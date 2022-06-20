package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinksWithAttributeWithGeneric {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		
		By links = By.tagName("a");
		List<String> hrefList = getElementsAttributeList(links,"href");
		for(String e : hrefList) {
			System.out.println(e);
		}
			
	}
	
	
//    <---------------- Interview Question ------------>
	
// Requirement : you capture the attributes, store in a particular List and then return	.
	
	public static List<WebElement> getElements(By locator) {    //I will call this method when I really want to capture the list and.. 
		                                                        //..I supply the by locator here
		return driver.findElements(locator);
	}
	
	public static List<String> getElementsAttributeList(By locator, String attrName) {
		
	List<WebElement> eleList= getElements(locator);         //Selenium will always give us List of WebElements not List of String
	List<String> eleAttrList = new ArrayList<String>();    //I will create a blank ArrayList and keep adding values into it.. 
	                                                      //..and current value is 0
			
//Selenium will always give us List of WebElements not List of String,..
//..so programmatically we have to convert the List of WebElements using a For loop and keep updating this particular List of String		
			
for(WebElement e : eleList) {                   //for each WebElement e inside of eleList print out e
String attValue = e.getAttribute(attrName);    //whatever value I am getting or captured I have to keep adding into..
eleAttrList.add(attValue);                //.."List<String> eleAttrList" ArrayList by using .add() method "eleAttrList.add(attValue);"
  }
	return eleAttrList;             //once the for loop is done return 		
	
	
	}
	

}