import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.facebook.com/");

		driver.manage().window().maximize();

		WebElement month_dropdown = driver.findElement(By.id("month"));
		Select month_dd = new Select(month_dropdown);

		month_dd.selectByIndex(3);
		Thread.sleep(3000);

		month_dd.selectByValue("10");

		Thread.sleep(3000);
		month_dd.selectByVisibleText("Aug");
		
		WebElement selected_value= month_dd.getFirstSelectedOption();
		System.out.println("After selection selected values is"+selected_value.getText());

		List<WebElement> month_list = month_dd.getOptions();
		int total_month = month_list.size();
		System.out.println("Total month count is :"+ total_month);

		for (WebElement ele:month_list)
		{
		String month_name=ele.getText();
		System.out.println("Months are ====="+month_name);
		}

	}

}
