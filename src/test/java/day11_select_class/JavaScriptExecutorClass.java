package day11_select_class;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class JavaScriptExecutorClass {

    WebDriver driver;
    JavascriptExecutor jse;


    /*
    how do you send code? I use java script executor
     */
    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        jse = (JavascriptExecutor) driver;

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        //driver.quit();
    }

    @Test
    public void scroll() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/");

        WebElement link = driver.findElement(By.linkText("Cybertek School"));

        jse.executeScript("arguments[0].scrollIntoView(true);",link);

        Thread.sleep(2000);
    }

    @Test
    public void sendKeysWithJS(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement input = driver.findElement(By.cssSelector("input[disabled]"));
        String text = "hi world";

        jse.executeScript("arguments[0].setAttribute('value', '"+text+"')",input);
        //argument[0].setAttribute('value', 'hello world');
    }
}
