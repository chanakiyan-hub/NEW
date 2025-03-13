package com.comcast.HMS.staff;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.csatcast.HMS.BaseTest.BaseClass;
import comcastHMSobjectRepository.Homepage;
import comcastHMSobjectRepository.StaffInfo;
import comcastHMSobjectRepository.StaffMemREgForm;
import comcastHMSobjectRepository.StaffMemSearch;
import om.comcast.HMS.generic.webdriverUtility.UtilityClassObject;

@Listeners(com.comcast.HMS.generic.listenerUtility.LisImpClass.class)
public class CreateStaffAndVerifyTestNew extends BaseClass{

	@Test (groups = "System")
	public void createDocAndVerifyTest() throws IOException, InterruptedException {
		UtilityClassObject.getTest().log(Status.INFO, "Read The Data From Excel");
		final String eml = ""; 
		String first = elib1.getDataFromExcel("HMS", 2, 1); 
		String last = elib1.getDataFromExcel("HMS", 2, 2) + jlib1.getRandomValue("sb");
		String Addre = elib1.getDataFromExcel("HMS", 2, 3);
        String email = ("bha" + jlib1.getRandomValue(eml) + "@gmail.com");
		System.out.println(email);
		
		Homepage hp = new Homepage(driver);
		hp.getStaffInfoLNK().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate To Staff Info");
		StaffInfo si = new StaffInfo(driver);
		si.getAddStaffMemLNK().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate To Staff REG Form");
		StaffMemREgForm Sreg = new StaffMemREgForm(driver);
		Sreg.SAllTEXtfield1(first, last, Addre, email); 
		Sreg.toScrollSTaff1(driver, Addre);
		Sreg.toScrollSTaff2(driver, Addre);
		Sreg.SAllTEXtfield2(email, 1, email, 4);
		Sreg.getSTMemAddSubmitLNK().click();
		UtilityClassObject.getTest().log(Status.INFO, "Fill All The Details And Submit");
		String actgName = Sreg.getSHeaderMsg().getText();
		boolean status1 = actgName.contains("Registration Successful !");
		Assert.assertEquals(status1, true);
		UtilityClassObject.getTest().log(Status.INFO, "Staff Registration Is SuccessFull");
	    si.getSTaffSearchLNK().click();
		StaffMemSearch sms = new StaffMemSearch(driver);
		UtilityClassObject.getTest().log(Status.INFO, "Navigate To Staff Member Search");
		sms.toScrollSTSub(driver);
		Actions action=new Actions(driver);
		action.moveToElement(sms.getSTSearchBarLNK()).click().sendKeys(email,Keys.ENTER).build().perform();
		UtilityClassObject.getTest().log(Status.INFO, "Pass Created Staff Details");
		String Expectemail = sms.getExpectma().getText();
		System.out.println("expected mail "+Expectemail);
		boolean status2 = email.equals(Expectemail);
		Assert.assertEquals(status2, true);
		System.out.println("Staff Details Verified Suceesfully");
		UtilityClassObject.getTest().log(Status.INFO, "Staff Details Verified Successfull");
	}

	@Test (groups = "Integration")
	public void staffActiveMemberTest() throws IOException {
		Homepage hp = new Homepage(driver);
		hp.getStaffInfoLNK().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate To Staff Info");
		StaffInfo sf = new StaffInfo(driver);
		sf.getActiveMEmLNK().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate To Active Members");
         sf.toScrollSTtttt(driver);
         String Ver=sf.getStverify().getText();
         boolean sts= Ver.contains("Active Staff Members");
         System.out.println(sf.getEVngDet().getText());
         UtilityClassObject.getTest().log(Status.INFO, "All Active Members Details Is Displated");
	}
}
