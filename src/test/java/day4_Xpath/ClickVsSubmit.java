package day4_Xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickVsSubmit {

    public static void main(String[] args) {
        /*
        Click()
        Submit()
        Task:
        1. Go to forgot password page on prictice.cybertkschool.com
           http://practice.cybertekschool.com/forgot_password
        2. Enter any email address
        3. Click "retrieve password" button
        4. Verify the url is: http://practice.cybertekschool.com/email_sent
         */
        String url = "http://practice.cybertekschool.com/forgot_password";
        String expectedURL = "http://practice.cybertekschool.com/email_sent";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.name("email")).sendKeys("anyemail@gmail.com");
        driver.findElement(By.id("form_submit")).submit();
        String actualURL = driver.getCurrentUrl();
        String expectedMessage = "Your e-mail's been sent!";
        String actualMessage = driver.findElement(By.tagName("h4")).getText();
        if (actualURL.equals(expectedURL)) {
            System.out.println("PASS! Actual URL matches the expected URL...");
        } else {
            System.out.println("FAIL! Actual URL does not match with the expected URL...");
            System.out.println("expectedURL = " + expectedURL);
            System.out.println("actualURL = " + actualURL);
        }
        System.out.println("'Expected Message' matches 'Actual Message' ==> " + expectedMessage.equals(actualMessage));
       // driver.close();

    }
}
