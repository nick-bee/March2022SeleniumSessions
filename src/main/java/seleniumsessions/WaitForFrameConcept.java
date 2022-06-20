package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForFrameConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();

		driver.get("http://www.londonfreelance.org/courses/frames/index.html");

		By frameLocator = By.name("main");
		
		waitForFrameByLocator(frameLocator, 5);
		
		//********************** Basic Approach ***********************//
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator)); // this method will check the frame... 
//...is available within 10 sec. If it is available switch to it and then the driver is by default available there and... 
//..now we can interact with all the elements which are currently available inside the frame.
		
// I have not written "driver.switchTo" then also driver is now inside the frame because of until method above.
		
		String header = driver.findElement(By.tagName("h2")).getText();
		System.out.println(header);

        driver.switchTo().defaultContent(); // If want to come back or come out of the frame we will use "defaultContent()"	
		
	}

	//************************ Generic Approach ***********************************//
	
	public static void waitForFrameByLocator(By frameLocator, int timeOut) {		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));		
	}

	public static void waitForFrameByIndex(int frameIndex, int timeOut) {		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}
	
	public static void waitForFrameByElement(WebElement frameElement, int timeOut) {		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}
	
	
	
}
