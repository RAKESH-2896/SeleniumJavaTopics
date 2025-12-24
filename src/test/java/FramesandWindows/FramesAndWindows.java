//Frames/windows/tabs: Switch between frames, windows, or browser tabs.

package FramesandWindows;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FramesAndWindows {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://testautomationpractice.blogspot.com/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // ========== Handling Frames ==========
            // Find frames and switch to the first one if present, then interact with the input.
            try {
                List<WebElement> frames = driver.findElements(By.tagName("iframe"));
                if (!frames.isEmpty()) {
                    driver.switchTo().frame(frames.get(0)); // switch to first iframe found

                    try {
                        WebElement frameInput = driver.findElement(By.id("RESULT_TextField-1"));
                        frameInput.clear();
                        frameInput.sendKeys("Rakesh");
                    } catch (NoSuchElementException e) {
                        System.out.println("Input not found inside the frame: " + e.getMessage());
                    }

                    // Switch back to main content
                    driver.switchTo().defaultContent();
                } else {
                    System.out.println("No frames found on the page.");
                }
            } catch (NoSuchFrameException e) {
                System.out.println("Frame switch failed: " + e.getMessage());
            }

            // ========== Handling Windows ==========
            // Capture the main window handle BEFORE clicking the link that opens a new window
            String mainWindow = driver.getWindowHandle();

            // Click on link that opens a new window
            driver.findElement(By.linkText("Click Here")).click();

            // Wait until a new window appears
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(d -> d.getWindowHandles().size() > 1);

            // Get all window handles and switch to the new one
            Set<String> allWindows = driver.getWindowHandles();
            for (String window : allWindows) {
                if (!window.equals(mainWindow)) {
                    driver.switchTo().window(window);

                    // Wait until the page title or body is present to ensure the window has loaded
                    wait.until(ExpectedConditions.titleIs(driver.getTitle())); // simple wait for stability

                    System.out.println("Switched to new window: " + driver.getTitle());

                    // Perform actions in the new window
                    // NOTE: Sending keys to <body> is often unreliable; instead interact with specific elements.
                    // If you want to type into an element, locate it and sendKeys to it. For now, we just print the title.

                    // Close the new window
                    driver.close();
                }
            }

            // Switch back to the main window
            driver.switchTo().window(mainWindow);

        } finally {
            // Close the browser and quit driver (ensures cleanup even if exceptions occur)
            if (driver != null) {
                driver.quit();
            }
        }
    }
}