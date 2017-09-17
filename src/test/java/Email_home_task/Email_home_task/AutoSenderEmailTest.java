package Email_home_task.Email_home_task;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutoSenderEmailTest {

	private AutoSenderEmail	senderTest;
	
	
	@BeforeClass 
	public void init() {
		senderTest = new AutoSenderEmail();	
	}
			
	@Test
	public void logOutIsFound () {
		WebDriver dr = senderTest.loginMailRu();
		
		dr.navigate().refresh(); // refreshing current url  
		   
		WebElement elementLogOut = dr.findElement(By.id("PH_logoutLink"));
	    assertEquals("выход", elementLogOut.getText());
	}

}
