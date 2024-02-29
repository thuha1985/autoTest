package com.qaauto.wintelapp.testcase;

import com.qaauto.wintelapp.page.HomePage;
import com.qaauto.wintelapp.page.LoginPage;
import com.qaauto.wintelapp.page.WelcomePage;
import com.qaauto.wintelapp.utils.BaseTest;
import com.qaauto.wintelapp.utils.Constants;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    WelcomePage welcomePage;
    LoginPage loginPage;

    @BeforeClass
    public void open_app() throws InterruptedException {
        welcomePage = new WelcomePage(driver);
    }

    @BeforeMethod
    public void open_login_screen(){
        loginPage = welcomePage.login();
    }

    @Test
    public void login(){
        loginPage.enterPhoneNumber(Constants.PHONE_NUMBER);
        loginPage.enterPassword(Constants.PASSWORD);
        HomePage homePage = loginPage.click_login();
        Assert.assertTrue(homePage.isLoaded());
    }
}
