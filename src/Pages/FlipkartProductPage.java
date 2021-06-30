package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import BaseClass.BaseClass;

public class FlipkartProductPage extends BaseClass {
	 
	@FindBy(xpath="//span[@class=\"_2P_LDn\"]")
	
	 WebElement submitpincode;
	
	@FindBy(xpath="(//div[contains(text(),'656')])[1]")
	
	 WebElement productprice;
	@FindBy(xpath="//button[normalize-space()='ADD TO CART']")
	WebElement addtocart;
	
	@FindBy(xpath="//button[normalize-space()='+']")
	 WebElement addquantity;
	@FindBy(xpath="/html/body/div[1]/div/div[2]/div/div/div[2]/div[1]/div/div/div/div[4]/div/span/div/div/span")
	 WebElement newvalue;
	
	public FlipkartProductPage(){
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
			
			addtocart.click();
			
		}
		
		public void increaseProductQuantity() {
			commonutil.waitForElement((By.xpath("//button[normalize-space()='+']")) , 10);
			addquantity.click();
		}

		public String newPriceAfterAddingNewQuantity() {
			return newvalue.getText();
		}

		public float printNewPriceAfterAddingNewQuantity() {
			 String newprice = newvalue.getText();
			 newprice = newprice.replaceAll("[₹,]","");
			 float FloatPrice = Float.parseFloat(newprice);
			 return FloatPrice;
		 }
		
		
		
		
		
		//public void checkAvailability() {
			
		
		/*WebDriverWait wait=new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOf(pincode)).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,350)", "");
			
		
			Actions action = new Actions(driver);
			action.moveToElement(pincode).click().build().perform();
			
		try {
			//WebElement pincode=driver.findElement(By.xpath("//div[contains(text(),'Enter pincode')]"));
			//to perform Scroll on application using Selenium
			
			
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
					.withTimeout(50, TimeUnit.SECONDS) 			
					.pollingEvery(5, TimeUnit.SECONDS) 			
					.ignoring(NoSuchElementException.class);
			wait.until(new Function<WebDriver, WebElement>(){
			
				public WebElement apply(WebDriver driver ) {
					return driver.findElement(By.xpath("//div[contains(text(),'Enter pincode')]/.."));
					
				}}
			);
			return;
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
	//}
		
}
