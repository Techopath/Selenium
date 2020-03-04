package day2_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElement {
    public static void main(String[] args) throws InterruptedException {
        /*Locator 1. ID
        * task:
        *  go to cybertek okta login page
        * write email to the text box
        * */

        //create setup

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url = "https://cybertekschool.okta.com"; //home page for cybertek okta
        driver.get(url);

        Thread.sleep(3000);

        //write email to email text box
        /*
        in order to do the task, we need to find the email box first - findElement () from Webdriver
        <input type="text" placeholder="" name="username" id="okta-signin-username" value="" aria-label="" autocomplete="off">

         */
        String word = "java";
        WebElement emailBox = driver.findElement(By.id("okta-signin-username")); //WebElement is a data type - interface contains many abstract methods.
        emailBox.sendKeys("musadam28@gmail.com");

/*
* <input type="password" placeholder="" name="password" id="okta-signin-password" value="" aria-label="" autocomplete="off">*/

        Thread.sleep(3000);
        WebElement passwordBox = driver.findElement(By.id("okta-signin-password"));
        passwordBox.sendKeys("Dushanbe#01");
/*
<input class="button button-primary" type="submit" value="Sign In" id="okta-signin-submit" data-type="save">
 */
        Thread.sleep(2000);
        WebElement submitBox = driver.findElement(By.id("okta-signin-submit"));
        submitBox.click();

        /*
        <input class="button button-primary" type="submit" value="Send Push" data-type="save">
         */
        Thread.sleep(2000);
        WebElement sendPushButton = driver.findElement(By.className("Send Push"));
        sendPushButton.click();

        driver.quit();
    }
}
