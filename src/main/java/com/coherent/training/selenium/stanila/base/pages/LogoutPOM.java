package com.coherent.training.selenium.stanila.base.pages;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPOM extends BasePOM {
    @FindBy(xpath = "//span[.='Log in']/ancestor::button")
    private WebElement loginFirst;
    @FindBy(id = "passp-field-login")
    private WebElement username;
    @FindBy (id= "passp:sign-in")
    private WebElement login;
    @FindBy(id = "passp-field-passwd")
    private WebElement password;
    @FindBy(xpath = "//a[@role='button']//img")
    private WebElement image;
    @FindBy(xpath = "//h3[normalize-space()='Choose an exclusive address']")
    private WebElement textForAssert;
    @FindBy(xpath = "//span[normalize-space()='Log out']")
    private WebElement logout;

    public LogoutPOM(WebDriver driver) {
        super(driver);
    }

    @SneakyThrows
    public void logout(String usname, String pswd){
        loginFirst.click();
        username.sendKeys(usname);
        login.click();
        password.sendKeys(pswd);
        login.click();
        image.click();
        logout.click();
    }

    public boolean textForAssertIsDisplayed() {
        return textForAssert.isDisplayed();
    }
}
