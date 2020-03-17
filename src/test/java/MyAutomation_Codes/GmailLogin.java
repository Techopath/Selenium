package MyAutomation_Codes;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmailLogin {
    public static void main(String[] args) throws InterruptedException {

        //setup
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //find element locator in gmail.com email box.
        /*
        <input type="email" class="whsOnd zHQkBf" jsname="YPqjbf" autocomplete="username" spellcheck="false" tabindex="0" aria-label="Email or phone" name="identifier" value="" autocapitalize="none"
        id="identifierId" dir="ltr" data-initial-dir="ltr" data-initial-value="">
         */

        driver.get("https://gmail.com");
        Thread.sleep(2000);

        WebElement emailBox = driver.findElement(By.id("identifierId"));
        emailBox.sendKeys("musadam28@gmail.com");

        /*
        <div class="ZFr60d CeoRYc"></div>
        <span class="RveJvd snByac">Next</span> // for pushing next button
         */

        Thread.sleep(2000);
        WebElement nextButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/span/span"));
        nextButton.click();

        Thread.sleep(2000);

        WebElement password = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[1]/div/div/div/div/div[1]/div/div[1]/input"));
        password.sendKeys("alhamdulilah1");

        Thread.sleep(2000);

        WebElement next = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/span/span"));
        next.click();





    }
}
