package IBM_Training.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckingAlertFunctionality {

	WebDriver D;

	@BeforeClass
	public void start() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\IBMADMIN\\Documents\\Driver\\chromedriver.exe");
		D = new ChromeDriver();
		D.get("https://courses.letskodeit.com/practice");
		D.manage().window().maximize();

	}

	@Test
	public void checkAlert() {
		WebElement TextBox = D.findElement(By.id("name"));
		TextBox.sendKeys("Sagar Naik");
		String enteredName = TextBox.getAttribute("placeholder");
		WebElement alertButton = D.findElement(By.id("alertbtn"));
		alertButton.click();
		String text = D.switchTo().alert().getText();
		boolean contains = enteredName.contains(text);
		Assert.assertEquals(contains, true, "string do not match");

	}

	@AfterClass
	public void stop() {
		D.quit();
	}
}
