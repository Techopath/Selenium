package HomeWork2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class W3Schools {

    /*
    LINKS
1. go to https://www.w3schools.com/
2. find all the elements in the page with the tag a
3. for each of those elements, if it is displayed on the page, print the text and the href of that
element.
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
    public void w3SchoolsTest(){

        //step 1
        driver.get("https://www.w3schools.com/");

        //step 2
        List<WebElement> a = driver.findElements(By.tagName("a"));

        List<String> aTagList = new ArrayList<>();
        System.out.println(aTagList.size());

        for (WebElement webElement : a) {
            //step 3
            if (webElement.isDisplayed()){
                aTagList.add(webElement.getText()+" = "+webElement.getAttribute("href"));

            }


        }

        System.out.println(aTagList);

        System.out.println("size: "+aTagList.size());

    }
}
