package frameworktwo.base.classes;

import org.openqa.selenium.WebDriver;

public class PageDriver {
	
	
	
	private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>();
	
	//start of singleton pattern
	private static PageDriver instance = null;
	
	private PageDriver() {
		
	}
	
	public static PageDriver getInstance() {
		if(instance == null) {
			instance = new PageDriver();
		}
		return instance;
	}
	//end of singleton pattern
	
	
	
	public WebDriver getDriver() {
		return threadDriver.get();
	}
	
	public void setDriver(WebDriver driver) {
		threadDriver.set(driver);
	}
	
	public static WebDriver getCurrentDriver() {
		return PageDriver.getInstance().getDriver();
		
	}
	
	public void removeDriver() {
	    threadDriver.remove();
	}

}
