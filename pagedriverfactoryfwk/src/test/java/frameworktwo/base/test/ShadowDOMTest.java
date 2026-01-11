package frameworktwo.base.test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShadowDOMTest{
	
	@Test
	public void enterUserName() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://selectorshub.com/xpath-practice-page/");
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement userNameField = (WebElement)jse.executeScript("return document.querySelector('.jackPart').shadowRoot.querySelector('#kils')");
		
		//this works too
		//String js = "arguments[0].setAttribute('value','Sharat')";
		//((JavascriptExecutor) driver).executeScript(js, userNameField);
		
		userNameField.sendKeys("sharat");
		 
		Thread.sleep(5000);
		
		driver.quit();
		
		
	}

}
