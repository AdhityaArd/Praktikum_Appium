package com.Tohsaka.SwagLabs.Screen;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginScreen {
    private AndroidDriver driver;
    private By username = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]");
    private By password = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]");
    private By button = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]");

    public LoginScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String username) {
        driver.findElement(this.username).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
    }

    public void click(){
        driver.findElement(button).click();
    }

    public void login(String username, String password) {
        setUsername(username);
        setPassword(password);
        click();
    }

    public void login(){
        login("standard_user","secret_sauce");
    }
}
