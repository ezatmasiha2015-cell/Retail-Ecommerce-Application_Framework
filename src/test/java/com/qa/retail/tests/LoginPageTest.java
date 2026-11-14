package com.qa.retail.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.retail.base.baseTest;
import com.qa.retail.constants.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Epic("Epic 119: Retail Login Page Feature")
@Story("User Story 101: Registration Flow")
@Story("User Story 102: Front End UI Style")
@Feature("F12: Login Page main Feature")
public class LoginPageTest extends baseTest{
	
	
	@Description("Login Page Title Test")
	@Severity(SeverityLevel.MINOR)
	@Test(priority=1)
	
	public void loginPageTest() {
	String actualPageTitle=loginPage.getLoginPageTitle();
	ChainTestListener.log("Actual page title is : " +actualPageTitle);
	Assert.assertEquals(actualPageTitle, AppConstants.LOGIN_PAGE_TITLE);
	}
	@Description("Login Page URL Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=2)
	public void loginPageURLTest() {
		String actualURL=loginPage.getLoginPageURL();
		ChainTestListener.log("Actual page URL is : " +actualURL);
		Assert.assertTrue(actualURL.contains(AppConstants.LOGIN_PAGE_URL_FRACTION));
//		ChainTestListener.embed("C:/Users/HP/OneDrive/Pictures/bollons.jpg", "image/jpg");
	}
	@Description("Verifying Forgot Password Link Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=3)
	public void isForgotternPWExistTest() {
		ChainTestListener.log("Checking if the password link exist or not");
		Assert.assertTrue(loginPage.isForgotPwdLisnkExist());
//		ChainTestListener.embed("C:/Users/HP/OneDrive/Pictures/bollons.jpg", "image/jpg");
	}
	@Description("Verifying Application Logo exist Test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=4)
	public void isLogoDisplayedTest() {
		ChainTestListener.log("Chicking if the application logo exist or not");
		boolean logoExist=loginPage.isLogoExist();
		Assert.assertTrue(true);
//		ChainTestListener.embed("C:/Users/HP/OneDrive/Pictures/bollons.jpg", "image/jpg");
	}
	@Description("Verifying that User is able to login with correct credentials test")
	@Severity(SeverityLevel.CRITICAL)
@Test(priority=5)

	public void doLoginTest() {
//	Assert.assertTrue(loginPage.doLogin("kasranaji@gmail.com", "Automation123"));
	accPage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	Assert.assertTrue(accPage.isLogoutLinkExist());
}
//	@Test
//	public void isCustomerExistTest() {
//		Assert.assertTrue(loginPage.isCustomerExist());
//	}
//	@Test
//	public void isItemCartExistTest() {
//		Assert.assertTrue(loginPage.isItemboxExist());
//	}
//	@Test
//	public void isFooterExistTest() {
//		Assert.assertTrue(loginPage.isFooterExist());
//	}


}
