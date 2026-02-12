package GabsSync.GabsSync;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestGabs {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://dash.caricomautosales.gy/");
		driver.findElement(By.id("email")).sendKeys("caricom_as@yahoo.com");
		driver.findElement(By.id("login-password")).sendKeys("CariComAuto714");
		Thread.sleep(30000);
		driver.findElement(By.id("submitBtn")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a/span")))
				.click();
		WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Keyword")));
		searchBox.clear();
		searchBox.sendKeys("J26011569");
		driver.findElement(By.xpath("//*[@id=\"vehicleSearchForm\"]/div/div[5]/div/div[1]/button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"master-list\"]/div[2]/div[2]/div[2]/ul[1]/li[1]/span[2]/a/span/span")));
		
		String make = driver.findElement(By.xpath("//*[@id=\"master-list\"]/div[2]/div[2]/div[2]/div/div[1]/span/span[1]/a")).getText();
		System.out.println(make);
       String model = driver.findElement(By.xpath("//*[@id=\"master-list\"]/div[2]/div[2]/div[2]/div/div[1]/span/span[2]/a")).getText();
       System.out.println(model);
       String chassis = driver.findElement(By.xpath("//*[@id=\"master-list\"]/div[2]/div[2]/div[2]/ul[1]/li[4]/span[2]/span")).getText();
       System.out.println(chassis);
       String regMonth = driver.findElement(By.xpath("//*[@id=\"master-list\"]/div[2]/div[2]/div[2]/div/div[1]/span/span[3]/a")).getText();
       System.out.println(regMonth);
       String enginC = driver.findElement(By.xpath("//*[@id=\"master-list\"]/div[2]/div[2]/div[2]/ul[2]/li[2]/span[2]/span")).getText();
       System.out.println(enginC);
       String colur = driver.findElement(By.xpath("//*[@id=\"master-list\"]/div[2]/div[2]/div[2]/ul[3]/li[2]/span[2]/span/a")).getText();
       System.out.println(colur);
       String mileage = driver.findElement(By.xpath("//*[@id=\"master-list\"]/div[2]/div[2]/div[2]/ul[2]/li[1]/span[2]/span")).getText();
       System.out.println(mileage);
       String fuel = driver.findElement(By.xpath("//*[@id=\"master-list\"]/div[2]/div[2]/div[2]/ul[2]/li[4]/span[2]/span/a")).getText();
       System.out.println(fuel);
     
      
      
      
      
      
       String grade = driver.findElement(By.xpath("//*[@id=\"master-list\"]/div[2]/div[2]/div[2]/ul[1]/li[3]/span[2]/span/a")).getText();
       System.out.println(grade);
       String drive = driver.findElement(By.xpath("//*[@id=\"master-list\"]/div[2]/div[2]/div[2]/ul[3]/li[1]/span[2]/span/a")).getText(); // RHD / LHD
       System.out.println(drive);
      
       String wheelDrive = driver.findElement(By.xpath("//*[@id=\"master-list\"]/div[2]/div[2]/div[2]/ul[3]/li[4]/span[2]/span")).getText();
       System.out.println(wheelDrive);
      
 //      int doors = Integer.parseInt(driver.findElement(By.id("doors")).getText());
  //     System.out.println(doors);
       int seats = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"master-list\"]/div[2]/div[2]/div[2]/ul[4]/li[1]/span[2]/span")).getText());
       System.out.println(seats);
      double volumeM3 = Double.parseDouble(
               driver.findElement(By.id("volume")).getText().replace(" M3", "")
   );
      
	}  
   
		
		
	}





