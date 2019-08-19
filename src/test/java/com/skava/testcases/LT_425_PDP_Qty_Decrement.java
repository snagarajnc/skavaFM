package com.skava.testcases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.framework.reporting.Log;
import com.skava.reusable.components.TestComponents;

public class LT_425_PDP_Qty_Decrement extends TestComponents {
	@BeforeClass
	public void initTest() throws IOException{		
		driver = initiTest(this.getClass().getSimpleName());	
		driver.setsize();
	}
	
	@Test
	public void LT_425_PDP_Qty_Decrement() throws Exception {
		
		launchUrl();
		searchValidation();
		selectProductinPLP();
		quantityIncrement();
		quantityDecrement();
		
		Log.startTestCase(this.getClass().getSimpleName());
	}
	
	@AfterClass
	public synchronized void tearDown(){		
		if (driver != null) {
			driver.quit();
		}
	}
}
