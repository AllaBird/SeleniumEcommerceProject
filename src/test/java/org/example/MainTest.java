package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set the path to the ChromeDriver executable
      //  System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize the ChromeDriver
        driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testMain() {
        // Navigate to a webpage
        driver.get("https://www.example.com");

        // Add your test logic here
        System.out.println("Page title is: " + driver.getTitle());

        // Assert something if necessary (using TestNG assertions)
        // Assert.assertEquals(driver.getTitle(), "Expected Title");
    }
}
