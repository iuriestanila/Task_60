package com.coherent.training.selenium.stanila.tests;

import com.coherent.training.selenium.stanila.base.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    @BeforeMethod
    public void initialize() {
        DriverFactory.setDriver();
        DriverFactory.getDriver().get("https://mail.yandex.com/");
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.closeBrowser();
    }
}