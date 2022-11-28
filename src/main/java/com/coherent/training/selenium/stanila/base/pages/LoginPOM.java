package com.coherent.training.selenium.stanila.base.pages;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPOM extends BasePOM {
    @FindBy(xpath = "//button[@class='Button2 Button2_size_m Button2_view_orange " +
            "Button2_weight_500 Button_3YGxEShvAi7lB8DLgdG3y8 PSHeader-NoLoginButton']")
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

    @SneakyThrows
    public void login(String userName, String pswd){
        loginFirst.click();
        username.sendKeys(userName);
        login.click();
        password.sendKeys(pswd);
        login.click();
        Thread.sleep(4000);
    }
    public boolean composeIsDisplayed() {
        return compose.isDisplayed();
    }
}
