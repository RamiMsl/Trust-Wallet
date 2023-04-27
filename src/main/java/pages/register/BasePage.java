package pages.register;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import utils.AppiumSetup;
import utils.ExtentTestManager;

public class BasePage {
    public AndroidDriver<MobileElement> getAndroidDriver() {
        return AppiumSetup.getInstance().getDriver();
    
    }
   
    public void Hidekeyboard() {
    	AppiumSetup.HideKeyboard();
    }
    
    
    /**
     * Wait for element to be present and return it based on the provided locator
     *
     * @param locator
     * @param timeOutInSeconds
     * @return AndroidElement
     */
    public AndroidElement waitForElementToBePresent(By locator, int timeOutInSeconds) {
        //ExtentTestManager.getTest().info("Waiting for elements to be present " + locator.toString());
        WebDriverWait wait = new WebDriverWait(getAndroidDriver(), timeOutInSeconds);
        return (AndroidElement) wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    

    /**
     * Wait for element to be present and return it based on the provided locator
     *
     * @param locator
     * @param timeOutInSeconds
     * @return AndroidElement
     */
    public List<WebElement> waitForElementsToBePresent(By locator, int timeOutInSeconds) {
        //ExtentTestManager.getTest().info("Waiting for elements to be present " + locator.toString());
        WebDriverWait wait = new WebDriverWait(getAndroidDriver(), timeOutInSeconds);
        return (List<WebElement>) wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    /**
     * Wait for element to be click able and return it based on the provided locator
     *
     * @param androidElement
     * @param timeOutInSeconds
     * @return AndroidElement
     */
    public AndroidElement waitForElementToBeClickable(AndroidElement androidElement, int timeOutInSeconds) {
        //	ExtentTestManager.getTest().info("Waiting for element to be clickable " + locator.toString());
        WebDriverWait wait = new WebDriverWait(getAndroidDriver(), timeOutInSeconds);
        return (AndroidElement) wait.until(ExpectedConditions.elementToBeClickable(androidElement));
    }
    
    /**
     * Performs click operation on the element provided
     *
     * @param customersBtn
     * @param elementLabel
     */
    public void clickElement(WebElement customersBtn, String elementLabel) {
        ExtentTestManager.getTest().info("Clicking " + elementLabel);
        customersBtn.click();
    }

    public AndroidElement findElement(By locator) {
        return (AndroidElement) getAndroidDriver().findElement(locator);

    }

    public void sendKeysToElement(AndroidElement element, String keys,String elementLabel) {
        ExtentTestManager.getTest().info("Sending keys for "+ elementLabel);
        element.sendKeys(keys);
    }

    public String getElementText(AndroidElement element, String elementLabel) {
        ExtentTestManager.getTest().info("Getting "+elementLabel+ " Text" );
        return element.getText();
    }

    public void scrollToElement(AndroidElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getAndroidDriver();
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "down");
        scrollObject.put("element", ((RemoteWebElement) element).getId());
        js.executeScript("mobile: scroll", scrollObject);
    }

    public void swipeUp() {
        ExtentTestManager.getTest().info("Swiping screen");
        TouchAction action = new TouchAction(getAndroidDriver());
        PointOption p1= new PointOption();
        Dimension dimensions = getAndroidDriver().manage().window().getSize();
        Double screenHeightStart = dimensions.getHeight() * 0.55;
        Double screenWidth = dimensions.getWidth() * .5;
        int width = screenWidth.intValue();
        int h1 = screenHeightStart.intValue();
        Double screenHeightEnd = dimensions.getHeight() * 0.2;
        int h2 = screenHeightEnd.intValue();
        action.press(PointOption.point(width,h1))
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(600)))
                .moveTo(PointOption.point(width, h2))
                .release()
                .perform();

    }

    public String randomString( int len ){
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }

    public String randomNumberString( int len ){
        String AB = "0123456789";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }

    public void longPress(AndroidElement ele, String elementLabel) {

        ExtentTestManager.getTest().info("Long press "+elementLabel );
        new TouchAction(getAndroidDriver())
                .longPress(new LongPressOptions()
                        .withElement(ElementOption.element(ele))
                        .withDuration(Duration.ofMillis(3000)))
                .release()
                .perform();
    }

    public void scrollElement(AndroidElement element) {
        TouchAction action = new TouchAction(getAndroidDriver());
        //action.scroll(element, 10, 20);
        action.perform();
    }
    
    public void SwipeRight (int startx, int startY, int endx) {

    	new TouchAction((PerformsTouchActions) getAndroidDriver())
		.press(PointOption.point(startx, startY))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
		.moveTo(PointOption.point(endx, startY))
		.release().perform();
    }
    	
    
    public void SwipeUp (int startx, int startY, int endy) {

    	new TouchAction((PerformsTouchActions) getAndroidDriver())
		.press(PointOption.point(startx, startY))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
		.moveTo(PointOption.point(startx, endy))
		.release().perform();
    }	
    
}
