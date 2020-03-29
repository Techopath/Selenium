package day9_TestNG;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgAssertionsTest {

    @Test
    public void test1(){
        String expected ="one";
        String actual = "one";

//        if (expected.equals(actual)){
//            System.out.println("pass");
//        }else {
//            System.out.println("fail");
//        }
        //Assert --> is a class in testng which provides assertions.
        //Assertion -> a method that does verification like comparing actual and expected.
        //assertEquals  -> compares two values
        Assert.assertEquals(actual,expected); //should be of the same data type.
        Assert.assertEquals(true,true);

        System.out.println("test one complete");
    }

    @Test
    public void test2() {
        String expected = "one";
        String actual = "two";
        System.out.println("starting to compare");
        Assert.assertEquals(true,true);
        System.out.println("true is true");
        Assert.assertEquals(actual,expected);
        //if test fails, the following statements will not be printed out in the console.
        System.out.println("test 2 complete");
    }

    @Test
    public void test3(){
        String expected = "one";
        String actual = "two";

        Assert.assertNotEquals(actual,expected);
        System.out.println("not equal");

    }

    @Test
    public void test4(){
        String expected = "one";
        String actual = "two";

        //System.out.println(expected.equals(actual));
        Assert.assertTrue(expected.equals(actual));

        int e =100;
        int a =200;

        Assert.assertTrue(a<e);

       System.out.println("test did not pass");

    }

    @Test
    public void test5(){
        //verify that url is EQUAL to http://www.google.com/

        String expected = "http://www.google.com/";
        String actual = "http://www.google.com/";

        Assert.assertEquals(expected,actual);
        System.out.println("passed");

        //verify that title starts with java
        String expected1 = "java";
        String actual1 = "java-Google Search";

        Assert.assertTrue(actual1.equals(expected1));
        System.out.println("failed");



    }


}
