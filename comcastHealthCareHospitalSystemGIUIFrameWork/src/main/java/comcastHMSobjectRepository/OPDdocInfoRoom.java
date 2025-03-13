package comcastHMSobjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OPDdocInfoRoom {

	WebDriver driver;
	public OPDdocInfoRoom(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='panel-body']")
     private WebDriver DocInfoPrin;
	
	public WebDriver getDocInfoPrin() {
		return DocInfoPrin;
	}

	public void toScrolldocinfoooo(WebDriver driver ) {
		JavascriptExecutor js2= (JavascriptExecutor) driver;
		for(; ;) {
		try {
			driver.findElement(By.xpath("//div[contains(text(),'OPD Doctor Address:')]")).click();
			break;
		}catch(Exception e) {
			js2.executeScript("window.scrollBy(0,250)");
		}
		}
	}
}
