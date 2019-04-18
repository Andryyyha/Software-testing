package ru.beru;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectLogin extends TestConfig {
    private WebElement loginField;
    private WebElement loginButton;
    private WebElement passwordField;
    private WebElement submit;
    private WebDriver driver;

    public PageObjectLogin(WebDriver driver) {
     this.driver = driver;
    }

    @Step("Send keys to login field")
    public void sendLogin() {
        loginField = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"passp-field-login\"]")));
        loginField.sendKeys("st-spring2019");
    }

    @Step("Submit login")
    public void submitLogin() {
        loginButton = driver.findElement(By.cssSelector("button.button2:nth-child(1)"));
        loginButton.click();
    }

    @Step("Send password")
    public void sendPassword() {
        passwordField = driver.findElement(By.cssSelector("#passp-field-passwd"));
        passwordField.sendKeys("st20191");
    }

    @Step("Submit password")
    public void submitPassword() {
        submit = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/div[2]/div/div[1]/form/div[2]/button"));
        submit.click();
    }
}
