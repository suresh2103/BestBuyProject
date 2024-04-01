package test.components;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import base.components.BaseEngine;
import page.components.CreateAccount;

public class AccountCreationTest extends BaseEngine {

	//Test case for Valid account creation
	@Test(priority = 1, groups = { "Regression", "Smoke" })
	public static void creationTc05() throws Exception {

		test = report.createTest("Tc05-Account Creation with valid Credentials");

		CreateAccount validCreation = new CreateAccount();

		validCreation.accountCreation(readingExcel("AccountCreationInput", 1, 0),
				readingExcel("AccountCreationInput", 1, 1), readingExcel("AccountCreationInput", 1, 2),
				readingExcel("AccountCreationInput", 1, 3), readingExcel("AccountCreationInput", 1, 4),
				readingExcel("AccountCreationInput", 1, 5));

		test.log(Status.PASS, "Account Creation Succesfull");
	}

	//Test case for account creation with invalid credentials
	@Test(priority = 2, groups = { "Regression" })
	public static void creationTc06() throws Exception {

		test = report.createTest("Tc06-Account Creation with invalid Credentials");

		CreateAccount validCreation = new CreateAccount();

		validCreation.accountCreation(readingExcel("AccountCreationInput", 2, 0),
				readingExcel("AccountCreationInput", 2, 1), readingExcel("AccountCreationInput", 2, 2),
				readingExcel("AccountCreationInput", 2, 3), readingExcel("AccountCreationInput", 2, 4),
				readingExcel("AccountCreationInput", 2, 5));

		test.log(Status.PASS, "Account Creation unSuccesfull");
	}
}
