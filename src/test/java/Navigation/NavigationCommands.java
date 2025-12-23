// Navigation: Move between pages, refresh, and go back/forward.

package Navigation;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationCommands {

    public static void main(String[] args) {
        // Ensure the ChromeDriver binary is available (requires io.github.bonigarcia:webdrivermanager dependency)
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        try {
            // Maximizes the browser window
            driver.manage().window().maximize();

            // For back/forward to have effect we navigate to a first page, then to the target page
            String firstPage = "https://example.com";
            String url = "https://testautomationpractice.blogspot.com/";

            // Navigate to first page (creates history)
            driver.navigate().to(firstPage);
            Thread.sleep(1000);

            // Navigate to target page
            driver.navigate().to(url);
            Thread.sleep(2000);

            // Navigate back to the previous page
            driver.navigate().back();
            Thread.sleep(1000);

            // Navigate forward to the next page
            driver.navigate().forward();
            Thread.sleep(1000);

            // Refresh the current page
            driver.navigate().refresh();

            // Get the current size of the browser window
            Dimension size = driver.manage().window().getSize();
            System.out.println("The current size of the browser window: " + size);

            // Set the browser window to the specified size
            driver.manage().window().setSize(new Dimension(1024, 768));

            // Get the current position of the browser window
            Point position = driver.manage().window().getPosition();
            System.out.println("Current window position: X = " + position.getX() + ", Y = " + position.getY());

            // Move the browser window to a specific screen position
            driver.manage().window().setPosition(new Point(200, 100));
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Restore interrupted status and print error
            Thread.currentThread().interrupt();
            System.err.println("Thread was interrupted: " + e.getMessage());
        } finally {
            // Closes all browser windows and ends the WebDriver session
            if (driver != null) {
                driver.quit();
            }
        }
    }
}