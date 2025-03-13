package comcastHMSobjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DocInfoMorning {
	WebDriver driver;
	public DocInfoMorning(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
