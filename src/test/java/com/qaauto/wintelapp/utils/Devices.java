package com.qaauto.wintelapp.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Devices {
    public static AndroidDriver driver;

    public Devices() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("platformVersion", "11");
//        capabilities.setCapability("deviceName", "BDE00027859");
        capabilities.setCapability("platformVersion", "14");
        capabilities.setCapability("deviceName", "R5CRC0MFA5R");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.reddi.dev");
        capabilities.setCapability("appActivity", "com.reddi.MainActivity");

        //driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
        capabilities.setCapability("clearDeviceLogsOnStart", true);
    }

    public static AndroidDriver getDriver() {
        return driver;
    }
}