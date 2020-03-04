package Selenium_OH_Myroslava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class SeleniumOH1 {
    public static void main(String[] args) {
        ArrayList<String> keysToSearch = new ArrayList<>();
        keysToSearch.add("fruits");
        keysToSearch.add("veggies");
        keysToSearch.add("berries");

        Iterator<String> iterator = keysToSearch.iterator();
        //iterator() -> returns Iterator type which we can use with all iterator methods

        //[fruits, veggies, berries]
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //print before modification and
        //add * to each string and print again
        //[fruits, veggies, berries]

        Iterator<String> iterator1 = keysToSearch.iterator();
        while (iterator1.hasNext()) {
            String item = iterator1.next();
            System.out.println(item);
            System.out.println("* " + item);
        }

        //create a map with <String, String>

        HashMap<String, String> personalInfo = new HashMap<>();
        personalInfo.put("name", "Bryan");
        personalInfo.put("student id", "22334455");
        personalInfo.put("major", "computer science");

        Iterator<String> mapIterator2 = personalInfo.keySet().iterator();

        while (mapIterator2.hasNext()) {
            String key = mapIterator2.next();
            System.out.println(key + " : " + personalInfo.get(key));
        }

        //======================================
        //selenium
        /*
        id -> always it is unique- [but not always available].
        class-classname
        name
        tag -> every element will have a tag

        will only work with the link
        linktext
        partial linktext

        locator that is using html (syntax)
        css
        xpath

        input -as a tag
        id = "global-enhancement-search-query" - one of the attributes.
        we can use id to locate element



         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://etsy.com");

        WebElement searchBar = driver.findElement(By.id("global-enhancement-search-query"));
        //findElement() -> return WebElement
        //as parameter we put By.locator

        //(id, name, classname, class, .....)


    }
    }
