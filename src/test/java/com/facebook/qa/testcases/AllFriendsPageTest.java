package com.facebook.qa.testcases;

import com.facebook.qa.base.TestBase;
import com.facebook.qa.pages.AllFriendsPage;
import com.facebook.qa.pages.FriendsPage;
import com.facebook.qa.pages.HomePage;
import com.facebook.qa.pages.LogInPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AllFriendsPageTest extends TestBase {
    LogInPage logInPage;
    HomePage homePage;
    FriendsPage friendsPage;
    AllFriendsPage allFriendsPage;

    public AllFriendsPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        logInPage = new LogInPage();
        friendsPage = new FriendsPage();
        allFriendsPage = new AllFriendsPage();
        homePage = logInPage.login(prop.getProperty("emailId"), prop.getProperty("password"));
        allFriendsPage = friendsPage.clickOn_AllFriendsLink();
    }


    @Test(priority = 1)
    public void verify_AllFriendsPageUrl_Test(){
        String url = allFriendsPage.verify_AllFriendsPage_Url();
        Assert.assertEquals(url,"https://www.facebook.com/friends/list");
    }

    @Test(priority = 2)
    public void verify_AllFriendsPageTitle_Test(){
        String title = allFriendsPage.verify_AllFriendsPage_Title();
        Assert.assertEquals(title,"All Friends | Facebook");
    }

    @Test(priority = 3)
    public void verify_AllFriendsPageLabel_Test(){
        Assert.assertTrue(allFriendsPage.verify_AllFriendsPage_Label());
    }

    @Test(priority = 4)
    public void select_SingleFriend_Test(){
        allFriendsPage.select_Friends_ByName("Tushar Ranjan Nayak");
    }

    @Test(priority = 5)
    public void select_MultipleFriends_Test(){
        allFriendsPage.select_Friends_ByName("Tushar Ranjan Nayak");
        allFriendsPage.select_Friends_ByName("David Odhiambo");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
