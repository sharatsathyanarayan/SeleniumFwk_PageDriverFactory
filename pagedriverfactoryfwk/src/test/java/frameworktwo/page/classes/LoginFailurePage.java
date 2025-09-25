package frameworktwo.page.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import frameworktwo.base.classes.PageDriver;

public class LoginFailurePage {
	
WebDriver driver;
	
	public LoginFailurePage() {
		
		this.driver = PageDriver.getCurrentDriver();
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css = "h3[data-test='error']")
	WebElement loginFailureText;

	public WebElement getLoginFailureText() {
		return loginFailureText;
	}


	public void setLoginFailureText(WebElement loginFailureText) {
		this.loginFailureText = loginFailureText;
	}
	
	

}
