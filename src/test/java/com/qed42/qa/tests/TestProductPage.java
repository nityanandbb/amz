package com.qed42.qa.tests;



import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qed42.qa.driver.DriverManager;
import com.qed42.qa.pageobjects.ProductPage;
import com.qed42.qa.pageobjects.SearchPage;
import com.qed42.qa.reportmanager.Report;

import commonUtils.GenericUtils;

public class TestProductPage extends BaseTest {

	WebDriver driver;
		@Test
		public void testProductPageDetails() throws Exception {
			
		    ProductPage obj =new ProductPage(DriverManager.getDriver());
			
			SearchPage searchobj =new SearchPage(DriverManager.getDriver());
			 
		    obj.visitAmazonHome();
			
			searchobj.SearchKeyword("Iphone");
			searchobj.getProductName();
			
			Report.log(Status.INFO,"Landing on product page");
			
			searchobj.clickingOnProductCard();
		

			//obj.getProductName(),"Apple iPhone 14 Plus (128 GB) - Midnight");
			
			Report.log(Status.INFO, " From test calling window handle Genric class methods");
			Thread.sleep(3000);
			GenericUtils generic = new GenericUtils(DriverManager.getDriver());
			 generic.SwitchToExpWindow("childwindow");
		
		//	obj.SwitchToChildWindow("childwindow");
			Thread.sleep(3000); 
			Report.log(Status.INFO,  "Veifying prooduct title with expected on search page and actual on product  page");
			System.out.println( "Producgt NAme = "+ obj.verifyProductTitle());
			
			 System.out.println( "$$ = " + searchobj.ProductNameOnSearchPage + "||  " + obj.verifyProductTitle());
			Assert.assertEquals(searchobj.ProductNameOnSearchPage, obj.verifyProductTitle());
	        Report.log(Status.INFO, "Verifying product price");
	      
	        System.out.println("Prod price $$ =  "+obj.verifyProductPriceIsCorrect());
		 Assert.assertEquals("₹84,900",obj.verifyProductPriceIsCorrect());
		 Assert.assertTrue(obj.verifyProductPriceIsDiplayed());
		 
		 Assert.assertEquals( false ,obj.verifyQuantityDropdownIsDisplayed("Mobile"));
		}
		   @Test
            public void testProductImages() throws Exception {
			
		    ProductPage obj =new ProductPage(DriverManager.getDriver());
		   
			
            Report.log(Status.INFO, "Veifying prodct image and thumbnails.");
		    Assert.assertTrue(obj.verifyMagnifierLensIsShowingImagePreview());
		
		    Assert.assertTrue(obj.verifythumbnailProdcutImageIsdisplayed()); 
  }
		



}
