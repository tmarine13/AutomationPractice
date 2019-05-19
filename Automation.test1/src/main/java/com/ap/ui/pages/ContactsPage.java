package com.ap.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ap.ui.base.TestBase;

public class ContactsPage extends TestBase{
	
	//Page Factory
	@FindBy(id="id_contact")
	WebElement headingDropdown;
	
	@FindBy(id="email")
	WebElement emailInput;
	
	@FindBy(id="id_order")
	WebElement orderReference;
	
	@FindBy(id="message")
	WebElement messageText;
	
	@FindBy(id="submitMessage")
	WebElement submitMessageButton;
	
	@FindBy(css="[class='alert alert_success']")
	WebElement successMsg;
	
	//Constructor to initialize the page elements
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	//creating objects for the drop down and passing the information thru
	public ContactsPage fillContactForm(String heading, String email, String reference, String message){
		Select select = new Select(headingDropdown);
		select.selectByVisibleText(heading);
		emailInput.sendKeys(email);
		orderReference.sendKeys(reference);
		messageText.sendKeys(message);
		return this;
	}
	//click submit button
	public void submitMessage(){
		submitMessageButton.click();
	}
	//
	public String getMessage(){
		return successMsg.getText();
	}
	

}
























