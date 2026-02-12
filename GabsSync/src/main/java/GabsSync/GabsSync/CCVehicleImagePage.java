package GabsSync.GabsSync;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CCVehicleImagePage {
	
	  private WebDriver driver;

	    public CCVehicleImagePage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public List<String> getCRFTickedImages() {

	        List<String> images = new ArrayList<>();

	        List<WebElement> imageBlocks =
	                driver.findElements(By.xpath("//li[contains(@class,'cpveh_img')]"));

	        for (WebElement block : imageBlocks) {

	            WebElement img = block.findElement(
	                    By.xpath(".//img[starts-with(@id,'ima')]"));

	            String src = img.getAttribute("src");

	            // Skip empty slots
	            if (src == null || src.contains("noimage")) {
	                continue;
	            }

	            boolean isCRFChecked = !block.findElements(By.xpath(
	                    ".//input[starts-with(@id,'ImageCheck') and @checked]")).isEmpty();

	            if (isCRFChecked) {
	                images.add(src);
	            }
	        }

	        return images;
	    }

}
