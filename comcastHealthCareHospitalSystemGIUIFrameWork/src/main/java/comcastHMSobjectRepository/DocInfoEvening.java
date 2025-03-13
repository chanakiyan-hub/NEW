package comcastHMSobjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DocInfoEvening {
	WebDriver driver;
	public DocInfoEvening(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
