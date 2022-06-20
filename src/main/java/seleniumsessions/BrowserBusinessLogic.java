package seleniumsessions;

public class BrowserBusinessLogic {

	public static void main(String[] args) {
		
		BrowserUtility bu=new BrowserUtility();
		
		bu.initializeDriver("chrome");
		bu.launchWebPageUrl("http://www.amazon.com");
		
		String title=bu.getWebPageTitle();
		System.out.println("current page Title is :  "+title);
		if(title.contains("Amazon")) {
			System.out.println("correct title captured");
		}
		else {
			System.out.println("incorrect title captured");
		}
		
		
		String url=bu.getUrl();
		System.out.println("current URL is : "+ url);
		if(url.contains("amazon")) {
			System.out.println("correct URL captured");
		}
		else {
			System.out.println("incorrect url");
		}
		
		bu.closingBrowser();
		

	}

}
