package day8_review_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetAttributeExamples {

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://ebay.com");

        // get title
        System.out.println("title : "+driver.getTitle());

        // get current url
        System.out.println("current url : "+ driver.getCurrentUrl());

        // get page source
        System.out.println("page source : "+driver.getPageSource());

        WebElement myEbayLink = driver.findElement(By.linkText("My eBay"));

        // get certain values of attributes of the webelement
        String classValue = myEbayLink.getAttribute("class");
        System.out.println("classValue = " + classValue);
        String href = myEbayLink.getAttribute("href");
        System.out.println("href = " + href);
        // get test of the web element
        System.out.println("my ebaylink : "+myEbayLink.getText());

        WebElement input = driver.findElement(By.id("gh-ac"));

        input.sendKeys("wooden spoon");
        System.out.println(input.getAttribute("value"));

        // .getAttribute("innerHTML") --> returns text of the element
        System.out.println("innerHtml: "+myEbayLink.getAttribute("innerHTML"));

        // getAttribute("outerHTML")) --> returns html information of element
        System.out.println("outerHtml: "+myEbayLink.getAttribute("outerHTML"));
        System.out.println("searchBox: "+input.getAttribute("outerHTML"));



    }


}
