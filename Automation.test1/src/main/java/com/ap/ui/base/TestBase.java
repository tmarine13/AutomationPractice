package com.ap.ui.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.ap.ui.util.TestUtil;
import com.ap.ui.util.WebEventListener;

public class TestBase { 
	//setting up property values:
	public static WebDriver driver;
	public static Properties propt;
	public static EventFiringWebDriver en_driver;		//initiates the web driver
	public static WebEventListener eventListener;      //sends the events that take place to the extent reporter
	
	public TestBase(){
		try{							//captures any error that may occur and avoids the error you will get when you interact with a file
			propt = new Properties();		//creating an object
			FileInputStream ipa = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/ap/ui/config/config.properties");
			propt.load(ipa);
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		String browserName = propt.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir")+ "src/main/resources/chrome driver/chromedriver.exe"));
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("FF")){				//adding additional browsers
			System.setProperty("webdriver.gecko.driver", "");
			driver = new FirefoxDriver(); 
		}
		else if(browserName.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", "");
			driver = new InternetExplorerDriver();
		}
		//creating object for action that's occurring and sharing with driver
		en_driver = new EventFiringWebDriver(driver);
		//create object of event listener to register it with eventFiringwebdriver
		eventListener = new WebEventListener();
		//even can be captured based on the method we create WebEventListener class
		en_driver.register(eventListener);
		//since we know driver object is for browser and en_driver is for event thats taking place.
		//we are declaring that they are equal to each when they are exchanging the info
		driver = en_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Page_Load, TimeUnit.SECONDS);
		
		driver.get(propt.getProperty("url"));

	}
}





























