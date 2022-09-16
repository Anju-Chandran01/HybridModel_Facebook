package com.facebook.qa.pages;

import com.facebook.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FriendsPage extends TestBase {

    @FindBy(xpath="//h1[contains(text(),'Friends')]")
    WebElement friendsLabel;

    @FindBy(xpath="//span[contains(text(),'All Friends')]")
    WebElement allFriends;


    public FriendsPage(){
        PageFactory.initElements(driver,this);
    }

    public String verify_FriendsPage_Title(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.getTitle();
    }

    public String verify_FriendsPage_Url(){
        return driver.getCurrentUrl();
    }

    public boolean verify_FriendsPage_Label(){
        return friendsLabel.isDisplayed();
    }

    public  AllFriendsPage clickOn_AllFriendsLink(){
        allFriends.click();
        return new AllFriendsPage();
    }
}
