package Selenium_OH_Myroslava;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class IFramesPractice {

    WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Congratulations!");

        //driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/nested_frames");
        driver.switchTo().frame("frame-top");
        List<WebElement> frameList = driver.findElements(By.xpath("//frame"));
        System.out.println("frameList = " + frameList.size());

        /*
        we have stored all frames web elements inside the list
        1. loop through list
        2. switch to each frame and get text from body
        3. get back to parent frame
         */

        for (WebElement each : frameList) {

            Thread.sleep(3000);

            driver.switchTo().frame(each);
            String bodyText = driver.findElement(By.xpath("//body")).getText();
            System.out.println("bodyText = " + bodyText);
            Thread.sleep(1000);
            driver.switchTo().parentFrame();

        }

//        for (int i =0; i<frameList.size();i++) {
//
//            driver.switchTo().frame(i);
//            String bodyText = driver.findElement(By.xpath("//body")).getText();
//            System.out.println("bodyText = " + bodyText);
//            Thread.sleep(1000);
//            driver.switchTo().parentFrame();
//
//        }

        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-bottom");
        String bodyText = driver.findElement(By.xpath("//body")).getText();
        System.out.println("bodyText = " + bodyText);







    }
}