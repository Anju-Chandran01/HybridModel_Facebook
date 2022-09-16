package com.facebook.qa.base;

import com.facebook.qa.util.TestUtil;
import com.facebook.qa.util.WebEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;

    public TestBase(){
        try{
            prop = new Properties();
            FileInputStream ip = new FileInputStream("C:\\Users\\HP\\IdeaProjects\\FacebookTest\\" +
                    "src\\main\\java\\com\\facebook\\qa\\config\\config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization(){
        String browserName = prop.getProperty("browser");
        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver.exe");

            ChromeOptions option = new ChromeOptions();
            option.addArguments("--disable-notifications");
            driver = new ChromeDriver(option);
        }
//        else if{
//            System.setProperty("webdriver.gecko.driver","");
//            driver = new FirefoxDriver();
//        }

        e_driver = new EventFiringWebDriver(driver);
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));
    }
}
