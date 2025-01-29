package MadhuTechnologies.TestComponent;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import MadhuTechnologies.pageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	
	public LandingPage landingPage;

	public WebDriver initializeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\main\\java\\MadhuTechnologies\\Resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//		} else if (browserName.equalsIgnoreCase("firefox")) {
//			// Enter the firefox driver initialization code
//		}
//
//		else if (browserName.equalsIgnoreCase("edge")) {
//			// Enter the edge driver initialization code
		}


		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		return driver;

	}

	@BeforeMethod
	public LandingPage launchApplication() throws IOException {
		
		driver= initializeDriver();

		landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	



}
