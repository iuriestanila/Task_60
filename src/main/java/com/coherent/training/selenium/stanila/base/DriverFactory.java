package com.coherent.training.selenium.stanila.base;

import lombok.SneakyThrows;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final String hubUrl = "http://192.168.0.11:4444/wd/hub";
    @SneakyThrows
    public static void setDriver()  {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WIN10);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.merge(capabilities);


        WebDriver driverRemote = new RemoteWebDriver(new URL(hubUrl),chromeOptions);
        driver.set(driverRemote);
    }

    public  static WebDriver getDriver(){
        return driver.get();
    }

    public  static void closeBrowser(){
        driver.get().close();
        driver.remove();
    }
}
