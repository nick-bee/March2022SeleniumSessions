package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


//************* When we don't have options like Select by index, visible, value ******************************//

//         -------------- Basic Approach ------------

public class SelectDropDownAllOptions {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		By country = By.id("Form_submitForm_Country");
		By states = By.id("Form_submitForm_State");
		dropDownSelectValueWithGetOptions(country, "India");
		Thread.sleep(2000);
		dropDownSelectValueWithGetOptions(states, "Uttarakhand");	
		
	}		
//************* Interview Question - Select the drop down without using By index, visible and value? ***********//
	
//*************************** Basic Approach ***********************************************//	
		
//		Select select_country= new Select(driver.findElement(country));
//		List<WebElement> countryoptionsList = select_country.getOptions(); // to get all options under Select class, from country list
//		for(WebElement e : countryoptionsList) {
//			String text = e.getText();		
//			System.out.println(text); //to print all options from country list
//			if(text.equals("India")){ //to print specific country or to select specific country
//				e.click();
//				break;				
//			}			
//		}
	

		//*************************** Generic Approach ***********************************************//	
			
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void dropDownSelectValueWithGetOptions(By locator, String value) {
		
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions(); // to get all options under Select class, from country list
		
		for(WebElement e : optionsList) {
			String text = e.getText();		
			System.out.println(text); //to print all options from country list
			if(text.equals(value)){ //to print specific country or to select specific country
				e.click();
				break;
				
			}
			
			
		}
		
		
		

	}

}
