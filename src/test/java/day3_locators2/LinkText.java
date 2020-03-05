package day3_locators2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkText {

    public static void main(String[] args) throws InterruptedException {

        //so far, we learned locators:  Id, name, tagname, class, LinkText

        //in this class we will learn ---> Locator LinkText

        //<a> tag representing Link.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        driver.manage().window().maximize();
/*
<a href="/dynamic_loading/1">Example 1: Element on page that is hidden and become visible after trigger</a>
 */
        WebElement example3 = driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger"));
        String textVersionOfExample3 = example3.getText();

        System.out.println("textVersionOfExample3 = " + textVersionOfExample3);


            //LinkText vs partialLinkText

        WebElement partialLinkText = driver.findElement(By.partialLinkText("Example 1:"));
        String textVersion_usingPartialLink = partialLinkText.getText();
        System.out.println("textVersion_usingPartialLink = " + textVersion_usingPartialLink);


        /*
        Task:
        1. go to "http://practice.cybertekschool.com/dynamic_loading"
        2. Locate Cybertek_School element by using linkText or PartialLinkText

        Cybertek_School is a link
        how do I know it is a link?
        --because it starts with tag <a in html code
        ---<a target="_blank" href="https://cybertekschool.com/">Cybertek School</a>

        How can I use linkText?
        --
         */

        //Locate Cybertek_School
        WebElement cybertekSchool = driver.findElement(By.linkText("Cybertek School"));
        //I cannot print  because it is a web element
        //in order to print I need to use getText() method

        String textVersion = cybertekSchool.getText();
        System.out.println("textVersion = " + textVersion);

        //Locate Home element

        WebElement homeElement = driver.findElement(By.linkText("Home"));
        String home_textVersion = homeElement.getText();

        System.out.println("home_textVersion = " + home_textVersion);


    }
}
