package day4_Xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextMethodOfXPath {

    /*
    got to http://practice.cybertekschool.com/context_menu
    verify Context Menu is on the page
     */
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/context_menu");

        WebElement textMethod = driver.findElement(By.xpath("//h3[text()='Context Menu']"));
        String actual = textMethod.getText();
//*[@id="content"]/div/h3
        String expected = "Context Menu";
        if(actual.equals(expected)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
            System.out.println("expected = " + expected);
            System.out.println("actual = " + actual);
        }




    }
}
