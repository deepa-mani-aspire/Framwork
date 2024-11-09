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

public class SearchCreditPage  extends LoadableComponent<SearchCreditPage> {
	
	private  WebDriver driver;
	private ExtentTest extentedReport;
	private boolean isPageLoaded;
	public ElementLayer uielement;
	
	//@FindBy(css = "body > app > shell > section > div > div > div > credit-module > div > search-credit > div > toolbar > div > div > h3")
	
	@FindBy(xpath ="/html/body/app-component/app-shell/section/div/div/div/credit-module/div/search-credit/div/tool-bar/div/div/h3")
	
	WebElement searchCredit;
	
	@FindBy(css="#navbar > ul > li:nth-child(1) > a > span.menutext")
	WebElement menuText;
	
	@FindBy(css="[name='CreditExtReference']")
	WebElement creditExtnReference;
	
	//@FindBy(css="#ui-accordiontab-0-content > div > form > div > div.savecancel.morebuttons > button.clickbut.maxwidth50")
	//@FindBy(xpath="p-accordion/div/p-accordiontab[1]/div[2]/div/form/div/div[2]/button[1]")
	@FindBy(className="clickbut maxwidth50")
	WebElement searchButton111;
	
	@FindBy(css=".ng-star-inserted tr:nth-child(2) td:nth-child(2) p-table div div div div.ui-table-scrollable-body table tbody tr td span>a")
	List<WebElement> linkCreditReference;
	
	/*@FindBy(css=".ng-star-inserted tr:nth-child(2) td:nth-child(2) p-table div div div div.ui-table-scrollable-body table tbody tr:nth-child(2) td span a")
	WebElement linkCreditReferenceTwo;*/
	
	
	@FindBy(css="/html/body/app-component/app-shell/header/nav/div/div[2]/ul[1]/li[1]/a")
	WebElement manageCredit;
		
	@FindBy(css="[class*='fa fa-caret-right cursor-hand collapsed ng-star-inserted'][data-target='#832']")
	WebElement financeDropdown;
		
	
	
	String elementPathOfListOfFinanceValues="#menu-content ul[class*='sub-menu'][id='832'] a";
	
	@FindBy(css="[class*='ui-dropdown-trigger ui-state-default ui-corner-right']>span")
	WebElement rePaymentMethodDropdown;
	
	
	
	String elementPathOfListOfRePayment ="[class*='ui-dropdown-items-wrapper']>ul>li>span";
	
	
	@FindBy(css="[name='PaymentReference']")
	WebElement paymentReference;
	
	@FindBy(css="[name='CreditIBANAccount']")
	WebElement rPMIBAN79;
	
	@FindBy(css="[name='PermanentOrderAmt']")
	WebElement rePaymentAmount;
	
	@FindBy(css="div[class*='col-sm-12 no-padding elementright'] button:nth-child(1)")
	WebElement newButton495;
	
	@FindBy(css="div[class*='col-sm-12 no-padding elementright'] button:nth-child(2)")
	WebElement updateButton225;
	
	@FindBy(css="div[class*='col-sm-12 no-padding elementright'] button:nth-child(3)")
	WebElement ddCloseButton221;

	@FindBy(css="div[class*='col-sm-12 no-padding elementright'] button:nth-child(4)")
	WebElement suspendButton;
	
	@FindBy(css="[name='DirectDebitNbr']")
	WebElement directDebitID;
	
	@FindBy(css="[name='IBANAccount']")
	WebElement dDMIBAN79;
	
	@FindBy(css="input[name='StartDate']")
	WebElement startDate;
	
	@FindBy(css="p-calendar[name='StartDate']")
	WebElement startdate;
	
	@FindBy(css="p-calendar[name='EndDate']")
	WebElement enddate;
	
	@FindBy(css="input[name='EndDate']")
	WebElement endDate;
	
	@FindBy(css="input[name='SuspendDate']")
	WebElement suspendDate;
	
	@FindBy(css="p-calendar[name='SuspendDate']")
	WebElement suspenddate;
	
	@FindBy(css="input[name='Until']")
	WebElement until;
	
	@FindBy(css="p-calendar[name='Until']")
	WebElement untildate;
	
	@FindBy(css="[name='BICCode']>span>input")
	WebElement BIC;
	
	
	//@FindBy(css="p-dropdown[name='ProductFamily'] span")
	
	@FindBy(xpath="/html/body/app-component/app-shell/section/div/div/div/credit-module/div/search-credit/div/p-accordion/div/p-accordiontab[1]/div[2]/div/form/div/div[1]/div/div[1]/div/p-dropdown/div/label")
	WebElement productFamilyDropdown;
	
	/*@FindBy(css="div[class*='ng-tns-c3-2 ui-dropdown-panel'] div ul li")
	List<WebElement> listOfProductFamily;*/
	
	String elementPathOfListOfProductFamily= "div[class*='ng-tns-c3-2 ui-dropdown-panel'] div ul li >span";
		
	@FindBy(css=".ui-table-tbody tr td:nth-child(2)")
	List<WebElement> creditDossierNr;
	
	@FindBy(css=".ui-table-tbody tr td:nth-child(1) span a i")
	List<WebElement> clickPlus;
	
	@FindBy(css=".ui-table-tbody tr:nth-child(2) td:nth-child(2) a")
	WebElement creditDossierLink;
	
	@FindBy(css="[class*='pull-right clickbut maxwidth20']")
	WebElement createButton;

	@FindBy(css="[class*='ui-dropdown-trigger ui-state-default ui-corner-right'] span")
	WebElement transactionTypedropdown;
	
	/*@FindBy(css=".ui-dropdown-items-wrapper ul li")
	List<WebElement> listOfTransactionType;*/
	
	String elementPathOfListOfTransactionType= ".ui-dropdown-items-wrapper>ul>li>span";
	
	@FindBy(css="p-calendar[class*='ng-tns-c9-36']>span>input")
	WebElement valueDate;
	
	@FindBy(css="[name='AmountColon']")
	WebElement amount;
		
	@FindBy(css="[class*='clickbut maxwidth30 ng-star-inserted'][type='submit']")
	WebElement saveButton220;
	
	/*@FindBy(css="div[class*='panel-heading borrad noborder'] button:nth-child(2)")
	WebElement ddCloseButton221;*/
	
	@FindBy(css="div[class*='panel-heading borrad noborder'] button:nth-child(2) span")
	WebElement cmtCloseButton;
			
	@FindBy(css="[class*='pull-right clickbut maxwidth20 ']")
	WebElement addEL363;
	
	@FindBy(css="[class*='ng-tns-c3-37 ui-dropdown ui-widget']>div>span")
	WebElement transcationEIType;
	
	/*@FindBy(css=".ui-dropdown-items-wrapper ul li")
	List<WebElement> listOfTranscationEIType;*/
	
	
	String elementPathOfListOfTransactionELType = "[class*='ui-dropdown-items-wrapper']>ul>li>span";
	
	
	@FindBy(css="[class*='table_cell nofloat control-input righticonwithinput']>input")
	WebElement transactionEiAmount;
		
	/*@FindBy(css="div[class*='panel panel-default heading pull-left'] div div button span")
	WebElement closeFinInfobutton;*/
	
	@FindBy(css="[class*='clickbut maxwidth50'][type='submit']")
	WebElement clickFilterButton;
	
	
	@FindBy(css="div[class*='ui-dropdown-trigger ui-state-default ui-corner-right']>span")//div[class*='ng-tns-c3-43 ui-dropdown ui-widget ui'] div span 
	WebElement txnTypeFinInfoDropdown;
	
	/*@FindBy(css="div[class*='ui-dropdown-items-wrapper'] ul li ")
	List<WebElement> listOfTranscationTypeFinInfo;*/
	
	String elementPathOfTxnTypeFinInfo= "[class*='ui-dropdown-items-wrapper']>ul>li>span";
	
	@FindBy(css="[name='TxAmountField']")
	WebElement txnAmountFinInfo;
	
	
	@FindBy(css="table[class*='ui-table-scrollable-body-table'] tbody tr:nth-child(2) td div:nth-child(2) td span a")
	WebElement creditReferenceLinkTest711;
	
	
	@FindBy(xpath="//button[@class='pull-right clickbut maxwidth20'][text()='303 Add New Simulation']")
	WebElement addNewSimulation;
	
	@FindBy(css="[class='ui-dropdown-trigger ui-state-default ui-corner-right']>span")
	WebElement amortizationReCalculation;
	
	String elementPathOfListOfAmortizationReCalculation = "[class*='ui-dropdown-items-wrapper']>ul>li";
	
	@FindBy(css="[id='NetAndGrossSimulation_Net/Gross simulation']>div>div>span")
	WebElement netGrossSimulation;
	
	@FindBy(css="input[name='NotificationDate']")
	WebElement notificationDate;
	
	@FindBy(css="input[name='ExpectedPrepaymentDate']")
	WebElement expectedPrepaymentDate;
	
	@FindBy(xpath="//button[@class='pull-right clickbut maxwidth20 custom-btn-active'][text()='304 Simulate Prepayment']")
	WebElement simulationPrepayment;
	
	@FindBy(css="[class='pull-right clickbut maxwidth20 custom-btn-active']")
	WebElement simulationprepayment;

	@FindBy(css="input[name='PrincipalPrepaymentAmount']")
	WebElement principalPrepaymentAmount;

	@FindBy(css="button[class*='pull-right clickbut margin-right-10px maxwidth20']")
	WebElement chargePrepayment;
	
	@FindBy(xpath="//span[@class='ui-button-text ui-clickable'][text()='834 Yes']")
	WebElement yesInChargePrepayment;

	@FindBy(css="[class*='ui-table-scrollable-body-table']>tbody>tr")
	WebElement filterDetails;
	
	@FindBy(css="[name='Name']")
	WebElement name66;
	
	@FindBy(css="[class*='form-group col-sm-12 table_01 fb-clearnone no-padding']:nth-child(5)>div>input")
	WebElement mainBorrowerName;
	
	@FindBy(css="button[type='button'][disabled]")
	WebElement chargeprepayment;
	
	@FindBy(xpath="//h3[@class='panel-title pull-left col-sm-6 no-padding'][text()='1025 Validity of Simulated Prepayment']")
	WebElement validityOfSimulatedPrepayment;
	
	@FindBy(xpath="//h3[@class='panel-title pull-left col-sm-6 no-padding'][text()='Expected Cash Flow']")
	WebElement expectedCashFlow;
	
	@FindBy(xpath="//h3[@class='panel-title pull-left col-sm-4 no-padding'][text()='1024 Allowed Expected Prepayment Date Interval']")
	WebElement allowedExpectedPrepaymentDateInterval;
	
	@FindBy(css="div>table th>span[class='ng-star-inserted']")
	List<WebElement> prepaymentSimulationsDetails_header;
	
	@FindBy(css="div>table tr:nth-child(1) td")
	List<WebElement> simulationsDetails_row;
	
	/*
	 * Constructor of the class
	 * 
	 * @param driver
	 *            : Webdriver
	 * @return 
	 */
	public SearchCreditPage(WebDriver driver, ExtentTest report) {
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
			Log.fail("Search Credit Page did not open up", driver, extentedReport);
		}

		uielement = new ElementLayer(driver);
	}

	
	protected void load() {

		isPageLoaded = true;
		WaitUtils.waitForElement(driver, searchCredit);
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
		if (!WaitUtils.waitForElement(driver, menuText) && !WaitUtils.waitForElement(driver, searchCredit))
			throw new Exception("Dashboard Page is not loaded");
		return true;
	}
	
	
	/*
	 * To Enter Credit Extn Reference
	 * 
	 * @param pwd
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
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
	
	
	
	public void navigateToSearchBuyToLetPage(String manageCredit_SearchBuyToLet, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForSpinner(driver);
			WebElement mc=  driver.findElement(By.partialLinkText("MANAGE CREDIT"));			
			mc.click();
			//manageCredit.click();			
			//Log.message("Clicked manage Credit menu : " , driver, extentedReport);
			//List<WebElement> managecreditmenuItems = driver.findElements(By.xpath("/html/body/app-component/app-shell/header/nav/div/div[2]/ul[1]/li[1]/a"));
			//List<WebElement> managecreditmenuItems2 = driver.findElements(By.linkText("javascript:void(0)"));
			//WebElement mc1=  driver.findElement(By.partialLinkText("Search Buy To Let"));
			//mc1.click();
			//String l2Category = "Search Buy To Let";
			driver.findElement(By.cssSelector("a[title = '"+manageCredit_SearchBuyToLet+"']")).click();
			load();
			//a[title = 'Search Buy To Let']
			//List<WebElement> managecreditmenuItems1 = driver.findElements(By.xpath("/html/body/app-component/app-shell/header/nav/div/div[2]/ul[1]/li[1]/div"));
		//for(WebElement a: managecreditmenuItems1)
			//{		  
			//		if(a.getText().equalsIgnoreCase("Search Buy To Let")) {
			//			a.click();
			//			break;
			//}
			Log.message("Selected Type : Search Buy To Let ", driver, extentedReport, true);
			
		} catch (Exception e) {
			throw new Exception("Unable to locate Search Buy to Let screen : " + e);
		}
	}
	
	public void navigateToViewLinkDirtyPayments(String manageCredit_ViewLinkDirtyPayments, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForSpinner(driver);
			WebElement mc=  driver.findElement(By.partialLinkText("MANAGE CREDIT"));			
			mc.click();		
			driver.findElement(By.cssSelector("a[title = '"+manageCredit_ViewLinkDirtyPayments+"']")).click();
			load();			
			Log.message("Selected Type : Link Dirty Payments ", driver, extentedReport, true);
			
		} catch (Exception e) {
			throw new Exception("Unable to locate View Link Dirty Payments screen : " + e);
		}
	}
	
	public void navigateToValidatePayments(String manageCredit_ValidatePayments, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForSpinner(driver);
			WebElement mc=  driver.findElement(By.partialLinkText("MANAGE CREDIT"));			
			mc.click();		
			driver.findElement(By.cssSelector("a[title = '"+manageCredit_ValidatePayments+"']")).click();
			load();				
			Log.message("Selected Type : Link Dirty Payments ", driver, extentedReport, true);
			
		} catch (Exception e) {
			throw new Exception("Unable to locate Validate Payments screen : " + e);
		}
	}
	
	public void navigateToViewMortgageDossierRequests(String manageCredit_navigateToViewMortgageDossierRequests, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForSpinner(driver);
			WebElement mc=  driver.findElement(By.partialLinkText("MANAGE CREDIT"));			
			mc.click();		
			driver.findElement(By.cssSelector("a[title = '"+manageCredit_navigateToViewMortgageDossierRequests+"']")).click();
			load();				
			Log.message("Selected Type : Link Dirty Payments ", driver, extentedReport, true);
			
		} catch (Exception e) {
			throw new Exception("Unable to locate ViewMortgageDossierRequests screen : " + e);
		}
	}
	
	public void navigateToSearchDeclarations(String manageCredit_SearchDeclarations, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForSpinner(driver);
			WebElement mc=  driver.findElement(By.partialLinkText("MANAGE CREDIT"));			
			mc.click();		
			driver.findElement(By.cssSelector("a[title = '"+manageCredit_SearchDeclarations+"']")).click();
			load();				
			Log.message("Selected Type : Link Dirty Payments ", driver, extentedReport, true);
			
		} catch (Exception e) {
			throw new Exception("Unable to locate SearchDeclarations screen : " + e);
		}
	}
	
	public void navigateToAdministrativeHistoryOverview(String manageCredit_AdministrativeHistoryOverview, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForSpinner(driver);
			WebElement mc=  driver.findElement(By.partialLinkText("MANAGE CREDIT"));			
			mc.click();		
			driver.findElement(By.cssSelector("a[title = '"+manageCredit_AdministrativeHistoryOverview+"']")).click();
			load();				
			Log.message("Selected Type : Link Dirty Payments ", driver, extentedReport, true);
			
		} catch (Exception e) {
			throw new Exception("Unable to locate AdministrativeHistoryOverview screen : " + e);
		}
	}
	
	public void navigateToSearchIncomingPayments(String manageCredit_SearchIncomingPayments, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForSpinner(driver);
			WebElement mc=  driver.findElement(By.partialLinkText("MANAGE CREDIT"));			
			mc.click();		
			driver.findElement(By.cssSelector("a[title = '"+manageCredit_SearchIncomingPayments+"']")).click();
			load();				
			Log.message("Selected Type : Link Dirty Payments ", driver, extentedReport, true);
			
		} catch (Exception e) {
			throw new Exception("Unable to locate Search Incoming Payments screen : " + e);
		}
	}
	/*
	 * Click Search Button
	 * 
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
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
		
	/*
	 * To select Item type of Product Family
	 * 
	 * @param Item Type Of Product family
	 * @param extentedReport
	 * @param screenshot
	 * @throws Exception
	 * 
	 */
	public void selectingProductFamily(String itemTypeOfProductFamily, ExtentTest extentedReport, boolean screenshot) throws Exception {
		try {
			WaitUtils.waitForElement(driver, productFamilyDropdown);
			//WaitUtils.waitForSpinner(driver);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", productFamilyDropdown);
			//productFamilyDropdown.click();
			//WaitUtils.waitForSpinner(driver);
			List<WebElement> links = driver.findElements(By.cssSelector(elementPathOfListOfProductFamily));
				
			for(WebElement a: links)
			{		  
					if(a.getText().equalsIgnoreCase(itemTypeOfProductFamily)) {
						a.click();
						break;
					}
			}
			Log.message("Selected Type : " + itemTypeOfProductFamily, driver, extentedReport, true);

		} catch (Exception e) {
			Log.message("Error while selecting Product Family : " + e);
		}
	}
	
//	public void searchCreditExternalReference(String creditReference, ExtentTest extentedReport, boolean screenshot) throws Exception {
//		try {
//			WaitUtils.waitForElement(driver, productFamilyDropdown);
//			//WaitUtils.waitForSpinner(driver);
//			JavascriptExecutor executor = (JavascriptExecutor) driver;
//			executor.executeScript("arguments[0].click();", productFamilyDropdown);
//			//productFamilyDropdown.click();
//			//WaitUtils.waitForSpinner(driver);
//			List<WebElement> links = driver.findElements(By.cssSelector(elementPathOfListOfProductFamily));
//				
//			for(WebElement a: links)
//			{		  
//					if(a.getText().equalsIgnoreCase(itemTypeOfProductFamily)) {
//						a.click();
//						break;
//					}
//			}
//			Log.message("Selected Type : " + itemTypeOfProductFamily, driver, extentedReport, true);
//
//		} catch (Exception e) {
//			Log.message("Error while selecting Product Family : " + e);
//		}
//	}
	
	public boolean isAlertPresent() throws TimeoutException{
	    boolean foundAlert = false;
	    WebDriverWait wait = new WebDriverWait(driver, 30 /*timeout in seconds*/);
	    wait.until(ExpectedConditions.alertIsPresent());
		foundAlert = true;
	    return foundAlert;
	}
	
	/*
	 * Clicking the Finance dropdown and Direct debit option
	 * */	
	
	public void clickFinancebutton(ExtentTest extentedReport, boolean screenshot) throws Exception {
		try {
			WaitUtils.waitForElement(driver, financeDropdown);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", financeDropdown);
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked Finance button ", driver, extentedReport);
		} catch (Exception e) {
			Log.message("Error while selecting Finance button : " + e);
		}
	}
	
	/*
	 * Selecting the Finance button
	 * @param Item Type Of Finance option
	 * @param extentedReport
	 * @param screenshot
	 * @throws Exception
	 * */
	
	public void selectingFinanceOption(String financeOption,ExtentTest extentedReport, boolean screenshot)throws Exception {
		try{
			int i = 0;
			WaitUtils.waitForSpinner(driver);
			List<WebElement> links = driver.findElements(By.cssSelector(elementPathOfListOfFinanceValues));
			for(WebElement a: links)
			{		  
				System.out.println(links.size());
				System.out.println(a.getText());
					if(a.getText().equalsIgnoreCase(financeOption)) {
				   		a.click();
				   		WaitUtils.waitForSpinner(driver);
						break;
					}
					i++;
			}
			Log.message("Selected Type : " + financeOption, driver, extentedReport, true);
		}catch (Exception e) {
			Log.message("Error while selecting Finance option button : " + e);
		}
				
	}
	
	
	
	/*
	 * Click Web Element Plus Icon
	 * 
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void clickPlusIcon(String creditDossier, String creditFormattedReference, ExtentTest extentedReport, boolean screenshot) throws Exception {
		try {
			
			if (creditDossierNr.size() == 0) {
				Log.message("No Item is available", driver, extentedReport, false);
			}

			for (int loopCount = 0; loopCount < creditDossierNr.size(); loopCount++) {
				String displayedItemName = creditDossierNr.get(loopCount).getText();
				if (displayedItemName.equalsIgnoreCase(creditDossier)) {
					Log.message(creditDossier + "is found", driver,extentedReport, screenshot);
					//clickPlus.get(loopCount).click();
				//WaitUtils.waitForSpinner(driver);
				int i = loopCount+2;
				List<WebElement> creditReferrence = driver.findElements(By.cssSelector(".ng-star-inserted tr:nth-child("+i+") td:nth-child(2) p-table div div div div.ui-table-scrollable-body table tbody tr td span>a"));
				for(int count = 0; count < creditReferrence.size(); count++){
					String displayedCreditReferrence = creditReferrence.get(count).getText();
					if (displayedCreditReferrence.contains(creditFormattedReference)) {
						Log.message(creditFormattedReference + "is found", driver,extentedReport, screenshot);
						Actions action =new Actions(driver);
						action.moveToElement(creditReferrence.get(count)).click().build().perform();
						
						//creditReferrence.get(count).click();
					WaitUtils.waitForSpinner(driver);
					break;
					}
				}
				}
			}
		} catch (Exception e) {
			throw new Exception("Error while clicking Plus link : " + e);
		}
	}
	
	/*
	 * Click Web Element Dossier Link
	 * 
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void clickCreditReferenceDossier(ExtentTest extentedReport, boolean screenshot) throws Exception {
		try {
			WaitUtils.waitForElement(driver, creditDossierLink);
			WaitUtils.waitForSpinner(driver);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", creditDossierLink);
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked Dossier link ", driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while clicking Dossier link : " + e);
		}
	}
		
	
	/*
	 * Enter the value like 
	 * @param Transaction type
	 * @param amount
	 * @param extentedReport
	 * @throws Exception
	 * */
	
	public void enterCreateManualTransactionDetails(String transactiontype, String valuedate, String amount, ExtentTest extentedReport, boolean screenshot ) throws Exception {
		
		try {
			selectingTransactionTypeDropdown(transactiontype,extentedReport);
			enterValueDate(valuedate, extentedReport);
			enterAmount(amount,extentedReport);
			WaitUtils.waitForSpinner(driver);	
		}
		catch(Exception e) {
			throw new Exception("Error while entering the fields : " + e);
		}
	}
	
	/*
	 * Selecting the transaction type as Charging of costs
	 * @param Item type of transaction
	 * @param extentedReport
	 * @throws Exception
	 * */
	
	

	public void selectingTransactionTypeDropdown(String itemTypeOfTranscation, ExtentTest extentedReport) throws Exception {
		try {
			WaitUtils.waitForElement(driver, transactionTypedropdown);
			WaitUtils.waitForSpinner(driver);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", transactionTypedropdown);
			//transactionTypedropdown.click();
			WaitUtils.waitForSpinner(driver);
			List<WebElement> links = driver.findElements(By.cssSelector(elementPathOfListOfTransactionType));
			
			for(WebElement a: links)
			{
				   if(a.getText().equalsIgnoreCase(itemTypeOfTranscation)) {   
				   a.click();
				   break;
				   }
			}
			
			Log.message("Selected Type : " + itemTypeOfTranscation, driver, extentedReport, true);
		
		} catch (Exception e) {
			Log.message("Error while selecting Transaction type : " + e);
		}
	}
	
	
	/*
	 * Entering the Value Date
	 * @param value date
	 * @param ExtenetReport
	 * @throws Exception
	 * */
	
	public void enterValueDate(String valueDATE, ExtentTest extentedReport)  throws Exception{
		try {
			WaitUtils.waitForElement(driver, valueDate);
			valueDate.clear();
			Thread.sleep(1000);
			valueDate.click();
			valueDate.sendKeys(valueDATE);
			valueDate.click();
			amount.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Entered Credit Reference : " + valueDATE, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering Value Date : " + e);
		}
			
	}
		
	
	/*
	 * Entering the Amount
	 * @param Amount
	 * @param ExtenetReport
	 * @throws Exception
	 * */
	
	public void enterAmount(String Amount, ExtentTest extentedReport)  throws Exception{
		try {
			WaitUtils.waitForElement(driver, amount);
			amount.clear();
			amount.sendKeys(Amount,Keys.TAB);
			Log.message("Entered Credit Reference : " + Amount, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering Amount : " + e);
		}
			
	}
	
	/*
	 * Click Web Element ADD EI
	 * 
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void clickAddEIButton(ExtentTest extentedReport, boolean screenshot) throws Exception {
		try {
			WaitUtils.waitForElement(driver, addEL363);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", addEL363);
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked Add EI ", driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while clicking Add EI : " + e);
		}
	}

	
	/*
	 * Enter the value like 
	 * @paramTransaction type
	 * @param Amount
	 * */
	
	public void enterCreateTransactionElements(String transactiontypeElement, String amountElement, ExtentTest extentedReport, boolean screenshot) throws Exception {
		
		try {
			selectingTransactionELTypeElementDropdown(transactiontypeElement,extentedReport);
			enterAmountElement(amountElement,extentedReport);
			WaitUtils.waitForSpinner(driver);
		}
		catch(Exception e) {
			throw new Exception("Error while entering the fields : " + e);
			
		}
	}
	
	/*
	 * Selecting the transaction El type as Charging of costs
	 * @param Item type of transaction EL 
	 * @param extentedReport
	 * @throws Exception
	 * */
	
	public void selectingTransactionELTypeElementDropdown(String trxnTypeElmt, ExtentTest extentedReport)throws Exception {
		
		try {
			WaitUtils.waitForElement(driver, transcationEIType);
			WaitUtils.waitForSpinner(driver);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", transcationEIType);
			//productFamilyDropdown.click();
			WaitUtils.waitForSpinner(driver);
			List<WebElement> links = driver.findElements(By.cssSelector(elementPathOfListOfTransactionELType));
				
			for(WebElement a: links)
			{
				   if(a.getText().equalsIgnoreCase(trxnTypeElmt)) {
				   a.click();
				   break;
				   }
			}
			Log.message("Selected Type : " + trxnTypeElmt, driver, extentedReport, true);
		} catch (Exception e) {
			Log.message("Error while selecting Transaction type : " + e);
		}
	}

	/*
	 * Entering the Amount
	 * @param amount
	 * @param extentedReport
	 * @throws exception
	 * */
	
	public void enterAmountElement(String AmountElement, ExtentTest extentedReport)  throws Exception{
		try {
			WaitUtils.waitForElement(driver, transactionEiAmount);
			transactionEiAmount.clear();
			transactionEiAmount.click();
			transactionEiAmount.sendKeys(AmountElement);
			Log.message("Entered Credit Reference : " + AmountElement, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering Amount : " + e);
		}	
	}
	
	/*
	 * Clicking the save button
	 * @param extentedReport
	 * @throws exception
	 * */
	
	public void clickSaveButton(ExtentTest extentedReport, boolean screenshot) throws Exception {
		try {
			WaitUtils.waitForElement(driver, saveButton220);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", saveButton220);
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked Save Button ", driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while clicking save Button : " + e);
		}
	}
	
	/*
	 * Enter the value like 
	 * @paramTransaction type
	 * @param Amount
	 * */
	
	public void enterFilterDetails(String FinInfoTxnType, String AmountFinInfo, ExtentTest extentedReport, boolean screenshot) throws Exception {
		
		try {
			selectingFinInfoTransactionType(FinInfoTxnType,extentedReport);
			enterFinInfoAmount(AmountFinInfo,extentedReport);
			WaitUtils.waitForSpinner(driver);
		}
		catch(Exception e) {
			throw new Exception("Error while entering the fields : " + e);
			
		}
	}
	
	/*
	 * Selecting the Finance transaction type as 
	 * @param Item type of transaction 
	 * @param extentedReport
	 * @throws Exception
	 * */
	
	public void selectingFinInfoTransactionType(String FinInfoTxnType,ExtentTest extentedReport )throws Exception{
		try {
			
			WaitUtils.waitForElement(driver, txnTypeFinInfoDropdown);
			WaitUtils.waitForSpinner(driver);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", txnTypeFinInfoDropdown);
			//productFamilyDropdown.click();
			WaitUtils.waitForSpinner(driver);
			List<WebElement> links = driver.findElements(By.cssSelector(elementPathOfTxnTypeFinInfo));
				
			for(WebElement a: links)
			{
				   if(a.getText().equalsIgnoreCase(FinInfoTxnType)) {
				   a.click();
				   break;
				   }
			}
			Log.message("Selected Type : " + FinInfoTxnType, driver, extentedReport, true);
		} catch (Exception e) {
			Log.message("Error while selecting Transaction type Finance info : " + e);
		}
	}
	
	/*
	 * Entering the finance  Amount
	 * @param amount
	 * @param extentedReport
	 * @throws exception
	 * */
	
	
	public void enterFinInfoAmount(String AmountFinInfo, ExtentTest extentedReport)  throws Exception{
		try {
			WaitUtils.waitForElement(driver, txnAmountFinInfo);
			txnAmountFinInfo.clear();
			txnAmountFinInfo.sendKeys(AmountFinInfo);
			Log.message("Entered Credit Reference : " + AmountFinInfo, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering Amount Finance info : " + e);
		}	
	}
	
	/*
	 * Clicking the Filter button
	 * @param extentedReport
	 * @throws exception
	 * */
	public void clickFilterButton(ExtentTest extentedReport, boolean screenshot)  throws Exception{
		try {
			WaitUtils.waitForElement(driver, clickFilterButton);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", clickFilterButton);
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked Filter Button ", driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while clicking Filter Button : " + e);
		}
	}

	/*
	 * Selecting the Re-payment transaction type as 
	 * @param Item type of transaction 
	 * @param extentedReport
	 * @throws Exception
	 * */
	
	public void selectingRePaymentMethod(String FinInfoTxnType,ExtentTest extentedReport )throws Exception{
		try {
			
			WaitUtils.waitForElement(driver, rePaymentMethodDropdown);
			WaitUtils.waitForSpinner(driver);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", rePaymentMethodDropdown);
			//productFamilyDropdown.click();
			WaitUtils.waitForSpinner(driver);
			List<WebElement> links = driver.findElements(By.cssSelector(elementPathOfListOfRePayment));
				
			for(WebElement a: links)
			{
				   if(a.getText().equalsIgnoreCase(FinInfoTxnType)) {
				   a.click();
				   break;
				   }
			}
			Log.message("Selected Type : " + FinInfoTxnType, driver, extentedReport, true);
		} catch (Exception e) {
			Log.message("Error while selecting Transaction type Finance info : " + e);
		}
	}
	
	/*
	 * Entering the Direct Debt
	 * @param Direct debt value
	 * @param extentedReport
	 * @throws exception
	 * */
	
	public void enterDirectDebitID(String directDebitid, ExtentTest extentedReport)  throws Exception{
		try {
			WaitUtils.waitForElement(driver, directDebitID);
			directDebitID.clear();
			directDebitID.sendKeys(directDebitid);
			Log.message("Entered Credit Reference : " + directDebitid, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering Direct debit ID : " + e);
		}	
	}
	
	/*
	 * Entering the Direct Debt mandate IBAN
	 * @param Direct debt IBAN value
	 * @param extentedReport
	 * @throws exception
	 * */
	
	public void enterDirectDebitMandateIBAN(String iban, ExtentTest extentedReport)  throws Exception{
		try {
			WaitUtils.waitForElement(driver, dDMIBAN79);
			dDMIBAN79.clear();
			dDMIBAN79.sendKeys(iban);
			Log.message("Entered IBAN Account : " + iban, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering IBAN Account in Direct Debit mandate : " + e);
		}	
	}
	
	/*
	 * Entering the Start date
	 * @param start date value
	 * @param extentedReport
	 * @throws exception
	 * */
	
	public void enterStartDate(String startdate, ExtentTest extentedReport)  throws Exception{
		try {
			WaitUtils.waitForElement(driver, startDate);
			startDate.clear();
			Thread.sleep(1000);
			startDate.click();
			startDate.sendKeys(startdate);
			startDate.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Entered the Date date for expected prepayment date : " + startdate, driver, extentedReport, true);
		} catch (Exception e) {
			throw new Exception("Error while entering start date : " + e);
		}	
	}
	
	/*
	 * Entering the payment reference
	 * @param reference
	 * @param extentedReport
	 * @throws exception
	 * */
	
	public void enterPaymentReference(String paymentreference, ExtentTest extentedReport)  throws Exception{
		try {
			WaitUtils.waitForElement(driver, paymentReference);
			paymentReference.clear();
			paymentReference.sendKeys(paymentreference);
			Log.message("Entered Credit Reference : " + paymentreference, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering Payment reference : " + e);
		}	
	}
	
	/*
	 * Entering the Re-Payment amount
	 * @param re payment value
	 * @param extentedReport
	 * @throws exception
	 * */
	
	public void enterRePaymentAmount(String repaymentAmount, ExtentTest extentedReport)  throws Exception{
		try {
			WaitUtils.waitForElement(driver, rePaymentAmount);
			rePaymentAmount.clear();
			rePaymentAmount.sendKeys(repaymentAmount);
			Log.message("Entered Credit Reference : " + repaymentAmount, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering Re-Payment amount : " + e);
		}	
	}
	
	/*
	 * Entering the re-payment IBAN
	 * @param Re-payment IBAN
	 * @param extentedReport
	 * @throws exception
	 * */
	
	public void enterRePaymentIBAN(String creditIBANAccount, ExtentTest extentedReport)  throws Exception{
		try {
			WaitUtils.waitForElement(driver, rPMIBAN79);
			rPMIBAN79.clear();
			rPMIBAN79.sendKeys(creditIBANAccount);
			Log.message("Entered Credit Reference : " + creditIBANAccount, driver, extentedReport);
		} catch (Exception e) {
			throw new Exception("Error while entering Repayment IBAN : " + e);
		}	
	}
	
	/*
	 * Verifying the End Date
	 * @param extentedReport
	 * @throws exception
	 * */
	
	public boolean verifyingEnddateEnable()  throws Exception{
		boolean enable=false;
		try {
			WaitUtils.waitForElement(driver, endDate);
			WaitUtils.waitForSpinner(driver);
			if(endDate.isEnabled()) {
				enable=true;
			}
			return enable;
			
		}catch(Exception e) {
			throw new Exception("Error while verifying the End date  : " + e);
		}
		
	}
	
	/*
	 * Verifying the Suspend Date
	 * @param extentedReport
	 * @throws exception
	 * */
	
	public boolean verifyingSuspenddateEnable()  throws Exception{
		boolean enable=false;
		try {
			WaitUtils.waitForElement(driver, suspendDate);
			WaitUtils.waitForSpinner(driver);
			if(suspendDate.isEnabled()) {
				enable=true;
			}
			return enable;
			
		}catch(Exception e) {
			throw new Exception("Error while verifying the Suspend date  : " + e);
		}
		
	}
	
	/*
	 * Verifying the Until
	 * @param extentedReport
	 * @throws exception
	 * */
	
	public boolean verifyingUntil()  throws Exception{
		boolean enable=false;
		try {
			WaitUtils.waitForElement(driver, until);
			WaitUtils.waitForSpinner(driver);
			if(until.isEnabled()) {
				enable=true;
			}
			return enable;
			
		}catch(Exception e) {
			throw new Exception("Error while verifying the until : " + e);
		}
		
	}
	
	/*
	 * Click Web Element Dossier Link
	 * 
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void clickCreditReferenceDossierTest711(ExtentTest extentedReport, boolean screenshot) throws Exception {
		try {
			WaitUtils.waitForElement(driver, creditReferenceLinkTest711);
			WaitUtils.waitForSpinner(driver);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", creditReferenceLinkTest711);
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked Dossier link ", driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while clicking Dossier link : " + e);
		}
	}
	
	/*
	 * Click Web Element Add New Simulation button
	 * 
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void clickAddNewSimulation(ExtentTest extentedReport, boolean screenshot) throws Exception {
		try {
			WaitUtils.waitForElement(driver, addNewSimulation);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", addNewSimulation);
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked Add New Simulation button", driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while clicking Add New Simulation button : " + e);
		}
	}
	
	/*
	 * Selected amortizationReCalculation
	 * 
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void selectAmortizationReCalculation(String amortizationreCalculation, ExtentTest extentTest, boolean screenshot) throws Exception {
		try {
			WaitUtils.waitForElement(driver, amortizationReCalculation);
			WaitUtils.waitForSpinner(driver);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", amortizationReCalculation);
			WaitUtils.waitForSpinner(driver);
			List<WebElement> links = driver.findElements(By.cssSelector(elementPathOfListOfAmortizationReCalculation));
			
			for(WebElement a: links)
			{
				   if(a.getText().equalsIgnoreCase(amortizationreCalculation)) {
				   a.click();
				   break;
				   }
			}
			Log.message("Selected amortization Recalculation : "+ amortizationreCalculation, driver, extentedReport, true);
			
		} catch (Exception e) {
			Log.message("Error while selecting amortization Recalculation : " + e);
		}
	}
	
	/*
	 * Selected notificationDate
	 * 
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void enterNotificationDate(String notificationdate, ExtentTest extentedReport, boolean screenshot)
			throws Exception {
		try {
			WaitUtils.waitForElement(driver, notificationDate);
			notificationDate.clear();
			Thread.sleep(1000);
			notificationDate.click();
			notificationDate.sendKeys(notificationdate);
			notificationDate.click();
			expectedPrepaymentDate.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Entered the Date date for notification date : " + notificationdate, driver, extentedReport, screenshot);
		} catch (Exception e) {
			throw new Exception("Error while entering date for notification date : " + e);
		}
	}
	
	/*
	 * Selected expected prepayment date 
	 * 
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void enterExpectedPrepaymentDate(String expectedprepaymentDate, ExtentTest extentedReport, boolean screenshot)
			throws Exception {
		try {
			WaitUtils.waitForElement(driver, expectedPrepaymentDate);
			expectedPrepaymentDate.clear();
			Thread.sleep(1000);
			expectedPrepaymentDate.click();
			expectedPrepaymentDate.sendKeys(expectedprepaymentDate);
			expectedPrepaymentDate.click();
			principalPrepaymentAmount.click();
			WaitUtils.waitForSpinner(driver);
			Log.message("Entered the Date date for expected prepayment date : " + expectedprepaymentDate, driver, extentedReport, screenshot);
		} catch (Exception e) {
			throw new Exception("Error while entering date for expected prepayment date : " + e);
		}
	}
	
	/*
	 * Click Web Element Add New Simulation button
	 * 
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void clickSimulationPrepayment(ExtentTest extentedReport, boolean screenshot) throws Exception {
		try {
			WaitUtils.waitForElement(driver, simulationPrepayment);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", simulationPrepayment);
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked simulation Prepayment button", driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while clicking simulation Prepayment button : " + e);
		}
	}
	
	/*
	 * Enter principal prepayment amount
	 * 
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void enterPrincipalPrepaymentAmount(String principalPrepaymentamount, ExtentTest extentedReport, boolean screenshot)
			throws Exception {
		try {
			WaitUtils.waitForElement(driver, principalPrepaymentAmount);
			principalPrepaymentAmount.clear();
			principalPrepaymentAmount.sendKeys(principalPrepaymentamount,Keys.TAB);
			WaitUtils.waitForSpinner(driver);
			Log.message(principalPrepaymentamount + " - principal prepayment amountis enterd ", driver, extentedReport, screenshot);
		} catch (Exception e) {
			throw new Exception("Error while entering principal prepayment amount : " + e);
		}
	}
	
	/*
	 * Click charge Prepayment
	 * 
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void clickChargePrepayment(ExtentTest extentedReport, boolean screenshot) throws Exception {
		try {
			WaitUtils.waitForElement(driver, chargePrepayment);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", chargePrepayment);
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked charge Prepayment button", driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while clicking charge Prepayment button : " + e);
		}
	}
	
	/**
	 * Click charge Prepayment
	 * 
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void clickYesInChargePrepayment(ExtentTest extentedReport, boolean screenshot) throws Exception {
		try {
			WaitUtils.waitForElement(driver, yesInChargePrepayment);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", yesInChargePrepayment);
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked Yes in charge Prepayment button", driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while clicking Yes in charge Prepayment button : " + e);
		}
	}
	

	/**
	 * Click Web Element Credit reference
	 * 
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void getLinkCreditReference(String creditReferrence, ExtentTest extentedReport, boolean screenshot)
			throws Exception {
		try {
			
			if (linkCreditReference.size() == 0) {
				Log.message("No Item is available", driver, extentedReport, false);
			}

			for (int loopCount = 0; loopCount < linkCreditReference.size(); loopCount++) {
				String displayedItemName = linkCreditReference.get(loopCount).getText();
				if (displayedItemName.contains(creditReferrence)) {
					Log.message(creditReferrence + "is found", driver,extentedReport, screenshot);
				linkCreditReference.get(loopCount).click();
				WaitUtils.waitForSpinner(driver);
				}
			}
		
		} catch (Exception e) {
			throw new Exception("Error while getting Added Item row in Outsied Home: " + e);
		}
	}
	
	/**
	 * Click Create Button
	 * 
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void clickCreateButton(ExtentTest extentedReport, boolean screenshot) throws Exception {
		try {
			WaitUtils.waitForElement(driver, createButton);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", createButton);
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked Create Button for Create manual transaction", driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while clicking Create button for Create manual transaction : " + e);
		}
	}
	
	/**
	 * Click new Button
	 * 
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void clickNewButton(ExtentTest extentedReport, boolean screenshot) throws Exception {
		try {
			WaitUtils.waitForElement(driver, newButton495);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", newButton495);
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked New Button for Direct Debit Mandate", driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while clicking New button for Direct Debit Mandate : " + e);
		}
	}
	
	/**
	 * verify Policy Detail In Add Buildings cover Section
	 * 
	 * @param expectedPolicyDetail
	 * @param extentedReport
	 * @return boolean
	 * 
	 */
	public boolean verifyNameDirectDebitMandate(ExtentTest extentedReport) throws Exception {
		try {
			boolean status = false;
			if(name66.getText().equalsIgnoreCase(mainBorrowerName.getText()))
			{
				status = true;
			}
			return status;
		} catch (Exception e) {
			throw new Exception("Error while verifying Name direct debit mandate : " + e);
		}
	}

	/**
	 * Enter principal prepayment amount
	 * 
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void enterBICCode(String bicCode, ExtentTest extentedReport, boolean screenshot)
			throws Exception {
		try {
			WaitUtils.waitForElement(driver, BIC);
			BIC.clear();
			BIC.sendKeys(bicCode);
			WaitUtils.waitForSpinner(driver);
			Log.message(bicCode + " - BIC code is enterd ", driver, extentedReport, screenshot);
		} catch (Exception e) {
			throw new Exception("Error while entering BIC code : " + e);
		}
	}
	
	/**
	 * Click update Button
	 * 
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void clickUpdateButton(ExtentTest extentedReport, boolean screenshot) throws Exception {
		try {
			WaitUtils.waitForElement(driver, updateButton225);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", updateButton225);
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked Update Button for Direct Debit Mandate", driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while clicking Update button for Direct Debit Mandate : " + e);
		}
	}
	
	/**
	 * Click close Button
	 * 
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void clickCloseButton(ExtentTest extentedReport, boolean screenshot) throws Exception {
		try {
			WaitUtils.waitForElement(driver, ddCloseButton221);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", ddCloseButton221);
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked Close Button for Direct Debit Mandate", driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while clicking Close button for Direct Debit Mandate : " + e);
		}
	}
	
	/**
	 * Verify Start Date is Disable
	 * 
	 * @param extentReport
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyStartDateIsDisable(ExtentTest extentReport) throws Exception {

		boolean status = false;
		if (startdate.getAttribute("class").contains("disable-calendar-button")) {
			status = true;
			Log.message("Strat date is disable");
		}
		else 
		{
			Log.message("Strat date is enable" + startdate);
		}
		return status;
	}
	
	/**
	 * Verify End Date is Disable
	 * 
	 * @param extentReport
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyEndDateIsDisable(ExtentTest extentReport) throws Exception {

		boolean status = false;
		if (enddate.getAttribute("class").contains("disable-calendar-button")) {
			status = true;
			Log.message("End date is disable");
		}
		else 
		{
			Log.message("End date is enable" + enddate);
		}
		return status;
	}
	
	/**
	 * Click suspend Button
	 * 
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void clickSuspendButton(ExtentTest extentedReport, boolean screenshot) throws Exception {
		try {
			WaitUtils.waitForElement(driver, suspendButton);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", suspendButton);
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked suspend Button for Direct Debit Mandate", driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while clicking suspend button for Direct Debit Mandate : " + e);
		}
	}
	
	/**
	 * Verify suspend Date is Disable
	 * 
	 * @param extentReport
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifySuspendDateIsDisable(ExtentTest extentReport) throws Exception {

		boolean status = false;
		if (suspenddate.getAttribute("class").contains("disable-calendar-button")) {
			status = true;
			Log.message("suspend date is disable");
		}
		else 
		{
			Log.message("suspend date is enable" + suspenddate);
		}
		return status;
	}
	
	/**
	 * Verify until Date is Disable
	 * 
	 * @param extentReport
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyUntilDateIsDisable(ExtentTest extentReport) throws Exception {

		boolean status = false;
		if (untildate.getAttribute("class").contains("disable-calendar-button")) {
			status = true;
			Log.message("until date is disable");
		}
		else 
		{
			Log.message("until date is enable" + untildate);
		}
		return status;
	}
	
	/**
	 * Click net Gross Simulation Button
	 * 
	 * @param extentedReport
	 * @throws Exception
	 * 
	 */
	public void clickNetGrossSimulation(ExtentTest extentedReport, boolean screenshot) throws Exception {
		try {
			WaitUtils.waitForElement(driver, netGrossSimulation);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", netGrossSimulation);
			WaitUtils.waitForSpinner(driver);
			Log.message("Clicked Net Gross Simulation Button", driver, extentedReport);
			
		} catch (Exception e) {
			throw new Exception("Error while clicking Net Gross Simulation Button : " + e);
		}
	}
	
	/**
	 * Verify simulation prepayment button is Disable
	 * 
	 * @param extentReport
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifySimulationPrepaymentIsEnable(ExtentTest extentReport) throws Exception {
		try{
			boolean status = false;
			if (simulationprepayment.getAttribute("class").contains("disable-calendar-button")) {
				status = true;
				Log.message("simulation prepayment button is enable");
			}
			else 
			{
				Log.message("simulation prepayment button is disable" + simulationprepayment);
			}
			return status;
		}catch(Exception e){
			throw new Exception("Error while clicking Net Gross Simulation Button : " + e);
		}
	}
	
	/**
	 * Verify Charge Prepaymentis Disable
	 * 
	 * @param extentReport
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyChargePrepaymentIsDisable(ExtentTest extentReport) throws Exception {

		boolean status = false;
		if (chargeprepayment.getText().equalsIgnoreCase("Charge Prepayment")) {
			status = true;
			Log.message("Charge Prepayment Button is disable");
		}
		else 
		{
			Log.message("Charge Prepayment Button is enable" + untildate);
		}
		return status;
	}
	
	/**
	 * Verify Prepayment Simulations Details 
	 * 
	 * @param extentReport
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyPrepaymentSimulationsDetails(ExtentTest extentReport) throws Exception {

		boolean status = false;

		HashMap<String, String> hm = new HashMap<String, String>();

		for(int i=0; i<prepaymentSimulationsDetails_header.size();i++) {
			hm.put(prepaymentSimulationsDetails_header.get(i).getText(), simulationsDetails_row.get(i).getText());
		}
		if(hm.get("816 Is Charged").contains("Yes")){
			status = true;	
		}
		return status;
	}

	
	

}
