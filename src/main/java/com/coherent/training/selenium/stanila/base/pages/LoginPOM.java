package com.coherent.training.selenium.stanila.base.pages;

import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPOM extends BasePOM {
    @FindBy(xpath = "//span[.='Log in']/ancestor::button")
    private WebElement loginFirst;
    @FindBy(id = "passp-field-login")
    private WebElement username;
    @FindBy (id= "passp:sign-in")
    private WebElement login;
    @FindBy(id = "passp-field-passwd")
    private WebElement password;
    @FindBy(xpath = "//a[@href='#compose']")
    private WebElement compose;

    public LoginPOM(WebDriver driver) {
        super(driver);
    }

    @Step("Login step")
    @SneakyThrows
    public void login(String userName, String pswd){
        loginFirst.click();
        username.sendKeys(userName);
        login.click();
        password.sendKeys(pswd);
        login.click();
    }
    @Step("Verify if control button is displayed")
    public boolean composeIsDisplayed() {
        return compose.isDisplayed();
    }
}
