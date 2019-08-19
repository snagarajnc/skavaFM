package com.skava.reusable.components;

import com.framework.reporting.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
import com.skava.frameworkutils.ExcelReader;
import com.skava.object.repository.FeaturedPage;
import com.skava.object.repository.HomePage;
import com.skava.object.repository.StorePage;

public class FeaturedCompnents extends CartComponents{
	
	public void PromoValidation()
	{
		if(driver.isElementDisplayed(FeaturedPage.cntPromoPage, 30, "Promo Page"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Promo Page Opened Successfully");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Promo Page Not Opened Successfully");
	}

	public void generalStorePageValidation()
	{
		if(driver.clickElement(HomePage.FindStorebtn, "Find Store Cliked"))
			ExtentTestManager.getTest().log(LogStatus.INFO, "Store Button clicked");
		else
			ExtentTestManager.getTest().log(LogStatus.INFO, "In Find Store Page");
		if(driver.isElementDisplayed(StorePage.StoreDetailPage, 10, "Store Detail Page Loaded"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Store Detail Page Validated");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Store Detail Page Not Opened");
	}
	public void generalCouponsDealsValidation()
	{
		if(driver.clickElement(HomePage.Coupondealbtn, "Coupondeal Cliked"))
			ExtentTestManager.getTest().log(LogStatus.INFO, "Coupon deal clicked");
		else
			ExtentTestManager.getTest().log(LogStatus.INFO, "In Coupondeal Page");
		if(driver.isElementDisplayed(FeaturedPage.CouponsandDealsHeader, 20, "Coupons and Deals page opened"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Coupons and Deals Page Validated");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Coupons and Deals Page Not Opened");
	}
	public void todaysADvalidation()
	{
		driver.isElementDisplayed(HomePage.TodaysADbtn, 10, "TodaysAd");
		if(driver.clickElement(HomePage.TodaysADbtn, "TodaysAD Cliked"))
			ExtentTestManager.getTest().log(LogStatus.INFO, "TodaysAD clicked");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "TodaysAD Not clicked");
		//driver.changeFrame(FeaturedPage.ADFrame, "Switch Frame");
		if(driver.isElementDisplayed(FeaturedPage.TodaysADHeader, 20, "Todays AD Page Validated"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Todays AD Header Page Validated");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Todays AD Header Page Not Opened");
	}
	public void genearalFavoritesValidation()
	{
		if(driver.clickElement(HomePage.Favoritesbtn, "Favorites Cliked"))
			ExtentTestManager.getTest().log(LogStatus.INFO, "Favorites clicked");
		else
			ExtentTestManager.getTest().log(LogStatus.INFO, "In Favorites Page");
		if(driver.isElementDisplayed(FeaturedPage.FavouritesHeader, 20, "Favourites Page"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Favourites Page Opened");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Favourites Page Not Opened");
	}
	public String productInFavourites()
	{
		if(driver.isElementDisplayed(FeaturedPage.ProductinFAV, 10, "Product present in FAV"))
			ExtentTestManager.getTest().log(LogStatus.INFO, "Product present in FAV");
		String ProductNameINFav = driver.getText(FeaturedPage.PorductNameinFav, "Product Name in Fav");
		return ProductNameINFav;
	}
	public void beallsINCValidation()
	{
		driver.scrollToElement(HomePage.btnMoreBealls, "scrolling");
		if(driver.clickElement(FeaturedPage.BeallsINCLnk, "Bealls INC clicked"))
		{
			String URLDirected = driver.getBrowserURL("Browser URL");
			if(driver.compareStrings(URLDirected, ExcelReader.getData("More_Link_Validation","beallsinc"), "Comparison"))
				ExtentTestManager.getTest().log(LogStatus.PASS, "Bealls INC Diretced");
			else
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Bealls INC Not Diretced");
		}
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Bealls INC Not Clicked");
	}
	public void payBillValidation()
	{
		driver.scrollToElement(HomePage.btnMoreBealls, "scrolling");
		if(driver.clickElement(FeaturedPage.PayBillLnk, "Pay Bill clicked"))
		{
			String URLDirected = driver.getBrowserURL("Browser URL");
			if(driver.compareStrings(URLDirected, ExcelReader.getData("More_Link_Validation","PayBill"), "Comparison"))
				ExtentTestManager.getTest().log(LogStatus.PASS, "Pay Bill Diretced");
			else
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Pay Bill Not Diretced");
		}
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Pay Bill Not Clicked");
	}
	public void appyNWandSave()
	{
		driver.scrollToElement(HomePage.btnMoreBealls, "scrolling");
		if(driver.clickElement(FeaturedPage.ApplyNowLnk, "Apply Now and Save clicked"))
		{
			String URLDirected = driver.getBrowserURL("Browser URL");
			if(driver.compareStrings(URLDirected, ExcelReader.getData("More_Link_Validation","ApplyNow"), "Comparison"))
				ExtentTestManager.getTest().log(LogStatus.PASS, "Apply Now and Save Diretced");
			else
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Apply Now and Save Not Diretced");
		}
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Apply Now and Save Not Clicked");
	}
	public void careerValidation()
	{
		driver.scrollToElement(HomePage.btnMoreBealls, "scrolling");
		if(driver.clickElement(FeaturedPage.CarrerLnk, "Career clicked"))
		{
			String URLDirected = driver.getBrowserURL("Browser URL");
			if(driver.compareStrings(URLDirected, ExcelReader.getData("More_Link_Validation","Carrer"), "Comparison"))
				ExtentTestManager.getTest().log(LogStatus.PASS, "Career page Diretced");
			else
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Career page Not Diretced");
		}
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Career page Not Clicked");
	}
	public void retailJobsValidation()
	{
		driver.scrollToElement(HomePage.btnMoreBealls, "scrolling");
		if(driver.clickElement(FeaturedPage.jobsorgLnk, "RetailJobs clicked"))
		{
			String URLDirected = driver.getBrowserURL("Browser URL");
			if(driver.compareStrings(URLDirected, ExcelReader.getData("More_Link_Validation","jobsorg"), "Comparison"))
				ExtentTestManager.getTest().log(LogStatus.PASS, "RetailJobs Diretced");
			else
				ExtentTestManager.getTest().log(LogStatus.FAIL, "RetailJobs Not Diretced");
		}
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "RetailJobs Not Clicked");
	}
	public void socialPageValidation()
	{
		driver.scrollToElement(HomePage.btnMoreBealls, "scrolling");
		if(driver.clickElement(FeaturedPage.SocialResLnk, "SocialPage clicked"))
		{
			String URLDirected = driver.getBrowserURL("Browser URL");
			if(driver.compareStrings(URLDirected, ExcelReader.getData("More_Link_Validation","SocialRes"), "Comparison"))
				ExtentTestManager.getTest().log(LogStatus.PASS, "SocialPage Diretced");
			else
				ExtentTestManager.getTest().log(LogStatus.FAIL, "SocialPage Not Diretced");
		}
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "SocialPage Not Clicked");
	}
	public void removePRD_FAV()
	{
		if(driver.isElementDisplayed(FeaturedPage.ProductinFAV, 10, "Product in FAV"))
		{
			driver.clickElement(FeaturedPage.btnRemovePRDFAV, "Remove Product In FAV");
			driver.clickElement(FeaturedPage.btnDeleteconfirmPRD, "Delete Confirmation");
			if(driver.isElementDisplayed(FeaturedPage.txtNoprdFAV, 20, "Product Deleted"))
				ExtentTestManager.getTest().log(LogStatus.PASS, "Product Removed from FAV");
			else
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Product Not Removed from FAV");
		}
		else
			ExtentTestManager.getTest().log(LogStatus.INFO, "NO Product in FAV");
	}
	public void addtoBag_FAV()
	{
		if(driver.clickElement(FeaturedPage.btnAddtoBagFAV, "Add To Bag Clicked in FAV"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Add To Bag Clicked in FAV");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Add To Bag not Clickable in FAV");
	}
	public void trackOrderValidation()
	{
		driver.clickElement(HomePage.TrackOrderbtn, "Track Order Clicked");
		if(driver.isElementDisplayed(FeaturedPage.TrackOrderHeader, 20, "Track Order Page Clicked"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Track Order Page Opened");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Track Order Page not Opened");
	}
	public void contactUSValidation()
	{
		driver.clickElement(HomePage.ContactUsbtn, "Track Order Clicked");
		if(driver.isElementDisplayed(FeaturedPage.ContactUsHeader, 20, "Contact Us Header"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Contact Us Header Page Opened");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Contact Us Header Page not Opened");
	}
	public void shippingndDelivery()
	{
		driver.clickElement(HomePage.Shippingbtn, "Shipping Clicked");
		if(driver.isElementDisplayed(FeaturedPage.ShippingHeader, 20, "Shipping Header"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Shipping Page Opened");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Shipping Page not Opened");
	}
	public void returnExchangeValidation()
	{
		driver.clickElement(HomePage.ReturnExchangebtn, "Return and Exchange Clicked");
		if(driver.isElementDisplayed(FeaturedPage.ReturnHeader, 20, "Return and Exchange Header"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Return and Exchange Page Opened");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Return and Exchange Page not Opened");
	}
	public void aboutUsValidation()
	{
		driver.clickElement(HomePage.AboutUsbtn, "About Us Clicked");
		if(driver.isElementDisplayed(FeaturedPage.AboutUSHeader, 20, "About Us Header"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "About Us Page Opened");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "About Us Page not Opened");
	}
	public void newsndINFOValidation()
	{
		driver.clickElement(HomePage.NewsInformationbtn, "NewsInformation Clicked");
		if(driver.isElementDisplayed(FeaturedPage.NewsndInfoHeader, 20, "News Information Header"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "News Information Page Opened");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "News Information Page not Opened");
	}
	public void fAQValidation()
	{
		driver.clickElement(HomePage.FAQbtn, "FAQ Clicked");
		if(driver.isElementDisplayed(FeaturedPage.FAQHeader, 20, "FAQ Header"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "FAQ Opened");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "FAQ Page not Opened");
	}
	public void privacyValidation()
	{
		driver.clickElement(HomePage.PrivacySecuritybtn, "Privacy Security Clicked");
		if(driver.isElementDisplayed(FeaturedPage.PrivayHeader, 20, "Privacy Security Header"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Privacy Security Page Opened");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Privacy Security Page not Opened");
	}
}
