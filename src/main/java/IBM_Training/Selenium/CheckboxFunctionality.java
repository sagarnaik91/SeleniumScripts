package IBM_Training.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckboxFunctionality {
	WebDriver D;

	@BeforeTest
	public void start() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\IBMADMIN\\Documents\\Driver\\chromedriver_win32\\chromedriver.exe");
		D = new ChromeDriver();
		D.get("https://courses.letskodeit.com/practice");
		D.manage().window().maximize();
	}

	@Test(priority = 1)
	public void checkBoxFunctionality() {
		WebElement checkBox = D.findElement(By.id("bmwcheck"));
		checkBox.click();
		boolean IsSelected = checkBox.isSelected();
		Assert.assertEquals(IsSelected, true, "Not selected");

	}

	@Test(priority = 2)
	public void uncheckFunctionality() {
		WebElement checkBox = D.findElement(By.id("bmwcheck"));
		checkBox.click();
		boolean IsSelected = checkBox.isSelected();
		Assert.assertEquals(IsSelected, false, "selected");
	}

	@AfterTest
	public void stop() {
		D.quit();
	}
}
