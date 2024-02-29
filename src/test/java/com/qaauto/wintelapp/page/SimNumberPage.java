package com.qaauto.wintelapp.page;

import com.qaauto.wintelapp.utils.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;
import java.util.List;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

public class SimNumberPage extends BasePage {
    public static By title = AppiumBy.accessibilityId("title");
    private By choose_number_phone = AppiumBy.accessibilityId("choose_number_phone");
    private By choose_package = AppiumBy.accessibilityId("select_package0");
    private By choose_physical_sim = AppiumBy.accessibilityId("choose_physical_sim");
    private By choose_Esim = AppiumBy.accessibilityId("choose_Esim");
    private By btn_order_continue = AppiumBy.accessibilityId("order_continue");
    private By name = AppiumBy.accessibilityId("deliveryInfomation_name");
    private By phone = AppiumBy.accessibilityId("deliveryInfomation_phone");
    private By email = AppiumBy.accessibilityId("deliveryInfomation_email");
    private By city = AppiumBy.accessibilityId("cityId");
    private By city0 = AppiumBy.accessibilityId("cityID0");
    private By district = AppiumBy.accessibilityId("districtId");
    private By district0 = AppiumBy.accessibilityId("deliveryID0");
    private By village = AppiumBy.accessibilityId("villageId");
    private By village0 = AppiumBy.accessibilityId("villageID0");
    private By address = AppiumBy.accessibilityId("addr_detail");
    private By payment = AppiumBy.accessibilityId("deliveryInfomation_pay");
    private By pay_COD = AppiumBy.accessibilityId("deliveryInfomationPay_COD");
    private By btn_delivery_continue = AppiumBy.accessibilityId("deliveryInfomation_continue");
    private By btn_confirm = AppiumBy.accessibilityId("confirmOrder_confirm");
    private By shipping = AppiumBy.accessibilityId("select_transport0");
    private By success = By.xpath("//android.widget.TextView[@text=\"Đặt hàng thành công\"]");

    public SimNumberPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public boolean isLoaded() {
        return waitForElementDisplay(driver, title, 10);
    }

    public void buyPhoneNumber() {

        // 1.Chọn số, Chọn gói cước
        driver.findElement(choose_number_phone).click();
        driver.findElement(choose_package).click();
        //2. Chọn loại sim
        Assert.assertEquals(driver.findElement(title).getText(), "Chọn loại hình SIM");
        driver.findElement(choose_physical_sim).click();
        driver.findElement(btn_order_continue).click();
        //3. Nhập thông tin nhận hàng
        //  Assert.assertEquals(driver.findElement(title).getText(), "Thông tin nhận hàng");
        driver.findElement(name).sendKeys("QA test ");
        driver.findElement(phone).sendKeys("0559123456");
       // driver.findElement(email).sendKeys("hadtt@mobicast.vn");
        driver.findElement(city).click();
        driver.findElement(city0).click();
        driver.findElement(district0).click();
        driver.findElement(village0).click();
        driver.findElement(address).sendKeys("QA test 123");

//        WebElement pay_COD_Ele= driver.findElement(pay_COD);
//        TouchAction action = new TouchAction(driver);
//        action.sc(pay_COD_Ele, 10, 100);
//        action.perform();
//        pay_COD_Ele.click();



//        WebElement elementToScroll = driver.findElement(AppiumBy.androidUIAutomator(
//                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
//                        + "new UiSelector().text(\"Hình thức thanh toán\"));"));
//
//        // Thực hiện hành động cuộn
//
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(pay_COD));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(pay_COD));
//



//        scrollAndClick("Hình thức thanh toán");
//        driver.findElement(pay_COD).click();

        driver.findElement(shipping).click();
        driver.findElement(btn_delivery_continue).click();
        //4.Xác nhận
        //   Assert.assertEquals(driver.findElement(title).getText(), "Xác nhận đơn hàng");
        driver.findElement(btn_confirm).click();
        //5.Thành công
        waitForElementDisplay(driver, success, 10);
        Assert.assertEquals(driver.findElement(success).getText(), "Đặt hàng thành công");

    }
}
