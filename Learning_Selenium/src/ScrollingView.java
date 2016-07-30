import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ScrollingView {
	
	@Test
	public void scrolling()
	{

	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");

	//Cretae an object of Javascript executor
	JavascriptExecutor je = (JavascriptExecutor) driver;

	//Identify the webelement which will appear after scrolling down
	WebElement element = driver.findElement(By.xpath("//*[@id='mCSB_3_container']/p[3]"));

	//Execute the JS to scroll untill the invisible element get visible.
	je.executeScript("arguments[0].scrollIntoView(true);",element);

	//Extract the text and verify
	System.out.println(element.getText());
	
	//Scroll page which is open with driver object 400 pixel vertical
	((JavascriptExecutor)driver).executeScript("scroll(0,400)");
	
	//driver.quit();

	}
}
