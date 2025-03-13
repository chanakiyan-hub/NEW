package integration;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.comcast.HMS.generic.fileUtility.FileUtility;

import comcastHMSobjectRepository.Homepage;
import comcastHMSobjectRepository.LoginPage;
import comcastHMSobjectRepository.MakeOPdInv;
import comcastHMSobjectRepository.PatientInfo;
import comcastHMSobjectRepository.PatientInformation;
import om.comcast.HMS.generic.webdriverUtility.WebdriverUtility;

public class MakePatientOpdInvoice {

	public static void main(String[] args) throws IOException {
	
		FileUtility flib1 = new FileUtility();
	
		WebdriverUtility wLib1 = new WebdriverUtility();

		String BROWSER = flib1.gatDataFromPropertiesFile("browser");
		String URL = flib1.gatDataFromPropertiesFile("url");
		String USERNAME = flib1.gatDataFromPropertiesFile("username");
		String PASSWORD = flib1.gatDataFromPropertiesFile("password");
		
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
		hp.getPatientInfoLNK().click();
		
		PatientInfo pa = new PatientInfo(driver);
		pa.getPatientInformLNK().click();
		
		PatientInformation pi = new PatientInformation(driver);
	    pi.toScrollopdmake(driver);
		wLib1.switchToTabOnURL(driver, "opdinvo.php");
		String next2 = driver.getCurrentUrl();
		Assert.assertEquals(next2,"");
		MakeOPdInv moi = new MakeOPdInv(driver);
		moi.AllField(USERNAME, PASSWORD);
		moi.getMeKeInSub().click();
		System.out.println("OPD Invoice Created");
	
	}

}
