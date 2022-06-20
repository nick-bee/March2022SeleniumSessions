package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestHRMapp {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		

		
		
		String title= driver.getCurrentUrl();
		System.out.println(title);
		
		driver.quit();
		
//		3rd approach-----------
//		By name= By.id("Form_submitForm_Name");
//		By email= By.id("Form_submitForm_Email");
//		By telephone= By.id("Form_submitForm_Contact");
//		
//		WebElement name_ele= driver.findElement(name);
//		WebElement email_ele= driver.findElement(email);
//		WebElement telephone_ele= driver.findElement(telephone);
//		
//		name_ele.sendKeys("Nitin");
//		email_ele.sendKeys("nitin@gmail.com");
//		telephone_ele.sendKeys("123456789");
////	
//		5th approach-----------
//		By name= By.id("Form_submitForm_Name");
//		By email= By.id("Form_submitForm_Email");
//		By telephone= By.id("Form_submitForm_Contact");
//		
//		getElement(name).sendKeys("Nitin");
//		getElement(email).sendKeys("nitin@gmail.com");
//		getElement(telephone).sendKeys("123466789");
		
		
//		6th approach--------
//		By name= By.id("Form_submitForm_Name");
//	    By email= By.id("Form_submitForm_Email");
//		By telephone= By.id("Form_submitForm_Contact");
//		
//		doSendKeys(name, "Nitin");
//		doSendKeys(email, "nitin@gmail.com");
//		doSendKeys(telephone, "123456");
		
		
		
		
		

	}
	
	public static void doSendKeys(By locaterName, String value) {
		getElement(locaterName).sendKeys(value);
		
	}
	
	public static WebElement getElement(By locatorName) {
		
		return driver.findElement(locatorName);
		
		
		
		
		
	}
	
	

}
