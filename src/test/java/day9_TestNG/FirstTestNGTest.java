package day9_TestNG;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class FirstTestNGTest {

  //Now, we don't use main method.
    //we deal with annotations

    //the following is a test.
    @Test //if we don't have this @Test annotation, we are not able to run the code
    public void test1(){
        System.out.println("test one");
    }
    @Ignore //=> ignores the method with @Test annotation.
    @Test
    public void test2(){
        System.out.println("Test two");
    }

    @Test
    public void test3(){
        System.out.println("test 3");
    }









}
