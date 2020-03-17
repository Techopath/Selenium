package day4_Xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttribute {

    /*
    1.Locate sign in button from bookit login page
    2.print out submit value
    3.type ="submit"

     */

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url = "http://practice.cybertekschool.com/forgot_password";


        //String bookItUrl = "https://cybertek-reservation-qa.herokuapp.com/sign-in";

        driver.get(url);
        /*
        <button id="form_submit" class="radius" type="submit">
        <i class="icon-2x icon-signin">Retrieve password</i></button>
         */

        WebElement retrievePasswordButtn = driver.findElement(By.id("form_submit"));

        System.out.println(retrievePasswordButtn.getAttribute("type")); //submit
        System.out.println(retrievePasswordButtn.getAttribute("class"));//radius
        System.out.println(retrievePasswordButtn.getAttribute("id"));//form_submit







    }
}
