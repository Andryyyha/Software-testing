package ru.beru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DeliveryTest extends TestConfig {

    @Test
    public void deliveryTest() {

        driver.get("https://beru.ru/catalog/elektricheskie-zubnye-shchetki/79832/list?hid=278374&track=fr_ctlg");

        WebElement foundCount = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("._160zXyZIMr")));
        Assert.assertEquals(foundCount.getAttribute("textContent"), "94");

        WebElement from = driver.findElement(By.cssSelector("#glpricefrom"));
        from.sendKeys("999");

        WebElement to = driver.findElement(By.cssSelector("#glpriceto"));
        to.sendKeys("1999");

        WebElement foundCount1 = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("._1PQIIOelRL")));
        while (!foundCount1.isDisplayed()) {
            driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        }

        List<WebElement> brushes = driver.findElements(By.cssSelector(".l3daMzINHn>button"));
//        List<WebElement> brushes = driver.findElements(By
//                .xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[4]/div/div[1]/div[2]/div/div/div/div/button/span"));
        while (!brushes.get(brushes.size() - 2).getAttribute("textContent").equals("В корзине")) {
            brushes.get(brushes.size() - 2).click();
            break;
        }

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.
                        cssSelector(".header2-nav-item__icon-wrap>span.personal-counter")));

        //  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement cart = driver.findElement(By.xpath("//span[contains(text(), 'Корзина')]"));
        cart.click();
//
//        while (!driver.findElement(By.cssSelector("._3l-uEDOaBN._31QIIqcvMw")).isDisplayed()) {
//            driver.findElement(By.xpath("//span[contains(text(), '+')]")).click();
//
//        }
        WebElement freeDelivery = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("._3yDgi6ylNe>span")));
        while (!freeDelivery.getAttribute("textContent")
                .equals("Поздравляем! Вы получили бесплатную доставку на ваш заказ")) {
            driver.findElement(By.xpath("//span[contains(text(), '+')]")).click();
            break;
        }
    }
}

