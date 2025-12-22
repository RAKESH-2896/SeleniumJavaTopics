package RobustMethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RobotActions {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            // Focus on the name input field
            WebElement nameField = driver.findElement(By.id("name"));
            nameField.click();

            // Initialize Robot class
            Robot r = new Robot();

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
            System.out.println("Robot initialization failed: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

        // Close the browser
        driver.quit();
    }
}