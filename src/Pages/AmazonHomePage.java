package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;

public class AmazonHomePage extends BaseClass {
	
@FindBy(xpath="//div[@class=\"nav-search-field \"]//following-sibling::input")
WebElement searchbox;
@FindBy(xpath="//input[@type='submit' and @value=\"Go\"]")
WebElement searchsubmit;
@FindBy(xpath="//span[contains(text(),'Philips HP8100/46 Hair Dryer')]")
WebElement product;
public AmazonHomePage() {
		PageFactory.initElements(driver, this);
	}
		
public void launchApplication() {
	driver.get(prop.getProperty("amazonurl"));
	
	
}
public void searchProduct(String product) {
	searchbox.click();
	searchbox.sendKeys("product");
}

public void submitSearch() {
	searchsubmit.click();
	
	
}
public AmazonProductPage clickFirstProduct() {
	commonutil.waitForElement(By.xpath("//span[contains(text(),'Philips HP8100/46 Hair Dryer')]"),30);
	product.click();
	return new AmazonProductPage();
	
}

}
