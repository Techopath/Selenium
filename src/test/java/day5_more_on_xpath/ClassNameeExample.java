package day5_more_on_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassNameeExample {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/login");

        WebElement link = driver.findElement(By.className("nav-link"));

        System.out.println(link.getText());

        /*
        go to
         */

    }
}
