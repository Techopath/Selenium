package day13_waits_and_synchronization;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VytrackLoginTestWithWait {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void tearDown(){
        //driver.quit();
    }

    @Test
    public void test(){
        driver.get("http://qa3.vytrack.com");

        WebElement username = driver.findElement(By.id("prependedInput"));

        username.sendKeys("salesmanager110");

        WebElement pass = driver.findElement(By.id("prependedInput2"));

        pass.sendKeys("UserUser123");
        pass.submit();

        WebElement pageName = driver.findElement(By.cssSelector("h1[class = 'oro-subtitle']")); //aslo : //.'oro-subtitle'
        Assert.assertEquals(pageName.getText(),"Dashboard");

        Assert.assertEquals(driver.getTitle(),"Dashboard");


    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/3");

        WebElement input = driver.findElement(By.id("username"));
        input.sendKeys("username");

        WebElement pas = driver.findElement(By.id("pwd"));

        pas.sendKeys("password");
        pas.submit();

    }


}
