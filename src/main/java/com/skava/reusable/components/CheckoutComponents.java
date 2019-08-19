package com.skava.reusable.components;

import com.framework.reporting.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
import com.skava.frameworkutils.ExcelReader;
import com.skava.object.repository.CheckoutPage;
import com.skava.object.repository.GuestCheckoutPage;
import com.skava.object.repository.LoginPage;
import com.skava.object.repository.ProductDetailPage;

public class CheckoutComponents extends GeneralComponents{
	public void clickGuestCheckout()
	{
		if(driver.isElementDisplayed(CheckoutPage.btnGuestCheckout,20, "Guest Checkout"))
		{
			ExtentTestManager.getTest().log(LogStatus.PASS, "Guest Checkout Button is displayed");
			if(driver.scrollToElement(CheckoutPage.btnGuestCheckout, "Guest Checkout") && driver.clickElement(CheckoutPage.btnGuestCheckout, "Guest Checkout"))
				ExtentTestManager.getTest().log(LogStatus.PASS, "Guest Checkout Button Clicked");
			else
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Guest Checkout Button Not Clicked");
			/*if(driver.isElementDisplayed(CheckoutPage.GuestCheckoutShippingPage,30, "Guest Checkout"))
				ExtentTestManager.getTest().log(LogStatus.PASS, "Guest Checkout Shipping Page Displayed");
			else
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Guest Checkout Shipping Page Not Displayed");*/
		}
		else
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Guest Checkout Button Not displayed");
		}
	}
	public void guestCheckoutValidation()
	{
		if(driver.isElementDisplayed(GuestCheckoutPage.txtWelcomeMsg, 30, "Welcome Guest MSG"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Welcome Guest MSG is displayed in Guest Checkout");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Welcome Guest MSG is not displayed in Guest Checkout");
		if(driver.isElementDisplayed(GuestCheckoutPage.ShippingBillingField, 10, "Shipping & Billing "))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Shipping & Billing is displayed in Guest Checkout");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Shipping & Billing is not displayed in Guest Checkout");
		driver.scrollToElement(GuestCheckoutPage.btnContinuePayment, "Scrolling");
		if(driver.isElementDisplayed(GuestCheckoutPage.btnContinuePayment, 10, "Continue Payment"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Continue Payment is displayed in Guest Checkout");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Continue Payment is not displayed in Guest Checkout");
	}
	/*public void enterShippingAddrs()
	{
		try
		{
		driver.enterText(GuestCheckoutPage.txtFirstNameField, ExcelReader.getData("General_Data", "FirstName"), "FirstName");
		driver.enterText(GuestCheckoutPage.txtLastNameField, ExcelReader.getData("General_Data", "SecondName"), "SecondName");
		driver.enterText(GuestCheckoutPage.txtAddrs1Field, ExcelReader.getData("General_Data", "Address1"), "Address 1");
		driver.enterText(GuestCheckoutPage.txtAddrs2Field, ExcelReader.getData("General_Data", "Address2"), "Address 2");
		driver.enterText(GuestCheckoutPage.txtCityField, ExcelReader.getData("General_Data", "City"), "City");
		driver.enterText(GuestCheckoutPage.txtPostalCode, ExcelReader.getData("General_Data", "PostalCode"), "Postal Code");
		driver.scrollToElement(GuestCheckoutPage.txtPostalCode, "Scrolling");
		driver.enterText(GuestCheckoutPage.txtPhoneNum, ExcelReader.getData("General_Data", "PhoneNumber"), "PhoneNumber");
		driver.enterText(GuestCheckoutPage.txtMailAddrs, ExcelReader.getData("General_Data", "Mail_Address"), "Mail Address");
		}
		catch(Throwable XX)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Entering Shipping Details Failed");
		}
	}*/
	
	public void enterShippingAddrs()
	{
		try
		{
		String[] CellData= ExcelReader.getData("General_Data", "Username").split("\n");
		driver.enterText(GuestCheckoutPage.txtFirstNameField, CellData[0], "FirstName");
		driver.enterText(GuestCheckoutPage.txtLastNameField,CellData[1], "SecondName");
		driver.enterText(GuestCheckoutPage.txtAddrs1Field, CellData[2], "Address 1");
		driver.enterText(GuestCheckoutPage.txtAddrs2Field, CellData[3], "Address 2");
		driver.enterText(GuestCheckoutPage.txtCityField, CellData[4], "City");
		int state=Integer.parseInt(CellData[5]);
		driver.clickRandomElement(GuestCheckoutPage.GuestShipStateDropDown, state, "Select state from dropdown");
		driver.scrollToElement(GuestCheckoutPage.txtPostalCode, "Scrolling");
		driver.enterText(GuestCheckoutPage.txtPostalCode, CellData[6], "Postal Code");
			
		
		driver.enterText(GuestCheckoutPage.txtPhoneNum, CellData[7], "PhoneNumber");
		driver.enterText(GuestCheckoutPage.txtMailAddrs, CellData[8], "Mail Address");
		}
		catch(Throwable XX)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Entering Shipping Details Failed");
		}
	}
	public void clickContinuePayment()
	{
		if(driver.clickElement(GuestCheckoutPage.btnContinuePayment, "Conitnue Payment Clicked"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Conitnue Payment Clicked Checkout");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Conitnue Payment not Clicked Checkout");
	}
	/*public void addressVerification()
	{
		if(driver.isElementDisplayed(GuestCheckoutPage.VerifyAddrsFiled, 20, "Address Verification"))
		{
			driver.clickElement(GuestCheckoutPage.btnUseAsEntry, "Clicked OK");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Address Verification done Checkout");
		}
		else
			ExtentTestManager.getTest().log(LogStatus.INFO, "Address Verification not done Checkout");
	}*/
	
	public void addressVerification() throws InterruptedException
	{
		if(driver.isElementDisplayed(GuestCheckoutPage.VerifyAddrsFiled, 20, "Address Verification"))
		{
			ExtentTestManager.getTest().log(LogStatus.PASS, "Address Verification displayed in Checkout");
			driver.scrollToElement(GuestCheckoutPage.btnUseAsEntry, "Clicked use as entered in address verification overlay");
			driver.isElementDisplayed(ProductDetailPage.btnAddToBag,10, "wait"); 
			if(driver.isElementDisplayed(GuestCheckoutPage.btnUseAsEntry,20, "Clicked OK") 
					&& driver.clickElement(GuestCheckoutPage.btnUseAsEntry, "Clicked OK"))
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "Address Verification use as entered button is clicked ");
			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Address Verification use as entered button is not clicked ");
			}
		
		}
		else
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "Address Verification not displayed Checkout");
		}
			
	}
	public void paymentPageValidation()
	{
		if(driver.isElementDisplayed(GuestCheckoutPage.PaymentHeader, 20, "Place Order Page"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Place Order Page loaded in Checkout");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Place Order Page not loaded Checkout");
	}
	/*public void enterPaymentDetailsOld()
	{
		if(driver.isElementDisplayed(GuestCheckoutPage.PaymentHeader, 20, "Payment Details"))
		{
			try
			{
				driver.SelectDropDown(GuestCheckoutPage.DDCCTypeField, 4, "Select Month");
				driver.enterText(GuestCheckoutPage.txtCCNUMField, ExcelReader.getData("General_Data", "CC_NUM"), "Enter CC Num");
				driver.SelectDropDown(GuestCheckoutPage.DDMonthField, 5, "Select Month");
				driver.SelectDropDown(GuestCheckoutPage.DDYearField, 3, "Select Year");
				driver.enterText(GuestCheckoutPage.txtSecurityField, ExcelReader.getData("General_Data", "CVV"), "Enter CVV Num");
			}
			catch(Throwable YY)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to enter Payment Details Checkout");
			}
		}
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Payment not loaded Checkout");
	}*/
		
	
	public void enterPaymentDetails()
	{
		if(driver.isElementDisplayed(GuestCheckoutPage.PaymentSection, 20, "Payment Details"))
		{
			try
			{
				String CellVall[]=ExcelReader.getData("General_Data", "Password").split("\n");
				//driver.SelectDropDown(GuestCheckoutPage.DDCCTypeField, 4, "Select Month");
				driver.clickRandomElement(GuestCheckoutPage.DDCCTypeField, 4, "Select Visa");
				//driver.SelectDropDown(GuestCheckoutPage.DDCCTypeField, 4, "Select Month");
				driver.enterText(GuestCheckoutPage.txtCCNUMField,CellVall[0], "Enter Credit card  Number");
				driver.enterText(GuestCheckoutPage.txtCCNameField, CellVall[1], "Enter Credit card name");
				//driver.SelectDropDown(GuestCheckoutPage.DDMonthField, 5, "Select Month");
				//driver.SelectDropDown(GuestCheckoutPage.DDYearField, 3, "Select Year");
				driver.clickRandomElement(GuestCheckoutPage.DDMonthField, 4, "Select moth");
				driver.clickRandomElement(GuestCheckoutPage.DDYearField ,4, "Select year");
				driver.enterText(GuestCheckoutPage.txtSecurityField, CellVall[2], "Enter CVV Num");
			}
			catch(Throwable YY)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to enter Payment Details Checkout");
			}
		}
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Payment not loaded Checkout");
	}
	
	
	public void clickContinueCheckout()
	{
		driver.scrollToElement(GuestCheckoutPage.btnContinueCheckout, "Verify Card Detail");
	}

	public void clickConfirmationOrder()
	{
		driver.scrollToElement(GuestCheckoutPage.btncontinueconfirm, "Scrolling");
		if(driver.clickElement(GuestCheckoutPage.btncontinueconfirm, "ConfirmOrder"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Confirmation Order loaded Checkout");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Confirmation Order not loaded Checkout");
	}
	public void placeOrderVerification()
	{
		if(driver.isElementDisplayed(CheckoutPage.btnPlaceOrderNow, 20, "Place Order Page"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Place Order Page loaded in Checkout");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Place Order Page not loaded Checkout");
		if(driver.isElementDisplayed(CheckoutPage.productField, 10, "Product Field in Checkout"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Product Field loaded in Checkout");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Product Field not loaded Checkout");
	}
	public void returnCustomer()
	{
		if(driver.isElementDisplayed(CheckoutPage.btnGuestCheckout, 50, "Guest Checkout"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Guest Checkout Displayed");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Guest Checkout Not Displayed");
		if(driver.isElementDisplayed(LoginPage.btnLogInCheckout, 30, "User Sign IN"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "User Sign IN Displayed");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "User Sign IN Not Displayed");
	}
	public void reviewOrderValidation()
	{
		if(driver.isElementDisplayed(CheckoutPage.eleReviewOrder, 40, "Review Order Page"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Review Order Page Displayed");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Review Order Page Not Displayed");
		if(driver.isElementDisplayed(CheckoutPage.eleBillingAddrssField, 10, "Billing Addrs field in Review Order Page"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Billing Addrs field Displayed");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Billing Addrs field Not Displayed");
		if(driver.isElementDisplayed(CheckoutPage.elePaymentField, 10, "Payment field in Review Order Page"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Payment field Displayed");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Payment field Not Displayed");
		driver.scrollToElement(CheckoutPage.eleShippingAddrssField, "Scrolling");
		if(driver.isElementDisplayed(CheckoutPage.eleShippingAddrssField, 10, "Shipping Addrs field in Review Order Page"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Shipping Addrs field Displayed");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Shipping Addrs field Not Displayed");
		if(driver.isElementDisplayed(CheckoutPage.eleOrderSummary, 10, "Order Summary field in Review Order Page"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Order Summary field Displayed");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Order Summary field Not Displayed");
		if(driver.isElementDisplayed(CheckoutPage.btnPlaceOrder, 10, "Place Order"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Place Order Displayed");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Place Order Not Displayed");
	}
	
	 public void isShippingPageDisplayed()
	{
		if(driver.isElementDisplayed(GuestCheckoutPage.GuestShippingPage, 40, "Guest checkout shipping screen is displayed on tapping guest chekout button"))
		{
			ExtentTestManager.getTest().log(LogStatus.PASS, "Guest checkout shipping screen is displayed on tapping guest chekout button");
		}
		else
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Guest checkout shipping screen is not displayed on tapping guest chekout button");
		}
	}
		
		public void isBillingPageDisplayed()
		{
			if(driver.isElementDisplayed(GuestCheckoutPage.GuestBillingPage, 40, "Guest checkout billing screen is displayed on tapping Continue chekout button in shipping screen"))
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "Guest checkout billing screen is displayed on tapping Continue chekout button in shipping screen");
			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Guest checkout billing screen is not displayed on tapping Continue chekout button in shipping screen");
			}
		}
		
		
		public void guest_EnterShippingAddrs(String Billing)
		{
			try
			{
			String[] CellData= ExcelReader.getData("General_Data", "Username").split("\n");
			driver.enterText(GuestCheckoutPage.txtFirstNameField, CellData[0], "FirstName");
			driver.enterText(GuestCheckoutPage.txtLastNameField,CellData[1], "SecondName");
			driver.enterText(GuestCheckoutPage.txtAddrs1Field, CellData[2], "Address 1");
			driver.enterText(GuestCheckoutPage.txtAddrs2Field, CellData[3], "Address 2");
			driver.enterText(GuestCheckoutPage.txtCityField, CellData[4], "City");
			int state=Integer.parseInt(CellData[5]);
			driver.clickRandomElement(GuestCheckoutPage.GuestShipStateDropDown, state, "Select state from dropdown");
			driver.scrollToElement(GuestCheckoutPage.txtPostalCode, "Scrolling");
			driver.enterText(GuestCheckoutPage.txtPostalCode, CellData[6], "Postal Code");
			if(Billing.equalsIgnoreCase("Untickbill"))
			{
			driver.clickElement(GuestCheckoutPage.MakeDefaultBill, "Untick default billing option");
			}
			
			
			driver.enterText(GuestCheckoutPage.txtPhoneNum, CellData[7], "PhoneNumber");
			driver.enterText(GuestCheckoutPage.txtMailAddrs, CellData[8], "Mail Address");
			}
			catch(Throwable XX)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Entering Shipping Details Failed");
			}
		}
		
		public void payment_ScreenCheck()
		{
			if(driver.isElementDisplayed(GuestCheckoutPage.PaymentSection, 30, "Payment section"))
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "Payment section is displayed");
				if(driver.isElementDisplayed(GuestCheckoutPage.GuestPaymentCardSection, 30, "Payment section"))
				{
					ExtentTestManager.getTest().log(LogStatus.PASS, "Payment  credit card section is displayed");
				}
				else
				{
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Payment  credit card section is not displayedd");
				}
				
				if(driver.scrollToElement(GuestCheckoutPage.GuestPaymentGiftSection, "scroll to gift section") &&
						driver.isElementDisplayed(GuestCheckoutPage.GuestPaymentGiftSection, 5, "Payment gift card section"))
				{
					ExtentTestManager.getTest().log(LogStatus.PASS, "Payment gift card section is displayed");
				}
				else
				{
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Payment gift card section is not displayedd");
				}
				
				if(driver.scrollToElement(GuestCheckoutPage.GuestPaymentPromoSection, "scroll to promo code section") &&
						driver.isElementDisplayed(GuestCheckoutPage.GuestPaymentPromoSection, 5, "Payment promo code section"))
				{
					ExtentTestManager.getTest().log(LogStatus.PASS, "Payment promo code section is displayed");
				}
				else
				{
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Payment promo code section is not displayedd");
				}
				
				if(driver.scrollToElement(GuestCheckoutPage.GuestPaymentAccountSection, "scroll to create account section") &&
						driver.isElementDisplayed(GuestCheckoutPage.GuestPaymentAccountSection, 5, "Payment create account section"))
				{
					ExtentTestManager.getTest().log(LogStatus.PASS, "Payment create account section is displayed");
				}
				else
				{
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Payment create account section is not displayedd");
				}
			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Payment section is not displayedd");
			}
		}
		
		public void payment_FieldCheck()
		{
			if(driver.isElementDisplayed(GuestCheckoutPage.PaymentSection, 30, "Payment section"))
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "Payment section is displayed");
				if(driver.isElementDisplayed(GuestCheckoutPage.GuestPaymentCardSection, 30, "Payment section"))
				{
					ExtentTestManager.getTest().log(LogStatus.PASS, "Payment  credit card section is displayed");
					
					if(driver.isElementDisplayed(GuestCheckoutPage.DDCCTypeField, 5, "Payment type"))
					{
						ExtentTestManager.getTest().log(LogStatus.PASS, "Payment  type field  is displayed");
					}
					else
					{
						ExtentTestManager.getTest().log(LogStatus.FAIL, "Payment type field is not displayed");
					}
					if(driver.isElementDisplayed(GuestCheckoutPage.txtCCNUMField, 5, "Card no "))
					{
						ExtentTestManager.getTest().log(LogStatus.PASS, "Card no field  is displayed");
					}
					else
					{
						ExtentTestManager.getTest().log(LogStatus.FAIL, "Card no  field is not displayed");
					}
					if(driver.isElementDisplayed(GuestCheckoutPage.txtCCNameField, 5, "Card name "))
					{
						ExtentTestManager.getTest().log(LogStatus.PASS, "Card name field  is displayed");
					}
					else
					{
						ExtentTestManager.getTest().log(LogStatus.FAIL, "Card name  field is not displayed");
					}
					if(driver.isElementDisplayed(GuestCheckoutPage.DDMonthField, 5, "Card  exp month"))
					{
						ExtentTestManager.getTest().log(LogStatus.PASS, "Card exp month field  is displayed");
					}
					else
					{
						ExtentTestManager.getTest().log(LogStatus.FAIL, "Card exp month  field is not displayed");
					}
					if(driver.isElementDisplayed(GuestCheckoutPage.DDYearField, 5, "Card  exp year"))
					{
						ExtentTestManager.getTest().log(LogStatus.PASS, "Card exp year field  is displayed");
					}
					else
					{
						ExtentTestManager.getTest().log(LogStatus.FAIL, "Card exp year  field is  not displayed");
					}
					if(driver.isElementDisplayed(GuestCheckoutPage.txtSecurityField, 5, "Card  CVV"))
					{
						ExtentTestManager.getTest().log(LogStatus.PASS, "Card CVV field  is displayed");
					}
					else
					{
						ExtentTestManager.getTest().log(LogStatus.FAIL, "Card CVV  field is not displayed");
					}
				}
				else
				{
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Payment  credit card section is not displayedd");
				}
				
				if(driver.scrollToElement(GuestCheckoutPage.GuestPaymentGiftSection, "scroll to gift section") &&
						driver.isElementDisplayed(GuestCheckoutPage.GuestPaymentGiftSection, 5, "Payment gift card section"))
				{
					ExtentTestManager.getTest().log(LogStatus.PASS, "Payment gift card section is displayed");
					if(driver.isElementDisplayed(GuestCheckoutPage.PaymentGiftno, 5, "Gift Card No"))
					{
						ExtentTestManager.getTest().log(LogStatus.PASS, "Gift Card No field  is displayed");
					}
					else
					{
						ExtentTestManager.getTest().log(LogStatus.FAIL, "Gift Card No field is displayed");
					}
					if(driver.isElementDisplayed(GuestCheckoutPage.PaymentGiftPin, 5, "Gift Card Pin"))
					{
						ExtentTestManager.getTest().log(LogStatus.PASS, "Gift Card Pin field  is displayed");
					}
					else
					{
						ExtentTestManager.getTest().log(LogStatus.FAIL, "Gift Card Pin  field is displayed");
					}
				}
				else
				{
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Payment gift card section is not displayedd");
				}
				
				if(driver.scrollToElement(GuestCheckoutPage.GuestPaymentPromoSection, "scroll to promo code section") &&
						driver.isElementDisplayed(GuestCheckoutPage.GuestPaymentPromoSection, 5, "Payment promo code section"))
				{
					ExtentTestManager.getTest().log(LogStatus.PASS, "Payment promo code section is displayed");
					if(driver.isElementDisplayed(GuestCheckoutPage.PaymentPromo, 5, "Promo code field"))
					{
						ExtentTestManager.getTest().log(LogStatus.PASS, "Promo code field  is displayed");
					}
					else
					{
						ExtentTestManager.getTest().log(LogStatus.FAIL, "Promo code  field is displayed");
					}
					
				}
				else
				{
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Payment promo code section is not displayedd");
				}
				
				if(driver.scrollToElement(GuestCheckoutPage.GuestPaymentAccountSection, "scroll to create account section") &&
						driver.isElementDisplayed(GuestCheckoutPage.GuestPaymentAccountSection, 5, "Payment create account section"))
				{
					ExtentTestManager.getTest().log(LogStatus.PASS, "Payment create account section is displayed");
					if(driver.isElementDisplayed(GuestCheckoutPage.PaymentAccPass, 5, "Account password field"))
					{
						ExtentTestManager.getTest().log(LogStatus.PASS, "Account password field  is displayed");
					}
					else
					{
						ExtentTestManager.getTest().log(LogStatus.FAIL, "Account password  field is displayed");
					}
					if(driver.isElementDisplayed(GuestCheckoutPage.PaymentAccConfPass, 5, "Account confirm password field"))
					{
						ExtentTestManager.getTest().log(LogStatus.PASS, "Account confirm password field  is displayed");
					}
					else
					{
						ExtentTestManager.getTest().log(LogStatus.FAIL, "Account confirm password field is displayed");
					}
					if(driver.isElementDisplayed(GuestCheckoutPage.PaymentAccPassHint, 5, "Account password hint field"))
					{
						ExtentTestManager.getTest().log(LogStatus.PASS, "Account password hint field  is displayed");
					}
					else
					{
						ExtentTestManager.getTest().log(LogStatus.FAIL, "Account password hint field is displayed");
					}
				}
				else
				{
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Payment create account section is not displayedd");
				}
			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Payment section is not displayedd");
			}
		}
		
		public void continueCheckoutClick()
		{
			if(driver.isElementDisplayed(GuestCheckoutPage.ContinueCheckout,10, "Is Continue Checkout Button displayed"))
			{
				
				ExtentTestManager.getTest().log(LogStatus.PASS, "Continue checkout button is displayed");
				driver.scrollToElement(GuestCheckoutPage.ContinueCheckout, "Scroll to Continue Checkout Button");
				if(driver.clickElement(GuestCheckoutPage.ContinueCheckout, "Click Continue checkout button"))
				{
					ExtentTestManager.getTest().log(LogStatus.PASS, "Continue checkout button click successfull");
				}
				else
				{
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Continue checkout button click unsuccessfull");
				}
				
			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Continue checkout button is not displayed");
			}
		}

	
	
}
