package com.qed42.qa.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.aventstack.extentreports.Status;
import com.qed42.qa.configurations.Configuration;
import com.qed42.qa.reportmanager.Report;

public class SearchPage {
	
	WebDriver driver;

	public By searchDropdown = By.id("searchDropdownBox");
	public By searchInoutBox = By.id("twotabsearchtextbox");
	public By txtPassword = By.name("password");
	public By searchBtn = By.id("nav-search-submit-button");
	public By searchresultsInfoBar = By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span[1]");
	public By searchresultsDisplayedFor = By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span[3]");
    
	public  By Sponsorproduct = By.xpath("//a[@class='puis-label-popover puis-sponsored-label-text']");
	
    public By SponsorproductName =  By.cssSelector("div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1'] span[class='a-size-medium a-color-base a-text-normal']");
	//public  By SponsorproductName = By.xpath ("//span[normalize-space()='Apple iPhone 13 (128GB) - (Product) RED']");
	// Product card Link
	public  By productName = By.xpath("//span[normalize-space()='Apple iPhone 14 Plus (128 GB) - Midnight']");
	
	public String ProductNameOnSearchPage;
	
	public String SpProductNameOnSearchPage;
	
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Login with valid credentials
	 * 
	 * @param userName
	 * @param password
	 * @throws Exception
	 */
	
	public void visitAmazonHome () {
		Report.log(Status.PASS, "Navigated to the Home page");
		driver.get(Configuration.BASE_URL);	
		
	}

	public String getPageCurrentUrl() throws Exception {
		
		return driver.getCurrentUrl();
	}
	
	
	public boolean searchDropdownlist () throws Exception {
		driver.get(Configuration.BASE_URL);
		Report.log(Status.PASS, "Navigated to the login page");
		
		
		if ( driver.findElement(searchDropdown).getText().contains("All")) {
		   Report.log(Status.PASS, "Search dropdown option All is selected by defult"); 
		}else {
		Report.log(Status.FAIL, "Search dropdown option All is selected by defult"); 
	}
		
		return driver.findElement(searchDropdown).isDisplayed();
	
	}

public String SearchKeyword(String item ) throws InterruptedException {
	
	driver.findElement(searchInoutBox).sendKeys(item);
	driver.findElement(searchBtn).click();
	Thread.sleep(2000);
	return item;	
}
	public String getSearchPageUrl() throws Exception {
		return driver.getCurrentUrl();
	}

	
	public String getProductName() {
	//	ProductNameOnSearchPage
		ProductNameOnSearchPage = driver.findElement(productName).getText();
		return ProductNameOnSearchPage ;
		
	}
	public boolean isDisplayedProductName() {
	

		return driver.findElement(productName).isDisplayed();
	}
	
	public boolean verifySearchResultBarisDislayed () {
		
		return driver.findElement(searchresultsInfoBar).isDisplayed();
	}
    public boolean verifySearchResultareDislayedFor () {
	  
	return driver.findElement(searchresultsDisplayedFor).isDisplayed();
	}
    public String  verifySearchResultareDislayedForitem () {
	  
		return driver.findElement(searchresultsDisplayedFor).getText();	
   }
    public void  clickingOnProductCard () {
    	
    
    driver.findElement(productName).click();
}
 
    
    public boolean  SpionsorProductCardTagIsDisplayed() {
    	
        
      return  driver.findElement(Sponsorproduct).isDisplayed();    
    
}
    public String getSponsorProductName() {
    	//	ProductNameOnSearchPage
    		SpProductNameOnSearchPage = driver.findElement(SponsorproductName).getText();
    		return ProductNameOnSearchPage ;
    		
    	}
    
    public String  verifySponsorProductCardTagCorrect() {
    	
        
        return  driver.findElement(Sponsorproduct).getText(); 
      
  }
public  void clickingOnSponsorProductCard () {
	
	System.out.println("Sponsor = "+ driver.findElement(Sponsorproduct).getText());
  driver.findElement(SponsorproductName).click(); }

}

