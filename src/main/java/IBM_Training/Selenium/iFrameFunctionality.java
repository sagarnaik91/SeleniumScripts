package IBM_Training.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class iFrameFunctionality {
	WebDriver D;

	@BeforeClass
	public void start() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\IBMADMIN\\Documents\\Driver\\chromedriver.exe");
		D = new ChromeDriver();
		D.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_test");
		D.manage().window().maximize();
	}

	@Test
	public void iFrameFunc() {
		D.switchTo().frame("iframeResult");
		WebElement firstName = D.findElement(By.id("fname"));
		firstName.sendKeys("Sagar");
		String fName = firstName.getAttribute("value");
		WebElement lastName = D.findElement(By.id("lname"));
		lastName.sendKeys("Naik");
		String lName = lastName.getAttribute("value");
		WebElement submitBtn = D.findElement(By.cssSelector("input[value='Submit']"));
		submitBtn.click();

		WebElement submittedData=D.findElement(By.xpath("/html/body/div[1]"));
		String submittedText = submittedData.getText();
		boolean submittedTextVerifyfName = submittedText.contains(fName);
		boolean submittedTextVerifylName = submittedText.contains(lName);
		Assert.assertEquals(submittedTextVerifyfName, true, "FirstName not displayed");
		Assert.assertEquals(submittedTextVerifylName, true, "LastName not displayed");
		D.switchTo().defaultContent();
		WebElement runBtn = D.findElement(By.id("runbtn"));
		runBtn.click();

	}

	@AfterClass
	public void stop() {
		D.quit();
	}

}
