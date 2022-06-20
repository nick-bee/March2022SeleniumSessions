package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownHandleConcept {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		// drop down --> (select) html tag is there then use Select class in Selenium

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		By country = By.id("Form_submitForm_Country");
		By states = By.id("Form_submitForm_State");
		
//		selectDropDownByIndex(country, 5);
//		selectDropDownByIndex(states, 4);
//		           OR
		selectDropDownByVisible(country, "India");
		Thread.sleep(4000);
		selectDropDownByVisible(states, "Uttarakhand");
		
      // --------------- Basic Approach -------------	
		
//		Select select = new Select(driver.findElement(country));
//		select.selectByIndex(5);                                 
//		select.selectByVisibleText("India");  //more appropriate and less risky to use "selectByVisibleText".
//		
//		Select select1 = new Select(driver.findElement(states));
//		select1.selectByVisibleText("Karnataka");

	}
	
	// ---------------- Generic Approach -------------------
	
	public static WebElement getElement(By locator) { //used static method so that we can call them directly within a class
		return driver.findElement(locator);
	}
	
	public static void selectDropDownByIndex(By locator, int index) { 
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
		public static void selectDropDownByVisible(By locator, String visibleText) {
			Select select = new Select(getElement(locator));
			select.selectByVisibleText(visibleText);		
	}
		
		public static void selectDropDownByValue(By locator, String value) {
			Select select = new Select(getElement(locator));
			select.selectByValue(value);			
		}
		
		
	
	
	

}
