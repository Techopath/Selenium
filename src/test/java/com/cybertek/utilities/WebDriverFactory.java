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


    /*
    the following method should be static so that we don't create an object of this class
    and be able to call this method by calling the name of class.  */
    //
    public static WebDriver getDriver(String browserType){

        //local variables should be initialized
        WebDriver driver = null;
        browserType = browserType.toLowerCase();
        switch (browserType){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case ("firefox"):
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();


        }

//
//
//        if (browserType.equals("chrome")) {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//        } else if (browserType.equals("firefox")) {
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//        }

        return driver;

    }




}
