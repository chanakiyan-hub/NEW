package comcastHMSobjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import om.comcast.HMS.generic.webdriverUtility.JavaUtility;


public class PatientReg {
	WebDriver driver;
	public PatientReg(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="fname")
	private WebElement PfirstnamLNK;
	
	@FindBy(id= "lname")
	private WebElement PlastnamLNK;
	
	@FindBy(name= "dnames")
	private WebElement POPDocLNK;
	
	@FindBy(name="addr")
	private WebElement PaddressLNK;
	
	@FindBy(name= "tel")
	private WebElement PmobnoLNK;
	
	@FindBy(id= "eml")
	private WebElement PemailLNK;
	
	@FindBy(name="gender")
	private WebElement PgenderLNK;
	
	@FindBy(name= "smbdd")
	private WebElement PBirthDateLNK;
	
	@FindBy(name= "bg")
	private WebElement PbldgroLNK;
	
	@FindBy(xpath="//button[contains(text(),'SUBMIT')]")
	private WebElement PSubmitREgLNK;

	@FindBy(xpath= "//div[contains(text(),'Registration Successful !')]")
	private WebElement HeaderMsg;

	public WebElement getHeaderMsg() {
		return HeaderMsg;
	}

	public WebElement getPfirstnamLNK() {
		return PfirstnamLNK;
	}

	public WebElement getPlastnamLNK() {
		return PlastnamLNK;
	}

	public WebElement getPOPDocLNK() {
		return POPDocLNK;
	}

	public WebElement getPaddressLNK() {
		return PaddressLNK;
	}

	public WebElement getPmobnoLNK() {
		return PmobnoLNK;
	}

	public WebElement getPemailLNK() {
		return PemailLNK;
	}

	public WebElement getPgenderLNK() {
		return PgenderLNK;
	}

	public WebElement getPBirthDateLNK() {
		return PBirthDateLNK;
	}

	public WebElement getPbldgroLNK() {
		return PbldgroLNK;
	}

	public WebElement getPSubmitREgLNK() {
		return PSubmitREgLNK;
	}

	public  void AllTEXtfield1(String first , String last , String opdoc , String address , String mob )  {
		
		PfirstnamLNK.sendKeys(first);
		PlastnamLNK.sendKeys(last);
		POPDocLNK.click();
		Select sel = new Select(POPDocLNK);
		sel.selectByIndex(4);
		PaddressLNK.sendKeys(address);
		PmobnoLNK.click();
		JavaUtility jlib1 = new JavaUtility();		
		PmobnoLNK.sendKeys("1234" + jlib1.getRandomNum(mob));
		
		
		
	}
	
	public void AllTEXtfield2( String email , int Gen , String birthdate , int bld ) {
		
		JavaUtility jlib2 = new JavaUtility();
		PgenderLNK.click();
		PemailLNK.sendKeys(jlib2.getRandomValue(email) + "@gmail.com");
		Select sel1 = new Select(PgenderLNK);
		sel1.selectByIndex(1);
		PBirthDateLNK.sendKeys( "10082026");
		PbldgroLNK.click();
		Select sel2 = new Select(PbldgroLNK);
		sel2.selectByIndex(4);
	}
}
