
package com.qaauto.wintelapp.testcase;


import com.qaauto.wintelapp.page.HomePage;
import com.qaauto.wintelapp.page.LoginPage;
import com.qaauto.wintelapp.page.PackagePage;
import com.qaauto.wintelapp.page.WelcomePage;
import com.qaauto.wintelapp.utils.BaseTest;
import com.qaauto.wintelapp.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PackagePageTest extends BaseTest {
    WelcomePage welcomePage;
    LoginPage loginPage;
    HomePage homePage;
    PackagePage packagePage;


    @BeforeClass
    public void open_app() throws InterruptedException {
        welcomePage = new WelcomePage(driver);
        loginPage = welcomePage.login();
        homePage = loginPage.login(Constants.PHONE_NUMBER, Constants.PASSWORD);
        packagePage = homePage.click_package_icon();
    }


    @Test
    public void buyPackage() {
        Assert.assertTrue(packagePage.isLoaded());
        packagePage.buyPackage();
    }
}
