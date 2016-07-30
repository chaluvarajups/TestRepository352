import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class XtentReport {
	
	@Test
	public void verifyXReport(){
		
		ExtentReports report = new ExtentReports("D:\\Selenium_Reports\\AdvanceReport.html");
		ExtentTest logger=report.startTest("StartingTC");
		
		WebDriver driver= new FirefoxDriver();
		driver.manage().window().maximize();
		
		//logger.log(LogStatus.INFO,"Browser is up and running");
		driver.get("http://www.google.com");

		logger.log(LogStatus.PASS,"Test completed");

		report.endTest(logger);
		report.flush();
		//driver.get("D:\\Selenium_Reports\\AdvanceReport.html"); 
		
	}
}
