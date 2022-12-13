package com.coherent.training.selenium.stanila.base.utils;

import lombok.SneakyThrows;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.net.URL;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @SneakyThrows
    public static void setDriver()  {
        System.setProperty(ReadFile.read("driverChrome"),
                ReadFile.read("chromeDriverPath"));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WIN10);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.merge(capabilities);

        WebDriver driverRemote = new RemoteWebDriver(new URL(ReadFile.read("hubURL")), chromeOptions);
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
