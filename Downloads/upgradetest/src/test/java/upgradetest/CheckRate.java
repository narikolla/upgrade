package upgradetest;
import java.util.Arrays;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckRate {

 
	
	WebDriver driver;
	
	@FindBy(name="desiredAmount")
	WebElement desiredAmount;
	
 	@FindBy(xpath="//select[@data-auto='dropLoanPurpose']")
	WebElement purpose;
	
 	
	@FindBy(xpath="//main/div/div/div/div/div[2]/div[2]/form/div/div/div[3]/button[@data-auto='CheckYourRate']")
	WebElement checkRateButton;

	 
	public CheckRate(WebDriver driver){
		super();
		this.driver = driver;
 		PageFactory.initElements(driver, this);
	}
	
 	public void setDesiredAmount(String amount){
		desiredAmount.sendKeys(amount);
		
	}
	
	public void selectLoanPurpose(String purposeValue){
		Select oSelect = new Select(purpose);
 		oSelect.selectByVisibleText(purposeValue);
	}
	
	public void clickCheckRate(){
  
		checkRateButton.click();
	}
		 
}
