package com.cybertek.base;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehiclesPage extends VytrackBasePage{

    public VehiclesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

}
