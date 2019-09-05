package upgradetest;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class UpgradeUITest {

	WebDriver driver;
    OfferPage offerPage;
	
    private static Map<String,String> map;
    
	@BeforeSuite
	public void setup(){
	    System.setProperty("webdriver.chrome.driver", "/Users/nkolla/Downloads/chromedriver");
	    driver = new ChromeDriver();
// 	    System.setProperty("webdriver.gecko.driver", "/Users/nkolla/Downloads/geckodriver");
//  	driver = new FirefoxDriver();
		map =  new HashMap<String,String>();
  	}

 	
	@Test(priority=1)
	public void testCheckRate() throws InterruptedException{
		driver.get("https://www.credify.tech/phone/nonDMFunnel");
        
		WaitHelper.waitForPageLoad(driver);
        

		CheckRate chkRate = new CheckRate(driver);
		String amount = "20000";

		chkRate.setDesiredAmount(amount);
		chkRate.selectLoanPurpose("Debt Consolidation");
 		chkRate.clickCheckRate();
	
        WaitHelper.waitForPageLoad(driver);

 		
  		PersonalInfo personalInfoPage = new PersonalInfo(driver);
   		personalInfoPage.setFirstName("John");
 		personalInfoPage.setLastName("Smith");
 		personalInfoPage.setHomeAddress("4444 Tech Drive Suite 199");
 		personalInfoPage.setCity("Fremont");
 		personalInfoPage.setState("CA");
 		personalInfoPage.setZipCode("94538");
 		personalInfoPage.setDateOfBirth("06/22/1988");
 		personalInfoPage.setIndividualIncome("65000");
 		personalInfoPage.setAdditionalIncome("20000");
 		personalInfoPage.setEmailAddress("abc@xyz.com");
 		personalInfoPage.setPassword("Welcome1!");
 		personalInfoPage.checkTermsAndConditions();
 		personalInfoPage.submitPersonalInfo();
 		
        WaitHelper.waitForPageLoad(driver);
      
        offerPage = new OfferPage(driver);
 	   
 	    map.put("LoanAmount",offerPage.getLoanAmount());
 	    map.put("Apr",offerPage.getApr());
 	    map.put("Monthly Payment",offerPage.getMonthlyPayment());
 	    map.put("Loan Term",offerPage.getLoanTerm());
  
		offerPage.clickMenu();
 	    
	 	offerPage.signOutNow();
   	}
	
	
	
	@Test(priority=2)
	public void loginAndVerify() throws InterruptedException{
	       System.out.println("Second Map"+map);

		driver.get("https://www.credify.tech/portal/login");
        WaitHelper.waitForPageLoad(driver);

		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName("abc@xyz.com");
		loginPage.setPassword("Welcome1!");
        loginPage.login();
	    
        
        WaitHelper.waitForPageLoad(driver);
  	  
	    OfferPage offerPage = new OfferPage(driver);
 	 	System.out.println("Loan Amount"+offerPage.getLoanAmount());
 	    System.out.println("Apr"+offerPage.getApr());
  	    System.out.println("Monthly "+offerPage.getMonthlyPayment());
 	    System.out.println("Loan Term"+offerPage.getLoanTerm());
 
 	    Assert.assertEquals(map.get("LoanAmount"), offerPage.getLoanAmount());
 	    Assert.assertEquals(map.get("Apr"), offerPage.getApr());
 	    Assert.assertEquals(map.get("Monthly Payment"), offerPage.getMonthlyPayment());
 	    Assert.assertEquals(map.get("Loan Term"), offerPage.getLoanTerm());
 	    
 
		offerPage.clickMenu();
 
		offerPage.signOutNow();
   	}
	
	@AfterTest
	public void tearDown() throws InterruptedException{
 		driver.quit();
	}
	
}
