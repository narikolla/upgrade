package upgradetest;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
 		PageFactory.initElements(driver, this);
	}
	
	
 	@FindBy(xpath="//input[@name='username']")		
 	WebElement userName;
 
 	@FindBy(xpath="//input[@name='password']")		
 	WebElement password;
 	
  	@FindBy(xpath="//button[@data-auto='login']")		
 	WebElement login;
 	

 	public void setUserName(String user){
 		 userName.sendKeys(user);
 	}
 	
	public void setPassword(String pwd){
		password.sendKeys(pwd);
	}
	
	public void login(){
       login.click();
 	}
	
}
