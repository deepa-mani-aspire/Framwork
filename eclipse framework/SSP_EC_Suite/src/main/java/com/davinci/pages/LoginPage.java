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

public class LoginPage extends LoadableComponent<LoginPage> {

	
	private final WebDriver driver;
	private ExtentTest extentedReport;
	private boolean isPageLoaded;
	public ElementLayer uielement;
	private String davinciURL;

	@FindBy(css = "input[name*='UserName']")
	WebElement txtUserName;

	@FindBy(css = "input[name*='Password']")
	WebElement txtPassWord;

	@FindBy(css = "span.submit")
	WebElement btnSignIn;

	/**
	 * 
	 * Constructor class for Login page Here we initializing the driver for page
	 * factory objects. For ajax element waiting time has added while initialization
	 * 
	 * @param driver
	 *            : Webdriver
	 * @param url
	 *            : Login Page URL
	 * @param extentedReport
	 */
	public LoginPage(WebDriver driver, String url, ExtentTest report) {

		this.driver = driver;
		this.extentedReport = report;
		davinciURL = url;
		PageFactory.initElements(driver, this);
		Log.message("Davinci url is launched : " + url, driver, extentedReport, true);
	}

	@Override
	protected void isLoaded() {

		WaitUtils.waitForPageLoad(driver);

		if (!isPageLoaded) {
			Assert.fail();
		}

		if (isPageLoaded && !driver.getTitle().contains("Sign In")) {
			Log.fail("Davinci Login Page did not open up. Site might be down.", driver, extentedReport);
		}
	}

	@Override
	protected void load() {

		isPageLoaded = true;
		driver.get(davinciURL);
		WaitUtils.waitForElement(driver, txtUserName);
	}
	
	/**
	 * Login to DAVINCI
	 * 
	 * @param username
	 * @param password
	 * @param extentedReport
	 * @return HomePage
	 * @throws Exception
	 * 
	 */

//	public SearchCreditPage loginToDavinci(String username, String password, ExtentTest extentedReport)
//			throws Exception {
//		try {
//			enterUserName(username, extentedReport);
//			enterPassword(password, extentedReport);
//			clickLoginBtn(extentedReport);
//			WaitUtils.waitForSpinner(driver);
//			WaitUtils.waitForPageLoad(driver);
//			return new SearchCreditPage(driver,extentedReport).get();
//		} catch (Exception e) {
//			throw new Exception("Error while login to application : " + e);
//		}
//	}
	
	/**
	 * Verify User Name is displayed
	 * 
	 * @return boolean
	 * @throws Exception
	 * 
	 */
	public boolean verifyUserNameField() throws Exception {
		try {
			return WaitUtils.waitForElement(driver, txtUserName);
		} catch (Exception e) {
			throw new Exception("Error while verifying username field : " + e);
		}
	}
	
	/**
	 * Verify Password is displayed
	 * 
	 * @return boolean
	 * @throws Exception
	 * 
	 */
	public boolean verifyPasswordField() throws Exception {
		try {
			return WaitUtils.waitForElement(driver, txtPassWord);
		} catch (Exception e) {
			throw new Exception("Error while verifying Password field : " + e);
		}
	}
	
	/**
	 * To enter user name
	 * 
	 * @param userName
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void enterUserName(String userName, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtUserName);
			txtUserName.clear();
			txtUserName.sendKeys(userName);
			Log.message("Entered UserName : " + userName, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering Username : " + e);
		}
	}
	
	/**
	 * To Enter password
	 * 
	 * @param pwd
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void enterPassword(String pwd, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, txtPassWord);
			txtPassWord.clear();
			txtPassWord.sendKeys(pwd);
			Log.message("Entered Password : " + pwd, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering password : " + e);
		}
	}
	
	/**
	 * Click signIn button on login page
	 * 
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void clickLoginBtn(ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, btnSignIn);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", btnSignIn);
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked Login button", driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while clicking Login button : " + e);
		}
	}
	
	public SelectSessionPage loginToDavinci(String username, String password, ExtentTest extentedReport)
			throws Exception {
		try {
			enterUserName(username, extentedReport);
			enterPassword(password, extentedReport);
			clickLoginBtn(extentedReport);
			WaitUtils.waitForSpinner(driver);
			WaitUtils.waitForPageLoad(driver);
			return new SelectSessionPage(driver,extentedReport).get();
		} catch (Exception e) {
			throw new Exception("Error while login to application : " + e);
		}
	}
}
