package MyAutomation_Codes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FacebookLogin {
    public static void main(String[] args) throws InterruptedException {
        /*
        1. go to facebook.com
        2. write username: musadam02@hotmail.com
        3. write password:
        4. click login

         */
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();
        driver.get("https://facebook.com");
        //

        Thread.sleep(3000);

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("musadam02@hotmail.com");

        Thread.sleep(3000);
        WebElement password = driver.findElement(By.id("pass"));
        password.sendKeys("Bilkent#06");
        Thread.sleep(3000);
        WebElement login = driver.findElement(By.id("u_0_b"));
        login.click();


    }
}
