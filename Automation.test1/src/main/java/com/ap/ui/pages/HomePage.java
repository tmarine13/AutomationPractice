package com.ap.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.ui.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(css="[class='login']")
	WebElement signInButton;
	
	@FindBy(id="contact-link")
	WebElement contactUsLink;
	
	@FindBy(id="search_query_top")
	WebElement searchField;
	
	@FindBy(css="[name='submit_search']")
	WebElement submitSearchButton;
	
	@FindBy(css="[class='logout']")
	WebElement logoutButton;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	public SearchPage searchProduct(String productName){
		searchField.sendKeys(productName);
		submitSearchButton.click();
		return new SearchPage();
	}
	public void clickonSignIn(){
		signInButton.click();
	}
	public void clickonContactLink(){
		contactUsLink.click();
	}
	public void logOut(){
		logoutButton.click();
	}
	
	

}








//initialize the page object
	//create method for SearchPage
	//create method for SignIn
	//create method for Contactbutton
	//create method for Logout



