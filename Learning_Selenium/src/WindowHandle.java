import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowHandle {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver= new FirefoxDriver();

		driver.manage().window().maximize();

		driver.get("https://accounts.google.com/SignUp?service=mail&continue...");

		String parent_window = driver.getWindowHandle();

		System.out.println("Before switching title is ="+driver.getTitle());

		driver.findElement(By.xpath("//*[@id='wrapper']/div[2]/div/div[1]/p/a")).click();
		
		Set<String> s1 = driver.getWindowHandles();

		Iterator<String> i1=s1.iterator();

			while(i1.hasNext())
				{
					String child_window = i1.next();

					if (!parent_window.equalsIgnoreCase(child_window))
					{
						driver.switchTo().window(child_window);
						Thread.sleep(10000);
						System.out.println(driver.getTitle());
						driver.close();
					}
				}
			driver.switchTo().window(parent_window);
			System.out.println(driver.getTitle());

	}

}
