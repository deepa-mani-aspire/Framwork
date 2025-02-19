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

public class SearchIncomingPaymentsPage  extends LoadableComponent<SearchIncomingPaymentsPage> {
	
	private  WebDriver driver;
	private ExtentTest extentedReport;
	private boolean isPageLoaded;
	public ElementLayer uielement;
	
	
	
	@FindBy(xpath ="/html/body/app-component/app-shell/section/div/div/div/credit-module/div/search-incoming-payments/div/tool-bar/div/div/h3")
	WebElement searchincomingpayments;
	
	
	
	
	public SearchIncomingPaymentsPage(WebDriver driver, ExtentTest report) {
		this.driver = driver;
		this.extentedReport = report;
		PageFactory.initElements(driver, this);
		Log.message("Navigated to Search Incoming Payments Page", driver, extentedReport, true);
	}
	

	protected void isLoaded() {

		if (!isPageLoaded) {
			Assert.fail();
		}
		if (isPageLoaded && !driver.getTitle().contains("Close")) {
			Log.fail("Search Incoming Payments Page did not open up", driver, extentedReport);
		}

		uielement = new ElementLayer(driver);
	}


	protected void load() {

		isPageLoaded = true;
		WaitUtils.waitForElement(driver, searchincomingpayments);
	}

	/*
	 * Verify HomePage
	 * 
	 * @throws Exception
	 *             : Custom Exception Message
	 * @return boolean
	 * 
	 */
	
	
		

}
	