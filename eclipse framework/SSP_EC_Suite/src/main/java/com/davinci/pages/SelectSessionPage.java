package com.davinci.pages;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.generic.support.Log;
import com.generic.utils.ElementLayer;
import com.generic.utils.GenericUtils;
import com.generic.utils.WaitUtils;
import com.relevantcodes.extentreports.ExtentTest;

public class SelectSessionPage  extends LoadableComponent<SelectSessionPage> {
                
                private  WebDriver driver;
                private ExtentTest extentedReport;
                private boolean isPageLoaded;
                public ElementLayer uielement;
                
                
                
                @FindBy(xpath="//h4[contains(text(),'280 Select session')]")
                WebElement readyElement;
               
               // @FindBy(xpath = "//button[@class='card-custom'] [1]")
                		
                		@FindBy(xpath = "/html/body/app-component/app-shell/section/div/div/div/app-session/div/div/div/button[1]")
                WebElement btnConsumerAndMortgagaeLending;
                
                
                /*
                * Constructor of the class
                * 
                 * @param driver
                *            : Webdriver
                * @return 
                 */
                public SelectSessionPage(WebDriver driver, ExtentTest report) {
                                this.driver = driver;
                                this.extentedReport = report;
                                PageFactory.initElements(driver, this);
                                Log.message("Navigated to Search Credit Page", driver, extentedReport, true);
                }
                
                protected void isLoaded() {

                                if (!isPageLoaded) {
                                                Assert.fail();
                                }
                                if (isPageLoaded && !driver.getTitle().contains("Close")) {
                                                Log.fail("Session Page did not open up", driver, extentedReport);
                                }

                                uielement = new ElementLayer(driver);
                }

                
                protected void load() {

                                isPageLoaded = true;
                                WaitUtils.waitForElement(driver, readyElement);
                }

                public  SearchCreditPage clickOnConsumerAndMortgageLendingButton() throws Exception {
                                try {
                                                WaitUtils.waitForElement(driver, btnConsumerAndMortgagaeLending);
                                                JavascriptExecutor executor = (JavascriptExecutor) driver;
                                                executor.executeScript("arguments[0].click();", btnConsumerAndMortgagaeLending);
                                                WaitUtils.waitForSpinner(driver);
                                                Log.message("Clicked ConsumerAndMortgagaeLending session", driver, extentedReport);
                                            	return new SearchCreditPage(driver,extentedReport).get();
                                } catch (Exception e) {
                                                throw new Exception("Error while clicking on btnConsumerAndMortgagaeLending session : " + e);
                                }
                }
                
                
}
                

 

