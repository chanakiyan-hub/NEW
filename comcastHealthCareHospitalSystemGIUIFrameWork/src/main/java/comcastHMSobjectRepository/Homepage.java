package comcastHMSobjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	/**
	 * @return the logout
	 */
	public WebElement getLogout() {
		return logout;
	}
	WebDriver driver;
	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Patient Info")
	private WebElement PatientInfoLNK;
	
	@FindBy(linkText="Staff Info")
	private WebElement StaffInfoLNK;
	
	@FindBy(linkText="Ptient Invoices")
	private WebElement PatientInvoicesLNK;
	
	@FindBy(linkText="Room Information")
	private WebElement RoomInformationLNK;
	
	@FindBy(linkText="Admited Patient Information")
	private WebElement AdmitedPatientInformationLNK;
	

	@FindBy(linkText = "Logout")
	private WebElement logout;
	
	public WebElement getPatientInfoLNK() {
		return PatientInfoLNK;
	}

	public WebElement getStaffInfoLNK() {
		return StaffInfoLNK;
	}

	public WebElement getPatientInvoicesLNK() {
		return PatientInvoicesLNK;
	}

	public WebElement getRoomInformationLNK() {
		return RoomInformationLNK;
	}

	public WebElement getAdmitedPatientInformationLNK() {
		return AdmitedPatientInformationLNK;
	}
}
