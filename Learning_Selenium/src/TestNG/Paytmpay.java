package TestNG;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class Paytmpay {

	@Test
	public void pay(){
		System.out.println("Payment at paytm");
	}
	
	@Test
	public void Skippay(){
		System.out.println("Payment at paytm");
		throw new SkipException("Skipay skipped");
		//skipped this test.
		//if the method is not implemented ready to run yet. if we want to skip it, we should use SkipException.so, that ll not in fail list.
	}
}
