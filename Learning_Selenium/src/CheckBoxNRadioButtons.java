import java.util.List;
		import java.util.concurrent.TimeUnit;
		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.firefox.FirefoxDriver;
		
public class CheckBoxNRadioButtons {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.ironspider.ca/forms/checkradio.htm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 
		List<WebElement> checkbox = driver.findElements(By.xpath("//*[@id='Content']/div[1]/blockquote[1]/form/input[@name='color']"));
		System.out.println(checkbox.size());
		for(WebElement e: checkbox){
		System.out.println(e.getAttribute("value")+"  "+e.isSelected());
		//System.out.println(e.getAttribute("value"));
		if(e.getAttribute("value").equals("blue") ||
		e.getAttribute("value").equals("green")){
		e.click();
		}
		}
		System.out.println("---------------------------");
		for(WebElement e: checkbox){
			System.out.println(e.getAttribute("value")+"  "+e.isSelected());
		}
		
		List<WebElement> RadioBtn = driver.findElements(By.xpath("//*[@id='Content']/div[1]/blockquote[2]/form/input[@name='browser']"));
		System.out.println("NUmber of Radio buttons available are: "+RadioBtn.size());
		
		for(WebElement e: RadioBtn){
		System.out.println(e.getAttribute("value"));
		//System.out.println(e.getAttribute("value"));
		//if(e.getAttribute("value").equals("blue"))
		//e.click();
		}
		
		driver.close();
	}
}


