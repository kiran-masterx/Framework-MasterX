package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BasePage;
import pageObjects.ContactsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utils.ExcelDataReader;

public class ExcelDataProvider extends BasePage{
	
	static Logger log = LogManager.getLogger();
	@BeforeMethod
	public void setUp() {
		launchBrowser();
	}
	
	@Test(dataProvider="cogmentoData", dataProviderClass = ExcelDataReader.class)
	public void createContact(String Username, String Password, String firstName, String lastName) throws InterruptedException {
		
		LoginPage loginPage = new LoginPage();
		loginPage.cogmentoLoginWithExcelData(Username, Password);
		
		HomePage homePage = new HomePage();
		homePage.clickContactIcon();
		
		ContactsPage contactsPage = new ContactsPage();
		contactsPage.clickCreateButton();
		contactsPage.createContactWithExcel(firstName, lastName);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}



