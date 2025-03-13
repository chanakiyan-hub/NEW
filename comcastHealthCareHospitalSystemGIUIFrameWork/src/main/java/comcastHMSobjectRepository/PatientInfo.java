package comcastHMSobjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientInfo {
	/**
	 * @return the verifyPaInf
	 */
	public WebElement getVerifyPaInf() {
		return verifyPaInf;
	}

	WebDriver driver;
	public PatientInfo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h3[text()='All Patient details']")
	private WebElement verifyPaInf;

	@FindBy(partialLinkText="Patient Registration")
	private WebElement PatientREGLNK;
	
	@FindBy(xpath="//strong[contains(text(),'Patient Information')]")
	private WebElement PatientInformLNK;
	
	@FindBy(xpath="//strong[contains(text(),'Patient Search')]")
	private WebElement PatientSearchLNK;

	public WebElement getPatientREGLNK() {
		return PatientREGLNK;
	}

	public WebElement getPatientInformLNK() {
		return PatientInformLNK;
	}

	public WebElement getPatientSearchLNK() {
		return PatientSearchLNK;
	}
	
	
	@FindBy(xpath = "//table[@class='table table-striped table-hover']")
	private WebElement Painnnn;
	

public WebElement getPainnnn() {
		return Painnnn;
	}

public void toScrollPAinfo(WebDriver driver) {
	JavascriptExecutor js2= (JavascriptExecutor) driver;
	for(; ;) {
	try {
		driver.findElement(By.xpath("(//a[@name='ad']/../../td[7]/a[1])[1]"));
		break;
	}catch(Exception e) {
		js2.executeScript("window.scrollBy(0,250)");
	}
	}
}


}