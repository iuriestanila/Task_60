package com.coherent.training.selenium.stanila.tests;

import com.coherent.training.selenium.stanila.base.pages.LogoutPage;
import com.coherent.training.selenium.stanila.tests.base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LogoutTest extends BaseTest {
    public static final String USERNAME_CREDENTIAL = "moraru.andy";
    public static final String PASSWORD_CREDENTIAL = "RootRoot5?";

    @Test
    public void logoutTest(){
        LogoutPage logoutPage = new LogoutPage(driver);
        SoftAssert softAssert = new SoftAssert();

        logoutPage.logout(USERNAME_CREDENTIAL,PASSWORD_CREDENTIAL);

        softAssert.assertTrue(logoutPage.textForAssertIsDisplayed(),"Text for Assert isn't displayed.");
        softAssert.assertAll();
    }
}
