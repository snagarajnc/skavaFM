package com.skava.testcases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.framework.reporting.Log;
import com.skava.reusable.components.TestComponents;

public class LT_730_SaveForLaterValidation extends TestComponents{

	@BeforeClass
	public void initTest() throws IOException{		
		driver = initiTest(this.getClass().getSimpleName());		
		driver.setsize();
	}
	
	@Test
	public void LT_730_SaveForLaterValidation() throws Exception {
		// Provide Log4j configuration settings		 
		//DOMConfigurator.configure("log4j.xml");		 
		//Log.startTestCase(this.getClass().getSimpleName());
		launchUrl();
		//clickMenuIcon();
		searchValidation();
	//	menuCategoryValidation();
		selectProductinPLP();
		selectColour();
		selectSize();
		addToBag_PDP();
		cartSuccess_OverLay("Checkout");
		addedproductValidation();
		String S1 = cartProductDetails();
		String S2 = saveforlater();
		System.out.println(S1);
		System.out.println(S2);
		compare(S1,S2);
		//ClickCheckoutbutton();
	//	CheckoutLogin();
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
