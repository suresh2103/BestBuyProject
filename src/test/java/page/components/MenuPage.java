package page.components;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utility.WebUtilis;

public class MenuPage extends WebUtilis {

	// WebElements
	@FindBy(xpath = "(//div[@class='country-selection']//child::a)[2]")
	WebElement country;

	@FindBy(xpath = "//button[@aria-controls='flyout-container']")
	WebElement menuIcon;

	@FindBys({ @FindBy(xpath = "//ul[@class='hamburger-menu-flyout-list']//li//button") })
	public List<WebElement> menuList;

	@FindBys({ @FindBy(xpath = "//ul[@class='hamburger-menu-flyout-list hamburger-menu-flyout-sidecar-list']//li/a") })
	public List<WebElement> subMenuList;

	// PageFactory method to initialize
	public MenuPage() {

		PageFactory.initElements(driver, this);
	}

	// validate the Menu icon and Get title
	public void menuValidate(String menu, String subMenu, String expTitle) throws Exception {

		waitClickable(country, 40);
		nrmlClick(country);
		waitClickable(menuIcon, 40);
		nrmlClick(menuIcon);
		dropdownList(menuList, menu);
		dropdownList(subMenuList, subMenu);

		String actual = getTitle();
		String expected = expTitle;

		screenshot("MenuValidation");

		Assert.assertEquals(actual, expected);

		navBack();
	}

	// Validating the menu & subMenu
	public void randomMenu(String menu, String subMenu, String expTitle) throws Exception {

		pageWait(40);
		waitClickable(menuIcon, 40);
		nrmlClick(menuIcon);
		dropdownList(menuList, menu);
		dropdownList(subMenuList, subMenu);

		pageWait(80);
		String actual = getTitle();
		String expected = expTitle;

		screenshot("MenuValidation");

		Assert.assertEquals(actual, expected);

		navBack();
	}
}
