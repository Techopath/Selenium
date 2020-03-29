package day7_Review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonCssExample {


    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://amazon.com");
        /*<a href="/gp/goldbox?ref_=nav_cs_gb_azl" class="nav-a  " tabindex="47">Today's Deals</a>
        #nav-xshop > a:nth-child(2)
         */

        //tag[@att ='value'] in xpath
        // tag[att = 'value]
        //a[tabindex='47]

        WebElement todaysDeals = driver.findElement(By.cssSelector("a[tabindex='47']"));
        todaysDeals.click();

        String expected = "Today's Deals";
        /*
        <span class="nav-a-content">
      Today's Deals

    </span>
         */

        WebElement topHeader = driver.findElement(By.cssSelector(".nav-a-content"));
        System.out.println(topHeader.getText());

        if (expected.equals(topHeader.getText())){
            System.out.println("pass");
        }else{
            System.out.println("fail");
            System.out.println("expected = "+expected);
            System.out.println("topHeader = " + topHeader.getText());
        }
        WebElement bottomHeader = driver.findElement(By.cssSelector("#gbox-item-0\\.0\\.0 > div > div > div.gbh1 > h1 > div.gbh1-bold"));
        System.out.println(bottomHeader.getText());

        if (expected.equals(topHeader.getText())){
            System.out.println("pass");
        }else{
            System.out.println("fail");
            System.out.println("expected = "+expected);
            System.out.println("topHeader = " + topHeader.getText());
        }
    }
}
