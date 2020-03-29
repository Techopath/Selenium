package day13_waits_and_synchronization;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ExplicitWaitExamples {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        wait = new WebDriverWait(driver, 10);

    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void test1TitleTest() {


        System.out.println(driver.getTitle());

        driver.get("https://steam.com");
        driver.get("https://store.steampowered.com/");

        // wait for the title of the second page
        // create web object
        wait = new WebDriverWait(driver, 10);
        // start waiting for title contain text
        wait.until(ExpectedConditions.titleContains("Steam"));

        System.out.println(driver.getTitle());

        //break till 2.10
    }

    @Test
    public void test2WaitForVisible(){

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        WebElement button = driver.findElement(By.tagName("button"));

        button.click();

        WebElement username = driver.findElement(By.id("username"));
        WebElement pass = driver.findElement(By.id("pwd"));
        //
        wait.until(ExpectedConditions.visibilityOf(username));
        //
        Assert.assertTrue(username.isDisplayed());
        username.sendKeys("johndoe");


    }

    //this will throw TimeoutException:
    @Test
    public void test3WaitForVisibleFail(){

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        WebElement button = driver.findElement(By.tagName("button"));

        button.click();

        WebElement username = driver.findElement(By.id("username"));
        WebElement pass = driver.findElement(By.id("pwd"));
        //
        //give not enough time
        wait.withTimeout(Duration.ofSeconds(2));

        //wait for given element to be visible on page.
        wait.until(ExpectedConditions.visibilityOf(username));
        //
        Assert.assertTrue(username.isDisplayed());
        username.sendKeys("johndoe");


    }

    @Test
    public void test4WaitForClickable(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/6");

        WebElement username = driver.findElement(By.id("username"));

        WebElement pass = driver.findElement(By.id("pwd"));
        WebElement submit = driver.findElement(By.tagName("button"));

        Assert.assertTrue(username.isDisplayed());
        username.sendKeys("tomsmith");
        pass.sendKeys("SuperSecretPassword"); //ElementClickInterceptedException

        // wait until the element disappears
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector("div[class='loadingoverlay']"))));


        // waits for givi=en element to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(submit));

        submit.click();
    }

    @Test
    public void test4WaitForVisible(){
        driver.manage().window().fullscreen();
        driver.get("http://qa3.vytrack.com");
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("salesmanager110");
        WebElement pass = driver.findElement(By.id("prependedInput2"));
        pass.sendKeys("UserUser123");
        pass.submit();
        driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS); //doesn't work
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //works
        WebElement myCalendar = driver.findElement(By.linkText("My Calendar"));
        // wait until the element with class loader-mask is not visible.
        //WebElement overlay = driver.findElement(By.cssSelector(".loader-mask"));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loader-mask"))); //works too
        myCalendar.click();
    }

    @Test
    public void test5Fluent(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/6");

    }

}
