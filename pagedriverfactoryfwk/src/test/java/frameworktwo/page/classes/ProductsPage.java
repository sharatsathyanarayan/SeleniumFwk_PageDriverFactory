package frameworktwo.page.classes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends BasePage {

	WebDriver driver;
	WebDriverWait wait;
	WebElement productTitleElement;

	public WebElement getProductTitle() {
		return getWebElement(productTitle);
	}

	public void setProductTitle(By productTitle) {
		this.productTitleElement = getWebElement(productTitle);
	}
	/*
	 * public ProductsPage() { this.driver = PageDriver.getCurrentDriver();
	 * PageFactory.initElements(driver, this); }
	 * 
	 * 
	 * @FindBy(css = ".title") WebElement productTitle;
	 */

	By productTitle = By.cssSelector(".title");
	By inventoryItems = By.cssSelector(".inventory_item");
	By add_To_Cart_Buttons = By.cssSelector(".inventory_item button");
	By shopping_Cart_Badge = By.cssSelector(".shopping_cart_badge");
	By inventory_item_name = By.cssSelector(".inventory_item:nth-child(1) .inventory_item_name");
	By dropDown = By.cssSelector(".product_sort_container");
	By inventory_item_price = By.cssSelector(".inventory_item:nth-child(1) .inventory_item_price");
	

	public void waitForProductTitle() {
		waitForElement(productTitle);
	}
	
	public int getInventorySize() {
		return getSize(inventoryItems);
	}
	
	public void addToCart() throws InterruptedException {
		System.out.println(getWebElements(add_To_Cart_Buttons).size());
		for(WebElement el: getWebElements(add_To_Cart_Buttons)) {
			Thread.sleep(3000);
			el.click();
		}
	}
	
	public String getCartCount() {
		return getText(shopping_Cart_Badge);
	}
	
	public String get_First_Item_Name_In_The_Inventory_List() {
		return getText(inventory_item_name);
	}
	
	public String get_First_Item_Price_In_The_Inventory_List() {
		return getText(inventory_item_price);
	}
	
	public void selectOptionByText(String option) {
		 selectByOption(dropDown,option);
	}
}
