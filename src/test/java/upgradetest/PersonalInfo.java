package upgradetest;

import java.util.Arrays;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalInfo {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */
	WebDriver driver;
	
	@FindBy(xpath="//main/div/div[1]/div[2]/div[1]/div/div/form/div[1]/div[1]/div[1]/div/div/div/div/input[@name='borrowerFirstName']")
 	WebElement firstName;
 
	@FindBy(xpath="//main/div/div[1]/div[2]/div[1]/div/div/form/div[1]/div[1]/div[2]/div/div/div/div/input[@name='borrowerLastName']")
	WebElement lastName;
	
	@FindBy(xpath="//main/div/div[1]/div[2]/div[1]/div/div/form/div[1]/div[2]/div/div/div/div/div/div/div[1]/input[@name='borrowerStreet']")
	WebElement homeAddress;
	
	@FindBy(xpath="//main/div/div[1]/div[2]/div[1]/div/div/form/div[1]/div[3]/div[1]/div/div/div/div/input[@name='borrowerCity']")
	WebElement city;
	
 	@FindBy(xpath="//main/div/div[1]/div[2]/div[1]/div/div/form/div[1]/div[3]/div[2]/div/div/div/div/input[@name='borrowerState']")
	WebElement state;
 	
	@FindBy(xpath="//main/div/div[1]/div[2]/div[1]/div/div/form/div[1]/div[3]/div[3]/div/div/div/div/input[@name='borrowerZipCode']")
	WebElement zipCode;
	
	@FindBy(xpath="//main/div/div[1]/div[2]/div[1]/div/div/form/div[1]/div[4]/div/div/div/input[@name='borrowerDateOfBirth']")
	WebElement dateOfBirth;
	
	@FindBy(xpath="//main/div/div[1]/div[2]/div[1]/div/div/form/div[1]/div[5]/div/div/div/input[@name='borrowerIncome']")
	WebElement annualIncome;
	
	@FindBy(xpath="//main/div/div[1]/div[2]/div[1]/div/div/form/div[1]/div[6]/div/div/div/input[@name='borrowerAdditionalIncome']")
	WebElement additionalIncome;
 	
	@FindBy(xpath="//main/div/div[1]/div[2]/div[1]/div/div/form/div[2]/div[1]/div/div/div/input[@name='username']")
	WebElement userName;
 	
	@FindBy(xpath="//main/div/div[1]/div[2]/div[1]/div/div/form/div[2]/div[2]/div/div/div/input[@name='password']")
	WebElement password;

	@FindBy(xpath="//main/div/div[1]/div[2]/div[1]/div/div/form/div[3]/div/label/input[@name='agreements']")
	WebElement agreeCheckBox;

	@FindBy(xpath="//main/div/div[1]/div[2]/div[1]/div/div/form/div[4]/button[@data-auto='submitPersonalInfo']")
	WebElement submitPersonalInfo;
 
	
 
	public PersonalInfo(WebDriver driver){
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	
	public void setFirstName(String firstNameValue) {
		firstName.sendKeys(firstNameValue);
	}

	public void setLastName(String lastNameValue) {
		lastName.sendKeys(lastNameValue);
	}

	public void setHomeAddress(String homeAddressValue) {
		homeAddress.sendKeys(homeAddressValue);  
 	}

	public void setCity(String cityValue) {
 		city.sendKeys(cityValue);
	}

	public void setState(String stateValue) {
		state.sendKeys(stateValue);
	}

	public void setZipCode(String zipCodeValue) {
		zipCode.sendKeys(zipCodeValue);
	}

	public void setDateOfBirth(String dateOfBirthValue) {
		dateOfBirth.sendKeys(dateOfBirthValue);
		
	}

	public void setIndividualIncome(String individualIncomeValue) {
		annualIncome.sendKeys(individualIncomeValue);
	}

	public void setAdditionalIncome(String additionalIncomeValue) {
 		additionalIncome.sendKeys(additionalIncomeValue);
	}

	public void setEmailAddress(String emailAddressValue) {
		userName.sendKeys(emailAddressValue);
	}

	public void setPassword(String passwordValue) {
		password.sendKeys(passwordValue);
	}

    public void checkTermsAndConditions(){
     	JavascriptExecutor js = (JavascriptExecutor) driver;
     	js.executeScript("arguments[0].click();", agreeCheckBox);
 
    }

    public void submitPersonalInfo(){
//    	WebDriverWait wait = new WebDriverWait(driver, 20);
// 		wait.until(ExpectedConditions.visibilityOfAllElements(Arrays.asList(submitPersonalInfo)));
// 		wait.until(ExpectedConditions.elementToBeClickable(submitPersonalInfo));
// 		new Actions(driver).click(submitPersonalInfo).perform();
 		submitPersonalInfo.click();
 	}
    
 
}
