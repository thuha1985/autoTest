package com.qaauto.wintelapp.page;

import com.qaauto.wintelapp.utils.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class VoucherPage extends BasePage {
    public static By title = AppiumBy.accessibilityId("title");

    private By voucher_50 = AppiumBy.accessibilityId("voucher0");
    private WebElement btnVoucher50 = driver.findElement(voucher_50);

    private By voucher_20 = AppiumBy.accessibilityId("voucher1");
    private WebElement btnVoucher20 = driver.findElement(voucher_20);

    private By buy = AppiumBy.accessibilityId("detailVoucher_buynow");
    private WebElement btnBuy;

    private By payment = AppiumBy.accessibilityId("confimOrderVoucher_pay");
    private WebElement btnPayment;

    private By close = AppiumBy.id("android:id/button1");
    private WebElement btnClose;

    public VoucherPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public boolean isLoaded() {
        return waitForElementDisplay(driver, title, 10);
    }

    public void click_voucher_20() {
        btnVoucher20.click();
        waitForElementDisplay(driver, buy, 10);
    }

    public void click_voucher_50() {
        btnVoucher50.click();
        waitForElementDisplay(driver, buy, 10);
    }

    public void click_buy_now() {
        btnBuy = driver.findElement(buy);
        btnBuy.click();
        waitForElementDisplay(driver,payment,10);
    }

    public void click_payment() {
        btnPayment = driver.findElement(payment);
        if (btnPayment.isEnabled()){
            btnPayment.click();
            waitSecond(2);
        }
    }

    public void cancel_order() {
        press_back();
        waitForElementDisplay(driver,close,10);
        btnClose = driver.findElement(close);
        btnClose.click();
        waitForElementDisplay(driver,HomePage.bottomNavigation,10);
    }
}
