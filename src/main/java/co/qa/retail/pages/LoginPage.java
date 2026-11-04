package co.qa.retail.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//
//public class LoginPage {
//	
//	//1: private webDriver driver reference
//	private WebDriver driver;
//	
//	//2: locators/ repositry; page object refpository 
//	// locator should be private -- access them public methods -- encapsulation
//	private By userName=By.id("input-email");
//	private By passwordId=By.id("input-password");
//	private By btnlogin=By.xpath("//button[text()='Login']");
//	private By forgotPwdlink=By.linkText("Forgotten Password");
//	private By logo= By.cssSelector("img.img-fluid");
//	// 3: page Constructor 
//	public LoginPage(WebDriver driver) {
//		this.driver=driver;
//		
//	}
//	// 4: page actions/ behavior/ methods
//	public String getLoginPageTitle() {
//		String title=driver.getTitle();
//		System.out.println("Login Page title is : "+ title);
//		return title;
//		
//	}
//	public String getLoginPageURL() {
//		String url=driver.getCurrentUrl();
//		System.out.println("Login Page URL is : "+ url);
//		return url;
//	}
//	public boolean isForgotPwdLisnkExist() {
//		return driver.findElement(forgotPwdlink).isDisplayed();
//	}
//	
//	public boolean isLogoExist() {
//		return driver.findElement(logo).isDisplayed();
//	
//	}
//	public boolean doLogin (String username, String pwd) {
//		driver.findElement(userName).sendKeys(username);
//		driver.findElement(passwordId).sendKeys(pwd);
//		driver.findElement(btnlogin).click();
//		System.out.println("User is logged in");
//		return true;
//		
//	}
import org.openqa.selenium.WebElement;

import co.qa.retail.constants.AppConstants;
import co.qa.retail.utils.ElementUtils;
import io.qameta.allure.Step;

public class LoginPage {
	
	//1: private webDriver driver reference
	private WebDriver driver;
	private ElementUtils eleUtil;
	
	//2: locators/ repositry; page object refpository 
	// locator should be private -- access them public methods -- encapsulation
	private By userName=By.id("input-email");
	private By passwordId=By.id("input-password");
	private By btnlogin=By.xpath("//button[text()='Login']");
	private By forgotPwdlink=By.linkText("Forgotten Password");
	private By logo= By.cssSelector("img.img-fluid");
	
	private By CustumerText = By.xpath("//h2[text()='Returning Customer']");
	private By Itembox= By.xpath("(//button[@type='button'] )[1]");
	private By Footer = By.xpath("(//div[@class='container']/child::div)[4]");
	
	
	private By registerLink=By.linkText("Register");
	
	// 3: page Constructor 
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	
	eleUtil=new ElementUtils(this.driver);
	
	}
	// 4: page actions/ behavior/ methods
	@Step("Getting Login Page Title")
	public String getLoginPageTitle() {
	String title=eleUtil.waitForTitleCompleteValue(AppConstants.LOGIN_PAGE_TITLE, AppConstants.SHORT_DEFAULT_WAIT);
		System.out.println("Login Page title is : "+ title);
		return title;
		
	}
	@Step("Getting Login Page URL")
	public String getLoginPageURL() {
		
		String url=eleUtil.waitForURLContains(AppConstants.LOGIN_PAGE_URL_FRACTION, AppConstants.SHORT_DEFAULT_WAIT);
		System.out.println("Login Page URL is : "+ url);
		return url;
	}
	@Step("Checking Forgot Password Link exist")
	public boolean isForgotPwdLisnkExist() {
		return eleUtil.waitForVisibilityOfElement(forgotPwdlink, AppConstants.SHORT_DEFAULT_WAIT).isDisplayed();
//		return driver.findElement(forgotPwdlink).isDisplayed();
	}
	@Step("Checking Application Logo exist")
	public boolean isLogoExist() {
		return eleUtil.waitForVisibilityOfElement(logo, AppConstants.SHORT_DEFAULT_WAIT).isDisplayed();
//		return driver.findElement(logo).isDisplayed();
	
	}
	@Step("User name is: *** and the user password is: ****")
	public AccountsPage doLogin (String username, String pwd) {
		
//		System.out.println("Credentials are :" +username+ ":" +pwd);
		eleUtil.doSendKeysWithWait(userName, username, AppConstants.MEDIUM_DEFAULT_WAIT);
		eleUtil.doSendKeys(passwordId, pwd);
		eleUtil.doClick(btnlogin);
		
		return new AccountsPage(driver);
	}
	public boolean isCustomerExist() {
		return eleUtil.waitForVisibilityOfElement(CustumerText, AppConstants.SHORT_DEFAULT_WAIT).isDisplayed();
		
	}
	
	public boolean isItemboxExist() {
		return eleUtil.waitForVisibilityOfElement(Itembox, AppConstants.SHORT_DEFAULT_WAIT).isDisplayed();
	}
	public boolean isFooterExist() {
		return eleUtil.waitForVisibilityOfElement(Footer, AppConstants.SHORT_DEFAULT_WAIT).isDisplayed();
	
	
	}
	@Step("Navigating to the register page")
	public RegisterPage navigateToRegisterPage() {
		eleUtil.waitForVisibilityOfElement(registerLink, AppConstants.MEDIUM_DEFAULT_WAIT).click();
		return new RegisterPage(driver);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
