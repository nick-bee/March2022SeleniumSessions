package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomCSSSelector {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
			
		//css selector - is not an attribute
		
		//id and class
// we have to use like this:		
		// #id or tag#id
		// .class or tag.class

//	   https://demo.opencart.com/index.php?route=account/login      //inspecting email address text field
//            #input-email or input#input-email
//            .form-control or input.form-control
		
//          #id.class -- we can use id and class together also.
//          .class#id -- we can use class and id together also.
//    eg.   #input-email.form-control
//	  OR	input#input-email.form-control -- we can use id, class together along with html tag.
//	  OR    input.form-control#input-email
		//By.cssSelector("#input-email");
		
		
//       https://app.hubspot.com/login       //inspecting email address text field
//		--if we have multiple classes then"
//                 .c1.c2.c2...cn  --if we have multiple classes then
//                 tag.c1.c2.c3....cn   --by using html tag
//                 input.form-control.private-form__control.login-email  --remove all spaces separated by a dot OR "."
//                 input.form-control.private-form__control.login-email#username  --I can use id also or # after classes
//                 input#username.form-control.private-form__control.login-email  --I can use id also or # before classes

//      https://app.hubspot.com/login       //inspecting email address text field		
//		--if we don't have id and classes then:		
//               tag[attr='value']
//               input[name='email']
//               input[name='email'][type='text'] -- in xpath we have use "and" operator but in CSS we just separated by []
//               input[name='email'][type='text'][placeholder='E-Mail Address']
		
		
		
//** Interview Question : Q.  Which syntax is correct?	
		                      //form-control private-form__control login-email -- 3
		
//1.		By.className("form-control private-form__control login-email");//wrong --When we are using By. className then 
//..we cannot use multiple class together.		
//2.		By.xpath("//input[@class='form-control private-form__control login-email']");//right
//3.		By.cssSelector("input.form-control.private-form__control.login-email");//right
//4.		By.className("login-email");//right  -- either 1 class I can use.
//5.		By.className("private-form__control");//right 
		
		
		
//      https://app.hubspot.com/login       //inspecting email address text field		
	//**parent to child:           in CSS selector we will use ">" symbol:
//              div.private-form__input-wrapper > input#username -- direct child element
//              div.private-form__input-wrapper  input#username -- direct + indirect child elements
		
//              form#hs-login input -- 3 elements are there  -- for indirect child element we have to use "space" in between.
//              form#hs-login input#username --1 (for specific input)
		
//              form#hs-login > input --0  -- gives 0 as input tag is not a direct element and we have used ">" symbol.
			
		
	//**child to parent: NA
			//backward traversing is not allowed in CSS.
		

		
//      https://app.hubspot.com/login       //inspecting email address text field		
	// Can we use contains?	
//              input[id*='name']  -- we use "*" instead of contains
//		        input[id*='name'][type='email'][class*='form-control'] -- we use "*" instead of contains
		
//              input[id^='user'] -- starts with (^)
//              input[id$='name'] --ends with  ($)
		
		
		
		//**preceding-sibling: NA
		
//		https://demo.opencart.com/index.php?route=account/login		
              //**following-sibling: label.control-label + input#input-email  -- with "+" we will get only immediate sibling, we..
//		                                                                      ..cannot use more than one sibling.
			
		
		
		//** xpath is more powerful than CSS selector:
		          //for WebHandling xpath is more powerful
		         //1. in css selector we cannot use backward traversing.
		
		
				 //2. no text support in CSS: 
//       https://demo.opencart.com/index.php?route=account/login
// for eg. if in a dom we have "<h2>Returning Customer</h2>" then we cannot directly use or write by CSS selector which is..
		//.. not in the case in xpath. we can easily write or create xpath by using text in dom..
		//..if we want to use by CSS Selector then first we go to the parent class "div" then to the child class "<h2>"
		
		
				//3. comma in css:
		//by using comma we can use various locators in cssSelector.
		
//		    https://app.hubspot.com/login       // inspecting username text field, password, checkbox, login button
//		int mand_fieldsCount = driver.
//				                 findElements
//		                            (By.cssSelector("input#username, input#password, button#loginBtn, input#remember")).size();
		
		//**not in css:
//               form-control private-form__control login-email
//               form-control private-form__control login-password m-bottom-3
		
		//input.form-control.private-form__control:not(#username)  -- first collect then avoid the id='password'
		
		
		
		
		//                 xpath                              |           cssSelector
		//1. syntax:       hard							                     simple
		//2. backward:     possible						                       NA
		//3. performance:  same							                      same
		//4. comma, not: 	NA							                    available
		//5. text: 			available						                   NA
		//6. sibling: 		better support				                  only direct forward sibling
		//7. dynamic ele: 	available(contains,start with)					available
		//8. webtable: 		better support				                   not that great
		
		
		
		
		
	}

}
