package com.qed42.qa.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CartPage extends HomePage {

	
	
	WebDriver driver;

	public CartPage(WebDriver driver) {
		
		super(driver);
		
		this.driver = driver;
	}
	
	
	public By shoppingCartHeading = By.cssSelector("div[class='a-row'] h1");
	
	public By cartProductName = By.xpath("//span[@class='a-truncate-cut']");
		
	public By cartQuantityDropdown =  By.xpath("//span[@class='a-dropdown-label']");
	   
	public By QuantityDropdown=  By.xpath("//span[@class='a-dropdown-label']");;
     public By dropDownSelectedValue = 	By.cssSelector ("*[class='a-dropdown-prompt']");
	Select select ;



	public String verifyShoppingCartHeadingIsDisplayed() {
		
		
	Assert.assertEquals(true, driver.findElement(shoppingCartHeading).isDisplayed());
	return driver.findElement(shoppingCartHeading).getText();
			
	}
	public String verifyCartProductNameIsCorrect() {
	return driver.findElement(cartProductName).getText();
		
	}
	public boolean verifyCartProductQuantityDropdownisDisplayed() {
		
		
		return driver.findElement(cartQuantityDropdown).isDisplayed();
			
		}
	public String SelectQuantityFromDropdown(String value) {
		
	//	select = new Select (QuantityDropdown);
		select = new Select (driver.findElement(By.xpath("//span[@class='a-dropdown-label']")));
		select.selectByValue(value);
		return driver.findElement(dropDownSelectedValue).getText();	
	}
	
	
}