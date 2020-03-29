package Office_hours2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.*;

public class SelectClassPracticeTests {

    WebDriver driver;
    @BeforeTest
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
      //  driver.quit();
    }
    /*
    1.go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellTable
    2. verify that table has dropdown with values Family, Friends Coworkers, Businesses, Contacts

     */

    @Test
    public void test() throws InterruptedException {
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellTable");
        Thread.sleep(2000);
        Select categories = new Select(driver.findElement(By.cssSelector("select[tabindex='-1']")));
    //getOptions() --> gives all available options as a list
      List<WebElement> allOptionsEl = categories.getOptions();

        System.out.println("number of options: "+allOptionsEl.size());

        List<String> expectedOptions = Arrays.asList("Family", "Friends","Coworkers", "Businesses","Contacts");
        //

        //given a list of elements, extract the text of the elements into new list of strings

        List<String> allOptionsStr = BrowserUtils.getElementsText(allOptionsEl);
        Assert.assertEquals(allOptionsStr, expectedOptions);

        System.out.println("allOptionsStr = " + allOptionsStr);

        /*
        1.go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellTable
        3. select option Coworkers
    4. verify that Coworkers is now selected
    5. select options Contacts
    6. verify that contacts is selected
         */
    }
    @Test
    public void test2() throws InterruptedException {
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellTable");
        Thread.sleep(2000);
        Select categories = new Select(driver.findElement(By.cssSelector("select[tabindex='-1']")));

        //select option Coworkers
        categories.selectByVisibleText("Coworkers");

        //verify that Coworkers is now selected .
        //getFirstSelectedOption -- returns the currently selected option
        String actual = categories.getFirstSelectedOption().getText();
       Assert.assertEquals(actual,"Coworkers");

        //select option Contacts
        Thread.sleep(3000);
        driver.navigate().refresh();
        Select category = new Select(driver.findElement(By.cssSelector("select[tabindex='-1']")));

        category.selectByVisibleText("Contacts");

        //verify that Contacts is selected
        String actualStr = categories.getFirstSelectedOption().getText();
        Assert.assertEquals(actualStr,"Contacts");




    }

    @Test
    public void test3(){
        driver.get("http://practice.cybertekschool.com/dropdown");
        Select days = new Select(driver.findElement(By.id("day")));

        List<WebElement> options = days.getOptions();

        System.out.println("options.size() = " + options.size());
        //I have list of web elements, i need to verify if the values are sorted in ascending order

        List<String> stringList = BrowserUtils.getElementsText(options);

        List<Integer> ints = new ArrayList<>();

        for (String s : stringList) {
            ints.add(Integer.parseInt(s));

        }

        System.out.println(ints);

        //verify list of ints is sorted
        //create a new class with values of givern list

        List<Integer> intsCopy = new ArrayList<>(ints);

        Collections.sort(intsCopy);

        Assert.assertEquals(ints,intsCopy);
        System.out.println("sorted");


//        String sorted = "sorted";
//        for (int i = 0; i < ints.size(); i++) {
//           Assert.assertEquals(ints.get(i), i+1);
//        }
//        System.out.println(sorted);






    }



}
