// Element finding and actions: Locate elements and perform actions like click or type.

package ElementFinding;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementFunctions {

    public static void main(String[] args) {

        // Setup ChromeDriver binary (WebDriverManager)
        WebDriverManager.chromedriver().setup();

        // Optional ChromeOptions - adjust if needed
        ChromeOptions options = new ChromeOptions();
        // Some Chrome/driver combinations require this flag; remove if unnecessary
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);

        // Use try/finally to ensure the browser is closed
        try {
            // Maximize window
            driver.manage().window().maximize();

            // Navigate to the test page
            driver.get("https://testautomationpractice.blogspot.com/");

            // Use explicit wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Locate the name input field (wait until visible)
            WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));

            // Clear the field
            nameField.clear();

            // Type text
            nameField.sendKeys("Rakesh");

            // Get entered value
            String enteredValue = nameField.getAttribute("value");
            System.out.println("Entered value: " + enteredValue);

            // Get tag name
            String tagName = nameField.getTagName();
            System.out.println("Tag name: " + tagName);

            // Get CSS value
            String cssColor = nameField.getCssValue("color");
            System.out.println("CSS color: " + cssColor);

            // Get location and size
            Rectangle rect = nameField.getRect();
            System.out.println("Location: (" + rect.getX() + ", " + rect.getY() + ")");
            System.out.println("Size: Width = " + rect.getWidth() + ", Height = " + rect.getHeight());

            // Locate and click the submit button (wait until clickable)
            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
            submitButton.click(); // or submitButton.submit();

            // Locate a button with visible text and get its text
            WebElement clickButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click Me']")));
            String buttonText = clickButton.getText();
            System.out.println("Button text: " + buttonText);

            // Click the button
            clickButton.click();

            // Small pause if you want to observe result (not recommended for real tests)
            // Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close browser
            if (driver != null) {
                driver.quit();
            }
        }
    }
}