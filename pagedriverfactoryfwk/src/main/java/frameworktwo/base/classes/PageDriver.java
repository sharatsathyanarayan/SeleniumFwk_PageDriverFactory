package frameworktwo.base.classes;

import org.openqa.selenium.WebDriver;

public class PageDriver {
	
	
	
	private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>();
	
	public static WebDriver getDriver() {
		return threadDriver.get();
	}
	
	public static void setDriver(WebDriver driver) {
		threadDriver.set(driver);
	}

}
