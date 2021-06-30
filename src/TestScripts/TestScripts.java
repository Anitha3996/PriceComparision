package TestScripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import TestMethods.AmazonHomePageTest;
import TestMethods.AmazonProductPageTest;
import TestMethods.FlipkartHomePageTest;
import TestMethods.FlipkartProductPageTest;
import utils.CommonUtility;

public class TestScripts extends BaseClass {
	FlipkartHomePageTest objFlipkartHomeTest;
	FlipkartProductPageTest objFlipkartProductTest;
	AmazonHomePageTest objAmazonHomeTest;
	AmazonProductPageTest objAmazonProductTest;
	CommonUtility commonutil;
	
	public  TestScripts() {
		objFlipkartHomeTest = new FlipkartHomePageTest ();
		objFlipkartProductTest= new FlipkartProductPageTest();
		objAmazonHomeTest=new AmazonHomePageTest();
		objAmazonProductTest=new AmazonProductPageTest();
		commonutil=new CommonUtility();
	}
	
	
	@BeforeClass
	 public void browserSetUp() {
		 BaseClass.initialiation();
	}
	
	
	
	@Test(priority = 1 , description = "Validation of Product search and Price in Flipkart") 
	public void FlipkartTestCase()
	{  
		objFlipkartHomeTest.launchFlipkartApplication();
		objFlipkartHomeTest.SearchProduct("PHILIPS HP8100/46 Hair Dryer");
		objFlipkartProductTest.getSelectedProductPrice();
		 Float Price = objFlipkartProductTest.printSelectedProductPrice();
		System.out.println("Flipkart : Selected Product Price before adding to Cart---->"+Price);
		objFlipkartProductTest.addProductToCart();
		objFlipkartProductTest.increaseProductQuantity();
		Float NewPrice=objFlipkartProductTest.printSelectedProductPriceAfterAddingNewQuantity();
		System.out.println("Total Price after adding oe more product---->"+NewPrice);
		
		
	}
	
	@Test(priority = 2 , description = "Validation of Price Comparision in Amazon and Flipkart Application ") 
	public void PriceComparision() {
		objFlipkartHomeTest.launchFlipkartApplication();
		objFlipkartHomeTest.SearchProduct("PHILIPS HP8100/46 Hair Dryer");
		objFlipkartProductTest.getSelectedProductPrice();
		 Float Price = objFlipkartProductTest.printSelectedProductPrice();
		 System.out.println("Flipkart: Selected Product Price before adding to Cart---->"+Price);
		objFlipkartProductTest.addProductToCart();
		Float FlipkartProductPrice=objFlipkartProductTest.printSelectedProductPriceAfterAddingNewQuantity();
		System.out.println("Flipkart Selected Product Price after adding to Cart---->"+FlipkartProductPrice);
		objAmazonHomeTest.launchAmazonApplication();
		objAmazonHomeTest.SearchProduct("PHILIPS HP8100/46 Hair Dryer");
		objAmazonProductTest.getSelectedProductPrice();
		Float price=objAmazonProductTest.printSelectedProductPrice();
		System.out.println("Amazon: Selected Product Price before adding to Cart---->"+price);
		objAmazonProductTest.addProductToCart();
		objAmazonProductTest.getSelectedProductPriceinCart();
		Float AmazonProductPrice = objAmazonProductTest.printSelectedProductPrice();
		objAmazonProductTest.addProductToCart();
		System.out.println("Amazon: Selected Product Price after adding to Cart---->"+AmazonProductPrice);
		commonutil.comparePrices(FlipkartProductPrice, AmazonProductPrice);
	}
	}

