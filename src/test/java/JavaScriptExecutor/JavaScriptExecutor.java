//JavaScript execution: Run custom JavaScript code in the browser.

package JavaScriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor {

    public static void main(String[] args) {

        // Launches a new Chrome browser session and assigns it to the driver object
        WebDriver driver = new ChromeDriver();

        // Maximizes the browser window
        driver.manage().window().maximize();

        // Opens the specified URL in the browser
        driver.get("https://testautomationpractice.blogspot.com/");

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Create JavaScriptExecutor object
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // 1. Send text to input field using JavaScript
        WebElement nameField = driver.findElement(By.id("name"));
        js.executeScript("arguments[0].value='Rakesh';", nameField);

        // 2. Click a button using JavaScript
        WebElement alertButton = driver.findElement(By.xpath("//button[text()='Alert']"));
        js.executeScript("arguments[0].click();", alertButton);

        // 3. Scroll down by pixels
        js.executeScript("window.scrollBy(0, 500);");

        // 4. Scroll to a specific element
        WebElement footer = driver.findElement(By.id("footer"));
        js.executeScript("arguments[0].scrollIntoView(true);", footer);

        // 5. Get page title using JavaScript
        String title = js.executeScript("return document.title;").toString();
        System.out.println("Page Title: " + title);

        // 6. Highlight an element (for visual debugging)
        js.executeScript("arguments[0].style.border='3px solid red'", nameField);

        // Close the browser
        driver.quit();
    }
}