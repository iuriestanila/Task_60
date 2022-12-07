package com.coherent.training.selenium.stanila.tests.utils;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadFile {

    @SneakyThrows
    public static String readProperties(){
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/resources/data.properties"));
        return properties.getProperty("key");
    }
}
