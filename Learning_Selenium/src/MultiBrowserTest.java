import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

// we can run tests in 3 browsers paralel , to run this script run MultiBrowserTest.xml
public class MultiBrowserTest {
 
	WebDriver driver;
	
	@Test
	@Parameters("browser")
	
	public void verifypageTitle(String browserName)
	{

	if (browserName.equalsIgnoreCase("firefox"))

	 driver= new FirefoxDriver();
	 else 
	if (browserName.equalsIgnoreCase("chrome"))
	{
	//System.setProperty("webdriver.chrome.driver","C:\\cps\\Desktop\\GitEclipse\\Learning_Selenium\\Lib\\chromedriver.exe");
	driver= new ChromeDriver();
	}
	else if (browserName.equalsIgnoreCase("ie"))
	{
	//System.setProperty("webdriver.IE.driver","C:\\cps\\Desktop\\GitEclipse\\Learning_Selenium\\Lib\\IEDriverServer.exe");
	driver= new InternetExplorerDriver();
	}

	driver.manage().window().maximize();
	driver.get("http://www.google.com");
	System.out.println(driver.getTitle());
	driver.quit();
	}
}
