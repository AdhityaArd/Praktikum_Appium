package com.Tohsaka.SwagLabs;

import com.Tohsaka.SwagLabs.Screen.InventoryScreen;
import com.Tohsaka.SwagLabs.Screen.LoginScreen;
import com.Tohsaka.SwagLabs.Screen.ProductScreen;
import com.Tohsaka.SwagLabs.components.HeaderComponent;
import com.Tohsaka.SwagLabs.utils.DragPositionUtil;
import com.Tohsaka.SwagLabs.utils.DriverUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class InventoryTest {

    private static final Logger log = LoggerFactory.getLogger(InventoryTest.class);

    @Test
    public void TC0007() throws MalformedURLException {
        DriverUtil driverUtil = new DriverUtil();
        LoginScreen loginScreen = new LoginScreen(driverUtil.getDriver());
        InventoryScreen inventoryScreen = new InventoryScreen(driverUtil.getDriver());

        loginScreen.login();


        /**
         * Berdasarkan pengamatan. persentase tidak konstan 100%, nilainya bisa melebihi
         * kapasitas konstan karena pengaruh panjang screen.
         * artinya persent > 100%.
         */


        int actual = inventoryScreen.getTotalProduct();
        inventoryScreen.scrollDown(10);
        actual += inventoryScreen.getTotalProduct();

        // actual +=

        // actual + inventory screen

        int expected = 6;
        System.out.println(actual);
        driverUtil.quitApp();
    }

    public void DragTest() throws MalformedURLException {
        DriverUtil driverUtil = new DriverUtil();
        HeaderComponent headerComponent = new HeaderComponent(driverUtil.getDriver());
        LoginScreen loginScreen = new LoginScreen(driverUtil.getDriver());
        InventoryScreen inventoryScreen = new InventoryScreen(driverUtil.getDriver(), headerComponent);

        loginScreen.login();

        inventoryScreen.drag(new DragPositionUtil(200,100));

        String expected = "1";
        String actual = inventoryScreen.getTotalCart();
        Assert.assertEquals(actual, expected);

        driverUtil.quitApp();
    }

    public void TC0009() throws MalformedURLException{
        DriverUtil driverUtil = new DriverUtil();
        HeaderComponent headerComponent = new HeaderComponent(driverUtil.getDriver());
        LoginScreen loginScreen = new LoginScreen(driverUtil.getDriver());
        InventoryScreen inventoryScreen = new InventoryScreen(driverUtil.getDriver(), headerComponent);


        loginScreen.login();


    }

    @Test()
    public void TC0010() throws MalformedURLException, InterruptedException {
        DriverUtil driverUtil = new DriverUtil();
        LoginScreen loginScreen = new LoginScreen(driverUtil.getDriver());
        InventoryScreen inventoryScreen = new InventoryScreen(driverUtil.getDriver());
        ProductScreen productDetailScreen = new ProductScreen(driverUtil.getDriver());


        // Pre condition (sebelum melakukan test)
        loginScreen.login();

        // masuk ke halaman inventory
        inventoryScreen.getTotalProduct();
        inventoryScreen.scrollDown(3);
        inventoryScreen.scrollUp(3);

        // masuk ke halaman products detail
        inventoryScreen.openProduct();
        inventoryScreen.scrollDown(3);
        inventoryScreen.scrollUp(5);
        Thread.sleep(3);

        // eksekusi buat zoomin
        productDetailScreen.zoomInOnProductImage();

        driverUtil.quitApp();
    }
}
