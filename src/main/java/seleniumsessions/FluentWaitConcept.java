package seleniumsessions;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept {
	
	static WebDriver driver;	

	public static void main(String[] args) {
	
		//FluentWait is the class which is the parent class of WebDriverWait and it is actually implementing Wait interface...
		//...and all the methods are actually defined inside the FluentWait class.

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");

		By customers = By.linkText("Amazon Science11");
		
		waitForElementPresenceWithFluentWait(customers, 10, 1000, "element is not present...........");
		
		// FW --> which is implementing the Wait interface
		
		//*********** Basic Approach ***************//
		
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//				                       .withTimeout(Duration.ofSeconds(20))
//				                       .pollingEvery(Duration.ofMillis(1000))
//				   					   .ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
//				   					   .withMessage("element is not present...");
//		
//		wait.until(ExpectedConditions.presenceOfElementLocated(customers)).click();
		
		// for WebDriver wait:
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.pollingEvery(Duration.ofMillis(1000))
			.ignoring(NoSuchElementException.class)
			.withMessage("element is not present...");
								
	}

	//*********** Generic Approach ***************//
	
	public static void waitForElementPresenceWithFluentWait(By locator, int timeOut, int pollingTime, String message) {
		
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(timeOut))
					.pollingEvery(Duration.ofMillis(pollingTime))
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
					.withMessage(message);

			wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
		}
	
	
}
