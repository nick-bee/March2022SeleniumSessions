package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinksWithAttribute {

		static WebDriver driver;

		public static void main(String[] args) {
			
//**		<----------Interview Question------------->
// to find out total number of Links on a page and print the href value of each link on the console
					
					WebDriverManager.chromedriver().setup();
					driver= new ChromeDriver();
					driver.get("https://www.amazon.in/");	
					
					driver.findElements(By.tagName("a"));
					
		List<WebElement> linksList	= driver.findElements(By.tagName("a"));
		System.out.println("Total Links: " + linksList.size());
		
		for(WebElement e : linksList) {  //for each WebElement e inside of linksList print out e
			String hrefValue = e.getAttribute("href");
			System.out.println(hrefValue);
		}
			
		
		
		

	}

}
