package comcastHMSobjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UpdateRoomForm {

	



	WebDriver driver;
	public UpdateRoomForm(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h3[@class=\"text-center\"]")
	private WebElement roVerify;


	

	/**
	 * @return the roVerify
	 */
	public WebElement getRoVerify() {
		return roVerify;
	}
	@FindBy(name="mrdo")
	private WebElement MrngDocSel;
	
	@FindBy(name="erdo")
	private WebElement EvngDocSel;
	
	@FindBy(xpath ="//button[contains(text(),'Submit')]")
	private WebElement RomUpDSubmitBtn;

	public WebElement getMrngDocSel() {
		return MrngDocSel;
	}

	public WebElement getEvngDocSel() {
		return EvngDocSel;
	}

	public WebElement getRomUpDSubmitBtn() {
		return RomUpDSubmitBtn;
	}
	
	
	public void toScrolupdate(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (;;) {
			try {
				driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
				break;
			} catch (Exception e) {
				js.executeScript("window.scrollBy(0,300)");
			}
		}
	}
public void DocIn(int dig1 , int dig2) {
	MrngDocSel.click();
	Select sel = new Select(MrngDocSel);
	sel.selectByIndex(4);
	MrngDocSel.getText();
	EvngDocSel.click();
	Select sel1 = new Select(EvngDocSel);
	sel1.selectByIndex(3);
	EvngDocSel.getText();
	
	
	
	
}
}
