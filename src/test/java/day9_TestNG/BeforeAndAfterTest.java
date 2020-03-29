package day9_TestNG;

import org.testng.Assert;
import org.testng.annotations.*;

public class BeforeAndAfterTest {

    @BeforeClass  //it runs only once
    public void beforeClass(){
        System.out.println("\tBefore Class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("\\tAfter Class");
    }

    @BeforeMethod  //it runs before each test.
    public void beforeMethod(){
        System.out.println("\tBefore Method");
        System.out.println("be a real tester");
    }
    @Ignore //cannot be ignored
    //it runs after every test
    @AfterMethod  //used for reporting, closing browsers, closing connections
    public void afterMethod(){
        System.out.println("\tAfter Method");
    }

    @Test
    public void test1(){
        System.out.println("this is test one");
        Assert.assertEquals(1,3);
        Assert.assertEquals(true,true);
    }

    @Test
    public void test2(){
        System.out.println("this is test two");
    }
}
