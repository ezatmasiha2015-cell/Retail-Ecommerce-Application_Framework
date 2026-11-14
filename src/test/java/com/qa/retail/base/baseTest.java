package com.qa.retail.base;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.aventstack.chaintest.service.ChainPluginService;
import com.qa.retail.factory.DriverFactory;
import com.qa.retail.listeners.TestAllureListener;
import com.qa.retail.pages.AccountsPage;
import com.qa.retail.pages.LoginPage;
import com.qa.retail.pages.RegisterPage;
import com.qa.retail.pages.productInfoPage;
import com.qa.retail.pages.searchResultPage;
//@Listeners(ChainTestListener.class)
@Listeners(TestAllureListener.class)
public class baseTest {

	protected WebDriver driver;

	DriverFactory df;
	protected LoginPage loginPage;
	protected AccountsPage accPage;
	protected Properties prop;
	protected searchResultPage searchResultPage;
	protected productInfoPage productInfoPage;
	protected SoftAssert softAssert;
	protected RegisterPage registerPage;
	@Parameters({"browser"})
	@BeforeTest

	public void setup(String browserName) {
		ChainPluginService.getInstance().addSystemInfo("Builds", "1.0");
		ChainPluginService.getInstance().addSystemInfo("Owner Name", "Masiha");
		ChainPluginService.getInstance().addSystemInfo("Sr. Tester", "Micheal");
		ChainPluginService.getInstance().addSystemInfo("Manager", "David");
		ChainPluginService.getInstance().addSystemInfo("Team Lead", "Jessica");
		ChainPluginService.getInstance().addSystemInfo("HR", "Fatima");
		
		df = new DriverFactory();
		prop = df.initProp();
//	driver=df.initDriver("chrome");
		 // If a browser parameter is provided from the TestNG XML, it will override the browser value from the config.properties file
//		driver = df.initDriver(prop);
		// check to give the reference to xml file
		if (browserName !=null) {
			prop.setProperty("browser", browserName);
		}
		driver=df.initDriver(prop);
		loginPage = new LoginPage(driver);
		softAssert = new SoftAssert();

	}
	@AfterMethod
	public void attachScreenshot(ITestResult result) {
	if(!result.isSuccess()) {
		takeScreenshot();
		ChainTestListener.embed(takeScreenshot(), "image/png");
	}
	}
	public byte[] takeScreenshot() {
		return((TakesScreenshot)(driver)).getScreenshotAs(OutputType.BYTES);
	}
	@AfterTest
	public void tearDown() {
//		if(DriverFactory.getDriver()!= null) {//new added
//			DriverFactory.getDriver().quit();//new
//			DriverFactory.tlDriver.remove();//new
//		}
		driver.quit();
	}

}
