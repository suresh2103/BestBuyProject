package page.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utility.WebUtilis;

public class SearchAddItem extends WebUtilis {

	// WebElements
	@FindBy(xpath = "(//div[@class='country-selection']//child::a)[2]")
	WebElement country;

	@FindBy(xpath = "//input[@id='gh-search-input']")
	WebElement searchBox;

	@FindBy(xpath = "(//button[@type='submit'])[1]")
	WebElement searchIcon;

	@FindBy(xpath = "(//a[@class='sku-title'])[1]")
	WebElement selectItem;

	@FindBy(xpath = "(//button[@data-sku-id='6539902'])[1]")
	WebElement addToCart;

	@FindBy(xpath = "//a[text()='Go to Cart']")
	WebElement goCart;

	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkOut;

	//// PageFactory method to initialize
	public SearchAddItem() {

		PageFactory.initElements(driver, this);
	}

	// Method to search a product and adding to cart
	public void searchItem(String value) {

		waitExplicit(country, 40);
		nrmlClick(country);
		waitExplicit(searchBox, 40);
		textKey(searchBox, value);
		waitExplicit(searchIcon, 40);
		nrmlClick(searchIcon);
		waitClickable(addToCart, 40);
		jClick(addToCart);
		waitExplicit(goCart, 80);
		buttonClick(goCart);

		String actual = elementText(checkOut);

		Assert.assertEquals(actual, "Checkout");

		screenshot("Search&AddtoCart");
	}
}
