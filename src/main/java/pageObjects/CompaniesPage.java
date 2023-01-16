package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class CompaniesPage extends BasePage{
	
	@FindBy(xpath="//a[@href=\"/companies/new\"]//button")
	WebElement createCompaniesButton;
	
	@FindBy(xpath="//label[text()='Name']/parent::div//input[@name='name']")
	WebElement name;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement saveButton;
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement newlyCreatedCompany;
	
	@FindBy(xpath="(//table//td[2]//a[1])[1]")
	WebElement firstCompanyName;
	
	
	
	public CompaniesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void createCompanies() {
		createCompaniesButton.click();
		name.sendKeys(prop.getProperty("CompanyName"));
		saveButton.click();
	}
	
	public void verifyCreatedCompanyDisplayed() {
		String actualCompany = newlyCreatedCompany.getText();
		String expectedCompany = prop.getProperty("CompanyName");
		assert actualCompany.equalsIgnoreCase(expectedCompany);
	}
	
	public void verifyCreatedCompanyDisplayedinList() {
		String actualCompany = firstCompanyName.getText();
		String expectedCompany = prop.getProperty("CompanyName");
		assert actualCompany.equalsIgnoreCase(expectedCompany);
	}
	

	
	
	

}
