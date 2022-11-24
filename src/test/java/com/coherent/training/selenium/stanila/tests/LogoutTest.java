package com.coherent.training.selenium.stanila.tests;

import com.coherent.training.selenium.stanila.base.DriverFactory;
import com.coherent.training.selenium.stanila.base.pages.LogoutPOM;
import com.coherent.training.selenium.stanila.tests.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {
    WebDriver driver;
    LogoutPOM logoutPOM;
    public static final String USERNAME_CREDENTIAL = "moraru.andy";
    public static final String PASSWORD_CREDENTIAL = "RootRoot5?";

    @Test
    public void logoutTest(){
        driver = DriverFactory.getDriver();
        logoutPOM = new LogoutPOM(driver);

        logoutPOM.logout(USERNAME_CREDENTIAL,PASSWORD_CREDENTIAL);

        Assert.assertTrue(logoutPOM.textForAssertIsDisplayed(),"Text for Assert isn't displayed.");
    }
}
