package ru.beru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class ChangeCityTest extends TestConfig {

    // FIXME: unstable test, fix
    @Parameters("cityName")
    @Test
    public void changeCityTest(String cityName) {
        driver.manage().window().maximize();
        WebElement cityChooser = driver.findElement(By
                .xpath("/html/body/div[1]/div/div[1]/div[2]/noindex/div/div[1]/div/div/div[1]/span/span[2]"));
        highlighter.highlightElement(cityChooser, driver);
        cityChooser.click();

        WebElement inputBox = driver.findElement(By.xpath("(//form[contains(@class, 'region-select-form')]//input)[1]"));
        highlighter.highlightElement(inputBox, driver);
        inputBox.sendKeys(cityName);
        WebElement suggsester = driver.findElement(By.cssSelector(".region-suggest>div"));
        Actions actions = new Actions(driver);
        actions.moveToElement(suggsester).click().perform();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement button = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[1]/div[1]/form/div/button"));
        highlighter.highlightElement(button, driver);
        button.click();

        driver.navigate().refresh();

        WebElement linkInner = driver.findElement(By.cssSelector(".link__inner"));
        highlighter.highlightElement(linkInner, driver);
        String s = linkInner.getText();
        Assert.assertEquals(s, cityName);

        WebElement loginButton = driver.findElement(By.className("header2-nav-item__text"));
        highlighter.highlightElement(loginButton, driver);
        loginButton.click();

        WebElement loginWait = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"passp-field-login\"]")));
        highlighter.highlightElement(loginWait, driver);
        loginWait.sendKeys("st-winter2019");

        WebElement login = driver.findElement(By.cssSelector("button.button2:nth-child(1)"));
        highlighter.highlightElement(login, driver);
        login.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement passwordField = driver.findElement(By.cssSelector("#passp-field-passwd"));
        highlighter.highlightElement(passwordField, driver);
        passwordField.sendKeys("st2019");

        WebElement submit = driver.findElement(By.cssSelector("button.control"));
        highlighter.highlightElement(submit, driver);
        submit.click();

        WebElement loginButton2 = driver.findElement(By.cssSelector("span.header2-nav-item > span:nth-child(1) > span:nth-child(1)"));
        loginButton2.click();

        WebElement settings = driver.findElement(By.cssSelector("li.header2-user-menu__item:nth-child(3) > a:nth-child(1)"));
        highlighter.highlightElement(settings, driver);
        settings.click();

        WebElement deliveryCity = driver.findElement(By.cssSelector("span.link_theme_minor:nth-child(1) > span"));
        String s1 = deliveryCity.getText();
        Assert.assertEquals(s, s1);
    }
}