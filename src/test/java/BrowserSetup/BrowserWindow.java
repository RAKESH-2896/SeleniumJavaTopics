package BrowserSetup;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindow {

    public static void main(String[] args) {
        // If chromedriver is not on your PATH, set its location:
        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        // Or use WebDriverManager (io.github.bonigarcia) before creating the driver:
        // WebDriverManager.chromedriver().setup();

        WebDriver driver = null;
        try {
            // Launch a new Chrome browser session
            driver = new ChromeDriver();

            // Maximize the browser window
            driver.manage().window().maximize();

            // Open the specified URL
            driver.get("https://testautomationpractice.blogspot.com/");

            // Print current URL and title
            System.out.println("Current URL: " + driver.getCurrentUrl());
            System.out.println("Page title: " + driver.getTitle());

            // Get page source but avoid printing the entire HTML (can be very large)
            String pageSource = driver.getPageSource();
            System.out.println("Page source length: " + pageSource.length());
            System.out.println("Page source (first 500 chars):\n" +
                    (pageSource.length() > 500 ? pageSource.substring(0, 500) : pageSource));

            // Get the current window handle and all open window handles
            String mainWindow = driver.getWindowHandle();
            System.out.println("Main window handle: " + mainWindow);

            Set<String> allWindows = driver.getWindowHandles();
            System.out.println("All window handles: " + allWindows);

            // Demonstrate minimize and fullscreen with short pauses so effects can be observed
            driver.manage().window().minimize();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            driver.manage().window().fullscreen();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }

        } catch (Exception e) {
            System.err.println("Error while running WebDriver: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Ensure the browser is closed and WebDriver session ends
            if (driver != null) {
                driver.quit();
            }
        }
    }
}