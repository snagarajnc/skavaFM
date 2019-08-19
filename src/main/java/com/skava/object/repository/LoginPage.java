package com.skava.object.repository;

import org.openqa.selenium.By;

public class LoginPage {
	
	//CheckoutLogin
	
	public static final By CheckoutSignINOverlay = By.xpath("//*[@id='jsLoginWrap']");
	public static final By CheckoutSignINHeader = By.className("checkout-heading");
	public static final By txtEmailIdCheckout = By.id("loginEmail");
	public static final By txtPasswordCheckout = By.id("loginPass");
	public static final By btnLogInCheckout = By.id("jsQuickCheckout");
	

	
	public static final By SignINHeader = By.className("sign-into-account__title");
	public static final By txtEmailId = By.id("sign-into-account-email-field");
	public static final By txtPassword = By.id("sign-into-account-password-field");
	public static final By btnLogIn = By.xpath("//*[@id='account-content-area']/div/div[2]/div[1]/div/div[1]/section/form/div[4]/button");
	public static final By ForgetPasswordlnk = By.className("cls_sk_forgotpwdlink");
	public static final By lblSignInSuccess = By.className("sk_cls_personalinfo_hdr");
	public static final By loginPopUpClose = By.id("id_sk_tabMyAccountModelCloseIcon");
	public static final By CreateAccount = By.className("cls_skAcc");
	public static final By FirstNameField = By.id("register.firstName");
	public static final By SecondNameField = By.id("register.lastName");
	public static final By NewEmailID = By.id("register.email");
	public static final By NewPWDField = By.id("password");
	public static final By CreateAccountbtn = By.xpath("cls_skBlsALLink");
	public static final By CreateAccountSuccess = By.className("cls_skAccountDetails");
	public static final By btnSignOut = By.className("sk_cls_logout");
	public static final By btnMyAccount = By.className("sk_cls_manage_txt");
	public static final By AccountName = By.className("user-container");
	public static final By RewardsHeader = By.id("reward-history");
	public static final By btnbckMainpage = By.className("skMob_navBreadCrumb");
	
	public static final By accountname = By.className("account-header");
	public static final By accountsummary = By.xpath("//*[@id='account-content-area']/div/div[3]/ul/li[1]/a");
	public static final By orderhistory = By.xpath("//*[@id='account-content-area']/div/div[3]/ul/li[2]/a");
	public static final By shippingaddress = By.xpath("//*[@id='account-content-area']/div/div[3]/ul/li[3]/a");
	public static final By billingaddress = By.xpath("//*[@id='account-content-area']/div/div[3]/ul/li[4]/a");
	public static final By payment = By.xpath("//*[@id='account-content-area']/div/div[3]/ul/li[5]/a");
	public static final By settings = By.xpath("//*[@id='account-content-area']/div/div[3]/ul/li[6]/a");
	
	public static final By accountsummaryPage = By.className("account-summary");
	public static final By orderhistoryPage = By.className("order-history-page");
	public static final By settingsPage = By.className("account-settings");
	public static final By billingaddressPage = By.className("billing-address-book");
	public static final By shippingaddressPage = By.className("shipping-address-book");
	public static final By paymentPage = By.xpath("//*[@class='payment']");

	public static final By paypalLogo = By.xpath("//*[@id='paypalLogo']");
	
}