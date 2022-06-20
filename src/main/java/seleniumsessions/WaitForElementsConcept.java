package seleniumsessions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForElementsConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");

        // We are waiting for all the footers or we have applied wait on all the footers:
		
		By footers = By.xpath("//div[@class='footer-main']//li/a");
		
		List<WebElement> footersList = waitForElementsVisible(footers,30);
		for(WebElement e : footersList) {
			System.out.println(e.getText());
		}
		
		
	//*************** Basic Approach *************************//
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		List<WebElement> footersList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(footers));
//		
//		for(WebElement e : footersList) {
//			System.out.println(e.getText());
//		}
		
	}
	
	//**************** Generic Approach *************************//
	
// visibilityOfAllElementsLocatedBy:
	//An expectation for checking that all elements present on the web page that match the locatorare visible...
	//...Visibility means that the elements are not only displayed but also have a heightand width that is greater than 0
	public static List<WebElement> waitForElementsVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

// presenceOfAllElementsLocatedBy:
	//An expectation for checking that there is at least one element present on a web page.
	public static List<WebElement> waitForElementsPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
}
