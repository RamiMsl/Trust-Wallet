package utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;



public class WebSetup {
	    public static WebSetup instance;
	    public WebDriver driver;

	    public static WebSetup getInstance() {
	        if (instance == null)
	            instance = new WebSetup();
	        return instance;
	    }

	    public WebDriver initDriver() {
	        if (driver == null) {

	            driver = new ChromeDriver();
	            driver.manage().window().maximize();
	            
	        }
	        return driver;
	    }

	    public WebDriver getDriver() {
	        return driver;
	    }
	    
	}
