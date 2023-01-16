package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class LoginPage extends BasePage {
	static Logger log = LogManager.getLogger();

	@FindBy(xpath = "//input[@name='email']")
	WebElement userName;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//div[text()='Login']")
	WebElement loginButton;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void cogmentoLogin() {
		userName.sendKeys(prop.getProperty("username"));
		log.info("Passing username as: " + prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		log.info("Passing password as: " + prop.getProperty("password"));
		loginButton.click();
		log.info("Clicking on login button");
	}
	
	public void cogmentoLoginWithExcelData(String Username, String Password) {
		userName.sendKeys(Username);
		log.info("Passing username as: " + Username);
		password.sendKeys(Password);
		log.info("Passing password as: " + Password);
		loginButton.click();
		log.info("Clicking on login button");
	}
}
