package com.davinci_Testscripts;

import java.io.IOException;
import java.util.Arrays;


import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.davinci.pages.LoginPage;
import com.davinci.pages.SearchByToLetPage;
import com.davinci.pages.SearchCreditPage;
import com.davinci.pages.SearchDeclarationsPage;

import com.davinci.pages.SelectSessionPage;
import com.davinci.pages.ValidatePaymentsPage;
import com.davinci.pages.ViewLinkDirtyPaymentsPage;
import com.davinci.pages.ViewMortgageDossierRequestsPage;
import com.generic.support.BaseTest;
import com.generic.support.EmailReport;
import com.generic.support.Log;
import com.generic.support.WebDriverFactory;
import com.generic.utils.DataProviderUtils;
import com.davinci.pages.AdministrativeHistoryOverviewPage;
import com.davinci.pages.GetTestData;
import com.davinci.pages.LinkDirtyPaymentsPage;
import com.relevantcodes.extentreports.ExtentTest;

@Listeners(EmailReport.class)
public class davinci_Script extends BaseTest {
	private String webSite;
	String sheetName = "davinci_Testscripts_";

	@BeforeMethod(alwaysRun = true)
	public void init(ITestContext context) throws IOException {
		webSite = System.getProperty("webSite") != null ? System.getProperty("webSite")
				: context.getCurrentXmlTest().getParameter("webSite");
	}

	public ExtentTest addTestInfo(String testCaseId, String testDesc) {
		String test = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getName();

		String browsername = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
				.getParameter("browser");
		String browserversion = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
				.getParameter("browser_version");
		String os = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("os").substring(0,
				1);
		String osversion = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
				.getParameter("os_version");
		String browserwithos = os + osversion + "_" + browsername + browserversion;

		return Log.testCaseInfo(testCaseId + " [" + test + "]",
				testCaseId + " - " + testDesc + " [" + browserwithos + "]", test);
	}

	@Test(description = "Direct debit flow", dataProviderClass = DataProviderUtils.class, dataProvider = "PureBroker")
	public void TC_001(String browser) throws Exception {

		String tcId = "TC_001";
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testData = new GetTestData(sheetName, tcId);
		Log.testCaseInfo(testData.description + "<small><b><i>[" + browser + "]</b></i></small>");

		ExtentTest extentedReport = addTestInfo(tcId, testData.description);
		try {

			LoginPage loginPage = new LoginPage(driver, webSite, extentedReport).get();
			Log.message("Login Page : " + webSite, driver, extentedReport, true);
			
			loginPage.loginToDavinci(testData.username, testData.password, extentedReport);
			
			SelectSessionPage selectsessionPage = new SelectSessionPage(driver, extentedReport).get();
			
			selectsessionPage.clickOnConsumerAndMortgageLendingButton();
			
			SearchCreditPage searchPage = new SearchCreditPage(driver, extentedReport).get();
			
			searchPage.navigateToSearchBuyToLetPage(testData.ManageCredit_SearchBuyToLet,extentedReport);
			
			SearchByToLetPage searchBuyToLetPage = new SearchByToLetPage(driver, extentedReport).get();
			
			searchBuyToLetPage.navigateToLinkDirtyPayments(testData.ManageCredit_LinkDirtyPayments,extentedReport);
			
			LinkDirtyPaymentsPage linkDirtyPaymentsPage = new LinkDirtyPaymentsPage(driver, extentedReport).get();
			
			linkDirtyPaymentsPage.clickCloseButton(extentedReport);
			
			//SearchCreditPage searchPage = new SearchCreditPage(driver, extentedReport).get();
			searchPage.navigateToViewLinkDirtyPayments(testData.ManageCredit_ViewLinkDirtyPayments, extentedReport);
			
			ViewLinkDirtyPaymentsPage viewlinkDirtyPaymentsPage = new ViewLinkDirtyPaymentsPage(driver, extentedReport).get();
			
			viewlinkDirtyPaymentsPage.clickCloseButton(extentedReport);
			
			searchPage.navigateToValidatePayments(testData.ManageCredit_ValidatePayments, extentedReport);
			
			ValidatePaymentsPage validatePaymentsPage = new ValidatePaymentsPage(driver, extentedReport).get();
			
			validatePaymentsPage.clickCloseButton(extentedReport);
			
			searchPage.navigateToViewMortgageDossierRequests(testData.ManageCredit_ViewMortgageDossierRequests, extentedReport);
			
			ViewMortgageDossierRequestsPage viewmortgagedossierrequestsPage = new ViewMortgageDossierRequestsPage(driver, extentedReport).get();
			
			viewmortgagedossierrequestsPage.clickCloseButton(extentedReport);
				
			searchPage.navigateToSearchDeclarations(testData.ManageCredit_SearchDeclarations, extentedReport);
			
			SearchDeclarationsPage searchdeclarationsPage = new SearchDeclarationsPage(driver, extentedReport).get();
			
			searchdeclarationsPage.clickCloseButton(extentedReport);
			
			searchPage.navigateToAdministrativeHistoryOverview(testData.ManageCredit_AdministrativeHistoryOverview, extentedReport);
			
			AdministrativeHistoryOverviewPage administrativehistoryoverviewPage = new AdministrativeHistoryOverviewPage(driver, extentedReport).get();
			
			administrativehistoryoverviewPage.clickCloseButton(extentedReport);
			
			searchPage.navigateToSearchIncomingPayments(testData.ManageCredit_SearchIncomingPayments, extentedReport);
			
			//SearchIncomingPaymentsPage searchincomingpaymentsPage = new SearchIncomingPaymentsPage(driver, extentedReport).get();
			
	
			
			
			
			
			
			
			//searchBuyToLetPage.enterCreditExtReference(testData.creditReferrenceNO,extentedReport);
			//searchBuyToLetPage.clickSearchButton(extentedReport);
			
			
			//searchPage.enterCreditExtReference(testData.creditReferrenceNO, extentedReport);
			
			
			//searchPage.selectingProductFamily(testData.productFamily, extentedReport, true);
			
			//searchPage.clickSearchButton(extentedReport);
			
			//searchPage.clickPlusIcon(testData.creditDossier, testData.creditFormattedReference, extentedReport, true);
			
//			searchPage.clickFinancebutton(extentedReport, true);
//			
//			searchPage.selectingFinanceOption(testData.financeOption, extentedReport, true);
//			
//			searchPage.selectingRePaymentMethod(testData.arrfinInfoTxnType[0], extentedReport);
//			
//			searchPage.clickNewButton(extentedReport, true);
//			
//			searchPage.enterDirectDebitID(testData.arrdirectDebitid[0], extentedReport);
//			
//			searchPage.enterDirectDebitMandateIBAN(testData.iban, extentedReport);
//			
//			searchPage.enterBICCode(testData.bicCode, extentedReport, true);
//			
//			searchPage.enterStartDate(testData.startdate, extentedReport);
//			
//			searchPage.clickSaveButton(extentedReport, true);
//
//			searchPage.clickUpdateButton(extentedReport, true);
//			
//			Log.softAssertThat(searchPage.verifyStartDateIsDisable(extentedReport), "Date fields are disable", "Date fields are enable", 
//					driver, extentedReport, true);
//			
//			searchPage.enterDirectDebitID(testData.arrdirectDebitid[1], extentedReport);
//			
//			searchPage.clickSaveButton(extentedReport, true);
//			
//			searchPage.clickCloseButton(extentedReport, true);
//			
//			Log.softAssertThat(!searchPage.verifyEndDateIsDisable(extentedReport), "End Date fields are enable", "End Date fields are disable", 
//					driver, extentedReport, true);
//			
//			searchPage.clickSuspendButton(extentedReport, true);
//			
//			Log.softAssertThat(!searchPage.verifySuspendDateIsDisable(extentedReport), "Suspend Date fields are enable", "Suspend Date fields are disable", 
//					driver, extentedReport, true);
//			
//			Log.softAssertThat(!searchPage.verifyUntilDateIsDisable(extentedReport), "Until Date fields are enable", "Until Date fields are disable", 
//					driver, extentedReport, true);
//			
//			searchPage.selectingRePaymentMethod(testData.arrfinInfoTxnType[1], extentedReport);
//			
//			searchPage.enterPaymentReference(testData.arrpaymentreference[0], extentedReport);
//			
//			searchPage.enterRePaymentIBAN(testData.rePaymentIBAN, extentedReport);
//			
//			searchPage.clickSaveButton(extentedReport, true);
//			
//			searchPage.selectingRePaymentMethod(testData.arrfinInfoTxnType[2], extentedReport);
//			
//			searchPage.enterPaymentReference(testData.arrpaymentreference[1], extentedReport);
//			
//			searchPage.enterRePaymentIBAN(testData.rePaymentIBAN, extentedReport);
//			
//			searchPage.enterRePaymentAmount(testData.amount, extentedReport);
//			
//			searchPage.clickSaveButton(extentedReport, true);
//			
			Log.testCaseResult(extentedReport);

		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			Log.endTestCase(extentedReport);
			driver.quit();
		}
	}
	
	@Test(description = "Create Manual TX & Financial info flow", dataProviderClass = DataProviderUtils.class, dataProvider = "PureBroker")
	public void TC_002(String browser) throws Exception {

		String tcId = "TC_002";
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testData = new GetTestData(sheetName, tcId);
		Log.testCaseInfo(testData.description + "<small><b><i>[" + browser + "]</b></i></small>");

		ExtentTest extentedReport = addTestInfo(tcId, testData.description);
		try {

			LoginPage loginPage = new LoginPage(driver, webSite, extentedReport).get();
			Log.message("Login Page : " + webSite, driver, extentedReport, true);
			
			loginPage.loginToDavinci(testData.username, testData.password, extentedReport);
			
			SearchCreditPage searchPage = new SearchCreditPage(driver, extentedReport).get();
			
			//searchPage.selectingProductFamily(testData.productFamily, extentedReport, true);
			
			searchPage.clickSearchButton(extentedReport);
			
			searchPage.clickPlusIcon(testData.creditDossier, testData.creditReferrenceNO, extentedReport, true);
			
			searchPage.clickFinancebutton(extentedReport, true);
			
			searchPage.selectingFinanceOption(testData.arrfinanceOption[0], extentedReport, true);
			
			searchPage.clickCreateButton(extentedReport, true);
			
			searchPage.enterCreateManualTransactionDetails(testData.arrtransactiontype[0], testData.valueDate, testData.amount, extentedReport, true);
			
			searchPage.clickAddEIButton(extentedReport, true);
			
			searchPage.enterCreateTransactionElements(testData.arrtransactiontype[1], testData.amount, extentedReport, true);
			
			searchPage.clickSaveButton(extentedReport, true);
			
			searchPage.selectingFinanceOption(testData.arrfinanceOption[1], extentedReport, true);
			
			searchPage.enterFilterDetails(testData.arrtransactiontype[0], testData.amount, extentedReport, true);
			
			searchPage.clickFilterButton(extentedReport, true);
			
			Log.softAssertThat(searchPage.uielement.verifyPageElements(Arrays.asList("filterDetails"), searchPage),
					"Create manual transaction details are saved successfuly", "Create manual transaction details are not saved", driver, extentedReport);
			
			Log.testCaseResult(extentedReport);

		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			Log.endTestCase(extentedReport);
			driver.quit();
		}
	}

	@Test(description = "Change Payment flow", dataProviderClass = DataProviderUtils.class, dataProvider = "PureBroker")
	public void TC_003(String browser) throws Exception {

		String tcId = "TC_003";
		final WebDriver driver = WebDriverFactory.get(browser);
		GetTestData testData = new GetTestData(sheetName, tcId);
		Log.testCaseInfo(testData.description + "<small><b><i>[" + browser + "]</b></i></small>");

		ExtentTest extentedReport = addTestInfo(tcId, testData.description);
		try {

			LoginPage loginPage = new LoginPage(driver, webSite, extentedReport).get();
			Log.message("Login Page : " + webSite, driver, extentedReport, true);
			
			loginPage.loginToDavinci(testData.username, testData.password, extentedReport);
			
			SearchCreditPage searchPage = new SearchCreditPage(driver, extentedReport).get();
			
			searchPage.enterCreditExtReference(testData.creditReferrenceNO, extentedReport);
			
			searchPage.clickSearchButton(extentedReport);
			
			searchPage.clickCreditReferenceDossier(extentedReport, true);
			
			searchPage.clickFinancebutton(extentedReport, true);
			
			searchPage.selectingFinanceOption(testData.financeOption, extentedReport, true);
			
			searchPage.clickAddNewSimulation(extentedReport, true);
			
			searchPage.selectAmortizationReCalculation(testData.amortizationreCalculation, extentedReport, true);
			
			searchPage.clickNetGrossSimulation(extentedReport, true);
			
			searchPage.enterNotificationDate(testData.notificationdate, extentedReport, true);
			
			searchPage.enterExpectedPrepaymentDate(testData.expectedprepaymentDate, extentedReport, true);
			
			searchPage.enterPrincipalPrepaymentAmount(testData.amount, extentedReport, true);
			
			
			
			Log.softAssertThat(searchPage.verifyChargePrepaymentIsDisable(extentedReport), 
					"Charge Prepayment button is disable", "Charge Prepayment button is enable", driver, extentedReport, true);
						
			searchPage.clickSimulationPrepayment(extentedReport, true);
			
			Log.softAssertThat(!searchPage.uielement.verifyPageElements(Arrays.asList("chargeprepayment"), searchPage),
					"Charge Prepayment button is enable", "Charge Prepayment button is disable", driver, extentedReport, true);
			
			Log.softAssertThat(searchPage.uielement.verifyPageElements(Arrays.asList("validityOfSimulatedPrepayment"), searchPage),
					"Validity Of Simulated Prepayment is displayed", "Validity Of Simulated Prepayment is not displayed", driver, extentedReport, true);
			
			Log.softAssertThat(searchPage.uielement.verifyPageElements(Arrays.asList("expectedCashFlow"), searchPage),
					"Expected Cash Flow is displayed", "Expected Cash Flow is not displayed", driver, extentedReport, true);
			
			searchPage.clickSaveButton(extentedReport, true);
			
			Log.softAssertThat(!searchPage.uielement.verifyPageElements(Arrays.asList("allowedExpectedPrepaymentDateInterval"), searchPage),
					"Allowed Expected Prepayment Date Interval is not displayed", "Allowed Expected Prepayment Date Interval is displayed", driver, extentedReport, true);
			
			Log.softAssertThat(!searchPage.verifyPrepaymentSimulationsDetails(extentedReport), 
					"Is Charged is set as NO", "Is Charged is set as Yes", driver, extentedReport, true);

			searchPage.clickSaveButton(extentedReport, true);
			
			searchPage.clickChargePrepayment(extentedReport, true);
			
			searchPage.clickYesInChargePrepayment(extentedReport, true);
			
			Log.softAssertThat(searchPage.verifyPrepaymentSimulationsDetails(extentedReport), 
					"Is Charged is set as Yes", "Is Charged is set as No", driver, extentedReport, true);
			
			Log.testCaseResult(extentedReport);

		} catch (Exception e) {
			Log.exception(e, driver, extentedReport);
		} finally {
			Log.endTestCase(extentedReport);
			driver.quit();
		}
	}

}