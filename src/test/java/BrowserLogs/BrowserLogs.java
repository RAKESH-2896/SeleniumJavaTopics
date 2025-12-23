//Browser logs: Retrieve logs for debugging browser activity.

package BrowserLogs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class BrowserLogs {

	public static void main(String[] args) {

		  // Launches a new Chrome browser session and assigns it to the driver object
	        WebDriver driver = new ChromeDriver();

	        // Maximizes the browser window
	        driver.manage().window().maximize();

	        // Opens the specified URL in the browser
	        driver.get("https://testautomationpractice.blogspot.com/");
	        
	        LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
	        for (LogEntry entry : logs) {
	            System.out.println(entry.getMessage());
	        }
	        
	     // Closes all browser windows and ends the WebDriver session
	        driver.quit(); 
	}	        
}