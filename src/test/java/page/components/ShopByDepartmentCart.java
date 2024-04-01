package page.components;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utility.WebUtilis;

public class ShopByDepartmentCart extends WebUtilis {

	// WebElements
	@FindBy(xpath = "(//div[@class='country-selection']//child::a)[2]")
	WebElement country;

	@FindBy(xpath = "//button[@aria-controls='flyout-container']")
	WebElement menuIcon;

	@FindBy(xpath = "//a[text()='Cooktops']")
	WebElement cookTop;

	@FindBy(xpath = "(//a[text()='French door refrigerators'])[1]")
	WebElement selectProduct;

	@FindBy(xpath = "//button[@data-sku-id='6261814']")
	WebElement CookTopProduct;

	@FindBy(xpath = "(//button[@data-sku-id='6488940'])[1]")
	WebElement rangesProduct;

	@FindBy(xpath = "//a[text()='Go to Cart']")
	WebElement goCart;

	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkOut;

	@FindBys({ @FindBy(xpath = "//ul[@class='hamburger-menu-flyout-list']//li//button") })
	public List<WebElement> menuList;

	@FindBys({ @FindBy(xpath = "//ul[@data-t='L2 Appliances']//li//button") })
	public List<WebElement> depList;

	@FindBys({ @FindBy(xpath = "//ul[@class='hamburger-menu-flyout-list hamburger-menu-flyout-sidecar-list']//li//a") })
	public List<WebElement> itemList;

	// PageFactory is intialized
	public ShopByDepartmentCart() {

		PageFactory.initElements(driver, this);
	}

	// Method to select the item by selecting department and adding to cart
	public void departmentCart1(String menu, String department, String item) throws Exception {

		waitExplicit(country, 40);
		nrmlClick(country);
		waitClickable(menuIcon, 40);
		nrmlClick(menuIcon);

		dropdownList(menuList, menu);
		dropdownList(depList, department);
		dropdownList(itemList, item);
		pageWait(40);
		waitClickable(rangesProduct, 40);
		jClick(rangesProduct);
		waitExplicit(goCart, 80);
		buttonClick(goCart);

		String actual = elementText(checkOut);

		Assert.assertEquals(actual, "Checkout");

		screenshot("ByDepartment");

	}

	// Method to select the item by selecting department and adding to cart
	public void departmentCart2(String menu, String department, String item) throws Exception {

		waitExplicit(country, 40);
		nrmlClick(country);
		waitClickable(menuIcon, 40);
		nrmlClick(menuIcon);

		dropdownList(menuList, menu);
		dropdownList(depList, department);
		dropdownList(itemList, item);
		waitClickable(CookTopProduct, 40);
		nrmlClick(CookTopProduct);
		waitExplicit(goCart, 80);
		buttonClick(goCart);

		String actual = elementText(checkOut);

		Assert.assertEquals(actual, "Checkout");

		screenshot("ByDepartment");

	}

}
