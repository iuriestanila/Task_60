package com.coherent.training.selenium.stanila.tests;

import com.coherent.training.selenium.stanila.base.DriverFactory;
import com.coherent.training.selenium.stanila.base.pages.LogoutPOM;
import com.coherent.training.selenium.stanila.tests.utils.EncryptionAes;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {
    WebDriver driver;
    LogoutPOM logoutPOM;
    EncryptionAes encryptionAes;
    public static final String USERNAME_CREDENTIAL = "moraru.andy";
    public static final String PASSWORD_CREDENTIAL = "My1HPpz2aUaTcrONcOii2g==";

    @Test
    public void logoutTest(){
        driver = DriverFactory.getDriver();
        logoutPOM = new LogoutPOM(driver);
        encryptionAes = new EncryptionAes("testTestSelenium");

        String pswdDecrypted = encryptionAes.decrypt(PASSWORD_CREDENTIAL);

        logoutPOM.logout(USERNAME_CREDENTIAL,pswdDecrypted);

        Assert.assertTrue(logoutPOM.textForAssertIsDisplayed(),"Text for Assert isn't displayed.");
    }
}
