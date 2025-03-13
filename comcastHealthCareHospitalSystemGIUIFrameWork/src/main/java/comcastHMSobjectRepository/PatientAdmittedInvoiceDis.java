package comcastHMSobjectRepository;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import om.comcast.HMS.generic.webdriverUtility.JavaUtility;

public class PatientAdmittedInvoiceDis {

	WebDriver driver;
	public PatientAdmittedInvoiceDis(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name= "mc")
	private WebElement MediChargeLNK;
	
	@FindBy(name= "cod")
	private WebElement CountofDayLNK;
	
	@FindBy(name= "dc")
	private WebElement docChargeLNK;
	
	@FindBy(xpath = "//button[contains(text(),'SUBMIT')]")
	private WebElement PaAdInSubBtn;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getMediChargeLNK() {
		return MediChargeLNK;
	}

	public WebElement getCountofDayLNK() {
		return CountofDayLNK;
	}

	public WebElement getDocChargeLNK() {
		return docChargeLNK;
	}

	public WebElement getPaAdInSubBtn() {
		return PaAdInSubBtn;
	}

	public void toScrollDisAd(WebDriver driver ) {
    	JavascriptExecutor js= (JavascriptExecutor) driver;
		for(; ;) {
		try {
			driver.findElement(By.name("mc")).click();
			break;
		}catch(Exception e) {
			js.executeScript("window.scrollBy(0,700)");
		}
		}
}

public void dischargeDet(String dig1 , String dig2 , String dig3 ) {
	
	MediChargeLNK.sendKeys("dig1");
	docChargeLNK.sendKeys("dig2");
	CountofDayLNK.sendKeys("dig3");
	
	
}











}
