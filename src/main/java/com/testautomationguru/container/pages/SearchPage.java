package com.testautomationguru.container.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public SearchPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 30);
    }

    public void goTo() {
        this.driver.get("https://www.google.com");
        System.out.println("Browser launched and navigated to Google");
    }
    
    /*public Boolean checkTitle(String expectedTitle){
       return driver.getTitle().contains(expectedTitle);
   }*/
  
  public String checkTitle(){
  driver.navigate().to("https://www.google.com");
  String pageTitle = driver.getTitle();
  System.out.println(pageTitle);
  return pageTitle;
  }
                       

}
