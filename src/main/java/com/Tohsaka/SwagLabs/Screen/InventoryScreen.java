package com.Tohsaka.SwagLabs.Screen;

import java.util.HashMap;
import java.util.Map;

import com.Tohsaka.SwagLabs.components.HeaderComponent;
import com.Tohsaka.SwagLabs.utils.DragPositionUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class InventoryScreen {
    private AndroidDriver driver;
    private By header = AppiumBy.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]");
    private By productCards = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Item\"]");
    private By scrollView = AppiumBy.xpath("//android.widget.ScrollView[@content-desc=\"test-PRODUCTS\"]");
    private By buttonDrag = AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"test-Drag Handle\"])[1]");
    private HeaderComponent headerComponent;

    public InventoryScreen(AndroidDriver driver, HeaderComponent headerComponent) {
        this.driver = driver;
        this.headerComponent = headerComponent;
    }

    public InventoryScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(header).getText();
    }

    public int getTotalProduct(){
        return driver.findElements(productCards).size();
    }

    public String getTotalCart(){
        return driver.findElement(headerComponent.getTotalByOne()).getText();
    }

    public void scrollDown(double percent){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("elementId", driver.findElement(scrollView));
        params.put("direction", "down");
        params.put("percent", percent);
        params.put("speed", 1000);
        js.executeScript("mobile: scrollGesture", params);
    }

    public void drag(DragPositionUtil dragPositionUtil){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Map<String, Object> params = new HashMap<String,Object>();

        int x = driver.findElement(scrollView).getLocation().getX() + dragPositionUtil.getCostumX();
        int y = driver.findElement(scrollView).getLocation().getY() - dragPositionUtil.getCostumY();

        params.put("elementId", driver.findElement(buttonDrag));
        params.put("endX", x);
        params.put("endY", y);
        params.put("speed", 5000 );

        js.executeScript("mobile: dragGesture", params);
    }

    public void scrollUp(double percent) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Map<String, Object> params = new HashMap<>();

        WebElement scrollableElement = driver.findElement(scrollView);
        params.put("elementId", ((RemoteWebElement) scrollableElement).getId());
        params.put("direction", "up");
        params.put("percent", percent);
        params.put("speed", 1000);

        js.executeScript("mobile: scrollGesture", params);
    }

    public void openProduct() {
        WebElement firstProduct = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"test-Item title\" and @text=\"Sauce Labs Backpack\"]"));
        firstProduct.click();
    }
}
