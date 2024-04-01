package test.components;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.components.BaseEngine;

import page.components.SearchAddItem;

public class SearchAddItemTest extends BaseEngine {

	// Testcase to validate the add to cart by search box
	@Test(priority = 1, groups = { "Regression", "Smoke" })
	public void searchItemTc07() throws Exception {

		test = report.createTest("Tc07-Adding Cart through search Icon");

		SearchAddItem search = new SearchAddItem();

		search.searchItem(readingExcel("SearchAdd", 1, 0));

		test.log(Status.PASS, "Added to cart");
	}

}
