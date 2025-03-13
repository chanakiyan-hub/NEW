package comcastHMSobjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiveMem {
	WebDriver driver;
	public ActiveMem(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
