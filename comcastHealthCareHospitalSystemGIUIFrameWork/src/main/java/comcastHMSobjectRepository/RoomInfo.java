package comcastHMSobjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoomInfo {



	WebDriver driver;

	public RoomInfo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id = "infor10")
	private WebElement RoomII;
	

	/**
	 * @return the roomII
	 */
	public WebElement getRoomII() {
		return RoomII;
	}
	@FindBy(linkText = "Doctor Info")
	private WebElement DocinfoMMmBtn;

	@FindBy(linkText = "Doctor Info")
	private WebElement DocinfoEvngBtn;

	@FindBy(partialLinkText  = "Update Room Informtion")
	private WebElement updateRomInfoBtn;

	public WebElement getDocinfoMMmBtn() {
		return DocinfoMMmBtn;
	}

	public WebElement getDocinfoEvngBtn() {
		return DocinfoEvngBtn;
	}

	public WebElement getUpdateRomInfoBtn() {
		return updateRomInfoBtn;
	}

	public void toScrollROm(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (;;) {
			try {
				driver.findElement(By.xpath("(//a[@name='ad']/../../td[9]/a[1])[1]")).click();
				break;
			} catch (Exception e) {
				js.executeScript("window.scrollBy(0,300)");
			}
		}
	}

	@FindBy(id = "rr10")
	private WebElement room10;

	public WebElement getRoom10() {
		return room10;
	}
	
	@FindBy(id="infor10")
	private WebElement ro10info;

	public WebElement getRo10info() {
		return ro10info;
	}

	public void toScrorrom10(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (;;) {
			try {
				driver.findElement(By.id("rr10")).click();
				break;
			} catch (Exception e) {
				js.executeScript("window.scrollBy(0,300)");
			}
		}
	}

	@FindBy(xpath = "(//a[contains(text(),'Doctor Info')])[1]")
	private WebElement docinfo;

	public WebElement getDocinfo() {
		return docinfo;
	}
	public void toScroDOcInfo(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (;;) {
			try {
				driver.findElement(By.xpath("(//a[contains(text(),'Doctor Info')])[1]")).click();
				break;
			} catch (Exception e) {
				js.executeScript("window.scrollBy(0,300)");
			}
		}
	}
	
}
