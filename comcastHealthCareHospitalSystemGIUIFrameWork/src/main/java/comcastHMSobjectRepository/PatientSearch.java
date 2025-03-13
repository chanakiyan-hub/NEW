package comcastHMSobjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientSearch {
	WebDriver driver;
	public PatientSearch(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="searvalu")
	private WebElement PaSearchBarLNK;
	
	@FindBy(name= "submit")
	private WebElement PaSearchSubmitBtn;

	public WebElement getPaSearchBarLNK() {
		return PaSearchBarLNK;
	}

	public WebElement getPaSearchSubmitBtn() {
		return PaSearchSubmitBtn;
	}
	
	

}
