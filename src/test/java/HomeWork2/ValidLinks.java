package HomeWork2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ValidLinks {
    /*
    VALID LINKS
1. go to https://www.selenium.dev/documentation/en/
2. find all the elements in the page with the tag a
3. verify that all the links are valid
     */
    WebDriver driver;
    @BeforeMethod
    public void beforeTest(){
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Congratulations!");

        //driver.quit();
    }

    @Test
    public void selenium_dev(){
        //step 1
        driver.get("https://www.selenium.dev/documentation/en/");

        List<WebElement> aTags = driver.findElements(By.tagName("a"));

        //System.out.println(aTags);
//step 2
        List<String> allLinks = new ArrayList<>();
        for (WebElement aTag : aTags) {
            allLinks.add(aTag.getAttribute("href"));
        }

//        System.out.println(allLinks);
//        System.out.println("allLinks.size() = " + allLinks.size());
//

        //step 3

        //write code here




    }


}
