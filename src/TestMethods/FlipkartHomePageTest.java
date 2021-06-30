package TestMethods;
import BaseClass.BaseClass;
import Pages.FlipkartHomePage;

public class FlipkartHomePageTest extends BaseClass {
	FlipkartHomePage flipkarthome;
	//FlipkartProductPage flipkartproduct;
	
	public FlipkartHomePageTest() {
		flipkarthome = new FlipkartHomePage();
		
		
	}

	
	 public void launchFlipkartApplication() {
		 flipkarthome.launchApplication();
	 }
	 public void SearchProduct( String productname) {
		          
				flipkarthome.searchProduct(productname);
				flipkarthome.submitSearch();
			flipkarthome.clickFirstProduct();
			 }

	 
	 
	 

}
