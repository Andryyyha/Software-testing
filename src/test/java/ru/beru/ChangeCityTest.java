package ru.beru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class ChangeCityTest extends TestConfig {

    //@Test(dataProvider = "ChangeCityTest")
    public void changeCityTest(String cityName) {
        WebElement cityChooser = driver.findElement(By
                .xpath("/html/body/div[1]/div/div[2]/div[2]/noindex/div/div[1]/div/div/div[1]/span/span[2]/span/span"));
        cityChooser.click();

        WebElement inputBox = driver.findElement(By.xpath("(//form[contains(@class, 'region-select-form')]//input)[1]"));
        inputBox.click();
        inputBox.sendKeys("Хвалынск");
        WebElement suggsester = driver.findElement(By.cssSelector(".region-suggest__list>div"));
        Actions actions = new Actions(driver);
        actions.moveToElement(suggsester).click().build().perform();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement button = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.elementToBeClickable(By.
                        xpath("/html/body/div[7]/div/div/div[1]/div[1]/form/div/button")));
        button.click();

        driver.navigate().refresh();

        WebElement linkInner = driver.findElement(By.cssSelector(".link__inner"));
        String s = linkInner.getText();
        Assert.assertEquals(s, cityName);

        WebElement loginButton = driver.findElement(By.className("header2-nav-item__text"));
        loginButton.click();

        WebElement loginWait = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"passp-field-login\"]")));
        loginWait.sendKeys("st-spring2019");

        WebElement login = driver.findElement(By.cssSelector("button.button2:nth-child(1)"));
        login.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement passwordField = driver.findElement(By.cssSelector("#passp-field-passwd"));
        passwordField.sendKeys("st20191");

        WebElement submit = driver.findElement(By.cssSelector("button.control"));
        submit.click();

        WebElement loginButton2 = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector("span.header2-nav-item > span:nth-child(1) > span:nth-child(1)")));
               // driver.findElement(By.cssSelector("span.header2-nav-item > span:nth-child(1) > span:nth-child(1)"));
        loginButton2.click();

        WebElement settings = driver.findElement(By.cssSelector("li.header2-user-menu__item:nth-child(3) > a:nth-child(1)"));
        settings.click();

        WebElement deliveryCity = driver.findElement(By.cssSelector("span.link_theme_minor:nth-child(1) > span"));
        String s1 = deliveryCity.getText();
        Assert.assertEquals(s, s1);
    }
}