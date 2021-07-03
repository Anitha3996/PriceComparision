package TestScripts;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import BaseClass.BaseClass;
import TestMethods.AmazonHomePageTest;
import TestMethods.FlipkartHomePageTest;
import utils.CommonUtility;

public class TestScripts extends BaseClass {
	FlipkartHomePageTest objFlipkartHomeTest;
	AmazonHomePageTest objAmazonHomeTest;
	
	CommonUtility commonutil;
	
	public  TestScripts() {
		objFlipkartHomeTest = new FlipkartHomePageTest ();
		objAmazonHomeTest=new AmazonHomePageTest();
		commonutil=new CommonUtility();
	}
	
	
	@BeforeMethod
	 public void browserSetUp() {
		 BaseClass.initialiation();
	}
	
	
	
	@Test(priority = 1 , description = "Validation of Product search and Price in Flipkart") 
	public void FlipkartTestCase()
	{  
		objFlipkartHomeTest.launchFlipkartApplication();
		objFlipkartHomeTest.SearchProduct("PHILIPS HP8100/46 Hair Dryer");
		objFlipkartHomeTest.getSelectedProductPrice();
		Float FlipkartProductPrice=objFlipkartHomeTest.printSelectedProductPrice();
		System.out.println("Flipkart: Selected Product Price BEFORE adding to Cart---->"+FlipkartProductPrice);
		objFlipkartHomeTest.addProductToCart();
		objFlipkartHomeTest.increaseProductQuantity();
		Float newPriceInCart=objFlipkartHomeTest.printSelectedProductPriceAfterAddingNewQuantity();
		System.out.println("Flipkart: Selected Product Price AFTER adding to Cart---->"+newPriceInCart);
		}
	
	@Test(priority = 2 , description = "Validation of Price Comparision in Amazon and Flipkart Application ") 
	public void PriceComparision() {
		objFlipkartHomeTest.launchFlipkartApplication();
		objFlipkartHomeTest.SearchProduct("PHILIPS HP8100/46 Hair Dryer");
		objFlipkartHomeTest.getSelectedProductPrice();
		Float FlipkartProductPrice=objFlipkartHomeTest.printSelectedProductPrice();
		System.out.println("Flipkart: Selected Product Price BEFORE adding to Cart---->"+FlipkartProductPrice);
		objFlipkartHomeTest.addProductToCart();
		Float newPriceInCart=objFlipkartHomeTest.printSelectedProductPriceAfterAddingNewQuantity();
		System.out.println("Flipkart: Selected Product Price in Cart---->"+newPriceInCart);
		objAmazonHomeTest.launchAmazonApplication();
		objAmazonHomeTest.SearchProduct("PHILIPS HP8100/46 Hair Dryer");
		objAmazonHomeTest.getSelectedProductPrice();
		Float price=objAmazonHomeTest.printSelectedProductPrice();
		System.out.println("Amazon: Selected Product Price before adding to Cart---->"+price);
		objAmazonHomeTest.addProductToCart();
		objAmazonHomeTest.getSelectedProductPriceinCart();
		Float AmazonProductPrice = objAmazonHomeTest.printSelectedProductPriceinCart();
		System.out.println("Amazon: Selected Product Price after adding to Cart---->"+AmazonProductPrice);
		CommonUtility.comparePrices(FlipkartProductPrice, AmazonProductPrice);
		
	}
	
	@AfterMethod
	 public void closeBrowser() {
		 driver.quit();
	}
	}

