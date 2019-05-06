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

        PageObjectItems pageObjectItems = new PageObjectItems(driver);
        PageObjectCart pageObjectCart = new PageObjectCart(driver);
        PageObjectMainPage pageObjectMainPage = new PageObjectMainPage(driver);

        pageObjectMainPage.goToBrushes();

        pageObjectItems.checkCount();

        pageObjectItems.setFrom();

        pageObjectItems.setTo();

        pageObjectItems.getBrushes();

        pageObjectItems.addToCart();

        pageObjectItems.goToCart();

        pageObjectCart.checkDelivery();
    }
}

