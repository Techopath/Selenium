package MyAutomation_Codes;

import com.cybertek.utilities.WebDriverFactory;
import com.sun.org.apache.xalan.internal.xsltc.dom.AdaptiveResultTreeImpl;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.concurrent.TimeUnit;

public class MyGmail {

    /*
    go to gmail.com login page
    locate email username box and sendKeys : musadam@gmail.com
    Locate next button
    Locate password box

     */

    public static void main(String[] args) throws InterruptedException {

        WebDriver taxi = WebDriverFactory.getDriver("chrome");

        taxi.get("https://outlook.live.com/owa/");
        Thread.sleep(1000);
        taxi.findElement(By.xpath("/html/body/header/div/aside/div/nav/ul/li[2]/a")).click();
        Thread.sleep(1000);
        taxi.findElement(By.xpath("//*[@id=\"i0116\"]")).sendKeys("musadam02@hotmail.com");
        Thread.sleep(1000);
        taxi.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
        Thread.sleep(3000);
        taxi.findElement(By.xpath("//*[@id=\"i0118\"]")).sendKeys("alhamdulilah1");
        Thread.sleep(3000);
        taxi.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
        Thread.sleep(2000);

//        taxi.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div[1]/div[1]/div[2]/div/div[1]/div/div[2]/div[1]/div/span")).click(); //clicks klasor file
//        Thread.sleep(3000);
//        taxi.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div[1]/div[1]/div[2]/div/div[1]/div/div[2]/div[2]/div/span[1]")).click(); //clicks gelen kutusu


//        taxi.findElement(By.xpath("//*[@id=\"id__3\"]")).click();
//        Thread.sleep(2000);
//
        WebElement ileti = taxi.findElement(By.xpath("//*[@id=\"id__3\"]"));
         ileti.sendKeys("musadam28@gmail.com");
        Thread.sleep(3000);
        taxi.findElement(By.xpath("//*[@id=\"subjectLine0\"]")).sendKeys("aha from selenuim");
        Thread.sleep(3000);
        taxi.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div[1]/div[3]/div[2]/div/div[3]/div[1]/div/div/div/div[1]/div[2]/div[1]")).sendKeys("aheee from selenuim to you aheeee");
        Thread.sleep(3000);
        taxi.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div[1]/div[3]/div[2]/div/div[3]/div[1]/div/div/div/div[1]/div[3]/div[2]/div[1]/button[1]/span")).click();
//        taxi.close();

    }
}
