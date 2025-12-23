package Conditional;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * ConditionalCommands: Locate elements and check if textbox is displayed/enabled,
 * check checkbox and radio button selection, then click them and re-check status.
 *
 * Improvements / fixes:
 * - Use WebDriverManager to ensure ChromeDriver binary is available.
 * - Guard against missing elements using findElements (avoids NoSuchElementException).
 * - Ensure driver.quit() runs in finally so browser always closes.
 * - Basic exception handling and clearer messages.
 */
public class ConditionalCommands {

    public static void main(String[] args) {

        // Setup ChromeDriver (WebDriver binary will be downloaded/managed automatically)
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize window
            driver.manage().window().maximize();

            // Navigate to the test page
            driver.get("https://only-testing-blog.blogspot.com/2014/01/textbox.html?");

            // Locate elements safely (use findElements to avoid exceptions if element not found)
            List<WebElement> textBoxes = driver.findElements(By.id("text1"));
            List<WebElement> checkBoxes = driver.findElements(By.id("check1"));
            List<WebElement> radioButtons = driver.findElements(By.id("radio1"));

            if (!textBoxes.isEmpty()) {
                WebElement textBox = textBoxes.get(0);
                System.out.println("Textbox is displayed: " + textBox.isDisplayed());
                System.out.println("Textbox is enabled: " + textBox.isEnabled());
            } else {
                System.out.println("Textbox with id 'text1' was not found on the page.");
            }

            if (!checkBoxes.isEmpty()) {
                WebElement checkBox = checkBoxes.get(0);
                System.out.println("Checkbox is selected: " + checkBox.isSelected());

                // Click to change selection state
                checkBox.click();
                System.out.println("Checkbox is selected after click: " + checkBox.isSelected());
            } else {
                System.out.println("Checkbox with id 'check1' was not found on the page.");
            }

            if (!radioButtons.isEmpty()) {
                WebElement radioButton = radioButtons.get(0);
                System.out.println("Radio button is selected: " + radioButton.isSelected());

                // Click to select radio button
                radioButton.click();
                System.out.println("Radio button is selected after click: " + radioButton.isSelected());
            } else {
                System.out.println("Radio button with id 'radio1' was not found on the page.");
            }

        } catch (Exception e) {
            System.err.println("An error occurred while running the test:");
            e.printStackTrace();
        } finally {
            // Close browser in finally to ensure cleanup
            if (driver != null) {
                driver.quit();
            }
        }
    }
}