package com.qed42.qa.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class SponsorProductpage extends HomePage {
	
	WebDriver driver;
	ProductPage prodpage;
	
		public SponsorProductpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
		// Apple iPhone 13 (128GB) - (Product) RED ₹61,990


		public  By productName = By.xpath("//span[normalize-space()='Apple iPhone 14 Plus (128 GB) - Midnight']");
		public  By amazonB = By.xpath("//span[@class='a-size-small aok-float-left ac-badge-rectangle']/span[1]");
	
	  public  By choiceB=By.xpath("//span[@class='a-size-small aok-float-left ac-badge-rectangle']/span[2]");






public String amazonChoiceTxtIsDisplayed() {
	
	
	String amazonchoice = driver.findElement(amazonB).getText()+" "+ driver.findElement(choiceB).getText();
	System.out.println("xx "+amazonchoice);
	
	return amazonchoice;
}

public String VerifyamazonTxtColor() {
	
	String  amazonTxtColor = driver.findElement(amazonB).getCssValue("color");
	String c = Color.fromString(amazonTxtColor).asHex();
	return c;
}

public String VerifyChoiceTxtColor() {
	
	
	String choiceTxtColor =  driver.findElement(choiceB).getCssValue("color");
	String c = Color.fromString(choiceTxtColor).asHex();
	
	return c ;
	
}



}