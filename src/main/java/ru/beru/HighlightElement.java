package ru.beru;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.cropper.indent.BlurFilter;
import ru.yandex.qatools.ashot.cropper.indent.IndentCropper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HighlightElement {

    public HighlightElement() {
    }

    public void highlightElement(WebElement element, WebDriver driver) {
        AShot screenshooter = new AShot();
        screenshooter.imageCropper(new IndentCropper().addIndentFilter(new BlurFilter()))
                .takeScreenshot(driver, element);

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String name = "/Users/andryyyha/IdeaProjects/testing/src/test/screenshots/" + dateFormat.format(date) + ".png";
        try {
            Screenshot sc = new AShot().imageCropper(new IndentCropper(1000).addIndentFilter(new BlurFilter()))
                    .takeScreenshot(driver, element);
            BufferedImage bf = sc.getImage();
            ImageIO.write(bf, "PNG", new File(name));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
