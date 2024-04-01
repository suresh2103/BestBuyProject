package test.components;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.components.BaseEngine;
import page.components.ShopByBrandCart;

public class ShopByBrandTest extends BaseEngine {

	// Test case to validate the add to cart by clicking on brand
	@Test(priority = 2, groups = { "Regression", "Smoke" })
	public void brandCartTc10() throws Exception {

		test = report.createTest("Tc10--Adding Cart through Brand");

		ShopByBrandCart brand = new ShopByBrandCart();

		brand.cartBrand(readingExcel("Brand", 1, 0));

		test.log(Status.PASS, "Added to cart");
	}

	// Test case to validate the add to cart by clicking on brand
	@Test(priority = 1, groups = { "Regression"})
	public void brandCartTc11() throws Exception {

		test = report.createTest("Tc11--Adding Cart through Brand");

		ShopByBrandCart brand1 = new ShopByBrandCart();

		brand1.cartBrandLG(readingExcel("Brand", 2, 0));

		test.log(Status.PASS, "Added to cart");
	}

}
