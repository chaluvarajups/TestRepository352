
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.swing.Spring;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import CommonLib.Utility;

public class FusionAuto  {
	
		// WebDriver FD = new ChromeDriver();

	
	static WebDriver FD = new FirefoxDriver();
	ExtentReports report;
	ExtentTest logger;
	String UOptyName;
	public static void main(String[] args) throws Exception {
	//	System.setProperty("webdriver.chrome.driver","C:\\Users\\cps\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		
		FusionAuto FA = new FusionAuto();
		FA.FusionTest();
		
	}
	
	@Test
		public void FusionTest() throws Exception{
		
		report = new ExtentReports("D:\\Selenium_Reports\\AdvanceReport.html");
		logger=report.startTest("StartingTC");
		
 //Read data from excel sheet
		File src = new File("D:/Data.xls");
		Workbook wb= Workbook.getWorkbook(src);
		String UID=wb.getSheet(0).getCell(0,0).getContents();
		System.out.println("The User name is: "+UID);
		String PWD = wb.getSheet(0).getCell(1,0).getContents();
		System.out.println("The Password is: "+ PWD);
	//	String OptyfName = wb.getSheet(0).getCell(0,1).getContents();
	//	String URL = wb.getSheet(0).getCell(1,1).getContents();
		String ipyear = wb.getSheet(0).getCell(0,2).getContents();
		String day = wb.getSheet(0).getCell(0,3).getContents();
		String Month = wb.getSheet(0).getCell(0,4).getContents();
		Integer Day = Integer.parseInt(day);
		Integer IPYear = Integer.parseInt(ipyear);
	//	try {
	//	FileInputStream ObjectRepFile = new FileInputStream(System.getProperty("user.dir"+"\\src\\Practice\\ObjectRepository\\Opportunity.OR"));
	    FileReader file = new FileReader("C:\\Users\\cps\\Desktop\\GitEclipse\\Learning_Selenium\\src\\Practice\\ObjectRepository\\Opportunity.OR");
		Properties OptyOR = new Properties();
		OptyOR.load(file);
	//	} catch (IOException e) 
	//	{ e.printStackTrace(); }
//Read data from CSV file
		/*File file=new File("D:/Data.csv");
		Scanner inputStream = new Scanner(file);
		inputStream.next();
		while(inputStream.hasNext())
		{
		String data= inputStream.next();
		String[] values= data.split(",");
		System.out.println(values[4]);
		}
		inputStream.close(); */
		
//Reference XPATH: every field will not have unique identifier, so reference XPATH will be helpful to find preceding and following elems.
		/*FD.findElement(By.xpath("//*[@id='userid']/preceding-sibling::a")).click();
		FD.findElement(By.xpath("//*[@id='userid']/preceding-sibling::a[1]")).click();
		FD.findElement(By.xpath("//*[@id='userid']/following-sibling::a")).click();
		FD.findElement(By.xpath("//*[@id='userid']/following-sibling::a[1]")).click(); */
		
//generate random number and convert to Int		
		//Random rdm =new Random();
		//String OptyName= OptyfName+rdm.nextInt(1000000);
//Generate Unique ID using UUID
		String UOptyName= Utility.MakeUnique("UOpty_");
		System.out.println("Unique Opty name generated is: "+ UOptyName);
		logger.log(LogStatus.INFO,"Unique Opty name generated is: "+ UOptyName);
//Read from XML
		String XmlURL = Utility.XmlRead();
		System.out.println("URL read from XML is: "+ XmlURL);
		logger.log(LogStatus.INFO,"URL read from XML is: "+ XmlURL);
		//WebDriver FD = new FirefoxDriver();
		
		FD.manage().window().maximize();
		FD.get(XmlURL);
		FD.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//Thread.sleep(5000);
		
	    FD.findElement(By.xpath(OptyOR.getProperty("Fusion.login.UID"))).sendKeys(UID);
		WebElement username = FD.findElement(By.xpath("//*[@id='userid']"));
		Utility.highLightElement(FD, username);
	//	FD.findElement(By.xpath("//*[@id='userid']")).click();
	//	FD.findElement(By.xpath("//*[@id='userid']")).sendKeys(UID);
		
		FD.findElement(By.xpath(OptyOR.getProperty("Fusion.login.PWD"))).sendKeys(PWD);
		WebElement pasword = FD.findElement(By.xpath("//*[@id='password']"));
		Utility.highLightElement(FD, pasword);
	//	FD.findElement(By.xpath("//*[@id='password']")).click();
	//	FD.findElement(By.xpath("//*[@id='password']")).sendKeys(PWD);
		FD.findElement(By.xpath(OptyOR.getProperty("Fusion.login.Submit"))).click();
	    //FD.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(5000);
//Explicit wait untill some element found		
		WebDriverWait wait=new WebDriverWait(FD,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='pt1:_UISmmLink::icon']")));
		
		//FD.findElement(By.xpath("//*[@id='pt1:_UISmmLink::icon']")).click();
		FD.findElement(By.xpath("//*[contains(@id,'pt1:_UISmmLink')]")).click();
		//FD.findElement(By.xpath("//*[starts-with(@id,'pt1:_UISmmLink')]")).click();
		FD.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		FD.findElement(By.xpath("//*[@id='pt1:nv_itemNode_sales_opportunities']")).click(); 
	//	FD.findElement(By.xpath("//*[@id='pt1:nv_MOO_OPPTYMGMTOPPORTUNITIES_CRM_CARD']")).click();
		FD.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		
		/*FD.findElement(By.xpath("//*[@id='pt1:USma:0:MAnt1:0:pt1:AP1:dcl1:overQry::_afrDscl']")) .click();
		FD.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		FD.findElement(By.xpath("//*[@id='pt1:USma:0:MAnt1:0:pt1:AP1:dcl1:overQry:value20::drop']")) .click();
		FD.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		FD.findElement(By.xpath("//*[@id='pt1:USma:0:MAnt1:0:pt1:AP1:dcl1:overQry:value20::pop']/li[4]/ul/li[7]/label/input")) .click();
		FD.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);  */
		
		WebElement Status = FD.findElement(By.id("pt1:USma:0:MAnt1:0:pt1:AP1:dcl1:overQry:value20::pop"));
		Select ST = new Select(Status);
		ST.selectByValue("4");  
		
		FD.findElement(By.xpath("//*[@id='pt1:USma:0:MAnt1:0:pt1:AP1:dcl1:OptyListApplicationsTable:_ATp:create::icon']")).click();
		FD.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		FD.findElement(By.xpath("//*[@id='pt1:USma:0:MAnt1:1:pt1:AP1:it1::content']")).click();
		FD.findElement(By.xpath("//*[@id='pt1:USma:0:MAnt1:1:pt1:AP1:it1::content']")).sendKeys(UOptyName);
		FD.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	
		
			
//======================================Enter close date================================================================	
		//int IPYear=2018;
		//String IPYear="2018";
		FD.findElement(By.xpath("//*[@id='pt1:USma:0:MAnt1:1:pt1:AP1:id1::glyph']")).click();
		FD.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	//Set year
		//FD.findElement(By.xpath("//*[@id='pt1:USma:0:MAnt1:1:pt1:AP1:id1::pop::cd::ys::content']")).sendKeys(IPYear);
		String year=null;
		
		//String Month_Year=FD.findElement(By.xpath("//*[@id='pt1:USma:0:MAnt1:1:pt1:AP1:id1::pop::cd::cg']")).getAttribute("summary");
		year=FD.findElement(By.xpath("//*[@id='pt1:USma:0:MAnt1:1:pt1:AP1:id1::pop::cd::ys::content']")).getAttribute("value");
		System.out.println("Year at calander is: "+year);
		if (IPYear != Integer.parseInt(year))
		{
			int n = IPYear -Integer.parseInt(year);
			System.out.println("Diff bwtn IPYear and Year is: "+n);
			if (IPYear > parseInt(year)) 
				for (int i=0;i<n;i++)
					FD.findElement(By.xpath("//*[@id='pt1:USma:0:MAnt1:1:pt1:AP1:id1::pop::cd::ys::increment']")).click();
				else
					for (int i=0;i<n;i++)
					FD.findElement(By.xpath("//*[@id='pt1:USma:0:MAnt1:1:pt1:AP1:id1::pop::cd::ys::decrement']")).click();	
		} 
		FD.findElement(By.xpath("//*[@id='pt1:USma:0:MAnt1:1:pt1:AP1:id1::pop::cd::mSel::content']")).click();
		FD.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		FD.findElement(By.xpath("//*[@id='pt1:USma:0:MAnt1:1:pt1:AP1:id1::pop::cd::mSel::content']/option[@value="+Month+"]")).click();
		FD.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		FD.findElement(By.xpath("//*[@id='pt1:USma:0:MAnt1:1:pt1:AP1:id1::pop::cd::cg']/tbody/tr[4]/td["+Day+"]")).click();
		FD.findElement(By.xpath("//*[@id='pt1:USma:0:MAnt1:1:pt1:AP1:id1::pop::cd::cg']/tbody/tr[4]/td["+Day+"]")).click();
		FD.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		
	/*Select Month using dynamic table handling technique
		//String Month=FD.findElement(By.xpath("//*[@id='pt1:USma:0:MAnt1:1:pt1:AP1:id1::pop::cd::mSel::content']")).getAttribute("title");
		List<WebElement> Months=  FD.findElements(By.xpath("//*[@id='pt1:USma:0:MAnt1:1:pt1:AP1:id1::pop::cd::mSel::content']/option"));
		for(WebElement d:Months)
		{
			System.out.println(d.getText());
		}
----------------------------------------------------------------------------------------------------------------------------*/		
		
		
		FD.findElement(By.xpath("//*[@id='pt1:USma:0:MAnt1:1:pt1:AP1:ctb1']/a/span")).click();
		Thread.sleep(5000);
		System.out.println("The Opty created is: "+ UOptyName);
		logger.log(LogStatus.INFO,"The Opty created is: "+ UOptyName);
	  
		
	  Utility.CaptureScreenShot(FD,"SS_"+UOptyName);	

	  FD.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
	  String dbData=Utility.dbconnect();
	  
	  logger.log(LogStatus.INFO,"Data fetched from db is: "+dbData);
	  System.out.println("Data fetched from db is: "+dbData);
	 
	  FD.close();
	 /* FD.manage().window().maximize();
	verify Google links	  
	  FD.get("https://www.google.co.in");
	  List<WebElement> links = FD.findElements(By.tagName("a"));
	  System.out.println("Total links are : "+links.size());

	  for (int i=0;i<links.size();i++)
	  {

	  WebElement ele=links.get(i);
	  String url=ele.getAttribute("href");
	  Utility.verifyLinkActive(url);
	  }  */
	  FD.quit();
	 logger.log(LogStatus.PASS,"Test completed");
	  report.endTest(logger);
		report.flush();
		//FD.get("D:\\Selenium_Reports\\AdvanceReport.html"); 
	}
	
    private static int parseInt(String year) {
		// TODO Auto-generated method stub
		return 0;
	  }

   @AfterMethod 
   public void takeScreenShotOnFailure(ITestResult testResult)  {
	
	 /* 
	   WebDriver FD = new FirefoxDriver();
	   FD.manage().window().maximize();
	   FD.get("https://www.google.co.in");
		  List<WebElement> links = FD.findElements(By.tagName("a"));
		  System.out.println("Total links are : "+links.size());

		  for (int i=0;i<links.size();i++)
		  {

		  WebElement ele=links.get(i);
		  String url=ele.getAttribute("href");
		  Utility.verifyLinkActive(url);
		  } */		  
	if (testResult.getStatus() == ITestResult.FAILURE) 
	{ 
		
		Utility.CaptureScreenShot(FD,"SS_"+UOptyName);
		//Utility.CaptureScreenShot(FD,testResult.getName());	
		/*System.out.println(testResult.getStatus()); 
		File scrFile = ((TakesScreenshot)FD).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("./Screenshots/"+"OptyPageFS"+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		}  FD.quit();
		logger.log(LogStatus.FAIL,"Test Case failed");
		  report.endTest(logger);
			report.flush();
	} 
/*@AfterMethod 
public void takeScreenShotOnFailure()  {
	 Utility.CaptureScreenShot(FD,"OptyPageFSS"); 
	} */ 
}

