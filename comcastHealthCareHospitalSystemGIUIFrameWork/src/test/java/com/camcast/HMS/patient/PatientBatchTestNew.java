package com.camcast.HMS.patient;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.HMS.generic.fileUtility.EXcelUtility;
import com.comcast.HMS.generic.fileUtility.FileUtility;
import com.csatcast.HMS.BaseTest.BaseClass;

import comcastHMSobjectRepository.Homepage;
import comcastHMSobjectRepository.LoginPage;
import comcastHMSobjectRepository.OPDdocInfoRoom;
import comcastHMSobjectRepository.PatientAdmitREGForm;
import comcastHMSobjectRepository.PatientInfo;
import comcastHMSobjectRepository.PatientInformation;
import comcastHMSobjectRepository.PatientReg;
import comcastHMSobjectRepository.RoomInfo;
import om.comcast.HMS.generic.webdriverUtility.JavaUtility;
import om.comcast.HMS.generic.webdriverUtility.UtilityClassObject;
import om.comcast.HMS.generic.webdriverUtility.WebdriverUtility;
@Listeners(com.comcast.HMS.generic.listenerUtility.LisImpClass.class)
public class PatientBatchTestNew extends BaseClass{
	
	@Test (groups = "System")
	public  void createPatientAndAdmittTest() throws IOException {

		UtilityClassObject.getTest().log(Status.INFO, "Read The Data From Excel");
		
		String first = elib1.getDataFromExcel("HMS", 1, 1); 
		String last = elib1.getDataFromExcel("HMS", 1, 2) + jlib1.getRandomValue("sb");
		String Addre = elib1.getDataFromExcel("HMS", 1, 3);

		UtilityClassObject.getTest().log(Status.INFO, "Navigate To Patient Info");
		Homepage hp = new Homepage(driver);
		hp.getPatientInfoLNK().click();
		PatientInfo pa = new PatientInfo(driver);
		pa.getPatientREGLNK().click();
			
		UtilityClassObject.getTest().log(Status.INFO, "Create New Patient");
		UtilityClassObject.getTest().log(Status.INFO, "Fill All Patient Details In REG Form And Submit");
		PatientReg pr = new PatientReg(driver);
		pr.AllTEXtfield1(first, last, last, Addre, Addre);
		wLib1.toScrollBy(driver, Addre);
		pr.AllTEXtfield2(last, 1, Addre, 4);
		pr.getPSubmitREgLNK().click();
		
		String actgName = pr.getHeaderMsg().getText();
		//Registration Successful !
		boolean status1 = actgName.equals("Registration Successful !");
		Assert.assertEquals(status1, true);
		UtilityClassObject.getTest().log(Status.INFO, "Patient Registration Successful");
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigate To Patient Information");
		pa.getPatientInformLNK().click();
		PatientInformation pain = new PatientInformation(driver);
		pain.toScrollAdmit(driver);
		pain.getAtmitHosBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Patient ADmit To Hospital");
	    
		wLib1.switchToTabOnURL(driver, "admit.php");
	    PatientAdmitREGForm pdr = new PatientAdmitREGForm(driver);
	    pdr.toScrollAdForm(driver, actgName);
	    pdr.Romno();
	    pdr.getPaAdmtSubmitBtn().click();
	    UtilityClassObject.getTest().log(Status.INFO, "Patient Admitted To Hospital Successfully");
	}
	
	    @Test (groups = "Smoke")
	    public void patientInfoCheckTest() throws IOException {
			
	    	 UtilityClassObject.getTest().log(Status.INFO, "Navigate To Patient Information");
			Homepage hp = new Homepage(driver);
			hp.getPatientInfoLNK().click();
			
			PatientInfo pa = new PatientInfo(driver);
			pa.getPatientInformLNK().click();
			String pageIn = pa.getVerifyPaInf().getText();
			Assert.assertEquals(pageIn,"All Patient details");
			pa.toScrollPAinfo(driver);
			System.out.println(pa.getPainnnn().getText());
			 UtilityClassObject.getTest().log(Status.INFO, "Patient Information Displayed");
				
		
			}
	    
	    @Test (groups = "Integration")
	    public void patientOPDdocDetailsTest() throws IOException {
			
	    	UtilityClassObject.getTest().log(Status.INFO, "Navigate To Room Information");
			Homepage hp = new Homepage(driver);
			hp.getRoomInformationLNK().click();
			
			RoomInfo rf = new RoomInfo(driver);	
			rf.toScroDOcInfo(driver);
			rf.getDocinfo().click();
			UtilityClassObject.getTest().log(Status.INFO, "Create OPD Doctor ");
			wLib1.switchToTabOnURL(driver, "admitdf.php");
			String next = driver.getCurrentUrl();
			Assert.assertEquals(next,"http://49.249.28.218:8081/AppServer/Health_Care_Hospital_System/admitdf.php?id=%2021");
			UtilityClassObject.getTest().log(Status.INFO, "Navigate To OPD Doctor Info");
			OPDdocInfoRoom odir = new OPDdocInfoRoom(driver);
			odir.toScrolldocinfoooo(driver);
			UtilityClassObject.getTest().log(Status.INFO, "Created OPD Doctor Information Is Presented");
		
		}

}
