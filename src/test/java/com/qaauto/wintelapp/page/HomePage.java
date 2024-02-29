package com.qaauto.wintelapp.page;

import com.google.common.collect.ImmutableMap;
import com.qaauto.wintelapp.utils.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {
    private By topUp = AppiumBy.accessibilityId("recharge_icon");
    private WebElement btnTopUp;

    private By phoneNumberWarehouse = AppiumBy.accessibilityId("service1");
    private WebElement btnPhoneNumberWarehouse;

    private By changeSIMCard = AppiumBy.accessibilityId("service2");
    private WebElement btnChangeSIMCard;

    private By callBarring = AppiumBy.accessibilityId("service3");
    private WebElement btnCallBarring;

    private By blackList = AppiumBy.accessibilityId("service4");
    private WebElement btnBlackList;

    private By whiteList = AppiumBy.accessibilityId("service5");
    private WebElement btnWhiteList;

    private By MCA = AppiumBy.accessibilityId("service6");
    private WebElement btnMCA;

    private By voucher = AppiumBy.accessibilityId("service7");
    private WebElement btnVoucher;

    public static By bottomNavigation = AppiumBy.id("com.reddi.dev:id/bottom_navigation_item_icon");
    private List<WebElement> btnBottomNavigation = driver.findElements(bottomNavigation);

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
    //    scrollToBottom();

//        btnPhoneNumberWarehouse = driver.findElement(phoneNumberWarehouse);
//        btnChangeSIMCard = driver.findElement(changeSIMCard);
//        btnCallBarring = driver.findElement(callBarring);
//        btnBlackList = driver.findElement(blackList);
//        btnWhiteList = driver.findElement(whiteList);
//        btnMCA = driver.findElement(MCA);
//        btnVoucher = driver.findElement(voucher);
    }

    public boolean isLoaded() {
        return waitForElementDisplay(driver, bottomNavigation, 10);
    }

    public TopUpPage click_top_up() {
        btnTopUp= driver.findElement(topUp);
        btnTopUp.click();
        waitForElementDisplay(driver, TopUpPage.title, 10);
        return new TopUpPage(driver);
    }

    public PhoneNumberSelectionPage click_number_warehouse() {
        btnPhoneNumberWarehouse.click();
        return new PhoneNumberSelectionPage(driver);
    }

    public ChangeSIMCardPage click_change_SIMCard() {
        btnChangeSIMCard.click();
        return new ChangeSIMCardPage(driver);
    }

    public VoucherPage click_voucher() {
        btnVoucher = driver.findElement(voucher);
        btnVoucher.click();
        return new VoucherPage(driver);
    }

    public void click_home_icon() {
        btnBottomNavigation = driver.findElements(bottomNavigation);
        btnBottomNavigation.get(0).click();
        waitForElementDisplay(driver, topUp, 10);
    }

    public PackagePage click_package_icon() {
        btnBottomNavigation = driver.findElements(bottomNavigation);
        btnBottomNavigation.get(1).click();
        waitForElementDisplay(driver, PackagePage.title, 10);
        return new PackagePage(driver);
    }
}
