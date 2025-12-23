//Waits (implicit, explicit, fluent): Wait for elements or conditions before proceeding.

package Waits;
 
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class WaitsCommands {
 
    public static void main(String[] args) {
    		
    	  // Launches a new Chrome browser session and assigns it to the driver object
        WebDriver driver = new ChromeDriver();

        // Maximizes the browser window
        driver.manage().window().maximize();

        // Opens the specified URL in the browser
        driver.get("https://testautomationpractice.blogspot.com/");

        // 1. Implicit Wait (applies globally)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2. Explicit Wait (waits for specific condition)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        nameField.sendKeys("Rakesh");
        			
        // 3. Fluent Wait (custom polling interval and exception handling)
        // Note: FluentWait is part of WebDriverWait in Selenium 4+
        WebDriverWait fluentWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        fluentWait.pollingEvery(Duration.ofSeconds(2));
        fluentWait.ignoring(Exception.class);

        WebElement emailField = fluentWait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
        emailField.sendKeys("rakesh@example.com");

        // Close the browser
        driver.quit();
    }
}