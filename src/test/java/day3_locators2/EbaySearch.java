package day3_locators2;
/*
    Task:
Go to amazon  https://www.amazon.com/
 Go to Ebay   https://www.ebay.com/
Enter a search term
Click on search button
Verify title contains search term
     */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EbaySearch {



    public static void main(String[] args) {
        //locators --> Id,Name,
        /*
     If class attribute's value has a space or spaces, driver driver cannot locate that element.
     Therefore we don't use that locator.
        */
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://amazon.com");

        driver.navigate().to("https://ebay.com");

        /*
        <input type="text" class="gh-tb ui-autocomplete-input" size="50" maxlength="300"
        label="Search for anything" placeholder="Search for anything" id="gh-ac"
        name="_nkw" autocapitalize="off" autocorrect="off" spellcheck="false" autocomplete="off" aria-haspopup="true"
         role="combobox" aria-owns="ui-id-1">


         //we will use name --> name="_nkw"
         */
        try{
            Thread.sleep(4000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        //we used name locator for practice
        WebElement searchBox = driver.findElement(By.name("_nkw"));
        //searchBox.sendKeys("shoes");
        //Keys.ENTER --> click the Enter key
        searchBox.sendKeys("shoes"+ Keys.ENTER);
//
//        WebElement searchButton  = driver.findElement(By.id("gh-ac"));
//        searchButton.click();

        ///verify title contains search term
        //expected vs actual

        String expectedPartialTitle = "shoes";
        String actualTitle = driver.getTitle();

        if(actualTitle.contains(expectedPartialTitle)){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }







    }
}
