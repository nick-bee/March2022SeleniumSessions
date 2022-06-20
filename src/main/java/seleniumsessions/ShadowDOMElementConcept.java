package seleniumsessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDOMElementConcept {

	public static void main(String[] args) throws InterruptedException {
		
		//html Page DOM --> under this we have no. of elements.
		//--->under this same DOM- Shadow DOM is there --> under this Shadow DOM we have various elements.

//html Page DOM --> elements
	//---->iframe
			//---> Shadow DOM 
						//--> elements
		
// xpath is not applicable for Shadow-root. we have to use CSS selector.
		
// shadow-root has to be in open state. if it is in close state then we cannot handle it by automation.  
		
		
     WebDriverManager.chromedriver().setup();
     WebDriver driver = new ChromeDriver();
     driver.get("https://selectorshub.com/xpath-practice-page/");
     Thread.sleep(15000);
     driver.switchTo().frame("pact");   //always check for the frame first otherwise xpath will not work.

    // document.querySelector("#snacktime").shadowRoot.querySelector("#tea")
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement tea = (WebElement)js.executeScript("return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\")");
		                   //Above we have converted it into a Selenium webElement.
		tea.sendKeys("masala tea");
	}
     
     
     
	

}
