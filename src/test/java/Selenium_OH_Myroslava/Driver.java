package Selenium_OH_Myroslava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver {

    private static WebDriver driver;
    private Driver(){} //constructor
    public static WebDriver getDriver(String browser){
        if(driver == null) {
            browser = browser.toLowerCase();
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    // ChromeOptions chromeOptions = new ChromeOptions().setHeadless(true);
                    return new ChromeDriver();
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    return new FirefoxDriver();
                case "chrome_headless":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions().setHeadless(true);
                    //set capabilities -- DesiredCapabilities --> extensions, proxy, platname
                    return new ChromeDriver(chromeOptions);
                case "firefox_headless":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions().setHeadless(true);
                    return new FirefoxDriver(firefoxOptions);
            }
        }
        return driver;
    }

    public static void quit() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
        // If the driver does not exist and you try to close it then you will get an error "Session does not exist"
    }

    // Example:
//    public static void main(String[] args) {
//        Driver.getDriver("chrome").findElement(By.id("sad")); //Initianlly its null
//
//        Driver.getDriver("chrome").findElement(By.id("sadasdas")); // its not null
//    }

}
