package com.cybertek.base;

import com.cybertek.utilities.Driver;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

//in order nobody create an object of this class we will create it as an abstract class
public abstract class TestBase {
    //we are creating this class in order to put all the common codes in a place, so that
    //we will not write everything each time we create a class. we will just call the method

    //using protected only your children can see it.
    public WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        //driver = WebDriverFactory.getDriver("chrome");
        driver = Driver.getDriver();
    }
    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(1000);
        Driver.closeDriver();
    }


}
