package Email_home_task.Email_home_task;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutoSenderEmailTest {

	private AutoSenderEmail	senderTest;
	private static WebDriver dr;
	
	
	@BeforeClass 
	public void init() {
		senderTest = new AutoSenderEmail();	
	}
			
	@Test
	public void logOutIsFound () {
		dr = senderTest.loginMailRu();
		
		dr.navigate().refresh(); // refreshing current url  
		
		
	    WebElement elementLogOut = dr.findElement(By.xpath("//table[@class='x-ph__auth']/descendant::a[@id='PH_logoutLink']"));	
	 // WebElement elementLogOut = dr.findElement(By.xpath("//a[@id='PH_logoutLink']"));
	 //	WebElement elementLogOut = dr.findElement(By.id("PH_logoutLink"));
	    assertEquals("выход", elementLogOut.getText());
	}

	@AfterClass
    public static void logout() {	
		// WebElement elementLogOut = dr.findElement(By.xpath("//a[@id='PH_logoutLink']"));
        WebElement logoutButton = dr.findElement(By.id("PH_logoutLink"));
        logoutButton.click();
      //  dr.quit();
    }
	
	
}
