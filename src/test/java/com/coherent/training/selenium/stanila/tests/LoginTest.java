package com.coherent.training.selenium.stanila.tests;

import com.coherent.training.selenium.stanila.base.DriverFactory;
import com.coherent.training.selenium.stanila.base.pages.LoginPOM;
import com.coherent.training.selenium.stanila.tests.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseTest {
    WebDriver driver;
    LoginPOM loginPOM;
    public static final String USERNAME_CREDENTIAL = "moraru.andy";
    public static final String PASSWORD_CREDENTIAL = "RootRoot5?";

    @Test
    public void testLogInSuccessful() {
        SoftAssert softAssert = new SoftAssert();
        driver = DriverFactory.getDriver();
        loginPOM = new LoginPOM(driver);

        loginPOM.login(USERNAME_CREDENTIAL,PASSWORD_CREDENTIAL);

        softAssert.assertTrue(loginPOM.composeIsDisplayed(),"Compose button isn't displayed.");
        softAssert.assertAll();
    }
}
