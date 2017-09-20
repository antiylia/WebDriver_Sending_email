package Email_home_task.Email_home_task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoSenderEmail {

	public WebDriver loginMailRu() {
		System.setProperty("webdriver.gecko.driver", "D:\\geckoDriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://mail.ru");

		final Wait<WebDriver> wait = new WebDriverWait(driver, 10L, 1000L).withMessage("Element was not found");
	    String xPathLogo = "//a[@title = 'Mail.Ru: почта, поиск в интернете, новости, игры']";
	//	String xPathLogo = "//a[@id = 'logo']";
		wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(xPathLogo))));
	//	WebElement elementLogin = driver.findElement(By.id("mailbox__login"));
		
		
	    String xPathLogin = "//form[@class='mailbox__auth__layout clearfix']/descendant::input";
	//	String xPathLogin = "//input[@class ='mailbox__login mix_placeholder']";
		WebElement elementLogin = driver.findElement(By.xpath(xPathLogin));
		elementLogin.sendKeys("tathtp");
		
		
	//	WebElement elementPassword = driver.findElement(By.id("mailbox__password"));
	//	String xPathPassword = "//input[@class ='mailbox__password mix_placeholder']";
		String xPathPassword = "//input[@type ='password']";	
		WebElement elementPassword = driver.findElement(By.xpath(xPathPassword));
		elementPassword.sendKeys("Klopik123");
		
		
	//	WebElement elementButtonSubmit = driver.findElement(By.id("mailbox__auth__button"));
		String xPathButtonSubmit = "//input[@class ='mailbox__auth__button']";
		WebElement elementButtonSubmit = driver.findElement(By.xpath(xPathButtonSubmit));
		elementButtonSubmit.submit();
		
		return driver;
	}

	public WebDriver sendEmail(WebDriver webDriver) {
		webDriver.navigate().refresh();
		
		String xPathButtonwriteEmail = "//div[@id='LEGO']//span";
		final Wait<WebDriver> wait = new WebDriverWait(webDriver, 5L, 1000L).withMessage("Element was not found");
		wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(xPathButtonwriteEmail))));
				
		WebElement writeEmail = webDriver.findElement(By.xpath(xPathButtonwriteEmail));
		writeEmail.click();

		WebElement recipient = webDriver.findElement(By.xpath("//textarea[@class = 'js-input compose__labels__input']"));
		//recipient.sendKeys("sviatlana.zakharenka@gmail.com");
		recipient.sendKeys("tathtp@mail.ru");		
		recipient.click();

		WebElement theme = webDriver.findElement(By.xpath("//input[@class = 'b-input']"));
		theme.click();
		theme.sendKeys("СПАМ_Антипирович Юлия_ДЗ_AutoEmail");

		String contentEmail = "HomeTask_Antipirovich_Y";

		WebElement iframe = webDriver.findElement(By.xpath("//iframe[starts-with(@id,'toolkit')]")); // динамический id

		webDriver.switchTo().frame(iframe);
		webDriver.findElement(By.id("tinymce")).click();
		webDriver.findElement(By.id("tinymce")).sendKeys(contentEmail);
		webDriver.findElement(By.id("tinymce")).click();

		webDriver.switchTo().defaultContent();

	 	WebElement sendEmail = webDriver.findElement(By.xpath("//span[@class = 'b-toolbar__btn__text']"));
		sendEmail.click();

		return webDriver;
	}

}
