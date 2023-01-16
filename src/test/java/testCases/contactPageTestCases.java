package testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BasePage;
import pageObjects.ContactsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class contactPageTestCases extends BasePage{
	static Logger log = LogManager.getLogger();
	
	@BeforeMethod
	public void setUp() {
		launchBrowser();
	}
	
	@Test
	public void createContact() throws IOException {
		test = extent.createTest("Test 1", "This is first test");
		log.info("LAUNCHING CREATE CONTACT TSET CASE");
		LoginPage loginPage = new LoginPage();
		loginPage.cogmentoLogin();
		
		HomePage homePage = new HomePage();
		homePage.clickContactIcon();
		ContactsPage contactsPage = new ContactsPage();
		contactsPage.clickCreateButton();
		contactsPage.createContact();
		System.out.println("Conatct is created");
	}
	
	@Test
	public void verifyContactCreated() throws IOException {
		test = extent.createTest("Test 2", "This is second test");
		log.info("VERIFYING CONTACT IS CREATED OR NOT");
		LoginPage loginPage = new LoginPage();
		loginPage.cogmentoLogin();
		
		HomePage homePage = new HomePage();
		homePage.clickContactIcon();
		ContactsPage contactsPage = new ContactsPage();
		contactsPage.verifyContactIsCreated();
	}
	
	@Test
	public void verifySum() {
		int a = 10;
		int b = 20;
		int c = 30;
		assert a + b == c;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		extent.flush();
	}
}
