package com.mobileresringframework.TestUtils;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
   static	ExtentReports extent ;
	@BeforeTest
	public static ExtentReports getRporterObject() {
		
		// ExtentSparkReporter
	    String reportPath = System.getProperty("user.dir")+"\\reports\\index.html" ;
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath); 
	
		sparkReporter.config().setReportName("Web Automation Results");
		sparkReporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Tester", "Mohamed Ishak");
		
		return extent ;
	}
}
