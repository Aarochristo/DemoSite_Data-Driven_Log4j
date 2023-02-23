package mainProgram;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class page1 {

	@Test(priority = 0)

	void SetProperty() {

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\CapstoneP\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

}
