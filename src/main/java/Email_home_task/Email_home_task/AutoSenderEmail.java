package Email_home_task.Email_home_task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutoSenderEmail {
	
	
	

	public WebDriver loginMailRu() {
		System.setProperty("webdriver.gecko.driver", "D:\\geckoDriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://mail.ru");

		WebElement elementLogin = driver.findElement(By.id("mailbox__login"));
		elementLogin.sendKeys("tathtp");
		WebElement elementPassword = driver.findElement(By.id("mailbox__password"));
		elementPassword.sendKeys("Klopik123");
		WebElement elementButtonSubmit = driver.findElement(By.id("mailbox__auth__button"));
		elementButtonSubmit.submit();
		return driver;
	 }
	
	public WebDriver sendEmail (WebDriver webDriver) {
		webDriver.navigate().refresh();
		String xPathButtonwriteEmail = "//div[@id='LEGO']//span";
		
		WebElement writeEmail = webDriver.findElement(By.xpath(xPathButtonwriteEmail));
		writeEmail.click();
		
		WebElement recipient = webDriver.findElement(By.cssSelector("textarea[class = 'js-input compose__labels__input']"));
		recipient.sendKeys("sviatlana.zakharenka@gmail.com");
		recipient.click();
				
		WebElement theme = webDriver.findElement(By.cssSelector("input[class = 'b-input']"));
		theme.click();
		theme.sendKeys("СПАМ_Антипирович Юлия_ДЗ_AutoEmail");
		
		String contentEmail = "Доброе воскресенье. Динамический id коварен!";
	
		WebElement iframe = webDriver.findElement(By.xpath("//iframe[starts-with(@id,'toolkit')]")); //  динамический id
		
		webDriver.switchTo().frame(iframe);
		webDriver.findElement(By.id("tinymce")).click();
		webDriver.findElement(By.id("tinymce")).sendKeys(contentEmail);
		webDriver.findElement(By.id("tinymce")).click();
		
		webDriver.switchTo().defaultContent();
				
		String xPathButtonSendEmail = "//div[@id='LEGO']";
		WebElement sendEmail = webDriver.findElement(By.cssSelector("span[class = 'b-toolbar__btn__text']"));
		sendEmail.click();
				
		
		return webDriver;
	}

}
