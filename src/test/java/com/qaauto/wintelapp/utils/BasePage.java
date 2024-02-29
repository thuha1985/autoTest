package com.qaauto.wintelapp.utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

public class BasePage {
    protected static AndroidDriver driver;
    WebDriverWait wait;

    public static void waitSecond(double second) {
        try {
            synchronized (driver) {
                driver.wait((int) (second * 1000));
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) Objects.requireNonNull(driver)).executeScript("return document.readyState").toString()
                .equals("complete");
        try {
            waitSecond(2);
            WebDriverWait wait = new WebDriverWait(driver, ofSeconds(60));
            wait.until(expectation);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static boolean waitForElementDisplay(AndroidDriver driver, By by, int waitInSecond) {
        for (int i = 0; i < waitInSecond / 2 + 1; i++) {
            try {
                if (driver.findElement(by).isDisplayed()) {
                    return true;
                }
                waitSecond(2);
            } catch (Exception e) {
                System.out.println("waiting element for display...");
            }
        }
        return false;
    }

    public boolean waitUtilElementShow(String path, boolean hasText) {
        ExpectedCondition<Boolean> expectation = driver -> {
            try {
                WebElement closeElement = Objects.requireNonNull(driver).findElement(By.xpath(path));
                if (closeElement != null) {
                    if (hasText) {
                        if (!closeElement.getText().trim().isEmpty()) {
                            return true;
                        }
                    } else {
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        };

        try {
            waitSecond(2);
            WebDriverWait wait = new WebDriverWait(driver, ofSeconds(60));
            return wait.until(expectation);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return false;
    }

    protected boolean enterInput(String value, String path, boolean isEnter) {
        boolean isSuccess = false;
        try {
            WebElement closeElement = driver.findElement(By.xpath(path));
            if (closeElement != null) {
                closeElement.sendKeys(value);
                if (isEnter) {
                    closeElement.sendKeys(Keys.ENTER);
                }
            }
            isSuccess = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        waitForPageLoaded();
        return isSuccess;
    }

    protected boolean enterInputByCssSelection(String value, String path, boolean isEnter) {
        boolean isSuccess = false;
        try {
            WebElement closeElement = driver.findElement(By.cssSelector(path));
            if (closeElement != null) {
                closeElement.sendKeys(value);
                if (isEnter) {
                    closeElement.sendKeys(Keys.ENTER);
                }
            }
            isSuccess = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        waitForPageLoaded();
        return isSuccess;
    }

    protected boolean enterInputByElement(String value, WebElement element, boolean isEnter) {
        boolean isSuccess = false;
        try {
            element.sendKeys(value);
            if (isEnter) {
                element.sendKeys(Keys.ENTER);
            }
            isSuccess = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        waitForPageLoaded();

        return isSuccess;
    }

    protected void executeJs(String script) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script);
    }

    public void scrollToBottom() {
        int  x = driver.manage().window().getSize().width / 2;
        int start_y = (int) (driver.manage().window().getSize().height * 0.2);
        int end_y = (int) (driver.manage().window().getSize().height * 0.8);
        TouchAction dragNDrop = new TouchAction(driver)
                .press(point(x,end_y)).waitAction(waitOptions(Duration.ofMillis(500)))
                .moveTo(point(x, start_y))
                .release();
        dragNDrop.perform();


    }

    public boolean check_title(By by,String title){
        return driver.findElement(by).getText().equals(title);
    }

    public void press_back(){
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

    protected void scrollElement(String selector, int position) {
        executeJs("document.querySelectorAll('" + selector + "')[0].scrollTop=" + position);
    }

    protected void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void scrollToElementAndClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
       // waitForPageLoaded();
    }

    protected boolean clickElementById(String id) {
        try {
            WebElement closeElement = driver.findElement(By.id(id));
            if (closeElement != null) {
                closeElement.click();
            }
        } catch (Exception e) {
            return false;
        }
        waitForPageLoaded();
        return true;
    }

    public boolean clickElementByPath(String path) {
        try {
            WebElement closeElement = driver.findElement(By.xpath(path));
            if (closeElement != null) {
                closeElement.click();
            }
        } catch (Exception e) {
            return false;
        }
        waitForPageLoaded();
        return true;
    }

    protected boolean clickElementBySelector(String selector) {
        try {
            WebElement closeElement = driver.findElement(By.cssSelector(selector));
            if (closeElement != null) {
                closeElement.click();
            }
        } catch (Exception e) {
            return false;
        }
        waitForPageLoaded();
        return true;
    }

    protected boolean clickThenEnterInput(String value, String path, boolean isEnter) {
        boolean isSuccess = false;
        try {
            WebElement closeElement = driver.findElement(By.xpath(path));
            if (closeElement != null) {
                closeElement.click();
                closeElement.sendKeys(value);
                if (isEnter) {
                    closeElement.sendKeys(Keys.ENTER);
                }
            }
            isSuccess = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        waitForPageLoaded();
        return isSuccess;
    }

    protected List<WebElement> getAllElementBySelector(String cssSelector) {
        try {
            List<WebElement> elements = driver.findElements(By.cssSelector(cssSelector));
            return elements;
        } catch (Exception e) {

        }
        return new ArrayList<>();
    }

    protected String getTextFromElement(String xpath) {
        String value = "";
        try {
            WebElement closeElement = driver.findElement(By.xpath(xpath));
            if (closeElement != null) {
                value = closeElement.getText();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    protected boolean isXpathExisted(String xpath) {
        try {
            WebElement closeElement = driver.findElement(By.xpath(xpath));
            if (closeElement != null) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public void scrollAndClick(String visibleText) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))")).click();
    }


//    public void swipeUpUntilTextExists(String expected, int times) {
//        int i = 0;
//        do {
//            swipeUp();
//            i++;
//            if (i == times)
//                break;
//        } while (!driver.getPageSource().contains(expected));
//    }
//
//    public void swipeUp() {
//        Dimension size = driver.manage().window().getSize();
//        int starty = (int) (size.height * 0.8);
//        int endy = (int) (size.height * 0.2);
//        int startx = (int) (size.width / 2.2);
//        try {
//            log.info("Trying to swipe up from x:" + startx + " y:" + starty + ", to x:" + startx + " y:" + endy);
//            new TouchAction(driver).press(point(startx, starty)).waitAction(waitOptions(ofSeconds(3)))
//                    .moveTo(point(startx, endy)).release().perform();
//        } catch (Exception e) {
//            log.info("Swipe did not complete succesfully.");
//        }
//    }
}