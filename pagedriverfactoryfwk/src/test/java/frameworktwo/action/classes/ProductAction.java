package frameworktwo.action.classes;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import frameworktwo.base.classes.PageDriver;

public class ProductAction {
	
	WebDriver driver;
	
	public WebElement getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(WebElement productTitle) {
		this.productTitle = productTitle;
	}

	public ProductAction() {
		this.driver = PageDriver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css = ".title")
	WebElement productTitle;
	
	WebDriverWait wait;
	
	public void waitForProductTitle() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(productTitle));
		
	}

	
	
}
