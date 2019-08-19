package com.skava.testcases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.framework.reporting.Log;
import com.skava.reusable.components.TestComponents;

public class LT_1040_Returning_Customer_Valid_SignIN_Validation extends TestComponents{

	@BeforeClass
	public void initTest() throws IOException{		
		driver = initiTest(this.getClass().getSimpleName());		
		driver.setsize();
	}
	
	@Test
	public void LT_1040_Returning_Customer_Valid_SignIN_Validation() throws Exception {
		// Provide Log4j configuration settings		 
		//DOMConfigurator.configure("log4j.xml");		 
		//Log.startTestCase(this.getClass().getSimpleName());
		launchUrl();
		clickMenuIcon();
		clickMyAccountIcon();
		enterLoginCredentials();
		myaccount();
		clickCartIcon();
		addedproductValidation();
		backToUSShipping();
		clickCheckoutbutton();
		reviewOrderValidation();
		
		/*MenuCategoryValidation();
		SelectProductinPLP();
		SelectColour();
		SelectSize();
		AddToBag_PDP();
		CartSuccess_OverLay("Checkout");
		AddedproductValidation();
		BackToUSShipping();
		ClickCheckoutbutton();
		enterLoginCredentials_Checkout();
		ReviewOrderValidation();*/
		//navigateToSignInPage();
		//enterLoginCredentials();
		//verifyLoginSuccessful();
		//closeLoginPopUp();
		//enterSearchString();
		Log.startTestCase(this.getClass().getSimpleName());
	}
	
	@AfterClass
	public synchronized void tearDown(){		
		if (driver != null) {
			driver.quit();
		}
	}
}
