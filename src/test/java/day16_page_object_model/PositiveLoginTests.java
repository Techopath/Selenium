package day16_page_object_model;

import com.cybertek.base.TestBase;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.sun.org.apache.xalan.internal.xsltc.dom.AdaptiveResultTreeImpl;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PositiveLoginTests extends TestBase {
    WebDriverWait wait;
    LoginPage loginPage;
    @BeforeMethod
    public void setUpTests(){
        driver.get(ConfigurationReader.getProperty("vytrack_url"));
        loginPage = new LoginPage();
        wait = new WebDriverWait(driver,5);

    }

    @Test
    public void loginAsDriver(){
        String username = ConfigurationReader.getProperty("driver_username");
        String password = ConfigurationReader.getProperty("driver_password");
//        loginPage.username.sendKeys(username);
//        loginPage.password.sendKeys(password);
//        loginPage.logIn.click(); //i created a method inside LoginPage so that we don't repeat these lines

        loginPage.login(username,password);

        //wait for title page load completely
        wait.until(ExpectedConditions.titleIs("Dashboard"));

        String actualTitle = driver.getTitle();
        assertEquals(actualTitle,"Dashboard"); //instead of calling Assert.assertEquals each time, we imported Assert above.
    }

    @Test
    public void loginAsSalesManager(){
        String username = ConfigurationReader.getProperty("sales_manager_username");
        String password = ConfigurationReader.getProperty("sales_manager_password");
        loginPage.login(username,password);
        wait.until(ExpectedConditions.titleIs("Dashboard"));
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle,"Dashboard");
    }

    @Test
    public void loginAsStoreManager(){
        String username = ConfigurationReader.getProperty("store_manager_username");
        String password = ConfigurationReader.getProperty("store_manager_password");

        loginPage.login(username,password);
        wait.until(ExpectedConditions.titleIs("Dashboard"));
        String actualTitle = driver.getTitle();

        assertEquals(actualTitle,"Dashboard");

    }



}
