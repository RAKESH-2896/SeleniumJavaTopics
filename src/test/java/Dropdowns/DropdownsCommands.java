package Dropdowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownsCommands {

    public static void main(String[] args) {
        WebDriver driver = null;

        try {
            // Ensure chromedriver binary is available
            WebDriverManager.chromedriver().setup();

            // Launch Chrome
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            // Navigate to site
            driver.get("https://testautomationpractice.blogspot.com/");

            // Explicit wait for the dropdown element to be present/clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement countryDropdown = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("country"))
            );

            // Create Select object
            Select select = new Select(countryDropdown);

            // 1. Select by visible text
            select.selectByVisibleText("India");

            // 2. Select by value (ensure this value exists in the select options)
            // e.g. if the option value attribute is "usa" this will work
            select.selectByValue("usa");

            // 3. Select by index (index starts from 0). Make sure index is within bounds.
            // Here index 3 selects the 4th option.
            select.selectByIndex(3);

            // Print currently selected option
            WebElement selectedOption = select.getFirstSelectedOption();
            System.out.println("Currently selected: " + selectedOption.getText());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close browser if it was created
            if (driver != null) {
                driver.quit();
            }
        }
    }
}