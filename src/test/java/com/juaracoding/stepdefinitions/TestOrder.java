package com.juaracoding.stepdefinitions;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.page.LoginPage;
import com.juaracoding.page.OrderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestOrder {

    public static WebDriver driver;

    public LoginPage loginPage;

    public OrderPage orderPage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage();
        orderPage = new OrderPage();

    }

    @Test(priority = 1)
    public void testOrder(){
        driver.get("https://shop.demoqa.com/my-account/");
        loginPage.login("riswanda22","Ciwan220399");

        //step action
        orderPage.clickToHome();
        System.out.println("Masuk ke Menu Utama");
        delay(3);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window,scroll(0,1000)");

        //step verify
        Assert.assertEquals(orderPage.getJudul(), "FOR LADIES");
        System.out.println(orderPage.getJudul()+" dipilih");
    }

    @Test(priority = 2)
    public void testDetailOrder(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window,scroll(0,550)");
        delay(3);

        //step action
        orderPage.clickBaju();
        orderPage.addDataBaju();
        System.out.println("Baju yang dipilih : "+orderPage.getNamaBaju());
//        System.out.println("Warna yang dipilih : "+orderPage.addDataBaju(););
//        System.out.println("Ukuran yang dipilih : "+orderPage.getSizeBaju());

        //step verify
        Assert.assertEquals(orderPage.getNamaBaju(),"PINK DROP SHOULDER OVERSIZED T SHIRT");
//        Assert.assertEquals(orderPage.getColorBaju(),"pink");
//        Assert.assertEquals(orderPage.getSizeBaju(),"37");

        //step action
        orderPage.clickFixOrder();
        System.out.println("Berhasil menambahkan ke keranjang");
        js.executeScript("window,scroll(0,-500)");
        delay(2);

        //setelah berhasil dimasukan ke chart
        //step action
        Assert.assertTrue(orderPage.pesanMasukKeranjang().contains("added to your cart"));

    }

    @Test(priority = 3)
    public void testDetailChart(){

        //stepAction
        orderPage.clickBtnCart();
        System.out.println("Cart Opened");
        System.out.println("Menu sekarang : "+orderPage.getTxtChart());

        //step verify
        Assert.assertEquals(orderPage.getTxtChart(),"CART");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window,scroll(0,600)");
        delay(3);
    }

    @AfterClass
    public void quitBrowser(){
        delay(3);
        driver.quit();


    }

    static void delay (int detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
