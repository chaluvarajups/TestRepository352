package CommonLib;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.UUID;

import javax.swing.Spring;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class Utility {
	
	//Capture screenshot
	public static void CaptureScreenShot(WebDriver FD, String ScreenshotName) {
		
		try{
		TakesScreenshot ts=(TakesScreenshot)FD;
		File source =ts.getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(source, new File("./Screenshots/"+ScreenshotName+".png"));
		  } catch(Exception e)
		{
		System.out.println("Exception while taking screenshot"+ e.getMessage());	
		}
	}
	
	//generate Unique ID
	public static String MakeUnique(String unique) {
		try {
			UUID uuid = UUID.randomUUID();
			String myRandom = uuid.toString();
			String rndm = myRandom.substring(0,myRandom.length() - 30);
			if (rndm.length() > 5) {
				rndm = rndm.substring(3);
			}
			Calendar lCDateTime = Calendar.getInstance();
			String tm = lCDateTime.getTimeInMillis() + "";
			if (tm.length() > 10) {
				tm = tm.substring(5);
			}
			return unique + rndm + tm;

		} catch (Exception e) {
			Calendar lCDateTime = Calendar.getInstance();
			return unique + unique.length() + lCDateTime.getTime().toString();
		}
	}
	
	//Read data from XML
	public static String XmlRead() throws SAXException, IOException, ParserConfigurationException
	{
		File xmlFile = new File("D:/Environment1.xml");
		//create instance for document builder factory
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(xmlFile);

				//get NodeList for xml	
				NodeList nlXml = doc.getChildNodes();
				
				//get xml first node
				Node nXml = nlXml.item(0);
				
				//Assign node element
				Element element =(Element)nXml;
			
				//print application url by tag name
				//System.out.println("URL: "+element.getElementsByTagName("APP_URL").item(0).getTextContent());
				return element.getElementsByTagName("APP_URL").item(0).getTextContent();
				
	}
	
	
	public static String dbconnect() throws SQLException,SQLSyntaxErrorException, ClassNotFoundException {

		//	String dburl="jdbc:oracle://localhost:1521/Bugs";
		//	String username="System";
		//	String Password="welcome1";
			String uName=null;
			String query="select * from emp";

			//load Oracle JDBC driver
			//Class.forName("com.oracle.jdbc.driver");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//get connection DB
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:orcl","System", "Welcome2");
			System.out.println("Login to db Success");

			//Create Statment object
			Statement stmt = con.createStatement();
					
			//Send SQL query to DB
			ResultSet rs = stmt.executeQuery(query);
					
			//While loop to get ResultSet all rows data
			while(rs.next())
			{ uName=rs.getString(2);
			//System.out.println(uName);
			}
			
			
			//close DB connection
			//con.close();
			if (con!=null)
			{
				con=null;
				System.out.println("db connection closed");
			}
			return uName;
			}
	
	
	//Verify all link in a page
	public static void verifyLinkActive(String linkurl)
	{
	  	try{
		URL url = new URL(linkurl);
		HttpURLConnection httpURLConnect= (HttpURLConnection)url.openConnection();
		httpURLConnect.connect();
		
		
		if(httpURLConnect.getResponseCode()==200)
		{
			System.out.println(linkurl + " - "+httpURLConnect.getResponseMessage());
		}

		if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)
		{
			System.out.println(linkurl + " - "+httpURLConnect.getResponseMessage()+ " - "+HttpURLConnection.HTTP_NOT_FOUND);
		}
	  	}catch(Exception e) {}
	}

	
	public static void highLightElement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;

		js.executeScript("arguments[0].setAttribute('style','background: yellow; border:2px solid red;');",element);

		try{
			Thread.sleep(500);
		} catch(InterruptedException e)
		{ System.out.println(e.getMessage()); }

		js.executeScript("arguments[0].setAttribute('style', 'border:solid 2px  white')",element);

	}
}
