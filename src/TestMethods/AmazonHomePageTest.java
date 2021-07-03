package TestMethods;


import java.util.Iterator;
import java.util.Set;

import BaseClass.BaseClass;
import Pages.AmazonHomePage;



public class AmazonHomePageTest extends BaseClass {
	AmazonHomePage amazonHomePageObj;
	
	
	//Constructor
	public AmazonHomePageTest() {
		amazonHomePageObj=new AmazonHomePage ();
		

		
}
	//Launch Amazon Application
	 	 public void launchAmazonApplication() {
		 	
		        amazonHomePageObj.launchApplication();
		        
		        
	 	 }
	 	 
	 	 //Search an Product
	 	 public void SearchProduct(String productname) {
	          
	 		amazonHomePageObj.searchProduct(productname);
	 		amazonHomePageObj.submitSearch();
	 		amazonHomePageObj.clickFirstProduct();
			 }
	 	 
	 	//Get the Amazon product price
	 	public void getSelectedProductPrice() {
            Set<String> windows = driver.getWindowHandles();
			
			String parent = driver.getWindowHandle();
			
			windows.remove(parent);
			
			Iterator<String> it = windows.iterator(); 
			String child=null; //This is for referencing specific child window 
			while(it.hasNext()){ 
			child=it.next(); 
			driver.switchTo().window(child); 
			 
			} 
	 		amazonHomePageObj.getProductPrice();
	 	}
	 	//Print the amazon product price
	 	public float printSelectedProductPrice() {
	 		return amazonHomePageObj.trimAndGetProductPrice();
	 		
	 		
	 	}
	 	 //Add the product to the cart
	      public void addProductToCart() {
	     	 amazonHomePageObj.addToCart();
	     	 amazonHomePageObj.navigateToCartPage();   	 
	      }
	     
	      //Get the price from the cart
	      public void getSelectedProductPriceinCart() {
	  		amazonHomePageObj.getProductPriceinCart();
	  	}
	      
	     //Print the price from the cart
	  	public float printSelectedProductPriceinCart() {
	  		return amazonHomePageObj.trimAndGetProductPriceInCart();
	  		
	  		
	  	}
	 	 
	 
		        
				
}	
			
		 
	 

