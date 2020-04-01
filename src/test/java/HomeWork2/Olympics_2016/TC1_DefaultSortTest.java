package HomeWork2.Olympics_2016;

import com.sun.org.apache.xalan.internal.xsltc.dom.AdaptiveResultTreeImpl;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC1_DefaultSortTest{
    /*
    Test Case 1: DEFAULT SORT TEST
1. Go to website
https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table.
2. Verify that by default the Medal table is sorted by rank. To do that you need
to capture all the cells in the Rank column and check if they are in
ascending order (highlighted in the picture).
3. Click link NOC.
4. Now verify that the table is now sorted by the country names. To do that you
need to capture all the names in the NOC column and check if they are in
ascending/alphabetical order (highlighted in the picture).
5. Verify that Rank column is not in ascending order anymore.
www.cybertekschool.com training@cybertekschool.com
2
Note 1: Countries names are actually links.
Note 2: Certain rows should not be included in the
calculation. Ignore the rows highlighted red in the
picture.
     */
    WebDriver driver;
    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //go to website
        driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table.");
        //locate table element
        WebElement table = driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']"));
        //System.out.println(table.getText());

        WebElement tableCol = driver.findElement(By.xpath("(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter'])/thead/tr/th[1]"));
        System.out.println("tableCol = " + tableCol.getText());

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement tableRows = driver.findElement(By.xpath("(//table[@class ='wikitable sortable plainrowheaders jquery-tablesorter'])/tbody/tr[2]/td[1]"));
        System.out.println("tableRows.getText() = " + tableRows.getText());

        //find rows size
        List<WebElement> rowsElements = driver.findElements(By.xpath("(//table[@class ='wikitable sortable plainrowheaders jquery-tablesorter'])/tbody/tr"));
        System.out.println("rowsElements.size() = " + rowsElements.size());
       //define column size

        List<WebElement> colElements = driver.findElements(By.xpath("(//table[@class ='wikitable sortable plainrowheaders jquery-tablesorter'])/thead/tr/th"));

        System.out.println("colElements.size() = " + colElements.size());

        List<String> rowsValues = new ArrayList<>();

        WebElement cell = driver.findElement(By.xpath(getCellByIndex(2,1)));
        System.out.println(getCellByIndex(5,1));
    }

    //a method that returns xpath string for a cell in the table
    public String getCellByIndex(int x, int y){

        String xpath = "(//table[@class ='wikitable sortable plainrowheaders jquery-tablesorter'])/tbody/tr["+x+"]/td["+y+"]";
        return xpath;

    }







}
