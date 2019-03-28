package ru.beru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends TestConfig {

    @Test
    public void loginTest() {
        WebElement loginButton = driver.findElement(By.className("header2-nav-item__text"));
        highlighter.highlightElement(loginButton, driver);
        loginButton.click();

        WebElement loginWait = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"passp-field-login\"]")));
        highlighter.highlightElement(loginWait, driver);
        loginWait.sendKeys("st-spring2019");

        WebElement login = driver.findElement(By.cssSelector("button.button2:nth-child(1)"));
        highlighter.highlightElement(login, driver);
        login.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement passwordField = driver.findElement(By.cssSelector("#passp-field-passwd"));
        highlighter.highlightElement(passwordField, driver);
        passwordField.sendKeys("st2019");

        WebElement submit = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/div[2]/div/div[1]/form/div[2]/button"));
        highlighter.highlightElement(submit, driver);
        submit.click();

        WebElement myProfile = driver.findElement(By.cssSelector("span.header2-nav-item > span:nth-child(1) > span:nth-child(2)"));
        myProfile.isDisplayed();
        highlighter.highlightElement(myProfile, driver);
        myProfile.click();
    }
}
