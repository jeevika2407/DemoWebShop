package com.test;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    
    private static final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public WebDriver getDriver() {
        return threadLocal.get();
    }

    @BeforeMethod
    public void setUp() {
        WebDriver driver = new ChromeDriver();
        threadLocal.set(driver);

        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void burnDown() {
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.quit();
            threadLocal.remove();
        }
    }
}
