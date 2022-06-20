package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitlyWaitConcept {

	public static void main(String[] args) {

		//1. Implicitly wait is a global wait:
		//2. it will be applied for all the web elements by default
		//3. its not a custom wait for a specific web element
		//4. not applicable for non web elements: title, url, alert
		//5. only applicable for web elements
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//sel 3.x --> depricated
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//sel 4.x
		
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		//Thread.sleep(10); we have to wait for 10 sec even the web element is found.
		
		
		//1st page: home page
				driver.findElement(By.id("Form_submitForm_Name11")).sendKeys("naveen");//10
				driver.findElement(By.id("Form_submitForm_Email")).sendKeys("naveen@gmail.com");//10
				driver.findElement(By.id("Form_submitForm_Contact")).sendKeys("909909099");//10
				
				
		//2nd page: contact page:
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//sel 4.x //latest value of ImpWt is now 5 sec
				//element e4
				//e5
				//e6
				//click on home page:
				//1st page: home page : 5 secs: //now on home page also ImpWt is 5 sec
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//sel 4.x // now latest value of ImpWt is now 10 sec
				//2nd page: contact page: 10 secs				
				
				
		//3rd page: cart page: Suppose I don't want wait or no wait: 0 sec - that ImpWt is called as nullify of imp wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));//sel 4.x

		
				//** Demerit of Implicitly wait:
		// 1. It is a Global Wait and applied for all the Web elements.
		// 2. We have to override or change the ImpWt again and again according to the requirement.	
		// 3. Not applicable for non Web Elements like: Title of the page, alerts, Url
		// 4. Only applicable for web elements		
				
				
	}

}
