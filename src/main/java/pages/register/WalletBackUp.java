package pages.register;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;

import android.elements.Constants;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.ExtentTestManager;

public class WalletBackUp extends BaseTest implements Constants{
	 
	@Test(priority = 1)
	 public void backUpConsent() throws InterruptedException{ 
		 ExtentTestManager.createTest("Wallet Back Up", "Testing the secret phrase behavior");
	     
		 String consentText= "Back up your wallet now!"; 
		 AndroidElement element = waitForElementToBePresent(backupText,10);
		 System.out.println(element.getAttribute("text"));
		 assertTrue(element.getAttribute("text").equals(consentText), "Passcode is set correctly");
		 
		 AndroidElement element1 = waitForElementToBePresent(backUpConsent1, 10);
	     clickElement(element1, "on first consent");
	     
	     AndroidElement element2 = waitForElementToBePresent(backUpConsent2, 10);
	     clickElement(element2, "on second consent");
	     
	     AndroidElement element3 = waitForElementToBePresent(backUpConsent3, 10);
	     clickElement(element3, "on third consent");
	     
	     AndroidElement element4 = waitForElementToBePresent(backUpContinue, 10);
	     clickElement(element4, "on Continue");
	     
		 Thread.sleep(500);
	 }
	
	@Test(priority = 2)
	 public void saveBackUpPhrase() throws InterruptedException{ 
	     
		 AndroidElement element1 = waitForElementToBePresent(backUpWordElement1,10);  //getting each word by xpath and saving it in an element
		 AndroidElement element2 = waitForElementToBePresent(backUpWordElement2,10);
		 AndroidElement element3 = waitForElementToBePresent(backUpWordElement3,10);
		 AndroidElement element4 = waitForElementToBePresent(backUpWordElement4,10);
		 AndroidElement element5 = waitForElementToBePresent(backUpWordElement5,10);
		 AndroidElement element6 = waitForElementToBePresent(backUpWordElement6,10);
		 AndroidElement element7 = waitForElementToBePresent(backUpWordElement7,10);
		 AndroidElement element8 = waitForElementToBePresent(backUpWordElement8,10);
		 AndroidElement element9 = waitForElementToBePresent(backUpWordElement9,10);
		 AndroidElement element10 = waitForElementToBePresent(backUpWordElement10,10);
		 AndroidElement element11 = waitForElementToBePresent(backUpWordElement11,10);
		 AndroidElement element12 = waitForElementToBePresent(backUpWordElement12,10);

		 String backUpWord1 = element1.getAttribute("text");   //returns the value of the android element's attribute as a string
		 String backUpWord2 = element2.getAttribute("text");
		 String backUpWord3 = element3.getAttribute("text");
		 String backUpWord4 = element4.getAttribute("text");
		 String backUpWord5 = element5.getAttribute("text");
		 String backUpWord6 = element6.getAttribute("text");
		 String backUpWord7 = element7.getAttribute("text");
		 String backUpWord8 = element8.getAttribute("text");
		 String backUpWord9 = element9.getAttribute("text");
		 String backUpWord10 = element10.getAttribute("text");
		 String backUpWord11 = element11.getAttribute("text");
		 String backUpWord12 = element12.getAttribute("text");
		 		
		 AndroidElement element = waitForElementToBePresent(secretPhraseContinue, 10);
	     clickElement(element, "on Continue");
		 Thread.sleep(1000);

		 String className = "android.widget.TextView";
		 
		 By verifyBackUpWordElement1 = By.xpath("//*[@class='"+className+"' and @text='"+ backUpWord1 +"']");  //looking for an element with a static class name and the string text saved previously
		 AndroidElement element13 = waitForElementToBePresent(verifyBackUpWordElement1, 10);
	     clickElement(element13, "1st word");
		 
		 By verifyBackUpWordElement2 = By.xpath("//*[@class='"+className+"' and @text='"+ backUpWord2 +"']");
		 AndroidElement element14 = waitForElementToBePresent(verifyBackUpWordElement2, 10);
	     clickElement(element14, "2nd word");		 
		
	     By verifyBackUpWordElement3 = By.xpath("//*[@class='"+className+"' and @text='"+ backUpWord3 +"']");
		 AndroidElement element15 = waitForElementToBePresent(verifyBackUpWordElement3, 10);
	     clickElement(element15, "3rd word");
	     
	     By verifyBackUpWordElement4 = By.xpath("//*[@class='"+className+"' and @text='"+ backUpWord4 +"']");
		 AndroidElement element16 = waitForElementToBePresent(verifyBackUpWordElement4, 10);
	     clickElement(element16, "4th word");
	     
	     By verifyBackUpWordElement5 = By.xpath("//*[@class='"+className+"' and @text='"+ backUpWord5 +"']");
		 AndroidElement element17 = waitForElementToBePresent(verifyBackUpWordElement5, 10);
	     clickElement(element17, "5th word");
	     
	     By verifyBackUpWordElement6 = By.xpath("//*[@class='"+className+"' and @text='"+ backUpWord6 +"']");
		 AndroidElement element18 = waitForElementToBePresent(verifyBackUpWordElement6, 10);
	     clickElement(element18, "6th word");
	     
	     By verifyBackUpWordElement7 = By.xpath("//*[@class='"+className+"' and @text='"+ backUpWord7 +"']");
		 AndroidElement element19 = waitForElementToBePresent(verifyBackUpWordElement7, 10);
	     clickElement(element19, "7th word");
	     
	     By verifyBackUpWordElement8 = By.xpath("//*[@class='"+className+"' and @text='"+ backUpWord8 +"']");
		 AndroidElement element20 = waitForElementToBePresent(verifyBackUpWordElement8, 10);
	     clickElement(element20, "8th word");
	     
	     By verifyBackUpWordElement9 = By.xpath("//*[@class='"+className+"' and @text='"+ backUpWord9 +"']");
		 AndroidElement element21 = waitForElementToBePresent(verifyBackUpWordElement9, 10);
	     clickElement(element21, "9th word");
	     
	     By verifyBackUpWordElement10 = By.xpath("//*[@class='"+className+"' and @text='"+ backUpWord10 +"']");
		 AndroidElement element22 = waitForElementToBePresent(verifyBackUpWordElement10, 10);
	     clickElement(element22, "10th word");
	     
	     By verifyBackUpWordElement11 = By.xpath("//*[@class='"+className+"' and @text='"+ backUpWord11 +"']");
		 AndroidElement element23 = waitForElementToBePresent(verifyBackUpWordElement11, 10);
	     clickElement(element23, "11th word");
	     
	     By verifyBackUpWordElement12 = By.xpath("//*[@class='"+className+"' and @text='"+ backUpWord12 +"']");
		 AndroidElement element24 = waitForElementToBePresent(verifyBackUpWordElement12, 10);
	     clickElement(element24, "12th word");
	     
	     Thread.sleep(2000);
	     String passStatus= "Well done! ";
	     
		 AndroidElement element25 = waitForElementToBePresent(verifyPhraseStatus,10);
		 assertTrue(element25.getAttribute("text").equals(passStatus), "Secret phrase is valid");
		   
	     AndroidElement element26 = waitForElementToBePresent(verifySecretPhraseDone, 10);
	     clickElement(element26, "on Done");
	     
   }
	}