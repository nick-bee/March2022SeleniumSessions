package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForTitleConcept {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		driver.findElement(By.linkText("CONTACT SALES")).click();
		
//		waitForUrlContains("contact-sales", 5);
		System.out.println(waitForUrlContains("contact-sales", 5));  // for printing on the console
		

//********************** Basic Approach ***********************//
		
		//url - wait for 5 secs:
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//	if(wait.until(ExpectedConditions.urlContains("contact-sales"))) {  // until method will return a boolean so we use if condition
//	driver.getCurrentUrl();
//	}		

	}
	 
//************************ Generic Approach ***********************************//
	
	//An expectation for checking that the title contains a case-sensitive substring.	
	public static String waitForTitleContains(String titleFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.titleContains(titleFraction))) {
			return driver.getTitle();
		}
		return null;    //else part
	}
	
	
	// An expectation for checking the title of a page.
	public static String waitForTitleIs(String title, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.titleIs(title))) {
			return driver.getTitle();
		}
		return null;    //else part
	}
	
	                //for fraction of url:
	public static String waitForUrlContains(String urlFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if(wait.until(ExpectedConditions.urlContains(urlFraction))) {
			return driver.getCurrentUrl();
		}
		return null;
	}
	
	                //for complete url:
	public static String waitForUrlIs(String url, int timeOut) {  
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if(wait.until(ExpectedConditions.urlToBe(url))) {
			return driver.getCurrentUrl();
		}
		return null;
	}
	
	
	
	

}
