package com.cybertek.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DemoPage {

    public DemoPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

}
