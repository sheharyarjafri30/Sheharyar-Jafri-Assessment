package CucumberPageObjectModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class baseclass {
	public static WebDriver driver;
	public static Properties prop;
	public static ChromeOptions options;
	public int count=0;
	public baseclass() {
		
	}
	
	public void initialization1() throws MalformedURLException {
		String browserName = "chrome";
		FirefoxOptions ffOptions;
		if(browserName.equals("chrome")) {
			 String current = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", current+"\\src\\main\\resources\\driver\\chromedriver.exe");

			
			driver = new ChromeDriver();
		
			
		}
		else if(browserName.equals("FF")) {
			 String current = System.getProperty("user.dir");
			System.setProperty("webdriver.gecko.driver", current+"\\src\\main\\resources\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			
			
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	
		
//	driver.get( "https://www.cars.com/");
	}
	
	public void openurl(String url) {
		driver.get(url);
	}
	public void clickevent(WebElement element) {
		try {
		element.click();
		System.out.println("Successfully Click on event " + element );
		}
		catch (Exception e) {
			System.out.println("Unable to Click on event " + element );
		}
	}
	public void SendKeysevent(WebElement element,String texttosend) {
		try {
			element.clear();
		element.sendKeys(texttosend);
		System.out.println("Successfully sendkeys on event " + element +  texttosend );
		}
		catch (Exception e) {
			System.out.println("Unable to sendkeys on event " + element +  texttosend );
		}
	}
	public void sendkeystoSelectorElement(WebElement element,String texttosend) {
		try {
			Select selectfields = new Select(element);
			selectfields.selectByVisibleText(texttosend);
			System.out.println("Successfully sendkeys on event " + element +  texttosend );
		}
		catch (Exception e) {
			System.out.println("Unable to sendkeys on event " + element +  texttosend );
		}
		
	}
	public void JSMovetoElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public String capturescreenshot(String ScreenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File SRC=	ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"\\reports\\"+count+ScreenshotName+".png";
		File destination = new File(path);
	FileUtils.copyFile(SRC,destination );
	count++;
	
	return path; 
	}
	
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}
}
