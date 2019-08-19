package com.framework.reporting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.net.ntp.TimeStamp;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.LogStatus;
import com.skava.framework.action.ActionEngine;
import com.skava.framework.action.ActionEngineFactory;
import com.skava.frameworkutils.Constants;
import com.skava.frameworkutils.ExcelReader;
import com.skava.frameworkutils.loggerUtils;

import java.nio.file.Paths;


import net.sf.json.JSONObject;

public class BaseClass {
	
	public ActionEngine driver;
	public static Properties properties = new Properties();
	public static String UserDir=Paths.get(".").toAbsolutePath().normalize().toString();
	String ConfigFilePath=Paths.get(".").toAbsolutePath().normalize().toString()+ "\\Resources\\Config.ini";
	static JSONObject json = new JSONObject();
	public static String currentRunReportPath;
	
	
	public static synchronized ActionEngine initiTest(String tcName) throws IOException {		
		return ActionEngineFactory.getActionEngine(BaseClass.getBrowser(tcName));
	}
	
	public void setDriver(ActionEngine driver) {
		this.driver = driver;
	}
	
	public static int getBrowser(String testCaseName) {
		String strBrowser=(String) json.getJSONArray(testCaseName).get(2);		
		switch (strBrowser) {
			case "Chrome" :
				return Constants.BROWSER_CHROME;
				
			case "Firefox" :
				return Constants.BROWSER_FIREFOX ;
			
			case "InternetExplorer":
				return Constants.BROWSER_IE;
			
			default :
				return Constants.BROWSER_CHROME;
			
		}
	}
	
	public static synchronized JSONObject initBatchExec() throws IOException {	
		
		Map<String, List> hashMap = new LinkedHashMap<String, List>();
		hashMap=ExcelReader.getBatchExecInfo(UserDir+properties.getProperty("TestRunnerPath"), properties.getProperty("RunConfigSheetName"));
		json.accumulateAll(hashMap);
		return json;
	}
	
	@BeforeSuite
	public void beforeSuite() throws IOException {
		
		//Load properties file		
		 File file = new File(ConfigFilePath);		  
		 FileInputStream fileInput = null;
			try {
				fileInput = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}				
			
			try {
				properties.load(fileInput);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//Read test runner file for test run configurations
			initBatchExec();
			
			//Setup reports path for current run 
			TimeStamp time=new TimeStamp(System.currentTimeMillis());	
			currentRunReportPath=UserDir+ properties.getProperty("ReportPath")+time;
			File files = new File(currentRunReportPath+"\\Screenshots");
			files.mkdirs();
			ExtentManager.filePath=currentRunReportPath+"\\Summary.html";
			ExtentManager.screenshotPath=currentRunReportPath+"\\Screenshots";	
			loggerUtils.setLogFile();
			
					
	}
	
	@BeforeMethod
    public void beforeMethod(Method method) {
		
        ExtentTestManager.startTest(method.getName());
    }
    
    @AfterMethod
    protected void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
        } else {
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
        }
        
        ExtentManager.getReporter().endTest(ExtentTestManager.getTest());        
        ExtentManager.getReporter().flush();
    }
    
    protected String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }
}
