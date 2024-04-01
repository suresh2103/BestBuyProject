package page.components;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utility.WebUtilis;

public class ShopByBrandCart extends WebUtilis {

	// WebElements
	@FindBy(xpath = "(//div[@class='country-selection']//child::a)[2]")
	WebElement country;

	@FindBy(xpath = "//button[@aria-controls='flyout-container']")
	WebElement menuIcon;

	@FindBy(xpath = "//button[@data-id='node-82']")
	WebElement brandsIcon;

	@FindBys({ @FindBy(xpath = "//ul[@class='hamburger-menu-flyout-list hamburger-menu-flyout-sidecar-list']//li/a") })
	public List<WebElement> searchBrand;

	@FindBy(xpath = "//a[text()='PS5 Consoles']")
	WebElement selectItem;

	@FindBy(xpath = "//a[text()='LG appliances']")
	WebElement selectLG;

	@FindBy(xpath = "//a[text()='LG ranges']")
	WebElement selectListLG;

	@FindBy(xpath = "//button[@data-sku-id='6450224']")
	WebElement addCartLG;

	@FindBy(xpath = "(//button[@data-sku-id='6566040'])[1]")
	WebElement addCart;

	@FindBy(xpath = "//a[text()='Go to Cart']")
	WebElement goCart;

	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkOut;

	// PageFactory method to initialize
	public ShopByBrandCart() {

		PageFactory.initElements(driver, this);
	}

	// Method to select the brand and select the item to add to cart
	public void cartBrand(String brandName) throws Exception {

		waitExplicit(country, 40);
		nrmlClick(country);
		waitClickable(menuIcon, 40);
		nrmlClick(menuIcon);
		waitClickable(brandsIcon, 40);
		nrmlClick(brandsIcon);
		dropdownList(searchBrand, brandName);
		waitClickable(selectItem, 40);
		nrmlClick(selectItem);
		scroll();
		jClick(addCart);
		waitExplicit(goCart, 80);
		buttonClick(goCart);

		String actual = elementText(checkOut);

		Assert.assertEquals(actual, "Checkout");

		screenshot("ByBrandName");

	}

	// Method to select the alternate brand and select the item to add to cart
	public void cartBrandLG(String brandName) throws Exception {

		waitExplicit(country, 40);
		nrmlClick(country);
		waitClickable(menuIcon, 40);
		nrmlClick(menuIcon);
		waitClickable(brandsIcon, 40);
		nrmlClick(brandsIcon);
		dropdownList(searchBrand, brandName);
		waitClickable(selectLG, 40);
		nrmlClick(selectLG);
		waitClickable(selectListLG, 40);
		nrmlClick(selectListLG);
		pageWait(40);
		waitClickable(addCartLG, 40);
		jClick(addCartLG);
		waitExplicit(goCart, 80);
		buttonClick(goCart);

		String actual = elementText(checkOut);

		Assert.assertEquals(actual, "Checkout");

		screenshot("ByBrandName");

	}
}
