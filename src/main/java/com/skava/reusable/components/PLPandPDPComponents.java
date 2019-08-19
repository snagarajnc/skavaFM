package com.skava.reusable.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.framework.reporting.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
import com.skava.object.repository.HomePage;
import com.skava.object.repository.ProductDetailPage;
import com.skava.object.repository.ProductListPage;
import com.skava.object.repository.ShoppingBag;

public class PLPandPDPComponents extends FeaturedCompnents {
	
	public void breadcrumbValidation()
	{
		if(driver.isElementDisplayed(ProductListPage.eleBreadCrumb, 40, "Bread Crumb"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Bread Crumb Displayed above Header in PLP");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Bread Crumb not Displayed above Header in PLP");
	}

	public void backToTopValidation() throws InterruptedException
	{
		if(driver.isElementDisplayed(ProductListPage.prdList, 30, "Products displayed in PLP Page"))
		{
			int size = driver.getsize(ProductListPage.prdList, "Total products from the list");
			if(size>=10)
			{
				driver.scrollToRandomElement(ProductListPage.prdList, 10, "Scrolling down");
				if(driver.isElementDisplayed(ProductListPage.btnBackToTop, 20, "Back To Top"))
				{
					ExtentTestManager.getTest().log(LogStatus.INFO, "Back To Top Button Displayed");
					driver.clickElement(ProductListPage.btnBackToTop, "Back To Top");
					driver.isElementDisplayed(ProductListPage.elePrdColourList, 5, "Wait");
					if(driver.isElementPresent(ProductListPage.btnBackToTop, "back To Top"))
					{
						ExtentTestManager.getTest().log(LogStatus.FAIL, "Back To Top Button not Working Fine");
					}
					else
					{
						ExtentTestManager.getTest().log(LogStatus.PASS, "Back To Top Button Working Fine");
					}	
				}
				else
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Back To Top Button Not Displayed");
			}
			else
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Not more than 10 products Displayed");
		}
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Products Not Displayed");
	}
	
	public void lazyLoadValidation()
	{
		try
		{
			driver.scrollToElement(ProductListPage.RelatedSearchtxt, "SrollDown");
			driver.isElementDisplayed(ProductListPage.LazyLoad, 20, "Lazy Load");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Lazy Load is Displayed");
		}
		catch(Throwable XX)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Lazy Load is Displayed");
		}
	}
	public void sortValidation()
	{
		driver.clickElement(ProductListPage.btnSorting, "Sorting Clicked");
		if(driver.isElementDisplayed(ProductListPage.RefineHeader, 30, "Refine"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Refine Page Opened");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Refine Page Not Opened");
		//driver.clickRandomElement(ProductListPage.SortingOption, 1, "Sorting Done");
	}
	public void filterValidation(String Method)
	{
		driver.clickElement(ProductListPage.btnFilter, "Filter Clicked");
		driver.clickElement(ProductListPage.FilterOption, "Filter Option Clicked");
		String Filter = driver.getElementAttribute(ProductListPage.eleFilterOptions, "class", "Filter Options Opened");
		if(driver.compareStrings(Filter, "skMob_filterOpen", "Compare"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Filter Option Opened");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Filter Option Not Opened");
		driver.clickElement(ProductListPage.btnFilterOption, "Filter Selected");
		if(Method == "Apply")
		{
		driver.clickElement(ProductListPage.btnApplyFilter, "Filter Apply");
		ExtentTestManager.getTest().log(LogStatus.PASS, "Filter Done");
		}
		else if(Method == "Close")
		{
			driver.clickElement(ProductListPage.btnSortingClose, "Filter not Apply");
			String FilterApplied = driver.getText(ProductListPage.FilterApplied, "Filter Applied");
			if(driver.compareStrings(FilterApplied, "0", "Filter Not Applied"))
				ExtentTestManager.getTest().log(LogStatus.PASS, "Filter Not Applied");
			else
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Filter Applied On Selecting Close");
		}
	}
	public String selectProductinPLP()
	{
		
		int randomNo = driver.generateRandomNumber(driver.getsize(ProductListPage.prdList, "Total products from the list"));
		String BrandName = driver.getTextRandom(ProductListPage.elePrdNameList, randomNo, "ProductListName");
		String TitleName = driver.getTextRandom(ProductListPage.elePrdDescription, randomNo, "ProductListName");
		String name = BrandName +" "+ TitleName;
		String ProductListName = name.replaceAll("\\s+", "");
		driver.clickRandomElement(ProductListPage.elePrdDescription, randomNo, "PLPselection");
		ExtentTestManager.getTest().log(LogStatus.PASS, "PLP Selected Name "+ProductListName);
		if(driver.isElementDisplayed(ProductDetailPage.productIdPDP, 30, "PDP Page wait"))
		{
			String namePDP = driver.getText(ProductDetailPage.productNamePDP, "Product Name In PDP");
			String ProductDetailName = namePDP.replaceAll("\\s+", "");
			String prodID = driver.getElementAttribute(ProductDetailPage.productIdPDP, "identifier", "Product Sku Id");
			ExtentTestManager.getTest().log(LogStatus.INFO, "PDP Selected Name: "+ProductDetailName);
			ExtentTestManager.getTest().log(LogStatus.INFO, "PDP selected ProdId:  "+prodID);
		}
		else
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "PDP page not displayed");
		}
		return ProductListName;
	}
	public String pDPValidation()
	{
		String ProductDetailName ="";
		if(driver.isElementDisplayed(ProductDetailPage.productIdPDP, 20, "PDP Page wait"))
		{
			String name = driver.getText(ProductDetailPage.productNamePDP, "Product Name In PDP");
			ProductDetailName = name.replaceAll("\\s+", "");
			String prodID = driver.getElementAttribute(ProductDetailPage.productIdPDP, "identifier", "Product Sku Id");
			ExtentTestManager.getTest().log(LogStatus.INFO, "PDP Selected Name: "+ProductDetailName);
			ExtentTestManager.getTest().log(LogStatus.INFO, "PDP selected ProdId:  "+prodID);
			return ProductDetailName;
		}
		else
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "PDP page not displayed");
		}
		return ProductDetailName;
		
	}
	
	public void pDPOverlay()
	{	
		if(driver.isElementDisplayed(ProductDetailPage.PDPOverlay, 20, "PDP overlay"))
		{
			ExtentTestManager.getTest().log(LogStatus.PASS, "PDP Overlay Displayed");
		}
		else
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "PDP Overlay not Displayed");
		}	
	}
	
	public void pdpEditOverlay()
	{	
		if(driver.isElementDisplayed(ProductDetailPage.PDPEditOverlay, 20, "PDP Edit overlay"))
		{
			ExtentTestManager.getTest().log(LogStatus.PASS, "PDP Edit Overlay Displayed");
		}
		else
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "PDP Edit Overlay not Displayed");
		}	
	}
	
	public void productDetailValidatin()
	{
		driver.scrollToElement(ProductDetailPage.btnAddToBag, "Scrolling");
		driver.isElementDisplayed(ProductDetailPage.eleProductDetail, 20, "Deatils");
		if(driver.isElementDisplayed(ProductDetailPage.elePrdDetailsList, 20, "Details List"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Product deatils Displayed");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Product deatils Not Displayed");
		
	}
	public String selectColour()
	{
		String ColourSelected = "";
		driver.scrollToElement(ProductDetailPage.productNamePDP, "Scrolling");
		if(driver.isElementDisplayed(ProductDetailPage.colourField, 5, "Colour Field present"))
		{
			if(driver.isElementPresent(ProductDetailPage.btnSelectedColour, "Colour selected by default"))
			{
				ExtentTestManager.getTest().log(LogStatus.INFO, "Colour Selected in PDP");
				ColourSelected = driver.getElementAttribute(ProductDetailPage.btnSelectedColour, "alt", "Size selected");
			}
			else
			{
				int randomNo = driver.generateRandomNumber(driver.getsize(ProductDetailPage.btnSelectColour, "Total size of color swatches"));
				driver.clickRandomElement(ProductDetailPage.btnSelectColour, randomNo, "Randomly selecting the Color from swatches");
				ExtentTestManager.getTest().log(LogStatus.INFO, "Colour Selected in PDP");
				ColourSelected = driver.getElementAttribute(ProductDetailPage.btnSelectedColour, "alt", "Size selected");
			}
		}
		else {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Colour Not present in selected product");
		}
		
		return ColourSelected;
		
	}
	public String selectSize()
	{
		String SizeSelected = "";
		if(driver.isElementDisplayed(ProductDetailPage.SizeField, 5, "Size field"))
		{
			if(driver.isElementPresent(ProductDetailPage.txtSlectedSize, "Size selected by default"))
			{
				ExtentTestManager.getTest().log(LogStatus.INFO, "Size Selected in PDP");
				SizeSelected = driver.getText(ProductDetailPage.txtSlectedSize, "Colour selected");
			}
			else
			{				
				int randomNo = driver.generateRandomNumber(driver.getsize(ProductDetailPage.btnSizeField, "Total size of size swatches"));
				driver.clickRandomElement(ProductDetailPage.btnSizeField, randomNo, "Randomly selecting the size from swatches");
				ExtentTestManager.getTest().log(LogStatus.INFO, "Size Selected in PDP");
				SizeSelected = driver.getText(ProductDetailPage.txtSlectedSize, "Colour selected");
			}
		}
		else {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Size Not present in selected product");
		}
		return SizeSelected;
	}
	public void selectFavourites()
	{
		driver.scrollToElement(ProductDetailPage.PresistentBanner, "Scrolling");
		if(driver.clickElement(ProductDetailPage.btnFavourites, "Product selected to favourites"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Product Added to Favourites");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Product Not Added to Favourites");
	}
	public void gridViewValidation()
	{
		String GridView = driver.getElementAttribute(ProductListPage.btnGridView, "class", "Grid View Validation");
		if(!driver.compareStrings(GridView, "isActiveView", "Comparision"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "GRID View in PLP");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "LIST View in PLP");
	}
	public void gridparameterValidation()
	{
		if(driver.isElementDisplayed(ProductListPage.priceINGrid, 20, "Prices In Grid"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Prices Displayed correctly in Grid View");
			else
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Prices NOT Displayed correctly in Grid View");
		if(driver.isElementDisplayed(ProductListPage.RatingINGrid, 10, "Rating Displayed in Grid View"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Rating Displayed correctly in Grid View");
			else 
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Rating  NOT Displayed correctly in Grid View");
		if(!driver.clickElement(ProductListPage.btnFavPLP, "Favourite Ckeck"))
			ExtentTestManager.getTest().log(LogStatus.INFO, "Fav NOT Displayed in Grid View");
			else
				ExtentTestManager.getTest().log(LogStatus.INFO, "Fav NOT Displayed in Grid View");
	}
	public void clickListView()
	{
		driver.clickElement(ProductListPage.btnListView, "ListView Selected");
		
	}
	public void listViewValidation()
	{
		String GridView = driver.getElementAttribute(ProductListPage.btnGridView, "class", "List View Validation");
		if(!driver.compareStrings(GridView, "isActiveView", "Comparision"))
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Grid View in PLP");
		else
			ExtentTestManager.getTest().log(LogStatus.PASS, "List View in PLP");
	}
	public void listParameterValidation()
	{
		if(driver.isElementDisplayed(ProductListPage.elePrdNameList, 20, "Prices In Grid"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Product Name Displayed correctly in Grid View");
			else
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Product Name NOT Displayed correctly in Grid View");
		if(driver.isElementDisplayed(ProductListPage.elePrdIMGList, 10, "Product Image Displayed in Grid View"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Product Image Displayed correctly in Grid View");
			else 
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Rating  NOT Displayed correctly in Grid View");
		if(driver.isElementDisplayed(ProductListPage.btnBUYlist, 10 , "Buy Button Displayed in List View"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Buy Button Displayed correctly in Grid View");
			else
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Buy Button not Displayed correctly in Grid View");
		if(driver.isElementDisplayed(ProductListPage.btnFavPLP, 10, ""))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Fav ICON Displayed correctly in LIST View");
			else
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Fav ICON NOT Displayed in LIST View");
	}
	public void buyButtonValidation()
	{
		driver.scrollToElement(ProductListPage.eleProduct, "Scroll To Buy Button");
		if(driver.clickElement(ProductListPage.btnBUYlist, "Click Buy Button"))
		{
			driver.scrollToElement(ProductListPage.btnCloseBuy, "Scroll Down");
			if(driver.isElementDisplayed(ProductListPage.btnAddToBag, 10, "Add to Bag"))
				ExtentTestManager.getTest().log(LogStatus.PASS, "Add to Bag Present under buy");
			else
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Add to Bag not Present under buy");
			if(driver.isElementDisplayed(ProductListPage.btnShare, 10, "Share Button"))
				ExtentTestManager.getTest().log(LogStatus.PASS, "Share Button Present under buy");
			else
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Share Button not Present under buy");
			if(driver.isElementDisplayed(ProductListPage.QTYfield, 10, "QTY"))
				ExtentTestManager.getTest().log(LogStatus.PASS, "QTY Present under buy");
			else
				ExtentTestManager.getTest().log(LogStatus.FAIL, "QTY not Present under buy");
			if(driver.isElementDisplayed(ProductListPage.prdcolourfield, 10, "QTY"))
				ExtentTestManager.getTest().log(LogStatus.INFO, "Colour present under buy");
			else
				ExtentTestManager.getTest().log(LogStatus.INFO, "Colour not Present under buy");
			if(driver.isElementDisplayed(ProductListPage.prdSizeField, 10, "QTY"))
				ExtentTestManager.getTest().log(LogStatus.INFO, "SIZE Present under buy");
			else
				ExtentTestManager.getTest().log(LogStatus.INFO, "SIZE not Present under buy");
			driver.scrollToElement(ProductListPage.btnFavPLP, "Scroll To Buy Button");
			driver.clickElement(ProductListPage.btnCloseBuy, "Close Button Clicked");
		}
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "BUY button not Clickable under LIST view");
	}
	public void colourandSize_Buy()
	{
		driver.scrollToElement(ProductListPage.eleProduct, "Scroll To Buy Button");
		if(driver.clickElement(ProductListPage.btnBUYlist, "Click Buy Button"))
		{
			ExtentTestManager.getTest().log(LogStatus.PASS, "BUY button Clicked under LIST view");
			if(driver.isElementDisplayed(ProductListPage.prdcolourfield, 2, "QTY"))
			{
				if(driver.clickElement(ProductListPage.btnclour, "Colour selecetd"))
					ExtentTestManager.getTest().log(LogStatus.PASS, "Colour Selected under buy");
				else
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Colour NOT Selected under buy");
			}
			else
				ExtentTestManager.getTest().log(LogStatus.INFO, "Colour not Present under buy");
			if(driver.isElementDisplayed(ProductListPage.prdSizeField, 2, "QTY"))
			{
				int NUMofSize = driver.getsize(ProductListPage.btnSize, "Number Of Size");
				if(NUMofSize>2)
				{
				if(driver.clickRandomElement(ProductListPage.btnSize, 1, "Size Selected"))
					ExtentTestManager.getTest().log(LogStatus.PASS, "SIZE Selected under buy");
				else
					ExtentTestManager.getTest().log(LogStatus.INFO, "SIZE NOT Selected Selected under buy");
				}
			}
			else
				ExtentTestManager.getTest().log(LogStatus.INFO, "SIZE not Present under buy");
		}
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "BUY button not Clickable under LIST view");
	}
	public void addToBag_BUY()
	{
		if(driver.scrollToElement(ProductListPage.btnAddToBag, "Scroll Add To Bag") && driver.clickElement(ProductListPage.btnAddToBag, "Add To Bag"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "BUY button Clicked under LIST view");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "BUY button not Clickable under LIST view");
	}
	public void addToBag_PDP()
	{
		driver.scrollToElement(ProductDetailPage.btnAddToBag, "Add To Bag");
		if(driver.clickElement(ProductDetailPage.btnAddToBag, "Add To Bag Clicked"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Add To Bag Clicked in PDP");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Add To Bag not Clickable in PDP");		
	}
	public void cartSuccess_OverLay(String Action)
	{
		if(driver.isElementDisplayed(ProductDetailPage.eleCartsuccessOverLay, 30, "Success Overlay"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Add To Cart Success OverLay Displayed");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Add To Cart Success OverLay Not Displayed");
		if(Action=="Continue")
		{
			driver.isElementDisplayed(ProductDetailPage.btnViewBag, 10, "Success Overlay");
			if(driver.clickElement(ProductDetailPage.btnViewBag, "Continue Shopping Clicked"))
				ExtentTestManager.getTest().log(LogStatus.PASS, "Continue Shopping Clicked");
			else
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Continue Shopping Not Clicked");
		}
		else if(Action =="Checkout")
		{
			if(driver.isElementDisplayed(ProductDetailPage.eleCartsuccessOverLay, 30, "Success Overlay"))
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "success overlay Displayed");
				if(driver.isElementDisplayed(ProductDetailPage.btnCheckout, 30, "checkout"))
				{
					ExtentTestManager.getTest().log(LogStatus.PASS, "Checkout Displayed");
					driver.explicitWaitforVisibility(ProductListPage.prdList, 15, "wait");
					if(driver.clickElement(ProductDetailPage.btnCheckout, "Checkout click"))
					{
						ExtentTestManager.getTest().log(LogStatus.PASS, "Checkout Clicked");
					}
					else
					{
						ExtentTestManager.getTest().log(LogStatus.FAIL, "Checkout Not Clicked");
					}
				}
				else
				{
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Checkout Not Displayed");
				}
			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "success overlay not Displayed");
			}
		}
		else
		{
			driver.isElementDisplayed(ProductDetailPage.btnOverLayClose, 10, "Success Overlay");
			if(driver.clickElement(ProductDetailPage.btnOverLayClose, "Close OverLay Clicked"))
				ExtentTestManager.getTest().log(LogStatus.PASS, "Close OverLay Clicked");
			else
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Close OverLay Not Clicked");
		}
	}
	public void presistentBanner_PLP()
	{
		if(driver.isElementDisplayed(ProductListPage.PresistentBanner, 10, "Banner In PLP"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Presistent Banner Found in PLP");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Presistent Banner Not Found in PLP");
	}
	public void presistentBanner_PDP()
	{
		if(driver.isElementDisplayed(ProductDetailPage.PresistentBanner, 10, "Banner In PDP"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Presistent Banner Found in PDP");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Presistent Banner Not Found in PDP");
	}
	public void pLPValidation()
	{
		if(driver.isElementDisplayed(ProductListPage.prdList, 20, "Product List Page"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Category Navigated successfully");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Category Navigated Unsuccessfully");
		if(driver.isElementDisplayed(ProductListPage.elePrdIMGList, 10, "Product Image"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Product Image Displayed");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Product Image Not Displayed");
		if(driver.isElementDisplayed(ProductListPage.elePrdNameList, 10, "Product NameList"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Product NameList Displayed");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Product NameList Not Displayed");
		/*if(driver.isElementDisplayed(ProductListPage.elePrdColourList, 10, "Product ColourList"))
			ExtentTestManager.getTest().log(LogStatus.INFO, "Product ColourList Displayed");
		else
			ExtentTestManager.getTest().log(LogStatus.INFO, "Product ColourList Not Displayed");*/
		if(driver.isElementDisplayed(ProductListPage.elePrdDescription, 10, "Product Description"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Product Description Displayed");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Product Description Not Displayed");
		if(driver.isElementDisplayed(ProductListPage.elePrdPrice, 10, "Product Price"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Product Price Displayed");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Product Price Not Displayed");
			
	}
	public void addtoFAV_BUY()
	{
		driver.clickRandomElement(ProductListPage.btnFavPLP, 0, "Add To FAV");
		if(driver.isElementDisplayed(ProductListPage.Favadded, 20, "Fav Added"))
				ExtentTestManager.getTest().log(LogStatus.PASS, "Fav Added");
			else
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Fav Not Added");
		driver.isElementDisplayed(ProductDetailPage.btnAddToBag, 10, "Add to Bag Displayed");
		//driver.isElementDisplayed(ProductListPage.POPUPAddToFav, 20, "Pop UP Opened");
	}
	public void addtoFAV_PDP()
	{
		if(driver.clickElement(ProductDetailPage.btnFavourites, "Add To FAV"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Add To FAV Clicked in PDP");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Add To FAV not Clickable in PDP");
		driver.isElementDisplayed(ProductListPage.btnFavPLP, 10, "Add to Fav");
	}
	
	
	public void quantityIncrement() throws InterruptedException
	{
		//Thread.sleep(1000);
		driver.isElementDisplayed(HomePage.btnCart, 10, "Wait");
		if(driver.isElementDisplayed(ProductDetailPage.productQtyIncrement, 30, "Product QTY increment"))
		{
			int qty,exp=0;
			ExtentTestManager.getTest().log(LogStatus.PASS, "Product QTY increment button is displayed ");
			driver.scrollToElement(ProductDetailPage.productQtyIncrement, "QTY");
			//System.out.println(driver.getElementAttribute(ProductDetailPage.productQty, "value", "gettting value"));				
			qty=Integer.parseInt(driver.getElementAttribute(ProductDetailPage.productQty, "value", "gettting value"));
			ExtentTestManager.getTest().log(LogStatus.INFO, "Before Increment value: "+qty);
			driver.clickElement(ProductDetailPage.productQtyIncrement, "Increment Click");
			driver.isElementDisplayed(ProductDetailPage.productQty, 10, "Wait");
			exp=Integer.parseInt(driver.getElementAttribute(ProductDetailPage.productQty, "value", "gettting value"));
			ExtentTestManager.getTest().log(LogStatus.INFO, "After Increment value: "+exp);
			if(qty<exp)
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "Quantity increment success");
			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Quantity increment  Failure");
			}			
		}
		else
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Quantity increment icon not present");
		}		
	}
	
	
	public void quantityDecrement()
	{
		if(driver.isElementDisplayed(ProductDetailPage.productQtyDecrement, 20, "Product QTY decrement"))
		{
			int qty,exp=0;
			ExtentTestManager.getTest().log(LogStatus.PASS, "Quantity decrement button is displayed");
			driver.scrollToElement(ProductDetailPage.productQtyDecrement, "QTY");			
			//System.out.println(driver.getElementAttribute(ProductDetailPage.productQty, "value", "gettting value"));			
			driver.isElementDisplayed(ProductDetailPage.productQty, 10, "Wait");
			qty=Integer.parseInt(driver.getElementAttribute(ProductDetailPage.productQty, "value", "gettting value"));
			ExtentTestManager.getTest().log(LogStatus.INFO, "Before Decrement value: "+qty);
			driver.clickElement(ProductDetailPage.productQtyDecrement, "Decrement Click");
			driver.isElementDisplayed(ProductDetailPage.productQty, 10, "Wait");
			exp=Integer.parseInt(driver.getElementAttribute(ProductDetailPage.productQty, "value", "gettting value"));
			ExtentTestManager.getTest().log(LogStatus.INFO, "After Decrement value: "+exp);
			if(qty>exp)
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "Quantity decrement success");				
			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Quantity decrement  Failure");
			}			
		}
		else
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Quantity decrement icon not present");
		}
	}
	
		
		public int bag_CountCheck()
		{
			if(driver.isElementDisplayed(ProductDetailPage.bagQty, 30, "Wait Bag Qty"))
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, " Bag Qty is displayed");
				driver.scrollToElement(ProductDetailPage.bagQty, "Scroll Bag Qty");
				int Qty=Integer.parseInt(driver.getText(ProductDetailPage.bagQty, "Bag Count get"));
				ExtentTestManager.getTest().log(LogStatus.INFO, " Bag Qty displayed is: "+Qty);
				return Qty;
			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, " Bag Qty is not displayed");
				return 0;
			}			
		}
		
		public void bagCount_Validation(int act,int exp)
		{
			if(exp>act)
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, " Bag Qty count is incremented on adding product to cart");
			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, " Bag Qty count is not incremented on adding product to cart");
			}
		}
		
		public void select_Sort()
		{			
			if(driver.isElementDisplayed(ProductListPage.btnSorting, 20, "Wait Bag Qty"))
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, " Sort and filter button is displayed ");
				driver.clickElement(ProductListPage.btnSorting, " Sort and filter button click");
				if(driver.isElementDisplayed(ProductListPage.SortPagee, 5, "Wait Bag Qty"))
				{
					ExtentTestManager.getTest().log(LogStatus.PASS, "Sort and Filter screen is displayed");
					
					int randSubSubCat = driver.generateRandomNumber(driver.getsize(ProductListPage.SortMainTypes, "Total Sub Sub categories"));
					/*if(randSubSubCat==1)
					{
						randSubSubCat++;
					}*/
					if(driver.clickRandomElement(ProductListPage.SortMainTypes, randSubSubCat, "Sort  Category Clicked"))
					{
						ExtentTestManager.getTest().log(LogStatus.PASS, "Selected one sort option ");
						if(driver.isElementDisplayed(ProductListPage.PLPPRoductContainer, 20, "PLP page is displayed after sorting"))
						{
							ExtentTestManager.getTest().log(LogStatus.PASS, "PLP page is displayed after sorting");							
						}
						else
						{
							ExtentTestManager.getTest().log(LogStatus.FAIL, "PLP page is not displayed after sorting");
						}
					}
					else
					{
						ExtentTestManager.getTest().log(LogStatus.FAIL, "Sort option not selected ");
					}
				
				}
				else
				{
					ExtentTestManager.getTest().log(LogStatus.FAIL, " Sort and filter types is not displayed ");
				}
			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, " Sort and filter button is not displayed ");
			}
		}	
		
		
		public void sort_ApplyFilter() throws InterruptedException
		{			
			if(driver.isElementDisplayed(ProductListPage.btnSorting, 20, "Wait Bag Qty"))
			{
				//Thread.sleep(1000);
				driver.explicitWaitforVisibility(ProductDetailPage.btnAddToBag, 5, "Wait");
				ExtentTestManager.getTest().log(LogStatus.PASS, " Sort and filter button is displayed ");
				driver.clickElement(ProductListPage.btnSorting, " Sort and filter button click");
				if(driver.isElementDisplayed(ProductListPage.SortPagee, 20, "Wait Bag Qty") )
				{
					ExtentTestManager.getTest().log(LogStatus.PASS, "Sort and Filter screen is displayed");					
					int randCat = driver.generateRandomNumber(driver.getsize(ProductListPage.SortFilter, "Total Sub Sub categories"));
					//int randCat=0;
					if(driver.clickRandomElement(ProductListPage.SortFilter, randCat, "Sort  Category Clicked"))
					{
						ExtentTestManager.getTest().log(LogStatus.PASS, "Selected one sort option ");
						int randSubCat = driver.generateRandomNumber(driver.getsize(ProductListPage.SortFilterSubCategory, "Total Sub Sub categories"));
						//int randSubCat=0;
						if(randSubCat==0)
						{
							randSubCat++;
						}
						if(driver.scrollToRandomElement(ProductListPage.SortFilterSubCategory, randSubCat, "scrolling to category") && driver.clickRandomElement(ProductListPage.SortFilterSubCategory, randSubCat, "Sort  Category Clicked"))
						{
							ExtentTestManager.getTest().log(LogStatus.PASS, "Subcategory selected ");
							driver.scrollToRandomElement(ProductListPage.SortFilterSubCategory, randSubCat, "scrolling to category");
							String count=driver.GetTextByRandom(ProductListPage.SortFilterSubCategoryCount, randSubCat, "Getting selected filter count").replace("(","").replace(")","");
							String category=driver.GetTextByRandom(ProductListPage.SortFilterCateName,randSubCat,"Getting selected filter name");
							if(driver.isElementDisplayed(ProductListPage.SortApply, 20, "Apply button is displayed on selecting the category") )
							{
								driver.scrollToElement(ProductListPage.SortApply,"Scroll to apply");
								ExtentTestManager.getTest().log(LogStatus.PASS, "Apply button is  displayed on selecting the category in filter filter");
								if(driver.clickElement(ProductListPage.SortApply, "Click apply button"))
								{
									ExtentTestManager.getTest().log(LogStatus.PASS, "Apply button click is successfull");
									
									//driver.isElementDisplayed(ProductListPage.SortLoadingHide, 20, "wait till apply");
									//driver.explicitWaitforVisibility(ProductListPage.SortLoadingHide, 30, "PLP");
									//Thread.sleep(3000);
									driver.explicitWaitforVisibility(ProductDetailPage.btnAddToBag, 10, "Wait");;
									if(driver.isElementDisplayed(ProductListPage.PLPPRoductContainer, 50, "PLP page is displayed after sorting")
											&& driver.isElementDisplayed(ProductListPage.PLPCount, 20, "PLP page is displayed after sorting"))
									{
										ExtentTestManager.getTest().log(LogStatus.PASS, "PLP page is displayed after sorting");
										//Thread.sleep(500);
										int actual=Integer.parseInt(count);
										driver.explicitWaitforVisibility(ProductDetailPage.btnAddToBag, 5, "Wait");
										int expected=Integer.parseInt(driver.getText(ProductListPage.PLPCount, "getting plp count").replaceAll(",",""));
										
										ExtentTestManager.getTest().log(LogStatus.INFO, "Actual Filter Selected : "+category);
										ExtentTestManager.getTest().log(LogStatus.INFO, "Actual Filter count to be applied: "+actual);
										ExtentTestManager.getTest().log(LogStatus.INFO, "Displayed Filter count: "+expected);
										if(actual==expected)
										{
											ExtentTestManager.getTest().log(LogStatus.PASS, "Sorting successfull");
										}
										else
										{
											ExtentTestManager.getTest().log(LogStatus.FAIL, "Sorting unsuccessfull");
										}										
									}
									else
									{
										ExtentTestManager.getTest().log(LogStatus.FAIL, "PLP page is not displayed after sorting");
									}
								}
								else
								{
									ExtentTestManager.getTest().log(LogStatus.FAIL, "Apply button is click unsuccessfull");
								}
							
							}
							else
							{
								ExtentTestManager.getTest().log(LogStatus.FAIL, "Apply button is not displayed on selecting the category in filter");
							}
						}
						else
						{
							ExtentTestManager.getTest().log(LogStatus.FAIL, "Subcategory not selected");
						}
					}
					else
					{
						ExtentTestManager.getTest().log(LogStatus.FAIL, "Sort option not selected ");
					}
				
				}
				else
				{
					ExtentTestManager.getTest().log(LogStatus.FAIL, " Sort and filter types is not displayed ");
				}
			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, " Sort and filter button is not displayed ");
			}
			
		}
		
		public int pLP_Count()
		{
			if(driver.isElementDisplayed(ProductListPage.PLPPRoductContainer, 50, "PLP page is displayed after sorting"))
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "PLP page is displayed after sorting");
				String Sort_count=driver.getText(ProductListPage.PLPCount, "getting plp count");
				if(Sort_count.contains(","))
				{
					Sort_count=Sort_count.replace(",","");
				}
				int S_count=Integer.parseInt(Sort_count);
				return S_count;
				
			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "PLP page is not displayed after sorting");
				return 0;
			}
		}
		
		public void sort_ClearAll(int Plp_act_count) throws InterruptedException
		{
					
				if(driver.isElementDisplayed(ProductListPage.PLPPRoductContainer, 20, "PLP page is displayed after sorting") && driver.isElementDisplayed(ProductListPage.btnSorting, 20, "Wait Bag Qty"))
				{
					driver.explicitWaitforVisibility(ProductDetailPage.btnAddToBag, 5, "Wait");
					ExtentTestManager.getTest().log(LogStatus.PASS, " Sort and filter button is displayed ");
					driver.clickElement(ProductListPage.btnSorting, " Sort and filter button click");
					if(driver.isElementDisplayed(ProductListPage.SortPagee, 20, "Wait Bag Qty") )
					{
						ExtentTestManager.getTest().log(LogStatus.PASS, "Sort and Filter screen is displayed");
						driver.explicitWaitforVisibility(ProductDetailPage.btnAddToBag, 5, "Wait");
						if(driver.isElementDisplayed(ProductListPage.SortClearAll, 20, "Is Clear All button is displayed"))
						{
							ExtentTestManager.getTest().log(LogStatus.PASS, "Sort and Filter Clear All button is displayed");
							if(driver.clickElement(ProductListPage.SortClearAll,"Clear All button Click"))
							{
								ExtentTestManager.getTest().log(LogStatus.PASS, "Sort and Filter Clear All button click successfull");
								//driver.explicitWaitforVisibility(ProductDetailPage.btnAddToBag, 5, "Wait");
								if(driver.isElementDisplayed(ProductListPage.PLPPRoductContainer, 20, "PLP page is displayed after sorting") && driver.isElementDisplayed(ProductListPage.PLPCount, 20, "PLP count is displayed after sorting") )
								{
									ExtentTestManager.getTest().log(LogStatus.PASS, "PLP page is displayed after sorting");
									int Sort_count=pLP_Count();
									if(Plp_act_count==Sort_count)
									{
										ExtentTestManager.getTest().log(LogStatus.PASS, "Sorting clear all successfull"+"PLP count:"+Plp_act_count+"After Clear All count:"+Sort_count+"");
									}
									else
									{
										ExtentTestManager.getTest().log(LogStatus.FAIL, "Sorting clear all unsuccessfull"+"PLP count:"+Plp_act_count+"After Clear All count:"+Sort_count+"");
									}									
								}
							}
							else
							{
								ExtentTestManager.getTest().log(LogStatus.FAIL, "Sort and Filter Clear All button click is unsuccessfull");
							}
						}
						else
						{
							ExtentTestManager.getTest().log(LogStatus.FAIL, "Sort and Filter Clear All button is not displayed");
						}
					
					}
					else
					{
						ExtentTestManager.getTest().log(LogStatus.FAIL, " Sort and filter types is not displayed ");
					}
				
				}
				else
				{
					ExtentTestManager.getTest().log(LogStatus.FAIL, " Sort and filter button  is not displayed ");
				}
		}
	    		
	    		
	    	
	
	
	
}
