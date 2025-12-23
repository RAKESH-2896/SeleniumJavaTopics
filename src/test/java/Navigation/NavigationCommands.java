// Navigation: Move between pages, refresh, and go back/forward.

package Navigation;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationCommands {
	
	 public static void main(String[] args) {
	
		  // Launches a new Chrome browser session and assigns it to the driver object
	        WebDriver driver = new ChromeDriver();

	        // Maximizes the browser window
	        driver.manage().window().maximize();

	        // URL to navigate to
	        String url = "https://testautomationpractice.blogspot.com/";

	        // Navigates to the specified URL
	        driver.navigate().to(url);

	        // Navigates back to the previous page
	        driver.navigate().back();

	        // Navigates forward to the next page
	        driver.navigate().forward();

	        // Refreshes the current page
	        driver.navigate().refresh();

	        // Gets the current size of the browser window
	        Dimension size = driver.manage().window().getSize();
	        System.out.println("The current size of the browser window: " +size);

	        // Sets the browser window to the specified size
	        driver.manage().window().setSize(new Dimension(1024, 768));

	        // Gets the current position of the browser window
	        Point position = driver.manage().window().getPosition();
	        System.out.println("Current window position: X = " + position.getX() + ", Y = " + position.getY());

	        // Moves the browser window to a specific screen position
	        driver.manage().window().setPosition(new Point(200, 100));

	        // Closes all browser windows and ends the WebDriver session
	        driver.quit();
	    }
}
