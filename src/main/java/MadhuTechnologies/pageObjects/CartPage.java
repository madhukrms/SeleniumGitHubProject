package MadhuTechnologies.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MadhuTechnologies.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".totalRow button")
	WebElement checkoutEle;

	@FindBy(xpath = "//div[@class='cartSection']/h3")
	List<WebElement> cartProducts;

	public boolean verifyProductDisplay(String ProductName) {

		boolean match = cartProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(ProductName));
		return match;

	}

	public CheckoutPage goToCheckOut() {
		checkoutEle.click();
		return new CheckoutPage(driver);
	}

}
