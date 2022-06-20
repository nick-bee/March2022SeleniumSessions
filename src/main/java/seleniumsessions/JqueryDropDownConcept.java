package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDownConcept {
	
static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		
		driver.findElement(By.id("justAnInputBox")).click();
		Thread.sleep(4000);
		
		By choices = By.xpath("(//div[contains(@id,'DropDownContainer')])[1]/ul//span[@class='comboTreeItemTitle']");
		
	//tc_01: single selection:
	//selectChoice(choices, "choice 1"); //to select only 1 drop down or for multiple or limited selection call the method.. 
		                                   //..again and again but not a good approach for 10 selection and more.
		
	//tc_02: multiple selection:
	//selectChoice(choices, "choice 1", "choice 2", "choice 5", "choice 7"); //not a good approach for 10 or all selection and more.
		
		
	//tc_03: all selection:
	 // selectChoice(choices, "all");  // user is passing this "all" value.
		

	selectChoice(choices, "choice 9"); // choice 9 is not there as an option.


	}
	
//	What if we have to select multiple Drop Downs :
	
                   //******************** Generic Approach **********************************//	
	
	public static void selectChoice(By locator, String... value) { //we have used "String..." here so that user can use..
		//..comma separated values ---- easy to do or easy job. and it is called 3 dot parameter..
	    //"String..."it should be last variable in a method
		//We can use ArrayList also. 
		//if I use a Array variable like "String[] value" then I have to create an array variable first..
		//..store all these choices there and then pass the Array  --- such a tedious job.
		
		List<WebElement> choiceList = driver.findElements(locator);
		System.out.println(choiceList.size());
		boolean flag = false;
		if(!value[0].trim().equalsIgnoreCase("all")) { //value[0] is not equals to all then if part will execute but we have..
			                                            //..deliberately given value[0]= all so it will execute else part.
			for(WebElement e : choiceList) {
			String text = e.getText().trim();
			//System.out.println(text);

			for(int i=0; i<value.length; i++) {
				if(text.equals(value[i])) {
					flag = true;
					e.click();
					break;
				}
			}
			
		}
		
	}
		else {
			
			//all selection logic:
			
			for(WebElement e : choiceList) {
				e.click();
				flag = true;
			}
		}
		
		if(flag == false) {
			System.out.println("choice is not available "+value[0]);
		}
	}
}
