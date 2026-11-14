package com.qa.retail.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.retail.base.baseTest;

public class ProductResultsPageTest extends baseTest {
	@BeforeClass
	public void productInfosetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

		/*
		 * Data provider 1: Data provider lets one test method run multiple times with
		 * different input-- Data-Driven Approaches. 2: In a Data provider we use the
		 * "@DataProvider" annotation. 3: This annotation returns a two-dimensional
		 * object "Object[][]"
		 * 
		 */
		// int [] num={1, 2, 3, 4}
		// String [] names={"Fatima", "Frishta", "Farzana"}
	}

	@DataProvider
	public Object[][] getSearchDate() {
		return new Object[][] { { "MacBook", "MacBook Pro", 4 }, { "MacBook", "MacBook Air", 4 }, { "iMac", "iMac", 3 },
				{ "Samsung", "Samsung SyncMaster 941BW", 1 }, { "Samsung", "Samsung Galaxy Tab 10.1", 7 },
				{ "Canon", "Canon EOS 5D", 3 }, { "Phone", "iPhone", 6 }

		};
	}

	@Test(dataProvider = "getSearchDate")

	public void productImagesTest(String searchKey, String productName, int imageCount) {
		searchResultPage = accPage.doSearch(searchKey);
		productInfoPage = searchResultPage.selectProduct(productName);
		Assert.assertEquals(productInfoPage.getProductImagesCount(), imageCount);
	}

	// this below test dosen't work,but it works form AccountPageTest.
//	@Test(priority = 1)
//	public void productImagesTest() {
//		searchResultPage=accPage.doSearch("MacBook");
//		productInfoPage=searchResultPage.selectProduct("MacBook Pro");
//		Assert.assertEquals(productInfoPage.getProductImagesCount(), 4);
//		
//		
//	}
//	Brand: Apple
//	Product Code: Product 18
//	Reward Points: 800
//	Availability: In Stock
//	$2,000.00
//	Ex Tax: $2,000.00
	@Test
	public void productInoTest() {
		searchResultPage = accPage.doSearch("MacBook");
		productInfoPage = searchResultPage.selectProduct("MacBook Pro");
		Map<String, String> producDetailMap = productInfoPage.getProductDetail();

		// Hard Assertions
//		Assert.assertEquals(producDetailMap.get("Brand"), "Apple");
//		Assert.assertEquals(producDetailMap.get("Product Code"), "Product 18");
//		Assert.assertEquals(producDetailMap.get("Reward Points"), "800");
//		Assert.assertEquals(producDetailMap.get("Availability"), "In Stock");
//		Assert.assertEquals(producDetailMap.get("price"), "$2,000.00");
//		Assert.assertEquals(producDetailMap.get("External Tax Price"), "$2,000.00");

		// Soft Assertions
		softAssert.assertEquals(producDetailMap.get("Brand"), "Apple");
		softAssert.assertEquals(producDetailMap.get("Product Code"), "Product 18");
		softAssert.assertEquals(producDetailMap.get("Reward Points"), "800");
		softAssert.assertEquals(producDetailMap.get("Availability"), "In Stock");
		softAssert.assertEquals(producDetailMap.get("price"), "$2,000.00");
		softAssert.assertEquals(producDetailMap.get("External Tax Price"), "$2,000.00");

		softAssert.assertAll();

	}

}
