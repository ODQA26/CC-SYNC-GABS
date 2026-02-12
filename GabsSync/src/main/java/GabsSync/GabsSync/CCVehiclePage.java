package GabsSync.GabsSync;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CCVehiclePage {
	private WebDriver driver;
	private WebDriverWait wait;

	public CCVehiclePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	public List<VehicleData> getVehicleByStock(String[] stocks) {
		List<VehicleData> vehicles = new ArrayList<>();

		for (String stock : stocks) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"1\"]/span"))).click();
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id=\"bodyIds\"]/div[1]/div/div/div[3]/nav[2]/a[1]/span")))
					.click();

			WebElement searchBox = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"stock_number\"]")));
			searchBox.clear();
			searchBox.sendKeys(stocks);
			driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div[1]/div[5]/input[1]")).click();

			WebElement stockElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//*[@id=\"bodyIds\"]/div[1]/div/table[2]/tbody/tr/td/form/div[3]/table[2]/tbody/tr/td/table/tbody/tr/td[2]/table[2]/tbody/tr[1]/td/table/tbody/tr[1]/td[1]/table/tbody/tr/td[3]/a")));
			System.out.println("Stock Number: " + stockElement.getText());

			String modelCode = driver.findElement(By.xpath(
					"//*[@id=\"bodyIds\"]/div[1]/div/table[2]/tbody/tr/td/form/div[3]/table[2]/tbody/tr/td/table/tbody/tr/td[2]/table[2]/tbody/tr[1]/td/table/tbody/tr[6]/td[2]/table/tbody/tr/td[3]"))
					.getText();
			System.out.println(modelCode);
			String chassis = driver.findElement(By.xpath(
					"//*[@id=\"bodyIds\"]/div[1]/div/table[2]/tbody/tr/td/form/div[3]/table[2]/tbody/tr/td/table/tbody/tr/td[2]/table[2]/tbody/tr[1]/td/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]"))
					.getText();
			System.out.println(chassis);
			String regMonthFull = driver.findElement(By.xpath(
					"//*[@id=\"bodyIds\"]/div[1]/div/table[2]/tbody/tr/td/form/div[3]/table[2]/tbody/tr/td/table/tbody/tr/td[2]/table[2]/tbody/tr[1]/td/table/tbody/tr[3]/td[1]/table/tbody/tr/td[3]"))
					.getText();
			String regMonth = regMonthFull.length() >= 4 ? regMonthFull.substring(0, 4) : regMonthFull;
			String lastYear = regMonthFull.substring(regMonthFull.length() - 4);

			System.out.println(regMonth);
			System.out.println(lastYear);

			String enginC = driver.findElement(By.xpath(
					"//*[@id=\"bodyIds\"]/div[1]/div/table[2]/tbody/tr/td/form/div[3]/table[2]/tbody/tr/td/table/tbody/tr/td[2]/table[2]/tbody/tr[1]/td/table/tbody/tr[2]/td[2]/table/tbody/tr/td[3]"))
					.getText();
			System.out.println(enginC);
			String mileage = driver.findElement(By.xpath(
					"//*[@id=\"bodyIds\"]/div[1]/div/table[2]/tbody/tr/td/form/div[3]/table[2]/tbody/tr/td/table/tbody/tr/td[2]/table[2]/tbody/tr[1]/td/table/tbody/tr[5]/td[1]/table/tbody/tr/td[3]"))
					.getText();
			System.out.println(mileage);
			String transmission = driver.findElement(By.xpath(
					"//*[@id=\"bodyIds\"]/div[1]/div/table[2]/tbody/tr/td/form/div[3]/table[2]/tbody/tr/td/table/tbody/tr/td[2]/table[2]/tbody/tr[1]/td/table/tbody/tr[3]/td[2]/table/tbody/tr/td[3]"))
					.getText();
			System.out.println(transmission);
			String colur = driver.findElement(By.xpath(
					"//*[@id=\"bodyIds\"]/div[1]/div/table[2]/tbody/tr/td/form/div[3]/table[2]/tbody/tr/td/table/tbody/tr/td[2]/table[2]/tbody/tr[1]/td/table/tbody/tr[4]/td[1]/table/tbody/tr/td[3]"))
					.getText();
			System.out.println(colur);
			String fuel = driver.findElement(By.xpath(
					"//*[@id=\"bodyIds\"]/div[1]/div/table[2]/tbody/tr/td/form/div[3]/table[2]/tbody/tr/td/table/tbody/tr/td[2]/table[2]/tbody/tr[1]/td/table/tbody/tr[4]/td[2]/table/tbody/tr/td[3]"))
					.getText();
			System.out.println(fuel);

			WebElement editLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//*[@id=\"bodyIds\"]/div[1]/div/table[2]/tbody/tr/td/form/div[3]/table[2]/tbody/tr/td/table/tbody/tr/td[2]/table[2]/tbody/tr[2]/td/p[1]/a[1]")));
			editLink.click();

			List<String> tabs = driver.getWindowHandles().stream().toList();
			driver.switchTo().window(tabs.get(tabs.size() - 1));
			WebElement makeDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("make_id")));
			Select makeSelect = new Select(makeDropdown);
			String makeText = makeSelect.getFirstSelectedOption().getText();
			System.out.println("Make: " + makeText);
			WebElement modelDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("maker_id")));
			Select modelSelect = new Select(modelDropdown);
			String modelText = modelSelect.getFirstSelectedOption().getText();
			System.out.println("Model: " + modelText);
			String grade = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("model_std")))
					.getAttribute("value");
			System.out.println("Grade: " + grade);
			List<WebElement> drives = driver.findElements(By.name("drive"));
			String driveCode = "";
			for (WebElement drive : drives) {
				if (drive.isSelected()) {
					String driveValue = drive.getAttribute("value");
					if (driveValue.equalsIgnoreCase("Right Hand")) {
						driveCode = "RHD";
					} else if (driveValue.equalsIgnoreCase("Left Hand")) {
						driveCode = "LHD";
					}
					break;
				}
			}
			System.out.println("Steering: " + driveCode);
			WebElement wheelDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//*[@id=\"bodyIds\"]/div[1]/div/table[2]/tbody/tr/td/form/div[1]/div[6]/div[3]/div[10]/div[2]/select")));

			Select wheelSelect = new Select(wheelDropdown);
			String wheelDrive = wheelSelect.getFirstSelectedOption().getText();

			System.out.println("Wheel Drive: " + wheelDrive);
			int doors = Integer.parseInt(
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("doors"))).getAttribute("value"));
			System.out.println("doors: " + doors);
			int seats = Integer
					.parseInt(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("seat_capacity")))
							.getAttribute("value"));
			System.out.println("seats: " + seats);
			int length = Integer.parseInt(driver.findElement(By.id("length")).getAttribute("value"));
			int width = Integer.parseInt(driver.findElement(By.id("width")).getAttribute("value"));
			int height = Integer.parseInt(driver.findElement(By.id("height")).getAttribute("value"));
			System.out.println("L=" + length + ", W=" + width + ", H=" + height);
			double volumeM3 = (length * width * height) / 1_000_000.0;
			volumeM3 = Math.round(volumeM3 * 100.0) / 100.0;
			System.out.println("Volume: " + volumeM3 + " M3");

			// Extract CRF Images
			CCVehicleImagePage imagePage = new CCVehicleImagePage(driver);
			List<String> crfImages = imagePage.getCRFTickedImages();
			System.out.println("Total CC CRF images: " + crfImages.size());

			vehicles.add(new VehicleData(stock, makeText, modelText, chassis, regMonth, lastYear, enginC, colur,
					mileage, fuel, transmission, grade, driveCode, wheelDrive, 4, seats, length, width, height,
					volumeM3, crfImages));

		}

		return vehicles;
	}
}
