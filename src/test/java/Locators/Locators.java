//Locators: are methods used in Selenium to find and interact with elements on a web page, such as by ID, name, class, tag, link text, or CSS selector.

package Locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

    public static void main(String[] args) {

        // Launches a new Chrome browser session and assigns it to the driver object
        WebDriver driver = new ChromeDriver();

        // Maximizes the browser window
        driver.manage().window().maximize();

        // Opens the specified URL in the browser
        driver.get("https://testautomationpractice.blogspot.com/");

        // Locate By ID
        driver.findElement(By.id("name")).sendKeys("Rakesh");

        // Locate By Name
        boolean isStartDisplayed = driver.findElement(By.name("start")).isDisplayed();
        System.out.println("Start button displayed: " + isStartDisplayed);

        // Locate By 
        driver.findElement(By.linkText("Udemy Courses")).click();
        driver.navigate().back();

        // Locate By PartialLinkText
        driver.findElement(By.partialLinkText("On1")).click();
        driver.navigate().back();

        // Using TagName locator to count links
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("Total links on page: " + allLinks.size());

        // Locate By CssSelector
        driver.findElement(By.cssSelector(".start")).click();

        // Close the browser
        driver.quit();
    }
}