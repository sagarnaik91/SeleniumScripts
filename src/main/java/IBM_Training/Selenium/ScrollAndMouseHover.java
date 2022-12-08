package IBM_Training.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScrollAndMouseHover {
	RemoteWebDriver D;

	@BeforeClass
	public void start() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\IBMADMIN\\Documents\\Driver\\chromedriver.exe");
		D = new ChromeDriver();
		D.get("https://courses.letskodeit.com/practice");
		D.manage().window().maximize();
	}

	@Test
	public void launch() throws InterruptedException {
		WebElement mouseHover = D.findElement(By.id("mousehover"));
		D.executeScript("arguments[0].scrollIntoView();", mouseHover);
		Thread.sleep(2000);
		Actions act=new Actions(D); 
		act.moveToElement(mouseHover).perform();
		Thread.sleep(1000);
		WebElement scrollOption=D.findElement(By.linkText("Top"));
		scrollOption.click();
	}
}
