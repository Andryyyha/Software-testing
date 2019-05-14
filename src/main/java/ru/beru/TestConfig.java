package ru.beru;

import org.aspectj.lang.annotation.Aspect;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestConfig {
    public static EventFiringWebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    protected void setUp() {
        StepListener sl = new StepListener();
        FirefoxDriver ffDriver = new FirefoxDriver();
        driver = new EventFiringWebDriver(ffDriver);
        driver.register(sl);
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
