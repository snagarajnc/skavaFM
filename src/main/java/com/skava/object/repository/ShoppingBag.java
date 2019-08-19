package com.skava.object.repository;

import org.openqa.selenium.By;

public class ShoppingBag {
	//CartHeaderLOGO
	public static final By btnCartHeaderLogo = By.xpath("//*[@class=\'logo_icon_wrapper\']/a");
	
	//CartHeader
	public static final By CartHeader = By.className("masthead-saksbag-title");

	//product
	public static final By ProductInCart = By.xpath("//*[@class='widebag-item-list-content']/div");
	
	//Checkout
	public static final By btnCheckoutBottom = By.xpath("(//*[@class='shopping-cart-button-group']//a)[1]");
	
	//Checkout
	public static final By btnPaypalChkt = By.xpath("//*[@class='sk_payPalCont']");
	
	
	

	//PriceDetails
	public static final By eleOrderSummary = By.className("order-summary");
	public static final By PrdNameInCart = By.className("widebag-item-product-name");
	public static final By PrdDescriptionInCart = By.className("widebag-item-short-description");
	public static final By PrdSKUIDInCart = By.xpath("//*[@class='sk_pdpCont']/p[3]");
	public static final By PrdSizeInCart = By.className("sk_pdtSize");
	public static final By PrdColourInCart = By.className("sk_pdtColor");
	public static final By PrdRemoveInCart = By.xpath("//*[@class='jsItemRoot widebag-item ']//*[@class='action-link jsRemoveItem']//span[2]");
	public static final By PrdSaveLaterInCart = By.xpath("//*[@class='action-group']/li[2]/a/span[2]");
	public static final By PrdEditInCart = By.xpath("//*[@class='jsItemRoot widebag-item ']//*[@class='action-link jsEditItem']");
	public static final By PrdInventoryStatusInCart = By.className("sk_pdtStatus");
	public static final By PrdClearancePriceInCart = By.className("sk_pdtTotPrice");
	public static final By PrdSalePriceInCart = By.className("widebag-item-unit-price");
	
	
	//ProductRemove
	public static final By PrdRemoveOverlay = By.className("confirmation-overlay");
	public static final By btnPrdRemoveConfirm = By.xpath("//*[@class='confirmation-overlay']/ul/li[1]/a/span");
	public static final By btnPrdRemoveCancel = By.xpath("//*[@class='confirmation-overlay']/ul/li[2]/a/span");

	//EmptyCart
	public static final By CartEmptytxt = By.className("widebag-empty-message");

	//Discount&Shipping
	public static final By EstimatedShipping = By.id("jsShippingMethodGroup");
	public static final By DDShippingMethod = By.id("jsSelectShippingMethodWrap");
	public static final By txtZipCode = By.id("jsBagZipCode");
	public static final By eleItemTotal = By.xpath("//*[@class='order-summary']/dl/div[1]/dt");
	public static final By eleEstimatedShipping = By.xpath("//*[@class='order-summary']/dl/div[2]/dt");
	public static final By eleEstimatedTax = By.xpath("//*[@class='order-summary']/dl/div[3]/dt");
	public static final By eleEstimatedTotal = By.xpath("//*[@class='order-summary']/dl/div[4]/dt");
	
	
	
	public static final By txtProductSize = By.className("skMob_SizeValue");
	public static final By txtProductColour = By.className("skMob_ColorName");
	public static final By btnRemovePrd = By.className("sk_selectedImgRemove");
	public static final By btnCheckoutTop = By.xpath("//*[@class=\'sk_shoppingBag_CheckoutBtn\']/div/div");
	public static final By ContinueShoppingbtn = By.className("sk_BagShopNowBtnText");
	public static final By CartMask = By.id("sk_mobContainerMask_id");
	public static final By CartHeaderCount = By.className("sk_bagHeadCount");
	public static final By BannerInCart = By.className("cls_skSBPersistentBannerImg");
	public static final By ShoppingID = By.className("sk_shoppingBag_Id");
	public static final By PrdIMGCart = By.xpath("//*[@class=\'sk_pdtImage_panel\']/a/img");
	
	//saveforlater
	public static final By saveforlater = By.xpath("//*[@class='action-group']/li[2]");
	public static final By saveditems = By.xpath("//*[@class='masthead-saved-item-title']");
	public static final By savedproduct = By.xpath("//*[@class='widebag-item-list-content']");
	public static final By savedproductname = By.xpath("//*[@class='widebag-item-product-name']");
	
	//BackTOUS
	
	public static final By backToUSshipping = By.xpath("//*[@class='sfa-button large flat']//*[@class='sfa-button-text']");
	
	
	public static final By CartPage=By.xpath("//*[@sk_pagename='sk_lntShoppingCartPage']");
	public static final By productQty=By.xpath("(//*[@name='itemQuantity'])[1]");
	public static final By ItemTotalPrice=By.xpath("//*[@id='jsVal-itemsTotal']");
	public static final By ProductDiscount=By.xpath("(//*[@class='widebag-item-discount-price']/span)[1]");
	public static final By productPrice=By.xpath("(//*[@class='widebag-item-unit-price']/span)[1]");
	public static final By productExdPrice=By.xpath("(//*[@class='widebag-item-extended-price']/span)[1]");
	public static final By CartProducts=By.xpath("//*[@class='widebag-item-list-content']");
	//public static final By CartLoadingOverView=By.xpath("//*[@class='blockUI blockOverlay']");
	
	public static final By CartLoadingOverView=By.xpath("//*[@class='blockUI blockMsg blockPage']");
	

		
}
