package day4_Xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttribute2 {

    /*
    go to http://practice.cybertekschool.com/dynamic_loading
    using linkText method locate the first link

    print out href attribute's value
    <a href="/dynamic_loading/1">
    Example 1: Element on page that is hidden and become visible after trigger</a>
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        //Locate Example 1

        WebElement example1 = driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger"));
        System.out.println(example1.getAttribute("href"));//returns value
        System.out.println(example1.getText()); //converts webElement to String

        WebElement link = driver.findElement(By.tagName("a")); //locates the first tagName if there are many
        System.out.println(link.getText());






    }
}
