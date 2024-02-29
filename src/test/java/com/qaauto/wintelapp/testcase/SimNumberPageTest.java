package com.qaauto.wintelapp.testcase;

import com.qaauto.wintelapp.page.*;
import com.qaauto.wintelapp.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SimNumberPageTest extends BaseTest {
    WelcomePage welcomePage;
    SimNumberPage simNumberPage;

    @BeforeClass
    public void open_app() throws InterruptedException {
        welcomePage = new WelcomePage(driver);
    }

    @BeforeMethod
    public void open_screen(){
        simNumberPage = welcomePage.click_buy_sim();
    }

    @Test
    public void buyPhoneNumber(){
        Assert.assertTrue(simNumberPage.isLoaded());
        simNumberPage.buyPhoneNumber();

    }
}
