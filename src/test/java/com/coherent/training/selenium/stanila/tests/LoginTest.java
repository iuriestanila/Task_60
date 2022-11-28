package com.coherent.training.selenium.stanila.tests;

import com.coherent.training.selenium.stanila.base.DriverFactory;
import com.coherent.training.selenium.stanila.base.pages.LoginPOM;
import com.coherent.training.selenium.stanila.tests.utils.EncryptionAes;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    WebDriver driver;
    LoginPOM loginPOM;
    EncryptionAes encryptionAes;
    public static final String USERNAME_CREDENTIAL = "moraru.andy";
    public static final String PASSWORD_CREDENTIAL = "My1HPpz2aUaTcrONcOii2g==";
    @Test
    public void testLogin() {
        driver = DriverFactory.getDriver();
        loginPOM = new LoginPOM(driver);
        encryptionAes = new EncryptionAes("testTestSelenium");

        String pswdDecrypted = encryptionAes.decrypt(PASSWORD_CREDENTIAL);

        loginPOM.login(USERNAME_CREDENTIAL,pswdDecrypted);
        Assert.assertTrue(loginPOM.composeIsDisplayed(),"Compose button isn't displayed.");
        //Assert.assertTrue(false); //uncomment to verify Listeners
    }
}
