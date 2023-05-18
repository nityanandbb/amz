package com.qed42.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qed42.qa.driver.DriverManager;
import com.qed42.qa.pageobjects.ProductPage;
import com.qed42.qa.pageobjects.SearchPage;
import com.qed42.qa.pageobjects.SponsorProductpage;
import com.qed42.qa.reportmanager.Report;

import commonUtils.GenericUtils;

public class TestSponsorProduct extends BaseTest {

			@Test
			public void testSearchResultsWithItemName() throws Exception {
				
				SearchPage obj =new SearchPage(DriverManager.getDriver());
				SponsorProductpage sp = new SponsorProductpage(DriverManager.getDriver());
				ProductPage pr =new ProductPage(DriverManager.getDriver());
				
				obj.visitAmazonHome();
				Report.log(Status.INFO, "Landing on Amazon Homepage");
				
				obj.SearchKeyword("Iphone");
				
				Report.log(Status.INFO, "Searching for Item");
				
				obj.getSponsorProductName();
				Assert.assertEquals(obj.SpionsorProductCardTagIsDisplayed(),true);
				
				obj.clickingOnSponsorProductCard();
				
				Report.log(Status.INFO,"Navigated on sponsored product page ");
				
				Thread.sleep(3000);
				GenericUtils generic = new GenericUtils(DriverManager.getDriver());
				 generic.SwitchToExpWindow("childwindow");
				 
			      Assert.assertEquals( obj.SpProductNameOnSearchPage,pr.verifyProductTitle());
			      Assert.assertEquals (pr.verifyProductPriceIsCorrect(),"₹61,990");
			      Assert.assertEquals( false ,pr.verifyQuantityDropdownIsDisplayed("Mobile"));
			   Assert.assertEquals(sp.amazonChoiceTxtIsDisplayed(),"Amazon's Choice");
				
			  Assert.assertSame(sp.VerifyamazonTxtColor(),"white");
			  Assert.assertSame(sp.VerifyChoiceTxtColor(),"Orange");
				
	
				
			}
}
