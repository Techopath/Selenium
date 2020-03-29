package day12_pops_tabs_alerts_iframes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

public class TabsUtility {

    public static void getNewWindow(WebDriver driver, String nextWindowTitle){

        for (String windowHandle:driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals(nextWindowTitle)) {
                break;
            }
        }

    }
}
