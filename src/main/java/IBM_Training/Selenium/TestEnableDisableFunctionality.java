package IBM_Training.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestEnableDisableFunctionality {
	WebDriver D;
	WebElement enableDisable;

	@BeforeClass
	public void startTest() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\IBMADMIN\\\\Documents\\\\Driver\\\\chromedriver.exe");
		D = new ChromeDriver();
		D.get("https://courses.letskodeit.com/practice");
		D.manage().window().maximize();
	}

	@Test
	public void testDisable() {
		WebElement DisableButton = D.findElement(By.cssSelector("input[value='Disable']"));
		DisableButton.click();
		enableDisable = D.findElement(By.id("enabled-example-input"));
		boolean fieldEnabled = enableDisable.isEnabled();
		Assert.assertEquals(fieldEnabled, false, "Disable not working");
	}

	@Test
	public void testEnable() {
		WebElement EnableButton = D.findElement(By.cssSelector("input[value='Enable']"));
		EnableButton.click();
		boolean fieldEnabled = enableDisable.isEnabled();
		Assert.assertEquals(fieldEnabled, true, "Enable not working");
	}

	@AfterClass
	public void stop() {
		D.quit();
	}
}
