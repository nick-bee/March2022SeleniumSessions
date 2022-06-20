package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PollingTimeConcept {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		By contactSales = By.linkText("CONTACT SALES11");
		
		waitForElementToBeClickableWithPolling(contactSales, 10, 2000);
		
	
		//*************************** Basic Approach ************************//
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(1000));
//		wait.until(ExpectedConditions.elementToBeClickable(contactSales)).click();
		
		
		//We will use in those Applications where elements is not immediately present on the page or where element is taking some time 
		// but instead of hitting the server or browser back to back in every 500 milli secs . where we know that the particular
		//element will be visible after 1 sec or after 2 sec then we can increase the polling time in that case

	}

	//*************************** Generic Approach ************************//
	
	// for every method we can create a poolling time
	
	public static void waitForElementToBeClickableWithPolling(By locator, int timeOut, long pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(pollingTime), Duration.ofMillis(pollingTime));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	
}
