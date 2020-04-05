package OfficeHoursWithMarufjon;

import com.cybertek.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class IframesExample extends TestBase {
        @Test
    public void frameTest(){
            driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");

            driver.switchTo().frame("iframeResult");
            System.out.println(driver.findElement(By.tagName("h2")).getText());
            //switch to using webElement to go to inner frame
            WebElement innerFrame = driver.findElement(By.cssSelector("iframe[src='demo_iframe.htm']"));
            driver.switchTo().frame(innerFrame);
            System.out.println(driver.findElement(By.tagName("h1")).getText());
            //change back to default content
            driver.switchTo().defaultContent(); //goes to original
            //using css selector, you need to fill the spaces with dots.
            System.out.println(driver.findElement(By.cssSelector(".cm-m-xml.cm-meta")).getText());
        }
}
