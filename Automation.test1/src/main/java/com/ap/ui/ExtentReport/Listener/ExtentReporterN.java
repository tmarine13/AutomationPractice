package com.ap.ui.ExtentReport.Listener;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


//class implements interface
public class ExtentReporterN implements IReporter{ 
	
	//abstract class with object and no body
	//private because we don't want to share its results
	private ExtentReports extent;
	
	//created a method with array concept (LIST), creates an xml file that will contain all the classes
	//XML Suite for testing type regression, smoke, sanity
	//ISuite for class pages (login/checkout)
	//String for pass, fail, skip
public void generateReport(List<XmlSuite> xmlSuites, List<ISuite>suites, String outPutDirectory){ 
	
	//creating an object and holding the string output
	//file separator is not needed but helps translate the output into any machine 
	//extent.html is telling it to save the file as this
	//boolean true = if there is no result from the test run, then don't generate a report, only generate if true
	extent = new ExtentReports(outPutDirectory + File.separator + "Extent.html", true);
	
	//Conditional Operator to run 1 suite or multiple suites
	//MAP obtains a key value that can not be duplicated and maps it to one location (extent reports)
	//MAP is an interface in JAVA, used here between the output string result to the extent report
	for(ISuite suite : suites){
		Map<String, ISuiteResult>result = suite.getResults();
	
	//the context is whenever the script runs, we are expecting a result	
	for(ISuiteResult r : result.values()){
		ITestContext context =r.getTestContext();
		
		//Capturing the context depending on the results
		buildTestNodes(context.getPassedTests(), LogStatus.PASS);
		buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
		buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
	}
}

//adding the result you get and attaching it to the attachment or html file
extent.flush();
extent.close();

}

//creating a private constructor
private void buildTestNodes(IResultMap tests, LogStatus status){
	
	//calling extent test and creating object "test"
	ExtentTest test;
	
	//
	if(tests.size()>0){
		for(ITestResult result : tests.getAllResults()){
			test = extent.startTest(result.getMethod().getMethodName());
			
			//duration of the test
			test.setStartedTime(getTime(result.getStartMillis()));
			test.setEndedTime(getTime(result.getEndMillis()));
			
			//going thru all results and grouping together the passed, failed, skipped
			for(String group : result.getMethod().getGroups())test.assignCategory(group);
			
			//logs all errors found
			//null is an empty string
			if(result.getThrowable() !=null){
				test.log(status, result.getThrowable());
			
			//logs the passed, failed, skipped
			}else{
				test.log(status, "Test" + status.toString().toLowerCase() + "ed");
			}
			extent.endTest(test);
		}
	}
}
//private constructor logs local machine time
private Date getTime(long millis){
	Calendar calendar = Calendar.getInstance();
	calendar.setTimeInMillis(millis);
	return calendar.getTime();
}
}