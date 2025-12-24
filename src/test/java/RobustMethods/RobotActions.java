//RobotActions

package RobustMethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RobotActions {

    public static void main(String[] args) {

        WebDriver driver = null;
        try {
            // Ensure ChromeDriver binary is available (requires io.github.bonigarcia:webdrivermanager)
            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://testautomationpractice.blogspot.com/");

            // Focus on the name input field
            WebElement nameField = driver.findElement(By.id("name"));
            nameField.click();

            // Initialize Robot class (may throw AWTException)
            Robot r = new Robot();
            // small automatic delay between events so the target field receives keystrokes
            r.setAutoDelay(100);

            // Optional short pause to ensure element has focus
            try {
                Thread.sleep(300);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }

            // Simulate typing with SHIFT (uppercase)
            r.keyPress(KeyEvent.VK_SHIFT);
            r.keyPress(KeyEvent.VK_R);
            r.keyRelease(KeyEvent.VK_R);

            r.keyPress(KeyEvent.VK_A);
            r.keyRelease(KeyEvent.VK_A);

            r.keyPress(KeyEvent.VK_K);
            r.keyRelease(KeyEvent.VK_K);

            r.keyPress(KeyEvent.VK_E);
            r.keyRelease(KeyEvent.VK_E);

            r.keyPress(KeyEvent.VK_S);
            r.keyRelease(KeyEvent.VK_S);

            r.keyPress(KeyEvent.VK_H);
            r.keyRelease(KeyEvent.VK_H);
            r.keyRelease(KeyEvent.VK_SHIFT);

            // Simulate pressing DOWN arrow
            r.keyPress(KeyEvent.VK_DOWN);
            r.keyRelease(KeyEvent.VK_DOWN);

            // Simulate pressing UP arrow
            r.keyPress(KeyEvent.VK_UP);
            r.keyRelease(KeyEvent.VK_UP);

        } catch (AWTException e) {
            System.err.println("Robot initialization failed: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the browser (ensure this always runs)
            if (driver != null) {
                driver.quit();
            }
        }
    }
}