package com.qa.retail.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.retail.base.baseTest;

import co.qa.retail.constants.AppConstants;
import co.qa.retail.pages.AccountsPage;

public class AccountsPageTest extends baseTest{
	
	
	@BeforeClass
	public void accsetup() {
		accPage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		
		
	}
	@Test(priority=1)
	public void accPageTitleTest() {
//		String actPageTitle=accPage.getAccPageTitle();
//		Assert.assertEquals("actPageTitle", "My Account");
		Assert.assertEquals(accPage.getAccPageTitle(),AppConstants.ACCOUNT_PAGE_TITLE);
	}
	@Test(priority=2)
	public void accPageURLTest() {
		Assert.assertTrue(accPage.getAccPageURL().contains(AppConstants.ACCOUNT_PAGE_URL_FRACTION));
	}
	@Test(priority=3)
	public void isLogoutLinkTest() {
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}
	@Test(priority=4)
	public void isSearchFieldExistTest() {
		Assert.assertTrue(accPage.isSearchFieldExist());
	}
	@Test(priority=5)
	public void accPageHeadersCountTest() {
		Assert.assertEquals(accPage.getAccountPageHearders().size(), AppConstants.ACCOUNT_PAGE_HEADERS_COUNT);
	}
	@Test (priority=6)
	public void accPageHeadersTest() {
		List<String>actAccPageHeadersList=accPage.getAccountPageHearders();
		System.out.println(actAccPageHeadersList);
		Assert.assertEquals(actAccPageHeadersList, AppConstants.ACCOUNTS_PAGE_HEADERS_LIST);
	}
	@Test(priority=7)
	public void searchTest() {
		searchResultPage=accPage.doSearch("MacBook");
	productInfoPage=searchResultPage.selectProduct("MacBook Pro");
	String actProductHeader=productInfoPage.getProductHeaderName();
	Assert.assertEquals(actProductHeader, "MacBook Pro");
		
		
	}
	
}







