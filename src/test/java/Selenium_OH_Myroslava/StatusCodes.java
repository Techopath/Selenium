package Selenium_OH_Myroslava;

/*
Office hour with Nurullah
 */

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

/*
Test case #12
Step 1. Go to https://practice-cybertekschool.herokuapp.com
step 2. And click on Status Codes
step 3. then click on 500
step 4. verify that following message is displayed : "This page returned a 500 status code"
 */
public class StatusCodes {

    @Test (priority = 0, description = "verify that following message is displayed : This page returned a 500 status code")
    public static void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //go to the following web site first then continue to write the rest of the code)
        driver.get("https://practice-cybertekschool.herokuapp.com");
        Thread.sleep(2000);

        
        /*
  xpath :
     //a[text()='Status Codes']
     //a[contains(text(),'Status Codes')]
     //ul/li[46]
     //a[@href="/status_codes"]
  linkText :
     lintText("Status Codes")
  partialLinkText:
     partialLintText("Status Codes")
     partiallinkText("Status")
     partiallinkText("Codes")
     CssSelector
     [href="/status_codes"]
 */

        //step 2.
//        WebElement op1 = driver.findElement(By.xpath("a[text()='Status Codes']"));
//        op1.click();
//        WebElement op2 = driver.findElement(By.xpath("a[contains(text(), 'Status Codes')]"));
//        op2.click();
//
//        WebElement op3 = driver.findElement(By.xpath("//ul/li/[46]"));
//
//        WebElement op4 = driver.findElement(By.cssSelector("[href='/status_codes']"));
//        op4.click();
        WebElement statusCodesLink = driver.findElement(By.linkText("Status Codes"));
        statusCodesLink.click();

        Thread.sleep(2000);
        //step 3
        WebElement sCode_500 = driver.findElement(By.linkText("500"));

        sCode_500.click();

        Thread.sleep(2000);

        //step 4

        String expected ="This page returned a 500 status code.";

        WebElement displayedMessageElement = driver.findElement(By.xpath("//p"));

        String actualMessage = displayedMessageElement.getText();



//        System.out.println(actualMessage);
//
        if (actualMessage.contains(expected)){
            System.out.println("passed");
        }else {
            System.out.println("failed");
        }
        driver.close();

    }


    @Test (priority = 1, description = "verify that following message is displayed : This page returned a 404 status code")
    public static void test2() throws InterruptedException {

                WebDriver driver = WebDriverFactory.getDriver("chrome");
                //go to the following web site first then continue to write the rest of the code)
                driver.get("https://practice-cybertekschool.herokuapp.com");
                Thread.sleep(2000);

        WebElement statusCodesLink = driver.findElement(By.linkText("Status Codes"));
        statusCodesLink.click();
                Thread.sleep(2000);
                //step 3
                WebElement sCode_500 = driver.findElement(By.linkText("404"));

                sCode_500.click();

                Thread.sleep(2000);

                String expected ="This page returned a 404 status code.";

                WebElement displayedMessageElement = driver.findElement(By.xpath("//p"));

                String actualMessage = displayedMessageElement.getText();


                if (expected.contains(actualMessage)){
                    System.out.println("passed");
                }else{
                    System.out.println("failed");
                }



    }

    @DataProvider(name = "testData")
    public static Object[] testData (){
            return new Object[]{"404","500","200","301"};
    }

    @Test (dataProvider = "testData")
    public void statusCodes(String code) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //go to the following web site first then continue to write the rest of the code)
        driver.get("https://practice-cybertekschool.herokuapp.com");
        Thread.sleep(2000);

        WebElement statusCodesLink = driver.findElement(By.linkText("Status Codes"));
        statusCodesLink.click();
        Thread.sleep(2000);
        //step 3
        WebElement sCode_500 = driver.findElement(By.linkText(code));

        sCode_500.click();

        Thread.sleep(2000);

        String expected ="This page returned a "+code+" status codeaa.";

        WebElement displayedMessageElement = driver.findElement(By.xpath("//p"));

        String actualMessage = displayedMessageElement.getText();


//        if (expected.contains(actualMessage)){
//            System.out.println("passed");
//        }else{
//            System.out.println("failed");
//        }
        /*
        The following is a hard assertion and contains a message that is
        displayed only if the assertion fails.

         */
        Assert.assertTrue(actualMessage.contains(expected), "the status code does not exist");

        driver.close();

    }

    /*
    DataProvider --> Provide data to test cases.
     */

}
