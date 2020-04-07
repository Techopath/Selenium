package com.cybertek.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    /*
    write a method that takes
    a list of web elements
    returns a list of strings

     */
    public static List<String> getElementsText(List<WebElement> listEl){
        List<String> listSt = new ArrayList<>();
        for (WebElement element : listEl){
            listSt.add(element.getText().trim());
        }
        return listSt;
    }

}
