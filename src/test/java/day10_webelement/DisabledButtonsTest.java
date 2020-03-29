package day10_webelement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DisabledButtonsTest {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
    }


    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    /*
    go to "http://practice.cybertekschool.com/checkboxes"
    verify green is disabled
    verify black is enabled

     */

    @Test
    public void disabledTest(){

        WebElement green = driver.findElement(By.id("green"));

        WebElement black = driver.findElement(By.id("black"));

        //isEnabled() returns true if the element is
        green.click();

        System.out.println("green enabled? "+green.isEnabled());
        System.out.println("black enabled? "+black.isEnabled());

        Assert.assertFalse(green.isEnabled());
        Assert.assertTrue(black.isEnabled());
    }

    @Test
    public void disabledTestWithAttribute(){
        WebElement green = driver.findElement(By.id("green"));

        WebElement black = driver.findElement(By.id("black"));

        System.out.println("black " + black.getAttribute("disabled") );
        System.out.println("green "+green.getAttribute("disabled"));

        //verify that certain value is equal to null

        Assert.assertEquals(black.getAttribute("disabled"),null);
        //verify that value of black.getAttribute("disabled") is NULL
        Assert.assertNull(black.getAttribute("disabled"));

        //verify that certain value is equal to true. verify element is disabled
        //Assert.assertEquals(green.getAttribute("disabled"), null);
        Assert.assertTrue(Boolean.parseBoolean(green.getAttribute("disabled")));
    }

    @Test
    public void testElementVisible() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        WebElement username = driver.findElement(By.id("username"));

        WebElement start = driver.findElement(By.tagName("button"));

        //verify that username is not visible
        //isDisplayed() --> return true element we found in html is visible on page

        System.out.println("username is visible "+username.isDisplayed());
        Assert.assertFalse(username.isDisplayed());

        Thread.sleep(2000);
        start.click();

        Thread.sleep(7000);

        System.out.println("username visible? "+username.isDisplayed());

        Assert.assertTrue(username.isDisplayed());
    }
}
