package com.qed42.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qed42.qa.driver.DriverManager;
import com.qed42.qa.pageobjects.SearchPage;
import com.qed42.qa.reportmanager.Report;

public class TestSearchpage extends BaseTest {

	@Test
	public void testSearchResultsWithItemName() throws Exception {
		
		SearchPage obj =new SearchPage(DriverManager.getDriver());
		
		obj.visitAmazonHome();
		Report.log(Status.INFO, "Landing on Amazon Homepage");
		Assert.assertEquals(obj.getPageCurrentUrl(),"https://www.amazon.in/");
		obj.SearchKeyword("Iphone");
		
		Report.log(Status.INFO, "Searching for Item");
		
        
		Assert.assertEquals(obj.verifySearchResultBarisDislayed(), true);
		Report.log(Status.INFO, "Searching for Item");
        
       Assert.assertEquals(obj.verifySearchResultareDislayedForitem(),"\"Iphone\"");
       System.out.println(obj.verifySearchResultareDislayedForitem());
       
       Assert.assertEquals( obj.verifySearchResultareDislayedFor(),true);
       
   Assert.assertEquals(obj.getSearchPageUrl().contains("=Iphone&"),true);
         System.out.println(obj.getSearchPageUrl());
       
       Assert.assertEquals(obj.getProductName(),"Apple iPhone 14 Plus (128 GB) - Midnight");
       System.out.println(obj.getProductName());
       Assert.assertEquals( obj.isDisplayedProductName(),true);
       
     // verify test correction  Assert.assertEquals(obj.getProductName(),"Apple iPhone 14 Plus (128 GB) - Midnight11");
      
	}

}
