import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
	
	
public class LaunchIEBrowser {

		public static void main(String[] args) {
			System.setProperty("webDriver.ie.driver",System.getProperty("user.dir")+"//Lib//IEDriverServer.exe");
			WebDriver IEDriver = new InternetExplorerDriver();
			IEDriver.get("http://www.google.com");

		}

	}