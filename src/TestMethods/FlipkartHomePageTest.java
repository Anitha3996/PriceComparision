package TestMethods;
import java.util.Iterator;
import java.util.Set;

import BaseClass.BaseClass;
import Pages.FlipkartHomePage;

public class FlipkartHomePageTest extends BaseClass {
	FlipkartHomePage flipkartHomePageObj;
	
	
	public FlipkartHomePageTest() {
		flipkartHomePageObj = new FlipkartHomePage();
		
		
	}

	//Launch Flipkart Applicaton
	 public void launchFlipkartApplication() {
		 flipkartHomePageObj.launchApplication();
	 }
	 
	 //Search an product
	 public void SearchProduct( String productname) {
				flipkartHomePageObj.searchProduct(productname);
				flipkartHomePageObj.submitSearch();
				flipkartHomePageObj.clickFirstProduct();
			 }
	//Get Price of the selected Product
		public void getSelectedProductPrice() {
			 //CommonUtility.navigateAndTakeControlToNewTab(0);
			
			Set<String> windows = driver.getWindowHandles();
			
			String parent = driver.getWindowHandle();
			
			windows.remove(parent);
			
			Iterator<String> it = windows.iterator(); 
			String child=null; //This is for referencing specific child window 
			while(it.hasNext()){ 
			child=it.next(); 
			driver.switchTo().window(child); 
			 
			} 
			flipkartHomePageObj.getProductPrice();
		}
		
		public float printSelectedProductPrice(){
			return flipkartHomePageObj.trimAndGetProductPrice();
			
		}
		
		  
		//add product to Cart
	     public void addProductToCart() {
	    	flipkartHomePageObj.addToCart();
	        }
	     
	     //Add one more Quantity to the cart
	     public void increaseProductQuantity() {
	    	 flipkartHomePageObj.increaseProductQuantity();
	    	 flipkartHomePageObj.newPriceAfterAddingNewQuantity();
	     }
	     
	     //Print the new price after adding the quatity
	    	 public float printSelectedProductPriceAfterAddingNewQuantity() {
	    	 return flipkartHomePageObj.printNewPriceAfterAddingNewQuantity();
	    	 
	     }

	 
	 
	 

}
