package com.Tohsaka.SwagLabs;

import com.Tohsaka.SwagLabs.Screen.InventoryScreen;
import com.Tohsaka.SwagLabs.Screen.LoginScreen;
import com.Tohsaka.SwagLabs.utils.DriverUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class LoginTest {
    @Test
    public void LoginTest() throws MalformedURLException {
        DriverUtil driverUtil = new DriverUtil();
        LoginScreen loginScreen = new LoginScreen(driverUtil.getDriver());
        InventoryScreen InventoryScreen = new InventoryScreen(driverUtil.getDriver());

        loginScreen.login("standard_user", "secret_sauce");

        String actual = InventoryScreen.getTitle();
        String expected = "PRODUCTS";
        Assert.assertEquals(actual, expected);

        driverUtil.quitApp();
    }

    
}
