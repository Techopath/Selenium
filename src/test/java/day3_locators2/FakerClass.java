package day3_locators2;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FakerClass extends VerifyLogin{

    public static void main(String[] args) throws InterruptedException {
        //create Faker object

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        Faker fakeData = new Faker();

        //I need firstName

        String name = fakeData.name().firstName();

        System.out.println(name);

        String username = fakeData.name().fullName();
        System.out.println(username);
        String password = fakeData.app().author();
        System.out.println(password);

        driver.get(url);
         /*<button id="details-button" class="secondary-button small-link">
                Advanced
                </button>
 */
        Thread.sleep(3000);
        WebElement advanced = driver.findElement(By.id("details-button"));
        advanced.click();

/*
<a href="#" id="proceed-link" class="small-link">Proceed to practice.cybertekschool.com (unsafe)</a>
 */
        Thread.sleep(3000);
        WebElement link = driver.findElement(By.id("proceed-link"));

        link.click();

        driver.findElement(By.name("username")).sendKeys(username);
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("wooden_spoon")).click();



        //driver.close();

    }
}
