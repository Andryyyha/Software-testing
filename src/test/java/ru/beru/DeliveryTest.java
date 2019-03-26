package ru.beru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DeliveryTest extends TestConfig {

    @Test
    public void deliveryTest() {
        driver.manage().window().maximize();

        driver.get("https://beru.ru/catalog/elektricheskie-zubnye-shchetki/79832/list?hid=278374&track=fr_ctlg");

        WebElement foundCount = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("._160zXyZIMr")));
        Assert.assertEquals(foundCount.getAttribute("textContent"), "91");

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

        WebElement brush = brushes.get(brushes.size() - 2);
        brush.click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".personal-counter")));

        WebElement cart = driver.findElement(By.xpath("//span[contains(text(), 'Корзина')]"));
        cart.click();

        while (driver.findElement(By.xpath("//span[contains(text(), 'бесплатно')]")).isDisplayed()) {
            driver.findElement(By.xpath("//span[contains(text(), '+')]")).click();
        }

    }
}

