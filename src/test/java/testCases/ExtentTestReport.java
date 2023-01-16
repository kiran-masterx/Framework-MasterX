package testCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BasePage;

public class ExtentTestReport extends BasePage{
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest
	public void startReport() {
		htmlReporter = new ExtentHtmlReporter("C:\\Users\\Lenovo\\eclipse-workspace\\Framework-Masterx\\test-output\\extentReport.html");
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		htmlReporter.config().setDocumentTitle("Test Automation Report");
		htmlReporter.config().setReportName("MasterX Automation Report");
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	@Test
	public void test1() {
		test = extent.createTest("Test 1", "This is first test");
		int a = 10; 
		int b = 10;
		Assert.assertEquals(a, b);
	}
	
	@Test
	public void test2() {
		test = extent.createTest("Test 2", "This is second test");
		int a = 20; 
		int b = 10;
		Assert.assertEquals(a, b);
	}
	
	@Test()
	public void test3() {
		test = extent.createTest("Test 3", "This is third test");
		throw new SkipException("Skipping the test");
	}
	
	@AfterMethod
	public void getResult(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getThrowable());
		}else if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getTestName());
		}else {
			test.log(Status.SKIP, result.getTestName());
			test.log(Status.SKIP, result.getThrowable());
		}
	}
	
	@AfterTest
	public void tearDown() {
		extent.flush();
	}

}
