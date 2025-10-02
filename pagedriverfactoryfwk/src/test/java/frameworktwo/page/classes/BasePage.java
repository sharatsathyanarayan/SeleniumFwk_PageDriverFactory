package frameworktwo.page.classes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import frameworktwo.base.classes.PageDriver;

public class BasePage {

	WebDriverWait wait;

	public void type(By byLocator, String text) {
		PageDriver.getCurrentDriver().findElement(byLocator).sendKeys(text);
	}

	public void click(By byLocator) {
		PageDriver.getCurrentDriver().findElement(byLocator).click();
	}
	
	public void implicitWait(Duration duration) {
		PageDriver.getCurrentDriver().manage().timeouts().implicitlyWait(duration);
	}

	public void waitForElement(By byLocator) {
		wait = new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(byLocator));
	}

	public WebElement getWebElement(By byLocator) {
		return PageDriver.getCurrentDriver().findElement(byLocator);
	}

	public List<WebElement> getWebElements(By byLocator) {
		return PageDriver.getCurrentDriver().findElements(byLocator);
	}
	
	public String getText(By byLocator) {
		return PageDriver.getCurrentDriver().findElement(byLocator).getText();
	}
	
	public int getSize(By byLocator) {
		return PageDriver.getCurrentDriver().findElements(byLocator).size();
	}
	
	public void selectByOption(By byLocator, String option) {
		Select selectOption = new Select(getWebElement(byLocator));
		selectOption.selectByVisibleText(option);
	}
}
