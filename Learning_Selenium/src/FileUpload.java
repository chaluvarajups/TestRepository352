import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FileUpload {

	
	@Test
	public void uploadFile() throws InterruptedException, IOException, AWTException{
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("http://tinypic.com");
	Thread.sleep(5000);
	//driver.get("http://tinypic.com/");
	driver.findElement(By.xpath("//*[@id='the_file']")).click();
	
	/* upload through plan send keys
	driver.findElement(By.xpath("//*[@id='the_file']")).sendKeys("C:\\Users\\cps\\Desktop\\FileUpload.txt"); */
	
	Runtime.getRuntime().exec("D:\\AutoITScript\\FileUpload.exe"); 
	driver.quit(); 
	
	WebDriver driver1 = new FirefoxDriver();
	driver1.manage().window().maximize();
	driver1.get("http://www.textfiles.com/directory.html");
	driver1.findElement(By.xpath("html/body/center/p[1]/table[2]/tbody/tr[1]/td[1]/b/a")).click();
	driver1.findElement(By.xpath("html/body/p[4]/table/tbody/tr[2]/td[1]/a")).click();
	
	Runtime.getRuntime().exec("D:\\AutoITScript\\FileUpload.exe"); 
	
	
	
/*ROBOT Execution	
	StringSelection ss = new StringSelection("C:\\Users\\cps\\Desktop\\FileUpload.txt");
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
     ROBOT Exe ends */
	}
}
