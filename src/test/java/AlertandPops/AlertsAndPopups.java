//Alerts: Handle browser pop-up alerts and prompts.

package AlertandPops;
 
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
 
public class AlertsAndPopups {
 
    public static void main(String[] args) {
 
        WebDriver driver = new ChromeDriver();
 
        try {

            driver.manage().window().maximize();

            driver.get("https://testautomationpractice.blogspot.com/");
 
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 
            // 1) JavaScript Alert

            WebElement alertBtn = wait.until(ExpectedConditions.elementToBeClickable(

                    By.xpath("//button[text()='Alert']")));

            alertBtn.click();
 
            wait.until(ExpectedConditions.alertIsPresent());

            Alert alert = driver.switchTo().alert();

            System.out.println("Alert text: " + alert.getText());

            alert.accept();
 
            // 2) Confirmation pop-up

            WebElement confirmBtn = wait.until(ExpectedConditions.elementToBeClickable(

                    By.xpath("//button[text()='Confirm']")));

            confirmBtn.click();
 
            wait.until(ExpectedConditions.alertIsPresent());

            Alert confirmAlert = driver.switchTo().alert();

            System.out.println("Confirm box text: " + confirmAlert.getText());

            confirmAlert.dismiss();
 
            // 3) Prompt pop-up

            WebElement promptBtn = wait.until(ExpectedConditions.elementToBeClickable(

                    By.xpath("//button[text()='Prompt']")));

            promptBtn.click();
 
            wait.until(ExpectedConditions.alertIsPresent());

            Alert promptAlert = driver.switchTo().alert();

            System.out.println("Prompt text: " + promptAlert.getText());

            promptAlert.sendKeys("Rakesh");

            promptAlert.accept();
 
        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            if (driver != null) {

                driver.quit();
            }
        }
    }
}
 