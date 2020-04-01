package day11_select_class;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SelectClassTest {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");



    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        //driver.quit();
    }
    @Test
    public void getSelectedOption(){
        //To interact with a dropdown we create an object of Select class.
        // Creating select class object involves two steps:
        //1. Find the dropdown web element using driver.findElement() method
        //2.Sreate a select class object by using the web element from step 1 as
        //a constructor

        //find the element that has select tag
        WebElement dropdown = driver.findElement(By.id("dropdown"));

        //
        Select dropdownList = new Select(dropdown);
        //we use select method when there is select in web element

        //get the selected option

        WebElement firstSelectedOption = dropdownList.getFirstSelectedOption();

        System.out.println(firstSelectedOption.getText());
        //verify
        Assert.assertEquals(firstSelectedOption.getText(), "Please select an option");
    }
    @Test
    public void selectFromList() throws InterruptedException {
        //get the element with select tag
        WebElement dropdown = driver.findElement(By.id("state"));

        //create select class
        Select states = new Select(dropdown);
       //selectByVisibleText(0 --> selects by visible text
        states.selectByVisibleText("Iowa"); //selects the state by text
        Thread.sleep(1000);
        states.selectByVisibleText("Kentucky");
        Thread.sleep(1000);
        states.selectByVisibleText("Vermont");
        Thread.sleep(1000);
        states.selectByVisibleText("Virginia");

        // TODO selectByIndex --> selects based on the index of the option, 0 based count
        states.selectByIndex(0);
        Thread.sleep(1000);
        states.selectByIndex(10);
        Thread.sleep(1000);
        states.selectByIndex(20);
        Thread.sleep(1000);

        // TODO selectByValue--> selects based on the value of the value attribute of the option
        // TODO selectByValue --> it is not select text
        states.selectByValue("VA");
        Thread.sleep(1000);
        states.selectByValue("SC");
        Thread.sleep(1000);
        states.selectByValue("CO");
        Thread.sleep(1000);
        states.selectByValue("NE");
    }
    @Test
    public void getAllAvailableOptions(){
        Select monthList = new Select(driver.findElement(By.id("month")));

        //print the current selection

        System.out.println(monthList.getFirstSelectedOption().getText());

        //TODO getOptions --> returns all of the available options from dropdown

        List<WebElement> allOptions = monthList.getOptions();
        System.out.println("Number of monthes: "+allOptions.size());
        //type iter it will automatically opens roe ech loop
        for (WebElement month : allOptions) {
            System.out.println(month.getText());
        }
//        WebElement monthDropDown = driver.findElement(By.id("month"));
//        System.out.println(monthDropDown.getText()); //this way works too.
        //verify that months list always show the current month.
        //get the current month
//        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
//        Date date = new Date(System.currentTimeMillis());
//        System.out.println(formatter.format(date)); //one way
        String expected = LocalDate.now().getMonth().name();
        System.out.println(expected);
        String actual = monthList.getFirstSelectedOption().getText();
        Assert.assertEquals(actual.toLowerCase(),expected.toLowerCase());
        //verify that months list has following values : January ... December
        List<String> expectedMonths = Arrays.asList("January", "February", "March", "April", "May",
                "June", "July","August", "September","October","November","December");
        //get options gives me list webElements, so allOptions is a list of web element
        //but my expected is a list strings. I have to make sure both are list of strings.
        //i need to get list string from list of webelements
        List<String> actualMonths = new ArrayList<>();
        for (WebElement option : allOptions) {
            actualMonths.add(option.getText());
        }
        Assert.assertEquals(actualMonths,expectedMonths);
    }

    @Test
    public void verifyOptions(){
        Select list = new Select(driver.findElement(By.id("dropdown")));

        //verify that list has three options
        int expectedSize = 3;
        int actualSize = list.getOptions().size(); //getOptions() -->gives list of web elements

        List<String> expectedValues = Arrays.asList("Please select an option", "Option 1", "Option 2");

        List<String> actualValues = new ArrayList<>();
        for (WebElement option : list.getOptions()) {
            actualValues.add(option.getText());
            //System.out.println(option.getText());
        }
//        System.out.println("-----------------");
//        System.out.println(actualValues.toString());
        Assert.assertEquals(expectedValues,actualValues); //asserts if the values equal index by index



    }



}
