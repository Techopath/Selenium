package day4_Xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XPathPractice {

    public static void main(String[] args) {

        //go to practice login page

        //locate the username box with absolute xpath
        //

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/login");
       // driver.findElement(By.xpath("//*[@id=\"login\"]/div[2]/div/input")).sendKeys("Password");

        //         //tagName[@attribute='value']; --relative xpath --it has double slash in the beginning
        //if we dont have any attribute and value, we will use text() method.
        //       //tagname[text()='exact text']

        driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("musadam28@gmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("alhamdulilah");
        //driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/div/div/input")).sendKeys("musadam@gmail.com");


    }
}
