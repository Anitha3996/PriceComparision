package Pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;
import utils.CommonUtility;


public class FlipkartHomePage extends BaseClass {
		
		/*
		@FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']")
		  WebElement closeloginpopupbuttonOld;
		
		@FindBy(xpath = "//input[@title='Search for products, brands and more']")
		   WebElement searchboxOld;
		
		@FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/button")  // //button[@type='submit']
		  WebElement searchsubmitOld;
		
		@FindBy(xpath="//a[contains(text(),'PHILIPS HP8100/46 Hair Dryer')]")
		   WebElement productOld;
		 */
	
	
	    private By closeLoginPopupButton = By.xpath("//button[@class='_2KpZ6l _2doB4z']");
	    private By searchBox = By.xpath("//input[@title='Search for products, brands and more']");
	    private By searchSubmit = By.xpath("//button[@type='submit']");
	    private By selectFirstproduct = By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div[2]/div/div[1]/div/a[1]");
	    private By productPrice = By.xpath("//div[@class='_30jeq3 _16Jk6d']");
	    private By addToCart = By.xpath("//button[normalize-space()='ADD TO CART']");
	    private By addQuantity=By.xpath("//button[normalize-space()='+']");
	    private By cartNewPrice = By.xpath("//div[normalize-space()='Total Amount']/../../div/span/div/div/span");
	
	
	
		public FlipkartHomePage() {
		    PageFactory.initElements(driver, this);
		}

		public void launchApplication() {
			driver.get(prop.getProperty("flipkarturl"));
			element(closeLoginPopupButton).click();
		}	
	
		public void searchProduct(String productname) {
			element(searchBox).click();
			element(searchBox).sendKeys(productname);
		}
		
		public void submitSearch() {
			element(searchSubmit).click();
		}		
		
		public void clickFirstProduct() {
			CommonUtility.waitBySeconds(10);
			element(selectFirstproduct).click();
			
	   }
		 
		
		
		
			
			public String getProductPrice() {
			  CommonUtility.waitForElement((By.xpath("//div[@class='_30jeq3 _16Jk6d']")) , 10);
				 
				 return element(productPrice).getText();
			}
			
			public float trimAndGetProductPrice(){
				 String price = element(productPrice).getText();
				  price=price.replaceAll("[^0-9.]", "");
				  float productPrice=Float.parseFloat(price);
				  return productPrice;
			}
			
			public void addToCart() {
				CommonUtility.waitForElement(By.xpath("//button[normalize-space()='ADD TO CART']"),30);
				element(addToCart).click();
				
				
			}
			
			public void increaseProductQuantity() {
				
				CommonUtility.waitForElement((By.xpath("//button[normalize-space()='+']")) , 50);
				element(addQuantity).click();
				driver.navigate().refresh();
				CommonUtility.waitBySeconds(30);
				
				
			}

			public String newPriceAfterAddingNewQuantity() {
				return element(cartNewPrice).getText();
			}

			public float printNewPriceAfterAddingNewQuantity() {
				CommonUtility.waitBySeconds(30);
				 String NewPriceCart = element(cartNewPrice).getText();
				 NewPriceCart=NewPriceCart.replaceAll("[^0-9.]", "");
				 float productPriceInCart=Float.parseFloat(NewPriceCart);
				  return productPriceInCart;
				 
			 }
			
		
		private WebElement element(By byPath) {
			return driver.findElement(byPath);
		}

		
}
