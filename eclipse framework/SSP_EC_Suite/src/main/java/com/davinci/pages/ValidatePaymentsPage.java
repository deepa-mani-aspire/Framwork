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

public class ValidatePaymentsPage  extends LoadableComponent<ValidatePaymentsPage> {
	
	private  WebDriver driver;
	private ExtentTest extentedReport;
	private boolean isPageLoaded;
	public ElementLayer uielement;
	
	
	
	@FindBy(xpath ="/html/body/app-component/app-shell/section/div/div/div/credit-module/div/validate-payments/div/form/tool-bar/div/div/h3")
	WebElement validatepayments;
	
	@FindBy(css="#navbar > ul > li:nth-child(1) > a > span.menutext")
	
	WebElement menuText;
	
	@FindBy(css="[name='CreditExtReference']")
	WebElement creditExtnReference;
	
	@FindBy(xpath="/html/body/app-component/app-shell/section/div/div/div/credit-module/div/validate-payments/div/form/tool-bar/div/div/div/button[2]/span")
	WebElement closeButton221;
	
	
	public ValidatePaymentsPage(WebDriver driver, ExtentTest report) {
		this.driver = driver;
		this.extentedReport = report;
		PageFactory.initElements(driver, this);
		Log.message("Navigated to  Validate Payments Page", driver, extentedReport, true);
	}
	

	protected void isLoaded() {

		if (!isPageLoaded) {
			Assert.fail();
		}
		if (isPageLoaded && !driver.getTitle().contains("Close")) {
			Log.fail(" Validate Payments Page did not open up", driver, extentedReport);
		}

		uielement = new ElementLayer(driver);
	}


	protected void load() {

		isPageLoaded = true;
		WaitUtils.waitForElement(driver, validatepayments);
	}

	/*
	 * Verify HomePage
	 * 
	 * @throws Exception
	 *             : Custom Exception Message
	 * @return boolean
	 * 
	 */
	public boolean verifysearchCreditPage() throws Exception {
		WaitUtils.waitForSpinner(driver);
		if (!WaitUtils.waitForElement(driver, menuText) && !WaitUtils.waitForElement(driver, validatepayments))
			throw new Exception("Dashboard Page is not loaded");
		return true;
	}
	
	
	public void enterCreditExtReference(String creditReference, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, creditExtnReference);
			creditExtnReference.clear();
			creditExtnReference.click();
			creditExtnReference.sendKeys(creditReference);
			Log.message("Entered Credit Reference : " + creditReference, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering password : " + e);
		}
	}

	
	public void clickCloseButton(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, closeButton221);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", closeButton221);
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked close Button ", driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while close Search button : " + e);
		}
	}
		

}
	