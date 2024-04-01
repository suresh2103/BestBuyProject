package page.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utility.WebUtilis;

public class CreateAccount extends WebUtilis {

	// WebElements
	@FindBy(xpath = "(//div[@class='country-selection']//child::a)[2]")
	WebElement country;

	@FindBy(xpath = "//div[@class='shop-account-menu']//child::button")
	WebElement accountIcon;

	@FindBy(xpath = "//a[text()='Create Account']")
	WebElement createAccountButton;

	@FindBy(xpath = "//input[@id='firstName']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='lastName']")
	WebElement lastName;

	@FindBy(xpath = "//input[@id='email']")
	WebElement emailId;

	@FindBy(xpath = "(//input[@type='password'])[1]")
	WebElement passwordInput;

	@FindBy(xpath = "(//input[@type='password'])[2]")
	WebElement confirmPassword;

	@FindBy(xpath = "//input[@id='phone']")
	WebElement mobileNumber;

	@FindBy(xpath = "//button[text()='Create an Account']")
	WebElement submit;

	@FindBy(xpath = "(//div[@class='shop-account-menu']//child::span)[1]")
	WebElement userText;

	@FindBy(xpath = "//form[@name='logoutForm']//child::button")
	WebElement logOut;

	@FindBy(xpath = "//h1[text()='Create an Account']")
	WebElement textUser;

	// PageFactory method to initialize
	public CreateAccount() {

		PageFactory.initElements(driver, this);
	}

	// Method to validate the createAccount Process
	public void accountCreation(String fName, String lName, String mailId, String passKey, String reconfirmPassKey,
			String phoneNumber) throws Exception {

		// Select the country
		waitImplicit(50);
		waitExplicit(country, 30);
		buttonClick(country);

		// Account details
		jClick(accountIcon);
		windowSwitch(createAccountButton);
		textKey(firstName, fName);
		textKey(lastName, lName);
		textKey(emailId, mailId);
		textKey(passwordInput, passKey);
		textKey(confirmPassword, reconfirmPassKey);
		textKey(mobileNumber, phoneNumber);
		waitExplicit(submit, 40);
		buttonClick(submit);

		String actual = elementText(textUser);
		String expected = "Create an Account";

		screenshot("AccountCreation");

		Assert.assertEquals(actual, expected);

		// waitExplicit(logOut, 5);
		// buttonClick(logOut);

	}
}
