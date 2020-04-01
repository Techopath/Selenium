package day15_webTables;

import Office_hours2.BrowserUtils;
import com.cybertek.base.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.sun.org.apache.xalan.internal.xsltc.dom.AdaptiveResultTreeImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTests extends TestBase {

    @BeforeMethod
    public void setUpTest(){
        String url = ConfigurationReader.getProperty("url");
        driver.get(url);
        driver.findElement(By.linkText("Sortable Data Tables")).click();
    }

    @Test
    public void printTable(){

//        String url = ConfigurationReader.getProperty("url"); //we implemented the common things which we are using in our tests to beforeMethod above()
//        driver.get(url);
//        driver.findElement(By.linkText("Sortable Data Tables")).click();

        WebElement myTable = driver.findElement(By.id("table1"));
        System.out.println("myTable = " + myTable.getText());
    }

    //get all headers

    @Test
    public void getHeaders(){
//        String url = ConfigurationReader.getProperty("url");
//        driver.get(url);
//        driver.findElement(By.linkText("Sortable Data Tables")).click();

        WebElement header = driver.findElement(By.tagName("thead"));
        System.out.println("header = " + header.getText());

        //get all header in a list

//        List<WebElement> headers = driver.findElements(By.tagName("th"));
//        System.out.println("headers.size() = " + headers.size());

        //
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());

        System.out.println(BrowserUtils.getElementsText(headers));
    }

    //get table size
    @Test
    public void getTableSize(){
        //get number of columns
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("Column number = " + headers.size());

        //get number of rows including header
        List<WebElement> rowsWithHeader = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("rowsWithHeader = " + rowsWithHeader.size());

        //get number of rows without header
        List<WebElement> rowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println("rowsWithoutHeader.size() = " + rowsWithoutHeader.size());

    }
    @Test
    public void getSingleRowByIndex(){

        //get the first row (in the body)
        WebElement row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]"));
        System.out.println("row.getText() = " + row.getText());

        //get the 3rd row (in the body) dynamic path
        String xpath = getTableRowXpath(3);
        row = driver.findElement(By.xpath(xpath));
        System.out.println("row = " + row.getText());
    }

    //getTableRowXpath based on index

    public static String getTableRowXpath(int index){

        String xpath = "//table[@id='table1']/tbody/tr["+index+"]";
        return xpath;
    }

    //get single cell based on index

    @Test
    public void getSingleBasedByIndex(){
        WebElement cell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]/td[1]"));
        System.out.println("cell.getText() = " + cell.getText());

        cell = driver.findElement(By.xpath(getCellXpathByIndex(2,3)));
        System.out.println("cell = " + cell.getText());
    }

    public static String getCellXpathByIndex(int row, int col){
        String xpath = "//table[@id='table1']/tbody/tr["+row+"]/td["+col+"]";
        return xpath;
    }

    // go through the table using loops and get all values

    @Test
    public void iterateTheTableUsingLoops(){
        //get the number of rows
        int rowCount = getRowCount();
        //get the number of columns
        int colCount = getColCount();

        for (int i = 1; i < rowCount; i++) {
            for (int j = 1; j <= colCount; j++) {
                String xpath = getCellXpathByIndex(i,j);
                WebElement cell = driver.findElement(By.xpath(xpath));
                System.out.println("cell.getText() = " + cell.getText());
            }
        }
    }

    // returns number of rows excluding the table headers
    public int getRowCount(){
        return driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

    }

    public int getColCount(){
        return driver.findElements(By.xpath("//table[@id='table1']//th")).size();
    }

}
