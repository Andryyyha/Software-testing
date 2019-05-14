package ru.beru;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class StepListener extends AbstractWebDriverEventListener {

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        screenshot();
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        screenshot();
    }

    @Attachment(value = "Screenshot", type = "image/jpeg")
    public static byte[] screenshot() {
        return ((TakesScreenshot) TestConfig.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
