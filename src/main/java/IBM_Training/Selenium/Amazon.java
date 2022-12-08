package IBM_Training.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Amazon {
	WebDriver D;

	@BeforeClass
	public void start() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\IBMADMIN\\Documents\\Driver\\chromedriver.exe");
		D = new ChromeDriver();
		D.get("https://www.amazon.in/ref=as_li_ss_tl?ie=UTF8&linkCode=ll2&tag=enin-edge-topsites-curate-ana-21&linkId=fbedcb44d04a4bae8eae32722a2f41c2&language=en_IN");
		// Thread.sleep(2000);
	}

	@Test(priority = 1)
	public void login() {
		WebElement login = D.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));
		login.click();
		WebElement email = D.findElement(By.xpath("//*[@id=\"ap_email\"]"));
		email.sendKeys("sagarthbs@gmail.com");
		WebElement Continue = D.findElement(By.id("continue"));
		Continue.click();
		WebElement password = D.findElement(By.id("ap_password"));
		password.sendKeys("Gaongeri$300");
		WebElement SignInsubmit = D.findElement(By.id("signInSubmit"));
		SignInsubmit.click();
		WebElement homePage = D.findElement(By.id("nav-logo-sprites"));
		String text = D.getTitle();
		String logoText = homePage.getText();
		System.out.println(text);
		System.out.println(logoText);
		boolean textVer = text.contains("Online Shopping site in India");
		boolean logoTextVer = logoText.contains(".in");
		Assert.assertEquals(textVer, true, "Title not displayed");
		Assert.assertEquals(logoTextVer, true, "Logo text not displayed");

	}

	@Test(priority = 2)
	public void dropDown() {
		WebElement accountList = D.findElement(By.cssSelector("a[data-nav-role='signin']"));
		Actions action = new Actions(D);
		action.moveToElement(accountList).perform();
		WebElement orders = D.findElement(By.linkText("Your Orders"));
		orders.click();
	}
}
