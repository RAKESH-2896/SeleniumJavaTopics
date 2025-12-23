// Browser/window management: Control browser size, position, and open/close windows.

package BrowerSetup;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindow {

	 public static void main(String[] args) {

		 // Launches a new Chrome browser session and assigns it to the driver object
	        WebDriver driver = new ChromeDriver();

	        // Maximizes the browser window
	        driver.manage().window().maximize();
	        
	        // Minimize the browser window
	        driver.manage().window().minimize();

	        // fullscreen the browser window
	        driver.manage().window().fullscreen();

	        // Opens the specified URL in the browser
	        driver.get("https://testautomationpractice.blogspot.com/");

	        // Returns the current URL of the page
	        String currentURL = driver.getCurrentUrl();
	        System.out.println("The Current URL of the page: " + currentURL);

	        // Returns the title of the current page
	        String pageTitle = driver.getTitle();
	        System.out.println("The Title of the Current Page: " + pageTitle);

	        // Returns the entire HTML source of the current page
	        String pageSource = driver.getPageSource();
	        System.out.println("The Source of the Current Page: " + pageSource);
	        
	        // Gets the current window handle
	        String mainWindow = driver.getWindowHandle(); 
	        System.out.println("The Current window handle:" + mainWindow);
	        
	        // Gets all open window handles
	        Set<String> allWindows = driver.getWindowHandles(); 
	        System.out.println("All open window handle:" + allWindows);
	        
	        // Closes all browser windows and ends the WebDriver session
	        driver.quit(); 
	    }
	}