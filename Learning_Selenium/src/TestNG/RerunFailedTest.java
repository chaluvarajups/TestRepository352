package TestNG;
import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class RerunFailedTest {

	public static void main(String[] args) {

		TestNG rerun = new TestNG();
		
		List<String> list = new ArrayList<String>();
		list.add("C:\\Users\\cps\\Desktop\\GitEclipse\\Learning_Selenium\\test-output\\ExeFailTest\\testng-failed.xml");
		rerun.setTestSuites(list);
		rerun.run();
	}
}
