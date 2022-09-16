package com.facebook.qa.testcases;

import com.facebook.qa.base.TestBase;
import com.facebook.qa.pages.FriendsPage;
import com.facebook.qa.pages.HomePage;
import com.facebook.qa.pages.LogInPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FriendsPageTest extends TestBase {

    LogInPage logInPage;
    HomePage homePage;
    FriendsPage friendsPage;

    public FriendsPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        logInPage = new LogInPage();
        friendsPage = new FriendsPage();
        homePage = logInPage.login(prop.getProperty("emailId"), prop.getProperty("password"));
        friendsPage = homePage.clickOn_FindFriends();
    }

    @Test(priority = 1)
    public void verify_FriendsPageUrl_Test(){
        String url = friendsPage.verify_FriendsPage_Url();
        Assert.assertEquals(url,"https://www.facebook.com/friends");
    }

    @Test(priority = 2)
    public void verify_FriendsPageTitle_Test(){
        String title = friendsPage.verify_FriendsPage_Title();
        Assert.assertEquals(title,"Friends | Facebook");
    }

    @Test(priority = 3)
    public void verify_FriendsPageLabel_Test(){
        Assert.assertTrue(friendsPage.verify_FriendsPage_Label());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
