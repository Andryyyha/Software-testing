package ru.beru;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectCart {
    private WebDriver driver;
    private WebElement freeDelivery;

    public PageObjectCart(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Check that delivery is free. If not increase count of brushes")
    public void checkDelivery() {
        freeDelivery = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("._3yDgi6ylNe>span")));
        while (!freeDelivery.getAttribute("textContent")
                .equals("Поздравляем! Вы получили бесплатную доставку на ваш заказ")) {
            driver.findElement(By.xpath("//span[contains(text(), '+')]")).click();
            break;
        }
    }
}
