package Selenium_OH_Myroslava;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class UnderstandingJavaScriptExecutor {

    @Test(priority = 0,description = "Send text to search box on Etsy")
    public void test1(){
        //Driver instance created
        WebDriver driver = WebDriverFactory.getDriver("chrome_headless");
        //navigatinf to etsy homepage
        driver.get("https://www.etsy.com");

        JavascriptExecutor  js = (JavascriptExecutor) driver;

        js.executeScript("document.getElementById('global-enhancements-search-query').value='Send these characters'");

    }
}
