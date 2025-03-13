package system;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.comcast.HMS.generic.fileUtility.EXcelUtility;
import com.comcast.HMS.generic.fileUtility.FileUtility;
import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

import comcastHMSobjectRepository.Homepage;
import comcastHMSobjectRepository.LoginPage;
import comcastHMSobjectRepository.StaffInfo;
import comcastHMSobjectRepository.StaffMemREgForm;
import comcastHMSobjectRepository.StaffMemSearch;
import om.comcast.HMS.generic.webdriverUtility.JavaUtility;
import om.comcast.HMS.generic.webdriverUtility.WebdriverUtility;

public class CreateDoctorAndVerifyTheDetails {

	

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		final String eml = ""; 
		/* Create Object */
		FileUtility flib1 = new FileUtility();
		EXcelUtility elib1 = new EXcelUtility();
		JavaUtility jlib = new JavaUtility();
		WebdriverUtility wLib1 = new WebdriverUtility();

		// read common data from propertyfile

		// step 3 : get the value based on the key
		String BROWSER = flib1.gatDataFromPropertiesFile("browser");
		String URL = flib1.gatDataFromPropertiesFile("url");
		String USERNAME = flib1.gatDataFromPropertiesFile("username");
		String PASSWORD = flib1.gatDataFromPropertiesFile("password");
		// read testscript data from excel file
		String first = elib1.getDataFromExcel("HMS", 2, 1); 
		String last = elib1.getDataFromExcel("HMS", 2, 2) + jlib.getRandomValue("sb");
		String Addre = elib1.getDataFromExcel("HMS", 2, 3);
        String email = ("bha" + jlib.getRandomValue(eml) + "@gmail.com");
		System.out.println(email);
		
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
		hp.getStaffInfoLNK().click();
		
		StaffInfo si = new StaffInfo(driver);
		si.getAddStaffMemLNK().click();
		
		StaffMemREgForm Sreg = new StaffMemREgForm(driver);
		Sreg.SAllTEXtfield1(first, last, Addre, email); 
		Sreg.toScrollSTaff1(driver, Addre);
		Sreg.toScrollSTaff2(driver, Addre);
		Sreg.SAllTEXtfield2(email, 1, email, 4);
		Sreg.getSTMemAddSubmitLNK().click();
	
		
		String actgName = Sreg.getSHeaderMsg().getText();
		boolean status1 = actgName.contains("Registration Successful !");
		Assert.assertEquals(status1, true);
		
	    si.getSTaffSearchLNK().click();
		StaffMemSearch sms = new StaffMemSearch(driver);
		sms.toScrollSTSub(driver);
		Actions action=new Actions(driver);
		action.moveToElement(sms.getSTSearchBarLNK()).click().sendKeys(email,Keys.ENTER).build().perform();
		
	 
	
		String Expectemail = sms.getExpectma().getText();
		System.out.println("expected mail "+Expectemail);
		boolean status2 = email.equals(Expectemail);
		Assert.assertEquals(status2, true);
		System.out.println("Staff Details Verified Suceesfully");
		
	}

}
