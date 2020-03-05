package day3_locators2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyerrorMessage extends VerifyLogin {
/*
test case:
1. go to login page https://prectice,cybertek.com/login
2. enter invalid username
3. enter invalid password
4. Verify the error message

 */


    //testers will gather test data in excel sheet
    //
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get(url); //we extended this class to VerifyLogin class so that using the url.




    }
}
