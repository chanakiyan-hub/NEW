package com.comcast.HMS.invoice;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.csatcast.HMS.BaseTest.BaseClass;
import comcastHMSobjectRepository.AllAdmittedPateintInvoices;
import comcastHMSobjectRepository.Homepage;
import comcastHMSobjectRepository.MakeOPdInv;
import comcastHMSobjectRepository.PatientInfo;
import comcastHMSobjectRepository.PatientInformation;
import comcastHMSobjectRepository.PatientInvoices;
import om.comcast.HMS.generic.webdriverUtility.UtilityClassObject;
@Listeners(com.comcast.HMS.generic.listenerUtility.LisImpClass.class)
public class InvoicePatientBatchTest extends BaseClass{

	@Test (groups = "Integration")
	public void patientOPDInvoMakeTest() throws IOException {
		UtilityClassObject.getTest().log(Status.INFO, "Navigate To Patient Info");
		Homepage hp = new Homepage(driver);
		hp.getPatientInfoLNK().click();
		
		PatientInfo pa = new PatientInfo(driver);
		pa.getPatientInformLNK().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate To Patient Information");
		PatientInformation pi = new PatientInformation(driver);
	    pi.toScrollopdmake(driver);
		wLib1.switchToTabOnURL(driver, "opdinvo.php");
		String next3 = driver.getCurrentUrl();
		Assert.assertEquals(next3,""+ next3 +"");
		UtilityClassObject.getTest().log(Status.INFO, "Make OPD Invoice");
		MakeOPdInv moi = new MakeOPdInv(driver);
		moi.AllField("jlib1.getRanNumTen()", "jlib1.getRanNumTen()");
		moi.getMeKeInSub().click();
		System.out.println("OPD Invoice Created");
		UtilityClassObject.getTest().log(Status.INFO, "OPD Invoice Is Created");
	
	}
	
	@Test (groups = "Smoke")
	public void allADmitPatientInvoTest() throws IOException {
		
		Homepage hp = new Homepage(driver);
		hp.getPatientInvoicesLNK().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate To Patient Invoices");
		PatientInvoices pi = new PatientInvoices(driver);
		pi.getPaAllAdmitPainvoiLNK().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate To All ADmitted Patient Invoices");
		AllAdmittedPateintInvoices aapi = new AllAdmittedPateintInvoices(driver);
		aapi.toScrollPAAllinvoi(driver);
		aapi.getAlAmtPaINvoiceVIEWBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Select One Patient Invoices");
	wLib1.switchToTabOnURL(driver, "print.php");
	String next4 = driver.getCurrentUrl();
	Assert.assertEquals(next4,""+ next4 +"");
	System.out.println(aapi.getINvoice().getText());
	UtilityClassObject.getTest().log(Status.INFO, "Patient Invoice Is Displayed");
	
	}
}
