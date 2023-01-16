package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BasePage;
import pageObjects.CompaniesPage;
import pageObjects.ContactsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class CompaniesPageTestCases extends BasePage{
	
	@BeforeMethod
	public void setUp() {
		launchBrowser();
	}
	
	@Test (description="Verify company is created successfully.", priority = 0)
	public void verifyCreatedCompanyDisplayed() {
		LoginPage loginPage = new LoginPage();
		loginPage.cogmentoLogin();
		
		HomePage homePage = new HomePage();
		homePage.clickCompaniesIcon();
		
		CompaniesPage companiesPage = new CompaniesPage();
		companiesPage.createCompanies();
		companiesPage.verifyCreatedCompanyDisplayed();
	}
	
	@Test (description="Verify the newly created company is available in the company list", priority = 1, dependsOnMethods= "verifyCreatedCompanyDisplayed", enabled=false)
	public void verifyCreatedCompanyDisplayedinList() {
		LoginPage loginPage = new LoginPage();
		loginPage.cogmentoLogin();
		
		HomePage homePage = new HomePage();
		homePage.clickCompaniesIcon();
		
		CompaniesPage companiesPage = new CompaniesPage();
		companiesPage.verifyCreatedCompanyDisplayedinList();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}


// 1. Verify company is created successfully. 
// 2. Verify the newly created company is available in the company list 
// 3. Verify user is able to delete the company
// 4. Verify company is successfully deleted