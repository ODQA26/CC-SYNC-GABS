package GabsSync.GabsSync;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginCC {

	// WebDriver driver = new ChromeDriver();
	private WebDriver driver; // only declare, do NOT create here

	public LoginCC(WebDriver driver) {
		this.driver = driver;
	}

	public void login(String username, String password) throws InterruptedException {
		driver.get("https://www.carchief.com/cp/");
		driver.findElement(By.xpath("/html/body/div[2]/form/div[1]/input")).sendKeys(username);
		driver.findElement(By.xpath("/html/body/div[2]/form/div[2]/input")).sendKeys(password);
		driver.findElement(By.xpath("/html/body/div[2]/form/div[4]/input[2]")).click();
		Thread.sleep(3000);

	}
}