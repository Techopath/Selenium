package HomeWork2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class W3Schools {

    /*
    LINKS
1. go to https://www.w3schools.com/
2. find all the elements in the page with the tag a
3. for each of those elements, if it is displayed on the page, print the text and the href of that
element.
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
    public void w3SchoolsTest(){

        //step 1
        driver.get("https://www.w3schools.com/");

        //step 2
        List<WebElement> a = driver.findElements(By.tagName("a"));

        List<String> aTagList = new ArrayList<>();
        System.out.println(aTagList.size());

        for (WebElement webElement : a) {
            //step 3
            if (webElement.isDisplayed()){
                aTagList.add(webElement.getText()+" = "+webElement.getAttribute("href"));

            }
        }
        System.out.println(aTagList);
        System.out.println("size: "+aTagList.size());
    }


    @Test
    public void yearsMonthsDaysTest(){
        /*
    YEARS, MONTHS, DAYS
1. go to http://practice.cybertekschool.com/dropdown
2. select a random year under Select your date of birth
3. select month January
4. verify that days dropdown has current number of days
5. repeat steps 3, 4 for all the months
NOTE: if you randomly select a leap year, verify February has 29 days
     */
       //1.step
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement year = driver.findElement(By.id("year"));
        Select select = new Select(year);
        //2.step
        Random random = new Random();
        int num = random.nextInt(select.getOptions().size());
        select.getOptions().get(num).click();
        System.out.println(select.getOptions().get(num).getText());
        //3.step
        WebElement month = driver.findElement(By.id("month"));
        select = new Select(month);
        String january = "";
        for (int i = 0; i <select.getOptions().size(); i++) {

            if(january.equalsIgnoreCase("january")){
                select.getOptions().get(i).click();
                january = select.getOptions().get(i).getText();
                break;
            }
        }
        WebElement days = driver.findElement(By.id("day"));
        select = new Select(days);
        int numOfDays = select.getOptions().size();
        System.out.println("numOfDays = " + numOfDays);
        Assert.assertEquals(numOfDays,31);
        System.out.println("There are "+numOfDays + " days in month "+january);
    }

    @Test
    public void yearsMonthDaysTest2(){
          /*
    YEARS, MONTHS, DAYS
1. go to http://practice.cybertekschool.com/dropdown
2. select a random year under Select your date of birth
3. select month January
4. verify that days dropdown has current number of days
5. repeat steps 3, 4 for all the months
NOTE: if you randomly select a leap year, verify February has 29 days
     */
        //1.step
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement year = driver.findElement(By.id("year"));
        Select select = new Select(year);
        //2.step
        Random random = new Random();
        int num = random.nextInt(select.getOptions().size());
        select.getOptions().get(num).click();
        System.out.println(select.getOptions().get(num).getText());
        //3.step

        for (int i = 0; i < select.getOptions().size(); i++) {
            if (i==12){
                return;
            }
            WebElement month = driver.findElement(By.id("month"));
            select = new Select(month);
            String monthName = "";
            System.out.println(select.getOptions().size());

                select.getOptions().get(i).click();
                monthName = select.getOptions().get(i).getText();
                System.out.println("monthName = " + monthName);
                // 4. step
                WebElement days = driver.findElement(By.id("day"));
                select = new Select(days);
                int numOfDays = select.getOptions().size();

                if (numOfDays >30){
                    System.out.println("numOfDays = " + numOfDays);
                    Assert.assertEquals(numOfDays,31);
                    System.out.println("There are "+numOfDays + " days in month "+monthName);
                }else if (numOfDays==30){
                    System.out.println("numOfDays = " + numOfDays);
                    Assert.assertEquals(numOfDays,30);
                    System.out.println("There are "+numOfDays + " days in month "+monthName);
                }else if (numOfDays ==28){
                    System.out.println("numOfDays = " + numOfDays);
                    Assert.assertEquals(numOfDays,28);
                    System.out.println("There are "+numOfDays + " days in month "+monthName);
                }else if (numOfDays ==29){
                    System.out.println("numOfDays = " + numOfDays);
                    Assert.assertEquals(numOfDays,29);
                    System.out.println("This is a special day!!! " +
                            "There are "+numOfDays + " days in month "+monthName +" in "+select.getOptions().get(num).getText());
                }

        }


    }
}
