package com.skava.testcases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.framework.reporting.Log;
import com.skava.reusable.components.TestComponents;

public class LT_677_Cart_Checkout_SignIN_Validation extends TestComponents{

	@BeforeClass
	public void initTest() throws IOException{		
		driver = initiTest(this.getClass().getSimpleName());		
		driver.setsize();
	}
	
	@Test
	public void LT_677_Cart_Checkout_SignIN_Validation() throws Exception {
		// Provide Log4j configuration settings		 
		//DOMConfigurator.configure("log4j.xml");		 
		//Log.startTestCase(this.getClass().getSimpleName());
		launchUrl();
		searchValidation();
		selectProductinPLP();
		selectColour();
		selectSize();
		addToBag_PDP();
		cartSuccess_OverLay("Checkout");
		isCartDisplayed();
		backToUSShipping();
		clickCheckoutbutton();
		/*isCartDisplayed();
		addedproductValidation();
		clickCheckoutbutton();*/
		checkoutLogin();
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
