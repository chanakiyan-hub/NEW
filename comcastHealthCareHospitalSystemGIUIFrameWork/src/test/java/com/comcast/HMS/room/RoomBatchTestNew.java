package com.comcast.HMS.room;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.csatcast.HMS.BaseTest.BaseClass;

import comcastHMSobjectRepository.Homepage;
import comcastHMSobjectRepository.RoomInfo;
import comcastHMSobjectRepository.UpdateRoomForm;
import om.comcast.HMS.generic.webdriverUtility.UtilityClassObject;
@Listeners(com.comcast.HMS.generic.listenerUtility.LisImpClass.class)
public class RoomBatchTestNew extends BaseClass {

	@Test (groups = "System")
	public void updateRoomInfoTestNew() throws IOException {

		Homepage hp = new Homepage(driver);
		hp.getRoomInformationLNK().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate To Room Info");
		RoomInfo rf = new RoomInfo(driver);
		rf.toScrollROm(driver);
		rf.getUpdateRomInfoBtn();
		UtilityClassObject.getTest().log(Status.INFO, "Select Update Room Information");
		UpdateRoomForm urf = new UpdateRoomForm(driver);
	     urf.toScrolupdate(driver);
		urf.DocIn(0, 0);
		String pagen5 = urf.getRomUpDSubmitBtn().getText();
		Assert.assertEquals(pagen5, "Submit");
		UtilityClassObject.getTest().log(Status.INFO, "Fill All The Details And Submit");
		urf.getRomUpDSubmitBtn().click();
		System.out.println("Room Info Is Updated SucessFully");
		UtilityClassObject.getTest().log(Status.INFO, "Room Information Is Updated SuccessFull");
	}

	@Test (groups = "Smoke")
	public void roomInfoForPatientTestNew() throws IOException {

		Homepage hp = new Homepage(driver);
		hp.getRoomInformationLNK().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate To Room Info");
		RoomInfo rf = new RoomInfo(driver);
		rf.toScrorrom10(driver);
		rf.getRoom10().click();
		String actgName = rf.getRoomII().getText();
	    boolean status1 = actgName.contains("Patient ID");
		Assert.assertEquals(status1, true);
		UtilityClassObject.getTest().log(Status.INFO, "Click One Room i Symbol");
		System.out.println(rf.getRo10info().getText());
		UtilityClassObject.getTest().log(Status.INFO, "Room Information Is Displayed");
	}

}
