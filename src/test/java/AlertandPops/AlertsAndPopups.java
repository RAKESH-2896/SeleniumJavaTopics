//Alerts: Handle browser pop-up alerts and prompts.

package AlertandPops;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsAndPopups {

    public static void main(String[] args) {

        // Launches a new Chrome browser session and assigns it to the driver object
        WebDriver driver = new ChromeDriver();

        // Maximizes the browser window
        driver.manage().window().maximize();

        // Opens the specified URL in the browser
        driver.get("https://testautomationpractice.blogspot.com/");

        // Wait setup
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 1. Handling JavaScript Alert
        driver.findElement(By.xpath("//button[text()='Alert']")).click();

        // Wait for alert to be present
        wait.until(ExpectedConditions.alertIsPresent());

        // Switch to alert and accept it
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text: " + alert.getText());
        alert.accept();

        // 2. Handling Confirmation Pop-up
        driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert confirmAlert = driver.switchTo().alert();
        System.out.println("Confirm box text: " + confirmAlert.getText());
        confirmAlert.dismiss(); // or confirmAlert.accept();

        // 3. Handling Prompt Pop-up
        driver.findElement(By.xpath("//button[text()='Prompt']")).click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert promptAlert = driver.switchTo().alert();
        System.out.println("Prompt text: " + promptAlert.getText());
        promptAlert.sendKeys("Rakesh");
        promptAlert.accept();

        // Close the browser
        driver.quit();
    }
}