package XpathLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathLocator {

    public static void main(String[] args) {

        // Launches a new Chrome browser session and assigns it to the driver object
        WebDriver driver = new ChromeDriver();

        // Maximizes the browser window
        driver.manage().window().maximize();

        // Opens the specified URL in the browser
        driver.get("https://testautomationpractice.blogspot.com/");

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

        // 5. XPath using logical operators
        WebElement maleRadio = driver.findElement(By.xpath("//*[@name='gender' and @value='male']"));
        maleRadio.click();

        // 6. XPath using index (selecting the second checkbox)
        WebElement secondCheckbox = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));
        secondCheckbox.click();

        // 7. XPath using parent-child relationship
        WebElement countryDropdown = driver.findElement(By.xpath("//select[@id='country']/option[text()='India']"));
        countryDropdown.click();

        // 8. XPath using following-sibling
        WebElement labelFollowingName = driver.findElement(By.xpath("//*[@id='name']/following-sibling::label"));
        System.out.println("Following label: " + labelFollowingName.getText());

        // Close the browser
        driver.quit();
    }
}