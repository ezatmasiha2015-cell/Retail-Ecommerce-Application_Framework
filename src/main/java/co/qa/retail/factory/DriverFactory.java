package co.qa.retail.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import co.qa.retail.exceptions.FrameworkException;

public class DriverFactory {
	// driver initialize/ generate
	WebDriver driver;
	Properties prop;
	OptionsManager optionsManager;
	public static ThreadLocal<WebDriver> tlDriver= new ThreadLocal<WebDriver>();
	
	public WebDriver initDriver(Properties prop) {
//		System.out.println("Broswer name is : " +browserName);

		String browserName = prop.getProperty("browser");// local run
//		String browserName = System.getProperty("browser", prop.getProperty("browser"));
//		String browserName = System.getProperty("browser");// CMD line run
		System.out.println("Browser name is : " + browserName);
		optionsManager = new OptionsManager(prop);
		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver(optionsManager.getChromeOptions());
//			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			break;
		case "firefox":
			driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
//			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
			break;

		case "edge":
			driver = new EdgeDriver(optionsManager.getEdgeOptions());
//			tlDriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
			break;
		case "safari":
			driver = new SafariDriver();
//			tlDriver.set(new SafariDriver() );
			break;
		default:
			System.out.println("Please pass the right browser name ... " + browserName);
			throw new FrameworkException("No browser found...");

		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		return driver;

//		getDriver().manage().deleteAllCookies();
//		getDriver().manage().window().maximize();
//		getDriver().get(prop.getProperty("url"));
//		return getDriver();

	}
	public static WebDriver getDriver() {
		return tlDriver.get();
	}

	public Properties initProp() {

		FileInputStream ip = null;
		prop = new Properties();
		String envName = System.getProperty("env");
		System.out.println("Environment name is :"+envName);
		try {
			if (envName == null) {
				ip = new FileInputStream("./src/test/resources/config/config.qa.properties");
			} else {
				switch (envName.toLowerCase().trim()) {
				case "qa":
					ip = new FileInputStream("./src/test/resources/config/config.qa.properties");
					break;
				case "dev":
					ip = new FileInputStream("./src/test/resources/config/config.dev.properties");
					break;
				case "stage":
					ip = new FileInputStream("./src/test/resources/config/config.stage.properties");
					break;
				case "uat":
					ip = new FileInputStream("./src/test/resources/config/config.uat.properties");
					break;
				case "prod":
					ip = new FileInputStream("./src/test/resources/config/config.properties");
					break;

				default:
					System.out.println("Please add the correct environment :" + envName);
					throw new FrameworkException("Wrong environment ..." + envName);

				}
			}
//		// Establish the Connection with config.properties
//		try {
////			FileInputStream ip=new FileInputStream(".\src\\test\\resources\\config\\config.properties");
//			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
//			// load the data from config.properties
//			prop.load(ip);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		} catch (FileNotFoundException e) {

		}
		try {
			prop.load(ip);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return prop;
	}
}
