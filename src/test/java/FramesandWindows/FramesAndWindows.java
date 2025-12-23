//Frames/windows/tabs: Switch between frames, windows, or browser tabs.

package FramesandWindows;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesAndWindows {

    public static void main(String[] args) {

        // Launches a new Chrome browser session and assigns it to the driver object
        WebDriver driver = new ChromeDriver();

        // Maximizes the browser window
        driver.manage().window().maximize();

        // Opens the specified URL in the browser
        driver.get("https://testautomationpractice.blogspot.com/");

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // ========== Handling Frames ==========
        // Switch to frame by index
        driver.switchTo().frame(0); // Switch to first frame on the page

        // Perform action inside the frame
        WebElement frameInput = driver.findElement(By.id("RESULT_TextField-1"));
        frameInput.sendKeys("Rakesh");

        // Switch back to main content
        driver.switchTo().defaultContent();

        // ========== Handling Windows ==========
        // Click on link that opens a new window
        driver.findElement(By.linkText("Click Here")).click();

        // Get current window handle
        String mainWindow = driver.getWindowHandle();

        // Get all window handles
        Set<String> allWindows = driver.getWindowHandles();

        // Switch to the new window
        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                System.out.println("Switched to new window: " + driver.getTitle());

                // Perform actions in the new window
                driver.findElement(By.tagName("body")).sendKeys("Hello from new window!");

                // Close the new window
                driver.close();
            }
        }

        // Switch back to the main window
        driver.switchTo().window(mainWindow);

        // Close the browser
        driver.quit();
    }
}