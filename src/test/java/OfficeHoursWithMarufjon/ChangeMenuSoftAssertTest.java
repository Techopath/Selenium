package OfficeHoursWithMarufjon;

import com.cybertek.base.VytrackTestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Assert.*;
import org.testng.annotations.Test;

public class ChangeMenuSoftAssertTest extends VytrackTestBase {

    /*
    1. go to vytrack
    2. verify we are logged in
    3. change menu to vehicles and verify title
    4. change menu to customers and verify title
     */

    @Test
    public void testMenuOptions() throws InterruptedException {
        loginPage.login(ConfigurationReader.getProperty("driver_username"),
                ConfigurationReader.getProperty("driver_password"));

        Assert.assertNotEquals(driver.getCurrentUrl(),"http://qa3.vytrack.com/user/login","url did not match");

        dashboardPage.changeMenu("Fleet","Vehicles");
        Thread.sleep(2000);
        softAssert.assertTrue(driver.getTitle().contains("Car"),"Vehicle page title mismatch");

        wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.fleet));
        dashboardPage.changeMenu("Customers", "Accounts");
        Thread.sleep(2000);

        
        softAssert.assertTrue(driver.getTitle().contains("Accounts"),"");
    }

}
