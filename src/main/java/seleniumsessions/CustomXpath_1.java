package seleniumsessions;

public class CustomXpath_1 {

	public static void main(String[] args) {
		
//		https://demo.opencart.com/index.php?route=account/login
		
		//xpath: is not an attribute
		//It is the address of the element in html dom
				
		//html/body/div/div[2]/form/div[1]/div[3]/div/input 
		//html/body/div/div[2]/div/ul/li/input like in drop down
		//absolute xpath: not recommended as it can change in future also after adding new features by developers..
		//..so same xpath will not work so we have to create our own xpath or custom path.
		
		//relative xpath: custom xpath: xpath axes like sibling, parent child, following sibling concept :
//		//htmltag[@attr = 'value'] -- Syntax of custom xpath.
//		//input[@id='input-email']
		
//htmlTag are- input,ul,li,div,form,a
		
        //**If we want to add 2 or 3 attribute:		
//		       //htmltag[@attr1 = 'value' and @attr2 = 'value'] -- Syntax
//		       //input[@id='input-email' and @name='email']
//		       //input[@id='input-email' and @name='email' and @type='text']
		
         //**If id and name is not available: we can use placeholder custom xpath
//		         //input[@placeholder='E-Mail Address']
		
		
        //**contains() : 
//		         will use when we have dynamic attribute[value changes after refreshing the page] and when attribute value is long
//		        //htmltag[contains(@attr,'value')] -- Syntax
//		        //input[contains(@id,'firstname')]
		
		//input id = "test_123"
		//input id = "test_456"
		//input id = "test_890"
		//input[contains(@id,'test_')]
		
        //**We can use attributes with "contains()" and "without contains()" all together :	
//		          //htmltag[contains(@attr1,'value') and @attr2='value'] -- Syntax
//		          //input[contains(@id,'firstname') and @name='firstname']

		
          //** all attributes having conatins() :
		          //htmltag[contains(@attr1,'value') and contains(@attr2,'value')] -- Syntax
		          //input[contains(@id,'firstname') and contains(@name,'first')]
//	OR	          //input[@name='firstname' and contains(@id,'firstname') and contains(@placeholder,'First')]
//	OR	          By firstName = By.xpath("//input[contains(@id,'firstname') and contains(@name,'first')]");
		
		
		//**text():  OR Header text(Register Account) OR wherever text is there
//		           Will use when we dont have id, name etc only have example- "h1" [header 1]
			      //htmltag[text()='value']
			      //h1[text()='Register Account']
//	OR		      By registerAccHeader = By.xpath("//h1[text()='Register Account']");
		
		
//		//Label text(Your Personal Details):-
		//legend[text()='Your Personal Details']
		
//		//a[text()='Register'] -- [for Register Link text]
	
//		https://www.freshworks.com/  :-		
		//p[text()='Freshworks makes it fast and easy for businesses to delight their customers and employees.']
		
		
		//**text() with attribute:
			    //htmltag[text()='value' and @attr='value']
			    //a[text()='Forgotten Password' and @class='list-group-item'] -- [forgotten password]
			
		
		//**contains() with text():
				//htmltag[contains(text(),'value')]
				//legend[contains(text(),'Personal')]
				//p[contains(text(),'businesses to')]
		
		
		//**contains(), text() and attribute:
	            //htmltag[contains(@attr,'value') and text()='value' and @attr='value']
		        //a[contains(@href,'route=account/forgotten') and text()='Forgotten Password' and @class='list-group-item']
		        //a[contains(@href,'route=account/forgotten') and contains(text(),'Forgotten') and contains(@class,'list-group')]
		

		//**starts-with():
				//htmltag[starts-with(@attr,'value')]
				//input[starts-with(@name,'first')]
//	OR			//input[starts-with(@name,'first') and starts-with(@placeholder,'First')]
		
		
		//**starts-with() and text():
		        //htmltag[starts-with(text(),'value')]
		        //h1[starts-with(text(),'Register')]
		
// there is no concept of ends-with() in Selenium.	
		
		
		//**index:   first we have to capture it in a group then apply index[] whether 0,1,2,3 etc.
//                   will use when we don't have any other attribute in dom.
//		      (//input[@class='form-control'])[2]
//		      (//input[@class='form-control'])[position()=2]
//		      By.xpath("(//input[@class='form-control'])[2]");
		
		
		//**last():
//		      (//input[@class='form-control'])[last()]
//            (//input[@class='form-control'])[last()-1]
// there is no concept of first or second() in Selenium.	
		
		
//		https://www.amazon.in/
//** Interview Question - what is the position of "Help" and verifying it is the page or not?..
//	OR	..our requirement is : Help should be in the last column and should be the last element.
//            ((//div[contains(@class,'navFooterLinkCol')])[last()]//li)[last()]/a
		//we have used 2 captured groups here:
		//1st for the last column and 2nd for the last element.
		
//Q. 	https://www.amazon.in/
// What is the position of "Help" and verifying it is the page or not? OR our requirement is : Help should be in the last column.. 
//..and should be the last element.
//Ans.
//	(//div[contains(@class,'navFooterLinkCol')])[4]
//– We have used captured group and selected the 4th column by writing [4] after the captured group. But [4] this is a hard coded..
//..value. So we will use last() and after that we are getting 8 li(8 elements in the last column) but we have to go to the..
//..last element so we will again use the captured group : ((//div[contains(@class,'navFooterLinkCol')])[last()]//li)
//- and this will give me 1 of 8.  Now we have to go to the last element amongst these 8 so we will use last() :
// ((//div[contains(@class,'navFooterLinkCol')])[last()]//li)[last()]
//	And if we want to capture the text then we know through a tag we get the text :
//	((//div[contains(@class,’navFooterLinkCol’)])[last()]//li)[last()]/a
//  This is the right xpath we have written, this will not work in only one condition when developer changes the class  of the..
//..particular element and this is very rare to see.
		
		
		//https://demo.opencart.com/index.php?route=account/login
//		//xpath axes:
		//**parent and child:
		      //parent tag / child tag - direct child elements
		     //parent tag // child tag -- direct + indirect child elements
		
		    //div[@id='content']//child::form   OR    //div[@id='content']//form
		   //div[@id='content']//form//input[@name='email']
		
		
		//**child to parent:   OR backward traversing
		    //backward traversing in xpath: allowed that is not allowed in Css selector
		   //input[@name='email']/../../../../../../../../../..

		    //input[@name='email']/parent::div ----> to go the immediate parent
//	  OR   //input[@name='email']/..
		  //input[@name='email']/ancestor::form ----> to go the grandparent or ancestor or indirect parent
		
		//** Interview Question
//		Q. How can you reach to parent from child element?
		
		
		
		//**preceding-sibling:       for email text field
		//input[@name='email']/preceding-sibling::label[@for='input-email']
		//we will use .getText() to capture the text after the above xpath.
		
		//**following-sibling:
		//label[@for='input-email']/following-sibling::input but what if in future one more sibling input tag is added..
		//..then we will  give specific detail by using @name::
		//label[@for='input-email']/following-sibling::input[@name='email']
		
		
		
//		** Selectors and Herbs tool for xpath.
		
		
//		https://demo.opencart.com/index.php?route=account/register
		
		
// While selecting Yes or No there is an space prior the Yes text or No text. and we cannot directly use Xpath due this space..
//..so we have to use "normalize-space()" to ignore the spaces in the text. and the text belongs to label nor to input.
		
		//label[normalize-space()='Yes']/input
		
//..and after that we perform the action like .click etc.
		
	}
}

