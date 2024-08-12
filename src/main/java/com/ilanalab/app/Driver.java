package com.ilanalab.app;

import org.openqa.selenium.WebDriver;

public class Driver {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void setDriver(WebDriver Driver){
        driver.set(Driver);
        System.out.println("Driver is set");
    }
    
}
