package day3_locators2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyLogin {
    public static String url = "https://practice.cybertekschool.com/login";

    /*
    go to login page of practice.cybertekschool.com
    enter username
    enter password
    click login button
    Verify the welcome message "Welcome to the secure Are. When you are done clock logout button.

Enter tomsmith for the username and SuperSecretPassword for the password.
     */

    public static void main(String[] args) throws InterruptedException {



        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://practice.cybertekschool.com/login");
        /*
        <input type="text" name="username">
         */
        /*
<button id="details-button" class="secondary-button small-link">
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

        Thread.sleep(2000);
        WebElement username = driver.findElement(By.name("username"));

        username.sendKeys("tomsmith");
/*
<input type="password" name="password">
 */     Thread.sleep(2000);
        WebElement password = driver.findElement(By.name("password"));

        password.sendKeys("SuperSecretPassword");
/*
<button class="btn btn-primary" type="submit" id="wooden_spoon">Login</button>
 */     Thread.sleep(2000);
        WebElement loginButton = driver.findElement(By.id("wooden_spoon"));

        loginButton.click();

//Locating the welcome message with tagname
        /*
        <h4 class="subheader">Welcome to the Secure Area. When you are done click logout below.</h4>
         */

        WebElement welcomeMessage = driver.findElement(By.tagName("h4"));
        //Verify the welcome message
        //expected vs actual

        String expectedResultAtHomePage = "Welcome to the Secure Area. When you are done click logout below.";

        //String vs WebElement
        //getText() - > converts webElement to string
        String actualResultAtHomePage = welcomeMessage.getText();

        if(expectedResultAtHomePage.equals(actualResultAtHomePage)){
            /*
            <i class="icon-2x icon-signout"> Logout</i>*/
//            WebElement logout = driver.findElement(By.className(""));
//            logout.click();

            System.out.println("passed");
        }else{
            System.out.println("You are not at home page!");
        }



    }
}
