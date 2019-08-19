package com.skava.testcases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.framework.reporting.Log;
import com.skava.reusable.components.TestComponents;

public class LT_464_BagCount_Check extends TestComponents {
	@BeforeClass
	public void initTest() throws IOException{		
		driver = initiTest(this.getClass().getSimpleName());	
		//driver = initiTest("Pdp");
		driver.setsize();
	}
	
	@Test
	public void LT_464_Bag_Count_Check() throws Exception {
		
		launchUrl();
		searchValidation();
		pLPValidation();
		//selectProductinPLP();
		selectProductinPLP();
		int actual=bag_CountCheck();
		selectColour();
		selectSize();
		addToBag_PDP();
		pDPOverlay();
		int expected=bag_CountCheck();
		bagCount_Validation(actual,expected);
		
		
		Log.startTestCase(this.getClass().getSimpleName());
	}
	
	@AfterClass
	public synchronized void tearDown(){		
		if (driver != null) {
			driver.quit();
		}
	}
}
