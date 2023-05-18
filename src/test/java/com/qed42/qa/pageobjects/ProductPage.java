package com.qed42.qa.pageobjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;
import com.qed42.qa.reportmanager.Report;




public class ProductPage extends HomePage {

	
	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		
		super(driver);
		
		this.driver = driver;
	}
// product page link
	public  By productName = By.xpath("//span[normalize-space()='Apple iPhone 14 Plus (128 GB) - Midnight']");
	

	public By MagnifierLens = By.xpath("//div[@id='magnifierLens']");
	
	public By thumbnailProductimg = By.id("altImages");
	
	public By  productTitle = By.xpath("//*[@id='titleSection']");
			
    public By productPrice = By.xpath("//div[@id='corePriceDisplay_desktop_feature_div']/div[1]/span[2]/span[2]");//[1]
 
	public By productQuantityDropdown = By.cssSelector("select[id='quantity']");
	
   public By addToCart = By.xpath("//input[@id='add-to-cart-button']");
   
 
    public String prodTitle; 
    
	public String  verifyProductTitle() {
    	
		prodTitle =  driver.findElement(productTitle).getText();
    	
		return prodTitle;
    }
    
   public boolean verifyIsProductTitleDsiplayed() {
	   
	   return driver.findElement(productTitle).isDisplayed();
   }
    
  public boolean verifyProductPriceIsDiplayed() {
	  
	  
	  return driver.findElement(productPrice).isDisplayed();
  }
public String verifyProductPriceIsCorrect() {
	  
	  return driver.findElement(productPrice).getText();
  }

public boolean verifyMagnifierLensIsShowingImagePreview() {
	
	
	Actions ac = new Actions(driver);

	   ac.moveToElement((WebElement) MagnifierLens).build().perform();
	 //  ac.release().perform(); 
	   
return	driver.findElement(MagnifierLens).isDisplayed();
	
  }
public boolean verifythumbnailProdcutImageIsdisplayed () {
	

return driver.findElement(thumbnailProductimg).isDisplayed();
}


  public boolean verifyQuantityDropdownIsDisplayed(String productType) {
 
	
	if ( productType =="Mobile")
	{	
	// return driver.findElement(productQuantityDropdown).isDisplayed() == false;
	boolean status =	isQuantityElementPresent(productQuantityDropdown);   
//	return status ==false;
 return status;
		
	} else { 
		
		return driver.findElement(productQuantityDropdown).isDisplayed() == true ;
	}
	
  }

	public boolean isQuantityElementPresent(By locatorKey) {
	    try {
	    	System.out.println(" in try checking quanity found");
	        driver.findElement(locatorKey);
	      
	        return true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	    	System.out.println(" in catch checking quanity not found");
	    	
	    	
	        return false;
	    }
	}

	
	public boolean isQuantityElementVisible(){
	    return driver.findElement(productQuantityDropdown).isDisplayed();
	}

public void clickOnAddToCartBtn () {
	
	driver.findElement(addToCart).click();
}


/*public void SwitchToChildWindow (String exp) {


System.out.print("Common utils method accessing");
	Report.log(Status.INFO, "Switching To child window ");
	
	Set<String> s1 = driver.getWindowHandles();
	Iterator <String> it= s1.iterator();
	
	String parentWindow =  it.next();
	
	String childwindow = it.next();
	
	// driver.switchTo().window(childwindow);
	
if (exp.contains("parentWindow")) {
	
	driver.switchTo().window(parentWindow);
	
} else if( exp.contains("childwindow")){
	
	driver.switchTo().window(childwindow);
	
}
	
  }
  */
}
