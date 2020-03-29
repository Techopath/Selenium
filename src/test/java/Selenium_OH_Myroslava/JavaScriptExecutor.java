package Selenium_OH_Myroslava;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class JavaScriptExecutor {


    /*
    JavaScriptExecutor
    Add-on to Selenium
    We use when the selenium doesn't react well with the web page
    Alternative way to interact with the browser
  JavaScriptExecutor is an INTERFACE for the Driver
  (An example of polymorphism for the driver)
  1. SendKeys
      document.getElementById('element id').value='Send these characters'
        document.getElementByName('element id').value='Send these characters'
  2. click a button click()
       document.getElementById('element id').click();
  3. Get the title of the page
      document.title
  4. Get the URL of the page
     document.URL
  5. getText()
     document.getElementById('element id').innerHTML;
  6. Scroll down & scroll to view an element (Scroll into view of an element)
     (Scroll Down) window.scrollBy(0,500)
      (Scroll an element into view) document.getElementById('element id').scrollIntoView();
      (Scroll to the bottom of the page)
     */

    @Test(priority = 0,description = "Send text to search box on etsy")
    public void test1(){
        //Driver instance created
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //Navigating to etsy homepage
        driver.get("https://www.etsy.com/");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementById('global-enhancements-search-query').value='Send these characters'");


    }
    @Test(priority = 2, description = "get the page title (return a value)")
    public void testcase3(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //Navigating to etsy homepage
        driver.get("https://www.etsy.com/");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //return keyword before the script is for Selenium to know that it needs to bring back information
        String pageTitle = js.executeScript("return document.title").toString();
        System.out.println(pageTitle);
    }
    @Test(priority = 1,description = "Clicking on an element")
    public void test2(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //Navigating to etsy homepage
        driver.get("https://www.etsy.com/");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript(" document.getElementById('catnav-primary-link-891').click();");
    }
    @Test(description = "return page URL")
    public void test4(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //Navigating to etsy homepage
        driver.get("https://www.etsy.com/");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //return keyword before the script is for Selenium to know that it needs to bring back information
        String pageURL = js.executeScript("return document.URL").toString();
        System.out.println(pageURL);
    }
    @Test(description = "return element text")
    public void test5(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //Navigating to etsy homepage
        driver.get("https://www.etsy.com/");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String elementText= js.executeScript("return document.getElementById('catnav-primary-link-11049').innerHTML").toString();
        elementText=elementText.trim();
        System.out.println(elementText);
    }
    @Test(description = "scroll an element into view")
    public void test6(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //Navigating to etsy homepage
        driver.get("https://www.etsy.com/");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementById('email-list-signup-email-input').scrollIntoView();");
    }
}
