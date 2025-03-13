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
import comcastHMSobjectRepository.OPDdocInfoRoom;
import comcastHMSobjectRepository.RoomInfo;
import om.comcast.HMS.generic.webdriverUtility.WebdriverUtility;

public class PatientOpdDocDetails {

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
		hp.getRoomInformationLNK().click();
		
		RoomInfo rf = new RoomInfo(driver);	
		rf.toScroDOcInfo(driver);
		rf.getDocinfo().click();
		
		wLib1.switchToTabOnURL(driver, "admitdf.php");
		
		OPDdocInfoRoom odir = new OPDdocInfoRoom(driver);
		odir.toScrolldocinfoooo(driver);
		String next = driver.getCurrentUrl();
		Assert.assertEquals(next,"http://49.249.28.218:8081/AppServer/Health_Care_Hospital_System/admitdf.php?id=%2021");
	
	}

}
