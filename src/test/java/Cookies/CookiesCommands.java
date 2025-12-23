//Cookies: Manage browser cookies for sessions and preferences.

package Cookies;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Cookie;

 
public class CookiesCommands {
 
    public static void main(String[] args) {
    	
        // Launches a new Chrome browser session and assigns it to the driver object
        WebDriver driver = new ChromeDriver();

        // Maximizes the browser window
        driver.manage().window().maximize();
        
        // Minimizes the browser window
        driver.manage().window().minimize(); 	 
        
        //Sets the browser to full-screen mode
        driver.manage().window().fullscreen();
        
        
        // Deletes all cookies
        driver.manage().deleteAllCookies();

        // Opens the specified URL in the browser
        driver.get("https://testautomationpractice.blogspot.com/");

        // Adds a new cookie to the current domain
        Cookie cookie = new Cookie("testCookie", "cookieValue");
        driver.manage().addCookie(cookie);
        System.out.println("Added cookie: " + cookie);

        // Gets all cookies
        System.out.println("All cookies:");
        for (Cookie c : driver.manage().getCookies()) {
            System.out.println(c);
        }

        // Gets a specific cookie by name
        Cookie retrievedCookie = driver.manage().getCookieNamed("testCookie");
        System.out.println("Retrieved cookie by name: " + retrievedCookie);

        // Deletes a specific cookie by name
        driver.manage().deleteCookieNamed("testCookie");
        System.out.println("Deleted cookie named 'testCookie'");

        // Verifies deletion
        Cookie deletedCookie = driver.manage().getCookieNamed("testCookie");
        System.out.println("Cookie after deletion (should be null): " + deletedCookie);

        // Closes all browser windows and ends the WebDriver session
        driver.quit();
    }
}