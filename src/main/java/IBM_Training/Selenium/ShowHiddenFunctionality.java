package IBM_Training.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ShowHiddenFunctionality 
{
    WebDriver D;
    WebElement TextBox;
    @BeforeClass
	public void startTest() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\IBMADMIN\\Documents\\Driver\\chromedriver.exe");
        D= new ChromeDriver();
        D.get("https://courses.letskodeit.com/practice"); 
        D.manage().window().maximize();
        Thread.sleep(10000);
	}
    @Test
	public void testHideButton()
	{
		WebElement Hide=D.findElement(By.id("hide-textbox"));
		Hide.click();
		TextBox=D.findElement(By.name("show-hide"));
		boolean IsShown=TextBox.isDisplayed();
		Assert.assertEquals(IsShown, false);	
	}
    @Test
	public void testShowButton()
	{
		WebElement Show=D.findElement(By.id("show-textbox"));
		Show.click();
		boolean IsShown=TextBox.isDisplayed();
		Assert.assertEquals(IsShown, true);	
	}
    @AfterClass
    public void stop()
    {
    	D.close();
    }

}
