package com.qaauto.wintelapp.page;

import com.qaauto.wintelapp.utils.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private By phoneNumber = AppiumBy.accessibilityId("signInScreen_username_input");
    private WebElement edtPhoneNumber = driver.findElement(phoneNumber);

    private By password = AppiumBy.accessibilityId("signInScreen_password_input");
    private WebElement edtPassword = driver.findElement(password);

  //  private By login = AppiumBy.accessibilityId("signInScreen_sign_in");
    private By login =By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]");
    private WebElement btnLogin;

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        press_back();
        btnLogin = driver.findElement(login);
    }

    public boolean isLoaded() {
        return waitForElementDisplay(driver, phoneNumber, 10);
    }

    public void enterPhoneNumber(String phoneNumber) {
        edtPhoneNumber.clear();
        edtPhoneNumber.sendKeys(phoneNumber);
    }

    public void enterPassword(String qpassword) {
        edtPassword.clear();
        edtPassword.sendKeys(qpassword);
    }

    public HomePage click_login() {
        btnLogin.click();
        return new HomePage(driver);
    }

    public HomePage login(String phoneNumber, String password) {
        enterPhoneNumber(phoneNumber);
        enterPassword(password);
        btnLogin.click();
        return new HomePage(driver);
    }
}
