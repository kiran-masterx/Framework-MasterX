package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BasePage {
	public static WebDriver driver;
	public static Properties prop;
	static Logger log = LogManager.getLogger();
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public BasePage() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\Lenovo\\eclipse-workspace\\Framework-Masterx\\src\\main\\java\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public static void launchBrowser() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Lenovo\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
			driver = new ChromeDriver();
			log.info("launching chrome driver");
		} else if (browserName.equals("firefox")) {
			System.out.println("Code for launching firefox driver");
		} else {
			System.out.println("Specified browser not found.");
		}

		driver.get(prop.getProperty("url"));
		log.info("Opening URL" + prop.getProperty("url"));
		log.warn("Opening URL");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}


	@BeforeTest
	public void startReport() {
		htmlReporter = new ExtentHtmlReporter(
				"C:\\Users\\Lenovo\\eclipse-workspace\\Framework-Masterx\\ExtentReport\\extentReport.html");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		htmlReporter.config().setDocumentTitle("Test Automation Report");
		htmlReporter.config().setReportName("MasterX Automation Report");
		htmlReporter.config().setTheme(Theme.DARK);
	}

	@AfterMethod
	public void getResult(ITestResult result) throws IOException {
		//ITestResult is used to capture the result of testNg test in extent report
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getTestName());
		} else {
			test.log(Status.SKIP, result.getTestName());
		}
	}

	//taking screenshots in Selenium
	public static String captureScreenshots(String screenShotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		// TakeScreenshot is an interface which is used to take the screenshots in test automation
		File source = ts.getScreenshotAs(OutputType.FILE);
		//getScreenshotAs is a method used in selenium to take the screenshots and which is coming from TakeScreenshot interface
		// OutputType.FILE --> create a temp file and we are storing it into the source
		String dest = "C:\\Users\\Lenovo\\eclipse-workspace\\Framework-Masterx\\ExtentReport\\" + screenShotName + ".png";
		//We have to store the screenshots in permanent location
		File destination = new File(dest);
		// We are passing the files here
		FileUtils.copyFile(source, destination);
		//FileUtils is a class which is used to perform some operations on files 
		//We are copying the file from temporary location to permanent location.
		return dest;
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
	}

}
