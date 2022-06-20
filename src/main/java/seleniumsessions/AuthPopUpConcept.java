package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

// ************** Authentication PopUp ******************
//Not JS nor HTML dom because the popup is having 2 text fields and sign in button also.

public class AuthPopUpConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	String username = "admin";
	String password = "admin";
		
//Along with the URL we have to pass UserName and Password but we can not use only @ in password as "admin@123" because after @..
//..domain name should be there.
	
	//	driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
//	                            OR
	    driver.get("https://"+username+":"+password+"@"+"the-internet.herokuapp.com/basic_auth");
		

	}

	

}
