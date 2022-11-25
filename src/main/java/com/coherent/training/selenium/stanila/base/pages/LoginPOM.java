package com.coherent.training.selenium.stanila.base.pages;

import com.coherent.training.selenium.stanila.base.BasePOM;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPOM extends BasePOM {
    @FindBy(xpath = "//button[starts-with(@class,'Button2')]")
    private WebElement loginFirst;
    @FindBy(id = "passp-field-login")
    private WebElement username;
    @FindBy (id= "passp:sign-in")
    private WebElement login;
    @FindBy(id = "passp-field-passwd")
    private WebElement password;
    @FindBy(xpath = "//div[@data-key='view=react-main-buttons']//div//a[@role='button']")
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
    }
    public boolean composeIsDisplayed() {
        return compose.isDisplayed();
    }
}
