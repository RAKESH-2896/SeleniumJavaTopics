//Locators are methods used in Selenium to find and interact with elements on a web page, such as by ID, name, class, tag, link text, or CSS selector.

package Locators;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {

    public static void main(String[] args) {

        // Setup ChromeDriver (uses WebDriverManager to download/manage driver)
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Ensure driver quits even if an exception occurs
        try {
            // Maximizes the browser window
            driver.manage().window().maximize();

            // Implicit wait can be set if desired; using explicit waits below
            // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            // Opens the specified URL in the browser
            driver.get("https://testautomationpractice.blogspot.com/");

            // Use explicit wait for elements that may take time to appear
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Locate By ID
            WebElement nameInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("name")));
            nameInput.sendKeys("Rakesh");

            // Locate By Name
            WebElement startButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("start")));
            boolean isStartDisplayed = startButton.isDisplayed();
            System.out.println("Start button displayed: " + isStartDisplayed);

            // Locate By LinkText
            // Click the link whose visible text exactly matches "Udemy Courses"
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Udemy Courses"))).click();
            driver.navigate().back();

            // Locate By PartialLinkText
            // Use a substring of the link text (e.g. "Udemy") so the partial match is more reliable
            wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Udemy"))).click();
            driver.navigate().back();

            // Using TagName locator to count links
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("a")));
            List<WebElement> allLinks = driver.findElements(By.tagName("a"));
            System.out.println("Total links on page: " + allLinks.size());

            // Locate By CssSelector (example: element with class 'start')
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".start"))).click();

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}