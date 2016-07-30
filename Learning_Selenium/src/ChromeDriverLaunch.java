import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverLaunch {

	public static void main(String[] args) {
		System.setProperty("webDriver.chrome.driver",System.getProperty("user.dir")+"\\Lib\\chromedriver.exe");
	//	System.setProperty("webDriver.chrome.driver",System.getProperty("user.dir")+"//Lib//chromedriver.exe");
		
		WebDriver CD = new ChromeDriver();
		CD.get("http://www.google.com");

	}

}
