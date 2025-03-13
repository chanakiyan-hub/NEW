package comcastHMSobjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffMemSearch {

	WebDriver driver;
	public StaffMemSearch(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="searvalu")
	private WebElement STSearchBarLNK;
	
	@FindBy(xpath= "//button[text()='Search']")
	private WebElement STSubmitBtn;

	public WebElement getSTSearchBarLNK() {
		return STSearchBarLNK;
	}

	public WebElement getSTSubmitBtn() {
		return STSubmitBtn;
	}
	
	@FindBy(xpath = "(//dd[@style='font-size:12px;'])[3]")
	private WebElement Expectma;
	
	public WebElement getExpectma() {
		return Expectma;
	}

	public void toScrollSTSub(WebDriver driver) {
    	JavascriptExecutor js2= (JavascriptExecutor) driver;
		for(; ;) {
		try {
			driver.findElement(By.xpath("//button[text()='Search']")).click();
			break;
		}catch(Exception e) {
			js2.executeScript("window.scrollBy(0,350)");
		}
		}
}
	
	public void toScrollSTDet( WebDriver driver) {
    	JavascriptExecutor js11= (JavascriptExecutor) driver;
		for(; ;) {
		try {
			driver.findElement(By.xpath("(//a[contains(text(),'Staff Details Modifications')]/../../../ul/li/a[1])[1]")).click();
			break;
		}catch(Exception e) {
			js11.executeScript("window.scrollBy(0,350)");
		}
		}
}

}
