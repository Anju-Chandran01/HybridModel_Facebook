package com.facebook.qa.testcases;

import com.facebook.qa.base.TestBase;
import com.facebook.qa.pages.HomePage;
import com.facebook.qa.pages.LogInPage;
import com.facebook.qa.util.TestUtil;
//import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;


public class LogInPageTest extends TestBase {

    LogInPage logInPage;
    HomePage homePage;
    String sheetName;

    Logger log = Logger.getLogger(LogInPageTest.class);

    public LogInPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        log.info("Chrome is launching");
        initialization();
        logInPage = new LogInPage();
    }
//
//    @Test(priority = 1)
//    public void loginPage_TitleTest(){
//        log.warn("Custom warning....");
//        log.fatal("Custom fatal error....");
//        log.debug("Custom debug");
//        String title = logInPage.validate_LoginPage_Title();
//        Assert.assertEquals(title,"Facebook – log in or sign up");
//    }
//
//    @Test(priority = 2)
//    public void loginPage_LogoTest(){
//        Boolean flag = logInPage.validate_LoginPage_LogoImage();
//        System.out.println(flag);
//        Assert.assertTrue(flag);
//    }
    @DataProvider
    public Object[][] getLoginTestdata() {
        return TestUtil.getTestData(sheetName);
    }

    @Test(priority = 2, dataProvider = "getLoginTestdata")
    public void loginTest(String username, String password) {
        homePage = logInPage.login(username, password);
    }
//    @Test(priority = 3)
//    public void loginTest(){
//        homePage = logInPage.login(prop.getProperty("emailId"), prop.getProperty("password"));
//    }
//
//    @DataProvider
//    public Object[][] getFacebookTestData(String sheetName){
//        Object data[][] = TestUtil.getTestData(sheetName);
//        return data;
//    }
//
//    @Test(priority = 4, dataProvider = "getFacebookTestData")
//    public void create_NewAccount_Test(String firstname, String lastname, String regpassword){
////        logInPage.clickOn_CreateAccount("Tom","Peter","TomPeter@123");
//        logInPage.clickOn_CreateAccount(firstname, lastname, regpassword);
//    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
