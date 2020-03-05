package day3_locators2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeValue {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://practice.cybertekschool.com/login");

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

        //driver.manage().window().fullscreen();

        // i want to get the value of type attribute
        // type ="text" getAttribute("attribute name");

        //locate username box

        WebElement username = driver.findElement(By.name("username"));

        //<input type="text" name="username">

        String valueOfType = username.getAttribute("type");

        System.out.println("valueOfType = " + valueOfType);
        /*<input type="password" name="password">*/

        // type="password" -> type is attribute and password is value of attribute.
        WebElement password = driver.findElement(By.name("password"));

        String valueOfType_password = password.getAttribute("type");
        System.out.println("valueOfType_password = " + valueOfType_password);

        /*
        <button class="btn btn-primary" type="submit" id="wooden_spoon">Login</button>

        class, type, id => are all attributes and the text inside quotation mark are their values.
         */

        WebElement login = driver.findElement(By.id("wooden_spoon"));
        System.out.println("login.getAttribute(\"class\") = " + login.getAttribute("class"));

        String valueOfType_login = login.getAttribute("class");
        System.out.println("valueOfType_login = " + valueOfType_login);

        //getText() vs getAttribute();
       /*
        getText() -> converts the webElement into string
        getAttribute() -> returns the value of attribute.
        */

    }
}
