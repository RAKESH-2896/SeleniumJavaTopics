// JavaScript execution: Run custom JavaScript code in the browser.

package JavaScriptExecutor;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// If you use WebDriverManager in your project, uncomment the next import and setup call below
// import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutor {

    public static void main(String[] args) {

        // If using WebDriverManager (recommended), ensure the dependency is present and uncomment:
        // WebDriverManager.chromedriver().setup();

        // Launches a new Chrome browser session and assigns it to the driver object
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize the browser window and set implicit wait
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Open the specified URL in the browser
            driver.get("https://testautomationpractice.blogspot.com/");

            // Create JavascriptExecutor object
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // 1. Send text to input field using JavaScript
            WebElement nameField = driver.findElement(By.id("name"));
            js.executeScript("arguments[0].value = arguments[1];", nameField, "Rakesh");

            // 2. Click a button using JavaScript
            WebElement alertButton = driver.findElement(By.xpath("//button[text()='Alert']"));
            js.executeScript("arguments[0].click();", alertButton);

            // Handle the alert that appears after clicking the button (if any)
            try {
                Alert alert = driver.switchTo().alert();
                System.out.println("Alert text: " + alert.getText());
                alert.accept();
            } catch (NoAlertPresentException e) {
                // No alert appeared — continue
                System.out.println("No alert present.");
            }

            // 3. Scroll down by pixels
            js.executeScript("window.scrollBy(0, 500);");

            // 4. Scroll to a specific element (if it exists)
            try {
                WebElement footer = driver.findElement(By.id("footer"));
                js.executeScript("arguments[0].scrollIntoView(true);", footer);
            } catch (NoSuchElementException e) {
                System.out.println("Footer element not found: " + e.getMessage());
            }

            // 5. Get page title using JavaScript
            String title = (String) js.executeScript("return document.title;");
            System.out.println("Page Title: " + title);

            // 6. Highlight an element (for visual debugging)
            js.executeScript("arguments[0].style.border='3px solid red'", nameField);

            // Optional: pause briefly so the highlight/scroll can be observed (uncomment if needed)
            // Thread.sleep(1500);

        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}