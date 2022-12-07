package com.coherent.training.selenium.stanila.tests.utils;

import com.coherent.training.selenium.stanila.base.DriverFactory;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
public class Screenshot {

    @SneakyThrows
    public static void screenshotPerform(String filename){
        WebDriver driver = DriverFactory.getDriver();
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source,new File(System.getProperty("user.dir")+"\\ScreenShot\\"+filename+".png"));
    }
}
