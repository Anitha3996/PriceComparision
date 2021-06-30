package TestMethods;


import BaseClass.BaseClass;
import Pages.AmazonHomePage;
import Pages.AmazonProductPage;


public class AmazonHomePageTest extends BaseClass {
	AmazonHomePage amazonhome;
	AmazonProductPage amazonproduct;
	
	public AmazonHomePageTest() {
		amazonhome=new AmazonHomePage ();
		 amazonproduct=new AmazonProductPage();

		
}
	 	 public void launchAmazonApplication() {
		 	
		        amazonhome.launchApplication();
		        
		        
	 	 }
	 	 public void SearchProduct( String productname) {
	          
	 		amazonhome.searchProduct(productname);
	 		amazonhome.submitSearch();
	 		amazonhome.clickFirstProduct();
			 }
	 	 
	 	 
	 	 
	 
		        
				
}	
			
		 
	 

