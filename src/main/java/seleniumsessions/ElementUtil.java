package seleniumsessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	
	public By getBy(String locatorType, String locatorValue) {
		By locator = null;
		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(locatorValue);
			break;

		default:
			break;
		}
           return locator;
       }
	
	
	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	

	public String getAttributeValue(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}
	
	
	public boolean doIsEnabled(By locator) {
		return getElement(locator).isEnabled();
	}
	
	
	public String doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	
	
	
	
	public void doSendKeys(String locatorType, String locatorValue, String value) {
		getElement(getBy(locatorType, locatorValue)).sendKeys(value);
	}
	
	
	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	
	public  List<WebElement> getElements(By locator) {
		 return driver.findElements(locator);		 
	}
	
	
	public  int getElementCount(By locator) {  //just give me the By locator(like images,href, etc) I will give you the count
		return getElements(locator).size();
	}
	
	
	public List<String> getElementsAttributeList(By locator, String attrName) {		
		List<WebElement> eleList= getElements(locator);         
		List<String> eleAttrList = new ArrayList<String>(); 				
	     for(WebElement e : eleList) {                   
	       String attValue = e.getAttribute(attrName);   
	       System.out.println();
	       eleAttrList.add(attValue);               
	  }
		return eleAttrList;  
	}
	
	
	public  List<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();
		for(WebElement e : eleList) {
			String eleText = e.getText();
			System.out.println(eleText);
			eleTextList.add(eleText);			
		 }
		  return eleTextList;
	}
	
	
	public void selectSuggestion(By locator, String suggValue) throws InterruptedException {

		List<WebElement> suggList = driver.findElements(locator);
	    for(WebElement e : suggList) {
		  String text = e.getText();               //System.out.println(e.getText());
		  System.out.println(text);
		      if(text.contains(suggValue)) {
		    	  e.click();
		    	  break;
		      }
		}
	  }
	
		
		public List<String> getSuggList(By locator, String searchKey) throws InterruptedException {
	
			List<WebElement> suggList = driver.findElements(locator);
			List<String> suggValList = new ArrayList<String>();
			for(WebElement e : suggList) {
			  String text = e.getText();               //System.out.println(e.getText());
			  System.out.println(text);
			  suggValList.add(text);
			}
		    return suggValList;
		}
		
		
		public boolean isElementDisplayed(By locator) {
			WebElement ele = getElement(locator); //to check whether element is displayed or not.
			List<WebElement> eleList = getElements(locator); //to get the size.
			if(eleList.size()>0) {
				if(ele.isDisplayed())
					return true;
			}
			return false;
		}
		
		
		public boolean isElementDisplayedWithSize(By locator) { //to get the size.
			List<WebElement> eleList = getElements(locator);
			if(eleList.size()>0) {
					return true;
			}
			return false;
		}
		
		
// **************************** Drop Down Utils ************************************************//		
		
		public  void selectDropDownByIndex(By locator, int index) {   
			Select select = new Select(getElement(locator));
			select.selectByIndex(index);
		}
		
		
			public  void selectDropDownByVisible(By locator, String visibleText) {   
				Select select = new Select(getElement(locator));
				select.selectByVisibleText(visibleText);		
		}
			
			
			public  void selectDropDownByValue(By locator, String value) {   
				Select select = new Select(getElement(locator));
				select.selectByValue(value);			
			}
			
			
			public int getDropDownValuesCount(By locator) {
				Select select = new Select(getElement(locator));
				return select.getOptions().size();
			}
			
			
			public void dropDownSelectValueWithGetOptions(By locator, String value) {
				
				Select select = new Select(getElement(locator));
				List<WebElement> optionsList = select.getOptions(); // to get all options under Select class, from country list
				
				for(WebElement e : optionsList) {
					String text = e.getText();		
					System.out.println(text); //to print all options from country list
					if(text.equals(value)){ //to print specific country or to select specific country
						e.click();
						break;
						
					}
					
				}
				}
				
				
				public void dropDownValueUsingLocator(By locator, String value) {
					List<WebElement> list = driver.findElements(locator);
					
					for(WebElement e : list) {
						String text = e.getText();
						if(text.equals(value)) {
							e.click();
							break;
						}
					}
				}

			
//*********************** Actions Utils ***************************************//			

				public void levelTwoMenuHandling(By parentMenu, By childMenu) throws InterruptedException {
					Actions act = new Actions(driver);
					act.moveToElement(getElement(parentMenu)).perform();
					Thread.sleep(1500);
					getElement(childMenu).click();
				}
				
				
				public void multiLevelMenuHandling(By parentMenu, String l1, String l2, String l3, String l4) throws InterruptedException {

					Actions act = new Actions(driver);
					act.moveToElement(getElement(parentMenu)).perform();
					Thread.sleep(1500);

					act.moveToElement(driver.findElement(By.linkText(l1))).perform();
					Thread.sleep(1500);

					act.moveToElement(driver.findElement(By.linkText(l2))).perform();
					Thread.sleep(1500);

					act.moveToElement(driver.findElement(By.linkText(l3))).perform();
					Thread.sleep(1500);

					getElement(By.linkText(l4)).click();
				}
				
				
				public  void selectRightClickMenu(By rightClickElementLocator, By rightMenuItem) {
					Actions act = new Actions(driver);
					act.contextClick(getElement(rightClickElementLocator)).perform();
					getElement(rightMenuItem).click();
				}
				
				
				public  List<String> getRightClickMenuList(By rightClickElementLocator, By rightMenuItems) {
					List<String> rightMenuList = new ArrayList<String>();  //we are maintaining a Blank ArrayList here.
					
					Actions act = new Actions(driver);
					act.contextClick(getElement(rightClickElementLocator)).perform();
					List<WebElement> menuItems = driver.findElements(rightMenuItems);

					for (WebElement e : menuItems) {
						String text = e.getText();
						rightMenuList.add(text);
					}
					return rightMenuList;
				}
				
				
				public void dragAndDropAction(By source, By target ) {
					Actions act = new Actions(driver);
					act.clickAndHold(getElement(source)).moveToElement(getElement(target)).release().build().perform();
				}
				
				
				public void doActionsSendKeys(By locator, String value) {
					Actions act = new Actions(driver);
					act.sendKeys(getElement(locator), value).perform();
				}
				
				public void doActionsClick(By locator) {
					Actions act = new Actions(driver);
					act.click(getElement(locator)).perform();
				}
				
				
				
				
//*********************** Wait Utils ***************************************//	
				
				 //An expectation for checking that an element is present on the DOM of a page...
				 //..This does not necessarily mean that the element is visible.
				public WebElement waitForElementPresence(By locator, int timeOut) {
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
					return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				}
				
				
				 //An expectation for checking that an element is present on the DOM of a page and visible...
				 //...Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
				public WebElement waitForElementVisible(By locator, int timeOut) {
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
					return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
				}
				
				
				
				           //An expectation for checking that the title contains a case-sensitive substring.	
				public String waitForTitleContains(String titleFraction, int timeOut) {
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
					if (wait.until(ExpectedConditions.titleContains(titleFraction))) {
						return driver.getTitle();
					}
					return null;    //else part
				}
				
								
				         // An expectation for checking the title of a page.
				public String waitForTitleIs(String title, int timeOut) {
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
					if (wait.until(ExpectedConditions.titleIs(title))) {
						return driver.getTitle();
					}
					return null;    //else part
				}
				
				
				
                           //for fraction of url:
              public String waitForUrlContains(String urlFraction, int timeOut) {
	          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
	             if(wait.until(ExpectedConditions.urlContains(urlFraction))) {
		            return driver.getCurrentUrl();
	             }
	               return null;
              }
              
              
                          //for complete url:
              public String waitForUrlIs(String url, int timeOut) {  
	          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
	            if(wait.until(ExpectedConditions.urlToBe(url))) {
		              return driver.getCurrentUrl();
	             }
	                return null;
              }
				
				
              
              
          	public void acceptAlert(int timeOut) {  
        		waitForAlert(timeOut).accept();
        	}

        	public void dismissAlert(int timeOut) {
        		waitForAlert(timeOut).dismiss();
        	}

        	public void alertSendKeys(int timeOut, String value) {
        		waitForAlert(timeOut).sendKeys(value);
        	}

        	public String doGetAlertText(int timeOut) { //go to the specific alert and capture the text
        		return waitForAlert(timeOut).getText();
        	}
        	
        	public Alert waitForAlert(int timeOut) {
        		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        		return wait.until(ExpectedConditions.alertIsPresent()); // wait for alert and then switch to alert

        	}
				
				
        	                //wait for frame
        	public void waitForFrameByLocator(By frameLocator, int timeOut) {		
        		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));		
        	}

        	public void waitForFrameByIndex(int frameIndex, int timeOut) {		
        		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
        	}
        	
        	public void waitForFrameByElement(WebElement frameElement, int timeOut) {		
        		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
        	}
				        	
				
			                //click Element when Ready
        	public void clickElementWhenReady(By locator, int timeOut) {
        		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();  //wait and click also
        	}
        	
        	
        	                // with Polling Time
        	public void waitForElementToBeClickableWithPolling(By locator, int timeOut, long pollingTime) {
        		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(pollingTime), Duration.ofMillis(pollingTime));
        		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        	}
        	
        	
        	
        	                  // visibilityOfAllElementsLocatedBy:
        	//An expectation for checking that all elements present on the web page that match the locatorare visible...
        	//...Visibility means that the elements are not only displayed but also have a heightand width that is greater than 0
        	
        	public List<WebElement> waitForElementsVisible(By locator, int timeOut) {
        		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        	}

        	
                             // presenceOfAllElementsLocatedBy:
        	    //An expectation for checking that there is at least one element present on a web page.
        	   //Default Polling Time = 500ms        	
        	public List<WebElement> waitForElementsPresence(By locator, int timeOut) {
        		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        	}
        	
        	
        	                 // with Polling Time
        	    //An expectation for checking that there is at least one element present on a web page.
        	   //Default Polling Time = customized(User has to pass it)       	
        	public List<WebElement> waitForElementsPresence(By locator, int timeOut, long pollingTime) {
        		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofMillis(pollingTime));
        		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        	}
				
				
        	                  // Fluent Wait
        	public void waitForElementPresenceWithFluentWait(By locator, int timeOut, int pollingTime, String message) {
        		
    			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
    					.withTimeout(Duration.ofSeconds(timeOut))
    					.pollingEvery(Duration.ofMillis(pollingTime))
    					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
    					.withMessage(message);

    			wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    		}
        	
        	
        	
        	
 //***************************** Custom Wait for the specific Element ***********************************************//       	
        	
        	public WebElement retryingElement(By locator, int timeOut, int pollingTime) {        		
        		WebElement element = null;  //non primitive data type or default value of WebElement is null
                                           //so initially we are declaring it null        		
        		int attempts = 0;
        		while (attempts < timeOut) {   //0 attempt, 1 attempt, 2 attempt.......till number of timeOut
        			try {
        				element = driver.findElement(locator);  //when the element is found break the loop.
        				break;
        			} catch (NoSuchElementException e) {  //if still element is not there then below catch will run
        				System.out.println("element is not found in attempt : " + attempts + " for : " + locator); //if on 1st attempt not... 
        				                                                      //...found then we have to use sleep also
        				try {
        					Thread.sleep(pollingTime);   //wait for 1000 milisecs
        				} catch (InterruptedException e1) {
        					e1.printStackTrace();
        				}
        			}
        			attempts++;
        		}		
             		if (element == null) {
        			try {
        				throw new Exception("ELEMENTNOTFOUNDEXCEPTION");
        			} catch (Exception e) {
        				System.out.println("element is not found exception....tried for : " + timeOut + " secs"
        						+ " with the interval of : " + pollingTime + " ms ");
        			}
        		}
        		return element;
        	}
        	
        	
        	
 //***************************** Custom Wait for the specific Page Loading ***********************************************//      	
        	public void waitForPageLoad(int timeOut) {
        		long endTime = System.currentTimeMillis() + timeOut;
        		while (System.currentTimeMillis() < endTime) {
        			JavascriptExecutor js = (JavascriptExecutor) driver;
        			String state = js.executeScript("return document.readyState").toString();
        			System.out.println("page is : " + state);
        			if (state.equals("complete")) {
        				System.out.println("page is fully loaded now....");
        				break;
        			}

        		}

        	}
        	
        	
				
}


