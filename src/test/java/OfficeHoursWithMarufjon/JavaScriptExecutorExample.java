package OfficeHoursWithMarufjon;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import sun.security.krb5.Config;

import java.util.List;

public class JavaScriptExecutorExample extends TestBase {

    @Test
    public void type(){
        String url = ConfigurationReader.getProperty("url");//url is in configuration.properties file
        driver.get(url);
        driver.findElement(By.linkText("Dynamic Controls")).click();
        //driver.findElement(By.cssSelector("#input-example>input")).sendKeys("hi");

        WebElement webElement = driver.findElement(By.cssSelector("#input-example>input"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String text = "hello";
        jse.executeScript("arguments[0].setAttribute('value','"+text+"')", webElement); //it types in disabled locators

    }

    @Test
    public void highlight() throws InterruptedException {
        driver.get(ConfigurationReader.getProperty("url"));
        Thread.sleep(1000);
        WebElement text = driver.findElement(By.tagName("h1"));

        highlight(text);

        List<WebElement> list = driver.findElements(By.cssSelector("li>a"));
        for (WebElement link : list) {
            highlight(link);
        }

    }


    public static void highlight(WebElement element) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 2px solid red;');", element);
        Thread.sleep(200);
        jse.executeScript("arguments[0].removeAttribute('style', 'background: blue; border: 2px solid red;');", element);
        Thread.sleep(200);

    }
}
