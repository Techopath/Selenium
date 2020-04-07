package day17_ddt_dataprovider_pom2;

import com.cybertek.base.VytrackTestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class MenuOptionsTests extends VytrackTestBase {

    @Test
    public void test() throws InterruptedException {
        loginPage.login(ConfigurationReader.getProperty("driver_username"),
                ConfigurationReader.getProperty("driver_password"));

//        dashboardPage.changeMenu("Fleet","Vehicles");


        dashboardPage.changeMenu("Activities","Calendar Events");
        wait.until(ExpectedConditions.titleIs("Calendar Events - Activities"));
        assertEquals(driver.getTitle(),"Calendar Events - Activities");

        //Thread.sleep(2000);
        /*
        .ElementClickInterceptedException: element click intercepted:
        Element <span class="title title-level-1">...</span> is not clickable at point (337, 56).
        Other element would receive the click: <div class="loader-mask shown">...</div>
         */
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader-mask shown']")));
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        dashboardPage.changeMenu("System","Jobs");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader-mask shown']")));

        dashboardPage.changeMenu("Fleet","Vehicles");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader-mask shown']")));

        dashboardPage.changeMenu("Fleet","Vehicle Contracts");

    }

    @Test(dataProvider = "test-data")
    public void ddtTest(String menu1, String menu2, String expectedTitle) throws InterruptedException {

        loginPage.login(ConfigurationReader.getProperty("driver_username"),
                ConfigurationReader.getProperty("driver_password"));
        dashboardPage.changeMenu(menu1,menu2);
        wait.until(ExpectedConditions.titleContains(expectedTitle));
        assertTrue(driver.getTitle().contains(expectedTitle));
    }

    //DDT test
    @DataProvider(name = "test-data")
    public Object[][] getData(){
        return new Object[][]{
                {"Fleet","Vehicles","Car"},
                {"Fleet", "Vehicle Costs","Vehicle Costs"},
                {"Customers", "Contacts", "Contacts - Customers"},
                {"Activities", "Calendar Events","Calendar Events - Activities"},
                {"System","System Calendars", "System Calendars - System"}
        };
    }

/*
1. login as driver
2. verify that driver can see menu options Fleet, Customers, Activities, system
 */
    @Test
    public void testAllOptionsDriver(){
        loginPage.login(ConfigurationReader.getProperty("driver_username"),
                ConfigurationReader.getProperty("driver_password"));
        List<String> expected = Arrays.asList("Fleet","Customers", "Activities","System");

        List<String > actualList = BrowserUtils.getElementsText(dashboardPage.menu1Options);
        assertEquals(actualList,expected);

    }

}
