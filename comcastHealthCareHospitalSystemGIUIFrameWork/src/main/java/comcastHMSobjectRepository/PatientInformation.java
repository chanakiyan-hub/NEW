package comcastHMSobjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientInformation {

	WebDriver driver;
	public PatientInformation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="ad")
	private WebElement OPdInvoiceBtn;
	
	@FindBy(xpath="(//a[@name='ad']/../../td[7]/a[1])[1]")
	private WebElement AtmitHosBtn;

	public WebElement getOPdInvoiceBtn() {
		return OPdInvoiceBtn;
	}

	public WebElement getAtmitHosBtn() {
		return AtmitHosBtn;
	}
	
	@FindBy(linkText = "Make OPD Invoice")
	private WebElement Makeopd;
	
	
	 public WebElement getMakeopd() {
		return Makeopd;
	}

	 public void toScrollAdmit(WebDriver driver  ) {
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
	 
	 public void toScrollopdmake(WebDriver driver  ) {
			JavascriptExecutor js2= (JavascriptExecutor) driver;
			for(; ;) {
			try {
				driver.findElement(By.xpath("(//a[@name='ad'])[2]")).click();
				break;
			}catch(Exception e) {
				js2.executeScript("window.scrollBy(0,250)");
			}
			}
		}

}