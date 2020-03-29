package day10_webelement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ListOfElementsTest {

    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("chrome");



    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        //driver.quit();
    }

    /*
    go to page radio buttons
    verify that none of the sport radio buttons are selected

     */

    @Test
    public void listOfRadioButtons() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        //driver.findElements() --> returns a List of elements
        //returns all the lements of the same type

       // WebElement sports = driver.findElements(By.name("sport")); //doesnt work

        Thread.sleep(3000);
        List <WebElement> sports = driver.findElements(By.name("sport"));


        //List <WebElement> sports = driver.findElements(By.name("lets say wrong locator"));
        //if the locator is wrong, the list of elements will be zero which means the element locator doesnt match.

        System.out.println(sports.size());

        for (WebElement radioButton: sports) {
            Assert.assertFalse(radioButton.isSelected());
            System.out.println("message");
        }
    }

    /*
    go to "http://practice.cybertekschool.com"

     */
@Test
    public void getAllLinksTest(){

    driver.get("http://practice.cybertekschool.com");

    //get all the links in a page

    List<WebElement> links = driver.findElements(By.tagName("a"));

    System.out.println(links.size());
    //get the text of each link and print
    int i = 1;
    for (WebElement link:links) {

        System.out.println(i +" => "+link.getText());
        i++;
    }




}
/*
got to amazon
search for lysol disinfecting wipes
print the number of results
print the first result.

 */
    @Test
    public void searchInAmazonTest(){
        driver.get("https://amazon.com");
        WebElement input = driver.findElement(By.id("twotabsearchtextbox"));

        input.sendKeys("paper towel" + Keys.ENTER);
//span.a-size-base-plus

        ///span[class ='a-size-base-plus a-color-base a-text-normal'];

        List<WebElement> allResults = driver.findElements(By.cssSelector("span.a-size-base-plus"));

        List<WebElement> allprices = driver.findElements(By.cssSelector("div[class='a-row']"));

        for (WebElement eachPrice :allprices) {
            System.out.println(eachPrice.getText());
        }
        System.out.println("size "+allResults.size());
        for (WebElement each:allResults) {
            System.out.println(each.getText());
        }

    }
/*
go to
verify the all sports checkboxes are not checked by default
randomly click any sport
verify that that sport is clicked
verify that all others are not clicked
repeat the last step for 5 times.
 */
    @Test
    public void rad_but () throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        List<WebElement> sportButtons = driver.findElements(By.name("sport"));
//        System.out.println("false here means not selected");
//        for (WebElement eachSport:sportButtons) {
//            Assert.assertFalse(eachSport.isSelected());
//            System.out.println("selected? "+eachSport.isSelected());
//
//        }
//
//        Thread.sleep(2000);
//
//        System.out.println("step 2");
//        sportButtons.get(2).click();
//
//        Assert.assertTrue(sportButtons.get(2).isSelected());
//        System.out.println(" selected? "+sportButtons.get(2).isSelected());
//        Thread.sleep(2000);
//
//        System.out.println("step 3");
//        System.out.println("2nd button is selected randomly" );
//        for (int i = 0; i < sportButtons.size(); i++) {
//
//            if (i!=2){
//
//                Assert.assertFalse(sportButtons.get(i).isSelected());
//                System.out.println("button "+i + " selected? " + sportButtons.get(i).isSelected());
//
//            }
//        }
//

                //with marufjon
        System.out.println("verify the all sports checkboxes are not checked by default\n");
        System.out.println(sportButtons.size());

        for (int i = 0; i < sportButtons.size() ; i++) {
            Assert.assertFalse(sportButtons.get(i).isSelected());
        }

        Thread.sleep(3000);
        System.out.println("randomly click any sport\n" +
                "verify that that sport is clicked\n" +
                "verify that all others are not clicked");
        Random ran = new Random();
        for (int q = 0; q < 5; q++) {
            Thread.sleep(2000);
            int num = ran.nextInt(4);
            sportButtons.get(num).click();
            System.out.println("button selected: "+num);

            for (int i = 0; i < sportButtons.size() ; i++) {
                if (i ==num){
                    Assert.assertTrue(sportButtons.get(i).isSelected());
                }else{
                    Assert.assertFalse(sportButtons.get(i).isSelected());
                    System.out.println(i+" not selected");
                }

            }


        }



    }



}
