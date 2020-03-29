package day12_pops_tabs_alerts_iframes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IFrameExample {
    WebDriver driver;
    @BeforeTest
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        //driver.quit();
    }

    @Test
    public void test(){
        driver.get("http://practice.cybertekschool.com/tinymce");

        //if there's an html inside html then we need to switch to iframe. otherwise
        //selenium cannot perform the action.
        //todo switch by id/name
        driver.switchTo().frame("mce_0_ifr");
        WebElement textBox = driver.findElement(By.id("tinymce"));
        textBox.clear();
        textBox.sendKeys("many thanks");

        //since the following locator is outside iframe, it will give no such element exception
       // System.out.println(driver.findElement(By.tagName("h3")));

        //now we get out of the frame
        //one way using driver.switch().defaultContent(). --> takes you to previous html

        driver.switchTo().defaultContent();
        //and locate the element
        System.out.println(driver.findElement(By.tagName("h3")).getText());

        //todo switch by webElement

        WebElement frame = driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame(frame);

        textBox = driver.findElement(By.id("tinymce"));
        textBox.clear();
        textBox.sendKeys("many thanks");

        //get out of the frame
        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.tagName("h3")).getText());

        //TODO switch by index

        driver.switchTo().frame(0);
        textBox = driver.findElement(By.id("tinymce"));
        textBox.clear();
        textBox.sendKeys("many thanks sincerely");


    }



}
