package TestNG;

import org.junit.Assert;
import org.testng.annotations.Test;

public class ExeFailedTest3 {

	@Test
	public void test3(){
		Assert.assertTrue(false);
	System.out.println("Test case 3");
	}
}
