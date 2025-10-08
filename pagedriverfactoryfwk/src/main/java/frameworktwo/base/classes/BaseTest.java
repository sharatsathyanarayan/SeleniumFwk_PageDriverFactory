package frameworktwo.base.classes;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

	WebDriver driver = null;
	protected WebDriverWait wait = null;
	protected String browser = null;
	
	@Parameters({"browsername"})
	@BeforeClass
	public void setUp (String browsername) {

		// setting up for local

		Map<String, Object> chromePrefs = new HashMap<>();
		chromePrefs.put("credentials_enable_service", false);
		chromePrefs.put("profile.password_manager_enabled", false);
		chromePrefs.put("profile.password_manager_leak_detection", false);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		this.browser = browsername;
		
		//if (Config.env.equals("local") && Config.browser.equalsIgnoreCase("chrome")) {
		if (Config.env.equals("local") && this.browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver(options);
			PageDriver.getInstance().setDriver(driver);
			driver.get(Config.url);
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		}
		//if (Config.env.equals("local") && Config.browser.equalsIgnoreCase("firefox")) {
		if (Config.env.equals("local") && this.browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
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
