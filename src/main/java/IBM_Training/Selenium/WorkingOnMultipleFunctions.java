package IBM_Training.Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WorkingOnMultipleFunctions {
	WebDriver D;

	@BeforeClass
	public void start() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\IBMADMIN\\Documents\\Driver\\chromedriver.exe");
		D = new ChromeDriver();
		D.get("https://courses.letskodeit.com/practice");
		D.manage().window().maximize();

	}

	@Test
	public void checkBoxesTest() throws InterruptedException {
		WebElement checkBoxCategory = D.findElement(By.id("checkbox-example-div"));
		List<WebElement> checkBoxes = checkBoxCategory.findElements(By.name("cars"));
		System.out.println(checkBoxes.size());
		for (WebElement checkBox : checkBoxes) {
			String bmwVer = checkBox.getAttribute("id");
			if (bmwVer.equals("bmwcheck")) {
				checkBox.click();
				Thread.sleep(2000);
				boolean isSelected = checkBox.isSelected();
				Assert.assertEquals(isSelected, true, "CheckBox not selected");
			}
		}

	}
}
