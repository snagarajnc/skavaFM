package com.skava.reusable.components;

import com.framework.reporting.BaseClass;
import com.framework.reporting.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
import com.skava.frameworkutils.ExcelReader;
import com.skava.object.repository.CheckoutPage;
import com.skava.object.repository.HomePage;
import com.skava.object.repository.LoginPage;

public class LoginComponents extends CreateAccountComponents	 {
	
	public void enterLoginCredentials(){
		driver.enterText(LoginPage.txtEmailId,ExcelReader.getData("General_Data","Username"),"Email");
		driver.enterTextAndSubmit(LoginPage.txtPassword,ExcelReader.getData("General_Data","Password"),"Password" );
		ExtentTestManager.getTest().log(LogStatus.INFO, "Entered valid credentials");
	}
	public void enterLoginCredentials_Checkout(){
		driver.enterText(LoginPage.txtEmailIdCheckout,ExcelReader.getData("General_Data","Username"),"Email");
		driver.enterTextAndSubmit(LoginPage.txtPasswordCheckout,ExcelReader.getData("General_Data","Password"),"Password" );
		ExtentTestManager.getTest().log(LogStatus.INFO, "Entered valid credentials");
		
		if(driver.isElementPresent(CheckoutPage.eleReviewOrder, "Review Order Page"))
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "Entering valid credentials navigated to Review Order Page ");
		}
		else
		{
			clickCheckoutbutton();
		}		
	}
	public void verifyLoginSuccessful(){
		if(driver.isElementDisplayed(LoginPage.lblSignInSuccess, 40, "Login Success Message"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "User sucessfully logged in");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "User login failed");
	}
	
	public void closeLoginPopUp(){
		driver.clickElement(LoginPage.loginPopUpClose, "PopUpCloseIcon");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Login popup closed");
	}

	public void loginPageValidation()
	{
		if(driver.isElementDisplayed(LoginPage.SignINHeader, 20, "Sign IN Page Loaded"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Sign IN Page Opened");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Sign IN Page not Opened");
		if(driver.isElementDisplayed(LoginPage.txtEmailId, 5, "UserName"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Email Address field in Sign IN Page");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Email Address field not in Sign IN Page");
		if(driver.isElementDisplayed(LoginPage.txtPassword, 10, "PassWord"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Password field in Sign IN Page");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Password field not in Sign IN Page");
		if(driver.isElementDisplayed(LoginPage.btnLogIn, 10, "Sign In Button"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Sign IN button in Sign IN Page");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Sign IN button not in Sign IN Page");
	}
	public void logout()
	{
		if(driver.clickElement(LoginPage.btnSignOut, "Sign Out"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "User sucessfully logged out");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "User Not able to out");
	}
	public void accountValidation()
	{
		if(driver.clickElement(LoginPage.btnMyAccount, "MyAccount Page"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "MyAccount Page Clicked");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "MyAccount Page not Clicked");
		if(driver.clickElement(LoginPage.btnbckMainpage, "Back to Main Page"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Back To Main Page clicked");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Back To Main Page not clicked");
	}
	public void checkoutLogin()
	{
		if(driver.isElementDisplayed(LoginPage.CheckoutSignINOverlay, 30, "Sign IN Page Navigated"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Sign IN Page Navigated");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Sign IN Page Not Navigated");
	}
	
	public void checkoutPaypal()
	{
		if(driver.isElementDisplayed(LoginPage.paypalLogo, 60, "PayPal Page Navigated"))
			ExtentTestManager.getTest().log(LogStatus.PASS, "Paypal Page Navigated");
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Paypal Page Not Navigated");
	}
	
	public void myaccount()
	{		
		driver.isElementDisplayed(LoginPage.accountsummaryPage, 40, "My Account page displayed");
		ExtentTestManager.getTest().log(LogStatus.PASS, "My Account page displayed");
		driver.isElementPresent(LoginPage.accountname,"accountname");  
		ExtentTestManager.getTest().log(LogStatus.PASS, "accountname displayed");
	}
	
	public void myaccountAccordians()
	{
		
		driver.scrollToElement(LoginPage.accountsummary, "accountsummary");
		driver.isElementPresent(LoginPage.accountsummary,"accountsummary");  
		ExtentTestManager.getTest().log(LogStatus.PASS, "accountsummary accordion displayed");
		driver.isElementPresent(LoginPage.orderhistory,"orderhistory");  
		ExtentTestManager.getTest().log(LogStatus.PASS, "orderhistory accordion displayed");
		driver.isElementPresent(LoginPage.shippingaddress,"shippingaddress");  
		ExtentTestManager.getTest().log(LogStatus.PASS, "shippingaddress accordion displayed");
		driver.isElementPresent(LoginPage.billingaddress,"billingaddress");  
		ExtentTestManager.getTest().log(LogStatus.PASS, "billingaddress accordion displayed");
		driver.isElementPresent(LoginPage.payment,"payment");  
		ExtentTestManager.getTest().log(LogStatus.PASS, "payment accordion displayed");
		driver.isElementPresent(LoginPage.settings,"settings");  
		ExtentTestManager.getTest().log(LogStatus.PASS, "settings accordion displayed");
					
	}
	
	public void orderhistory()
	{
		driver.isElementDisplayed(LoginPage.orderhistory, 40, "Order history");
		driver.scrollToElement(LoginPage.orderhistory, "orderhistory");
		driver.clickElement(LoginPage.orderhistory,"orderhistory clicked"); 
		driver.isElementPresent(LoginPage.orderhistoryPage,"orderhistory Page");  
		ExtentTestManager.getTest().log(LogStatus.PASS, "On tapping orderhistory accordion Order History Page displayed");
	}	
	public void shippingaddress()
	{
		driver.isElementDisplayed(LoginPage.shippingaddress, 40, "shippingaddress");
		driver.scrollToElement(LoginPage.shippingaddress, "shippingaddress");
		driver.clickElement(LoginPage.shippingaddress,"shippingaddress clicked"); 
		driver.isElementPresent(LoginPage.shippingaddressPage,"shippingaddress Page");  
		ExtentTestManager.getTest().log(LogStatus.PASS, "On tapping Shippingaddress accordion Shippingaddress Page displayed");
	}
	public void billingaddress()
	{
		driver.isElementDisplayed(LoginPage.billingaddress, 40, "billingaddress");
		driver.scrollToElement(LoginPage.billingaddress, "billingaddress");
		driver.clickElement(LoginPage.billingaddress,"billingaddress clicked"); 
		driver.isElementPresent(LoginPage.billingaddressPage,"billingaddress");  
		ExtentTestManager.getTest().log(LogStatus.PASS, "On tapping billingaddress accordion Billingaddress Page displayed");
	}
	public void payment()
	{
		driver.isElementDisplayed(LoginPage.payment, 40, "payment");
		driver.scrollToElement(LoginPage.payment, "payment");
		driver.clickElement(LoginPage.payment,"payment clicked"); 
		driver.isElementPresent(LoginPage.paymentPage,"payment page");  
		ExtentTestManager.getTest().log(LogStatus.PASS, "On tapping payment accordion Payment page displayed");
	}	
	public void accountsettings()
	{
		driver.isElementDisplayed(LoginPage.settings, 40, "settings");
		driver.scrollToElement(LoginPage.settings, "settings");
		driver.clickElement(LoginPage.settings,"settings clicked"); 
		driver.isElementPresent(LoginPage.settingsPage,"settings page");  
		ExtentTestManager.getTest().log(LogStatus.PASS, "On tapping settings accordion Settings page displayed ");
	}
	
}
