package com.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.ITestResult;

public class ExtentReporter {

	protected static ExtentTest test;
	protected static ExtentReports extent;
	protected static DateFormat dateFormat;
	protected static Date date;
	protected static String dt;
	protected static String extentReport;
	protected static String extentReportPath;
	protected static String reportFolder;
	protected static String title;
	
	public static HashMap testStatusDetail;
	public static Map extentTestMap = new HashMap();
	public static Map testMap = new HashMap();
	
	
	@BeforeSuite(alwaysRun = true)
	public void extentsetUp(ITestContext xmlSuite) {
		System.out.println("- - - Extent SetUp - - -");
		String suiteName = xmlSuite.getSuite().getName();
		System.out.println("suiteName : " +suiteName);
		startExtentReport(suiteName);
	}
	
	public static ExtentReports startExtentReport(String suiteName) {
		try {
			System.out.println("- - - Start Extent Report - - -");
			dateFormat = new SimpleDateFormat("MMM-dd_HH-mm");
			dt = dateFormat.format(date);
			System.out.println("dt : "+dt);
			
			reportFolder = suiteName+ "_" +dt;
			System.out.println("Report Folder : "+reportFolder);
			
			extentReport = reportFolder + "/" + suiteName +"_Report_"+ dt +".html";
			System.out.println("Extent Report : "+extentReport);
			
			title = suiteName;
			System.out.println("Title : "+title);
			
			extent.setSystemInfo("Environment", "ENVIRONMENT");
			extent.setSystemInfo("Build Number", "BUILD NUMBER");
			extent.setSystemInfo("OS Version", "OS VERSION");
			extent.setSystemInfo("Java Version", "JAVA VERSION");
			extent.setSystemInfo("User Name", "USER NAME");
			extent.setSystemInfo("Title", "JenkinsJobName");
			
			testStatusDetail = new HashMap();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return extent;
	}
	
	public static ExtentReports getReporter() {
		if(extent == null) {
			extent = startExtentReport("AUTOMATION STATUS");
		}
		return extent;
	}
	
	public static ExtentTest startTestCase(String testName) {
		test = getReporter().createTest(testName, testName);
		return test;
	}
	
	private static ExtentTest getTest() {
		return (ExtentTest) extentTestMap.get((int) Thread.currentThread().getId());
	}
	
	private static String getTestName() {
		String testName = (String) testMap.get((int) Thread.currentThread().getId());
		return testName;
	}
	
	public static void reportStepWeb(WebDriver driver, String desc) {
	try {
			getTest().log(Status.INFO, desc);
			testStatusDetail.put(getTestName(), "-");
		}catch(Exception e){
				e.printStackTrace();
		}
	}
	
	public static void reportStepWeb(WebDriver driver, String desc, String status, int scFlag) {
	try {
			if(status.equalsIgnoreCase("PASS")) {
				if(scFlag > 0) {
					getTest().log(Status.PASS, desc).pass("PASSED");
					testStatusDetail.put(getTestName(), "-");
				}else {
					getTest().log(Status.PASS, desc);
					testStatusDetail.put(getTestName(), "-");
				}
			}else if(status.equalsIgnoreCase("FAIL")){
				if(scFlag > 0) {
					getTest().log(Status.FAIL, desc).pass("FAILED");
					testStatusDetail.put(getTestName(), "-");
				}else {
					getTest().log(Status.FAIL, desc);
					testStatusDetail.put(getTestName(), "-");
				}
			}else if(status.equalsIgnoreCase("SKIP")){
				if(scFlag > 0) {
					getTest().log(Status.SKIP, desc).pass("SKIPPED");
					testStatusDetail.put(getTestName(), "-");
				}else {
					getTest().log(Status.SKIP, desc);
					testStatusDetail.put(getTestName(), "-");
				}
			}else if(status.equalsIgnoreCase("WARNING")){
				if(scFlag > 0) {
					getTest().log(Status.WARNING, desc).pass("WARNING");
					testStatusDetail.put(getTestName(), "-");
				}else {
					getTest().log(Status.WARNING, desc);
					testStatusDetail.put(getTestName(), "-");
				}
			}
		}catch(Exception e){
				e.printStackTrace();
		}
	}
	
	public static void reportStepMobile(AppiumDriver<MobileElement> driver, String desc, String status, int scFlag) {
		try {
			if(status.equalsIgnoreCase("PASS")) {
				if(scFlag > 0) {
					getTest().log(Status.PASS, desc).pass("PASSED");
					testStatusDetail.put(getTestName(), "-");
				}else {
					getTest().log(Status.PASS, desc);
					testStatusDetail.put(getTestName(), "-");
				}
			}else if(status.equalsIgnoreCase("FAIL")){
				if(scFlag > 0) {
					getTest().log(Status.FAIL, desc).pass("FAILED");
					testStatusDetail.put(getTestName(), "-");
				}else {
					getTest().log(Status.FAIL, desc);
					testStatusDetail.put(getTestName(), "-");
				}
			}else if(status.equalsIgnoreCase("SKIP")){
				if(scFlag > 0) {
					getTest().log(Status.SKIP, desc).pass("SKIPPED");
					testStatusDetail.put(getTestName(), "-");
				}else {
					getTest().log(Status.SKIP, desc);
					testStatusDetail.put(getTestName(), "-");
				}
			}else if(status.equalsIgnoreCase("WARNING")){
				if(scFlag > 0) {
					getTest().log(Status.WARNING, desc).pass("WARNING");
					testStatusDetail.put(getTestName(), "-");
				}else {
					getTest().log(Status.WARNING, desc);
					testStatusDetail.put(getTestName(), "-");
				}
			}
			}catch(Exception e){
					e.printStackTrace();
			}
		}
	
	public static void endExtentReport() {
		System.out.println("- - - End Extent Report - - -");
		getReporter().flush();
	}
	
	public static void endExtentReport(String status, ITestResult result) {
		System.out.println("- - - End Extent Report - - -");
		if(status == "Failed") {
			ExtentReporter.getTest().log(Status.FAIL, result.getThrowable());
		}else if(status == "Skipped") {
			ExtentReporter.getTest().log(Status.SKIP, "Test Skipped "+result.getThrowable());
		}else {
			ExtentReporter.getTest().log(Status.PASS, "Test Passed ");
		}
		getReporter().flush();
	}
	
	
	

}
