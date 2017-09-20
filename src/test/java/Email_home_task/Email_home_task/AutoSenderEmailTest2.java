package Email_home_task.Email_home_task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoSenderEmailTest2 {

	private AutoSenderEmail senderTest;
	private static WebDriver dr;

	@BeforeClass
	public void init() {
		senderTest = new AutoSenderEmail();
	}

	@BeforeMethod
	public void logIn() {
		dr = senderTest.loginMailRu();
	}

	@Test
	public void sendsEmail() {
		dr.navigate().refresh();
		dr = senderTest.sendEmail(dr);
	   // dr.navigate().back();
		
		final Wait<WebDriver> wait = new WebDriverWait(dr, 10L, 1000L).withMessage("Element was not found");
		String xPathsResult = "//div[@class='message-sent__title']";
		wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(xPathsResult))));
				
		
		WebElement responseEmailSent = dr.findElement(By.xpath(xPathsResult));
		Assert.assertNotNull(responseEmailSent);
		 
		
	/*
	 String xPathsentEmails = "//span[text() = 'Отправленные']";	
	 WebElement sentEmails = dr.findElement(By.xpath(xPathsentEmails));
	 sentEmails.click();
	 
	 */
	}	
		
	@AfterClass
    public static void logoutExit() {		
        WebElement logoutButton = dr.findElement(By.id("PH_logoutLink"));
        logoutButton.click();
        dr.quit();
    }				
	
}
