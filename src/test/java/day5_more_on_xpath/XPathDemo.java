package day5_more_on_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XPathDemo {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //open browser
       driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //represents an element from web page
        //where the elements come from --> from the findelement methods
        //how findelement finds elements --> using locators such as id, className, tagName, xpath, link text ..
        WebElement buttonOne = driver.findElement(By.xpath("//button[@onclick = 'button1()']"));

        //start interacting with the element
        String txt = buttonOne.getText();
        System.out.println(txt);

//
        WebElement buttonTwo = driver.findElement(By.xpath("//h3/following-sibling::button[2]"));
        System.out.println(buttonTwo.getText());

        WebElement buttonThree = driver.findElement(By.xpath("//button[3]"));
        System.out.println(buttonThree.getText());

        WebElement buttonFour = driver.findElement(By.xpath("//div/button[4]"));
        System.out.println(buttonFour.getText());


        WebElement buttonFive = driver.findElement(By.xpath("//button[.='Button 5']"));
        System.out.println(buttonFive.getText());

        WebElement buttonSix = driver.findElement(By.xpath("button[@id='disappearing_button']"));
        //element.getAttribute("value") --. method to get text from element, used with input boxes
        //get text of element
        System.out.println(buttonSix.getAttribute("innerHTML"));
        // if none of them works, use outerHTML

        System.out.println(buttonSix.getAttribute("outerHTML"));


    }
}
