package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinks {
	
	static WebDriver driver;

	public static void main(String[] args) {
	
//**		<----------Interview Question------------->
// to find out total number of Links on a page and print the text of each link on the console & ignore the blank text
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");

// we have use "findElements" here and we never perform any actions( like .sends(), .click()) after that just end with ; .
//to find total links we have used "By.tagName("a") as links are started with tag "a href".
//we have used "List<WebElement>" instead of "Array" because no.of links vary every sec or minute in Amazon so List.. 
//..is dynamic array and it is already defined in Selenium that "driver.findElements()" will return List.
//"List" is the parent interface of "ArrayList" and it will maintain an order as 0,1,2....
//what type of links we are getting "WebElement" type not String type.
		
	List<WebElement> linksList= driver.findElements(By.tagName("a"));
		System.out.println("Total number of links: " +linksList.size());
		
//by using for loop:		
//		for (int i=0; i<linksList.size(); i++) {
//			String text= linksList.get(i).getText();  //on index based loop we use "get(i)" and ".get(i)" is representing a WebElement.
//                                                      //..which method is used to get the value from the ArrayList ".get(i)".
//			
//			System.out.println(text); //there are some links which are having a blank text that also will print
//			if(!text.isEmpty()) {     //ignore the blank text by using "!text.isEmpty()" [print those which are not empty]
//				System.out.println(text); 
//			}
//		}
//		
		
//solved the same with for each loop:		
		for(WebElement e : linksList) {   //we have WebElement type of data.
			String text = e.getText();   //e will go to every element whatever we have stored in the linkList.
		if(!text.isEmpty()) {
			System.out.println(text);
	}
		
		
//how to use stream in selenium:
//		        linksList.stream().forEach(ele -> System.out.println(ele.getText())); //blank text included
    //convert that list into stream   // use any variable like "ele"  // -> supply to System.out.println();
		                         //this "ele" will pointing to each and every element in the list
		           
//		           OR
		      //blank text excluded:
         //  linksList.stream().filter(el -> !el.getText().isEmpty()).forEach(el -> System.out.println(el.getText()));     
		           
		}
		
		

		
		
		
		
		
	}	


}
	

