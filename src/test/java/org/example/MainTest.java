package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class MainTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Устанавливаем драйвер с помощью WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Получаем параметры Chrome из переменной окружения
        ChromeOptions options = new ChromeOptions();
        String chromeOpts = System.getenv("CHROME_OPTS");
        if (chromeOpts != null) {
            options.addArguments(chromeOpts.split(" "));
        }

        // Запускаем Chrome с указанными параметрами
        driver = new ChromeDriver(options);
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