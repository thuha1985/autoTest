package com.qaauto.wintelapp.testcase;

import com.qaauto.wintelapp.page.LoginPage;
import com.qaauto.wintelapp.page.WelcomePage;
import com.qaauto.wintelapp.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WelcomePageTest extends BaseTest {
    WelcomePage welcomePage;

    @BeforeClass
    public void open_app() throws InterruptedException {
        welcomePage = new WelcomePage(driver);
    }

    @Test
    public void login_first() {
        LoginPage loginPage = welcomePage.login();
        Assert.assertTrue(loginPage.isLoaded());
    }
}
