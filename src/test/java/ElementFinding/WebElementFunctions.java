//WebElementFunctions

package ElementFinding;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementFunctions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 	WebElementFunctions
 */
		// Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Maximize window
        driver.manage().window().maximize();

        // Navigate to the test page
        driver.get("https://testautomationpractice.blogspot.com/");

        // Locate the name input field
        WebElement nameField = driver.findElement(By.id("name"));

        // Clear the field
        nameField.clear();

        // Type text
        nameField.sendKeys("Rakesh");

        // Get entered value
        String enteredValue = nameField.getAttribute("value");
        System.out.println("Entered value: " + enteredValue);

        // Get tag name
        String tagName = nameField.getTagName();
        System.out.println("Tag name: " + tagName);

        // Get CSS value
        String cssColor = nameField.getCssValue("color");
        System.out.println("CSS color: " + cssColor);

        // Get location and size
        Rectangle rect = nameField.getRect();
        System.out.println("Location: (" + rect.getX() + ", " + rect.getY() + ")");
        System.out.println("Size: Width = " + rect.getWidth() + ", Height = " + rect.getHeight());

        // Locate and click the submit button
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click(); // or submitButton.submit();

        // Locate a button with visible text and get its text
        WebElement clickButton = driver.findElement(By.xpath("//button[text()='Click Me']"));
        String buttonText = clickButton.getText();
        System.out.println("Button text: " + buttonText);

        // Click the button
        clickButton.click();
        
        // Close browser
        driver.quit();
    }
}