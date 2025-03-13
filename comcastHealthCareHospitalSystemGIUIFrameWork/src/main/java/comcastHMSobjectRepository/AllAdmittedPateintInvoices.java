package comcastHMSobjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllAdmittedPateintInvoices {
	
	WebDriver driver;
	public AllAdmittedPateintInvoices(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "View")
	private WebElement AlAmtPaINvoiceVIEWBtn;

	public WebElement getAlAmtPaINvoiceVIEWBtn() {
		return AlAmtPaINvoiceVIEWBtn;
	}
	
	@FindBy(id = "upform")
	private WebElement INvoice;
	public WebElement getINvoice() {
		return INvoice;
	}
	
	public void toScrollPAAllinvoi(WebDriver driver ) {
		JavascriptExecutor js2= (JavascriptExecutor) driver;
		for(; ;) {
		try {
			driver.findElement(By.linkText("View")).click();
			break;
		}catch(Exception e) {
			js2.executeScript("window.scrollBy(0,350)");
		}
		}
	}
	

}
