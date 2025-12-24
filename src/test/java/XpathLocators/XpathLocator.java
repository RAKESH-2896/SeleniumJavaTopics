//XPath locators use XML path expressions to navigate and identify elements in the HTML structure, allowing for flexible and powerful element selection, especially when other locators are insufficient.

package XpathLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class XpathLocator {

    public static void main(String[] args) {

        // Setup ChromeDriver (uses WebDriverManager to avoid manual driver binary management)
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize window and add a short implicit wait
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Open the target page
            driver.get("https://testautomationpractice.blogspot.com/");

            try {
                // 1. XPath using attribute
                WebElement nameField = driver.findElement(By.xpath("//*[@id='name']"));
                nameField.sendKeys("Rakesh");

                // 2. XPath using contains()
                WebElement emailField = driver.findElement(By.xpath("//*[contains(@id,'email')]"));
                emailField.sendKeys("rakesh@example.com");

                // 3. XPath using starts-with()
                WebElement phoneField = driver.findElement(By.xpath("//*[starts-with(@id,'phone')]"));
                phoneField.sendKeys("9876543210");

                // 4. XPath using text()
                WebElement countryLabel = driver.findElement(By.xpath("//*[text()='Country']"));
                System.out.println("Label text: " + countryLabel.getText());

                // 5. XPath using logical operators (check before clicking)
                WebElement maleRadio = driver.findElement(By.xpath("//*[@name='gender' and @value='male']"));
                if (!maleRadio.isSelected()) {
                    maleRadio.click();
                }

                // 6. XPath using index (selecting the second checkbox) — safer via findElements
                List<WebElement> checkboxes = driver.findElements(By.xpath("//*[@type='checkbox']"));
                if (checkboxes.size() >= 2) {
                    checkboxes.get(1).click();
                }

                // 7. Use Select for dropdowns instead of clicking an <option> element directly
                WebElement countrySelectElement = driver.findElement(By.id("country"));
                Select countrySelect = new Select(countrySelectElement);
                countrySelect.selectByVisibleText("India");

                // 8. XPath using following-sibling
                WebElement labelFollowingName = driver.findElement(By.xpath("//*[@id='name']/following-sibling::label"));
                System.out.println("Following label: " + labelFollowingName.getText());

            } catch (NoSuchElementException e) {
                System.err.println("One or more elements were not found: " + e.getMessage());
            }

        } finally {
            // Close the browser in a finally block to ensure cleanup
            driver.quit();
        }
    }
}