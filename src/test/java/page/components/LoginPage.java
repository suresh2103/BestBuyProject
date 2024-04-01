package page.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utility.WebUtilis;

public class LoginPage extends WebUtilis {

	// WebElements
	@FindBy(xpath = "(//div[@class='country-selection']//child::a)[2]")
	WebElement country;

	@FindBy(xpath = "//div[@class='shop-account-menu']//child::button")
	WebElement accountIcon;

	@FindBy(xpath = "//a[text()='Sign In']")
	WebElement signinIcon;

	@FindBy(xpath = "//input[@id='fld-e']")
	WebElement emailId;

	@FindBy(xpath = "//input[@id='fld-p1']")
	WebElement passKey;

	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement submit;

	@FindBy(xpath = "(//div[@class='shop-account-menu']//child::span)[1]")
	WebElement userText;

	@FindBy(xpath = "//form[@name='logoutForm']//child::button")
	WebElement logOut;

	@FindBy(xpath = "//button[text()='Skip for now']")
	WebElement skipKey;

	@FindBy(xpath = "//h1[text()='Sign In to Best Buy']")
	WebElement errorText;

	@FindBy(xpath = "//input[@id='show-hide-password-toggle']")
	WebElement showPass;

	// PageFactory method to initialize
	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	// Method to validate the sign in/Login
	public void signIn(String id, String password) throws Exception {

		waitExplicit(country, 30);
		nrmlClick(country);
		waitImplicit(40);
		pageWait(40);
		waitExplicit(accountIcon, 20);
		nrmlClick(accountIcon);
		windowSwitch(signinIcon);
		textKey(emailId, id);
		textKey(passKey, password);
		waitExplicit(submit, 30);
		jClick(submit);
		pageWait(60);
		jClick(showPass);

		// waitExplicit(skipKey, 60);
		// nrmlClick(skipKey);
		// waitExplicit(userText, 60);

		String actual = elementText(errorText);
		String expected = "Sign In to Best Buy";

		screenshot("ValidSignin");

		Assert.assertEquals(actual, expected);

		// waitExplicit(logOut, 30);
		// nrmlClick(logOut);

	}

}
