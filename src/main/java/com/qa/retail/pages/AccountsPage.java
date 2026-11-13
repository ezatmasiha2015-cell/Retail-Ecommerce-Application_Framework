package com.qa.retail.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.retail.constants.AppConstants;
import com.qa.retail.utils.ElementUtils;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtils eleUtil;
	// locator repository
	private By logoutlink = By.xpath("//a[text()='Logout' and @class='list-group-item']");

	private By search = By.name("search");
	private By accHeaders = By.cssSelector("div#content >h1, div#content>h2");
	private By searchIcon=By.xpath("//button[@class='btn btn-light btn-lg']");

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil= new ElementUtils(this.driver);
	}
//	Page behaviors/ actions/ methods
	public String getAccPageTitle() {
		String actPageTitle=eleUtil.waitForTitleCompleteValue(AppConstants.ACCOUNT_PAGE_TITLE, AppConstants.MEDIUM_DEFAULT_WAIT);
		System.out.println("Account Page title is: "+ actPageTitle);
		return actPageTitle;
	}
	public String getAccPageURL() {
		String actPageURL=eleUtil.waitForURLContains(AppConstants.ACCOUNT_PAGE_URL_FRACTION, AppConstants.MEDIUM_DEFAULT_WAIT);
		System.out.println(actPageURL);
		return actPageURL;
		
	}
	public boolean isLogoutLinkExist() {
		return eleUtil.waitForVisibilityOfElement(logoutlink, AppConstants.MEDIUM_DEFAULT_WAIT).isDisplayed();
	}
	public void logout() {
		if(isLogoutLinkExist()) {
			eleUtil.doClick(logoutlink);
		}
	}
	public boolean isSearchFieldExist() {
		return eleUtil.waitForVisibilityOfElement(search, AppConstants.MEDIUM_DEFAULT_WAIT).isDisplayed();
	}
	public List<String> getAccountPageHearders() {
		List<WebElement> headersList=eleUtil.waitForVisibilityOfElements(accHeaders, AppConstants.MEDIUM_DEFAULT_WAIT);
		List<String >headerVlList=new ArrayList<>();
		for(WebElement e: headersList) {
			String Text=e.getText();
			headerVlList.add(Text);
		}
		return headerVlList;
	}
	public searchResultPage doSearch(String searchKey) {
		eleUtil.waitForVisibilityOfElement(search, AppConstants.MEDIUM_DEFAULT_WAIT).clear();
		eleUtil.waitForVisibilityOfElement(search, AppConstants.LONG_DEFAULT_WAIT).sendKeys(searchKey);
		eleUtil.doClick(searchIcon);
		return new searchResultPage(driver);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
