package ru.beru;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PageObjectItems {
    private WebDriver driver;
    WebElement foundCount;
    WebElement from;
    WebElement to;
    WebElement cart;
    List<WebElement> brushes;

    public PageObjectItems(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Check that count is not 0")
    public void checkCount() {
        foundCount = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("._160zXyZIMr")));
        Assert.assertNotEquals(foundCount.getAttribute("textContent"), "0");
    }

    @Step("Set 'from' to 999")
    public void setFrom() {
        from = driver.findElement(By.cssSelector("#glpricefrom"));
        from.sendKeys("999");
    }

    @Step("Set 'to' to 1999")
    public void setTo() {
        to = driver.findElement(By.cssSelector("#glpriceto"));
        to.sendKeys("1999");
    }

    @Step("Get brushes by given price")
    public void getBrushes() {
        WebElement foundCount1 = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("._1PQIIOelRL")));
        while (!foundCount1.isDisplayed()) {
            driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        }
        brushes = driver.findElements(By.cssSelector(".l3daMzINHn>button"));
    }

    @Step("Get prenultimate brush and add to cart")
    public void addToCart() {
        while (!brushes.get(brushes.size() - 2).getAttribute("textContent").equals("В корзине")) {
            brushes.get(brushes.size() - 2).click();
            break;
        }
    }

    @Step("Going to cart")
    public void goToCart() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.
                        cssSelector(".header2-nav-item__icon-wrap>span.personal-counter")));

        //  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        cart = driver.findElement(By.xpath("//span[contains(text(), 'Корзина')]"));
        cart.click();
    }
}
