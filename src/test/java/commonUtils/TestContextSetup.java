package commonUtils;

import org.openqa.selenium.WebDriver;

import com.qed42.qa.driver.DriverManager;

public class TestContextSetup {

	
	public WebDriver driver;
	public DriverManager driverManager ;
	public PageObjectManager pageObjectManager;
	
	public GenericUtils genericUtils;
	
	public TestContextSetup () { 
		driverManager = new DriverManager(); // class DriverManager { to public
		
		pageObjectManager = new PageObjectManager(driverManager.getDriver());
	}
	
}
