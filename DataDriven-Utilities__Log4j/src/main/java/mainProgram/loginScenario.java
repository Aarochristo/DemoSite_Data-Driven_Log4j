package mainProgram;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class loginScenario {

	WebDriver driver;

	@Test(dataProvider = "exeldata", dataProviderClass = providrerclass.class)

	void actualTest(String secinddta[]) throws InterruptedException

	{
		
		

		/*
		 * 
		 * READ-- Step 1 : Create class with ( 2dimensional array method -- > public
		 * static String[][] main() throws IOException {
		 * 
		 * get the data from exel and store in return type
		 * 
		 * 
		 * 
		 * STORE-- Step 2 : craete class 2 and 2dimensoonal array metod
		 * with @Dataprovider annotation --->
		 * 
		 * 
		 * @DataProvider
		 * 
		 * public String[][] exeldata() throws IOException and get return value as (
		 * return secinddta; )
		 * 
		 * 
		 * 
		 * INSERT DATA INTO SCRIPT ------Step 3 :Next v hav to cl that exeldata() from
		 * that class ex ---> @Test(dataProvider = "exeldata",dataProviderClass =
		 * providrerclass.class)
		 * 
		 * Step 4 :
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
		System.out.println(secinddta[0]);

		System.out.println(secinddta[1]);


		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(secinddta[0]);
		
		Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.findElement(By.xpath("//input[@name='password' and @placeholder='Password']")).sendKeys(secinddta[1]);
		
		Thread.sleep(2000);

		WebElement pass = driver.findElement(By.xpath("//button[@type='submit']"));
		
		

		wait.until(ExpectedConditions.elementToBeClickable(pass));
		pass.click();
		
		Thread.sleep(2000);
		
		driver.close();

	}

}
