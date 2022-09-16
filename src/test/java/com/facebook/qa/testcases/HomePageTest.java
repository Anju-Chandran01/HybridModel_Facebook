package com.facebook.qa.testcases;

import com.facebook.qa.base.TestBase;
import com.facebook.qa.pages.FriendsPage;
import com.facebook.qa.pages.HomePage;
import com.facebook.qa.pages.LogInPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    LogInPage logInPage;
    HomePage homePage;
    FriendsPage friendsPage;

    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        logInPage = new LogInPage();
        homePage = logInPage.login(prop.getProperty("emailId"), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void verify_HomePageTitle_Test(){
        String homePageTitle = homePage.verify_HomePage_Title();
        Assert.assertEquals(homePageTitle,"Facebook","Home Page title is not matched");
    }

    @Test(priority = 2)
    public void verify_UserName_Test(){
        Assert.assertTrue(homePage.verify_UserName());
    }

    @Test(priority = 3)
    public void verify_FriendsLink_Test(){
        friendsPage = homePage. clickOn_FindFriends();
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
