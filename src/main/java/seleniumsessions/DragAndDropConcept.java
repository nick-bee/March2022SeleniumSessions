package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropConcept {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
//".build()"- method will collect all the methods or actions and ".perform()"- will perform all these actions in the same order.	
		Actions act = new Actions(driver);
		act.clickAndHold(source).moveToElement(target).release().build().perform();
		
//		act.clickAndHold(source).moveToElement(target).release().build();     //not valid
//		act.clickAndHold(source).moveToElement(target).release().perform();   //valid
		
//                      OR
		
		act.dragAndDrop(source, target).perform();            //valid
		//act.dragAndDrop(source, target).build().perform(); //valid
		//act.dragAndDrop(source, target).build();           //not valid

	}

}
