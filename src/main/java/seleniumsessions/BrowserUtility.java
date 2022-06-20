package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtility {
	
	private WebDriver driver;
	
	public WebDriver initializeDriver(String browserName) {
		System.out.println("Browser Name is: " + browserName);
		
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		
		else if(browserName.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		
		else {
			System.out.println("Please pass the correct browser "  + browserName);
		}
		
		return driver;
	}
	
	
	public void launchWebPageUrl(String url) {
		if(url == null) {
			System.out.println("URL is null....");
			return;
		}
		
		if(url.indexOf("http") == -1 || url.indexOf("https") ==-1) {
			System.out.println("http(s) is missing....");
			try {
				throw new Exception("HTTPMISSINGEXCEPTION");
			} catch (Exception e) {
				System.out.println("HAHAAAA    http (s) is missing....");
			}
		}
		
		driver.get(url);	
	}
	
	public String getWebPageTitle() {
		  return driver.getTitle();
		
	}
	
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	
	public void closingBrowser() {
		driver.close();
	}
	

	

	
	

}
