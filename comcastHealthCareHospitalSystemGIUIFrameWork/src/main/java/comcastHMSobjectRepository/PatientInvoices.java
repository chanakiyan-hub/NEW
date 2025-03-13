package comcastHMSobjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientInvoices {

	WebDriver driver;
	public PatientInvoices(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(partialLinkText="All OPD Patients Invoiceses")
	private WebElement PaAllOPdINVoLNK;
	
	@FindBy(partialLinkText="All Admited Patients Invoiceses")
	private WebElement PaAllAdmitPainvoiLNK;

	public WebElement getPaAllOPdINVoLNK() {
		return PaAllOPdINVoLNK;
	}

	public WebElement getPaAllAdmitPainvoiLNK() {
		return PaAllAdmitPainvoiLNK;
	}


	public void toScrollPAAllinvoi(WebDriver driver , String EL ) {
		JavascriptExecutor js2= (JavascriptExecutor) driver;
		for(; ;) {
		try {
			driver.findElement(By.linkText("View")).click();
			break;
		}catch(Exception e) {
			js2.executeScript("window.scrollBy(0,350)");
		}
		}
	}
	
}
