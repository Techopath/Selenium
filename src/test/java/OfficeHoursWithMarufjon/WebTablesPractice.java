package OfficeHoursWithMarufjon;

import com.cybertek.base.TestBase;
import org.graalvm.compiler.lir.alloc.lsra.LinearScan;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesPractice extends TestBase {

    @BeforeMethod
    public void setUpTests() {
        driver.get("https://www.mockaroo.com/");
        driver.findElement(By.id("num_rows")).clear();
        driver.findElement(By.id("num_rows")).sendKeys("10");
        driver.findElement(By.id("preview")).click();

    }

    @Test
    public void testHeaderCount() {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.switchTo().frame("preview_iframe");

        //WebElement table = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-condensed']"));
        WebElement table = driver.findElement(By.xpath("//table"));
        System.out.println(table.getText());

        //get all
        List<WebElement> headers = driver.findElements(By.xpath("//table[@style]//th"));
        Assert.assertEquals(headers.size(), 6);

    }

    /*
    verify that value of each entry under gender column is equal to male or female

     */

    @Test
    public void maleFemale() {
        //table[@style]/tbody/tr
        List<WebElement> allGenders = driver.findElements(By.xpath("//table[@style]/tbody/tr/td[5]"));
        System.out.println("allGenders.size() = " + allGenders.size());

        //go through the list
        //verify that values is either Male or Female
        for (WebElement gender : allGenders) {
            String actual = gender.getText();
            Assert.assertTrue(actual.equals("Male") || actual.equalsIgnoreCase("Female"));

        }

    }
}

//    public String getSpecificCell(int r, int c){
//        String xpath = "//table[@style]/tbody/tr";
//    }

