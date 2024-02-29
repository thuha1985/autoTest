package com.qaauto.wintelapp.page;

import com.qaauto.wintelapp.utils.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WelcomePage extends BasePage {
    private By login = AppiumBy.accessibilityId("intro_sign_in");
    private By btn_buySim = AppiumBy.accessibilityId("intro_buySIM");
    private WebElement btnLogin;

    public WelcomePage(AndroidDriver driver) throws InterruptedException {
        this.driver = driver;
        btnLogin = driver.findElement(login);
    }

    public LoginPage login() {
        btnLogin.click();
        return new LoginPage(driver);
    }

    public SimNumberPage click_buy_sim() {
        driver.findElement(btn_buySim).click();
        return new SimNumberPage(driver);
    }
}
