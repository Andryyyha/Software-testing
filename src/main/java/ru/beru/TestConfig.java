package ru.beru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import ru.beru.HighlightElement;

import java.util.concurrent.TimeUnit;

public class TestConfig {
    protected WebDriver driver;
    protected HighlightElement highlighter;

    @BeforeTest
    protected void setUp() {
        driver = new FirefoxDriver();
        highlighter = new HighlightElement();
        driver.get("https://beru.ru/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // TODO: highlight x button
        WebElement closeAds = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("._3BBUsZVSt0")));
        closeAds.click();

    }

/*    @AfterTest
    protected void tearDown() {
        driver.quit();
    }*/
}
