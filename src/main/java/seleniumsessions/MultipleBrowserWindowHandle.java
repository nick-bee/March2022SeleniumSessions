package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleBrowserWindowHandle {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/");// parent window
		String parentWindowId = driver.getWindowHandle();

		//4 clicks I am doing and open 4 more windows + 1 Parent window
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click();
		driver.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on youtube']")).click();
		
		Set<String> handles = driver.getWindowHandles();  //It will return Set of String
		
		Iterator<String> it = handles.iterator();
		
		while(it.hasNext()) {
			String windowId = it.next();  // to get the window ID and stored in the String windowID.
			if(!parentWindowId.equals(windowId)) {
				driver.switchTo().window(windowId);
				System.out.println(driver.getCurrentUrl());
				driver.close();
			}
			
		}
		
		driver.switchTo().window(parentWindowId);
		System.out.println("parent window title: " + driver.getTitle());
	}

}
