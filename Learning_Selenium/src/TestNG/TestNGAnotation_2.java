package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestNGAnotation_2 {

	
	@BeforeSuite
	public void beforeSuite(){
		System.out.println("BeforeSuite-Starting TestNG");
	}
	
	@AfterSuite
	public void afterSuite(){
		System.out.println("AfterSuite-Stoping TestNG");
	}

	@BeforeTest
	public void beforeTest(){
		System.out.println("BeforeTest-Start Test Execution");
	}
	
		@BeforeClass
		public void beforeClass(){
		System.out.println("BeforeClass-Initialize Selenium for Class 2");
		}
	
			@Test
				public void test3(){
					System.out.println("Test-Inside Test 3");
				}
	
		@AfterClass
		public void afterClass(){
		System.out.println("AfterClass-Destroy Selenium for class 2");
	}
	
	@AfterTest
	public void afterTest(){
		System.out.println("AfterTest-Stop Test Execution");
	}
}
