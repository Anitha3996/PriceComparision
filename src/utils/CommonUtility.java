package utils;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseClass.BaseClass;

public class CommonUtility {
	  private static WebDriver driver;
	  private static WebDriverWait wait;
	  
	  //Driver initialization
	  public static void initializeDriver(WebDriver webDriver) {
			  driver = webDriver;
	  }
       
	  //explicit wait
	   public static void waitForElement(By locator, int seconds) {
	    	wait = new WebDriverWait(driver,seconds);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }
	    
	    // Makes the driver wait by the given seconds.
	    public static void waitBySeconds(int seconds) {
	    	driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	    }	    
	    
	    //compare the price of the product in Flipkart and Amazon
	    public static void comparePrices(float flipkartPrice,float amazonPrice)
	    {
	    	if(flipkartPrice > amazonPrice)
	    	{
	    		System.out.println("***********************************************************");
	    		System.out.println("Product rate is cheaper on Amazon compared to Flipkart");
	    		System.out.println("***********************************************************");
	    	}
	    	else if(amazonPrice > flipkartPrice)
	    	{
	    		System.out.println("***********************************************************");
	    		System.out.println("Product rate is cheaper on Flipkart compared to Amazon");
	    		System.out.println("***********************************************************");
	    	}
	    	else
	    	{
	    		System.out.println("***********************************************************");
	    		
	    		System.out.println("Product has same price on both the application");
	    		System.out.println("***********************************************************");
	    	}
	    }
	    
	    public static void navigateAndTakeControlToNewTab(int tabNumber)
	    {
	    	ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs1.get(tabNumber+1));
	    }
	    
	   
	    
}
