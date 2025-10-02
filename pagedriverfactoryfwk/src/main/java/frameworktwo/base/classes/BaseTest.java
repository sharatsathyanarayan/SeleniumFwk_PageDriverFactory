package frameworktwo.base.classes;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

	WebDriver driver = null;
	protected WebDriverWait wait = null;

	@BeforeClass
	public void setUp() {
		
		//setting up for local
		
		 // Turn off password manager, autofill & leak detection
		// Create a HashMap to store Chrome preferences
        Map<String, Object> chromePrefs = new HashMap<>();
        // Disable the credential enable service (prevents saving passwords)
        chromePrefs.put("credentials_enable_service", false);
        // Disable the built-in password manager
        chromePrefs.put("profile.password_manager_enabled", false);
        // Disable password leak detection (prevents the breach notification)
        chromePrefs.put("profile.password_manager_leak_detection", false);
        // Create ChromeOptions and set the experimental preferences
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

		
		if(Config.env.equals("local") && Config.browser.equals("chrome")) {
		driver = new ChromeDriver(options);
		PageDriver.getInstance().setDriver(driver);
		driver.get(Config.url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		}

	}

	@AfterClass
	public void tearDown() {
		PageDriver.getCurrentDriver().quit();
	}

}
