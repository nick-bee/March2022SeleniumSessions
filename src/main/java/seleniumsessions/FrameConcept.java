package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameConcept {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.londonfreelance.org/courses/frames/index.html");

//		2 types of Frame:
		//1. frame -is also a WebElement
		//2. iframe
		
	 //   driver.switchTo().frame(2); ......1st method with index number
	//OR  driver.switchTo().frame("main"); .........2nd method by name    
   //OR
	  driver.switchTo().frame(driver.findElement(By.name("main")));  //....3rd method if name and is is not available
		
		String header = driver.findElement(By.tagName("h2")).getText();
		System.out.println(header);
		
		driver.switchTo().defaultContent();    //come back to the main page as driver is inside the frame above.
		
		
		//after sel 4.x:
		driver.switchTo().parentFrame();
		
		
//		https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/
		
	}

}
