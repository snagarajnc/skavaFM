package com.skava.object.repository;

import org.openqa.selenium.By;

public class SearchPage {
	public static final By Searchclosebtn = By.className("sk_mobCross");
	public static final By SearchResultName = By.xpath("//*[@class=\'skMob_prodCatTitle\']/span/h1");
	public static final By SearchprdCount = By.className("skMob_ProductCountVal");
}
