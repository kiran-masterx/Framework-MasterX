package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class ContactsPage extends BasePage{
	static Logger log = LogManager.getLogger();
	@FindBy(xpath="//a[@href='/contacts/new']//button[@class='ui linkedin button']")
	WebElement createButton;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='middle_name']")
	WebElement middleName;

	@FindBy(xpath="//div[@name='company']//input")
	WebElement company;
	
	@FindBy(xpath="//button[@class='ui small fluid positive toggle button']")
	WebElement accessButton;
	
	@FindBy(xpath="//label[@for='tags']//input")
	WebElement tags;
	
	@FindBy(xpath="//input[@placeholder='Email address']")
	WebElement email;
	
	@FindBy(xpath="//div[@name='status']//div[@role='alert']")
	WebElement statusDropdown;
	
	@FindBy(xpath="//div[@class='visible menu transition']//div//span[text()='Active']")
	WebElement statusDropdownActiveOption;
	
	@FindBy(xpath="//i[@class='save icon']/parent::button[@class='ui linkedin button']")
	WebElement saveButton;
	
	@FindBy(xpath="//tbody//tr[1000]")
	WebElement fifthContactCreated;
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickCreateButton() {
		createButton.click();
		log.info("Clicking on create button");
	}
	
	public void createContact() {
		log.info("Creating a contact");
		firstName.sendKeys("Ram");
		lastName.sendKeys("Patil");
		middleName.sendKeys("J");
		company.sendKeys("TCS");
		accessButton.click();
		tags.sendKeys("QA");
		email.sendKeys("kiran123@gmail.com");
		statusDropdown.click();
		statusDropdownActiveOption.click();
		saveButton.click();
	}
	
	public void createContactWithExcel(String FirstName, String LastName) throws InterruptedException {
		log.info("Creating a contact");
		firstName.sendKeys(FirstName);
		lastName.sendKeys(LastName);
		Thread.sleep(2000);
		saveButton.click();
		Thread.sleep(2000);
	}
	
	public void verifyContactIsCreated() {
		log.info("Verifying the contact is created or not");
		if (fifthContactCreated.isDisplayed()) {
			System.out.println("contact is created");
			log.info("Conatct is Created");
		}else {
			System.out.println("contact is not created");
			log.info("Conatct is not Created due to some issue.");
		}
	}

}
