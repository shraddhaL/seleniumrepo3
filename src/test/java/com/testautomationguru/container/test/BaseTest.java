package com.testautomationguru.container.test;

import com.google.common.util.concurrent.Uninterruptibles;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseTest {

    protected WebDriver driver;

    @BeforeSuite
    public void initialDelay(){
        //intentionally added this as chrome/firefox containers take few ms to register
        //to hub - test fails saying hub does not have node!!
        //very rare
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
    }
    
    @BeforeTest
    public void setUp() throws MalformedURLException {
        
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        capabilities.setCapabilities(ChromeOptions.CAPABILITY,options);
        
        
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        driver.manage().window.maximize();
        google = new PageClass(driver);
        
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        driver.close();
        driver.quit();
    }  
}
