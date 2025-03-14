package com.csatcast.HMS.BaseTest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.comcast.HMS.generic.databaseUtility.DataBaseUtility;
import com.comcast.HMS.generic.fileUtility.EXcelUtility;
import com.comcast.HMS.generic.fileUtility.FileUtility;

import comcastHMSobjectRepository.Homepage;
import comcastHMSobjectRepository.LoginPage;
import om.comcast.HMS.generic.webdriverUtility.JavaUtility;
import om.comcast.HMS.generic.webdriverUtility.UtilityClassObject;
import om.comcast.HMS.generic.webdriverUtility.WebdriverUtility;

public class BaseClass {

	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	public DataBaseUtility dblib1 = new DataBaseUtility();
	public FileUtility flib1 = new FileUtility();
	public JavaUtility jlib1 = new JavaUtility();
	public EXcelUtility elib1 = new EXcelUtility();
	public WebdriverUtility wLib1 = new WebdriverUtility();
	
	

	
	@BeforeSuite (groups = {"Smoke" , "Integration" , "System"})
	public void configBS() throws SQLException {
		System.out.println("====Connect to DB , Report Config====");
		dblib1.getDbconnection();
		
	}
	

	
	
	@Parameters ("BROWSER") //this is using only suite file execution time not for other time
	@BeforeClass (groups = {"Smoke" , "Integration" , "System"})
	public void configBC(@Optional ("BROWSER") String browser) throws IOException {
		System.out.println("===Launch The BROWSER===");
		
		String BROWSER = browser;
		BROWSER = flib1.gatDataFromPropertiesFile("browser");
		//CMD LINE
		//String BROWSER =System.getProperty("browser" , flib.gatDataFromPropertiesFile("browser"));
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
			
		}
		sdriver = driver;
		UtilityClassObject.setDriver(driver);
	}

	
    /*@Parameters ("BROWSER") //this is using only suite file execution time not for other time
	@BeforeClass (groups = {"smokeTest" , "regressionTest"})
	public void configBC(@Optional ("BROWSER") String browser) throws IOException {
		System.out.println("===Launch The BROWSER===");
		String BROWSER = browser;
		BROWSER = flib1.gatDataFromPropertiesFile("browser");
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
			
		}
		sdriver = driver;
	}*/
	
	@BeforeMethod (groups = {"Smoke" , "Integration" , "System"})
	public void configBM() throws IOException {
		System.out.println("==Login==");
		String URL = flib1.gatDataFromPropertiesFile("url");
		String USERNAME = flib1.gatDataFromPropertiesFile("username");
		String PASSWORD = flib1.gatDataFromPropertiesFile("password");
		//CMD LINE
		//String URL = System.getProperty("url" , flib.gatDataFromPropertiesFile("url"));
		//String USERNAME = System.getProperty("username" , flib.gatDataFromPropertiesFile("username"));
		//String PASSWORD = System.getProperty("password" , flib.gatDataFromPropertiesFile("password"));
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(URL, USERNAME, PASSWORD);
		wLib1.toMaximize(driver);
		wLib1.toWaitForElements(driver);
		
	}
	
	@AfterMethod (groups = {"Smoke" , "Integration" , "System"})
	public void configAM() {
		System.out.println("==Logout==");
		Homepage hp = new Homepage(driver);
		hp.getLogout();
		
	}
	
	@AfterClass (groups = {"Smoke" , "Integration" , "System"})
	public void configAC() {
		System.out.println("===Close The BROWSER===");
		driver.quit();
		
	}
	
	@AfterSuite (groups = {"Smoke" , "Integration" , "System"})
	public void configAS() {
		System.out.println("====Close To DB , Report Backup====");
		dblib1.closeDbconnection();
		//report.flush();
	}	
	
}
