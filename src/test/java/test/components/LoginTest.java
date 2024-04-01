package test.components;


import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import base.components.BaseEngine;
import page.components.LoginPage;

public class LoginTest extends BaseEngine {

	// Test case to validate the signin functionality with valid credentials
	@Test(priority = 1, groups = { "Regression", "Smoke" })
	public void signinTc01() throws Exception {

		test = report.createTest("Tc01-Sign-in with valid Credentials");

		LoginPage validLogin = new LoginPage();

		validLogin.signIn(readingExcel("Login", 1, 0), readingExcel("Login", 1, 1));

		test.log(Status.PASS, "Login Succesfull");
	}

	// Test case to validate the signin functionality with invalid credentials
	@Test(priority = 2, groups = { "Regression" })
	public void signinTc02() throws Exception {

		test = report.createTest("Tc02-Sign-in with Invalid password & valid password");

		LoginPage validLogin = new LoginPage();

		validLogin.signIn(readingExcel("Login", 2, 0), readingExcel("Login", 2, 1));

		test.log(Status.PASS, "Login Un-Succesfull");
	}

	// Test case to validate the signin functionality with invalid credentials
	@Test(priority = 11, groups = { "Regression" })
	public void signinTc03() throws Exception {

		test = report.createTest("Tc03-Sign-in with valid password & invalid password");

		LoginPage validLogin = new LoginPage();

		validLogin.signIn(readingExcel("Login", 3, 0), readingExcel("Login", 3, 1));

		test.log(Status.PASS, "Login Un-Succesfull");
	}

	// Test case to validate the signin functionality with invalid credentials
	@Test(priority = 12, groups = { "Regression" })
	public void signinTc04() throws Exception {

		test = report.createTest("Tc04-Sign-in with invalid password & invalid password");

		LoginPage validLogin = new LoginPage();

		validLogin.signIn(readingExcel("Login", 4, 0), readingExcel("Login", 4, 1));

		test.log(Status.PASS, "Login Un-Succesfull");
	}
}
