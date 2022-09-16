package com.facebook.qa.pages;

import com.facebook.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends TestBase {

    @FindBy(xpath = "//img[@alt='Facebook']")
    WebElement fbLogo;

    @FindBy(id = "email")
    WebElement emailId;

    @FindBy(id = "pass")
    WebElement password;

    @FindBy(name = "login")
    WebElement loginButton;

    @FindBy(linkText = "Forgotten password?")
    WebElement forgotPassword;

    @FindBy(linkText = "Create New Account")
    WebElement createAccount;

    @FindBy(name = "firstname")
    WebElement firstName;

    @FindBy(name = "lastname")
    WebElement lastName;

    @FindBy(name = "reg_passwd__")
    WebElement registrationPassword;

    @FindBy(xpath="//button[@name='websubmit' and @type = 'submit' ]")
    WebElement signUpButton;


    // Initializing the page objects
    public LogInPage(){
        PageFactory.initElements(driver , this);
    }

    // Actions
    public String validate_LoginPage_Title(){
        return driver.getTitle();
    }

    public boolean validate_LoginPage_LogoImage(){
        return fbLogo.isDisplayed();
    }

    public HomePage login(String email, String pwd){
        emailId.sendKeys(email);
        password.sendKeys(pwd);
//        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
//        loginBtn.click();
        loginButton.click();
        return new HomePage();
    }

    public void clickOn_CreateAccount(String ftName, String ltName, String regPassword){
        createAccount.click();
        firstName.sendKeys(ftName);
        lastName.sendKeys(ltName);
        registrationPassword.sendKeys(regPassword);
        signUpButton.click();
    }
}
