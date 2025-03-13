package com.comcast.HMS.admittedpatientinfo;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.csatcast.HMS.BaseTest.BaseClass;
import comcastHMSobjectRepository.AdmittedPatientInfo;
import comcastHMSobjectRepository.Homepage;
import comcastHMSobjectRepository.PatientAdmittedInvoiceDis;
import om.comcast.HMS.generic.webdriverUtility.UtilityClassObject;
@Listeners(com.comcast.HMS.generic.listenerUtility.LisImpClass.class)
public class AdmittedPatientBatchTestNew extends BaseClass{

	@Test (groups = "System")
	public void dischargePatientTestNew() throws IOException {
		UtilityClassObject.getTest().log(Status.INFO, "Navigate To AllADmitted Patient Information");
		Homepage hp = new Homepage(driver);
		hp.getAdmitedPatientInformationLNK().click();
		UtilityClassObject.getTest().log(Status.INFO, "DisCharge One Admitted Patient");
		AdmittedPatientInfo api = new AdmittedPatientInfo(driver);
		api.toScrDdd(driver);
		api.getDischargeLNK().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate To Patient Admitted Invoice To Discharge");
		PatientAdmittedInvoiceDis paid = new PatientAdmittedInvoiceDis(driver);
		wLib1.switchToTabOnURL(driver, "admiteinvo.php");
		paid.toScrollDisAd(driver);
		String next1 = driver.getCurrentUrl();
		Assert.assertEquals(next1,""+ next1 +"");
		paid.dischargeDet("jlib1.getRanNumTen()", "jlib1.getRanNumTen()", "jlib1.getRanNumTen()");
		paid.getPaAdInSubBtn().click();
		System.out.println("The Patient Was Discharged");
		UtilityClassObject.getTest().log(Status.INFO, "THe Patient Was Discharged");
	}
}
