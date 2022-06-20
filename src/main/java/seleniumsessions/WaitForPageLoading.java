package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForPageLoading {
// we use this method where we have very slow application 
	static WebDriver driver;

	public static void waitForPageLoad(int timeOut) {

		long endTime = System.currentTimeMillis() + timeOut;

		while(System.currentTimeMillis() < endTime) {

			JavascriptExecutor js = (JavascriptExecutor)driver;
			String state = js.executeScript("return document.readyState").toString(); //convert JavaScript String to Java String
			System.out.println("page is : " + state); //from this state I came to know that page is fully loaded or not.like completed
			if (state.equals("complete")) {
				System.out.println("page is fully loaded now....");
				break;
			}

		}  //Java Script: document.readyState-> to check whether the web page or dom is fully loaded or not and...
		                                      //...after that we can interact with the elements.
//Q. What are the 3 states of Page Loading?
//Ans: loading : the document is still loading,
//interactive : Document has finished loading but sub-resources such as scripts, images, stylesheets, and frames are still loading & 
//complete : The document and all sub-resources  have finished loading.


	}

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		waitForPageLoad(20);  //within 20 sec you have to give me the complete state otherwise I assume that page is not loaded.
				
	}

}



