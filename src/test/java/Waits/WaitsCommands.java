package Waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitsCommands {

    public static void main(String[] args) {

        // If you don't have chromedriver on PATH, set system property or use WebDriverManager:
        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        WebDriver driver = new ChromeDriver();

        try {
            // Maximize browser window
            driver.manage().window().maximize();

            // Open the URL
            driver.get("https://testautomationpractice.blogspot.com/");

            // 1. Implicit Wait (applies globally)
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // 2. Explicit Wait (waits for specific condition)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
            nameField.sendKeys("Rakesh");

            // 3. Fluent Wait (custom polling interval and exception handling)
            // Use FluentWait<T> directly (WebDriverWait extends FluentWait but using FluentWait makes the intent explicit)
            FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(20))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);

            WebElement emailField = fluentWait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
            emailField.sendKeys("rakesh@example.com");
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}