package day12_pops_tabs_alerts_iframes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PopupAndAlertsExamples {

    WebDriver driver;
    @BeforeTest
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
          driver.quit();
    }

    @Test
    public void htmlPopup() throws InterruptedException {
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

        WebElement button = driver.findElement(By.xpath("//span[text()='Destroy the World']"));
        Thread.sleep(1000);
        button.click();
        Thread.sleep(1000);
        WebElement no = driver.findElement(By.xpath("//span[.='No']"));
        no.click();

    }
    //red alerts :
    @Test
    public void jsAlertsAccept(){

        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        WebElement button1 = driver.findElement(By.xpath("//button[1]"));

        button1.click();

        Alert alert = driver.switchTo().alert(); //when we say Alert alert = new Alert() it doesn't work, instead we use the one we wrote here.
        alert.accept();
    }

    @Test
    public void jsAlertsCancel() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        WebElement button2 = driver.findElement(By.xpath("//button[2]"));

        button2.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert(); //when we say Alert alert = new Alert() it doesn't work.
        alert.dismiss();
    }

    @Test
    public void jsAlertsSendKeys() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        WebElement button3 = driver.findElement(By.xpath("//button[3]"));

        //button3.click();
        Thread.sleep(2000);
        Alert alert = null;
        try{
            alert = driver.switchTo().alert(); //when we say Alert alert = new Alert() it doesn't work.
            alert.sendKeys("Admiral Marufjon");
            alert.accept();
        }catch (NoAlertPresentException e){
            e.printStackTrace();
        }

    }

}
