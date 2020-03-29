package HomeWork2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Days {

    /*
    DAYS
1. go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox
2. Randomly select a checkbox. As soon as you check any day, print the name of the day
and uncheck immediately.
After you check and uncheck Friday for the third time, exit the program.
NOTE: Remember some checkboxes are not selectable. You need to find a way to ignore them
when they are randomly selected. It has to be dynamic. Do not hard code Saturday and Sunday.
Use values of certain attributes.
     */


    WebDriver driver;
    @BeforeTest
    public void beforeTest(){
        driver = WebDriverFactory.getDriver("chrome");

    }

    @Test
    public void selectRandomly() throws InterruptedException {
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        Thread.sleep(1000);
        List<WebElement> checkBox = driver.findElements(By.cssSelector("input[type='checkbox']"));

        System.out.println(checkBox.size());
        Random ran = new Random();
         int countFriday = 0;
         int turns =0;
         while (countFriday!=3) {
             //Thread.sleep(1000);
             int num = ran.nextInt(7);

             //to ignore disabled elements
//             WebElement disabled = driver.findElement(By.tagName("input"));
//
//             Assert.assertTrue(Boolean.parseBoolean(disabled.getAttribute("disabled")));
//             String bl = checkBox.get(num).getAttribute("disabled");
//             System.out.println(bl + " "+checkBox.get(num).getAttribute("id"));


            checkBox.get(num).click();
            if (checkBox.get(num).getAttribute("id").contains("Friday")) {
                System.out.println(num+" Friday");
                countFriday++;
            }
            System.out.println(countFriday);
            //Thread.sleep(2000);
            checkBox.get(num).click();


             turns++;
         }
        System.out.println("number of cycle "+turns);
    }
}
