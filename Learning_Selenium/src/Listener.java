

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import CommonLib.Utility;

public class Listener extends TestListenerAdapter {

	
	private static final WebDriver FD = null;

	public void onTestFailure(ITestResult tr) {
		Utility.CaptureScreenShot(FD, "OptyPage");
		}
}