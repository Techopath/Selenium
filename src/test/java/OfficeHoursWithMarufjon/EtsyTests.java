package OfficeHoursWithMarufjon;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.base.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class EtsyTests extends TestBase {
    /*
    search for wooden spoon on etsy.com
    verify that default shipt to location is shipt to
    verify Ship to countries includes Australia

     */
    @Test
    public void verifyCountryList() throws InterruptedException {
        driver.get("https://etsy.com");
       // driver.manage().window().fullscreen();
        WebElement input = driver.findElement(By.id("global-enhancements-search-query"));
        input.sendKeys("wooden spoon"+ Keys.ENTER);

        String expectedTitle = "Wooden spoon | Etsy";

        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        System.out.println("actualTitle = " + actualTitle);

        //if we want to find an element and the page load late we use implicit waiting.
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //it is only for finding element
        //driver.findElement(By.linkText("All categories")).click();

        //verify ship to Loaction
        //wait until the page loads in html

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        Select shipToList = new Select(driver.findElement(By.name("ship_to")));

        String expectedDefaultCountry = "United States";
        String actualDefaultCountry = shipToList.getFirstSelectedOption().getText().trim();

        Assert.assertEquals(actualDefaultCountry,expectedDefaultCountry);
        System.out.println("actualDefaultCountry = " + actualDefaultCountry);

        // verify ship to countries include Australia

        List<String> options = BrowserUtils.getElementsText(shipToList.getOptions());

        Assert.assertTrue(options.contains("Australia"));


        //verify free shipping is not selected

        WebElement freeShipping = driver.findElement(By.xpath("//label[.='FREE shipping']"));

        Assert.assertFalse(freeShipping.isSelected());

        //verify that url changes when freeShipping clicked

        freeShipping.click();

//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript("arguments[0].click();",freeShipping);

        String expectedUrl = "free_shipping=true";
        Assert.assertTrue(driver.getCurrentUrl().endsWith(expectedUrl));




    }
}
