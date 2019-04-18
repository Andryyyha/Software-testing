package ru.beru;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjectMainPage {
    private WebElement loginButton;
    private WebElement myProfile;
    private WebDriver driver;

    public PageObjectMainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click login button")
    public void clickForLogin() {
        loginButton = driver.findElement(By.xpath("//span[contains(text(), 'Войти в аккаунт')]"));
        loginButton.click();
    }

    @Step("Checking that 'login' button changed to 'my profile'")
    public void isMyProfileDisplayed() {
        myProfile = driver.findElement(By.cssSelector("span.header2-nav-item > span:nth-child(1) > span:nth-child(2)"));
        myProfile.isDisplayed();
    }
}
