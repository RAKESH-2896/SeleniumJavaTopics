package MouseandKeyboard;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;

public class MouseAndKeyboardActions {

    public static void main(String[] args) {

        // Launches a new Chrome browser session and assigns it to the driver object
        WebDriver driver = new ChromeDriver();

        // Maximizes the browser window
        driver.manage().window().maximize();

        // Opens the specified URL in the browser
        driver.get("https://testautomationpractice.blogspot.com/");

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Create Actions object
        Actions actions = new Actions(driver);

        // 1. Mouse Hover
        WebElement hoverElement = driver.findElement(By.xpath("//button[text()='Hover Over Me']"));
        actions.moveToElement(hoverElement).perform();

        // 2. Right Click
        WebElement rightClickButton = driver.findElement(By.xpath("//button[text()='Right Click Me']"));
        actions.contextClick(rightClickButton).perform();

        // 3. Double Click
        WebElement doubleClickButton = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
        actions.doubleClick(doubleClickButton).perform();

        // 4. Click and Hold
        WebElement dragBox = driver.findElement(By.id("draggable"));
        actions.clickAndHold(dragBox).pause(Duration.ofSeconds(2)).release().perform();


        // 5. Drag and Drop
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(source, target).perform();

    
        // 6. Keyboard Actions - Typing with SHIFT (uppercase)
        WebElement nameField = driver.findElement(By.id("name"));
        actions.moveToElement(nameField)
               .click()
               .keyDown(Keys.SHIFT)
               .sendKeys("rakesh")
               .keyUp(Keys.SHIFT)
               .sendKeys(Keys.TAB) // Move to next field
               .sendKeys("rakesh@example.com")
               .sendKeys(Keys.ENTER)
               .perform();

        // Close the browser
        driver.quit();
    }
}