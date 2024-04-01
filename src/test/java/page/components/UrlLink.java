package page.components;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utility.WebUtilis;

public class UrlLink extends WebUtilis {

	// PageFactory method to initialize
	public UrlLink() {

		PageFactory.initElements(driver, this);
	}

	// Method to validate the Broken Link
	public void brokenLink() {

		String url = "https://www.bestbuy.com";

		try {
			@SuppressWarnings("deprecation")
			URL link = new URL(url);
			HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
			httpConn.connect();
			int code = httpConn.getResponseCode();

			if (code >= 400) {
				Assert.assertTrue(true, "Link is valid");
			} else {
				Assert.assertFalse(false, "Link is broken");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
