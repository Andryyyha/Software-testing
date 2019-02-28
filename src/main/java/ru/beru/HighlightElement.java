package ru.beru;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.cropper.indent.BlurFilter;
import ru.yandex.qatools.ashot.cropper.indent.IndentCropper;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HighlightElement {

    public HighlightElement() {
    }

    public void highlightElement(WebElement element, WebDriver driver) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].setAttribute('style', arguments[1]);",
                element, "color: red; border: 2px solid red; border-color: red;");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AShot screenshooter = new AShot();
        screenshooter.imageCropper(new IndentCropper().addIndentFilter(new BlurFilter()))
                .takeScreenshot(driver, element);

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String name = "/Users/andryyyha/IdeaProjects/testing/src/test/screenshots/" + dateFormat.format(date) + ".jpg";
        File fileName = new File(name);
        try {
//            Screenshot sc = new AShot().imageCropper(new IndentCropper().addIndentFilter(new BlurFilter()));
            FileUtils.copyFile(file, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*javascriptExecutor.executeScript("arguments[0].setAttribute('style', arguments[1]);",
                element, "");*/
    }
}
