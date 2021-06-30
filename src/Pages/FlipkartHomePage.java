package Pages;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;


public class FlipkartHomePage extends BaseClass {
	
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']")
	  WebElement closeloginpopupbutton;
	
	@FindBy(xpath = "//input[@title='Search for products, brands and more']")
	   WebElement searchbox;
	
	@FindBy(xpath="//button[@type='submit']")
	  WebElement searchsubmit;
	
	@FindBy(xpath="//a[contains(text(),'PHILIPS HP8100/46 Hair Dryer')]")
	   WebElement product;
	
	
public FlipkartHomePage() {
	    
	    PageFactory.initElements(driver, this);
	}
	public void launchApplication() {
		driver.get(prop.getProperty("flipkarturl"));
		
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		
	}
	
	
	public void searchProduct(String productname) {
		driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).click();
		driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys(productname);
	}
		public void submitSearch() {
		searchsubmit.click();
		}
		
		
		
		public FlipkartProductPage clickFirstProduct() {
		commonutil.waitForElement(By.xpath("//a[contains(text(),'PHILIPS HP8100/46 Hair Dryer')]"),30);
		product.click();
		return new FlipkartProductPage();
		
	}

		
	
}
