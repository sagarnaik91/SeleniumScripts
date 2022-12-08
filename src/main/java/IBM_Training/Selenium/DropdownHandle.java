package IBM_Training.Selenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropdownHandle {
	WebDriver D;
	Select sel;
	WebElement dropdown;

	@BeforeClass
	public void start() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\IBMADMIN\\Documents\\Driver\\chromedriver.exe");
		D = new ChromeDriver();
		D.get("https://courses.letskodeit.com/practice");
		D.manage().window().maximize();
	}

	@Test(priority = 1)
	public void dropDownControl() {
		dropdown = D.findElement(By.id("carselect"));
		sel = new Select(dropdown);
		WebElement firstSelected = sel.getFirstSelectedOption();
		String text = firstSelected.getText();
		boolean isEqual = text.equals("BMW");
		Assert.assertEquals(isEqual, true, "BMW is not displayd");
	}

	@Test(priority = 2)
	public void verifySelect() throws InterruptedException {

		sel.selectByValue("honda");

	}

	@Test(priority = 3)
	public void listAllDropDown() {
		List<String> list = new ArrayList<String>();
		list.add("BMW");
		list.add("Benz");
		list.add("Honda");

		List<WebElement> dropDownList = sel.getOptions();

		for (WebElement option : dropDownList) {
			String optionText=option.getText();
			boolean contains = list.contains(optionText);
			Assert.assertEquals(contains, true, optionText+" not present");
		}
	}
}
