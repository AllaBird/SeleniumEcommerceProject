package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        // Автоматически загружает драйвер
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testGoogleSearch() {
        // Открываем страницу Google
        driver.get("https://www.google.com");

        // Проверяем, что элемент поиска присутствует
        boolean isSearchBoxPresent = driver.findElement(By.name("q")).isDisplayed();
        Assert.assertTrue(isSearchBoxPresent, "Поиск не найден на странице");
    }

    @AfterClass
    public void tearDown() {
        // Закрываем драйвер
        if (driver != null) {
            driver.quit();
        }
    }
}