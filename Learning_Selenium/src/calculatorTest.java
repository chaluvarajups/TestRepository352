
import java.io.File; 
import java.io.IOException; 
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils; 
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType; 
import org.openqa.selenium.TakesScreenshot; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert; import org.testng.ITestResult; 
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test; 
public class calculatorTest {
	//Create firfox driver's instance
	WebDriver driver = new FirefoxDriver();
	@Test 
	//Tests google calculator 
	public void googleCalculator() { 
		 //Set implicit wait of 10 seconds 
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//Launch google 
			driver.get("http://www.google.co.in");
			
			//script fail to find below element and capture SS, if we remove below 2 lines, script ll pass and ll not capture any SS.
			WebElement googleTextBox = driver.findElement(By.id("gbqfq")); 
			googleTextBox.sendKeys("2+2"); 
						
		} 
		
	
	@AfterMethod 
	public void takeScreenShotOnFailure(ITestResult testResult)  {
		
		if (testResult.getStatus() == ITestResult.FAILURE) 
		{ 
			System.out.println(testResult.getStatus()); 
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile, new File("./Screenshots1/"+"OptyPage1"+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		} 
	} 

	
	
