package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseClass.BaseClass;

public class CommonUtility extends BaseClass{
	 private  WebDriverWait wait;

	    public  void waitForElement(By locator, int seconds) {
	    	 wait = new WebDriverWait(driver,seconds);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	        
	        
}
	    
	    
	    public void comparePrices(float flipkartPrice,float amazonPrice)
	    {
	    	if(flipkartPrice > amazonPrice)
	    	{
	    		System.out.println("Product rate is cheaper on Amazon");
	    	}
	    	else if(amazonPrice > flipkartPrice)
	    	{
	    		System.out.println("Product rate is cheaper on Flipkart");
	    	}
	    	else
	    	{
	    		System.out.println("Product has same price on both the application");
	    	}
	    }
	    
}
