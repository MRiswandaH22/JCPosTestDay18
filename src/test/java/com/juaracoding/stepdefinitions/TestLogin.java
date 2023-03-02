package com.juaracoding.stepdefinitions;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.page.LoginPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLogin {

    public static WebDriver driver;

    public LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage();

    }

    @Test(priority = 1)
    public void testUrl(){
        driver.get("https://shop.demoqa.com/my-account/");
        System.out.println("Get URL Login Shop DemoQA");

        Assert.assertEquals(loginPage.getLoginTitle(),"LOGIN");
        System.out.println("Judul Halaman : "+loginPage.getLoginTitle());
    }

    @Test(priority = 2)
    public void testLogin(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window,scroll(0,450)");
        delay(3);

        // Step Action
        loginPage.login("riswanda22", "Ciwan220399");

        //step verify
        Assert.assertEquals(loginPage.getAkunName(),"riswanda22");
        System.out.println(loginPage.getAkunName()+" Berhasil Login");
    }


    @AfterClass
    public void quitBrowser(){
        delay(3);


    }

    static void delay (int detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
