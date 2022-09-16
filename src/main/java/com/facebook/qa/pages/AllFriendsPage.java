package com.facebook.qa.pages;

import com.facebook.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllFriendsPage extends TestBase {

    @FindBy(xpath="//span[contains(text(),'All Friends')]")
    WebElement allFriendsLabel;

    public AllFriendsPage(){
        PageFactory.initElements(driver , this);
    }

    public String verify_AllFriendsPage_Title(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.getTitle();
    }

    public String verify_AllFriendsPage_Url(){
        return driver.getCurrentUrl();
    }

    public boolean verify_AllFriendsPage_Label(){
        return allFriendsLabel.isDisplayed();
    }

    public void select_Friends_ByName(String name){
        driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]")).click();
    }
}
