package com.qaauto.wintelapp.testcase;

import com.qaauto.wintelapp.page.HomePage;
import com.qaauto.wintelapp.page.LoginPage;
import com.qaauto.wintelapp.page.TopUpPage;
import com.qaauto.wintelapp.page.WelcomePage;
import com.qaauto.wintelapp.utils.BaseTest;
import com.qaauto.wintelapp.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TopUpPageTest extends BaseTest {
    String TITLE = "Nạp tiền";

    WelcomePage welcomePage;
    LoginPage loginPage;
    HomePage homePage;
    TopUpPage topUpPage;

    @BeforeClass
    public void open_login_screen() throws InterruptedException {
        welcomePage = new WelcomePage(driver);
        loginPage = welcomePage.login();
        homePage = loginPage.login(Constants.PHONE_NUMBER, Constants.PASSWORD);
    }

    @BeforeMethod
    public void open_home_screen() {
        homePage.click_home_icon();
    }

    @Test
    public void top_up() {
        topUpPage = homePage.click_top_up();
        Assert.assertTrue(topUpPage.isLoaded());
        Assert.assertTrue(topUpPage.check_title(topUpPage.title, TITLE));

        // check default
        Assert.assertEquals(topUpPage.getEdtPhoneNumber().getText(), Constants.PHONE_NUMBER);
        Assert.assertEquals(topUpPage.getEdtAmountOfMoney().getText(), "100.000");
        Assert.assertEquals(topUpPage.getLbPaymentAmount().getText(), "100.000đ");

        topUpPage.top_up();
    }
}
