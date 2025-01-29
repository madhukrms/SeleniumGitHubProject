package MadhuTechnologies.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MadhuTechnologies.AbstractComponents.AbstractComponent;


public class LandingPage extends AbstractComponent {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);


	}

//	driver.findElement(By.id("userEmail")).sendKeys("asr@asr.com");
//	driver.findElement(By.id("userPassword")).sendKeys("Selenium@1");
//	driver.findElement(By.id("login")).click();

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement passwordEle;

	@FindBy(id = "login")
	WebElement submit;

	public ProducCatalogue loginApplication(String email, String password) {

		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		ProducCatalogue producCatalogue = new ProducCatalogue(driver);
		return producCatalogue;

	}
	
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
		
	}


}
