package com.davinci.pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;
import com.generic.support.Log;
import com.generic.utils.ElementLayer;
import com.generic.utils.WaitUtils;
import com.relevantcodes.extentreports.ExtentTest;

public class AdministrativeHistoryOverviewPage  extends LoadableComponent<AdministrativeHistoryOverviewPage> {
	
	private  WebDriver driver;
	private ExtentTest extentedReport;
	private boolean isPageLoaded;
	public ElementLayer uielement;
	
	
	
	@FindBy(xpath ="/html/body/app-component/app-shell/section/div/div/div/credit-module/div/administrative-history-overview/div/tool-bar/div/div/h3")
	WebElement administrativehistoryoverview;
	
	
	@FindBy(xpath="/html/body/app-component/app-shell/section/div/div/div/credit-module/div/administrative-history-overview/div/tool-bar/div/div/div/button/span")
	WebElement closeButton221;
	
	
	public AdministrativeHistoryOverviewPage(WebDriver driver, ExtentTest report) {
		this.driver = driver;
		this.extentedReport = report;
		PageFactory.initElements(driver, this);
		Log.message("Navigated to Administrative History Overview Page", driver, extentedReport, true);
	}
	

	protected void isLoaded() {

		if (!isPageLoaded) {
			Assert.fail();
		}
		if (isPageLoaded && !driver.getTitle().contains("Close")) {
			Log.fail("Administrative History Overview Page did not open up", driver, extentedReport);
		}

		uielement = new ElementLayer(driver);
	}


	protected void load() {

		isPageLoaded = true;
		WaitUtils.waitForElement(driver, administrativehistoryoverview);
	}

	/*
	 * Verify HomePage
	 * 
	 * @throws Exception
	 *             : Custom Exception Message
	 * @return boolean
	 * 
	 */
	
	public void clickCloseButton(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, closeButton221);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", closeButton221);
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked close Button ", driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking close button : " + e);
		}
	}
		

}
	