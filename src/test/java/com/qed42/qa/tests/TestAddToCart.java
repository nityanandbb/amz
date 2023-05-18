package com.qed42.qa.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qed42.qa.driver.DriverManager;
import com.qed42.qa.pageobjects.CartPage;
import com.qed42.qa.pageobjects.ProceedToCheckOutPage;
import com.qed42.qa.pageobjects.ProductPage;
import com.qed42.qa.pageobjects.SearchPage;
import com.qed42.qa.pageobjects.SponsorProductpage;
import com.qed42.qa.reportmanager.Report;

import commonUtils.GenericUtils;

public class TestAddToCart extends BaseTest {


		@Test
		public void testAddtoCartProductAndProceddToCheckout() throws Exception {

			
			SearchPage obj =new SearchPage(DriverManager.getDriver());
			SponsorProductpage sp = new SponsorProductpage(DriverManager.getDriver());
			ProductPage pr =new ProductPage(DriverManager.getDriver());
			ProceedToCheckOutPage proceedToCheck = new ProceedToCheckOutPage(DriverManager.getDriver());
			CartPage cartpage = new CartPage (DriverManager.getDriver());
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

				pr.verifyProductTitle();
				
				Report.log(Status.INFO,"Clicking on the Cart Button");
				
				pr.clickOnAddToCartBtn();
				Thread.sleep(3000);
			
				Assert.assertTrue( proceedToCheck.verifyAddedToCartTxt().equals("Added to Cart"));
			
				proceedToCheck.clikingOnCartBtn();
			
			Thread.sleep(3000);
			Assert.assertEquals(cartpage.verifyCartProductNameIsCorrect(), pr.prodTitle);
			
		//	Assert.assertEquals(cartpage.verifyCartProductQuantityDropdownisDisplayed(),true);
			Assert.assertEquals(cartpage.verifyShoppingCartHeadingIsDisplayed(),"Shopping Cart");

			Report.log(Status.INFO,"selecting 4 product quantiyt");
			Assert.assertEquals (cartpage.SelectQuantityFromDropdown("4"),"4");
			
			
		}
}
