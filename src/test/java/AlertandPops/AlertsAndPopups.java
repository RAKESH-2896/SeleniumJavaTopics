package AlertandPops;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// If your project uses WebDriverManager, uncomment the import below and call WebDriverManager.chromedriver().setup();
// import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * AlertsAndPopups:
 * - Navigates to the demo page
 * - Handles an alert, a confirmation and a prompt
 * - Switches into an iframe if the demo buttons are inside one
 * - Uses explicit waits and ensures the browser is closed in a finally block
 */
public class AlertsAndPopups {

    public static void main(String[] args) {

        // If chromedriver isn't available via Selenium Manager / PATH, enable WebDriverManager:
        // WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://testautomationpractice.blogspot.com/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Some demo pages place the alert buttons inside an iframe. If so, switch to the first iframe.
            List<WebElement> frames = driver.findElements(By.tagName("iframe"));
            if (!frames.isEmpty()) {
                driver.switchTo().frame(frames.get(0));
            }

            // 1) JavaScript Alert
            WebElement alertBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(normalize-space(.),'Alert') or contains(.,'Alert Box') or contains(.,'Alert')]")
            ));
            alertBtn.click();

            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert text: " + alert.getText());
            alert.accept();

            // 2) Confirmation pop-up
            WebElement confirmBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(.,'Confirm') or contains(.,'Confirm Box') or contains(.,'Confirm') ]")
            ));
            confirmBtn.click();

            wait.until(ExpectedConditions.alertIsPresent());
            Alert confirmAlert = driver.switchTo().alert();
            System.out.println("Confirm box text: " + confirmAlert.getText());
            // choose dismiss or accept based on test need
            confirmAlert.dismiss();

            // 3) Prompt pop-up
            WebElement promptBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(.,'Prompt') or contains(.,'Prompt Box') or contains(.,'Prompt')]")
            ));
            promptBtn.click();

            wait.until(ExpectedConditions.alertIsPresent());
            Alert promptAlert = driver.switchTo().alert();
            System.out.println("Prompt text: " + promptAlert.getText());
            promptAlert.sendKeys("Rakesh");
            promptAlert.accept();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Ensure the browser is always closed even if something fails
            if (driver != null) {
                driver.quit();
            }
        }
    }
}