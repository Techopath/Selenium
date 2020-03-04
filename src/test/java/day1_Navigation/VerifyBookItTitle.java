package day1_Navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
* 1. go to https://cybertek-reservation-qa.herokuapp.com/sign-in
* verify title
* 2. go to https://cybertek-reservation-qa.herokuapp.com/sign-in*/

public class VerifyBookItTitle {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        String bookItLoginPageUrl = "https://cybertek-reservation-qa.herokuapp.com/sign-in";
        driver.get(bookItLoginPageUrl);
        Thread.sleep(2000);
        driver.manage().window().fullscreen();

        String expectedLoginTitle = "bookit";

        String actualLoginTitle = driver.getTitle();

        if(expectedLoginTitle.equals(actualLoginTitle)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
            System.out.println("actualLoginTitle = " + actualLoginTitle);
            System.out.println("expectedLoginTitle = " + expectedLoginTitle);
        }
        String str = "cybertek-reservatiol";
        if(bookItLoginPageUrl.contains(str)){
            System.out.println(bookItLoginPageUrl+" Url contains "+ str);
        }else{
            System.out.println("failed. url does not contain "+str);
        }
        Thread.sleep(2000);
        driver.close();
    }
}
