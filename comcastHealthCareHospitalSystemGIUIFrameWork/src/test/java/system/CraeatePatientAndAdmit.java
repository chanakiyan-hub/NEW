package system;
import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CraeatePatientAndAdmit {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("http://49.249.28.218:8081/AppServer/Health_Care_Hospital_System/");

		driver.findElement(By.id("field")).sendKeys("basicadmin");
		driver.findElement(By.name("sadmpw")).sendKeys("123");
		// driver.findElement(By.name("login")).click();
		// driver.findElement(By.xpath("//button[contains(text(),'SUBMIT')]")).click();
		// driver.findElement(By.xpath("//button[@type='submit']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    WebElement Login = driver.findElement(By.name("login"));
		js.executeScript("arguments[0].scrollIntoView(true)", Login);
		driver.findElement(By.xpath("//button[contains(text(),'SUBMIT')]")).click();
		
		driver.findElement(By.linkText("Patient Info")).click();
		driver.findElement(By.partialLinkText("Patient Registration")).click();
		
		int n=6;
		//choose a character random from this string
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		//create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);
		for (int i=0; i<n; i++) {
			int index = (int) (AlphaNumericString.length()* Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}
	
		driver.findElement(By.id("fname")).sendKeys("chan");
		WebElement last = driver.findElement(By.id("lname"));
		last.sendKeys("jo" + sb );
		
		 WebElement opdoc = driver.findElement(By.name("dnames"));
		 Select sel = new Select(opdoc);
		// sel.selectByVisibleText("wade wi");
		 sel.selectByIndex(4);
		 
		 driver.findElement(By.name("addr")).sendKeys("5th cross,new road ,bengaluru");
		
		 int n2=9;
			//choose a character random from this string
			String AlphaNumericString2 = "1234567890";
			//create StringBuffer size of AlphaNumericString
			StringBuilder sb2 = new StringBuilder(n2);
			for (int i=0; i<n; i++) {
				int index = (int) (AlphaNumericString2.length()* Math.random());
				sb2.append(AlphaNumericString2.charAt(index));
			}
		
		 driver.findElement(By.name("tel")).sendKeys("123345" + sb2);
		 driver.findElement(By.id("eml")).sendKeys(sb +"@gmail.com" );
		 
		 JavascriptExecutor js1 = (JavascriptExecutor) driver;
		    WebElement submit = driver.findElement(By.name("submit"));
			js1.executeScript("arguments[0].scrollIntoView(true)", submit);
			
		 WebElement gen = driver.findElement(By.name("gender"));
		 Select sel1 = new Select(gen);
		 //sel1.selectByVisibleText("Male");
		 sel1.selectByIndex(1);
		 
		 driver.findElement(By.name("smbdd")).sendKeys(sb2);
		 WebElement bld = driver.findElement(By.name("bg"));
		 Select sel2 = new Select(bld);
		 //sel2.selectByVisibleText("A RhD positive (A+)");
		 sel2.selectByIndex(3);
		 driver.findElement(By.name("submit")).click();
		 
		 driver.findElement(By.xpath("//strong[contains(text(),'Patient Information')]")).click();
		 
	/*	 JavascriptExecutor js2 = (JavascriptExecutor) driver;
		    WebElement admit = driver.findElement(By.xpath("(//a[@name='ad']/../../td[7]/a[1])[1]"));
			js2.executeScript("arguments[0].scrollIntoView(true)", admit); */
		 
		 JavascriptExecutor js2= (JavascriptExecutor) driver;
			for(; ;) {
			try {
				driver.findElement(By.xpath("(//a[@name='ad']/../../td[7]/a[1])[1]")).click();
				break;
			}catch(Exception e) {
				js2.executeScript("window.scrollBy(0,250)");
			}
		}
			
		 driver.findElement(By.xpath("(//a[@name='ad']/../../td[7]/a[1])[1]")).click();
		// driver.findElement(By.xpath("//a[text()='"+ last +"']")).click();// dynamic xpath

		
		 Set<String> windowId =driver.getWindowHandles();
			for(String id : windowId) {
				driver.switchTo().window(id);
				String url= driver.getCurrentUrl();
			if(url.contains("admit.php")) {
				break;
			}
		} 
			 WebElement dise = driver.findElement(By.name("pet_disea"));
			JavascriptExecutor js3= (JavascriptExecutor) driver;
			js3.executeScript("arguments[0].scrollIntoView(true)", dise);
			dise.sendKeys("Fever");
			
	   WebElement romno = driver.findElement(By.name("adm_rn"));
			Random r = new Random();
			int random = r.nextInt(9);
			Select sel3= new Select(romno);
			//sel3.selectByVisibleText(" Room No: 4");
			sel3.selectByIndex(random);
			
			driver.findElement(By.name("submit")).click();
			
			
			
		 
		 
		 
		 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
