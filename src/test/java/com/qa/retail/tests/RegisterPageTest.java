package com.qa.retail.tests;

import java.util.UUID;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.retail.base.BaseTest;

public class RegisterPageTest extends BaseTest{

@BeforeClass
public void regStup() {
	registerPage=loginPage.navigateToRegisterPage();
	
	
	
}
 public String getRandamEmail(String firstName) {
	 return firstName +"DMV"+ System.currentTimeMillis()+"@gmail.com";
//	 return "Selenium" +UUID.randomUUID()+ "@gmail.com";
 }
 @DataProvider
 public Object[][] getUserRegisterData() {
	 return new Object[][] {
		 {"Paul", "Smeth", getRandamEmail("Paul"),"Test123"}, 
		 {"Franklin", "Smeth",getRandamEmail("Franklin"),"Test123"}, 
		 {"Smith", "Smeth", getRandamEmail("Smith"),"Test123"},
		 {"Sorya", "Nazari", getRandamEmail("Sorya"),"Test123"},
		 {"Fatima", "Ahami", getRandamEmail("Fatima"),"Test123"},
		 {"Ezat", "Masiha", getRandamEmail("Ezat"),"Test123"},
		 {"Frishta", "Mohammadi", getRandamEmail("Frishta"),"Test123"}
		 
	 }; 
 }
 @Test(dataProvider ="getUserRegisterData")
 public void userRegTest(String userFirstName, String userLastName, String userEmail, String UserPassword) {
 	boolean isRegDone=registerPage.userRegisteration(userFirstName, userLastName, getRandamEmail(userLastName),UserPassword);
 	Assert.assertTrue(isRegDone);
 }
 
 
 
 
 
//@Test
//public void userRegTest() {
//	boolean isRegDone=registerPage.userRegisteration("Paul", "Smeth", getRandamEmail("Paul"),"Test123");
//	Assert.assertTrue(isRegDone);
//}

}
