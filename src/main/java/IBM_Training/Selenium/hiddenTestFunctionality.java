package IBM_Training.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class hiddenTestFunctionality 
{
	WebDriver D;
	WebElement textBox;
	@BeforeClass
	public void startBrowser() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\IBMADMIN\\Documents\\Driver\\chromedriver.exe");
		D = new ChromeDriver();
		D.get("https://courses.letskodeit.com/practice");
		D.manage().window().maximize();
		Thread.sleep(10000);
	}
	@Test
	public void hideButtonTest()
	{
		WebElement hide = D.findElement(By.id("hide-textbox"));
		hide.click();
		textBox=D.findElement(By.name("show-hide"));
		boolean isShown= textBox.isEnabled();
		Assert.assertEquals(isShown, false);
		
	}
	@Test
	public void showButtonTest()
	{
		WebElement show=D.findElement(By.id("show-textbox"));
		show.click();
		textBox=D.findElement(By.name("show-hide"));
		boolean isShown= textBox.isEnabled();
		Assert.assertEquals(isShown, true);
	}
	@AfterClass
	public void stop()
	{
		D.close();
	}

}
