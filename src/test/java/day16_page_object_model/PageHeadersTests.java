package day16_page_object_model;

import com.cybertek.base.TestBase;
import com.cybertek.base.VytrackTestBase;
import com.cybertek.pages.DemoPage;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import org.openqa.selenium.interactions.Actions;

public class PageHeadersTests extends VytrackTestBase {
    /*
    1. go to vytrack
    2. login as a driver
    3. verify header is "Dashboard"
    4.
   */
    @Test
    public void dashboardPageTest(){
        String username = ConfigurationReader.getProperty("driver_username");
        String password = ConfigurationReader.getProperty("driver_password");

        loginPage.login(username,password);

        DashboardPage dashboardPage = new DashboardPage();
        wait.until(ExpectedConditions.textToBePresentInElement(dashboardPage.pageHader,"Quick Launchpad"));

        String actual = dashboardPage.pageHader.getText();

        assertEquals(actual,"Quick Launchpad");

    }
    /*

    --------------------------------
    1. go to vytrack
    2. login as a driver
    3. go to fleet manager
    3. verify header is "All cars"
    4.
     */

    @Test
    public void fleetVehiclesTest() throws InterruptedException {

        //use login to log in
        String username = ConfigurationReader.getProperty("driver_username");
        String password = ConfigurationReader.getProperty("driver_password");
        loginPage.login(username,password);

        //use dashboard change page
        wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.fleet));
        dashboardPage.fleet.click();
        wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.vehicles));
        dashboardPage.vehicles.click();

        //use the fleet/vehicles to get text
        wait.until(ExpectedConditions.textToBePresentInElement(vehiclesPage.pageHader,"Cars"));
        String actual = vehiclesPage.pageHader.getText();
        assertEquals(actual,"Cars");



    }

    @Test
    public void test(){
        DemoPage demoPage =new DemoPage(driver);

    }


}
