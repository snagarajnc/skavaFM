package com.skava.testcases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.framework.reporting.Log;
import com.skava.reusable.components.TestComponents;


public class LT_766_Cart_PriceCheck  extends TestComponents {
	@BeforeClass
	public void initTest() throws IOException{		
		driver = initiTest(this.getClass().getSimpleName());	
		//driver = initiTest("Pdp");
		driver.setsize();
	}
	
	@Test
	public void LT_766_Cart_Price_Check() throws Exception {
		
		launchUrl();
		searchValidation();
		pLPValidation();

		//selectProductinPLP();
		selectProductinPLP();
		selectColour();
		selectSize();
		addToBag_PDP();
		//AddToBag_BUY();
		cartSuccess_OverLay("Checkout");
		isCartDisplayed();
		backToUSShipping();
		float product_price=productPriceCheck();
		Float actual=totalPriceCheck();
		cartQtyIncrement();
		Float expected=totalPriceCheck();
		priceCheck(actual,expected,product_price,"increment");
		actual=totalPriceCheck();
		cartQtyDecrement();
		expected=totalPriceCheck();
		priceCheck(actual,expected,product_price,"decrement");
		
		
		Log.startTestCase(this.getClass().getSimpleName());
	}
	
	@AfterClass
	public synchronized void tearDown(){		
		if (driver != null) {
			driver.quit();
		}
	}
}
