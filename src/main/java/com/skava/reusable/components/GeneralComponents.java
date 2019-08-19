package com.skava.reusable.components;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeSuite;

import com.framework.reporting.BaseClass;
import com.framework.reporting.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
import com.skava.framework.action.ActionEngine;
import com.skava.framework.action.ActionEngineFactory;
import com.skava.frameworkutils.Constants;
import com.skava.frameworkutils.ExcelReader;
//import com.skava.groovy.utils.MongoConnection;
import com.skava.object.repository.HomePage;
import com.skava.object.repository.LoginPage;

public class GeneralComponents extends BaseClass{
	
	
	public void launchUrl() {
		driver.setsize();
		driver.navigateToUrl(properties.getProperty("ApplicationUrl"));		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Navigated to application url");		
	}
	
	public static void verifyMongoValidation(){
	//	MongoConnection.test();
	}
	public void bannerclose()
	{
		if(driver.isElementDisplayed(HomePage.Bannercheck, 10, "POPUP"))
		{
			driver.clickElement(HomePage.closeBanner, "BannerClose");
		}
		else
			return;
	}
	public void clickMenuIcon()
	{
		if(driver.isElementDisplayed(HomePage.btnPancake, 50, "Wait to get site Loaded"))
		{
			driver.clickElement(HomePage.btnPancake, "Click Menu");
		}
	}
	public void closeMenu()
	{
		if(driver.ExecutorclickElement(HomePage.btnClosePancake, "Menu Closed"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Close Menu");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Close Menu Not Closed");
	}
	public void clickHeaderLogo()
	{
		driver.clickElement(HomePage.Logo, "Back To Homepage");
		ExtentTestManager.getTest().log(LogStatus.PASS, "MyAccount Validation Completed");
	}
	public void clickMyAccountIcon()
	{
		driver.clickElement(HomePage.lnkMyAccount, "Enetered Login");
	}
	public void clickPrivacyPolicy()
	{
		driver.clickElement(HomePage.ShopAll, "Shop All is Minimized");
		driver.scrollToElement(HomePage.PrivacySecuritybtn, "Scrolled to privacy");
		driver.clickElement(HomePage.PrivacySecuritybtn, "Privacy Policy Page");
	}
	public void clickFavouritesInMenu()
	{
		driver.clickElement(HomePage.ShopAll, "Shop All is Minimized");
		driver.scrollToElement(HomePage.Favoritesbtn, "Scrolled to privacy");
		driver.clickElement(HomePage.Favoritesbtn, "Privacy Policy Page");
	}
	public void clickStoresIcon()
	{
		driver.clickElement(HomePage.btnStoresHeader, "Click Store");
	}
	public void clickCartIcon()
	{
		driver.clickElement(HomePage.btnCart, "Click Cart");
	}
	public void clicksShopALL()
	{
		driver.clickElement(HomePage.ShopAll, "Click Shop ALL");
	}
	/*public void navigateBack()
	{
		driver.navigateDriverBack();
	}*/
	public void closeCartLayout()
	{
		driver.clickElement(HomePage.CartMask, "Cart Closed");
	}
	public void desktopViewValidation()
	{
		driver.scrollToElement(HomePage.btnDesktopView, "Scrolling");
		if(driver.ToWindowHandle(HomePage.btnDesktopView, properties.getProperty("CorrespondingClassicURL"), "Redirection Comparison"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Redirection to desktop site successfull");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Redirection to desktop site unsuccessfull");
	}
	public void clickLogin_Menu()
	{
		driver.clickElement(HomePage.AccountSignbtn, "Sign IN");
	}
}