package com.Tohsaka.SwagLabs.Screen;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
public class ProductScreen {
    private AppiumDriver driver;
    private By productImage = AppiumBy.xpath("//android.view.ViewGroup[@content-desc='test-Image Container']//android.widget.ImageView");


    public ProductScreen(AppiumDriver driver) {
        this.driver = driver;
    }

    public void zoomInOnProductImage() {
        // Tunggu sampai gambar muncul
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement image = wait.until(ExpectedConditions.visibilityOfElementLocated(productImage));

        // Hitung titik tengah gambar
        int centerX = image.getRect().getX() + (image.getRect().getWidth() / 2);
        int centerY = image.getRect().getY() + (image.getRect().getHeight() / 2);

        // Posisi awal (dua jari rapat di tengah gambar)
        int finger1StartX = centerX - 50;
        int finger1StartY = centerY;
        int finger2StartX = centerX + 50;
        int finger2StartY = centerY;

        // Posisi akhir (dua jari menjauh untuk zoom in)
        int finger1EndX = centerX - 250;
        int finger1EndY = centerY;
        int finger2EndX = centerX + 250;
        int finger2EndY = centerY;

        // Buat dua pointer untuk dua jari
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

        // Sequence gerakan jari pertama
        Sequence finger1Actions = new Sequence(finger1, 1);
        finger1Actions.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), finger1StartX, finger1StartY));
        finger1Actions.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        finger1Actions.addAction(finger1.createPointerMove(Duration.ofMillis(800), PointerInput.Origin.viewport(), finger1EndX, finger1EndY));
        finger1Actions.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Sequence gerakan jari kedua
        Sequence finger2Actions = new Sequence(finger2, 1);
        finger2Actions.addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), finger2StartX, finger2StartY));
        finger2Actions.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        finger2Actions.addAction(finger2.createPointerMove(Duration.ofMillis(800), PointerInput.Origin.viewport(), finger2EndX, finger2EndY));
        finger2Actions.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Jalankan kedua jari bersamaan
        driver.perform(Arrays.asList(finger1Actions, finger2Actions));


    }
}
