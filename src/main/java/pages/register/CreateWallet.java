package pages.register;

import static org.testng.Assert.assertTrue;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;
import android.elements.Constants;
import io.appium.java_client.android.AndroidElement;
import utils.ExtentTestManager;

public class CreateWallet extends BaseTest implements Constants{
	 
	@Test(priority = 1)
	 public void registerNewUser() throws InterruptedException{ 
		 ExtentTestManager.createTest("Register", "Testing the passcode & consents behavior");
		 Thread.sleep(1000);

		 AndroidElement element = waitForElementToBePresent(createWalletButton, 10);
	     clickElement(element, "Create New Wallet Button");
		 Thread.sleep(2000);
		 
         String disclaimerText= "Please review the Trust Wallet Terms of Service and Privacy Policy."; 
		 AndroidElement element2 = waitForElementToBePresent(disclaimer,10);
		 assertTrue(element2.getAttribute("text").equals(disclaimerText), "Create New Wallet is working well");
	 }
	
	@Test(priority = 2)
	 public void legalConsent() throws InterruptedException{ 
	     AndroidElement element1 = waitForElementToBePresent(consentCheckBox, 10);
	     clickElement(element1, "Consent Checkbox Check");
		 Thread.sleep(500);
		 
		 AndroidElement element2 = waitForElementToBePresent(continueBtnLegal, 10);
	     clickElement(element2, "on Continue button");
		 Thread.sleep(2000);
	 }
	
	@Test(priority = 3)
	 public void createPasscode() throws InterruptedException{ 
	     AndroidElement element = waitForElementToBePresent(passcodeZero, 10);
	     for (int i = 0; i < 6; i++) {	     
	     clickElement(element, "on 0 for the passcode");		 
	     }
	     Thread.sleep(1000);
	 }
	
	@Test(priority = 4)
	 public void setWrongPasscode() throws InterruptedException{ 
	     AndroidElement element = waitForElementToBePresent(passcodeOne, 10);
	     for (int i = 0; i < 6; i++) {	     
		 clickElement(element, "on 1 to have unmatched passcodes");	
	     }
	     
	     Thread.sleep(2000);  
	     AndroidElement element2 = waitForElementToBePresent(passcodeStatus,10);
		 String passCodeStatus= "Those passwords didn’t match!";
		 
		 assertTrue(element2.getAttribute("text").equals(passCodeStatus), "Passcode do not match");      
	 }
	
	@Test(priority = 5)
	 public void confirmPasscode() throws InterruptedException{ 
		 this.createPasscode();
	     AndroidElement element = waitForElementToBePresent(passcodeZero, 10);
	     for (int i = 0; i < 6; i++) {	     
		 clickElement(element, "0 to confirm the passcode");		 
	     Thread.sleep(500);   
	     }  
	 }
	
}