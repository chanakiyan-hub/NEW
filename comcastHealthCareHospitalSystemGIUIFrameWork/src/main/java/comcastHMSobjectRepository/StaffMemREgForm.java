package comcastHMSobjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import om.comcast.HMS.generic.webdriverUtility.JavaUtility;

public class StaffMemREgForm {

	WebDriver driver;
	public StaffMemREgForm(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="fname")
	private WebElement SfirstnamLNK;
	
	@FindBy(id= "lname")
	private WebElement SlastnamLNK;
	
	@FindBy(name="addr")
	private WebElement SaddressLNK;
	
	@FindBy(name= "tel")
	private WebElement SmobnoLNK;
	
	@FindBy(id= "eml")
	private WebElement SemailLNK;
	
	@FindBy(name="gender")
	private WebElement SgenderLNK;
	
	@FindBy(name= "smbdd")
	private WebElement SBirthDateLNK;
	
	@FindBy(name= "typesm")
	private WebElement STStaffTypeLNK;
	
	@FindBy(name= "workt")
	private WebElement STWorkTiLNK;
	
	@FindBy(name="submit")
	private WebElement STMemAddSubmitLNK;

	@FindBy(xpath= "//div[contains(text(),'Registration Successful !')]")
	private WebElement SHeaderMsg;
	
	public WebElement getSHeaderMsg() {
		return SHeaderMsg;
	}

	public WebElement getSfirstnamLNK() {
		return SfirstnamLNK;
	}

	public WebElement getSlastnamLNK() {
		return SlastnamLNK;
	}

	public WebElement getSaddressLNK() {
		return SaddressLNK;
	}

	public WebElement getSmobnoLNK() {
		return SmobnoLNK;
	}

	public WebElement getSemailLNK() {
		return SemailLNK;
	}

	public WebElement getSgenderLNK() {
		return SgenderLNK;
	}

	public WebElement getSBirthDateLNK() {
		return SBirthDateLNK;
	}

	public WebElement getSTStaffTypeLNK() {
		return STStaffTypeLNK;
	}

	public WebElement getSTWorkTiLNK() {
		return STWorkTiLNK;
	}

	public WebElement getSTMemAddSubmitLNK() {
		return STMemAddSubmitLNK;
	}
	
public  void SAllTEXtfield1(String first , String last , String address , String mob )  {
		
		SfirstnamLNK.sendKeys(first);
		SlastnamLNK.sendKeys(last);
		SaddressLNK.sendKeys(address);
		SmobnoLNK.click();
		JavaUtility jlib = new JavaUtility();		
		SmobnoLNK.sendKeys("1234" + jlib.getRandomNum(mob));
		
	}
	
	public void SAllTEXtfield2( String email , int Gen , String birthdate , int bld ) {
		
		//JavaUtility jlib = new JavaUtility();
		//SemailLNK.sendKeys("bha" + jlib.getRandomValue(eml) + "@gmail.com");
		//SemailLNK.sendKeys("ChanJohn@gmail.com");
		SemailLNK.sendKeys(email);
		SgenderLNK.click();
		Select sel1 = new Select(SgenderLNK);
		sel1.selectByIndex(1);
		SBirthDateLNK.sendKeys( "10082026");
		STStaffTypeLNK.click();
		Select sel2 = new Select(STStaffTypeLNK);
		sel2.selectByIndex(1);
		STWorkTiLNK.click();
		Select sel3 = new Select(STWorkTiLNK);
		sel3.selectByIndex(1);
		
	}
	
	public void toScrollSTaff1(WebDriver driver , String EL ) {
    	JavascriptExecutor js= (JavascriptExecutor) driver;
		for(; ;) {
		try {
			driver.findElement(By.name("tel")).click();
			break;
		}catch(Exception e) {
			js.executeScript("window.scrollBy(0,350)");
		}
		}
}
	
	public void toScrollSTaff2(WebDriver driver , String EL ) {
    	JavascriptExecutor js1= (JavascriptExecutor) driver;
		for(; ;) {
		try {
			driver.findElement(By.name("submit")).click();
			break;
		}catch(Exception e) {
			js1.executeScript("window.scrollBy(0,350)");
		}
		}
}
}
