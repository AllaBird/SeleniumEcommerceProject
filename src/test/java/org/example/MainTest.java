package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class MainTest {
    WebDriver driver;

    @BeforeMethod
    public void newDriver() {
        ChromeOptions options = new ChromeOptions();
        String chromeOpts = System.getenv("CHROME_OPTIONS");
        if (chromeOpts != null) {
            options.addArguments(chromeOpts.split(";"));
        }
        driver = new ChromeDriver(options); // Передаем options в ChromeDriver
        driver.get("https://askomdch.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }


    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }


    @Test
    public void testGoogleSearch() {
        driver.get("https://www.google.com");

        boolean isSearchBoxPresent = driver.findElement(By.name("q")).isDisplayed();

        Assert.assertTrue(isSearchBoxPresent);

    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
