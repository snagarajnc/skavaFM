package com.skava.framework.action;

import org.openqa.selenium.By;

public interface ActionEngine {

	public void maximizeBrowser();

	public void navigateToUrl(String url);

	public boolean enterText(By textField, String textValue,String elementName);

	public boolean clickElement(By buttonField,String elementName);
	
	public boolean ExecutorclickElement(By buttonField,String elementName);

	public Object findElement(By txtusername);

	public boolean isElementPresent(By elementPath, String elementName);

	public boolean compareElementText(By path, String expectedText,String elementName);

	public boolean explicitWaitforVisibility(By path, int seconds, String elementName);

	public boolean isElementDisplayed(By path, int seconds, String elementName);

	public boolean isElementDisplayedByRandom(By path, int seconds, int RandomValue, String elementName);

	public String getText(By path, String elementName);

	public String getTextRandom(By path, int RandomValue, String elementName);

	public String getElementAttribute(By path, String attrName,String elementName);

	public boolean compareElementAttribute(By path, String attrName, String expectedText,String elementName);

	public int generateRandomNumber(int limit);

	public int generateRandomNumberWithLimit(int maximum, int minimum);

	public boolean scrollToElement(By path, String elementName);

	public boolean isElementNotDisplayed(By path, String elementName);

	public boolean isElementEnabled(By path, String elementName);

	public void takeScreenShot(String elementName);

	boolean enterTextAndSubmit(By path, String value, String elementName);

	public void quit();

	void takeScreenshotWithPath(String path, String elementName);
	
	public void setsize();
	
	public int getsize(By path, String elementName);
	
	public boolean clickRandomElement(By path, int RandomValue, String elementName);
	
	public boolean scrollToRandomElement(By path, int RandomValue, String elementName);
	
	public String GetTextByRandom(By path, int RandomValue, String elementName);
	
	public boolean SelectDropDown(By path, int Value, String elementName);
	
	public boolean compareStrings(String toCompare, String toCompareWith, String elementName);
	
	public String getStringInBetween(String text, String textFrom, String textTo, String elementName);
	
	public String getBrowserURL(String elementName);
	
	public void navigateDriverBack();
	
	public boolean changeFrame(By path, String elementName);
	
	public boolean ToWindowHandle(By path ,String WindowTitle, String elementName);


}