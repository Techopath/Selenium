package MyAutomation_Codes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmailLogin {
    public static void main(String[] args) throws InterruptedException {

        //setup
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

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
        WebElement nextButton = driver.findElement(By.className("ZFr60d CeoRYc"));
        nextButton.click();




    }
}
