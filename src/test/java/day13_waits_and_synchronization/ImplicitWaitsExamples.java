package day13_waits_and_synchronization;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitsExamples {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void tearDown(){
        //driver.quit();
    }

    @Test

        public void test1() throws InterruptedException {
            driver.get("http://practice.cybertekschool.com/dynamic_loading/4");

            //implicit timing is
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        WebElement message = driver.findElement(By.cssSelector("#finish>h4")); //#-means id.
        Assert.assertTrue(message.isDisplayed());
        System.out.println(message.getText());

        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
        WebElement button = driver.findElement(By.cssSelector("#finish>h4"));

        Assert.assertTrue(button.isDisplayed());
        System.out.println(button.getText());



        }




    @Test
    public void ifPandemicExists(){

String alphabet = "abcdefghijklmnopqrstuvwxyz";
String toBeEncrypted = "Watch out! Pandemic is in action";
String enc = "";
        for (int i = 0; i < toBeEncrypted.length(); i++) {

            char ch = toBeEncrypted.charAt(i);

            int idx = alphabet.indexOf(ch);

            enc = enc+alphabet.charAt(idx);

        }
//         System.out.println("Watch out! Pandemic is in action");
//         driver.get("https://www.who.int/emergencies/diseases/novel-coronavirus-2019");
//
//         String message = driver.findElement(By.cssSelector("//h1")).getText();
//
//         if (message.contains("Pandemic")){
//             System.out.println("Never enter the zone with pandemic");
//             System.out.println("Nor people get out from pandemic zone, else it will impact everyone. ");
//         }


    }






}
