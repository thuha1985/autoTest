package com.qaauto.wintelapp.page;

import com.qaauto.wintelapp.utils.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PackagePage extends BasePage {
    public static By title = AppiumBy.accessibilityId("TITLE");
  //  public static By title = By.xpath("//android.widget.TextView[@text=\"Gói cước\"]");
    private By select_package = AppiumBy.accessibilityId("package0");

    By btnDK = AppiumBy.accessibilityId("detailPackage_registration");
  //  private By btnDK = By.xpath("//android.widget.TextView[@text=\"Đăng ký\"]");
    private By btnDongY = AppiumBy.accessibilityId("detailPackage_yes_modal");
  //  private By btnDongY = By.xpath("//android.widget.TextView[@text=\"Đồng ý\"]");
    private By title_HTTT = By.xpath("//android.widget.TextView[@text=\"Hình thức thanh toán\"]");
   // private By ATM_noiDia = By.xpath("//android.widget.TextView[@text=\"Thẻ ATM nội địa\"]");
    private By ATM_noiDia=AppiumBy.accessibilityId("DC");
    private By btnXacNhan = AppiumBy.accessibilityId("detailPackage_confim_pay");
   // private By btnXacNhan = By.xpath("//android.widget.TextView[@text=\"Xác nhận\"]\n");
    private By vnpt_epay_page = By.xpath("//android.widget.Image[@text=\"Vnpt epay\"]");

    public PackagePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public boolean isLoaded() {
        return waitForElementDisplay(driver, title, 10);
    }

    public boolean isAlert() {
        return waitForElementDisplay(driver, btnDongY, 10);
    }

    public void buyPackage() {
        //Chon goi
        driver.findElement(select_package).click();
        //Click đăng ký gói
        driver.findElement(btnDK).click();
        //Kiem tra thong bao thay the goi cuoc cu
        if (isAlert()) {
            driver.findElement(btnDongY).click();
        }
       // waitForElementDisplay(driver, ATM_noiDia, 10);
        driver.findElement(ATM_noiDia).click();
        driver.findElement(btnXacNhan).click();
      //  waitForElementDisplay(driver, vnpt_epay_page, 10);
        Assert.assertEquals(driver.findElement(vnpt_epay_page).getText(), "Vnpt epay", "Trang thanh toán");


    }

}
