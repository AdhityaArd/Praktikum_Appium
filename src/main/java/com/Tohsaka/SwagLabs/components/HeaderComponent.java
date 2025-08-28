package com.Tohsaka.SwagLabs.components;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class HeaderComponent {
    private By totalByOne = AppiumBy.xpath("//android.widget.TextView[@text=\"1\"]");
    private AndroidDriver driver;

    public HeaderComponent(AndroidDriver driver) {
        this.driver = driver;
    }

    public By getTotalByOne() {
        return totalByOne;
    }
}
