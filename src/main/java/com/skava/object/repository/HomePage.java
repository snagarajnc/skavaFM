package com.skava.object.repository;

import org.openqa.selenium.By;

public class HomePage {
	//Header
	public static final By Logo = By.id("logo_icon");
	public static final By btnPancake = By.id("sk_shop");
	public static final By btnSearch = By.id("search_icon");
	public static final By btnCart = By.id("bag_count");
	
	//Pancake
	public static final By ShowPancakeMask = By.id("sk_mobContainerMask_id");
	public static final By btnClosePancake = By.id("tabHeaderIcon");
	
	//Search
	//public static final By SearchSuggestion = By.xpath("//*[@class=\'suggestedItem-searchsuggestion\']/div[1]/div");
	public static final By SearchSuggestion = By.xpath("//*[@class='suggestedItem-searchsuggestion']//*[@class='suggestedItems']");
	public static final By searchSugContainer=By.xpath("//*[@class='suggestedItem-searchsuggestion']");
	//public static final By searchInputField = By.xpath("//*[@id='sk_mobSearchForm']");
	public static final By searchInputField = By.xpath("(//*[@class='sk_mobContentSearchInput'])[1]");
	
	//TopCategory
	public static final By CatMenu = By.xpath("//*[@class='sk_mobCategoryItem ']");
	public static final By CatMenuCheck = By.xpath("(//*[@class='sk_mobCategoryItem '])[1]");
	public static final By subCatMenu = By.xpath("(//*[@class='sk_mobSubCategory'][@style='display: block;']//*[@level='level_1'])[1]");
	public static final By subSubCatMenu = By.xpath("(//*[@id='sk_mobSublevel_1_1'][@style='display: block;']//*[@level='level_2'])[1]");

	
	
	
	public static final By topMenuCategoryNav = By.xpath("//*[@id='sk_mobCategory_id']/div[1]/div[1]/div[3]");
	public static final By CheckTopCategory = By.xpath("//*[@id='sk_mobCategory_id']/div[1]/div[1]");
	//public static final By TopSubCategoryNav = By.xpath("//*[@id='sk_mobCategory_id']/div[1]/div[2]/div[2]/a/div/div[4]");
	public static final By TopSubCategoryNav = By.xpath("(//*[@class='sk_mobCategoryItem sk_NEW ARRIVALS'])[1]");
	
			
	public static final By SubcategoryNav = By.xpath("(//*[@class='sk_mobCategoryItem sk_Shop All'])[1]");
	//public static final By SubcategoryNav = By.xpath("//*[@id='sk_mobCategory_id']/div[1]/div[2]/div[2]/div/div[1]/a/div/div[4]");
	public static final By SecTopCategoryNav = By.xpath("//*[@id='sk_mobCategory_id']/div[2]");
	public static final By btnBacktoTopCategory = By.xpath("//*[@class='sk_backBtn']");
	
	public static final By TopBrandcategory  = By.xpath("//*[contains(@class,'sk_mobCategoryItemCont sk_BRANDS')]");
	public static final By TopSubBrandCategory = By.xpath("//*[@class='sk_mobCategoryItem sk_BRANDS BY CATEGORY']");
	public static final By SubBrandCategory = By.xpath("//*[@class='sk_mobCategoryItem sk_BRANDS BY CATEGORY']//*[@class='sk_mobSubCategory']//*[@id='sk_mobCategoryItem_id_2_2']"); 
	public static final By brandNameList = By.xpath("//*[@class='sk_brandsLinksMainCont']//*[@class='sk_brandsLinksCont active']//*[@class='sk_brandsLink']"); 

	//Promolnk
	//public static final By lnkPromo = By.xpath("//*[@id='lntheaderpromoId']/div[1]/div[3]/div/a");
	public static final By lnkPromo = By.xpath("(//*[contains(@class,'swiper-slide-active') and contains(@class,'swiper-slide sk_hdr_prmBnrInnerCell swiper') ]//a)[1]");
	
	//promo
	public static final By promoLink=By.xpath("//*[@class='sk_promolink']/a");
	
	//Footer
	
	public static final By FooterContainer = By.xpath("//*[@class='tabFooter sktabFooterContainer']");
	public static final By CallEmailLink = By.xpath("//*[@class='sk_footerSubCont']//a");
	public static final By signUpForDailyEmails = By.xpath("//*[@class='sk_ftrSignUpBtn']");
	public static final By AccordionMenus = By.xpath("//*[@class='footer-menu-list']");
	public static final By SocialIcons = By.xpath("//*[@class='social-icons-wrapper']//li");
	public static final By signUpForSms = By.xpath("//*[@class='sk_signUpSms']//a");
	public static final By VisitFullSite = By.xpath("//*[@class='sk_fullsite']");
	public static final By copyRight = By.xpath("//*[@class='footer-cr-panel']//div");
	public static final By PrivacyPolicy = By.xpath("//*[@class='footer-cr-panel']//a");

	//RR
	
	public static final By RR1=By.xpath("(//*[@class='sk_rrScrollContainer'])[1]");
	public static final By RR2=By.xpath("(//*[@class='sk_rrScrollContainer'])[2]");
	public static final By RR_items=By.xpath("//*[@class='sk_rrTopContainer']");
	public static final By Rr_item_name=By.xpath("//*[@class='sk_rrprodname']");



	
	
	
	
	
	
	
	
	public static final By DealsRewardBanner = By.xpath("//*[@class=\'cls_skWrap\']/div");
	public static final By btnDesktopView = By.id("id_skBLSViewDsktpSite");
	public static final By MenuFooter = By.className("cls_skBLSPancakeFooter");
	public static final By CartMask = By.className("sk_BagShopNowBtnText");
	public static final By btnMoreBealls = By.id("id_skBLSMore");
	public static final By PresistentBanner = By.className("cls_skPersistentBannerCont");
	public static final By lnkMyAccount = By.id("my_account");
	public static final By btnStoresHeader = By.id("sk_favoritIconImg");
	public static final By CartIcon = By.id("sk_bagIconText");
	public static final By Menu = By.className("sk_menuIconText");
	public static final By RotationalBanner = By.xpath("//*[@class=\'ski_imageGalleryContainer\']/div[1]/div[1]/div[1]/div[2]/div[2]");
	public static final By Bannercheck = null;
	public static final By closeBanner = null;
	public static final By linkSignIn = null;
	public static final By AllCategory = By.id("id_panCakeBrowseMenu");
	public static final By MenuMask = By.id("sk_mobContainerMask_id");
	public static final By ShopTopCategory = By.className("sk_mobTopCategoryTitle");
	public static final By CategoryNav = By.className("sk_mobTopCategoryItemTxt");
	public static final By CategorySecNav = By.id("sk_mobTopSublevel_0");
	public static final By CarouselBanner = By.className("SKImageWrap");
	public static final By FirstCategory = By.xpath("//*[@id=\'sk_mobTopCategoryItemCont_id\']/div[2]");
	public static final By SecondCategoryfirstNav = By.xpath("//*[@id=\'sk_mobTopCategoryItemCont_id\']/div/div[2]/div");
	public static final By ShopallExpand = By.id("id_panCakeBrowseMenu");
	public static final By MenuCategory = By.className("sk_mobCategory");
	public static final By Nav = By.className("skMob_rightIcon");
	public static final By ShopAll = By.className("sk_mobPanCakeBrowseTxt");
	public static final By AccountSignbtn = By.id("id_skBLSAccSignIn");
	public static final By FindStorebtn = By.id("id_skBLSFindStore");
	public static final By Coupondealbtn =By.id("id_skBLSCouponDeals");
	public static final By TodaysADbtn = By.id("id_skBLSTodaysAd");
	public static final By Favoritesbtn = By.id("id_skBLSWishlist");
	public static final By TrackOrderbtn = By.id("id_skBLSTrackOrder");
	public static final By ContactUsbtn = By.id("id_skBLSContactUs");
	public static final By Shippingbtn = By.id("id_skBLSShipping");
	public static final By ReturnExchangebtn = By.id("id_skBLSReturnsExchanges");
	public static final By affiliatebtn = By.id("id_skBLSBecomeAffiliate");
	public static final By AboutUsbtn =By.id("id_skBLSAboutUs");
	public static final By NewsInformationbtn = By.id("id_skBLSNewsInformation");
	public static final By FAQbtn = By.id("id_skBLSFaq");
	public static final By BrandExclusionbtn = By.id("id_skBLSBrandExclusions");
	public static final By PrivacySecuritybtn = By.id("id_skBLSPrivacy");
	//public static final By SubCategoryMenuNav(St) = By.xpath("//*[@class=\'sk_mobCategory\']/div[\"+RandomTopCategory+\"]/div[2]/div");
	
	
}