package comcastHMSobjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffInfo {
	


	WebDriver driver;
	public StaffInfo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(partialLinkText="Add Staff Memeber")
	private WebElement AddStaffMemLNK;
	
	@FindBy(partialLinkText= "Staff Memebers Details")
	private WebElement StaffMemDETailsLNK;
	
	@FindBy(partialLinkText= "Staff Memeber Search")
	private WebElement STaffSearchLNK;
	
	@FindBy(partialLinkText= "Active Members")
	private WebElement ActiveMEmLNK;
	
	@FindBy(xpath = "//h3[@class='text-center']")
	private WebElement stverify;
	
	/**
	 * @return the stverify
	 */
	public WebElement getStverify() {
		return stverify;
	}
	

	public WebElement getAddStaffMemLNK() {
		return AddStaffMemLNK;
	}

	public WebElement getStaffMemDETailsLNK() {
		return StaffMemDETailsLNK;
	}

	public WebElement getSTaffSearchLNK() {
		return STaffSearchLNK;
	}

	public WebElement getActiveMEmLNK() {
		return ActiveMEmLNK;
	}
	
	@FindBy(xpath = "//div[@class='col-md-4 col-xs-4 alert-success']")
	private WebElement EVngDet;
	
	
	public WebElement getEVngDet() {
		return EVngDet;
	}

	public void toScrollSTtttt(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (;;) {
			try {
				driver.findElement(By.xpath("//h4[contains(text(),'Evening')]")).click();
				break;
			} catch (Exception e) {
				js.executeScript("window.scrollBy(0,300)");
			}
		}
	}

}
