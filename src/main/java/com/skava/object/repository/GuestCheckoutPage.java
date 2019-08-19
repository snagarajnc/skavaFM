package com.skava.object.repository;

import org.openqa.selenium.By;

public class GuestCheckoutPage {
	public static final By btncontinueconfirm = By.className("cls_skContinueOrderBtn");
	public static final By PaymentIframe = By.id("id_skRedIframe");
	public static final By btnVerifyCard = By.id("NEXT_BUTTON");
	public static final By txtSecurityField = By.id("payCCV");
	public static final By DDYearField = By.xpath("//*[@id=\'ccYear\']/option");
	public static final By DDMonthField = By.xpath("//*[@id=\'ccMonth\']/option");
	public static final By txtCCNUMField = By.id("payCCNum");
	public static final By txtCCNameField = By.id("payCCName");
	public static final By DDCCTypeField = By.xpath("//*[@id='payCC']/option");
	
	public static final By PaymentField = By.className("cls_skPaymentMethodCont");
	//public static final By btnUseAsEntry = By.className("jsUseEntered");
	public static final By VerifyAddrsFiled = By.id("jsAddressVerificationLayer");
	public static final By txtMailAddrs = By.id("shipEmail");
	public static final By txtPhoneNum = By.id("shipPhone");
	public static final By txtPostalCode = By.id("shipZip");
	public static final By dropDownState = By.xpath("//*[@id=\'shipState\']/option");
	public static final By txtCityField = By.id("shipCity");
	public static final By txtAddrs2Field = By.id("shipAddress2");
	public static final By txtAddrs1Field = By.id("shipAddress1");
	public static final By txtLastNameField = By.id("shipLast");
	public static final By txtFirstNameField = By.id("shipFirst");
	
	//CheckoutGuestPayment
	public static final By PaymentHeader = By.id("tab-payment");
	
	
	public static final By ConfirmOrderField = By.className("cls_skOrderConfirmTotalCont");
	public static final By btnContinuePayment = By.xpath("//*[@id=\'save_shipping_address_service\']/div[3]/div/ul/li/button");
	public static final By btnContinueCheckout = By.id("jsCompletePayment");
	public static final By ShippingBillingField = By.id("save_shipping_address_service");
	public static final By txtWelcomeMsg = By.id("tab-shipbill");
	
	
	public static final By GuestShippingPage=By.xpath("//*[@id='save_shipping_address_service']");
	public static final By GuestBillingPage=By.xpath("//*[@id='jsBillingAddressLayerWrap']");
	
	
	//shipping 
	
		
		
		//state drop down
		public static final By GuestShipStateDropDown=By.xpath("//*[@name='SHIP_TO_ADDRESS<>state_cd']/option");
		public static final By ContinueCheckout=By.xpath("//*[@class='sfa-button large transactional']");
		public static final By btnUseAsEntry = By.xpath("//*[@id='jsUseEntered']");
		
		public static final By MakeDefaultBill=By.xpath("//*[@class='skMobCheckBoxTxt']");
		
		public static final By PaymentSection=By.xpath("//*[@id='jsPaymentMethodWrap']");
		public static final By GuestPaymentCardSection=By.xpath("//*[@id='submit_payment_service']");
		public static final By GuestPaymentGiftSection=By.xpath("//*[@class='js-gift-card-form gift-card-form']");
		public static final By GuestPaymentPromoSection=By.xpath("//*[@id='add_promo_code_service']");
		public static final By GuestPaymentAccountSection=By.xpath("//*[@id='create_account_form']");
		//payment
		public static final By PaymentType=By.xpath("//*[@id='payCC']");
		public static final By PaymentGiftno=By.xpath("//*[@id='payGCNum']");
		public static final By PaymentGiftPin=By.xpath("//*[@id='payGCPIN']");
		public static final By PaymentPromo=By.xpath("//*[@id='promoCodeEntry']");
		public static final By PaymentAccPass=By.xpath("//*[@id='password']");
		public static final By PaymentAccConfPass=By.xpath("//*[@id='password2']");
		public static final By PaymentAccPassHint=By.xpath("//*[@id='passwordHint']");

	
}
