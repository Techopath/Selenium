package HomeWork2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CartAmazon {

    /*
    CART
1. go to https://amazon.com
2. search for "wooden spoon"
3. click search
4. remember the name and the price of a random result
5. click on that random result
6. verify default quantity of items is 1
7. verify that the name and the price is the same as the one from step 5
8. verify button "Add to Cart" is visible
     */

    WebDriver driver;
    @BeforeMethod
    public void beforeTest(){
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Congratulations!");

        //driver.quit();
    }

    @Test
    public void amazonCart() throws InterruptedException {
        //step 1
        driver.get("https://amazon.com");
        //step 2
        Thread.sleep(2000);
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("wooden spoon");

        Thread.sleep(2000);
        searchBox.submit();




//        List<WebElement> woodenSpoon = driver.findElements(By.tagName("span"));
//
//        List<String> wsList = new ArrayList<>();
//
//        for (WebElement webElement : woodenSpoon) {
//            if (webElement.getText().toLowerCase().contains("wooden spoon")){
//                wsList.add(webElement.getText());
//            }
//
//        }



//        Random ran = new Random();
////        for (int i = 0; i < woodenSpoon.size() ; i++) {
//            int num = ran.nextInt(wsList.size());
//
//            if (wsList.get(num).toLowerCase().contains("wooden spoon")){
//                Thread.sleep(4000);
//
//                String itemName = wsList.get(num);
//                System.out.println("itemName = " + itemName);
//                woodenSpoon.get(num).click();
//            }

//        }











    }

}
