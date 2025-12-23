//File upload: Automate uploading files through input fields.

package FileUpload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	  public static void main(String[] args) {

		  // Launches a new Chrome browser session and assigns it to the driver object
	        WebDriver driver = new ChromeDriver();

	        // Maximizes the browser window
	        driver.manage().window().maximize();

	        // Opens the specified URL in the browser
	        driver.get("https://testautomationpractice.blogspot.com/");
	        
	        driver.findElement(By.id("fileInput")).sendKeys("C:\\path\\to\\file.txt");
	        // ...additional steps if needed...
	       
	        // Closes all browser windows and ends the WebDriver session
	        driver.quit(); 
	    }
	}
