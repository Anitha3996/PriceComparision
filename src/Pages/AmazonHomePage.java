package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;
import utils.CommonUtility;

public class AmazonHomePage extends BaseClass {
	
/*@FindBy(xpath="//div[@class=\"nav-search-field \"]//following-sibling::input")
WebElement searchbox;
@FindBy(xpath="//input[@type='submit' and @value=\"Go\"]")
WebElement searchsubmit;
@FindBy(xpath="//span[contains(text(),'Philips HP8100/46 Hair Dryer')]")
WebElement product;*/

private By searchBox = By.xpath("//div[@class=\"nav-search-field \"]//following-sibling::input");
private By searchSubmit = By.xpath("//input[@type='submit' and @value=\"Go\"]");
private By selectFirstProduct = By.xpath("//span[contains(text(),'Philips HP8100/46 Hair Dryer')]");
private By productPrice = By.xpath("//span[@id='priceblock_ourprice']");
private By addToCartButton = By.id("add-to-cart-button");
private By goToCartPage = By.id("hlb-view-cart-announce");
//private By selectFirstproduct = By.id("sc-subtotal-amount-activecart");
private By getAmazonCartPrice = By.id("sc-subtotal-amount-activecart");



public AmazonHomePage() {
		PageFactory.initElements(driver, this);
	}
		
public void launchApplication() {
	driver.get(prop.getProperty("amazonurl"));
	
	
}
public void searchProduct(String product) {
	element(searchBox).sendKeys(product);
}

public void submitSearch() {
	element(searchSubmit).click();
	
	
}
public void clickFirstProduct() {
	CommonUtility.waitForElement(By.xpath("//span[contains(text(),'Philips HP8100/46 Hair Dryer')]"),30);
	element(selectFirstProduct).click();
	
	
}




	
public String getProductPrice() {
CommonUtility.waitForElement((By.xpath("//span[@id='priceblock_ourprice']")) , 10);
 
 return element(productPrice).getText();
}
public float trimAndGetProductPrice(){
	 String price = element(productPrice).getText();
	  price=price.replaceAll("[^0-9.]", "");
	  float productPrice=Float.parseFloat(price);
	  return productPrice;
}


public void addToCart() {
	element(addToCartButton).click();
	
}
public void navigateToCartPage() {
	element(goToCartPage).click();
}
public String getProductPriceinCart() {
	CommonUtility.waitForElement(By.id("sc-subtotal-amount-activecart"),30);
	 
	 return element(getAmazonCartPrice).getText();
}
public float trimAndGetProductPriceInCart(){
	 String price = element(getAmazonCartPrice).getText();
	  price=price.replaceAll("[^0-9.]", "");
	  float productPrice=Float.parseFloat(price);
	  return productPrice;
}
private WebElement element(By byPath) {
	return driver.findElement(byPath);
}

}
