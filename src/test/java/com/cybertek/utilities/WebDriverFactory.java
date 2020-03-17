package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {


    //write a static return method which returns WebDriver

    //name:getDriver
    //it takes a String as a parameter ---> browser typr
    //returns ChromeDriver and FirefoxDriver

    public static WebDriver getDriver(String browserType){

        //local variables should be initialized

        WebDriver driver = null;

        if (browserType.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserType.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        return driver;

    }




}
