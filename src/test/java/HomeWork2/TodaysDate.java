package HomeWork2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TodaysDate {

    /*
    TODAYS DATE
1. go to http://practice.cybertekschool.com/dropdown
2. verify that dropdowns under Select your date of birth display current year, month, day
     */
    WebDriver driver;
    WebDriverWait wait;
    @BeforeTest
    public void beforeTest(){
        driver = WebDriverFactory.getDriver("chrome");

    }

    @Test
    public void testTodaysDate(){
        driver.get("http://practice.cybertekschool.com/dropdown");

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        WebElement month = driver.findElement(By.id("month"));
        Select selectMonth = new Select(month);
        String actualMonth = selectMonth.getFirstSelectedOption().getText().toUpperCase();

        //get all months with their corresponding month int values
        List<WebElement> months = selectMonth.getOptions();
        Map<String, Integer> monthsMap = new HashMap<>();

        for (WebElement webElement : months) {
            monthsMap.put(webElement.getText(), Integer.parseInt(webElement.getAttribute("value")));

        }
        System.out.println("monthsMap = " + monthsMap);

//        //get all months in dropDown as a List
        List<WebElement> monthsElements = selectMonth.getOptions();
        List<String> monthsList = new ArrayList<>();
        for (WebElement webElement : monthsElements) {
            monthsList.add(webElement.getText());
            monthsList.add(webElement.getAttribute("value"));

        }
        System.out.println("monthsList = " + monthsList);


        String expectedMonth = LocalDate.now().getMonth().name();

        Assert.assertEquals(actualMonth,expectedMonth);
        System.out.println("Month is the same as currents month: "+expectedMonth);

        WebElement day = driver.findElement(By.id("day"));

        Select selectDay = new Select(day);

        Integer expectedDay = LocalDate.now().getDayOfMonth();

        String actualDay = selectDay.getFirstSelectedOption().getText();
        Integer actualDayCasted = Integer.parseInt(actualDay);
        Assert.assertEquals(actualDayCasted,expectedDay);

        System.out.println("Day is as today's day: "+expectedDay);

        WebElement year = driver.findElement(By.id("year"));

        Select selectYear = new Select(year);

        String actualYear = selectYear.getFirstSelectedOption().getText();
        String expectedYear = String.valueOf(LocalDate.now().getYear()); //String.valueOf() method converts a number into String

        Assert.assertEquals(actualYear,expectedYear);
        System.out.println("Year is as "+ expectedYear);

        String date = DateUtility.getDate();
        System.out.println("date = " + date);

        System.out.println("Actual month letters is converted to upperCase. ");
        System.out.println("Actual Date: = "+actualYear +" / "+actualMonth +" / "+actualDay);
        System.out.println("Expected Date: = "+expectedYear +" / "+expectedMonth +" / "+expectedDay);


    }
}
