package com.ap.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.ui.base.TestBase;

public class OrderSummaryPage extends TestBase{
	
	@FindBy(css="[title='Proceed to checkout']")
	WebElement proceedCheckOutButton;
	
	@FindBy(name="processAddress")
	WebElement processAddressButton;
	
	@FindBy(name="processCarrier")
	WebElement processCarrierButton;
	
	@FindBy(id="cgv")
	WebElement termsAndConditionCheckBox;
	
	@FindBy(css="[title='Pay by bank wire']")
	WebElement payByBankWire;
	
	@FindBy(css="[class='button btn btn-default button-medium']")
	WebElement confirmOrderButton;
	
	@FindBy(css="[class='cheque-indent']")
	WebElement orderConfirm;

	public OrderSummaryPage(){
		PageFactory.initElements(driver, this);
	}
	public OrderSummaryPage proceedCheckOut(){
		proceedCheckOutButton.click();
		return this;
	}
	public OrderSummaryPage proceedAddressCheckOut(){
		processAddressButton.click();
		return this;
	}
	public OrderSummaryPage proceedShippingCheckOut(){
		termsAndConditionCheckBox.click();
		processCarrierButton.click();
		return this;
	}
	public OrderSummaryPage confirmOrder(){
		payByBankWire.click();
		confirmOrderButton.click();
		return this;
	}
	public String getConfirmationMessage(){
		return orderConfirm.getText();
	}

}














