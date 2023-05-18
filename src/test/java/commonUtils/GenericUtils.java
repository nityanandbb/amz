package commonUtils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.qed42.qa.reportmanager.Report;

public class GenericUtils {
	
WebDriver driver;
	
	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	// public void SwitchToChildWindow (String expectctedwindow) {
	public void SwitchToExpWindow (String exp) {


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
	
}

