package HomeWork2.Olympics_2016;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
        //WebElement table = driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']"));
        //System.out.println(table.getText());

        WebElement tableCol = driver.findElement(By.xpath("(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter'])/thead/tr/th[1]"));
        System.out.println("tableCol = " + tableCol.getText());

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement tableRows = driver.findElement(By.xpath("(//table[@class ='wikitable sortable plainrowheaders jquery-tablesorter'])/tbody/tr[2]/td[1]"));
        System.out.println("tableRows.getText() = " + tableRows.getText());

//        WebElement nocLink = driver.findElement(By.linkText("Remaining NOCs"));
//        nocLink.click();


        //find rows size
        List<WebElement> rowsElements = driver.findElements(By.xpath("(//table[@class ='wikitable sortable plainrowheaders jquery-tablesorter'])/tbody/tr"));
        System.out.println("rowsElements.size() = " + rowsElements.size());
        //define column size

        List<WebElement> colElements = driver.findElements(By.xpath("(//table[@class ='wikitable sortable plainrowheaders jquery-tablesorter'])/thead/tr/th"));
        System.out.println("colElements.size() = " + colElements.size());

        List<Integer> rowsValues = new ArrayList<>();
        for (int i = 1; i < rowsElements.size(); i++) {
            String xpath = getCellByIndex(i,1);
            WebElement rowsV = driver.findElement(By.xpath(xpath));
            if(!rowsV.getText().startsWith("11")) {
                rowsValues.add(Integer.parseInt(rowsV.getText()));
            }
        }

        System.out.println(rowsValues);
        String asc = "";
        for (int i = 0; i <rowsValues.size()-1; i++) {
            if ((rowsValues.get(i+1)-rowsValues.get(i))==1){
                asc = "yes";
            }
        }
        System.out.println("ascending order? = " + asc);
    }

    //a method that returns xpath string for a cell in the table
    public String getCellByIndex(int x, int y){
        String xpath = "(//table[@class ='wikitable sortable plainrowheaders jquery-tablesorter'])/tbody/tr["+x+"]/td["+y+"]";
        return xpath;

    }

    //for test2()
    public String getCountriesCell(int x){
        String xp = "(//table[@class ='wikitable sortable plainrowheaders jquery-tablesorter'])/tbody/tr["+x+"]/th/a";
        return xp;
    }

    @Test
    public void test2(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table.");
        WebElement noc = driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/thead/tr/th[2]"));
        noc.click();

        List<WebElement> rowsElements = driver.findElements(By.xpath("(//table[@class ='wikitable sortable plainrowheaders jquery-tablesorter'])/tbody/tr/th/a"));
        List<String> rowsValues = new ArrayList<>();
        for (int i = 1; i < rowsElements.size(); i++) {
            String xpath = getCountriesCell(i);
            if (i!=8){
                WebElement rowsV = driver.findElement(By.xpath(xpath));
                rowsValues.add(rowsV.getText());
            }
        }
        System.out.println(rowsValues);

        char ch ='a';
        for (char i = ch; i <= 'z'; i++) {
            //System.out.println(i);

            for (int j = 0; j < rowsValues.size(); j++) {

                if (rowsValues.get(j).toLowerCase().charAt(0)==i){
                    System.out.println("yes "+rowsValues.get(j)+" starts with "+i);
                }
            }


        }



    }

/*
Test Case 2: THE FIRST FROM THE BOTTOM
Write a method that returns the name of the country with the smallest
number of gold medals.
Write a method that returns the name of the country with the smallest
number of silver medals.
Write a method that returns the name of the country with the smallest
number of bronze medals.
 */
    @Test
    public void test3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //go to website
        Assert.assertEquals(gold(),"Italy (ITA)","Italy does not exist");

    }

    private String gold() throws InterruptedException {
        driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
        driver.findElement(By.xpath("//table[9]/thead/tr/th[3]")).click();
        String smallest = driver.findElement(By.xpath("//table[9]/tbody/tr[1]/th")).getText().trim();
        return smallest;
    }

}
