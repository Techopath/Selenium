package Office_hours2;

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

        //given a list of elements, extract the text of the elements into new list of strings
   List<String> listSt = new ArrayList<>();

        for (WebElement element : listEl) {
            listSt.add(element.getText());

        }
   return listSt;
    }

}
