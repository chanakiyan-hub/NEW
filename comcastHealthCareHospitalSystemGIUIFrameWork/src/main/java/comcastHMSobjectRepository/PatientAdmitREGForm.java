package comcastHMSobjectRepository;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PatientAdmitREGForm {

	WebDriver driver;
	public PatientAdmitREGForm(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="pet_disea")
	private WebElement DiseBtn;
	
	@FindBy(name="adm_rn")
	private WebElement SelRomBtn;
	
	@FindBy(name="submit")
	private WebElement PaAdmtSubmitBtn;

	public WebElement getDiseBtn() {
		return DiseBtn;
	}

	public WebElement getSelRomBtn() {
		return SelRomBtn;
	}

	public WebElement getPaAdmtSubmitBtn() {
		return PaAdmtSubmitBtn;
	}
	
	 public void toScrollAdForm(WebDriver driver , String EL ) {
	    	JavascriptExecutor js2= (JavascriptExecutor) driver;
			for(; ;) {
			try {
				driver.findElement(By.name("pet_disea")).click();
				break;
			}catch(Exception e) {
				js2.executeScript("window.scrollBy(0,300)");
			}
			}
	 		DiseBtn.sendKeys("Fever");
	 }
 
	 public void Romno() {
		 SelRomBtn.click();
		 Random r = new Random();
		 int random = r.nextInt(5);
			Select sel3= new Select(SelRomBtn);
			//sel3.selectByVisibleText(" Room No: 4");
			sel3.selectByIndex(random);
	 }
	
	
	
	
	
}
