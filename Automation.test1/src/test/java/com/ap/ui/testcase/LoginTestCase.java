package com.ap.ui.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.ap.ui.pages.HomePage;
import com.ap.ui.pages.LoginPage;

public class LoginTestCase extends TestBase {
	
	//interact indirectly with the page instead of calling the page directly everytime
	LoginPage loginPage;
	HomePage homePage;
	
	//constructor calls the super class (TestBase)
	public LoginTestCase(){
		super();
	}
	@BeforeMethod
	//initializes the driver
	public void setUpdriver(){
		initialization();
		loginPage = new LoginPage();
	}
	//testing title of page
	@Test(priority=1)
	public void loginPageTitleTest(){
		//creating a string and calling the method from login page OR (object repository)
		String title = loginPage.verifyPageTitle();
		//TestNG feature that captures the value of the title and verifies if it is equal to the value provided
		Assert.assertEquals(title, "Later will check on the site");
	}
	//boolean method to validate logo
	@Test(priority=2)
	public void apLogoTest(){
		boolean value = loginPage.validateAPImage();
		//TestNG feature that captures the value and verifies if it is true or not
		Assert.assertTrue(value);
	}
	//getting property value of username and password
	@Test(priority=3)
	public void loginTest(){
		//making connection with home page and login page
		//getting value from config.propt file
		homePage = loginPage.login(propt.getProperty("username"), propt.getProperty("password"));
	}
	//Exiting browser
	@AfterMethod
	public void closeBrowser(){
		driver.quit();
	}

}













