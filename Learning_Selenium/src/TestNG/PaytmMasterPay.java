package TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class PaytmMasterPay {
@BeforeSuite
public void beforeSuite(){
	System.out.println("Starting TestNG at Paytm");
}

@AfterSuite
public void afterSuite(){
	System.out.println("Stoping TestNG at Paytm");
}

@Test
public void test3(){
	System.out.println("Inside Test 3");
	Assert.assertEquals(1,2);
	Assert.assertEquals("Raju","raju1");
	Assert.assertTrue(1<2);
	//Will execute when it satisfy, if we want to execute some methods only after condition satisfies we should use assert.
}
}
