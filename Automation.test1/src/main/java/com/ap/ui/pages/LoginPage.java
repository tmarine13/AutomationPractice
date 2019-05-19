package com.ap.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.ui.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory
	//edit fields identified by id
	//button and logo img identified by xpath
	
	@FindBy(id="email")
	WebElement username;
	
	@FindBy(id="passwd")
	WebElement password;

	@FindBy(xpath="//*[@id='SubmitLogin']")
	WebElement submitbutton;
	
	@FindBy(xpath="//*[@id='header_logo']/a/img")
	WebElement apLogo;
	
	//initiates login page
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	//method to get title
	public String verifyPageTitle(){
		return driver.getTitle();
	}
	//boolean method to verify app logo
	public boolean validateAPImage(){
		return apLogo.isDisplayed();
	}
	//method to perform login in function
	public HomePage login(String uname, String passw){
		username.sendKeys(uname);
		password.sendKeys(passw);
		submitbutton.click();
		return new HomePage();
	}
}














