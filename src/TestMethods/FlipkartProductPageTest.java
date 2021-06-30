package TestMethods;

import BaseClass.BaseClass;
import Pages.FlipkartProductPage;

public class FlipkartProductPageTest extends BaseClass{
	FlipkartProductPage flipkartproduct;
	public FlipkartProductPageTest() {
		 flipkartproduct = new FlipkartProductPage();
	}
	
	public void getSelectedProductPrice() {
		flipkartproduct.getProductPrice();
	}
	public float printSelectedProductPrice() {
		return flipkartproduct.printProductPrice();
		
		
	}
	   
     public void addProductToCart() {
    	 flipkartproduct.addToCart();
    	 
     }
     
     public void increaseProductQuantity() {
    	 flipkartproduct.increaseProductQuantity();
    	 flipkartproduct.newPriceAfterAddingNewQuantity();
     }
     
    	 public float printSelectedProductPriceAfterAddingNewQuantity() {
    	 return flipkartproduct.printNewPriceAfterAddingNewQuantity();
    	 
     }
}
