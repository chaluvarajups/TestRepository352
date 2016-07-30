import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertHandling {

	@Test
	public void alert() throws InterruptedException{
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("http://ksrtc.in/");

	driver.findElement(By.xpath("html/body/div[1]/div[2]/div[1]/form/div[8]/a")).click();
	Thread.sleep(5000);
	
	//Alert alt = driver.switchTo().alert();
	//alt.accept();
	
	String actual_msg = driver.switchTo().alert().getText();
	System.out.println("actual message i s: " +actual_msg);
	 driver.switchTo().alert().accept();
	 
	 String expected_msg = "'From' place required please update";
	 
	 Assert.assertEquals(actual_msg, expected_msg);
	driver.quit();
	}
}
