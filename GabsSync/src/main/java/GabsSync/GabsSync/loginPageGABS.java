package GabsSync.GabsSync;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPageGABS {
	private WebDriver driver;

	public loginPageGABS(WebDriver driver) {
		this.driver = driver;
	}

	public void login(String username, String password) throws InterruptedException {
		driver.get("https://dash.caricomautosales.gy/");
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("login-password")).sendKeys(password);
		Thread.sleep(30000);
		driver.findElement(By.id("submitBtn")).click();
		Thread.sleep(3000);
	}

}
