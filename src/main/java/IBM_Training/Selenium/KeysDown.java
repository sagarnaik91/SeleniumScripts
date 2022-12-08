package IBM_Training.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class KeysDown {
	WebDriver D;

	@BeforeClass
	public void start() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\IBMADMIN\\Documents\\Driver\\chromedriver_win32\\chromedriver.exe");
		D = new ChromeDriver();
		D.navigate().to("https://courses.letskodeit.com/practice");
		D.manage().window().maximize();
	}

	@Test(priority = 1)
	public void selectFromDropDown() throws InterruptedException {
		WebElement selectDropdown = D.findElement(By.id("carselect"));
		selectDropdown.click();
		selectDropdown.sendKeys(Keys.ARROW_DOWN);
		selectDropdown.sendKeys(Keys.ARROW_DOWN);
		selectDropdown.sendKeys(Keys.ENTER);

	}

	@Test(priority = 2)
	public void dragAndDrop() throws InterruptedException {
		WebElement dragAndDropStr = D.findElement(By.xpath("//*[@id=\"multiple-select-example\"]/option[1]"));
		WebElement dragAndDropEnd = D.findElement(By.xpath("//*[@id=\"multiple-select-example\"]/option[3]"));
		dragAndDropStr.click();
		Thread.sleep(2000);
		Actions action = new Actions(D);
		action.dragAndDrop(dragAndDropStr, dragAndDropEnd);
	
	}
}
