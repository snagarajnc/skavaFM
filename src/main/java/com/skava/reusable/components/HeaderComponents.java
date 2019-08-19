package com.skava.reusable.components;

import com.framework.reporting.BaseClass;
import com.framework.reporting.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
import com.skava.frameworkutils.ExcelReader;
import com.skava.object.repository.HomePage;
import com.skava.object.repository.LoginPage;
import com.skava.object.repository.SearchPage;
import com.skava.object.repository.ShoppingBag;
import com.skava.object.repository.StorePage;

public class HeaderComponents extends LoginComponents {
	
	public void navigateToSignInPage() {
		driver.clickElement(HomePage.linkSignIn,"SignInLink");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Navigate to signin page");
	}
	
	public void enterSearchString() {
		ExtentTestManager.getTest().log(LogStatus.INFO, "Search Keyword: "+ExcelReader.getData("General_Data","SearchString"));
		driver.enterTextAndSubmit(HomePage.searchInputField, ExcelReader.getData("General_Data","SearchString"),"searchField");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Search product");
	}
	
	public void menuValidation()
	{
		String ShopAll = driver.getElementAttribute(HomePage.ShowPancakeMask, "class", "Pancake Opened");
		if(driver.compareStrings(ShopAll, "showPanCakeMask", "Comparison"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Pancake Opened");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Pancake Not Opened");
	}
	
	public void cartValidation()
	{
		if(driver.isElementDisplayed(ShoppingBag.CartHeader, 10, "Cart wrapper Opened"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Cart Page");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Cart Page not opened");
		if(driver.isElementDisplayed(ShoppingBag.CartEmptytxt, 5, "Cart Empty Text"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Empty Text Displayed in Cart");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Empty Text not Displayed in Cart");
		/*if(driver.isElementDisplayed(ShoppingBag.ContinueShoppingbtn, 5, "Continue Shopping"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Continue Shopping Displayed in Cart");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Continue Shopping not Displayed in Cart");*/
		if(driver.clickElement(ShoppingBag.btnCartHeaderLogo, "Back To Homepage"))
			ExtentTestManager.getTest().log(LogStatus.INFO, "Homepage directed");
	}
}
