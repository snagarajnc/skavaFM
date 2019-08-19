package com.skava.reusable.components;

import com.framework.reporting.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
import com.skava.object.repository.CheckoutPage;
import com.skava.object.repository.HomePage;
import com.skava.object.repository.ProductDetailPage;
import com.skava.object.repository.ShoppingBag;

public class CartComponents extends CheckoutComponents{

	public void addedproductValidation()
	{
		if(driver.isElementDisplayed(ShoppingBag.CartHeader, 20, "Cart Opened"))
				ExtentTestManager.getTest().log(LogStatus.PASS, "Cart Page Opened");
			else
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Cart Wrapper Not Opened");
		if(driver.isElementDisplayed(ShoppingBag.ProductInCart, 10, "Product Added to Cart"))
				ExtentTestManager.getTest().log(LogStatus.PASS, "Product Added To Cart");
			else
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Product Not Added To Cart");
	}
	public String cartProductDetails()
	{
		String PrdNameinCart = driver.getText(ShoppingBag.PrdNameInCart, "Product Name In Cart");
		if(driver.isElementDisplayed(ShoppingBag.PrdDescriptionInCart, 10, "Product Description"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Product Description Displayed");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Product Description Not Displayed");
		if(driver.isElementDisplayed(ShoppingBag.PrdInventoryStatusInCart, 10, "Product Inventory Status"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Product Inventory Status Displayed");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Product Inventory Status Not Displayed");
		if(driver.isElementDisplayed(ShoppingBag.PrdSKUIDInCart, 10, "Product SKUID"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Product SKUID Displayed");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Product SKUID Not Displayed");
		if(driver.isElementDisplayed(ShoppingBag.PrdEditInCart, 10, "Product Edit"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Product Edit Displayed");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Product Edit Not Displayed");
		if(driver.isElementDisplayed(ShoppingBag.PrdRemoveInCart, 10, "Product Remove"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Product Remove Displayed");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Product Remove Not Displayed");
		if(driver.isElementDisplayed(ShoppingBag.PrdSaveLaterInCart, 10, "Product Save Later"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Product Save Later Displayed");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Product Save Later Not Displayed");
		if(driver.isElementDisplayed(ShoppingBag.PrdSizeInCart, 10, "Product Size"))
			ExtentTestManager.getTest().log(LogStatus.INFO, "Product Size Displayed");
		else
			ExtentTestManager.getTest().log(LogStatus.INFO, "Product Size Not Displayed");
		if(driver.isElementDisplayed(ShoppingBag.PrdColourInCart, 10, "Product Colour"))
			ExtentTestManager.getTest().log(LogStatus.INFO, "Product Colour Displayed");
		else
			ExtentTestManager.getTest().log(LogStatus.INFO, "Product Colour Not Displayed");
		if(driver.isElementDisplayed(ShoppingBag.PrdClearancePriceInCart, 10, "Product Clearance Price"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Product Clearance Price Displayed");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Product Clearance Price Not Displayed");
		if(driver.isElementDisplayed(ShoppingBag.PrdSalePriceInCart, 10, "Product Sale Price"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Product Sale Price Displayed");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Product Sale Price Not Displayed");
		return PrdNameinCart;
	}
	public void clickEdit_Cart()
	{
		driver.isElementDisplayed(ShoppingBag.PrdDescriptionInCart, 30, "Wait");
		if(driver.ExecutorclickElement(ShoppingBag.PrdEditInCart, "Edit Button"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Product Edit Clicked");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Product Edit Not Clicked");
	}
	public void clickRemove_Cart(String Action)
	{
		driver.isElementDisplayed(ShoppingBag.PrdDescriptionInCart, 30, "Wait");
		if(driver.ExecutorclickElement(ShoppingBag.PrdRemoveInCart, "Remove Button"))
		{
			ExtentTestManager.getTest().log(LogStatus.PASS, "Product Remove Clicked");
			if(driver.isElementDisplayed(ShoppingBag.btnPrdRemoveConfirm, 10, "Remove Confirmation Button"))
				ExtentTestManager.getTest().log(LogStatus.PASS, "Remove Confirmation Button Displayed");
			else
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Remove Confirmation Button Not Displayed");
			if(driver.isElementDisplayed(ShoppingBag.btnPrdRemoveCancel, 10, "Remove Confirmation Button"))
				ExtentTestManager.getTest().log(LogStatus.PASS, "Remove Confirmation Button Displayed");
			else
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Remove Confirmation Button Not Displayed");			
			if(Action=="Remove")
			{
				driver.ExecutorclickElement(ShoppingBag.btnPrdRemoveConfirm, "Product Removed");
				if(driver.isElementDisplayed(ShoppingBag.CartEmptytxt, 40, "Product Removed"))
					ExtentTestManager.getTest().log(LogStatus.PASS, "Product Removed From Cart");
				else
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Product Not Removed From Cart");
			}
			else if(Action=="Cancel")
			{
				driver.ExecutorclickElement(ShoppingBag.btnPrdRemoveCancel, "Product Removed Canceled");
				if(driver.isElementNotDisplayed(ShoppingBag.PrdRemoveOverlay, "Prduct remove overlay"))
					ExtentTestManager.getTest().log(LogStatus.PASS, "Product Remove ovrelay closed");
				else
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Product Remove ovrelay not closed");
			}			
		}
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Product Remove Not Clicked");
		
	}
	public void cartCountValidation()
	{
		int NumberofProduct_Cart = driver.getsize(ShoppingBag.ProductInCart, "Number Of Product In Cart");
		String CartHeaderCount = driver.getText(ShoppingBag.CartHeaderCount, "Cart Count");
		String CartHeaderCount2 =  driver.getStringInBetween(CartHeaderCount, "[", "]", "Fetch the Value");
		int CartCount = Integer.parseInt(CartHeaderCount2);
		if(NumberofProduct_Cart==CartCount)
			ExtentTestManager.getTest().log(LogStatus.PASS, "Cart Count Is Same");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Cart Count Mismatched");
	}
	public void presistentBanner_Cart()
	{
		if(driver.isElementDisplayed(ShoppingBag.BannerInCart, 20, "Presistent Banner"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Presistent Banner present in cart");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Presistent Banner not present in cart");
	}
	public void shoppingIDvalidation()
	{
		if(driver.isElementDisplayed(ShoppingBag.ShoppingID, 20, "Presistent Banner"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Shopping ID present in cart");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Shopping ID not present in cart");
	}
	public void productImageValidation()
	{
		if(driver.isElementDisplayed(ShoppingBag.PrdIMGCart, 20, "Presistent Banner"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Product Image present in cart");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Product Image not present in cart");
	}
	public void cart_CheckoutValidation()
	{
		if(driver.isElementDisplayed(ShoppingBag.btnCheckoutTop, 20, "Checkout Top Button"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Checkout Top Button present in cart");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Checkout Top Button not present in cart");
		if(driver.isElementDisplayed(ShoppingBag.btnCheckoutBottom, 10, "Checkout Bottom Button"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Checkout Bottom Button present in cart");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Checkout Bottom Button present in cart");
	}
	public void clickCheckoutbutton()
	{
		if(driver.isElementDisplayed(ShoppingBag.btnCheckoutBottom, 30, "Wait"))
		{
			ExtentTestManager.getTest().log(LogStatus.PASS, "Checkout button displayed");
			if(driver.scrollToElement(ShoppingBag.btnCheckoutBottom, "scroll to checkout") && driver.ExecutorclickElement(ShoppingBag.btnCheckoutBottom, "Click Checkout"))
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "Checkout button clicked in cart");	
			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Checkout button not clicked in cart");	
			}			
		}
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Checkout button not displayed in cart");
	}
		
		
	public void clickPayPalbutton()
	{
		if(driver.isElementDisplayed(ShoppingBag.btnPaypalChkt, 20, "Wait"))
		{
			ExtentTestManager.getTest().log(LogStatus.PASS, "PayPal button displayed");
			if(driver.ExecutorclickElement(ShoppingBag.btnPaypalChkt, "Click PayPal"))
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "PayPal button clicked in cart");	
			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "PayPal button not clicked in cart");	
			}			
		}
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "PayPal button not displayed in cart");	
	}
		
	public void removeProduct_Cart()
	{
		if(driver.isElementDisplayed(ShoppingBag.btnRemovePrd, 20, "Remove Prd"))
		{
			driver.clickElement(ShoppingBag.btnRemovePrd, "Product Removed");
			if(driver.isElementDisplayed(ShoppingBag.CartEmptytxt, 10, "Cart Empty"))
				ExtentTestManager.getTest().log(LogStatus.PASS, "Product removed from cart");
			else
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Product not removed from cart");
		}
		else
			ExtentTestManager.getTest().log(LogStatus.INFO, "No Product IN cart");
	}
	public String getProductColour_Cart()
	{
		String ProductColour = driver.getText(ShoppingBag.txtProductColour, "Get Product Colour");
		return ProductColour;
	}
	public String getProductSize_Cart()
	{
		String ProductSize = driver.getText(ShoppingBag.txtProductSize, "Get Product Size");
		return ProductSize;
	}
	public void sKUComparison(String Colour, String Size, String CartColour, String CartSize)
	{
		if(driver.compareStrings(Colour, CartColour, "PDP and Cart product Comparison"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "PDP and Cart products Colour are Same");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "PDP and Cart products Colour are Different");
		if(driver.compareStrings(Size, CartSize, "PDP and Cart product Comparison"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "PDP and Cart products Size are Same");
			
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "PDP and Cart products Size are Different");
	}
	public void cartPriceValidation()
	{
		driver.scrollToElement(ShoppingBag.EstimatedShipping, "Scrolling");
		if(driver.isElementDisplayed(ShoppingBag.EstimatedShipping, 20, "Estimated Shipping"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Estimated Shipping Displayed");
		
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Estimated Shipping Not Displayed");
		if(driver.isElementDisplayed(ShoppingBag.DDShippingMethod, 20, "Shipping Method"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Shipping Method Displayed");
		
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Shipping Method");
		if(driver.isElementDisplayed(ShoppingBag.txtZipCode, 20, "Zip Code"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Zip Code Displayed");
		
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Zip Code Not Displayed");
		if(driver.isElementDisplayed(ShoppingBag.eleItemTotal, 20, "Item Total"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Item Total Displayed");
		
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Item Total Not Displayed");
		if(driver.isElementDisplayed(ShoppingBag.eleEstimatedShipping, 20, "Estimated Shipping"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Estimated Shipping Displayed");
		
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Estimated Shipping Not Displayed");
		if(driver.isElementDisplayed(ShoppingBag.eleEstimatedTax, 20, "Estimated Tax"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Estimated Tax Displayed");
		
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Estimated Tax Not Displayed");
		if(driver.isElementDisplayed(ShoppingBag.eleEstimatedTotal, 20, "Estimated Total"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Estimated Total Displayed");
		
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Estimated Total Not Displayed");
	}

	public String saveforlater()
	{
		
		driver.isElementDisplayed(ShoppingBag.saveforlater, 15, "Saveforlater");
		driver.clickElement(ShoppingBag.saveforlater, "Saveforlater clicked");
		
		driver.explicitWaitforVisibility(ShoppingBag.saveditems, 15, "Saveditems");
		driver.explicitWaitforVisibility(ShoppingBag.savedproduct, 15, "Savedproduct");
		ExtentTestManager.getTest().log(LogStatus.PASS, "Product Added To Saved for later");
		String productnameinsaved = driver.getText(ShoppingBag.savedproductname, "saveditemname");
		return productnameinsaved;
	}
	
	public void compare(String productnameinsaved, String PrdNameinCart)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, "Actual: "+productnameinsaved);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Expected: "+PrdNameinCart);
		if(productnameinsaved.contains(PrdNameinCart))
		{
			ExtentTestManager.getTest().log(LogStatus.PASS, "Product Name is same");
		}
		else
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Product Name is not same");
		}
	}
	
	public void backToUSShipping()
	{	
		if(driver.isElementPresent(ShoppingBag.backToUSshipping, "BackToUSShipping"))
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "BackToUSShipping is present");
			driver.scrollToElement(ShoppingBag.backToUSshipping, "BackToUSShipping");
			driver.clickElement(ShoppingBag.backToUSshipping, "BackToUSShipping");
			driver.explicitWaitforVisibility(ShoppingBag.ProductInCart, 30, "Wating for cart page");
			if(driver.isElementPresent(ShoppingBag.backToUSshipping, "BackToUSShipping"))
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "BackToUSShipping is not done");
			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "BackToUSShipping is done");
			}		
		}
		else
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "BackToUSShipping is not present");
		}
	}
	
	
	
	public void isCartDisplayed()
	{
		driver.isElementDisplayed(ShoppingBag.CartProducts, 20, "IS Cart page products is displayed");
		if(driver.isElementDisplayed(ShoppingBag.CartPage, 20, "Is Cart page Displayed"))
		{
			ExtentTestManager.getTest().log(LogStatus.PASS, "Cart page is displayed");
		}
		else
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Cart page is not displayed");
		}
	}
		
	public void cartQtyIncrement() throws InterruptedException
	{
		if(driver.isElementDisplayed(ShoppingBag.productQty, 20, "Is product QTY Displayed"))
		{
			ExtentTestManager.getTest().log(LogStatus.PASS, "product QTY is displayed");
			driver.enterText(ShoppingBag.productQty, "2", "Increment Product QTY to 2");
			driver.isElementDisplayed(ProductDetailPage.btnAddToBag, 30, "Wait");
			//Thread.sleep(6000);
			driver.isElementDisplayed(ShoppingBag.productQty, 30, "Cart loading overview");
			//driver.explicitWaitforVisibility(ShoppingBag.productQty, 10,"Cart loading overview");
			//driver.isElementNotDisplayed(ShoppingBag.CartLoadingOverView, "Cart loading overview");
		}
		else
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "product QTY  is not displayed");
		}
	}
	
	public void cartQtyDecrement() throws InterruptedException
	{
		if(driver.isElementDisplayed(ShoppingBag.productQty, 20, "Is product QTY Displayed"))
		{
			ExtentTestManager.getTest().log(LogStatus.PASS, "product QTY is displayed");
			driver.enterText(ShoppingBag.productQty, "1", "Decrement Product QTY to 1");
			driver.isElementDisplayed(ProductDetailPage.btnAddToBag, 30, "Wait");
		//	Thread.sleep(6000);
			driver.isElementDisplayed(ShoppingBag.productQty, 30, "Cart loading overview");
		}
		else
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "product QTY  is not displayed");
		}
	}
	
	public float totalPriceCheck()
	{
		if(driver.isElementDisplayed(ShoppingBag.ItemTotalPrice, 20, "Is Item total price is displayed"))
		{
			ExtentTestManager.getTest().log(LogStatus.PASS, "Item total price is displayed");
			String price=driver.getText(ShoppingBag.ItemTotalPrice, "Item toal price fetch").replace("$","");
			//System.out.println(price+"dsfsdfds");
			//System.out.println(price);
			float amt=Float.parseFloat(price);
			return amt;
		}
		else
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "product QTY  is not displayed");
			return 0;
		}
	}
	
	public float productPriceCheck()
	{
		
		if(driver.isElementDisplayed(ShoppingBag.productPrice, 20, "Is product price Displayed"))
		{
			ExtentTestManager.getTest().log(LogStatus.PASS, "product price is displayed");
			String price=driver.getText(ShoppingBag.productPrice, "product price fetch");
			float amt=Float.parseFloat(price);
			ExtentTestManager.getTest().log(LogStatus.PASS, "product price:"+amt+"");
			return amt;
		
		}
		else
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "product QTY  is not displayed");
			return 0;
		}
	}
	
	
	public void priceCheck(float act,float exp,float prod,String inc_dec)
	{
		if(inc_dec.equalsIgnoreCase("increment"))
		{
			float discount=0;
			if(driver.isElementDisplayed(ShoppingBag.ProductDiscount, 10, "Discount for product"))
			{
				discount=Float.parseFloat(driver.getText(ShoppingBag.ProductDiscount, "Get discount price"));
			}
			float expected=act*2;
			if(expected==exp)
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "Total price is updated on inrementing the qty");
			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Total price is not updated on inrementing the qty");
			}
			float Prod_expected=(prod*2)-discount;
			driver.explicitWaitforVisibility(ShoppingBag.productExdPrice, 20, "product price");
			String pro_price=driver.getText(ShoppingBag.productExdPrice, "product price fetch");
			float Prod_actulal=Float.parseFloat(pro_price);
			if(Prod_expected==Prod_actulal)
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "product price is updated in the product section");
			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "product price is not updated in the product section");
			}
			
		}
		else if(inc_dec.equalsIgnoreCase("decrement"))
		{
			float discount=0;
			if(driver.isElementDisplayed(ShoppingBag.ProductDiscount, 10, "Discount for product"))
			{
				discount=Float.parseFloat(driver.getText(ShoppingBag.ProductDiscount, "Get discount price"));
			}
			float expected=act/2;
			if(expected==exp)
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "Total price is updated on decrementing the qty");
			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Total price is not updated on decrementing the qty");
			}
			float Prod_expected=prod-discount;
			driver.explicitWaitforVisibility(ShoppingBag.productExdPrice, 20, "product price");
			String pro_price=driver.getText(ShoppingBag.productExdPrice, "product price fetch");
			float Prod_actulal=Float.parseFloat(pro_price);
			if(Prod_expected==Prod_actulal)
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "product price is updated in the product section");
			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "product price is not updated in the product section");
			}
		}	
	}

}
