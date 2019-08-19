package com.skava.object.repository;

import org.openqa.selenium.By;

public class ProductDetailPage {
	
	//PDP Deatils
	public static final By eleProductDetail = By.className("pdp_DetailsName");
	public static final By elePrdDetailsList = By.className("pdp_DescValue");
	
	//AddToBag
	public static final By btnAddToBag = By.id("pdpAddtoBagBtn");
	
	//PrdName
	public static final By productNamePDP = By.className("prdNametitle");
	public static final By productIdPDP = By.xpath("//*[@id='id_pdpWrapper']");
	
	public static final By PDPOverlay =By.xpath("//*[contains(@class,'sk_mobPdtAddToBagCont ')][contains(@style,'block')]");
	
	public static final By PDPEditOverlay =By.xpath("//*[contains(@class,'quicklook-dialog')][contains(@style,'block')]");
	
	//colour
	public static final By colourField = By.className("pdpAvailColors");
	public static final By btnSelectColour = By.xpath("//*[@id='id_pdpColorSwatchCont']//*[contains(@class,'skMob_available')]");
	public static final By btnSelectedColour = By.xpath("//*[@id='id_pdpColorSwatchCont']//*[contains(@class,'skMob_available selected')]");


	//Size
	public static final By SizeField =By.className("pdpSelectOpt");
	public static final By btnSizeField = By.xpath("//*[@id='pdpSizeContainer']//*[contains(@class,'skMob_available')]");
	public static final By txtSlectedSize = By.xpath("//*[@class='pdpSelectBorder ']//*[contains(@class,'skMob_available selected')]");

	//SuccessOverLay
	public static final By eleCartsuccessOverLay = By.xpath("//*[@id='sk_addtobagSuccess_id']/div[1]");
	public static final By btnViewBag = By.xpath("//*[@class='skMob_ATB_BtnContainer']/div[1]");
	public static final By btnCheckout = By.xpath("//*[@class='skMob_ATB_BtnContainer']/div[2]");
	public static final By btnOverLayClose = By.xpath("//*[@id='sk_addtobagSuccess_id']//*[contains(@class,'sk_mobCloseImg')]");


	
	public static final By txtPriceField = By.className("skMob_colorPriceCont");
	//public static final By txtSlectedSize = By.xpath("//*[@class=\'pdpSelectBorder\']/span[1]");
	public static final By PresistentBanner = By.className("cls_skPersistentBannerCont");
	public static final By btnFavourites = By.className("skMob_favourites");
	public static final By eleFavAdded = By.className("skMob_favourites skMob_favAdded");
	
	//Quantity Increment Decrement
	public static final By productQtyDecrement = By.xpath("//*[@id='id_skMob_quantityMinus']");
	public static final By productQtyIncrement = By.xpath("//*[@id='id_skMob_quantityPlus']");
	public static final By productQty = By.xpath("//*[@id='id_skMob_quantityText']");
	public static final By bagQty = By.xpath("//*[@id='bag_count']");
	
	
}
