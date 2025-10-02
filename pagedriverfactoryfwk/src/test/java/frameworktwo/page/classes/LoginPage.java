package frameworktwo.page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import frameworktwo.base.classes.Config;

public class LoginPage extends BasePage{
	
	WebDriver driver;
	
	
	//This is orthodox way of using Page Factory
	
	/*public LoginPage() {
		
		this.driver = PageDriver.getCurrentDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user-name")
	@CacheLookup
	WebElement username;
	
	@FindBy(id = "password")
	@CacheLookup
	WebElement password;
	
	@FindBy(id = "login-button")
	WebElement loginButton;
	*/
	
	
	//Alternate approach
	
	By username = By.id("user-name");
	By password = By.id("password");
	By loginButton = By.id("login-button");
	
	
	public void login(String usrname, String pwd) {
		
		type(username, usrname);
		type(password, pwd);
		click(loginButton);
	}
	
	public void login() {
		
		type(username, Config.validUserName);
		type(password, Config.ValidPassword);
		click(loginButton);
	}

}
