package com.davinci.pages;

import java.util.HashMap;

import org.testng.Reporter;
import org.testng.annotations.Listeners;

import com.generic.support.BaseTest;
import com.generic.support.EmailReport;
import com.generic.support.Log;
import com.generic.utils.DataUtils;

/**
 * Get TestData class is used for test data variable declaration globally and
 * use it in synchronized for parallel execution
 */

@Listeners(EmailReport.class)
public class GetTestData extends BaseTest {
	



	public HashMap<String, String> getTestData(String sheetName, String testcaseId) {
		String env = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("env");
		String className = sheetName + env;
		return DataUtils.testDatabyID(testcaseId, className);
	}

	public GetTestData(String sheetName, String tcId) throws Exception {
		try {
			HashMap<String, String> testData = getTestData(sheetName, tcId);
			getTestData(testData);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String description;
	public String username;
	public String password;
	public String creditDossier;
	public String creditFormattedReference;
	public String creditReferrenceNO;
	public String ManageCredit_SearchBuyToLet;
	public String ManageCredit_LinkDirtyPayments;
	public String ManageCredit_ViewLinkDirtyPayments;
	public String ManageCredit_ValidatePayments;
	public String ManageCredit_ViewMortgageDossierRequests;
	public String ManageCredit_SearchDeclarations;
	public String ManageCredit_AdministrativeHistoryOverview;
	public String ManageCredit_SearchIncomingPayments;
	
	public String financeOption;
	public String arrfinanceOption[];
	public String finInfoTxnType;
	public String arrfinInfoTxnType[];
	public String directDebitid;
	public String arrdirectDebitid[];
	public String iban;
	public String bicCode;
	public String startdate;
	public String paymentreference;
	public String arrpaymentreference[];
	public String rePaymentIBAN;
	public String arrayrePaymentMethod[];
	public String productFamily;
	public String chargingOfCosts;
	public String valueDate;
	public String amount;
	public String chargingOfPostageCosts;
	public String transactiontype;
	public String arrtransactiontype[];
	public String amortizationreCalculation;
	public String notificationdate;
	public String expectedprepaymentDate;
	
	
	
	public synchronized void getTestData(HashMap<String, String> testData) {
		
		description = testData.get("TC_Description");
		username = testData.get("username");
		password = testData.get("password");
		creditDossier = testData.get("credit_Dossier");
		creditReferrenceNO = testData.get("credit_Reference");
		creditFormattedReference=testData.get("credit_FormattedRef");
		ManageCredit_SearchBuyToLet=testData.get("ManageCredit_SearchBuyToLet");
		ManageCredit_LinkDirtyPayments=testData.get("ManageCredit_LinkDirtyPayments");
		ManageCredit_ViewLinkDirtyPayments=testData.get("ManageCredit_ViewLinkDirtyPayments");
		ManageCredit_ValidatePayments=testData.get("ManageCredit_ValidatePayments");
		ManageCredit_ViewMortgageDossierRequests=testData.get("ManageCredit_ViewMortgageDossierRequests");
		ManageCredit_SearchDeclarations=testData.get("ManageCredit_SearchDeclarations");
		ManageCredit_AdministrativeHistoryOverview=testData.get("ManageCredit_AdministrativeHistoryOverview");
		ManageCredit_SearchIncomingPayments=testData.get("ManageCredit_SearchIncomingPayments");
		//financeOption = testData.get("");
		//finInfoTxnType = testData.get("");
		//directDebitid = testData.get("");
		iban = testData.get("iban");
		bicCode = testData.get("bic_Code");
		startdate = testData.get("start_Date");
		//paymentreference = testData.get("");
		rePaymentIBAN= testData.get("rePayment_IBAN");
		//rePaymentMethod= testData.get("");
		productFamily= testData.get("product_Family");
		chargingOfCosts= testData.get("");
		valueDate=testData.get("value_Date");
		amount=testData.get("amount");
		chargingOfPostageCosts=testData.get("");
		//transactiontype = testData.get("");
		amortizationreCalculation = testData.get("amortizationre_Calculation");
		notificationdate = testData.get("notification_Date");
		expectedprepaymentDate = testData.get("expected_Prepayment_Date");
		
		try {
			directDebitid = testData.get("direct_Debitid");
			arrdirectDebitid = directDebitid.split("\\|");
		} catch (Exception e) {
			Log.event("address-->" + e);
		}
		try {
			finInfoTxnType = testData.get("fin_Info_Txn_Type");
			arrfinInfoTxnType = finInfoTxnType.split("\\|");
		} catch (Exception e) {
			Log.event("address-->" + e);
		}
		try {
			paymentreference = testData.get("payment_Reference");
			arrpaymentreference = paymentreference.split("\\|");
		} catch (Exception e) {
			Log.event("address-->" + e);
		}
		try {
			financeOption = testData.get("finance_Option");
			arrfinanceOption = financeOption.split("\\|");
		} catch (Exception e) {
			Log.event("address-->" + e);
		}
		try {
			transactiontype = testData.get("transaction_Type");
			arrtransactiontype = transactiontype.split("\\|");
		} catch (Exception e) {
			Log.event("address-->" + e);
		}
		
	}
}
