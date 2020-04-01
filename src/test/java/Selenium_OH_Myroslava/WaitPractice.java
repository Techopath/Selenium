package Selenium_OH_Myroslava;

import com.cybertek.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WaitPractice extends TestBase {

    /*
    http://qa3.vytrack.com
    salesmanager110
    UserUser123
     */
    /*
    Implicit wait - we set it one time and it will work for every findElement method called
     -if the element not found,  NoSuchElementException -
     once the element found it will skip the rest of time assigned.

     Thread.sleep - not selenium wait! Thread - java class, sleep() method of Thread class.
                    stops the execution of java program for the time defined.
                    - we never want to use this method in our tests

      Explicit wait - we have to declare every time before the interaction with element
                    Expected condition we are looking for


        Singletone - to make sure we have only one instance of driver

     */

    @Test
    public void test(){
        driver.get("http://qa3.vytrack.com");
        //if test doesnt pass try wait until the page loads and title is found
        WebDriverWait webDriverWait = new WebDriverWait(driver,10);
        webDriverWait.until(ExpectedConditions.titleIs("Login"));

        WebElement user = driver.findElement(By.id("prependedInput"));
        WebElement password = driver.findElement(By.id("prependedInput2"));

        user.sendKeys("salesmanager110");
        password.sendKeys("UserUser123");
        password.submit();

        WebElement account =driver.findElement(By.xpath("//span[.='Accounts']/following-sibling::a"));
        //<div class="loader-mask shown">...</div>
        webDriverWait.until(ExpectedConditions.elementToBeClickable(account));
        account.click();


        System.out.println("feature branch");



    }



}
