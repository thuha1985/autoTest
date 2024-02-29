package com.qaauto.wintelapp.page;

import com.qaauto.wintelapp.utils.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class PhoneNumberSelectionPage extends BasePage {
    public static By title = AppiumBy.accessibilityId("title");
    public PhoneNumberSelectionPage(AndroidDriver driver){
        this.driver= driver;
    }

}
