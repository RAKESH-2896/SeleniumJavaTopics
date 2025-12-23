package FileUpload;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload {

    public static void main(String[] args) {
        // Ensure the chromedriver binary is available (WebDriverManager will download/setup it)
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://testautomationpractice.blogspot.com/");

            // Use a real file path. Recommended: place a test file under src/test/resources/file.txt
            File file = new File(System.getProperty("user.dir") + "/src/test/resources/file.txt");
            if (!file.exists()) {
                System.err.println("File not found: " + file.getAbsolutePath());
                return;
            }

            // Upload by sending the absolute path to the input[type='file'] element
            driver.findElement(By.id("fileInput")).sendKeys(file.getAbsolutePath());

            // small pause to observe the result (optional)
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            // Close browser and quit WebDriver session
            driver.quit();
        }
    }
}