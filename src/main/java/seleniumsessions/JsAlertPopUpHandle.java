package seleniumsessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JsAlertPopUpHandle {

//JS pop up: alert- Please enter a valid userName /prompt- Please enter the value /confirmation- are you sure you want to delete..
//..this user?are you sure you want to make payment?
//modal dialog  are also called JS Popup                                                                   
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.name("proceed")).click();
		Thread.sleep(4000);
		
		Alert alert = driver.switchTo().alert();   //driver will switch to alert box or popup
		String text = alert.getText();  //to fetch the text of the alert
		System.out.println(text);
		
		//alert.sendKeys("testing");  //if the alert is coming with the text field pass alert.sendKeys("*****");
		
		alert.accept();  //if it is a simple alert then click on OK
		//alert.dismiss();  //dismiss the alert, click on cancel
		
		
	}

}
