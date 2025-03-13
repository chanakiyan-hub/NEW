package comcastHMSobjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//Rule-1 create seperate class
	//Rule-2 Object creation
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="field")
	private WebElement usernameEdt;
	
	@FindBy(name="sadmpw")
	private WebElement passwordEdt;
	
	@FindBy(xpath="//button[contains(text(),'SUBMIT')]")
	private WebElement loginBtn;
	
	//Rule-3 object intialization
	//Rule-4 object Encapsulation
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	/**
	 * login to app based on username ,password,url
	 * @param url
	 * @param username
	 * @param password
	 */
	//Rule-5 provide Action
	public void loginToApp( String url , String username , String password) {
		driver.get(url);
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    WebElement Login = driver.findElement(By.name("login"));
		js.executeScript("arguments[0].scrollIntoView(true)", Login);
		loginBtn.click();
	}
	
	
}
