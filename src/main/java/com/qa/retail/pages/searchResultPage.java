package com.qa.retail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.retail.constants.AppConstants;
import com.qa.retail.utils.ElementUtils;

public class searchResultPage {
	private WebDriver driver;
	private ElementUtils eleUtil;
	
	
public searchResultPage(WebDriver driver) {
	
	this.driver=driver;
	eleUtil=new ElementUtils(this.driver);
}
 	By productNameLocator= By.xpath("(//a[text()='MacBook Pro'])[2]");
 	

public productInfoPage selectProduct(String productName) {
	eleUtil.waitForVisibilityOfElement(By.linkText(productName), AppConstants.LONG_DEFAULT_WAIT).click();
	return new productInfoPage(driver);
	
}


}
