package Conditional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalCommands {

    public static void main(String[] args) {

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Maximize window
        driver.manage().window().maximize();

        // Navigate to the test page
        driver.get("https://only-testing-blog.blogspot.com/2014/01/textbox.html?");

        // Locate elements
        WebElement textBox = driver.findElement(By.id("text1"));
        WebElement checkBox = driver.findElement(By.id("check1"));
        WebElement radioButton = driver.findElement(By.id("radio1"));

        // Check if textbox is displayed
        System.out.println("Textbox is displayed: " + textBox.isDisplayed());

        // Check if textbox is enabled
        System.out.println("Textbox is enabled: " + textBox.isEnabled());

        // Check if checkbox is selected
        System.out.println("Checkbox is selected: " + checkBox.isSelected());

        // Check if radio button is selected
        System.out.println("Radio button is selected: " + radioButton.isSelected());

        // Optionally, select checkbox and radio button to see change
        checkBox.click();
        radioButton.click();

        // Re-check selection status
        System.out.println("Checkbox is selected after click: " + checkBox.isSelected());
        System.out.println("Radio button is selected after click: " + radioButton.isSelected());

        // Close browser
        driver.quit();
    }
}