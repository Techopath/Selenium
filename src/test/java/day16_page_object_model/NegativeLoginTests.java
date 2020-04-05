package day16_page_object_model;

import com.cybertek.base.TestBase;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NegativeLoginTests extends TestBase {
    LoginPage loginPage;
    @BeforeMethod
    public void setUpTests(){
        driver.get(ConfigurationReader.getProperty("vytrack_url")); //if we use new url without deleting the previous one we use thus
        loginPage = new LoginPage();

    }

    @Test
    public void wrongUserNameTest(){
       // driver.get(ConfigurationReader.getProperty("vytrack_url")); //if we use new url without deleting the previous one we use thus

//if we don't create LoginPage class, we would write the following each time we are finding a webelement
//        WebElement username = driver.findElement(By.id("predpendedInput"));
//        username.sendKeys("sakelhahfasdf");

        //LoginPage loginPage = new LoginPage();
        loginPage.username.sendKeys("alesmanager110");
        loginPage.password.sendKeys("UserUser123");
        loginPage.logIn.click();

        String actual = loginPage.errorMessage.getText();
        Assert.assertEquals(actual,"Invalid user name or password.");
   // try{
    Assert.assertTrue(loginPage.errorMessage.isDisplayed());

   // } catch (Exception e){
//    e.printStackTrace();
//    System.out.println("credentials great");
//    }

    }

    @Test
    public void wrongPasswordTest(){
        //driver.get(ConfigurationReader.getProperty("vytrack_url")); //if we use new url without deleting the previous one we use thus
        //LoginPage loginPage = new LoginPage(); //we took these two repeatable into beforeMethod

        loginPage.username.sendKeys("salesmanager110");
        loginPage.password.sendKeys("LC");
        loginPage.logIn.click();

        String actual = loginPage.errorMessage.getText();
        Assert.assertEquals(actual,"Invalid user name or password.");
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());


    }
}
