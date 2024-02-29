package com.qaauto.wintelapp.page;

import com.qaauto.wintelapp.utils.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopUpPage extends BasePage {
    public static By title = AppiumBy.accessibilityId("title");

    private By phoneNumber = AppiumBy.accessibilityId("enter_phone_input");
    private WebElement edtPhoneNumber = driver.findElement(phoneNumber);

    private By amountOfMoney = AppiumBy.accessibilityId("enter_price_input");
    private WebElement edtAmountOfMoney = driver.findElement(amountOfMoney);

    private By paymentMethod = AppiumBy.accessibilityId("select_pay");
    private WebElement btnPaymentMethod = driver.findElement(paymentMethod);

    private By paymentMethodList;

    private By paymentAmount = AppiumBy.accessibilityId("total_amount");
    private WebElement lbPaymentAmount = driver.findElement(paymentAmount);

  //  private By topUp = AppiumBy.accessibilityId("recharge_btn");
    private By topUp = By.xpath("(//android.widget.TextView[@text=\"Nạp tiền\"])[2]");
    private WebElement btnTopUp = driver.findElement(topUp);

    public TopUpPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public boolean isLoaded(){
        return waitForElementDisplay(driver, title,10);
    }

    public WebElement getEdtPhoneNumber() {
        return edtPhoneNumber;
    }

    public WebElement getEdtAmountOfMoney() {
        return edtAmountOfMoney;
    }

    public WebElement getLbPaymentAmount() {
        return lbPaymentAmount;
    }

    public void top_up(){
        btnTopUp.click();
    }
}
