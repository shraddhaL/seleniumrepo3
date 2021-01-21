package com.testautomationguru.container.test;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testautomationguru.container.pages.SearchPage;

public class SearchTest extends BaseTest {

    private SearchPage google;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        super.setUp();
        google = new SearchPage(driver);
    }

   @Test()
    public void googleTest() {
        google.goTo();
        if(google.checkTitle().equals("Google"))
        Assert.assertTrue(true);
        else
        Assert.assertTrue(false);
        
   
    }
    /*@Test()
    public void googleTest() {
        if(google.checkTitle().equals("Google"))
        Assert.assertTrue(true);
        else
        Assert.assertTrue(false);
        
   
    }*/
    
    
   

}
