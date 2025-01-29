package MadhuTechnologies.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import MadhuTechnologies.TestComponent.BaseTest;
import MadhuTechnologies.pageObjects.CartPage;
import MadhuTechnologies.pageObjects.CheckoutPage;
import MadhuTechnologies.pageObjects.ConfirmationPage;
import MadhuTechnologies.pageObjects.ProducCatalogue;

public class StandAloneTestPageObject extends BaseTest {

	@Test
	public void StandAloneTest() throws IOException {
		String productName = "ADIDAS ORIGINAL";
		ProducCatalogue producCatalogue = landingPage.loginApplication("asr@asr.com", "Selenium@1");
		List<WebElement> products = producCatalogue.getProductList();
		producCatalogue.addProductToCart(productName);
		CartPage cartPage = producCatalogue.goToCartPage();

		boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);

		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage = cartPage.goToCheckOut();
		checkoutPage.selectCountry("india");

		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();

		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));


	}

}
