package com.cybertek.base;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.jvm.hotspot.debugger.Page;

import java.util.List;

public class VytrackBasePage {

    public VytrackBasePage(){ //create constructor
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(className = "oro-subtitle")  //locator for page header
    public WebElement pageHader;

    @FindBy(xpath= "//span[contains(text(), 'Fleet')][@class='title title-level-1']")
    public WebElement fleet; //locator for fleet tab

    @FindBy(xpath= "//span[.='Vehicles'][@class='title title-level-2']")
    public WebElement vehicles; //locator for vehicles sub tab

    //--------------locator for account holder

    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[1]") //a[href=‘javascript: void(0);’]
    public WebElement accountHolder;

    @FindBy(css = ".title-level-1")
    public List<WebElement> menu1Options;


    public static void display(){
        System.out.println("welcome");
    }

    public void changeMenu(String menu1, String menu2) throws InterruptedException {
        //menu1 -->fleet
        //menu2 --> vehicles
        //locate the menu1
        String menu1X =  "//span[contains(text(), '"+menu1+"')][@class='title title-level-1']";
        WebElement menu1Element = Driver.getDriver().findElement(By.xpath(menu1X));

        String menu2X = "//span[.='"+menu2+"'][@class='title title-level-2']";
        WebElement menu2Element = Driver.getDriver().findElement(By.xpath(menu2X));

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);
        wait.until(ExpectedConditions.elementToBeClickable(menu1Element));
        menu1Element.click();
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }

        wait.until(ExpectedConditions.elementToBeClickable(menu2Element));
        menu2Element.click();
    }
}
