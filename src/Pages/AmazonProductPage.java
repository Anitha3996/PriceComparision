package Pages;



import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;




public class AmazonProductPage extends BaseClass{
	
	@FindBy(xpath="//span[@id='priceblock_ourprice']")
	 WebElement productprice;
	
	@FindBy(id = "add-to-cart-button")
	 WebElement addToCartButton;
	
	   @FindBy(id="hlb-view-cart-announce")
	   WebElement gotocartpage;
	   @FindBy(id= "sc-subtotal-amount-activecart")
		private WebElement getamazonproductprice;
	
	public AmazonProductPage(){
		PageFactory.initElements(driver, this);
	}
	
			
	public String getProductPrice() {
		commonutil.waitForElement((By.xpath("//span[@class='B_NuCI']")) , 10);
		 
		 return productprice.getText();
	}
	public float printProductPrice() {
		 String price = productprice.getText();
		 price = price.replaceAll("[₹,]","");
		 float FloatPrice = Float.parseFloat(price);
		 return FloatPrice;
	 }
		
		
		public void addToCart() {
			addToCartButton.click();
			
		}
		public void navigateToCartPage() {
			gotocartpage.click();
		}
		public String getProductPriceinCart() {
			commonutil.waitForElement(By.id("sc-subtotal-amount-activecart"),30);
			 
			 return getamazonproductprice.getText();
		}
		public float printProductPriceinCart() {
			 String price = getamazonproductprice.getText();
			 price = price.replaceAll("[₹,]","");
			 float FloatPrice = Float.parseFloat(price);
			 return FloatPrice;
		 }
		
		
	
}
