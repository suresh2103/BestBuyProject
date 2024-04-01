package base.components;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utility.WebUtilis;

public class BaseEngine extends WebUtilis {

	// open the report
	@BeforeSuite(alwaysRun = true)
	public static void beforeSuite() {

		html = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReport.html");
		report = new ExtentReports();
		report.attachReporter(html);
	}

	// open & maximize the browser & open the link
	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public static void beforeMethod(String browser) {

		if (browser.equalsIgnoreCase("firefox")) {

			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			driver = new FirefoxDriver(options);

		} else if (browser.equalsIgnoreCase("chrome")) {

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless=new");
			driver = new ChromeDriver(options);

		}
		driver.manage().window().maximize();
		driver.get(openURL("link"));
	}

	// after method report & quit the browser
	@AfterMethod(alwaysRun = true)
	public static void afterMethod() {
		report.flush();
		driver.quit();
	}
}