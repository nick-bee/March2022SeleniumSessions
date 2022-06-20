package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinksWithAttributeTextWithGeneric {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		By links = By.tagName("a");  //tag name of the links
		By images = By.tagName("img");
		
		System.out.println("total links " + getElementCount(links));
		System.out.println("total images " + getElementCount(images));
		
		if(getElementsTextList(links).contains("Registry")){
			System.out.println("pass");
		}
		
		

	}
	
	public static List<WebElement> getElements(By locator) {
		 return driver.findElements(locator);
		 
	}
	
	
	public static int getElementCount(By locator) {  //just give me the By locator(like images,href, etc) I will give you the count
		return getElements(locator).size();
	}
	
	
	public static List<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();
		for(WebElement e : eleList) {
			String eleText = e.getText();
			System.out.println(eleText);
			eleTextList.add(eleText);
			
		}
		return eleTextList;
	}
	
	

}
