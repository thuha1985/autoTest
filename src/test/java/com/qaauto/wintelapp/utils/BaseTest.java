package com.qaauto.wintelapp.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.time.Duration;

public class BaseTest {
    protected static AndroidDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void createDriver() throws MalformedURLException {
        driver = new Devices().getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }
}