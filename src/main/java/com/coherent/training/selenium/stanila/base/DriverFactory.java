package com.coherent.training.selenium.stanila.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static void setDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver.set(new ChromeDriver());
    }
    public  static WebDriver getDriver(){
        return driver.get();
    }
    public  static void closeBrowser(){
        driver.get().close();
        driver.remove();
    }
}
