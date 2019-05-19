package com.ap.ui.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.ap.ui.pages.ContactsPage;
import com.ap.ui.pages.HomePage;
import com.ap.ui.pages.LoginPage;

public class ContactTest  extends TestBase{
	
	//indirect link of the pages
	ContactsPage contactspage;
	//included because "contact us" is in home page
	HomePage homepage;
	
	//constructor
	public ContactTest(){
		super();
	}
	@BeforeMethod
	public void setUpdriver(){
		initialization();
		contactspage = new ContactsPage();
		homepage = new HomePage();
	}
	
	@Test
	public void testContact(){
		//click on "contact us" on home page
		homepage.clickonContactLink();
		//on contact page, use contact page method and fill in these arguments:
		contactspage = contactspage.fillContactForm("Customer service", "Random@test.com", "Testing", "This is test purpose");
		
		//click on submit button
		contactspage.submitMessage();
		//get success msg
		String successMsg = contactspage.getMessage();
		//boolean, make sure message reads as follows:
		Assert.assertEquals(successMsg, "Your message has been successfully sent to our team.");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}



























