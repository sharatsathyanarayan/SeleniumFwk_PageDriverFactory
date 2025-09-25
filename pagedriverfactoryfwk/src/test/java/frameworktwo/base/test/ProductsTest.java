package frameworktwo.base.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import frameworktwo.base.classes.BaseTest;
import frameworktwo.page.classes.LoginPage;
import frameworktwo.page.classes.ProductsPage;

public class ProductsTest extends BaseTest {

	LoginPage loginClass = new LoginPage();
	ProductsPage productHomePage = new ProductsPage();

	@Test(priority = 1)
	public void loginTest() throws InterruptedException {
		loginClass.login("standard_user", "secret_sauce");
		productHomePage.waitForProductTitle();
		System.out.println(productHomePage.getProductTitle().getText().toString());
		assertEquals(productHomePage.getProductTitle().getText().toString(), "Products");
		
		System.out.println("No of items in the products page : " + productHomePage.getInventorySize());
		assertEquals(productHomePage.getInventorySize(), 6);
		
		productHomePage.addToCart();
		System.out.println("No of items added in the cart : " + productHomePage.getCartCount());
		assertEquals(productHomePage.getCartCount(), "6");

	}

	/*
	 * @Test(priority = 2) public void assertInventorySize() {
	 * 
	 * }
	 * 
	 * @Test(priority = 3) public void assertCartSize() {
	 * 
	 * }
	 */

}
