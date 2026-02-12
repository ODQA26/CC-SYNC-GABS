package GabsSync.GabsSync;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GABSVehiclePage {

	private WebDriver driver;
	private WebDriverWait wait;

	public GABSVehiclePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	public VehicleData getVehicleByStock(String stock) {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='main-menu-navigation']/li[2]/a/span")))
				.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Keyword"))).sendKeys(stock);
		driver.findElement(By.xpath("//*[@id='vehicleSearchForm']//button")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("master-list")));

		String make = driver
				.findElement(By.xpath("//*[@id='master-list']/div[2]/div[2]/div[2]/div/div[1]/span/span[1]/a"))
				.getText();
		String model = driver
				.findElement(By.xpath("//*[@id='master-list']/div[2]/div[2]/div[2]/div/div[1]/span/span[2]/a"))
				.getText();
		String grade = driver
				.findElement(By.xpath("//*[@id='master-list']/div[2]/div[2]/div[2]/ul[1]/li[3]/span[2]/span/a"))
				.getText();
		String drive = driver
				.findElement(By.xpath("//*[@id='master-list']/div[2]/div[2]/div[2]/ul[3]/li[1]/span[2]/span/a"))
				.getText();
		String wheelDrive = driver
				.findElement(By.xpath("//*[@id='master-list']/div[2]/div[2]/div[2]/ul[3]/li[4]/span[2]/span"))
				.getText();
		String fuel = driver
				.findElement(By.xpath("//*[@id='master-list']/div[2]/div[2]/div[2]/ul[2]/li[4]/span[2]/span/a"))
				.getText();
		String color = driver
				.findElement(By.xpath("//*[@id='master-list']/div[2]/div[2]/div[2]/ul[3]/li[2]/span[2]/span/a"))
				.getText();
		String mileage = driver
				.findElement(By.xpath("//*[@id=\"master-list\"]/div[2]/div[2]/div[2]/ul[2]/li[1]/span[2]/span"))
				.getText();
		String chassis = driver
				.findElement(By.xpath("//*[@id='master-list']/div[2]/div[2]/div[2]/ul[1]/li[4]/span[2]/span"))
				.getText();
		String regMonth = driver
				.findElement(By.xpath("//*[@id=\"master-list\"]/div[2]/div[2]/div[2]/div/div[1]/span/span[3]/a"))
				.getText();

		String lastYear = driver
				.findElement(By.xpath("//*[@id=\"master-list\"]/div[2]/div[2]/div[2]/ul[2]/li[3]/span[2]/span"))
				.getText();

		String enginC = driver
				.findElement(By.xpath("//*[@id=\"master-list\"]/div[2]/div[2]/div[2]/ul[2]/li[2]/span[2]/span"))
				.getText();
		String transmission = driver
				.findElement(By.xpath("//*[@id=\"master-list\"]/div[2]/div[2]/div[2]/ul[3]/li[3]/span[2]/span/a"))
				.getText();
		int seats = Integer.parseInt(driver
				.findElement(By.xpath("//*[@id='master-list']/div[2]/div[2]/div[2]/ul[4]/li[1]/span[2]")).getText());
		double volumeM3 = Double.parseDouble(driver
				.findElement(By.xpath("//*[@id='master-list']/div[2]/div[2]/div[2]/ul[4]/li[4]/span[2]")).getText());

		List<String> crfImages = new ArrayList<>();

		return new VehicleData(stock, make, model, chassis, regMonth, lastYear, enginC, color, mileage, fuel,
				transmission, grade, drive, wheelDrive, 0, seats, 0, 0, 0, volumeM3, crfImages);

	}
}