package GabsSync.GabsSync;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class cri {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		try {

			LoginCC loginCC = new LoginCC(driver);
			loginCC.login("nathasha", "Carchief101");

			String[] stockNumbers = {
				    "J26020419",
				    "J26020667",
				    "J26020652",
				    "J26020842",
				    "J260208421"
				   
				};

			CCVehiclePage ccVehiclePage = new CCVehiclePage(driver);
			List<VehicleData> ccVehicles = ccVehiclePage.getVehicleByStock(stockNumbers);

			System.out.println("= CC Vehicles =");
			for (VehicleData v : ccVehicles) {
				System.out.println(v);
			}

			loginPageGABS loginGABS = new loginPageGABS(driver);
			loginGABS.login("caricom_as@yahoo.com", "CariComAuto714");

			GABSVehiclePage gabsPage = new GABSVehiclePage(driver);

			for (VehicleData ccVehicle : ccVehicles) {
				VehicleData gabsVehicle = null;
				try {
			        gabsVehicle = gabsPage.getVehicleByStock(ccVehicle.getStock());
			    } catch (Exception e) {
			        System.out.println("⚠️ Stock not found in GABS: " + ccVehicle.getStock());
			        continue; // skip comparison and move to next stock
			    }

			    // Only compare if stock was found
			    if (gabsVehicle != null) {
			        VehicleComparator.compare(ccVehicle, gabsVehicle);
			    }
			

//				System.out.println("\n= GABS Vehicle =");
//				System.out.println(gabsVehicle);
//
//				VehicleComparator.compare(ccVehicle, gabsVehicle);

				WebElement imageIcon = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//div[@id='master-list']/div[2]/div[2]/div[3]/div/div/a[4]/i")));
				((org.openqa.selenium.JavascriptExecutor) driver)
						.executeScript("arguments[0].scrollIntoView({block:'center'});", imageIcon);
				Thread.sleep(500);
				((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", imageIcon);

				wait.until(ExpectedConditions.urlContains("/image"));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("draggable-cards")));

				List<WebElement> gabsImages = driver
						.findElements(By.cssSelector("#draggable-cards img.doc_name_img_vehi"));
				System.out.println("Total GABS images: " + gabsImages.size());
				
				// Check for broken images
				int brokenCount = 0;
				for (WebElement img : gabsImages) {
				    Boolean imageLoaded = (Boolean) ((org.openqa.selenium.JavascriptExecutor) driver)
				            .executeScript(
				                    "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				                    img);
				    if (!imageLoaded) {
				        brokenCount++;
				        System.out.println("🚨 Broken image detected: " + img.getAttribute("src"));
				    }
				}
				if (brokenCount == 0) {
				    System.out.println("🌟 No broken images found.");
				} else {
				    System.out.println("🚨Total broken images: " + brokenCount);
				}


				// Compare count
				if (gabsImages.size() == ccVehicle.getCrfImages().size()) {
					System.out.println("✔️ CRF image count matches GABS image count");
				} else {
					System.out.println("⚠️ Image count mismatch! CC: " + ccVehicle.getCrfImages().size() + ", GABS: "
							+ gabsImages.size());
				}
			}

		} finally {

			Thread.sleep(1000);
			driver.quit();
		}

	}
}