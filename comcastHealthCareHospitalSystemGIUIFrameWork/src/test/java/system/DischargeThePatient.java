package system;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.HMS.generic.fileUtility.EXcelUtility;
import com.comcast.HMS.generic.fileUtility.FileUtility;

import comcastHMSobjectRepository.AdmittedPatientInfo;
import comcastHMSobjectRepository.Homepage;
import comcastHMSobjectRepository.LoginPage;
import comcastHMSobjectRepository.PatientAdmittedInvoiceDis;
import om.comcast.HMS.generic.webdriverUtility.JavaUtility;
import om.comcast.HMS.generic.webdriverUtility.WebdriverUtility;

public class DischargeThePatient {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		/* Create Object */
		FileUtility flib1 = new FileUtility();
		EXcelUtility elib1 = new EXcelUtility();
		JavaUtility jlib1 = new JavaUtility();
		WebdriverUtility wLib1 = new WebdriverUtility();

		// read common data from propertyfile

		// step 3 : get the value based on the key
		String BROWSER = flib1.gatDataFromPropertiesFile("browser");
		String URL = flib1.gatDataFromPropertiesFile("url");
		String USERNAME = flib1.gatDataFromPropertiesFile("username");
		String PASSWORD = flib1.gatDataFromPropertiesFile("password");
		// read testscript data from excel file
	/*	String first = elib1.getDataFromExcel("HMS", 1, 1); 
		String last = elib1.getDataFromExcel("HMS", 1, 2) + jlib1.getRandomValue("sb");
		String Addre = elib1.getDataFromExcel("HMS", 1, 3);*/

		
		WebDriver driver = null;
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		
		driver.get(URL);
		wLib1.toMaximize(driver);
		wLib1.toWaitForElements(driver);
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(URL, USERNAME, PASSWORD);
		
		Homepage hp = new Homepage(driver);
		hp.getAdmitedPatientInformationLNK().click();
		
		AdmittedPatientInfo api = new AdmittedPatientInfo(driver);
		api.toScrDdd(driver);
		api.getDischargeLNK().click();
		
		PatientAdmittedInvoiceDis paid = new PatientAdmittedInvoiceDis(driver);
		wLib1.switchToTabOnURL(driver, "admiteinvo.php");
		paid.toScrollDisAd(driver);
	//	paid.dischargeDet("3000", "2000", "12");
		paid.dischargeDet(USERNAME, USERNAME, PASSWORD);
		paid.getPaAdInSubBtn().click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
