package com.skava.testcases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.framework.reporting.Log;
import com.skava.reusable.components.TestComponents;

public class LT_1081_GuestCheckout_AddShipping  extends TestComponents {

	@BeforeClass
	public void initTest() throws IOException{		
		driver = initiTest(this.getClass().getSimpleName());	
		//driver = initiTest("Pdp");
		driver.setsize();
	}
	
	@Test
	public void LT_1081_GuestCheckout_Add_Shipping() throws Exception {
		
		launchUrl();
		searchValidation();
		selectProductinPLP();
		selectColour();
		selectSize();
		addToBag_PDP();
		pDPOverlay();
		cartSuccess_OverLay("Checkout");
		isCartDisplayed();
		backToUSShipping();
		clickCheckoutbutton();
		clickGuestCheckout();
		isShippingPageDisplayed();
		guest_EnterShippingAddrs("untickbill");
		continueCheckoutClick();
		addressVerification();
		//isBillingPageDisplayed();
		
		Log.startTestCase(this.getClass().getSimpleName());
	}
	
	@AfterClass
	public synchronized void tearDown(){		
		if (driver != null) {
			driver.quit();
		}
	}
}
