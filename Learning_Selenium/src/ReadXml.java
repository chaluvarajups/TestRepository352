import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXml {

	public static void main(String[] args) throws Exception {
		
		File xmlFile = new File("D:/Environment1.xml");
		//create instance for document builder factory
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(xmlFile);

				//get NodeList for xml	
				NodeList nlXml = doc.getChildNodes();
				System.out.println("NodeList get is: "+nlXml);
				//get xml first node
				Node nXml = nlXml.item(0);
				System.out.println("Node get is: "+nXml);
				//Assign node element
				Element element =(Element)nXml;
				System.out.println("element get is: "+element);
				//print application url by tag name
				System.out.println("URL: "+element.getElementsByTagName("APP_URL").item(0).getTextContent());
	}			

}
