//Capabilities: Set browser-specific options and configurations.

package HeadlessChrome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChrome {
	
	  public static void main(String[] args) {

	  ChromeOptions options = new ChromeOptions();
	        options.addArguments("--headless");
	  // Launches a new Chrome browser session and assigns it to the driver object
      WebDriver driver = new ChromeDriver();

      // Maximizes the browser window
      driver.manage().window().maximize();

      // Opens the specified URL in the browser
      driver.get("https://testautomationpractice.blogspot.com/");
      
      // Returns the title of the current page
      System.out.println("Title: " + driver.getTitle());
      
      // Closes all browser windows and ends the WebDriver session
      driver.quit(); 
      
	}
}