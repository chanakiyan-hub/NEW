package comcastHMSobjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddStaffMem {
	WebDriver driver;
	public AddStaffMem(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(partialLinkText="Add Staff Memeber")
	private WebElement AddStaffMemLNK;

	public WebElement getAddStaffMemLNK() {
		return AddStaffMemLNK;
	}

}
