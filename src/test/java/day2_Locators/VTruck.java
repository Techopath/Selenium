package day2_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VTruck {

    /*
    User Story: As a user, I should be able to login Vytrack app.
    =-----------------------------------==========================================
    Test scenario: 1. Verify that only authorized user can login to vytrack app.
                    2.
    test case1: Happy path.
    1. go toVyTrack login page
    2. write username data: storemanager52
    3. write password "UserUser123"
    4. click login button
    5. verify that the user is at home page
    -----------------------------------------------------------------------------------

    Test scenario: Verify that a person with wrong credentials cannot login to vytrack.
    Negative test case2:
    1. go to login page
    2. write invalid user name
    3. write valid or invalid password
    4. click login button
    5. verify that user sees "wrong credentials" message


     */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://app.vytrack.com/user/login");


        driver.findElement(By.id("prependedInput")).sendKeys("storemanager52");

        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");

        WebElement logInButton = driver.findElement(By.id("_submit"));

        logInButton.click();

        /*
        Verify that you are in the home page


         */

        String expectedUrlTitle = "Dashboard";

        String actualUrlTitle = driver.getTitle();
        if(expectedUrlTitle.equals(actualUrlTitle)){
            System.out.println("We verified that we are at home page");
        }else{
            System.out.println("We are not at home page");
        }

        String expectedUrl = "https://app.vytrack.com/";
        String actualUrl = driver.getCurrentUrl();

        if(expectedUrl.equals(actualUrl)){
            System.out.println("We are at Right home page");
        }else{
            System.out.println("Not at home page");
        }

        driver.close();

    }


}
