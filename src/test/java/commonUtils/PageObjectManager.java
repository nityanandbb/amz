package commonUtils;

import org.openqa.selenium.WebDriver;

import com.qed42.qa.driver.DriverManager;
import com.qed42.qa.pageobjects.ProductPage;
import com.qed42.qa.pageobjects.SearchPage;
import com.qed42.qa.pageobjects.SponsorProductpage;

public class PageObjectManager {
	
	public WebDriver driver;
	public SearchPage searchPage;
	
	public SponsorProductpage sponsorProductpage;
	
	public ProductPage productPage;
	
	public PageObjectManager (WebDriver driver ) {
		
		this.driver = driver;
		
	}
	
public SearchPage getSearchPage() {
	
	return  searchPage = new SearchPage (driver);
	
	
}
	
	
	
}
