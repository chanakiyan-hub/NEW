package comcastHMSobjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import om.comcast.HMS.generic.webdriverUtility.JavaUtility;

public class MakeOPdInv {


	WebDriver driver;
	public MakeOPdInv(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name = "mc")
	private WebElement Medichar;

	@FindBy(name = "dc")
	private WebElement Docchar;
	
	@FindBy(name= "submit")
	private WebElement MeKeInSub;
	
	
	public WebElement getMedichar() {
		return Medichar;
	}


	public WebElement getDocchar() {
		return Docchar;
	}


	public WebElement getMeKeInSub() {
		return MeKeInSub;
	}

	@FindBy(xpath = "//div[contains(text(),'Registration Successful !')]")
	private WebElement Verifymsg;

	public WebElement getVerifymsg() {
		return Verifymsg;
	}


	public void toScrollMaked(WebDriver driver ) {
    	JavascriptExecutor js2= (JavascriptExecutor) driver;
		for(; ;) {
		try {
			driver.findElement(By.xpath("(//a[@name='ad']/../../td[7]/a[1])[1]")).click();
			break;
		}catch(Exception e) {
			js2.executeScript("window.scrollBy(0,250)");
		}
		}
}
	
	public void AllField(String dat1 , String dat2) {
	//	JavaUtility jlib1 = new JavaUtility();
		
		Medichar.sendKeys("dat1");
		Docchar.sendKeys("dat2");
	}
	
}
