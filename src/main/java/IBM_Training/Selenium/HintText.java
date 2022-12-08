package IBM_Training.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HintText {
	WebDriver D;

	@BeforeClass
	public void startTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\IBMADMIN\\Documents\\Driver\\chromedriver.exe");
		D = new ChromeDriver();
		D.get("https://courses.letskodeit.com/practice");
		D.manage().window().maximize();
	}

	@Test
	public void hintText() {
		WebElement nameBox = D.findElement(By.cssSelector("input[placeholder='Enter Your Name']"));
		String PlaceHolder = nameBox.getAttribute("placeholder");
		Assert.assertEquals(PlaceHolder, "Enter Your Name1");
	}

	@AfterClass
	public void stop() {
		D.quit();
	}

}
