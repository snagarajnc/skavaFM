package com.skava.testcases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.framework.reporting.Log;
import com.skava.reusable.components.TestComponents;


public class LT_377_SortSelectOneFilter extends TestComponents
{
	@BeforeClass
	public void initTest() throws IOException{		
		driver = initiTest(this.getClass().getSimpleName());	
		//driver = initiTest("Pdp");
		driver.setsize();
	}
	
	@Test
	public void LT_377_Sort_Select_One_Filter() throws Exception {
		
		launchUrl();
		searchValidation();
		pLPValidation();

		select_Sort();
		
		
		Log.startTestCase(this.getClass().getSimpleName());
	}
	
	@AfterClass
	public synchronized void tearDown(){		
		if (driver != null) {
			driver.quit();
		}
	}
}
