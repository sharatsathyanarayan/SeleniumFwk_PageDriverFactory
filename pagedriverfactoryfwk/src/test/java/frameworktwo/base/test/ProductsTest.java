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

	}

	@Test(priority = 2)
	public void assertInventorySize() {
		System.out.println("No of items in the products page : " + productHomePage.getInventorySize());
		assertEquals(productHomePage.getInventorySize(), 6);
	}

	@Test(priority = 3)
	public void assertCartSize() throws InterruptedException {
		productHomePage.addToCart();
		System.out.println("No of items added in the cart : " + productHomePage.getCartCount());
		assertEquals(productHomePage.getCartCount(), "6");

	}
	
	@Test(priority = 4)
	public void assertFirstItemNameAndPrice() throws InterruptedException{
		String option ="Name (Z to A)";
		productHomePage.selectOptionByText(option);
		Thread.sleep(3000);
		System.out.println("No of items added in the cart : " + productHomePage.get_First_Item_Name_In_The_Inventory_List());
		System.out.println("No of items added in the cart : " + productHomePage.get_First_Item_Price_In_The_Inventory_List());
		assertEquals(productHomePage.get_First_Item_Name_In_The_Inventory_List(), "Test.allTheThings() T-Shirt (Red)");
		assertEquals(productHomePage.get_First_Item_Price_In_The_Inventory_List(), "$15.99");

	}

}
