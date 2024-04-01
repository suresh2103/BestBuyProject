package test.components;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.components.BaseEngine;
import page.components.MenuPage;

public class MenuTest extends BaseEngine {

	// Testcase to validate the Menu icon and get title
	@Test(priority = 1, groups = { "Regression", "Smoke" })
	public void menuValidationTc14() throws Exception {

		test = report.createTest("Tc14-Menu validation");

		MenuPage menu = new MenuPage();

		menu.menuValidate(readingExcel("Menu", 1, 0), readingExcel("Menu", 1, 1), readingExcel("Menu", 1, 2));
		menu.randomMenu(readingExcel("Menu", 2, 0), readingExcel("Menu", 2, 1), readingExcel("Menu", 2, 2));
		menu.randomMenu(readingExcel("Menu", 3, 0), readingExcel("Menu", 3, 1), readingExcel("Menu", 3, 2));
		menu.randomMenu(readingExcel("Menu", 4, 0), readingExcel("Menu", 4, 1), readingExcel("Menu", 4, 2));
		menu.randomMenu(readingExcel("Menu", 5, 0), readingExcel("Menu", 5, 1), readingExcel("Menu", 5, 2));
		menu.randomMenu(readingExcel("Menu", 6, 0), readingExcel("Menu", 6, 1), readingExcel("Menu", 6, 2));

		test.log(Status.PASS, "Validation Succesfull");
	}

}
