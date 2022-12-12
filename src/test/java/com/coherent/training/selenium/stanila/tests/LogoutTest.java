package com.coherent.training.selenium.stanila.tests;

import com.coherent.training.selenium.stanila.base.DriverFactory;
import com.coherent.training.selenium.stanila.base.pages.LogoutPOM;
import com.coherent.training.selenium.stanila.tests.utils.EncryptionAes;
import com.coherent.training.selenium.stanila.tests.utils.ReadFile;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {
    WebDriver driver;
    LogoutPOM logoutPOM;
    EncryptionAes encryptionAes;
    public static final String USERNAME_CREDENTIAL = "moraru.andy";
    public static final String PASSWORD_CREDENTIAL = "My1HPpz2aUaTcrONcOii2g==";

    @Test
    @Description("Verify logout")
    @Epic("EP01")
    @Feature("Feature2 Logout")
    @Story("Story Logout")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PROJECT_KEY-6")
    public void logoutTest(){
        driver = DriverFactory.getDriver();
        logoutPOM = new LogoutPOM(driver);
        encryptionAes = new EncryptionAes(ReadFile.readProperties("key"));
        String pswdDecrypted = encryptionAes.decrypt(PASSWORD_CREDENTIAL);

        logoutPOM.logout(USERNAME_CREDENTIAL,pswdDecrypted);

        Assert.assertTrue(logoutPOM.textForAssertIsDisplayed(),"Text for Assert isn't displayed.");
        //Assert.assertTrue(false); //for failing purposes
    }
}
