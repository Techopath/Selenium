package day17_ddt_dataprovider_pom2;

import com.cybertek.pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*
When you are running the same kind of tests with different
data, this means Data Driven Testing(DDT).
In other words, Data driven Testing is executing the same
test with different values.
 */

public class UserInfoDataDriverTests {

    //we can insert getUsers in dataProvider too, hen no need for @DataProvider to have name.

    /*, dataProviderClass = LoginPage.class/* --> we use this when our data provider is in another class.*/
    @Test(dataProvider = "users" /*, dataProviderClass = LoginPage.class*/) //we will provide data from DataProvider below
    public void test(String username, String password, int number){
        System.out.println("opening application");
        System.out.println("login as: "+username);
        System.out.println("Number is: "+number);
        System.out.println("verify info: ");
    }

    @DataProvider(name = "users")
    public Object[][] getUsers(){ //in data provider, we need to have Object

        return new Object[][]{
                {"user1","UserUser123",25},
                {"salesmanager110","UserUser123", 26},
                {"storemanager110","UserUser123", 26},
                {"salesmanager400","UserUser123", 26}
        };
    }

}
