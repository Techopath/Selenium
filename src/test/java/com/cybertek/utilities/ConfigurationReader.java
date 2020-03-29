package com.cybertek.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties;

    static {

        try {
            //reads file in java. we need to pass the path of the file.
            FileInputStream fileInputStream = new FileInputStream("configuration.properties");
            //initialize the object
            properties = new Properties();

            properties.load(fileInputStream);
            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }

    public void test(){
        String browser = properties.getProperty("browser");
        System.out.println("browser name= " + browser);

        // i need the browser/url from properties file

        String pBrowser = ConfigurationReader.getProperty("browser");
        System.out.println("pBrowser = " + pBrowser);

        String pUrl = ConfigurationReader.getProperty("url");
        System.out.println("pUrl = " + pUrl);


    }


    @Test
    public void test2(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // get the the from props file
        String url = ConfigurationReader.getProperty("url");
        driver.get(url);
        driver.close();
    }

}
