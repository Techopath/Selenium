package day16_page_object_model;

import com.cybertek.base.VytrackBasePage;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends VytrackBasePage {

    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }



}
