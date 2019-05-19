package com.ap.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.ap.ui.base.TestBase;

public class ProductDetailsPage extends TestBase{
	
	//page factory elements:
	@FindBy(id="quantity_wanted")
	WebElement quantityInput;
	
	@FindBy(id="group_1")
	WebElement sizeList;
	
	@FindBy(id="color_14")
	WebElement color;
	
	@FindBy(name="Submit")
	WebElement AddToCartButton;
	
	@FindBy(css="[title='Proceed to checkout']")
	WebElement proceedCheckout;
	
	@FindBy(id="wishlist_button")
	WebElement addToWishListButton;
	
	@FindBy(css="[class='fancybox-error']")
	WebElement addwishlistMsg;
	
	@FindBy(css="[class='fancybox-item fancybox-close']")
	WebElement addwishlistMsgCloseButton;
	
	//initializes the page factory elements
	public ProductDetailsPage(){
		PageFactory.initElements(driver, this);
	}
	
	//boolean to verify message is accurate, then close
	public void verifyAddwishListMsg(){
		Assert.assertEquals(addwishlistMsg.getText(), "Added to your wishlist.");
		addwishlistMsgCloseButton.click();
	}
	
	//method to interact with a color
	//string for css selector path thru concatenation
	public ProductDetailsPage selectProductColor(String color){
		String locator = "[name='"+color+"']";
		driver.findElement(By.cssSelector(locator)).click();
		return this;
	}
	
	//constructor to clear quantity field then enter a value
	public ProductDetailsPage inputQuantity(String quantity){
		quantityInput.clear();
		quantityInput.sendKeys(quantity);
		return this;
	}
	
	//constructor to interact with webList, creating an object for webList and locating it by sizeList,
	//then selecting the value by its visible text
	public ProductDetailsPage selectSize(String size){
		Select select = new Select(sizeList);
		select.selectByVisibleText(size);
		return this;
	}
	
	//constructor to click buttons: 
	
	public ProductDetailsPage clickAddCart(){
		AddToCartButton.click();
		return this;
	}
	public ProductDetailsPage clickAddWishListButton(){
		addToWishListButton.click();
		return this;
	}
	public OrderSummaryPage proceedCheckOut(){
		proceedCheckout.click();
		return new OrderSummaryPage();
	}
	
	


}






















