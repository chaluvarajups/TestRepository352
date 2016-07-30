package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPriority {
/*@Test(priority=4)
public void login(){
System.out.println("Log in");
}
@Test(priority=2)
public void navigating(){
System.out.println("navigating");
}
@Test(priority=2)
public void logout(){
System.out.println("Log out");
}*/
// top priority test will be executed first, if the priority will be same then TestNG will decide which Test to be executed.

@Test()
public void login(){
System.out.println("Log in");
Assert.assertEquals("String1", "String2"); // execute this test only if condition satisfies
}
@Test()
public void navigating(){
System.out.println("navigating");
}
@Test(priority=1,dependsOnMethods={"login","navigating"}) // Test depends on some method, if they pass then this ll exe.
public void logout(){
System.out.println("Log out");
}
}