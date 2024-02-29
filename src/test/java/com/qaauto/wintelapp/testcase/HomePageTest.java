package com.qaauto.wintelapp.testcase;

import com.qaauto.wintelapp.page.HomePage;
import com.qaauto.wintelapp.page.LoginPage;
import com.qaauto.wintelapp.page.TopUpPage;
import com.qaauto.wintelapp.page.WelcomePage;
import com.qaauto.wintelapp.utils.BaseTest;
import com.qaauto.wintelapp.utils.Constants;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    WelcomePage welcomePage;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeClass
    public void open_login_screen() throws InterruptedException {
        welcomePage = new WelcomePage(driver);
        loginPage = welcomePage.login();
        homePage = loginPage.login(Constants.PHONE_NUMBER,Constants.PASSWORD);
    }

    @BeforeMethod
    public void open_home_screen() {
        homePage.click_home_icon();
    }

    @Test
    public void top_up() {
        TopUpPage topUpPage = homePage.click_top_up();
        Assert.assertTrue(topUpPage.isLoaded());
    }
}
