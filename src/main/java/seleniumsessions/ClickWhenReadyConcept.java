package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickWhenReadyConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		By contactSales = By.linkText("CONTACT SALES");

		clickElementWhenReady(contactSales, 5);
		
		//*************** Basic Approach *************************//
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // I am gonna wait for 10 sec for this Contact sales
//		wait.until(ExpectedConditions.elementToBeClickable(contactSales)).click();
	}
	
	
	   //*************** Generic Approach *************************//	
	
// An expectation for checking an element is visible and enabled such that you can click it.	
	public static void clickElementWhenReady(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();  //wait and click also
	}

}
