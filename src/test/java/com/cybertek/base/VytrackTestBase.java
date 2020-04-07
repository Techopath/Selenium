package com.cybertek.base;

import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import day16_page_object_model.DashboardPage;
import day17_ddt_dataprovider_pom2.CreateCalendarEventsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;


public abstract class VytrackTestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected VehiclesPage vehiclesPage;


    //-----
    protected CreateCalendarEventsPage eventsPage;
    protected SoftAssert softAssert;
    @BeforeMethod
    public void setUpMethod() {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get(ConfigurationReader.getProperty("vytrack_url"));
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        vehiclesPage = new VehiclesPage();

        //-----
        eventsPage = new CreateCalendarEventsPage();
        softAssert = new SoftAssert();

    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(5000);
//        Driver.closeDriver();
//        softAssert.assertAll();
        softAssert.assertAll();
//        Thread.sleep(3000);
        Driver.closeDriver();
        softAssert.assertAll();
    }
}
