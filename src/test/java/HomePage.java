

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.qed42.qa.configurations.Configuration;
import com.qed42.qa.reportmanager.Report;

public class HomePage {


	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void visitAmazonHome () {
			Report.log(Status.PASS, "Navigated to the Home page");
			driver.get(Configuration.BASE_URL);	
			
		}

}
