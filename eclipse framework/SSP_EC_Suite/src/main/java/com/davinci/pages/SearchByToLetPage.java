package com.davinci.pages;
import org.openqa.selenium.By;
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

public class SearchByToLetPage  extends LoadableComponent<SearchByToLetPage> {
	
	private  WebDriver driver;
	private ExtentTest extentedReport;
	private boolean isPageLoaded;
	public ElementLayer uielement;
	
	
	@FindBy(xpath ="/html/body/app-component/app-shell/section/div/div/div/credit-module/div/search-buy-to-let/div/tool-bar/div/div/h3")
	
	WebElement searchBuyToLet;
	
	@FindBy(css="#navbar > ul > li:nth-child(1) > a > span.menutext")
	
	WebElement menuText;
	
	@FindBy(css="[name='CreditExtReference']")
	WebElement creditExtnReference;
	
	@FindBy(xpath="p-accordion/div/p-accordiontab[1]/div[2]/div/form/div/div[2]/button[1]")
	WebElement searchButton111;
	
	
	public SearchByToLetPage(WebDriver driver, ExtentTest report) {
		this.driver = driver;
		this.extentedReport = report;
		PageFactory.initElements(driver, this);
		Log.message("Navigated to Search Buy To let Page", driver, extentedReport, true);
	}
	

	protected void isLoaded() {

		if (!isPageLoaded) {
			Assert.fail();
		}
		if (isPageLoaded && !driver.getTitle().contains("Close")) {
			Log.fail("Search Buy to Let Page did not open up", driver, extentedReport);
		}

		uielement = new ElementLayer(driver);
	}


	protected void load() {

		isPageLoaded = true;
		WaitUtils.waitForElement(driver, searchBuyToLet);
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
		if (!WaitUtils.waitForElement(driver, menuText) && !WaitUtils.waitForElement(driver, searchBuyToLet))
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

	
	public void clickSearchButton(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, searchButton111);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", searchButton111);
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked Search Button ", driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking Search button : " + e);
		}
	}
		
	
	public void navigateToLinkDirtyPayments(String manageCredit_LinkDirtyPayments, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForSpinner(driver);
			WebElement mc=  driver.findElement(By.partialLinkText("MANAGE CREDIT"));			
			mc.click();		
			driver.findElement(By.cssSelector("a[title = '"+manageCredit_LinkDirtyPayments+"']")).click();
			load();			
			Log.message("Selected Type : Link Dirty Payments ", driver, extentedReport, true);
			
		} catch (Exception e) {
			throw new Exception("Unable to locate Link Dirty Payments screen : " + e);
		}
	}
	

}
	