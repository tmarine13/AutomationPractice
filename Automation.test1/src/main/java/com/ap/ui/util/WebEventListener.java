//We have created this class WebDriverEventListener in order to implement interface
//is to override all the methods and define certain helpful log actions which would
//be displayed/logged as the app under test is being executed. These methods will be
//invoked by itself automatically when certain action are performed. Ex: click, submit,
//screenshot, findby, etc.

package com.ap.ui.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.ap.ui.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener{
	
	public void beforeNavigate(String url, WebDriver driver){
		System.out.println("Before navi to: '" + url + "'");
	}
	public void afterNavigate(String url, WebDriver driver){
		System.out.println("Navigate to: '" + url + "'");
	}
	public void beforeChangeValueof(WebElement element, WebDriver driver){
		System.out.println("Value of: " + element.toString() + "before making any change");
	}
	public void afterChangeValueof(WebElement element, WebDriver driver){
		System.out.println("Value changed to: " + element.toString());
	}
	public void beforeClickingon(WebElement element, WebDriver driver){
		System.out.println("Attempting to Click on: " + element.toString());
	}
	public void afterClickingon(WebElement element, WebDriver driver){
		System.out.println("Successfully Clicked on: " + element.toString());
	}
	public void beforeNavigatingback(WebDriver driver){
		System.out.println("Attempting navigating back to previous page");
	}
	public void afterNavigatingback(WebDriver driver){
		System.out.println("Successfully navigating to current page");
	}
	public void beforeNavigatingforward(WebDriver driver){
		System.out.println("Attempting navigating forward to next page");
	}
	public void afterNavigatingforward(WebDriver driver){
		System.out.println("Successfully navigating forward to next page");
	}
	public void dueToException(Throwable error, WebDriver driver){
		System.out.println("Exception occured: " + error);
		try{
			TestUtil.takeScreenShotAt();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	public void beforeFindBy(By by, WebElement element, WebDriver driver){
		System.out.println("Attempting find the element: " + by.toString());
	}
	public void afterFindBy(By by, WebElement element, WebDriver driver){
		System.out.println("Successfully found the element: " + by.toString());
	}
	
	//These are non overridden methods of the the WebListener class 
	public void beforeScript(String script, WebDriver driver){
		
	}
	//These are non overridden methods of the the WebListener class 
	public void afterScript(String script, WebDriver driver){
		
	}
	//These are non overridden methods of the the WebListener class 
	public void beforeAcceptingAlert(WebDriver driver){
		
	}
	//These are non overridden methods of the the WebListener class 
	public void afterAcceptingAlert(WebDriver driver){
		
	}
	//These are non overridden methods of the the WebListener class 
	public void beforeDismissingAlert(WebDriver driver){
		
	}
	//These are non overridden methods of the the WebListener class 
	public void afterDismissingAlert(WebDriver driver){
		
	}
	//These are non overridden methods of the the WebListener class 
	public void beforeNavigateRefresh(WebDriver driver){
		
	}
	//These are non overridden methods of the the WebListener class 
	public void afterNavigateRefresh(WebDriver driver){
		
	}
	//These are non overridden methods of the the WebListener class 
	public void beforeChangeValueof(WebElement element, WebDriver driver, CharSequence [] keysToSend){
		
	}
	//These are non overridden methods of the the WebListener class 
	public void afterChangeValueof(WebElement element, WebDriver driver, CharSequence [] keysToSend){
		
	}
	//These are non overridden methods of the the WebListener class 
	public <X> void beforeGetScreenshotAs(OutputType<X> arg0){
		
	}
	//These are non overridden methods of the the WebListener class 
	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1){
		
	}
	//These are non overridden methods of the the WebListener class 
	public void beforeGetText(WebElement arg0, WebDriver arg1){
		
	}
	//These are non overridden methods of the the WebListener class
	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2){
		
	}
	//These are non overridden methods of the the WebListener class 
	public void beforeSwitchToWindow(String arg0, WebDriver arg1){
		
	}
	//These are non overridden methods of the the WebListener class 
	public void afterSwitchToWindow(String arg0, WebDriver arg1){
		
	}
	public void afterAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	public void afterAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	public void afterNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	public void onException(Throwable arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
}




























