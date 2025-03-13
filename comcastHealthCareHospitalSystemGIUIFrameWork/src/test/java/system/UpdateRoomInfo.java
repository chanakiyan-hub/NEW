package system;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.comcast.HMS.generic.fileUtility.FileUtility;

import comcastHMSobjectRepository.Homepage;
import comcastHMSobjectRepository.LoginPage;
import comcastHMSobjectRepository.RoomInfo;
import comcastHMSobjectRepository.UpdateRoomForm;
import om.comcast.HMS.generic.webdriverUtility.WebdriverUtility;



public class UpdateRoomInfo {

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
		rf.toScrollROm(driver);
		rf.getUpdateRomInfoBtn();
	
		UpdateRoomForm urf = new UpdateRoomForm(driver);
	     urf.toScrolupdate(driver);
		urf.DocIn(0, 0);
		urf.getRomUpDSubmitBtn().click();
		System.out.println("Room Info Is Updated SucessFully");
		
	}

}
