package comcastHMSobjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllOPDPatientInvoices {


	WebDriver driver;
	public AllOPDPatientInvoices(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindAll({@FindBy(xpath="//a[@name='ad']/../../td[10]/a[1]"), @FindBy(linkText = "View")})
	private WebElement AlOPDPaINvoiceVIEWBtn;

	public WebElement getAlOPDPaINvoiceVIEWBtn() {
		return AlOPDPaINvoiceVIEWBtn;
	}
	
}
