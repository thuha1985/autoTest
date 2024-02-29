package com.qaauto.wintelapp.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseTest1 {
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
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
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
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
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

    protected void scrollElement(String selector, int position) {
        executeJs("document.querySelectorAll('" + selector + "')[0].scrollTop=" + position);
    }

    protected void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void scrollToElementAndClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        waitForPageLoaded();
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
}