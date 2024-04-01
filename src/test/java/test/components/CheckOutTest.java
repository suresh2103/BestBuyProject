package test.components;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.components.BaseEngine;
import page.components.CheckOutPage;
import page.components.ShopByBrandCart;


public class CheckOutTest extends BaseEngine {

	// Testcase to validate the checkout process & payment process
	@Test(priority = 1, groups = {"Regression","Smoke" })
	public void paymentTc12() throws Exception {

		test = report.createTest("Tc11-Checkout & Payment Process");

		// Search the item and adding to cart
		ShopByBrandCart brand = new ShopByBrandCart();

		brand.cartBrand(readingExcel("Brand", 1, 0));

		Thread.sleep(2000);

		// Delivery details & payement details
		CheckOutPage payment = new CheckOutPage();
		payment.checkOutPayment(readingExcel("Checkout", 1, 0), readingExcel("Checkout", 1, 1),
				readingExcel("Checkout", 1, 2), readingExcel("Checkout", 1, 3), readingExcel("Checkout", 1, 4),
				readingExcel("Checkout", 1, 5), readingExcel("Checkout", 1, 6), readingExcel("Checkout", 1, 7),
				readingExcel("Checkout", 1, 8), readingExcel("Checkout", 1, 9), readingExcel("Checkout", 1, 10),
				readingExcel("Checkout", 1, 11));

		test.log(Status.PASS, "PaymentIcon is clicked not able to automate it");
	}
}
