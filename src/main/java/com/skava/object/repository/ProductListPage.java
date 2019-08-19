package com.skava.object.repository;

import org.openqa.selenium.By;

public class ProductListPage {
	
	//BrandPLP
	public static final By TopBrandsList = By.xpath("//*[@class='sk_brandsLinksMainCont']");
	
	//PLP
		
	public static final By plpPage = By.xpath("//*[contains(@class,'productlistTab sk_sideFilter sk_sideFilterEnabled')]");
	public static final By prdList =  By.xpath("//*[contains(@class,'skMob_productListItemOuterCont')]");
	//public static final By prdList = By.className("skMob_productList");
	public static final By elePrdIMGList = By.className("skMob_productImgLink");
	public static final By elePrdNameList = By.className("sk_brandName");
	public static final By elePrdColourList = By.className("skMob_availableColor");
	public static final By elePrdDescription = By.className("skMob_productTitle");
	public static final By elePrdPrice = By.className("skMob_pdtPriceCont");
	
	//BackToTop
	//public static final By btnBackToTop = By.xpath("//*[@id=\'id_skStudio_Wrapper\']/div[4]");
	public static final By btnBackToTop = By.xpath("//*[contains(@class,'skMob_showBackToTop')]");
	//BreadCrump
	public static final By eleBreadCrumb = By.id("skMob_breadCrumbContainer_id");
	
	//Sorting
	public static final By btnSorting = By.id("skMob_filterView_icn_id");
	public static final By RefineHeader = By.xpath("//*[@id='id_skMob_titleCont']/div[3]");
	public static final By btnSortingClose = By.xpath("//*[@id='id_skMob_titleCont']/div[1]");
	public static final By SortingOption = By.id("sk_sortOptionContainer_id");
	
	//Filter
	public static final By btnFilter = By.id("skMob_filterView_icn_id");
	public static final By FilterOption = By.xpath("//*[@class='skMob_filterContentWrapperContainer']/div[1]");
	public static final By eleFilterOptions = By.xpath("//*[@class='skMob_filterContentWrapperContainer']/div[1]/div[1]");
	public static final By btnFilterOption = By.xpath("//*[@class='skMob_filterContentWrapperContainer']/div[1]/div[2]/div/div/div[1]");
	public static final By btnApplyFilter = By.id("skMob_filterDone_id");
	public static final By FilterApplied = By.className("skMob_filterCount");

	
	public static final By PresistentBanner = By.className("cls_skPersistentBannerCont");
	public static final By LazyLoad = By.className("skMob_loadMoreProducts");
	public static final By RelatedSearchtxt = By.id("id_plp_relatedSearch");
	public static final By SortSelected = By.xpath("//*[@class=\'skMob_sortByOptions\']/option[@selected=\"selected\"]");
	public static final By btnProductselection = By.className("skMob_productImgDiv");
	public static final By btnProductNameGird = By.xpath("//*[@class=\'skMob_productDetails\']/a/div");
	public static final By btnGridView = By.id("skMob_GridView_id");
	public static final By btnListView = By.id("skMob_ListView_id");
	public static final By PrdDetailGrid = By.className("skMob_productDetails");
	public static final By btnFavPLP = By.xpath("//*[@class=\'skMob_productDetailsContainer\']/div[4]/span");
	public static final By POPUPAddToFav = By.className("skBeallFavSucPopupCont");
	public static final By Favadded = By.xpath("//*[@class=\'skMob_ProductList_Favorites skMob_favourites listview skmob_fav  favSelected skMob_favAdded\']");
	public static final By btnAddToFavPLP = By.xpath("//*[@id=\'skMob_productListContainerId\']/div[1]/div[1]/div/div[2]/div[4]/span");
	public static final By priceINGrid = By.className("skMob_productPriceContainer");
	public static final By RatingINGrid = By.className("skMob_ratingstar_container");
	public static final By eleProduct = By.xpath("//*[@id=\'skMob_productListContainerId\']/div[1]");
	public static final By btnBUYlist = By.xpath("//*[@id=\'skMob_productListContainerId\']/div[1]/div[1]/div[1]/div[2]/div[3]");
	public static final By btnCloseBuy = By.xpath("//*[@id=\'skMob_productListContainerId\']/div[1]/div[5]/div[1]");
	public static final By btnAddToBag = By.xpath("//*[@id=\'skMob_productListContainerId\']/div[1]/div[2]/div[3]/div[2]");
	public static final By QTYfield = By.xpath("//*[@id=\'skMob_productListContainerId\']/div[1]/div[2]/div[3]/div[4]");
	public static final By prdcolourfield = By.xpath("//*[@id=\'skMob_productListContainerId\']/div[1]/div[2]/div[1]");
	public static final By prdSizeField = By.xpath("//*[@id=\'skMob_productListContainerId\']/div[1]/div[2]/div[2]");
	public static final By btnShare = By.xpath("//*[@id=\'skMob_productListContainerId\']/div[1]/div[2]/div[3]/div[1]");
	public static final By btnclour = By.xpath("//*[@class=\'skMob_swatchContentItems\']/div");
	public static final By btnSize = By.xpath("//*[@class=\'skMob_selectSizeCont\']/div");
	
	
	//public static final By btnAddToBag = By.xpath("//*[@id='pdpAddtoBagBtn']");
	public static final By ATBoverlay=By.xpath("//*[@id='sk_addtobagSuccess_id']");
	public static final By SortTypes=By.xpath("//*[@class='skMob_filterContentWrapper']");
	public static final By SortMainTypes=By.xpath("//*[@class='skRes_sortOption']");
	public static final By SortPagee=By.xpath("//*[@class='skMob_iconContainer']");
	//public static final By PLPPRoductContainer=By.xpath("//*[@id='skMob_productListContainer_id']");
	public static final By PLPPRoductContainer=By.xpath("//*[@class='skMob_productList']");
	public static final By SortFilter=By.xpath("//*[@class='skMob_filterContentWrapper']");
	
	
	public static final By SortFilterSubCategory=By.xpath("//*[contains(@class,'skMob_filterOpen')]//*[@class='skMob_filterItemVal']");
	public static final By SortApply=By.xpath("//*[contains(@class,'skMob_filterOpen')]//*[@id='skMob_filterDone_id']");
	public static final By SortFilterSubCategoryCount=By.xpath("//*[contains(@class,'skMob_filterOpen')]//*[@class='skMob_filterItemCount']");
	public static final By SortFilterCateName=By.xpath("//*[contains(@class,'skMob_filterOpen')]//*[@class='skMob_filterItemVal']");
	public static final By PLPCount=By.xpath("//*[@class='skMob_ProductCountVal']");
	public static final By SortClearAll=By.xpath("//*[@class='skMob_clearAllFilter']");
	public static final By SortLoadingHide =By.xpath("//*[(@class='skMob_ui_loadingBar')  and (@style='display: none;')]");
	
}
