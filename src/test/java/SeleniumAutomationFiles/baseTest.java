package SeleniumAutomationFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class baseTest {
	protected WebDriver driver;
	
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
	}
	
	@AfterClass
	public void TearDown() {
		driver = new ChromeDriver();
		driver.quit();
	}
	

}
