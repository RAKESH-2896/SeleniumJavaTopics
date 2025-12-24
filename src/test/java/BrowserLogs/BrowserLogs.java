//Browser logs: Retrieve logs for debugging browser activity.

package BrowserLogs;
 
import java.util.Date;
import java.util.logging.Level;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class BrowserLogs {
 
    public static void main(String[] args) {

        // Ensure ChromeDriver binary is available (uses WebDriverManager)

        WebDriverManager.chromedriver().setup();
 
        // Enable browser logging

        LoggingPreferences logPrefs = new LoggingPreferences();

        logPrefs.enable(LogType.BROWSER, Level.ALL);
 
        ChromeOptions options = new ChromeOptions();

        options.setCapability("goog:loggingPrefs", logPrefs);

        // If you want to accept insecure certs, uncomment the next line:

        // options.setAcceptInsecureCerts(true);
 
        WebDriver driver = new ChromeDriver(options);
 
        try {

            // Maximize window and open URL

            driver.manage().window().maximize();

            driver.get("https://testautomationpractice.blogspot.com/");
 
            // Small pause to allow console logs to appear (adjust if necessary)

            Thread.sleep(2000);
 
            // Retrieve and print browser logs

            LogEntries logs = driver.manage().logs().get(LogType.BROWSER);

            for (LogEntry entry : logs) {

                System.out.printf("%s %s %s%n", new Date(entry.getTimestamp()), entry.getLevel(), entry.getMessage());

            }

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            System.err.println("Interrupted: " + e.getMessage());

        } finally {

            // Close browser and cleanup

            driver.quit();
        }
    }
}
 