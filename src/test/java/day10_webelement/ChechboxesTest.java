package day10_webelement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChechboxesTest {

    /*
go to http://practice.cybertekschool.com/
verify that blue is selected
red is not selected
*/
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");



    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        //driver.quit();
    }

    @Test
    public void test(){

        WebElement checkBox1 = driver.findElement(By.xpath("//input[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//input[2]"));

        //by default one is not checked, but two is checked

        System.out.println("is checkbox1 selected: "+checkBox1.isSelected());
        System.out.println("is checkbox2 selected: "+checkBox2.isSelected());


        Assert.assertFalse(checkBox1.isSelected());
        Assert.assertTrue(checkBox2.isSelected());

        //check the first box
        //verify one is selected
        //verify two is selected

        System.out.println("check the first check box");

        checkBox1.click();


        System.out.println("is checkbox1 selected: "+checkBox1.isSelected());
        System.out.println("is checkbox2 selected: "+checkBox2.isSelected());

        Assert.assertFalse(checkBox1.isSelected());
        Assert.assertTrue(checkBox2.isSelected());


    }
}
