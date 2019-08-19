package com.skava.framework.action;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.skava.frameworkutils.Constants;
import com.skava.frameworkutils.loggerUtils;
import com.skava.object.repository.HomePage;
import com.framework.reporting.*;

public class SeleniumActionEngine implements ActionEngine {

	private WebDriver driver;

	public SeleniumActionEngine(int browserType) {

		init(browserType);
	}

	private void init(int browserType) {
		switch (browserType) {
			case Constants.BROWSER_FIREFOX:
				this.driver = new FirefoxDriver();
			break;

			case Constants.BROWSER_CHROME:
				System.setProperty("webdriver.chrome.driver", BaseClass.UserDir+BaseClass.properties.getProperty("DriversPath")+"chromedriver.exe");
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				ChromeOptions options=new ChromeOptions();				
				options.addArguments("--user-agent=Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1");
				options.addArguments("--user-agent=Mozilla/5.0 (Linux; Android 6.0; HTC One M9 Build/MRA58K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.98 Mobile Safari/537.36");
				options.addArguments("disable-infobars");
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				this.driver = new ChromeDriver(capabilities);
			break;

			case Constants.BROWSER_IE:
				this.driver = new InternetExplorerDriver();
			break;
			default:
				//throw new InvalidBrowserTypeException();
			break;
		}
	}


	@Override
	public boolean enterText(By textField, String textValue,String elementName)
	{
		Boolean valid = false;
		 try
		 {
			Boolean visibility = explicitWaitforVisibility(textField,10,elementName);
			if( visibility && !textValue.equals(""))
			{
				WebElement element = this.driver.findElement(textField);
				element.clear();
				element.sendKeys(textValue);
				valid = true;
				loggerUtils.passLog(elementName+" is entered in the field");
			}
		 }
		 catch(Exception e)
		 {
			 loggerUtils.stackTracePrint(e);
			 loggerUtils.failLog(elementName+"is not present");
			 takeScreenShot(elementName);
		 }
		 return valid;
	}

	@Override
	public boolean clickElement(By buttonField,String elementName)
	{
		Boolean valid = false;
		try
		{
			if(explicitWaitforVisibility(buttonField,20,elementName))
			{
				WebElement element = this.driver.findElement(buttonField);
				element.click();
				valid = true;
				loggerUtils.passLog(elementName+" is clicked");
			}
		}
		catch(Exception e)
		{
			loggerUtils.stackTracePrint(e);
			loggerUtils.failLog(elementName+"is not present");
			takeScreenShot(elementName);
		}
		return valid;
	}
	@Override
	public boolean ExecutorclickElement(By buttonField,String elementName)
	{
		Boolean valid = false;
		try
		{
			if(explicitWaitforVisibility(buttonField,10,elementName))
			{
				WebElement element = this.driver.findElement(buttonField);
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", element);
				//element.click();
				valid = true;
				loggerUtils.passLog(elementName+" is clicked");
			}
		}
		catch(Exception e)
		{
			loggerUtils.stackTracePrint(e);
			loggerUtils.failLog(elementName+"is not present");
			takeScreenShot(elementName);
		}
		return valid;
	}
	@Override
	public boolean isElementPresent(By path,String elementName)
	{
		return !this.driver.findElements(path).isEmpty();
	}

	@Override
	public boolean compareElementText(By path,String expectedText,String elementName)
	{
		Boolean valid = false;
			try
			{
				if(explicitWaitforVisibility(path,10,elementName))
				{
					String currentText = getText(path, elementName);
					expectedText=Jsoup.parse(expectedText).text();
					if(currentText.equals(expectedText))
					{
						loggerUtils.passLog(elementName+" is verified");
						valid = true;
					}
					else
					{
						//Logging
						loggerUtils.failLog(elementName+" is mismatched");
					}
				}
			}
			catch(Exception e)
			{
				loggerUtils.stackTracePrint(e);
				loggerUtils.failLog(elementName+" is not present");
				takeScreenShot(elementName);
			}
			return valid;
	}

	@Override
	public boolean explicitWaitforVisibility(By path,int seconds,String elementName)
	{
			try
			{
				WebDriverWait wait = new WebDriverWait(this.driver,seconds);
				wait.until(ExpectedConditions.visibilityOfElementLocated(path));
				return true;
			}
			catch(Exception e)
			{
				loggerUtils.stackTracePrint(e);
				loggerUtils.failLog(elementName+" is not present");
				takeScreenshotWithPath("C:/seleniumScriptErrors/",elementName);
				return false;
			}
	}

	@Override
	public boolean isElementDisplayed(By path,int seconds,String elementName)
	{
		Boolean valid = false;
			try
			{
				if(explicitWaitforVisibility(path,seconds,elementName))
				{
					WebElement element = this.driver.findElement(path);
					valid = element.isDisplayed();
					if(valid)
						loggerUtils.passLog(elementName+" is displayed");
					else
						loggerUtils.failLog(elementName+" is not displayed");
				}
			}
			catch(Exception e)
			{
				loggerUtils.stackTracePrint(e);
				loggerUtils.failLog(elementName+" is not present");
				takeScreenShot(elementName);
			}
			return valid;
	}
	@Override
	public boolean isElementDisplayedByRandom(By path, int seconds, int RandomValue, String elementName)
	{
		Boolean valid = false;
		try
		{
			if(explicitWaitforVisibility(path,seconds,elementName))
			{
				WebElement element = this.driver.findElements(path).get(RandomValue);
				valid = element.isDisplayed();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			takeScreenShot(elementName);
		}
		return valid;
	}
	@Override
	public boolean isElementNotDisplayed(By path,String elementName)
	{
		Boolean valid = true;
		try
		{
			if(explicitWaitforVisibility(path,10,elementName))
			{
				WebElement element = this.driver.findElement(path);
				valid = element.isDisplayed();
				if(!valid)
					loggerUtils.passLog(elementName+" is not displayed");
				else
					loggerUtils.failLog(elementName+" is displayed");
			}
		}
		catch(Exception e)
		{
			loggerUtils.stackTracePrint(e);
			loggerUtils.failLog(elementName+" is not present");
			takeScreenShot(elementName);
		}
		return valid;
	}

	@Override
	public boolean isElementEnabled(By path,String elementName)
	{
		Boolean valid = false;
		try
		{
			if(explicitWaitforVisibility(path,10,elementName))
			{
				WebElement element = this.driver.findElement(path);
				valid = element.isEnabled();
				if(valid)
					loggerUtils.passLog(elementName+" is enabled");
				else
					loggerUtils.failLog(elementName+" is not enabled");
			}
		}
		catch (Exception e)
		{
			loggerUtils.stackTracePrint(e);
			loggerUtils.failLog(elementName+" is not present");
			takeScreenShot(elementName);
		}
		return valid;
	}

	@Override
	public String getText(By path,String elementName)
	{
		String text = "";
			try
			{
				if(explicitWaitforVisibility(path,10,elementName))
				{
					WebElement element = this.driver.findElement(path);
					text = element.getText();
				}
			}
			catch(Exception e)
			{
				loggerUtils.stackTracePrint(e);
				loggerUtils.failLog(elementName+" is not present");
				takeScreenShot(elementName);
			}
			return text;
	}
	@Override
	public String getTextRandom(By path, int RandomValue, String elementName)
	{
		String text = "";
		try
		{
			if(explicitWaitforVisibility(path,20,elementName))
			{
				WebElement element = this.driver.findElements(path).get(RandomValue);
				text = element.getText();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			takeScreenShot(elementName);
		}
		return text;
	}
	@Override
	public String getElementAttribute(By path,String attrName,String elementName)
	{
		String text = "";
			try
			{
				if(explicitWaitforVisibility(path,10,elementName))
				{
					WebElement element = this.driver.findElement(path);
					text = element.getAttribute(attrName);
				}
			}
			catch(Exception e)
			{
				loggerUtils.stackTracePrint(e);
				loggerUtils.failLog(elementName+" is not present");
				takeScreenShot(elementName);
			}
			return text;
	}

	@Override
	public boolean compareElementAttribute(By path,String attrName,String expectedText,String elementName)
	{
		Boolean valid = false;
			try
			{
				if(explicitWaitforVisibility(path,10,elementName))
				{
					WebElement element = this.driver.findElement(path);
					if(element.getAttribute(attrName).equals(expectedText))
					{
						valid = true;
						loggerUtils.passLog(elementName+" is verified");
					}
					else
					{
						//Logging
						loggerUtils.failLog(elementName+" is mismatched");
					}
				}
			}
			catch(Exception e)
			{
				loggerUtils.stackTracePrint(e);
				loggerUtils.failLog(elementName+" is not present");
				takeScreenShot(elementName);
			}
		return valid;
	}

	@Override
    public void takeScreenShot(String elementName)
    {
      try
      {
    	  DateFormat dateFormat = new SimpleDateFormat("h_m_s");
		  Date date = new Date();
    	  TakesScreenshot scrShot =((TakesScreenshot)this.driver);
    	  File sourceFile=scrShot.getScreenshotAs(OutputType.FILE);
    	  FileUtils.copyFile(sourceFile,new File("C:/seleniumScriptErrors/"+elementName+"_"+dateFormat.format(date)+".png"));
      }
      catch (Exception e)
      {
    	  loggerUtils.stackTracePrint(e);
      }
    }

	@Override
    public void takeScreenshotWithPath(String path,String elementName)
    {
      try
      {
    	  DateFormat dateFormat = new SimpleDateFormat("h_m_s");
		  Date date = new Date();
    	  TakesScreenshot scrShot =((TakesScreenshot)this.driver);
    	  File sourceFile=scrShot.getScreenshotAs(OutputType.FILE);
    	  FileUtils.copyFile(sourceFile,new File(path+elementName+"_"+dateFormat.format(date)+".png"));
      }
      catch (Exception e)
      {
    	  loggerUtils.stackTracePrint(e);
      }
    }


	@Override
	public int generateRandomNumber(int limit)
	{
		Random rand = new Random();
		return rand.nextInt(limit);
	}

	@Override
	public int generateRandomNumberWithLimit(int maximum,int minimum)
	{
		Random rand = new Random();
		return rand.nextInt(maximum) + minimum;
	}

	@Override
	public boolean scrollToElement(By path,String elementName)
	{
		Boolean valid = false;
		try
		{
			if(explicitWaitforVisibility(path,10,elementName))
			{
				WebElement element = this.driver.findElement(path);
				((JavascriptExecutor) this.driver).executeScript("arguments[0].scrollIntoView();", element);
				valid = true;
				loggerUtils.passLog("scrolled to "+elementName);
			}
		}
		catch(Exception e)
		{
			loggerUtils.stackTracePrint(e);
			loggerUtils.failLog(elementName+" is not present");
			takeScreenShot(elementName);
			valid = false;
		}
		return valid;
	}

	@Override
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	@Override
	public void navigateToUrl(String url) {
		driver.get(url);
		loggerUtils.passLog(url+" is opened");
	}
	@Override
	public boolean enterTextAndSubmit(By path,String value,String elementName)
	{
		 boolean valid=false;
		 try
		 {
			 if(explicitWaitforVisibility(path,10,elementName) && !value.equals(""))
			 {
				 WebElement element = driver.findElement(path);
				 element.clear();
				 element.sendKeys(value);
				 element.sendKeys(Keys.ENTER);
				 valid = true;
				 loggerUtils.passLog(value+" is entered in "+elementName);
			 }
		 }
		 catch(Exception e)
		 {
			 loggerUtils.stackTracePrint(e);
			 loggerUtils.failLog(elementName+"is not present");
			 takeScreenShot(elementName);
		 }
		return valid;
	}

	@Override
	public Object findElement(By txtusername) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getsize(By path, String elementName)
	{
		int Value;
		Value = driver.findElements(path).size();
		return Value;		
	}
	@Override
	public boolean clickRandomElement(By path, int RandomValue, String elementName)
	{
		Boolean valid = false;
		try
		{
			if(explicitWaitforVisibility(path,20,elementName))
			{
				this.driver.findElements(path).get(RandomValue).click();
				valid=true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			takeScreenShot(elementName);
			valid = false;
		}
		return valid;
		
	}
	@Override
	public boolean scrollToRandomElement(By path, int RandomValue, String elementName)
	{
		Boolean valid = false;
		try
		{
			if(explicitWaitforVisibility(path,20,elementName))
			{
				WebElement element = this.driver.findElements(path).get(RandomValue);
				((JavascriptExecutor) this.driver).executeScript("arguments[0].scrollIntoView();", element);
				valid = true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			takeScreenShot(elementName);
			valid = false;
		}
		return valid;
	}
	@Override
	public String GetTextByRandom(By path, int RandomValue, String elementName)
	{
		String text = "";
		try
		{
			if(explicitWaitforVisibility(path,20,elementName))
			{
				WebElement element = this.driver.findElements(path).get(RandomValue);
				text = element.getText();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			takeScreenShot(elementName);
		}
		return text;
		
	}
	@Override
	public boolean SelectDropDown(By path, int Value, String elementName)
	{
		boolean index = false;
		try
		{
			if(explicitWaitforVisibility(path,20,elementName))
			{
				WebElement element = this.driver.findElement(path);
				Select Option = new Select(element);
				Option.selectByIndex(Value);
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			takeScreenShot(elementName);
		}
		return false;
		
	}
	@Override
	public boolean compareStrings(String toCompare, String toCompareWith, String elementName)
	{
		Boolean valid = false;
		try
		{
		
				if(toCompare.trim().contains(toCompareWith.trim()))
				{	
					valid = true;
				}
				else
				{
					//Logging
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			takeScreenShot(elementName);
		}
	return valid;
	}
	@Override
	public String getStringInBetween(String text, String textFrom, String textTo, String elementName) 
	{
		String result = "";
		try
		{
			result = text.substring(text.indexOf(textFrom) + textFrom.length(), text.length());
			result = result.substring(0, result.indexOf(textTo));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			takeScreenShot(elementName);
		}
	return result;
	}
	@Override
	public String getBrowserURL(String elementName)
	{
		String text = "";
		try
		{
			text = driver.getCurrentUrl();
			return text;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			takeScreenShot(elementName);
			return text;
		}
		
	}
	public void navigateDriverBack()
	{
		driver.navigate().back();
	}
	@Override
	public boolean changeFrame(By path, String elementName) 
    {
            boolean valid=false;
            explicitWaitforVisibility(path,20,elementName);
             try
             {
                     WebElement element = driver.findElement(path);
                     driver.switchTo().frame(element);
                     valid = true; 
                     System.out.println("Switched to iframe");
             }
             catch(Exception e)
             {
                     e.printStackTrace();
             }
            System.out.println(valid);              
            return valid;
    }
	@Override
	public boolean  ToWindowHandle(By path ,String WindowTitle, String elementName)
	{
		boolean Value = false;
		try
		{
			String parentHandle = driver.getWindowHandle();
			driver.findElement(path).click();
			Thread.sleep(10000);
			System.out.println("function");
			for (String winHandle : driver.getWindowHandles())
			{
				driver.switchTo().window(winHandle);
			}
			if(driver.getCurrentUrl().contains(WindowTitle))
			{
				return true;
			}
			driver.close();
			driver.switchTo().window(parentHandle);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return Value;
	}
	@Override
	public void setsize()
	{
		driver.manage().window().setSize(new Dimension(400,900));
	}
	@Override
	public void quit() {
		// TODO Auto-generated method stub
		driver.close();
	}

}
