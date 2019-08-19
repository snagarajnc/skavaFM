package com.skava.object.repository;

import org.openqa.selenium.By;

public class CheckoutPage {
	public static final By productField = By.className("cls_skProductDetailsCont");
	public static final By btnPlaceOrderNow = By.className("cls_skPlaceOrderBtn");
	public static final By btnGuestCheckout = By.id("jsCheckoutRemediationGuestCheckout");
	public static final By txtCheckoutHeader = By.className("cls_skSelectMethodTotalCont");
	public static final By GuestCheckoutheader = By.id("tab-shipbill");
	public static final By GuestCheckoutShippingPage = By.xpath("//*[contains(@class,'shippingPage')][@style='visibility: visible;']");
	
	//Checkout
	public static final By eleReviewOrder = By.xpath("//*[contains(@class,'reviewPage')][@style='visibility: visible;']");
	public static final By eleBillingAddrssField = By.className("billing-address-summary");
	public static final By elePaymentField = By.className("payment-method-summary");
	public static final By eleShippingAddrssField = By.className("widebag-freight-shipment-list");
	public static final By btnPlaceOrder = By.id("jsReviewSubmit");
	
	//OrderSummary
	public static final By eleOrderSummary = By.xpath("//*[@class='order-summary']");

}
