package day10_webelement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RadioButtons {

    /*
go to http://practice.cybertekschool.com/
verify that blue is selected
red is not selected
 */
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("firefox");
        driver.get("http://practice.cybertekschool.com/radio_buttons");



    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }




    @Test
    public void test1() throws InterruptedException {

    WebElement blue = driver.findElement(By.id("blue"));
    //isSelected --> returns true if the element is selected.

        //System.out.println(blue.isSelected());

        Assert.assertTrue(blue.isSelected());

        WebElement red = driver.findElement(By.id("red"));
        //print red is not selected
        System.out.println(red.isSelected());
        //verifies if the statement is false, if false passed, if true failed
        Assert.assertFalse(red.isSelected());
        //Assert.assertFalse(!red.isSelected()); //the same thing actually
    }

    @Test
    public void test2(){

        WebElement blue = driver.findElement(By.id("blue"));
        WebElement red = driver.findElement(By.id("red"));

        red.click();

        Assert.assertFalse(blue.isSelected()); //it should return false, if blue is not selected
        Assert.assertTrue(red.isSelected());
        //Assert.assertFalse(red.isSelected());
    }


}
