package com.facebook.qa.pages;

import com.facebook.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(xpath="//span[contains(text(),'John Smith')]")
    WebElement userNameLabel;

    @FindBy(xpath="//span[contains(text(),'Find friends')]")
    WebElement findFriends;

    @FindBy(xpath = "//span[contains(text(),'Marketplace')]")
    WebElement marketPlace;

    @FindBy(xpath = "//span[contains(text(),'Watch')]")
    WebElement watch;

    public HomePage(){
        PageFactory.initElements(driver , this);
    }

    public String verify_HomePage_Title(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.getTitle();
    }

    public Boolean verify_UserName(){
        return userNameLabel.isDisplayed();
    }

    public  FriendsPage clickOn_FindFriends(){
        findFriends.click();
        return new FriendsPage();
    }

    public MarketPlacePage clickOn_marketPlace(){
        marketPlace.click();
        return new MarketPlacePage();
    }

    public WatchPage clickOn_Watch(){
        watch.click();
        return new WatchPage();
    }
}
