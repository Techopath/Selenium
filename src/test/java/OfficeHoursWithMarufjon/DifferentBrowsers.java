package OfficeHoursWithMarufjon;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.sun.org.apache.xalan.internal.xsltc.dom.AdaptiveResultTreeImpl;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class DifferentBrowsers extends TestBase {

    @Test

    public void test(){
        //which browser am i using now

        //option 1 get the value from properties files
        System.out.println("option 1");
        System.out.println(ConfigurationReader.getProperty("browser"));
        System.out.println("option 2");
        System.out.println(driver);
        if (driver.toString().contains("ChromeDriver")){
            System.out.println("this is chrome");
        }else if (driver.toString().contains("FirefoxDriver")){
            System.out.println("this is Firefox");
        }

        System.out.println("option 3");
        if (driver instanceof FirefoxDriver){
            System.out.println("firefoox");
        }else if (driver instanceof ChromeDriver){
            System.out.println("chrome");
        }
    }
}
