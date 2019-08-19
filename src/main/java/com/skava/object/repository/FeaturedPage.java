package com.skava.object.repository;

import org.openqa.selenium.By;

public class FeaturedPage {
	
	//PromoPage
	public static final By cntPromoPage = By.xpath("(//*[@class='genericESpot' or @id='skMob_productListContainer_id' or @id='saksContainer'])[1]");
	
	
	public static final By ADFrame = By.id("wishabi-google-tag-management");
	public static final By PrivayHeader = By.xpath("//*[@id=\'content-area\']/div/div[1]/div/h1");
	public static final By FAQHeader = By.xpath("//*[@id=\'content-area\']/div/div[1]/div/h1");
	public static final By NewsndInfoHeader = By.xpath("//*[@id=\'content-area\']/div/div[1]/div/h1");
	public static final By AboutUSHeader = By.id("mobile_header");
	public static final By ReturnHeader = By.xpath("//*[@id=\'content-area\']/div/div[1]/div/h1");
	public static final By ShippingHeader = By.xpath("//*[@id=\'content-area\']/div/div[1]/div/h1");
	public static final By ContactUsHeader = By.xpath("//*[@id=\'content-area\']/div/div[1]/div/h1");
	public static final By TrackOrderHeader = By.className("cls_skYourOrderTitle");
	public static final By CheckboxFAV = By.className("skMob_favCheckbox");
	public static final By txtNoprdFAV = By.className("skMob_noFavText");
	public static final By btnDeleteconfirmPRD = By.className("skBeallFavConfirmButtonCont");
	public static final By btnAddtoBagFAV = By.xpath("//*[@class=\'skMob_addToBagTemp\']/div[2]");
	public static final By btnRemovePRDFAV = By.className("skMob_favPdtsRemoveBtn");
	public static final By CouponsandDealsHeader = By.xpath("//*[@id=\'content-area\']/div/div[1]/div/h1");
	public static final By TodaysADLogo = By.className("header_font");
	public static final By TodaysADHeader = By.id("wishabi-merchant-header");
	public static final By FavouritesHeader = By.className("skMob_favTopContainer");
	public static final By PorductNameinFav = By.xpath("//*[@class='skMob_favPdtsDetailsCont']/div[1]");
	public static final By ProductinFAV = By.className("skMob_favPdtsCont");
	public static final By BeallsINCLnk = By.id("id_skBLSInc");
	public static final By PayBillLnk = By.id("id_skBLSPayBill");
	public static final By ApplyNowLnk = By.id("id_skBLSApplyNow");
	public static final By CarrerLnk = By.id("id_skBLSCareers");
	public static final By jobsorgLnk = By.id("id_skBLSRetailMeansJob");
	public static final By SocialResLnk = By.id("id_skBLSSocialRespStmt");
}
