package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FooterList {
		
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.freshworks.com/");
		
		
		List<WebElement> footerList = driver.findElements(By.xpath("//div[@class='footer-main']//ul//a"));
		System.out.println("Total number of links: " +footerList.size());
		
		footerList.stream().forEach(e -> System.out.println(e.getText()));
		
//		OR
		

//		for(WebElement e : footerList ) {
//			String text = e.getText();
//			if(!text.isEmpty()) {
//			System.out.println(text);
//		}
//		
//		}
		
	}	

}
