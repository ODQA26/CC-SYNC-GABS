package GabsSync.GabsSync;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class test {

    public static void main(String[] args) throws InterruptedException {
        // ✅ Initialize WebDriver and WebDriverWait
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            // Maximize window
            driver.manage().window().maximize();

            // =========================
            // 1️⃣ Login to CC
            // =========================
            driver.get("https://www.carchief.com/cp/");

            // Enter username and password
            driver.findElement(By.xpath("/html/body/div[2]/form/div[1]/input")).sendKeys("nathasha");
            driver.findElement(By.xpath("/html/body/div[2]/form/div[2]/input")).sendKeys("Carchief101");

            // Click login
            driver.findElement(By.xpath("/html/body/div[2]/form/div[4]/input[2]")).click();

            // Wait for dashboard to load
        

            // =========================
            // 2️⃣ Click on Vehicle Menu
            // =========================
           wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id=\"1\"]/span"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@id=\"bodyIds\"]/div[1]/div/div/div[3]/nav[2]/a[1]/span")))
                    .click();

            WebElement searchBox = wait
    				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"stock_number\"]")));
    		searchBox.clear();
    		searchBox.sendKeys("J26011365");
    		driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div[1]/div[5]/input[1]")).click();
    		// 4️⃣ Wait for results table and get stock number
    		WebElement stockElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
    				"//*[@id=\"bodyIds\"]/div[1]/div/table[2]/tbody/tr/td/form/div[3]/table[2]/tbody/tr/td/table/tbody/tr/td[2]/table[2]/tbody/tr[1]/td/table/tbody/tr[1]/td[1]/table/tbody/tr/td[3]/a")));
    		System.out.println("Stock Number: " + stockElement.getText());

            

            System.out.println("✅ Vehicle search completed successfully.");

        } finally {
            // Optional: close driver
            // driver.quit();
        }
    }
}
