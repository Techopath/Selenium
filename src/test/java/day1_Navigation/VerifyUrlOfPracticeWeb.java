package day1_Navigation;

/*
Task:
1. Go to google.com website
2. save the title in a string variable.
3. go to etsy
4. save the etsy title in a string
5. navigate back to previous page
6. verify the title is same as step 2.
7. navigate forward to previous page
8. verify the title is same as step 4.

 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerifyUrlOfPracticeWeb {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //driver.get("https://www.practice.cybertekschool.com");

        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        String expectedGoogleTitle = "Google";
        //String gTitle = driver.getTitle();

        Thread.sleep(2000);

        //driver.get("https://www.etsy.com");
        driver.navigate().to("https://www.etsy.com");
        //String eTitle = driver.getTitle();
        String expectedEtsyTitle = "tsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        Thread.sleep(2000);
        driver.navigate().back();

        String actualGoogleTitle = driver.getTitle();
        if (expectedGoogleTitle.equals(actualGoogleTitle)) {

            System.out.println("passed");
        }else{

            System.out.println("failed");
            System.out.println("actualGoogleTitle = " + actualGoogleTitle);
            System.out.println("expectedGoogleTitle = " + expectedGoogleTitle);

        }

        driver.navigate().forward();
        String actualEtsyTitle = driver.getTitle();
        if(expectedEtsyTitle.equals(actualEtsyTitle)){
            System.out.println("passed");
        }else
        {
            System.out.println("failed");
            System.out.println("actualEtsyTitle = " + actualEtsyTitle);
            System.out.println("expectedEtsyTitle = " + expectedEtsyTitle);
        }
        Thread.sleep(2000);

        driver.quit();


    }
}
