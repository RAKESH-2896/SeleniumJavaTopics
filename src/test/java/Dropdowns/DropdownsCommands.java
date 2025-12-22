//DropdownsCommands

package Dropdowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownsCommands {

	   public static void main(String[] args) {
	    	
/*
	DropdownsCommands
 */
		   
		     // Launches a new Chrome browser session and assigns it to the driver object
	        WebDriver driver = new ChromeDriver();

	        // Maximizes the browser window
	        driver.manage().window().maximize();

	        // Opens the specified URL in the browser
	        driver.get("https://testautomationpractice.blogspot.com/");

	        // Implicit wait
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 
	        WebElement countryDropdown = driver.findElement(By.id("country"));

	        // Create Select object
	        Select select = new Select(countryDropdown);

	        // 1. Select by visible text
	        select.selectByVisibleText("India");

	        // 2. Select by value
	        select.selectByValue("usa");

	        // 3. Select by index
	        select.selectByIndex(3); // Index starts from 0

	        // Print selected option
	        WebElement selectedOption = select.getFirstSelectedOption();
	        System.out.println("Currently selected: " + selectedOption.getText());

	        // Close the browser
	        driver.quit();
	    }
	}