package frameworktwo.base.classes;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

	WebDriver driver = null;
	protected WebDriverWait wait = null;

	@BeforeClass
	public void setUp() {

		driver = new ChromeDriver();
		PageDriver.getInstance().setDriver(driver);
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

	}

	@AfterClass
	public void tearDown() {
		PageDriver.getCurrentDriver().quit();
	}

}
