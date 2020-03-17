package day4_Xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class getText {

    public static void main(String[] args) {
        String url = "http://practice.cybertekschool.com/forgot_password";
        String expectedURL = "http://practice.cybertekschool.com/email_sent";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.name("email")).sendKeys("anyemail@gmail.com");
        driver.findElement(By.id("form_submit")).submit();
        String actualURL = driver.getCurrentUrl();
        String expectedMessage = "Your email's been sent!";
        String actualMessage = driver.findElement(By.tagName("h4")).getText();

        WebElement confirmationMessage = driver.findElement(By.name("confirmation_message"));

        String actaulConfMessage = confirmationMessage.getText();

        if (expectedMessage.equals(actaulConfMessage)){
            System.out.println("passed");
        }else {
            System.out.println("failed");
            System.out.println("actaulConfMessage = " + actaulConfMessage);
            System.out.println("confirmationMessage = " + confirmationMessage);
        }


    }
}
