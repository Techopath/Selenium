package day1_Navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyUrl {

    /*
    1. Go to Etsy
    2. verify url
     */

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.etsy.com");
        driver.manage().window().maximize();

        //for verifying title -> getTitle()
        //for verifying url ->

        String expectedUrl = "https://www.etsy.com";
        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)) {

            System.out.println("passed");
        }else{
            System.out.println("failed");
            System.out.println("expectedUrl = " + expectedUrl);
            System.out.println("actualUrl = " + actualUrl);
        }

        driver.quit();
    }


}
