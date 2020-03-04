package day1_Navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.awt.windows.ThemeReader;

/*how do you launch/open a web page?
* --by using get() --> url as a string.
*
* get() vs navigate().to()
* get -> wait to load the page
* navigate().to() -> does not wait*/
public class FirstClass {
    public static void main(String[] args) throws InterruptedException {
// binary the driver and browsers
        WebDriverManager.chromedriver().setup();

        //WebDriver object --> Interface
        //I have a driver now.
        WebDriver driver = new ChromeDriver();
// I want to open google home page.

        //driver.get("https://www.google.com");
        //driver.get("https://www.amazon.com");

        //Navigation
        //navigate().to() -> opens a web page
        //driver.navigate().to("https://www.amazon.com");

        //navigate().back()
        //driver.navigate().back();

        //test case: Go to google.com and then 2. go back to cybertek practice website.
        driver.get("https://www.facebook.com");
        Thread.sleep(500);
        driver.navigate().to("http://practice.cybertekschool.com/");
        Thread.sleep(500);
        driver.navigate().back();
//        WebElement q = driver.findElement(By.name("q"));
//        q.sendKeys(new String[]{"pencil"});
//        q.submit();
        //driver.findElement(By.linkText("Log in")).click();
//        driver.navigate().forward();
//        driver.navigate().refresh();





    }
}
