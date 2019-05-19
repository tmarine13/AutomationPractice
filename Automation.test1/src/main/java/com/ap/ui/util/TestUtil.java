package com.ap.ui.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ap.ui.base.TestBase;

//extended to TestBase
public class TestUtil extends TestBase {
	
	public static long Page_Load = 10;
	public static long Implicit_Wait = 10;
	
	//XL Sheet
	public static String XL_SHEET_PATH = "path of the xl sheet";
	
	//first go to excel file then to the sheet
	static Workbook book;
	static Sheet sheet;
	
	static JavascriptExecutor js;

	//method will have a string within the sheet name:
	public static Object[][] getTestData(String sheetName){
		//won't run the method if no data is available:
		FileInputStream file = null;
		//XL file error handling:
		//file level:
		try{
			file = new FileInputStream(XL_SHEET_PATH);
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
		//workbook level:
		try{
			book = WorkbookFactory.create(file);
		}catch (InvalidFormatException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
		//method to go thru info in XL sheet:
		sheet = book.getSheet(sheetName);
		//2D array
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		//loop to get number of rows
		for (int i = 0; i< sheet.getLastRowNum(); i++){
			//loop to go thru rows and retrieve cell string data:
			for (int j = 0; j< sheet.getRow(0).getLastCellNum(); j++){
				data[i][j]=sheet.getRow(i + 1).getCell(j).toString();
			}
		}
		return data;
	}
	//method to take screenshot and saves it into this project
	public static void takeScreenShotAt() throws IOException {
		//takes screenshot
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//goes to project directory, creates folder "screenshot", takes time stamp in millis and save it into a .png file.
		String currentDirect = System.getProperty("user.dir");
		FileUtils.copyFile(srcFile, new File(currentDirect + "/screenshot/" + System.currentTimeMillis() + ".png"));
	}
	//method to capture everything from the console log and saves it in @log to help developers debug
	public static void runTimeInfo(String messageType, String message) throws InterruptedException{
		js = (JavascriptExecutor) driver;
		
		js.executeScript("if (!window.JQuery){"
				//translates the JQuery
			+ "var jquery = document.createElement('script'); jquery.type = 'text/javascript';"
				//saves the file
			+ "jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';"
				//captures the header and response body
			+ "document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");
		//wait statement for log capturing to happen
		Thread.sleep(6000);
		
		//gets API info
		js.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");
		//takes the header and goes to the link and translates it
		js.executeScript("$('head').append('<link rel=\"stylesheet\" "
			+ "href\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />'");
		Thread.sleep(6000);
				
		//GET method to retrieve API info
		js.executeScript("$ growl({ title: 'GET' , message: '\'});");
		
		//any type of warning the driver returns and differentiating/segregating it
		if(messageType.equals("error")){
			js.executeScript("$growl.error({ title: 'ERROR' message: '"+message+"'});");
		}else if(messageType.equals("info")){
			js.executeScript("$growl.error({ title: 'Notice', message: 'notice message will appear here' });");
		}else if(messageType.equals("warning")){
			js.executeScript("$growl.warning({ title: 'Warning!!', message: 'warning message will appear here' });");
		}else
			System.out.println("Show NO Error Message");
		Thread.sleep(6000);
	}
}














