package day1_Navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyTitle {

    public static void main(String[] args) {
        /*1. got ot cybertek.practice website
        * 2. verify title  expexted result: Practice
        * */

        //setup the manager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url = "https://google.com";
        driver.get(url);
        driver.manage().window().maximize();

        String expectedResult = "Google";

        String actualResult = driver.getTitle();

        if(expectedResult.equals(actualResult)){
            System.out.println("Test passed. ");
        }else {
            System.out.println("Expected title: "+expectedResult +" but the actual title is "+actualResult);
        }


    }
}
