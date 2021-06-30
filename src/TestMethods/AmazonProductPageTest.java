package TestMethods;

import Pages.AmazonProductPage;


public class AmazonProductPageTest {
	AmazonProductPage amazonproduct;
	public AmazonProductPageTest() {
		 amazonproduct = new AmazonProductPage();
	}
	
	public void getSelectedProductPrice() {
		amazonproduct.getProductPrice();
	}
	public float printSelectedProductPrice() {
		return amazonproduct.printProductPrice();
		
		
	}
	   
     public void addProductToCart() {
    	 amazonproduct.addToCart();
    	 amazonproduct.navigateToCartPage();   	 
     }
    
     
     public void getSelectedProductPriceinCart() {
 		amazonproduct.getProductPriceinCart();
 	}
 	public float printSelectedProductPriceinCart() {
 		return amazonproduct.printProductPriceinCart();
 		
 		
 	}
     
    	
}
