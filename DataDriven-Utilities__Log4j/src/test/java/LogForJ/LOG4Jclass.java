package LogForJ;

import java.util.Set;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.spi.LoggerRepository;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LOG4Jclass {
	
	
	
	
	static WebDriver driver;
	
	
	static Logger log= Logger.getLogger(LOG4Jclass.class);
	
	@Test
	public static void main() {
		
		//BasicConfigurator.configure();
		
		
		PropertyConfigurator.configure("C:\\Users\\aaron\\git\\akmProject\\MinkF\\src\\test\\java\\LogForJ\\log.properties");
		
		
		log.debug("driver started");
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\CapstoneP\\chromedriver.exe");
		
		 driver =new ChromeDriver();
		
		driver.get("https:\\www.google.com");
			

		
		log.info("launched");
		
		
		
	}
	

	
	@Test(priority = 1)
	 void warntitle()
	 {
		 
		Set<Cookie> s= driver.manage().getCookies();
		
		System.out.println(s.toString());
		 
		 log.warn("Getting Cookies");
		 
	 }
	@Test(priority = 2)
	 void deeleted()
	 {
		 
		 
		driver.manage().deleteAllCookies();
		
			log.fatal("deleted cookies");
			Set<Cookie> s= driver.manage().getCookies();
			
			System.out.println(s.toString());
			
			
	 }
	@Test(priority = 3)
	 void close()
	 {
		 
		LoggerRepository name= log.getLoggerRepository() ;
		System.out.println(name.toString());
		 driver.quit();
	 }
	 
	 
	 
	 
	 
	 
	 
	 

}
