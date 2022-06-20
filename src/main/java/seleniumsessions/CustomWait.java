package seleniumsessions;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomWait {

	static WebDriver driver;

	public static void main(String[] args) {

		//** Interview Question: Q. You are not allowed to use Implicit wait and Explicit wait and... 
		//...then you have to make your own custom wait? not allowed to use fluent wait and WebDriver Wait.
		
		  // we use static wait ---> to achieve dynamic wait

		WebDriverManager.chromedriver().setup();		
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");

		By customers = By.linkText("Amazon Science11"); //Amazon Science11
		retryingElement(customers, 20, 500).click();
	
	}

	public static WebElement retryingElement(By locator, int timeOut, int pollingTime) {
		
		WebElement element = null;  //non primitive data type or default value of WebElement is null
                                   //so initially we are declaring it null
		
		int attempts = 0;
		while (attempts < timeOut) {   //0 attempt, 1 attempt, 2 attempt.......till number of timeOut
			try {
				element = driver.findElement(locator);  //when the element is found break the loop.
				break;
			} catch (NoSuchElementException e) {  //if still element is not there then below catch will run
				System.out.println("element is not found in attempt : " + attempts + " for : " + locator); //if on 1st attempt not... 
				                                                      //...found then we have to use sleep also
				try {
					Thread.sleep(pollingTime);   //wait for 1000 milisecs
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			attempts++;
		}
		
		
		if (element == null) {
			try {
				throw new Exception("ELEMENTNOTFOUNDEXCEPTION");
			} catch (Exception e) {
				System.out.println("element is not found exception....tried for : " + timeOut + " secs"
						+ " with the interval of : " + pollingTime + " ms ");
			}
		}

		return element;

	}
	
}
