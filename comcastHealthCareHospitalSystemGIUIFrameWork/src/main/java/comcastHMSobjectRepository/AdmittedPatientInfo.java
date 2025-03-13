package comcastHMSobjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdmittedPatientInfo {

	WebDriver driver;
	public AdmittedPatientInfo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Discharge")
	private WebElement dischargeLNK;

	public WebElement getDischargeLNK() {
		return dischargeLNK;
	}
		
		public void toScrDdd(WebDriver driver ) {
	    	JavascriptExecutor js4= (JavascriptExecutor) driver;
			for(; ;) {
			try {
				driver.findElement(By.linkText("Discharge")).click();
				break;
			}catch(Exception e) {
				js4.executeScript("window.scrollBy(0,900)");
			}
			}
	

		}
	
}
