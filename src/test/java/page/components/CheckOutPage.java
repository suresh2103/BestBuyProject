package page.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utility.WebUtilis;

public class CheckOutPage extends WebUtilis {

	// WebElements
	@FindBy(xpath = "(//input[@name='availability-selection'])[1]")
	WebElement pickUp;

	@FindBy(xpath = "//button[@data-store-id='852']")
	WebElement pickUpArea;

	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkOutIcon;

	@FindBy(xpath = "//button[text()='Continue as Guest']")
	WebElement guest;

	@FindBy(xpath = "//input[@id='firstName']")
	WebElement fName;

	@FindBy(xpath = "//input[@id='lastName']")
	WebElement lName;

	@FindBy(xpath = "//input[@id='street']")
	WebElement address;

	@FindBy(xpath = "//input[@id='city']")
	WebElement city;

	@FindBy(xpath = "//select[@id='state']")
	WebElement state;

	@FindBy(xpath = "//input[@id='zipcode']")
	WebElement zipCode;

	@FindBy(xpath = "//input[@id='user.emailAddress']")
	WebElement emailId;

	@FindBy(xpath = "//input[@id='user.phone']")
	WebElement phnNo;

	@FindBy(xpath = "//button[@data-track='Shipping: Save shipping address']")
	WebElement applyButton;

	@FindBy(xpath = "//span[text()='Continue to Payment Information']//parent::button")
	WebElement continuePayment;

	@FindBy(xpath = "//input[@id='number']")
	WebElement cardNo;

	@FindBy(xpath = "//select[@id='expMonth']")
	WebElement expMonth;

	@FindBy(xpath = "//select[@id='expYear']")
	WebElement expYear;

	@FindBy(xpath = "//input[@id='cvv']")
	WebElement cvv;

	@FindBy(xpath = "//span[text()='Place Your Order']//parent::button")
	WebElement placeOrder;

	@FindBy(xpath = "//span[text()='Place Your Order']")
	WebElement orderText;

	@FindBy(xpath = "//button[@aria-label='Close']")
	WebElement popupClose;

	@FindBy(xpath = "//button[text()='Switch to shipping']")
	WebElement pickupLink;

	// PageFactory method to initialize
	public CheckOutPage() {

		PageFactory.initElements(driver, this);
	}

	// Method to validate the Checkout Process & Payment process
	public void checkOutPayment(String firstName, String lastName, String addDetails, String place, String stateName,
			String pinCode, String email, String mobileNo, String cardNumber, String month, String year, String cvvNo)
			throws Exception {

		// CheckOut page
		waitClickable(checkOutIcon, 40);
		nrmlClick(checkOutIcon);
		waitClickable(guest, 40);
		nrmlClick(guest);

		// EmailAddress form
		pageWait(50);
		pageWait(50);
		waitClickable(fName, 40);
		textKey(fName, firstName);
		waitClickable(lName, 40);
		textKey(lName, lastName);
		waitClickable(address, 40);
		textKey(address, addDetails);
		waitClickable(city, 40);
		textKey(city, place);
		waitClickable(state, 40);
		dropDown(state, stateName);
		waitClickable(zipCode, 40);
		textKey(zipCode, pinCode);
		waitClickable(applyButton, 40);
		nrmlClick(applyButton);
		waitClickable(emailId, 40);
		textKey(emailId, email);
		waitClickable(phnNo, 40);
		textKey(phnNo, mobileNo);
		

		screenshot("Address Details");

		String actual = elementText(continuePayment);
		Assert.assertEquals(actual, "Continue to Payment Information");

		
	}
}