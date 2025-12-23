package MouseandKeyboard;

// Mouse/keyboard actions: Simulate user interactions like clicks and key presses.

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseAndKeyboardActions {

    public static void main(String[] args) {

        // Setup ChromeDriver (requires io.github.bonigarcia:webdrivermanager dependency)
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize the browser window
            driver.manage().window().maximize();

            // Open the specified URL in the browser
            driver.get("https://testautomationpractice.blogspot.com/");

            // Implicit wait
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Create Actions object
            Actions actions = new Actions(driver);

            // 1. Mouse Hover
            try {
                WebElement hoverElement = driver.findElement(By.xpath("//button[text()='Hover Over Me']"));
                actions.moveToElement(hoverElement).perform();
            } catch (NoSuchElementException e) {
                System.out.println("Hover element not found: " + e.getMessage());
            }

            // 2. Right Click
            try {
                WebElement rightClickButton = driver.findElement(By.xpath("//button[text()='Right Click Me']"));
                actions.contextClick(rightClickButton).perform();
            } catch (NoSuchElementException e) {
                System.out.println("Right-click element not found: " + e.getMessage());
            }

            // 3. Double Click (this may trigger an alert)
            try {
                WebElement doubleClickButton = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
                actions.doubleClick(doubleClickButton).perform();

                // handle possible alert
                try {
                    // small wait to allow alert to appear
                    Thread.sleep(500);
                    Alert alert = driver.switchTo().alert();
                    System.out.println("Alert text: " + alert.getText());
                    alert.accept();
                } catch (NoAlertPresentException | InterruptedException ignored) {
                    // no alert appeared or interrupted
                }
            } catch (NoSuchElementException e) {
                System.out.println("Double-click element not found: " + e.getMessage());
            }

            // 4. Click and Hold
            try {
                // The draggable/droppable widgets on that page are usually inside an iframe.
                // We'll attempt to find the draggable element; if it's not in the default content,
                // try to locate it inside any iframe on the page.
                WebElement dragBox = findElementPossiblyInIframes(driver, By.id("draggable"));
                if (dragBox != null) {
                    actions.clickAndHold(dragBox).pause(Duration.ofSeconds(2)).release().perform();
                } else {
                    System.out.println("Draggable element not found.");
                }
            } catch (Exception e) {
                System.out.println("Click-and-hold failed: " + e.getMessage());
            }

            // 5. Drag and Drop
            try {
                WebElement source = findElementPossiblyInIframes(driver, By.id("draggable"));
                WebElement target = findElementPossiblyInIframes(driver, By.id("droppable"));
                if (source != null && target != null) {
                    // ensure driver is focused on the same frame that contains the elements
                    actions.dragAndDrop(source, target).perform();
                } else {
                    System.out.println("Source or target for drag-and-drop not found.");
                }
            } catch (Exception e) {
                System.out.println("Drag and drop failed: " + e.getMessage());
            } finally {
                // always switch back to default content after working with frames
                driver.switchTo().defaultContent();
            }

            // 6. Keyboard Actions - Typing with SHIFT (uppercase)
            try {
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
            } catch (NoSuchElementException e) {
                System.out.println("Name/email field not found: " + e.getMessage());
            }

        } finally {
            // Close the browser in all cases
            driver.quit();
        }
    }

    /**
     * Try to find an element in the default content first; if not found, iterate through
     * all iframes and try to locate the element inside each one. If found, the driver's
     * context will be left inside the iframe that contains the element.
     *
     * @param driver the WebDriver
     * @param by     locator for the element
     * @return the WebElement if found, otherwise null
     */
    private static WebElement findElementPossiblyInIframes(WebDriver driver, By by) {
        // try default content first
        try {
            return driver.findElement(by);
        } catch (NoSuchElementException ignored) {
        }

        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        for (WebElement frame : iframes) {
            try {
                driver.switchTo().frame(frame);
                WebElement el = driver.findElement(by);
                // found — leave the driver inside this frame
                return el;
            } catch (NoSuchElementException e) {
                // not in this frame — move back to default and try next
                driver.switchTo().defaultContent();
            }
        }

        // ensure we end in default content
        driver.switchTo().defaultContent();
        return null;
    }
}