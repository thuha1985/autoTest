package com.qaauto.wintelapp.testcase;

import com.qaauto.wintelapp.page.HomePage;
import com.qaauto.wintelapp.page.LoginPage;
import com.qaauto.wintelapp.page.VoucherPage;
import com.qaauto.wintelapp.page.WelcomePage;
import com.qaauto.wintelapp.utils.BaseTest;
import com.qaauto.wintelapp.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VoucherPageTest extends BaseTest {
    String TITLE = "Voucher";
    String SUB_TITLE = "Xác nhận đơn hàng";

    WelcomePage welcomePage;
    LoginPage loginPage;
    HomePage homePage;
    VoucherPage voucherPage;

    @BeforeClass
    public void open_login_screen() throws InterruptedException {
        welcomePage = new WelcomePage(driver);
        loginPage = welcomePage.login();
        homePage = loginPage.login(Constants.PHONE_NUMBER, Constants.PASSWORD);
    }

    @BeforeMethod
    public void open_home_screen() {
        homePage.click_home_icon();
        homePage.scrollToBottom();
    }

    @Test(priority = 1)
    public void buy_voucher_20(){
        voucherPage = homePage.click_voucher();
        Assert.assertTrue(voucherPage.isLoaded());
        Assert.assertTrue(voucherPage.check_title(voucherPage.title, TITLE));

        voucherPage.click_voucher_20();
        voucherPage.click_buy_now();
        Assert.assertTrue(voucherPage.check_title(voucherPage.title, SUB_TITLE));

        voucherPage.click_payment();
    }

    @Test(priority = 2)
    public void buy_voucher_50(){
        voucherPage = homePage.click_voucher();
        Assert.assertTrue(voucherPage.isLoaded());
        Assert.assertTrue(voucherPage.check_title(voucherPage.title, TITLE));

        voucherPage.click_voucher_50();
        voucherPage.click_buy_now();
        Assert.assertTrue(voucherPage.check_title(voucherPage.title, SUB_TITLE));

        voucherPage.click_payment();
    }

    @AfterMethod
    public void back_to_home_screen(){
        voucherPage.cancel_order();
    }
}
