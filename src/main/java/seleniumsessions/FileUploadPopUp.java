package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadPopUp {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		
//type="file" - this property should be there or is mandatory and if it is not there then we have to ask the developer..
//..to add this particular attribute then only Selenium will work.
		//Selenium cannot select multiple files (image file to upload) at once.		
		
		driver.findElement(By.name("upfile")).sendKeys("C:\\Users\\sysadmin\\Desktop/depositpic.jpg");
		
//		driver.findElement(By.name("upfile")).sendKeys("/Users/naveenautomationlabs/Documents/workspace/March2022SeleniumSessions/GIT_Course.png");

		//Robot classes- Only work for windows machine..
		//..We can not use Robot  classes as it will not work on Linux, MAc, container or docker container(only for Linux machines).
		//autoIT - 3rd party tool, only for windows application.
		//sikuli -- image based
		
	} 



}
