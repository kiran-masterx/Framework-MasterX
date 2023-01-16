package testCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BasePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class FirstTestCase extends BasePage {
	
	@BeforeMethod
	public void setUp() {
		launchBrowser();
		LoginPage loginPage = new LoginPage();
		loginPage.cogmentoLogin();
	}
	
	@Test
	public void verifyLogoDisplayed() throws IOException {
		test = extent.createTest("verifyLogoDisplayed", "This is to verify the logo is displaying or not");
		HomePage homePage = new HomePage();
		homePage.verifyLogo();
		captureScreenshots("verifyLogoDisplayed");
	}
	
	@Test
	public void verifyUserIsTestUser() throws IOException {		
		test = extent.createTest("verifyUserIsTestUser", "This is top verify correct user is displying or not");
		HomePage homePage = new HomePage();
		homePage.verifyUser();
		captureScreenshots("verifyUserIsTestUser");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		extent.flush();
	}
	
	
	
	
	
}



//Test cases
//1. Verify the cogmento logo is displayed
//2. Verify the name of the user is Test User
