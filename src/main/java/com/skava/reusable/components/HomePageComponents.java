package com.skava.reusable.components;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.SendKeysAction;

import com.framework.reporting.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
import com.skava.frameworkutils.ExcelReader;
import com.skava.object.repository.*;

public class HomePageComponents extends HeaderComponents {

	public void categoryValidation(){
		
		driver.scrollToElement(HomePage.RotationalBanner, "Move to Category");
		int NumberOfCategory = driver.getsize(HomePage.FirstCategory, "Number Of Category");
		System.out.println(NumberOfCategory);
		driver.clickRandomElement(HomePage.FirstCategory, 0, "Clicked First Category");
		driver.clickRandomElement(HomePage.SecondCategoryfirstNav, 0, "Clicked Sub Category");
		driver.isElementDisplayed(FamilyPage.Header, 20, "Category Navigated");
		driver.isElementDisplayed(FamilyPage.PromoBanner, 10, "PromoValidated");
		//int NumberOfCategory = driver.getsize(HomePage.CategoryNav, "Nummber Of Category");
		//int RandomNumber = driver.generateRandomNumber(NumberOfCategory);
		//driver.scrollToRandomElement(HomePage.CategoryNav, RandomNumber, "Scrolled To Random Category");
		//driver.clickRandomElement(HomePage.CategoryNav, RandomNumber, "Clicked Random Category");
		//int NumOfSecondNavCategory = driver.getsize(HomePage.CategorySecNav, "Number Of Sub Category");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Category & Reward Navigation Validated");
	}
	public void topCategory_Back_Validation()
	{
		//driver.clickElement(HomePage.topMenuCategoryNav, "Clicked Main Category");
		if(driver.isElementDisplayed(HomePage.subCatMenu, 10, "Sub Categories Displayed"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Sub Categories Displayed and UnSelected Top Categories are Hidden");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Sub Categories not Displayed ");
			
		if(driver.isElementDisplayed(HomePage.btnBacktoTopCategory, 10, "Sub Categories Displayed"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Back Button Displayed");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Back Button Not Displayed");
	}
	public void navBrandCategory()
	{
		driver.clickElement(HomePage.TopBrandcategory, "Selecting Brand Category from pancake");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Brand category selected from pancake");
		driver.clickElement(HomePage.TopSubBrandCategory, "Selecting Brand Sub category");		
		int randomNo = driver.generateRandomNumber(driver.getsize(HomePage.SubBrandCategory, "Total Brand categories"));
		driver.clickRandomElement(HomePage.SubBrandCategory, randomNo, "Brand Category Clicked");
		
		if(driver.isElementDisplayed(ProductListPage.TopBrandsList, 30, "Brands page"))
		{
			ExtentTestManager.getTest().log(LogStatus.PASS, "Brands page Displayed");
		}
		else
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Brands page Not Displayed");
		}
	}
	
	public void selectBrand()
	{
		if(driver.isElementDisplayed(ProductListPage.TopBrandsList, 30, "Brands page"))
		{
			int randomNo = driver.generateRandomNumber(driver.getsize(HomePage.brandNameList, "Select A Brand"));
			driver.clickRandomElement(HomePage.brandNameList, randomNo, "Selected Brand Category Clicked");
			if(driver.isElementDisplayed(ProductListPage.plpPage, 20, "Brand PLP page"))
				ExtentTestManager.getTest().log(LogStatus.PASS, "Brand Selected and respective PLP displayed");
			else
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Brand Not Selected");
		}
		else
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Brands page Not Displayed");
		}
	}
	public void clickPromoLink()
	{
		if(driver.isElementDisplayed(HomePage.lnkPromo, 200, "search/PLP page"))
		{
			ExtentTestManager.getTest().log(LogStatus.PASS, "Search result page present");
			if(driver.clickElement(HomePage.lnkPromo, "Click Promo"))
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "Promo click success");
			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Promo click unsuccess");
			}
		}
		else
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Search result page not present");
		}
		
	}
	public void topCategory_Back_Nav_Validation()
	{
		driver.clickElement(HomePage.btnBacktoTopCategory, "Click Back Button");
		if(driver.compareStrings(driver.getElementAttribute(HomePage.SecTopCategoryNav, "style", "Get Attribute"), "block", "Comparison"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "On Clicking Back Top Category Nav's are Loaded successfully");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "On Clicking Back Top Category Nav's are Not Loaded successfully");
	}
	public void topCategoryValidation()
	{
		driver.clickElement(HomePage.topMenuCategoryNav, "Clicked Main Category");
		if(driver.compareStrings(driver.getElementAttribute(HomePage.CheckTopCategory, "class", "Get Attribute"), "sk_menuOpen", "Comparison"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Top Category Opened");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Top Category Not Opened");
		if(driver.isElementDisplayed(HomePage.TopSubCategoryNav, 20, "Sub Categories Displayed"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Top Sub Category Displayed");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Top Sub Category Not Displayed");
	}
	
	public void topCategoryValidation_1()
	{
		
		int randCat = driver.generateRandomNumber(driver.getsize(HomePage.CatMenu, "Total categories"));
		if(randCat == 10 || randCat == 9)
		{
			randCat = 1;
		}
		driver.isElementDisplayed(HomePage.CatMenuCheck, 10, "Menu Category");
		driver.scrollToRandomElement(HomePage.CatMenu, randCat, "Top Category scroll");
		driver.clickRandomElement(HomePage.CatMenu, randCat, "Top Category Clicked");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Top Category Clicked");
		if(driver.isElementDisplayed(HomePage.subCatMenu, 15 ,"SubCategory"))
		{
			ExtentTestManager.getTest().log(LogStatus.PASS, "Top Sub Category Displayed");
		}
		else
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Top Sub Category Not Displayed");
		}
	}
	
	public void menuCategoryValidation()
	{
		//int TopMenuCategorySize = driver.getsize(HomePage.topMenuCategoryNav, "Size of category in Menu");
		//int RandomTopCategory = driver.generateRandomNumber(TopMenuCategorySize);
		//driver.clickRandomElement(HomePage.topMenuCategoryNav, RandomTopCategory, "Selected Top Category");
		//int SubCategorySize = driver.getsize(HomePage.SubCategoryMenuNav, "Size of Sub Category");
		driver.explicitWaitforVisibility(ProductListPage.btnAddToBag, 5, "wait");
		driver.isElementDisplayed(HomePage.topMenuCategoryNav, 10, "wait");
		driver.scrollToElement(HomePage.topMenuCategoryNav, "Menu scroll");
		driver.clickElement(HomePage.topMenuCategoryNav, "Menu Clicked");
		
		driver.explicitWaitforVisibility(ProductListPage.btnAddToBag, 5, "wait");
		driver.isElementDisplayed(HomePage.TopSubCategoryNav, 10, "wait");
		driver.scrollToElement(HomePage.TopSubCategoryNav, "Menu sub scroll");
		driver.clickElement(HomePage.TopSubCategoryNav, "Sub Menu Clicked");
		
		driver.explicitWaitforVisibility(ProductListPage.btnAddToBag, 5, "wait");
		driver.isElementDisplayed(HomePage.SubcategoryNav, 10, "wait");
		driver.scrollToElement(HomePage.SubcategoryNav, "Menu sub cat scroll");
		driver.clickElement(HomePage.SubcategoryNav, "Sub Menu2 Clicked");
	}
	
	public void menuCategoryValidation_1() throws InterruptedException
	{
		int randCat = driver.generateRandomNumber(driver.getsize(HomePage.CatMenu, "Total categories"));
		if(randCat == 10 || randCat == 9)
		{
			randCat = 1;
		}
		driver.isElementDisplayed(HomePage.CatMenu, 10, "Menu Category");
		driver.clickRandomElement(HomePage.CatMenu, randCat, "Category Clicked");
		if(driver.isElementDisplayed(HomePage.subCatMenu, 15 ,"SubCategory"))
		{
			int randSubCat = driver.generateRandomNumber(driver.getsize(HomePage.subCatMenu, "Total Sub categories"));
			driver.clickRandomElement(HomePage.subCatMenu, randSubCat, "Sub Category Clicked");
			if(driver.isElementDisplayed(HomePage.subSubCatMenu, 15 ,"Sub Sub Category "))
			{
				int randSubSubCat = driver.generateRandomNumber(driver.getsize(HomePage.subSubCatMenu, "Total Sub Sub categories"));
				driver.clickRandomElement(HomePage.subSubCatMenu, randSubSubCat, "Sub Sub Category Clicked");
				if(driver.isElementDisplayed(ProductListPage.plpPage, 10, "PLP Page displayed"))
				{
					ExtentTestManager.getTest().log(LogStatus.INFO, "PLP Page displayed when selecting category");
				}
				else
				{
					driver.navigateDriverBack();
					searchValidation();
					
				}
			}
			else
			{
				if(driver.isElementDisplayed(ProductListPage.plpPage, 20, "PLP Page displayed"))
				{
					ExtentTestManager.getTest().log(LogStatus.INFO, "PLP Page displayed when selecting category");
				}
				else
				{
					driver.navigateDriverBack();
					searchValidation();
				}
			}		
		}	
		else
		{
			if(driver.isElementDisplayed(ProductListPage.plpPage, 20, "PLP Page displayed"))
			{
				ExtentTestManager.getTest().log(LogStatus.INFO, "PLP Page displayed when selecting category");
			}		
			else
			{
				driver.navigateDriverBack();
				searchValidation();
			}
		}	
	}
	
	
	public void searchSuggestionValidation() throws InterruptedException
	{
		driver.isElementDisplayed(ProductDetailPage.btnAddToBag, 10, "wait");
		driver.clickElement(HomePage.btnSearch, "Click Search");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Search keyword: "+ExcelReader.getData("General_Data", "SearchSuggestionString"));
		driver.enterText(HomePage.searchInputField, ExcelReader.getData("General_Data", "SearchSuggestionString"), "Search");
		//dri
		//driver.isElementDisplayed(ProductDetailPage.btnAddToBag, 20, "wait");
		Thread.sleep(5000);
		if(driver.isElementDisplayed(HomePage.searchSugContainer, 30, "Search Suggesion Displayed"))
		{
			ExtentTestManager.getTest().log(LogStatus.PASS, "Search suggestion displayed");
		}
		else
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Search suggestion not displayed");
		}
		/*driver.clickElement(HomePage.SearchSuggestion, "Click Suggestion");
		if(driver.compareElementText(SearchPage.SearchResultName, ExcelReader.getData("General_Data", "SearchSuggestionResult"), "Search Keyword Comparision"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Search Keyword Matched");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Search Keyword UnMatched");
		driver.isElementDisplayed(SearchPage.SearchprdCount, 10, "Search Count");*/
	}
	
	public void searchSuggestionSelection() throws InterruptedException
	{
		if(driver.isElementDisplayed(HomePage.searchSugContainer, 30, "Search Suggesion Displayed"))
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "Search suggestion displayed");
			int randomNo = driver.generateRandomNumber(driver.getsize(HomePage.SearchSuggestion, "Search suggestion"));
			driver.clickRandomElement(HomePage.SearchSuggestion, randomNo, "Search suggestion Clicked");
			//driver.isElementDisplayed(ProductDetailPage.btnAddToBag, 10, "wait");
			Thread.sleep(5000);
			driver.explicitWaitforVisibility(ProductListPage.plpPage, 30, "PLP page");
			if(driver.isElementDisplayed(ProductListPage.plpPage, 50, "PLP page"))
				ExtentTestManager.getTest().log(LogStatus.PASS, "Selecting the suggestion it navigates to Search Results Page");
			else
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Selecting the suggestion not navigates to Search Results Page");
		}
		else
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Search suggestion not displayed");
		}
	}
	public void searchValidation() throws InterruptedException
	{
		driver.ExecutorclickElement(HomePage.btnSearch, "Click Search");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Search Keyword: "+ExcelReader.getData("General_Data", "SearchString"));
		
/*		System.out.println(ExcelReader.getData("General_Data", "SearchString"));
		String value=ExcelReader.getData("General_Data", "SearchString");
		//driver.ExecutorclickElement(buttonField, elementName)
		driver.clickElement(HomePage.searchInputField, "aa");
		
		driver.enterText(HomePage.searchInputField, value, "aaaa");
		driver.enterTextAndSubmit(HomePage.searchInputField, value, "search");*/
		driver.enterTextAndSubmit(HomePage.searchInputField, ExcelReader.getData("General_Data", "SearchString"), "Search");
	//	driver.isElementDisplayed(ProductDetailPage.btnAddToBag, 10, "wait");
		Thread.sleep(5000);
		if(driver.isElementDisplayed(ProductListPage.plpPage, 30, "search/PLP page"))
		{
			ExtentTestManager.getTest().log(LogStatus.PASS, "Search result page present");
		}
		else
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Search result page not present");
		}
		/*if(driver.compareElementText(SearchPage.SearchResultName, ExcelReader.getData("General_Data", "SearchResult"), "Search Keyword Comparision"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Search Keyword Matched");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Search Keyword UnMatched");*/
		driver.isElementDisplayed(SearchPage.SearchprdCount, 10, "Search Count");
	}
	public void presistentBanner_HP()
	{
		if(driver.isElementDisplayed(HomePage.PresistentBanner, 10, "Banner In HomePage"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Presistent Banner Found in HomePage");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Presistent Banner Not Found in HomePage");
	}
	public void clickMore()
	{
		driver.scrollToElement(HomePage.btnMoreBealls, "Scrolling");
		if(driver.clickElement(HomePage.btnMoreBealls, "More Clicked"));
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "More Button Not Clickable");
	}
	public void dealsNDrewardsBanner()
	{
		if(driver.isElementDisplayed(HomePage.DealsRewardBanner, 10, "Banner Check"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Deals And Reward Banner Found in HomePage");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Deals And Reward Banner Not Found in HomePage");
	}
	public void rotatingBanner()
	{
		driver.scrollToElement(HomePage.DealsRewardBanner, "Scrolling");
		if(driver.isElementDisplayed(HomePage.RotationalBanner, 20, " Rotational Banner Check"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Rotational Banner Found in HomePage");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Rotational Banner Not Found in HomePage");
	}
	public void carouselBanner()
	{
		driver.scrollToElement(HomePage.CarouselBanner, "Scrolling");
		if(driver.isElementDisplayed(HomePage.CarouselBanner, 10, "Carousel Banner Check"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Carousel Banner Found in HomePage");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Carousel Banner Not Found in HomePage");
	}
	
	public void footerContainer()
	{
		if(driver.isElementDisplayed(HomePage.FooterContainer, 10, "Footer Container"))
		{
			driver.scrollToElement(HomePage.FooterContainer, "Scroll to Footer");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Footer Container in HomePage");
			if(driver.isElementDisplayed(HomePage.CallEmailLink, 10, "Call & Email Link"))
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "Call & Email Link in Footer");			
			}
			else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Call & Email Link  not in Footer");
			if(driver.isElementDisplayed(HomePage.signUpForDailyEmails, 10, "signUpForDailyEmails"))
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "signUpForDailyEmails button in Footer");			
			}
			else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "signUpForDailyEmails button  not in Footer");
			if(driver.isElementDisplayed(HomePage.SocialIcons, 10, "Social Share Icons"))
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "Social Share Icons in Footer");				
			}
			else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Social Share Icons  not in Footer");
			if(driver.isElementDisplayed(HomePage.AccordionMenus, 10, "Accordion Menus"))
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "AccordionMenus in Footer");				
			}
			else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "AccordionMenus not in Footer");
			if(driver.isElementDisplayed(HomePage.signUpForSms, 10, "SignUpForSms"))
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "SignUpForSms in Footer");				
			}
			else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "SignUpForSms not in Footer");
			if(driver.isElementDisplayed(HomePage.copyRight, 10, "copyRight"))
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "copyRight in Footer");				
			}
			else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "copyRight not in Footer");
			if(driver.isElementDisplayed(HomePage.PrivacyPolicy, 10, "PrivacyPolicy"))
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "PrivacyPolicy in Footer");				
			}
			else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "PrivacyPolicy not in Footer");			
			
		}
		else
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Footer Container not in HomePage");
		
	}
	
	public String richRelevanceHome()
	{
		if(driver.isElementDisplayed(HomePage.RR1, 10, "Carousel Banner Check") && driver.isElementDisplayed(HomePage.RR2, 10, "Carousel Banner Check"))
		{
			ExtentTestManager.getTest().log(LogStatus.PASS, "RR 1 Found in HomePage");
			int randomNo = driver.generateRandomNumber(driver.getsize(HomePage.RR_items, "Total size of RR"));
			
			driver.scrollToRandomElement(HomePage.RR_items, randomNo, "Click on random rr item");
			String item_name=driver.getTextRandom(HomePage.Rr_item_name, randomNo,"Get RR product name");
			if(driver.clickRandomElement(HomePage.RR_items, randomNo, "Click on random rr item"))
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "RR item successfull");
				return item_name.replaceAll(" ", "");
			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "RR item unsuccessfull");
				return "empty";
			}
		}
		else
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "RR not Found in HomePage");
			return "empty";
		}
	
	}
	
	
}
