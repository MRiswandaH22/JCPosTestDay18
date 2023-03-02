package com.juaracoding.page;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrderPage {

    private WebDriver driver;

    public OrderPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "ToolsQA Demo Site")
    WebElement btnLinkToHome;

    @FindBy(xpath = "//*[@id='noo-site']/div[2]/div[3]/div/div[2]/div/div/div/div[1]/h3/span")
    WebElement txtJudulMenu;

    @FindBy(xpath = "//*[@id='product-1497']/div[1]/div[2]/h1")
    WebElement txtNamaBaju;

    @FindBy(xpath = "//*[@id='noo-site']/div[2]/div[3]/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div/h3")
    WebElement btnPilihBaju;

    @FindBy(xpath = "//select[@id='pa_color']")
    WebElement addColor;

    @FindBy(xpath = "//select[@id='pa_size']")
    WebElement addSize;

    @FindBy(xpath = "//*[@id='product-1497']/div[1]/div[2]/form/div/div[2]/button")
    WebElement btnFixOrder;

    @FindBy(className = "woocommerce-message")
    WebElement txtPesanBerhasilMasukKeranjang;

    @FindBy(className = "cart-button")
    WebElement btnCart;

    @FindBy(className = "page-title")
    WebElement txtCart;


    public String getTxtChart(){
        return txtCart.getText();
    }

    public void clickBtnCart(){
        btnCart.click();
    }

    public void addDataBaju(){
        addColor.sendKeys("pink");
        addSize.sendKeys("37");
    }

    public String pesanMasukKeranjang(){
        return txtPesanBerhasilMasukKeranjang.getText();
    }

    public void clickFixOrder(){
        btnFixOrder.click();
    }
//    public String getTxtSizeBaju(){
//        return txtSize.getText();
//    }

//    public String getSizeBaju(){
//        Select select2 = new Select(txtSize);
//        select2.selectByIndex(2);
//        return txtSize.getText();
//    }

//    public String getTxtColorBaju(){
//        return txtColor.getText();
//    }

//    public String getColorBaju(){
//        Select select = new Select(txtColor);
//        select.selectByIndex(1);
//        return txtColor.getText();
//    }

    public void clickBaju(){
        btnPilihBaju.click();
    }

    public String getNamaBaju(){
        return txtNamaBaju.getText();
    }

    public String getJudul(){
        return txtJudulMenu.getText();
    }


    public void clickToHome(){
        btnLinkToHome.click();
    }
}
