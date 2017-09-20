package Email_home_task.Email_home_task;

import org.openqa.selenium.WebDriver;

/*
1. залогиниться в mail.ru и написать тест на testng, что мы действительно смогли залогиниться (найти элемент logout или аналогичный).
2. на mail.ru создать письмо и отправить Светлане на gmail (spam)
*/
public class App  {
	
    public static void main( String[] args ) {
    	AutoSenderEmail sender = new AutoSenderEmail();
    	WebDriver webDriver = sender.loginMailRu();
    	// sender.sendEmail (webDriver);
    }
    
    
}
