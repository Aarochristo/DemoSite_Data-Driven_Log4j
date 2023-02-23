package apachepoiexel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class classsdatapass {

	WebDriver driver;

	@BeforeTest
	void suite() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\CapstoneP\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://demo.automationtesting.in/Register.html");

	}

	@Test(dataProvider = "registerdetails")
	void run(String nm, String last, String email, String num ) throws FileNotFoundException {

		System.out.println(nm + last + email + num );
		
		
		WebElement el=driver.findElement(By.xpath("//input[@placeholder='First Name']"));el.sendKeys(nm);
		el.clear();
		
		WebElement ell=driver.findElement(By.xpath("//input[@placeholder='Last Name']"));ell.sendKeys(last);
		ell.clear();
		
		WebElement elll=driver.findElement(By.xpath("//input[@type='email']"));elll.sendKeys(email);
		elll.clear();
		

		WebElement ellll=driver.findElement(By.xpath("//input[@type='tel']"));ellll.sendKeys(num);
		ellll.clear();
	}

	@DataProvider(name = "registerdetails")
	public String[][] dATAPROVIDER() throws IOException {

		String path = ("C:\\Users\\aaron\\Downloads\\Bookkk.xlsx");

		// String[][] all =

		utilityFile ne = new utilityFile(path);
		

		int totalRow = ne.getrowcount("Sheet1");
		
		System.out.println("totalRow"+totalRow);

		int totalcol = ne.colCount("Sheet1", 1);
		
		System.out.println("totalcol"+totalcol);
		
		
		

		String registerData[][] = new String[totalRow][totalcol];

		for (int i = 1; i < totalRow+1; i++) {

			for (int j = 0; j < totalcol; j++) {

				registerData[i-1][j] = ne.getCellData("Sheet1", i, j);

			}
		}

		return registerData;

	}
	

	@AfterSuite
	void close()
	{
		
		driver.close();
	}

}
