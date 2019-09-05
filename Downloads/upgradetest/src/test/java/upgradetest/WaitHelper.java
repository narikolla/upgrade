package upgradetest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

	public static void waitForPageLoad(WebDriver driver) {
 
		ExpectedCondition<Boolean> expectation = new
	            ExpectedCondition<Boolean>() {
	                public Boolean apply(WebDriver driver) {
	                    return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
	                }
	            };
	    try {
	        Thread.sleep(4000);
	        WebDriverWait wait = new WebDriverWait(driver, 80);
	        wait.until(expectation);
	    } catch (Exception ex) {ex.printStackTrace();}
	    }
	

}