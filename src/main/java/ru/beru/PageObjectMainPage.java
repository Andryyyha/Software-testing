package ru.beru;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class PageObjectMainPage {
    private WebElement loginButton;
    private WebElement myProfile;
    private WebElement logoutButton;
    private WebElement cityChooser;
    private WebElement inputBox;
    private WebElement suggester;
    private WebElement acceptButton;
    private WebElement linkInner;
    private WebElement deliveryCityName;
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

    @Step("logout")
    public void logout() {
        myProfile = driver.findElement(By.cssSelector("span.header2-nav-item > span:nth-child(1) > span:nth-child(2)"));
        myProfile.click();
        logoutButton = driver.findElement(By.cssSelector(".header2-user-menu__logout"));
        logoutButton.click();
    }

    @Step("click to city chooser")
    public void clickToCityChooser() {
        cityChooser = driver.findElement(By
                .xpath("/html/body/div[1]/div/div[2]/div[2]/noindex/div/div[1]/div/div/div[1]/span/span[2]/span/span"));
        cityChooser.click();
    }

    @Step("send keys to inputBox")
    public void sendKeysToInputBox() {
        inputBox = driver.findElement(By.xpath("(//form[contains(@class, 'region-select-form')]//input)[1]"));
        inputBox.click();
        inputBox.sendKeys("Хвалынск");
    }

    @Step("click to suggester")
    public void clickToSuggester() {
        suggester = driver.findElement(By.cssSelector(".region-suggest__list>div"));
        Actions actions = new Actions(driver);
        actions.moveToElement(suggester).click().build().perform();
    }

    @Step("Accept")
    public void clickToAcceptButton() {
        acceptButton = driver.findElement(By.cssSelector("button.button2:nth-child(3)"));
        acceptButton.click();
        driver.navigate().refresh();
    }

    @Step("Getting text from cityChooser and comparing with example")
    public void getCityName(String cityName) {
        linkInner = driver.findElement(By.cssSelector(".link__inner"));
        String s = linkInner.getAttribute("textContent");
        Assert.assertEquals(s, cityName);
    }

    @Step("Open my profile settings")
    public void openSettings() {
        driver.get("https://beru.ru/my/settings");
    }

    @Step("Comparing city name in settings with city chooser text")
    public void compareNames(String cityName) {
        deliveryCityName = driver.findElement(By.cssSelector(".n-headline__content>span>span"));
        String s1 = deliveryCityName.getAttribute("textContent");
        Assert.assertEquals(cityName, s1);
    }

    @Step("Go to elcetric toothbrushes")
    public void goToBrushes() {
        driver.get("https://beru.ru/catalog/elektricheskie-zubnye-shchetki/79832/list?hid=278374&track=fr_ctlg");
    }
}
