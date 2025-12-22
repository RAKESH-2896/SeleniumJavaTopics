//TimeoutsCommands

package Timeouts;
 
import java.time.Duration;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
 
public class TimeoutsCommands {
 
    public static void main(String[] args) {
 
/*
 		TimeoutsCommands
*/
    	// Setup: Launch Chrome browser

        WebDriver driver = new ChromeDriver();
 
        // Maximize the browser window

        driver.manage().window().maximize();
 
        // Open the specified URL in the browser

        driver.get("https://testautomationpractice.blogspot.com/");
 
        // Set implicit wait timeout (waits for elements to appear)

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 
        // Set page load timeout (waits for the page to load)

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
 
        // Set script timeout (waits for asynchronous scripts to finish)

        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
 
        // Close the browser

        driver.quit();

    }
}
 