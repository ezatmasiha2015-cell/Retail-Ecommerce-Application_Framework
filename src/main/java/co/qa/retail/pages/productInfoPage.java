package co.qa.retail.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import co.qa.retail.constants.AppConstants;
import co.qa.retail.utils.ElementUtils;

public class productInfoPage {
	private WebDriver driver;
	private ElementUtils eleUtil;
	
	public productInfoPage(WebDriver driver) {
		this.driver=driver;
		eleUtil=new ElementUtils(this.driver);
		
	}
	//locator
	private By productHeader=By.cssSelector("div#content h1");
	
	private By productImages= By.cssSelector("div.image.magnific-popup img");
	private By productMetaData= By.xpath("(//div[@class='col-sm']//descendant::ul[@class='list-unstyled'])[1]//child::li");
	private By productPriceData= By.xpath("(//div[@class='col-sm']//descendant::ul[@class='list-unstyled'])[2]//child::li");
	//action
	public String getProductHeaderName() {
		String productHeaderValue=eleUtil.doElementGetText(productHeader);
		System.out.println("The product header is: "+productHeaderValue);
		return productHeaderValue;
		
	}
	// method 02 -- product images count
	public int getProductImagesCount() {
		int imagesCount=eleUtil.waitForVisibilityOfElements(productImages, AppConstants.MEDIUM_DEFAULT_WAIT).size();
		System.out.println("Product: " +getProductHeaderName() + "image count: "+imagesCount);
		return imagesCount;
		
	}
	private Map <String, String> productMap=new HashMap<String, String>();
	
	private void getProductMetaDate() {
		List<WebElement> metaDataList=eleUtil.waitForVisibilityOfElements(productMetaData, AppConstants.MEDIUM_DEFAULT_WAIT);
		for(WebElement e :metaDataList) {
			String metaData=e.getText();
		String metaKey=metaData.split(":")[0].trim();
		String metaValue=metaData.split(":")[1].trim();
		productMap.put(metaKey, metaValue);
		}
		
	}
	
	private void getProductPriceMetaDate() {
		List<WebElement> metaPriceList=eleUtil.waitForVisibilityOfElements(productPriceData, AppConstants.MEDIUM_DEFAULT_WAIT);
		String productPrice=metaPriceList.get(0).getText();
		String producExTax=metaPriceList.get(1).getText().split(":")[1].trim();
		
		productMap.put("price", productPrice);
		productMap.put("External Tax Price", producExTax);
	}
		
	public Map<String, String> getProductDetail() {
		productMap.put("product name ", getProductHeaderName());
		getProductMetaDate();
		getProductPriceMetaDate();
		System.out.println(productMap);
		return productMap;
		
	}
	
	
	
}
