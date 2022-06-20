package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClickAndSendKeys {

//Actionclass.click  or act.click(); method first it will move to the specific element in the middle of the element and click it,..
//..And normal .click(); it will click anywhere on the login button. Useful in the cases where any pop up is overlapping the.. 
//..login button.
	
// “act.sendKeys();” method first it will move to the specific element then click on the specific text field and..
//..then it will enter the value.

//if selenium is not able to find element then it will throw an exception as ElementNotFoundException,and..
//..if selenium is not able to interact with specific element then it will throw an exception as NotInteractiveException. Then in that case we have to use Act.click();

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		By emailId = By.id("input-email");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
		
		doActionsSendKeys(emailId, "naveen@gmail.com");
		doActionsSendKeys(password, "test@123");
		doActionsClick(loginBtn);
		
		//************** Basic Approach **********************//
		
//		Actions act = new Actions(driver);
//		act.sendKeys(getElement(emailId), "test@gmail.com").perform(); //we will select the 2nd .sendKeys(); method.
//		act.sendKeys(getElement(password), "test@123").perform();
//		act.click(getElement(loginBtn)).perform();
	
		
		//*************** Generic Approach ***************//
	}
	
	public static void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();
	}
	
	public static void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
}

