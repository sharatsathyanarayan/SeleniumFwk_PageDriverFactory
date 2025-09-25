package frameworktwo.base.test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import frameworktwo.base.classes.BaseTest;
import frameworktwo.page.classes.LoginFailurePage;
import frameworktwo.page.classes.LoginPage;

public class TestLogin_negative extends BaseTest {

	WebDriver driver = null;

	@Test
	public void loginNegativeTest() {

		LoginPage loginClass = new LoginPage();
		loginClass.login("standard_user", "wrong_password");
		
		LoginFailurePage failureToLogin = new LoginFailurePage();
		

		assertEquals(failureToLogin.getLoginFailureText().getText().toString(), "Epic sadface: Username and password do not match any user in this service");


	}

}
