package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

              //************************ not allowed to use Select class ************************//

// ******* Interview Question : Handle the Drop Down without using Select Class **********************//

public class SelectDropDownWithoutUsingSelectClass {

static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		
            //*************** Basic Approach *******************************//
		
//		By country = By.id("Form_submitForm_Country");
//		By states = By.id("Form_submitForm_State");
//		
//		List<WebElement> list = driver.findElements(By.xpath("//select[@id='Form_submitForm_Country']/option"));
//		
//		for(WebElement e : list) {
//			String text = e.getText();
//			if(text.equals("India")) {
//				e.click();
//				break;
//			}
//		}
		

		//*************** Generic Approacah ********************************//
		
		By countryOptions = By.xpath("//select[@id='Form_submitForm_Country']/option");
		dropDownValueUsingLocator(countryOptions, "India");
				
	}
	
	public static void dropDownValueUsingLocator(By locator, String value) {
		List<WebElement> list = driver.findElements(locator);
		
		for(WebElement e : list) {
			String text = e.getText();
			if(text.equals(value)) {
				e.click();
				break;
			}
		}
	}
	

}
