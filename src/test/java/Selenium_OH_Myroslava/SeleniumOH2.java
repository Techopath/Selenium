package Selenium_OH_Myroslava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumOH2 {


    public static void main(String[] args) {
         /* 1. go to http://automationpractice.com/
            2. Search for "tshirt" in a searchbox - click enter OR click search button
            3. Validate you got "no results" message on UI
            4. Search for "t-shirt"
            5. Validate there was 1 result found
          */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
        WebElement search_box = driver.findElement(By.id("search_query_top"));
        //WebElement - class in selenium/java and it has many useful methods
        //.sendKeys("value that we want to send - input tag")
        search_box.sendKeys("tshirt" + Keys.ENTER);
        /*
        <p class="alert alert-warning">
        No results were found for your search&nbsp;"tshirt"
         */

        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        WebElement error = driver.findElement(By.className("alert alert-warning"));
        String errorText = error.getText();
        //.getText() -> returns String (text) from the element
        System.out.println("Error message: " + errorText);
        //NoSuchElementException - means we could not locate the element


        //WebElement search_box = driver.findElement(By.id("search_query_top"));


        search_box.sendKeys("t-shirt"+Keys.ENTER);

        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        WebElement count = driver.findElement(By.className("product-count"));
        System.out.println("items found : "+count.getText());

        /*

         */
        WebElement addToCart = driver.findElement(By.className(""));//

        driver.quit();

    }
}