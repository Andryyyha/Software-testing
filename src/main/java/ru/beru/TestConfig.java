package ru.beru;

import org.aspectj.lang.annotation.Aspect;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestConfig {
    public WebDriver driver;

    @BeforeMethod
    protected void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://beru.ru/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    protected void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "ChangeCityTest")
    public static Object[] citiesNames() {
        return new Object[] {"Хвалынск"};
    }
}
