package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class HomePage extends BasePage {
	static Logger log = LogManager.getLogger();
	@FindBy(xpath = "//div[@class='header item']")
	WebElement cogmentoLogo;

	@FindBy(xpath = "//div[@class='right menu']//span[@class='user-display']")
	WebElement testUser;

	@FindBy(xpath = "//i[@class='users icon']")
	WebElement contactIcon;

	@FindBy(xpath = "//i[@class='building icon']")
	WebElement companiesIcon;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void verifyLogo() {
		Boolean logo = cogmentoLogo.isDisplayed();
		System.out.println("The logo is: " + logo);
	}

	public void verifyUser() {
		String expectedUser = "Test User1";
		String actualUser = testUser.getText();
		System.out.println("The expected user is: " + expectedUser + " and " + "actual user is: " + actualUser);
		assert expectedUser.equalsIgnoreCase(actualUser);
	}

	public void clickContactIcon() {
		contactIcon.click();
		log.info("Clicking on contact icon");
	}

	public void clickCompaniesIcon() {
		companiesIcon.click();
		log.info("Clicking on companies icon");
	}

}
