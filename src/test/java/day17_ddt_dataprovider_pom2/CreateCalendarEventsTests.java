package day17_ddt_dataprovider_pom2;

import com.cybertek.base.VytrackTestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class CreateCalendarEventsTests extends VytrackTestBase {

    @Test
    public void allDayEventRadioTest() throws InterruptedException {
        loginPage.login(ConfigurationReader.getProperty("driver_username"),
                ConfigurationReader.getProperty("driver_password"));
        driver.get("https://qa3.vytrack.com/calendar/event/create");

        assertFalse(eventsPage.allDayCheckBox.isSelected());
//        Thread.sleep(3000);
//        wait.until(ExpectedConditions.elementToBeClickable(eventsPage.allDayCheckBox));
//        eventsPage.allDayCheckBox.click();
//
//        wait.until(ExpectedConditions.elementToBeClickable(eventsPage.repeatCheckBox));
//        eventsPage.repeatCheckBox.click();
    }

    @Test
    public void repeatCheckBoxTest() throws InterruptedException {
        loginPage.login(ConfigurationReader.getProperty("driver_username"),
                ConfigurationReader.getProperty("driver_password"));

        driver.get("https://qa3.vytrack.com/calendar/event/create");
        wait.until(ExpectedConditions.elementToBeClickable(eventsPage.repeatCheckBox));
        assertFalse(eventsPage.repeatCheckBox.isSelected());
    }
}
