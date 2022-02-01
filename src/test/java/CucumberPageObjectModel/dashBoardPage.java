package CucumberPageObjectModel;


import static org.junit.Assert.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class dashBoardPage extends baseclass {


	LogEntries entry;
	List<LogEntry> logs;
	public dashBoardPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void getConsoleLogs() {
		 entry = driver.manage().logs().get(LogType.BROWSER);
		// Retrieving all log
		 logs = entry.getAll();
		// Print one by one
		 for (LogEntry e : logs) {
				String logsentry = e.toString();
				System.out.println(logsentry);
				if (logsentry.contains("SEVERE") || logsentry.contains("errors") || logsentry.contains("404")
						|| logsentry.contains("Failed")) {

					assertTrue("there is error message", false);  
				}

				assertTrue("there is no error message", true);
			}
		
	}
	public static void getResponcecode(String url) throws MalformedURLException, IOException {
		HttpURLConnection cont = (HttpURLConnection) new URL(url)
				.openConnection();
		// pass HEAD as parameter to setRequestMethod
		cont.setRequestMethod("HEAD");
		// obtain Response code
		cont.connect();
		int rs = cont.getResponseCode();
		System.out.println("Http response code: " + rs);

	}
	
	
	 public static void clickAllHyperLinksByTagName() throws InterruptedException{
		   
		 
			 int numberOfElementsFound = getNumberOfElementsFound(By.tagName("a"));
		 
		    System.out.println(numberOfElementsFound);
		    for (int pos = 0; pos < numberOfElementsFound; pos++) {
		    	Thread.sleep(1500);
			      
		    	try{
		    		String currenturl = getElementWithIndex(By.tagName("a"), pos).getAttribute("href");
		    		System.out.println(currenturl);
		    		getResponcecode(currenturl);
			       	if(currenturl.equals("")) {
			       		
			       	}else {
			       	  getElementWithIndex(By.tagName("a"), pos).click();
				     	Thread.sleep(1500);
				        driver.navigate().back();
			       	}
		    	}
		    	catch(Exception e) {
		    		
		    	}
		      
		    }
		}

		public static int getNumberOfElementsFound(By by) {
		    return driver.findElements(by).size();
		}

		public static WebElement getElementWithIndex(By by, int pos) {
		    return driver.findElements(by).get(pos);
		}
		
}
