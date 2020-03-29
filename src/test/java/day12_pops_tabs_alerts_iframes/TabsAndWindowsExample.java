package day12_pops_tabs_alerts_iframes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class TabsAndWindowsExample {

    WebDriver driver;
    @BeforeTest
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        System.out.println("hehe");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        //driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/windows");

        WebElement link = driver.findElement(By.linkText("Click Here"));
        Thread.sleep(2000);
        link.click();

        // get all the available tabs
        Set<String> windowHandles = driver.getWindowHandles();

        // print all the windows handles
        for (String windowHandle : windowHandles) {
            System.out.println(windowHandle);
        }



        // get the id of current window/tab
        String currentWindow = driver.getWindowHandle();


        System.out.println("currentWindow = " + currentWindow);
        System.out.println("Before Switching");

        System.out.println("Title: "+driver.getTitle());

        System.out.println("text: "+driver.findElement(By.tagName("h3")).getText());

        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle); //switches between the open tabs
            if (driver.getTitle().equals("New Window")) {
                break;
            }
        }

        System.out.println("AFTER SWITCHING");
        System.out.println(driver.getTitle());
        System.out.println(driver.findElement(By.tagName("h3")).getText());

        for (String windows :windowHandles) {
            driver.switchTo().window(windows);
            if (driver.getTitle().equals("Practice"));
            break;

        }
        Thread.sleep(2000);
        System.out.println("page title "+driver.getTitle());
        link = driver.findElement(By.linkText("Click Here"));
        link.click();

        
    }
//TODO
    //write a utility that takes a String title,
    //changes to tab with given title
    //if such title is not found, go back to original window

    //write a utility that takes a String url,
    //changes to tab with given url
    //if such title is not found, go back to original window


}
