package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class PrallelTest {
	WebDriver driver = null;
	
	@Test(groups="Chrome")
	public void launchChrome() {
		System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(groups="Chrome", dependsOnMethods="launchChrome")
	public void facebook1() {
		System.out.println(Thread.currentThread().getId());
		driver.findElement(By.id("email")).sendKeys("lasantha.perera@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("lasper2000");
		driver.findElement(By.name("login")).click();
	}
	
	@Test(groups="Firefox")
	public void launchFirefox() {
		System.setProperty("Webdriver.chrome.driver", "gekodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.facebook.com");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test(groups="Firefox", dependsOnMethods="launchFirefox")
	public void facebook2() {
		driver.findElement(By.id("email")).sendKeys("Samantha.perera@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Samper2001");
		driver.findElement(By.name("login")).click();
		System.out.println(Thread.currentThread().getId());
	}

}
