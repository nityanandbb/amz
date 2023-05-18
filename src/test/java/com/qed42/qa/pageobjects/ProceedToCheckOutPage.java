package com.qed42.qa.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProceedToCheckOutPage extends HomePage{

	WebDriver driver;
	
	ProductPage productPage;
	public ProceedToCheckOutPage(WebDriver driver) {
		
		super(driver);
		
		this.driver = driver;
	}
	

	
	  public By proceedToCheckOut = By.xpath("//input[@aria-labelledby='attach-sidesheet-checkout-button-announce']");
	   
	  public By  addedToCartTxt =  By.cssSelector(".a-size-medium-plus.a-color-base.sw-atc-text.a-text-bold");
	  public By cartPageBtn =  By.cssSelector ("input[aria-labelledby='attach-sidesheet-view-cart-button-announce']");
	  
	  public String verifyAddedToCartTxt() throws InterruptedException {
		  Thread.sleep(3000);
		  System.out.println("$added to Cart = "+  driver.findElement(addedToCartTxt).getText());
	return  driver.findElement(addedToCartTxt).getText();
		  
		  
	  }
	public void clikingOnCartBtn (){
		
		driver.findElement(cartPageBtn).click();
		
		
	}
	public void clickOnProceedToCheckoutBtn() {
		
		driver.findElement(proceedToCheckOut).click();
		
	}
	
}
