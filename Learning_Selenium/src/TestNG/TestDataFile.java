package TestNG;

// if we want to pass test data to prog, then we can use DataParameter

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class TestDataFile {

	@DataProvider(name="data")
	public static Object[][] testData(Method m){
		Object[][] obj = null;
		
		if (m.getName().equals("registerUser")){
			obj = new Object[3][4];
			obj[0][0]="Raj";
			obj[0][1]="Kumar";
			obj[0][2]="Raja@gmail.com";
			obj[0][3]="123";
			
			obj[1][0]="Rani";
			obj[1][1]="Kumari";
			obj[1][2]="Rani@gmail.com";
			obj[1][3]="321";
			
			obj[2][0]="YuvaRani";
			obj[2][1]="Kumari";
			obj[2][2]="yuvaRani@gmail.com";
			obj[2][3]="4321";
			
	}
	
	if (m.getName().equals("LoginUser")){
		obj = new Object[3][2];
		
		obj[0][0]="Raja@gmail.com";
		obj[0][1]="123";
		
		
		obj[1][0]="Rani@gmail.com";
		obj[1][1]="321";
		
		
		obj[2][0]="yuvaRani@gmail.com";
		obj[2][1]="4321";
		
	}
	return obj;
	
}

}
