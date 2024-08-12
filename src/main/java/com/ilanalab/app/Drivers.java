package com.ilanalab.app;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Drivers {

    public static void ChromeDriver() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Driver.setDriver(driver);
        System.out.println("ChromeDriver is set");
    
    }
    
}
