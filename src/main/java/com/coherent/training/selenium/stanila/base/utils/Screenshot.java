package com.coherent.training.selenium.stanila.base.utils;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Screenshot {
    @SneakyThrows
    public static void screenshotPerform(WebDriver driver, String filename){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source,new File(System.getProperty("user.dir")+"\\ScreenShot\\"+filename+".png"));
    }
}
