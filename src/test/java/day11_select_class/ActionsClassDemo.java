package day11_select_class;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ActionsClassDemo {

    /*
    we use actions class, when we hover, drag and drop, right click, double click
    //hover involves putting the mouse tick on top of something
     */
    WebDriver driver;
    Actions actions;
    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        actions = new Actions(driver);
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        //driver.quit();
    }

    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");
        Thread.sleep(2000);
        WebElement target = driver.findElement(By.tagName("img"));
        //moveToElement --> moves the mouse on top of given element.
        actions.moveToElement(target).perform();
        Thread.sleep(3000);
    }

    @Test
    public void hoverGoogleTest() throws InterruptedException {
        driver.get("http://google.com");
        Thread.sleep(2000);
        WebElement target = driver.findElement(By.xpath("//input[@id='gbqfbb']"));
        actions.moveToElement(target).perform();
        Thread.sleep(2000);
    }

    @Test
    public void hover2(){
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        WebElement enabled = driver.findElement(By.id("ui-id-3"));
        WebElement downloads = driver.findElement(By.id("ui-id-4"));
        WebElement pdf = driver.findElement(By.id("ui-id-5"));

        //move the mouse to enabled
        //wait
        //move the mouse to downloads
        //wait
        //move the mouse to pdf

        //click on PDF
        actions.moveToElement(enabled);
                actions.pause(2000).
                moveToElement(downloads);
                actions.pause(2000).
                //moveToElement(pdf);
                //actions.click().
                click(pdf);
                actions.build().perform(); //build() is used when there is more than one action.
    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().fullscreen();
        Thread.sleep(2000);
        WebElement money = driver.findElement(By.id("draggable"));
        WebElement bank = driver.findElement(By.id("droptarget"));
        //scroll
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        actions.dragAndDrop(money, bank).perform();
        Thread.sleep(2000);



    }
    /*
    //todo task
    do the drag and drop by changing actions
    move mouse to sourcemoney
    mouse down
    move mouse to target/bank
    mouse up.
     */

    @Test
    public void dragAndDropAgain() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().fullscreen();

        Thread.sleep(2000);
        WebElement money = driver.findElement(By.id("draggable"));
        WebElement bank = driver.findElement(By.id("droptarget"));

        actions.moveToElement(money).clickAndHold().moveToElement(bank).release().build().perform();

        Thread.sleep(2000);

    }

    //todo
    //https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml


}
