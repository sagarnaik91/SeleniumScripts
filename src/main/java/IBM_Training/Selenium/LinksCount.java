package IBM_Training.Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LinksCount {
	WebDriver D;

	@BeforeClass
	public void start() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\IBMADMIN\\Documents\\Driver\\chromedriver.exe");
		D = new ChromeDriver();
		D.get("https://www.wikipedia.org/");

	}

	@Test
	public void countLinks() {
		WebElement English = D.findElement(By.id("js-link-box-en"));
		English.click();
		WebElement Community = D.findElement(By.cssSelector("a[title='Wikipedia:Community portal']"));
		Community.click();
		List<WebElement> links = D.findElements(By.tagName("a"));
		System.out.println(links.size());
		List<WebElement> links1 = D.findElements(By.linkText("dashboard"));
		System.out.println(links1.size());
	}

}
