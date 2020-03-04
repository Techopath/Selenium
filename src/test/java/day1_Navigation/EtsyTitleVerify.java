package day1_Navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EtsyTitleVerify {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://etsy.com");
        // in order to verify we need expected and
        String expected_etsyTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";

        String actual_etsyTitle = driver.getTitle();

        if(expected_etsyTitle.equals(actual_etsyTitle)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
            System.out.println("Expected result is "+expected_etsyTitle);
            System.out.println("Actual result is "+actual_etsyTitle);
        }

        driver.close();
    }
}
