package com.ap.ui.testcase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.ap.ui.pages.HomePage;
import com.ap.ui.pages.LoginPage;
import com.ap.ui.pages.SearchPage;

public class SearchItemTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	SearchPage searchPage;
	
public SearchItemTest(){
	super();
}
@BeforeMethod
public void setUpdriver(){
	initialization();
	loginPage = new LoginPage();
	homePage = new HomePage();
}
@Test(priority=3)
public void testSearchItem(){
	String product = "Evening";
	homePage.clickonSignIn();
	homePage = loginPage.login(propt.getProperty("username"), propt.getProperty("password"));
	
	searchPage = homePage.searchProduct("Evening");
	String header = searchPage.getHeader();
	System.out.println(header);
	Assert.assertTrue(header.toLowerCase().contains(product.toLowerCase()));
	homePage.logOut();
}
@AfterMethod
public void tearDown(){
	driver.quit();
}
}

























