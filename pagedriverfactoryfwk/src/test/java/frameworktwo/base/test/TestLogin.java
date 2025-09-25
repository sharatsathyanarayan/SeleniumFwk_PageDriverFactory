package frameworktwo.base.test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import frameworktwo.base.classes.BaseTest;
import frameworktwo.page.classes.LoginPage;
import frameworktwo.page.classes.ProductsPage;

public class TestLogin extends BaseTest {

	WebDriver driver = null;

	@Test
	public void loginTest() throws InterruptedException {

		LoginPage loginClass = new LoginPage();
		loginClass.login("standard_user", "secret_sauce");
		
		ProductsPage productHomePage = new ProductsPage();
		productHomePage.waitForProductTitle();
		
		System.out.println(productHomePage.getProductTitle().getText().toString());
		assertEquals(productHomePage.getProductTitle().getText().toString(), "Products");

	}

}
