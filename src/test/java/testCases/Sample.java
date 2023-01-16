package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sample {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Inside beforeSuite");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("Inside afterSuite");
	}
	
	@Test(priority =1)
	public void test1() {
		System.out.println("Verify the sequence of annotations");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Inside beforeMethod");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Inside afterMethod");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("Inside afterClass");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Inside beforeTest");
	}
	@Test(priority = 0)
	public void test2() {
		System.out.println("Verify the sequence of annotations by test 2");
	}
	
	//If priority is not given for any method then it will consider its priority as 0
	//The test having lowest priority will execute first
	//If priority is not passed for any of the test then it will be consider on the basis of the alphabetical order of the method name.

}
