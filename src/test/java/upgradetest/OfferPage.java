package upgradetest;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OfferPage {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */
	
	WebDriver driver;
	
	public OfferPage(WebDriver driver){
		this.driver = driver;
 		PageFactory.initElements(driver, this);
	}
	
	
 	@FindBy(xpath="//span[@data-auto='userLoanAmount']")		
 	WebElement loanAmount;
 
 	@FindBy(xpath="//div[@data-auto='HeroOfferBox0']/div/div/div/div[@data-auto='defaultLoanTerm']")		
 	WebElement loanTerm;
 	
  	@FindBy(xpath="//div[@data-auto='HeroOfferBox0']/div/div/div/span[@data-auto='defaultMonthlyPayment']")		
   	WebElement monthlyPayment;
  	
  	@FindBy(xpath="//div[@data-auto='HeroOfferBox0']/div/div/div/div/div[@data-auto='defaultMoreInfoAPR']/div")		
 	WebElement apr;
  	
    @FindBy(xpath="//label[@class='header-nav__toggle']")
  	WebElement menu;
  	
 	@FindBy(xpath="//a[text()='Sign Out']")
	WebElement signOut;
	
 
 	public String getLoanAmount(){
 		return loanAmount.getText();
 	}
 	
	public String getLoanTerm(){
		return loanTerm.getText();	
	}
	
	public String getApr(){
		return apr.getText();
	}
	
	public String getMonthlyPayment(){		
		return monthlyPayment.getText();
	}
	
	public void clickMenu(){
 		menu.click();
	}
	public void signOutNow(){
 
		//signOut.click();
   
	}
	
		 
}
