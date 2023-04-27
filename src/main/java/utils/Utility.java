package utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import utils.ExtentTestManager;
import utils.LogUtil;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.BasicFileReporter;

import io.appium.java_client.android.AndroidDriver;

public class Utility {
	public static String captureWebScreenShot(WebDriver driver, String fileName) throws IOException {
		String destinationPath = null;
		String filePath = null;
		try {
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
			BasicFileReporter reporter = (BasicFileReporter) ExtentTestManager.getTest().getExtent().getStartedReporters().get(0);
			File report = reporter.getFileFile();
			String folder = report.getParent();
			filePath = "screenshot/" + fileName + System.currentTimeMillis() + ".png";
			destinationPath = folder + File.separator +  "screenshot/" + fileName + System.currentTimeMillis() + ".png";
			File destination = new File(destinationPath);
			destinationPath = destination.getAbsolutePath();
			FileUtils.copyFile(src, destination);
		} catch (Exception e) {
			LogUtil.getLoggerInstance().error(e.getMessage(), e);
		}
		return filePath;
	}
	
	public static void attachWebScreenShotToReport(WebDriver driver, String fileName) {
		try {
			String imagePath = captureWebScreenShot(driver, fileName);
			ExtentTestManager.getTest().info("Screen Capture", MediaEntityBuilder.createScreenCaptureFromPath(imagePath).build());
		} catch (Exception e) {
			LogUtil.getLoggerInstance().error("Error while capturing screen", e);
		}

	}
	
	public static String captureAndroidScreenShot(AndroidDriver<?> driver, String fileName) throws IOException {
		String destinationPath = null;
		String filePath = null;
		try {
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
			BasicFileReporter reporter = (BasicFileReporter) ExtentTestManager.getTest().getExtent().getStartedReporters().get(0);
			File report = reporter.getFileFile();
			String folder = report.getParent();
			filePath = "screenshot/" + fileName + System.currentTimeMillis() + ".png";
			destinationPath = folder + File.separator +  "screenshot/" + fileName + System.currentTimeMillis() + ".png";
			File destination = new File(destinationPath);
			destinationPath = destination.getAbsolutePath();
			FileUtils.copyFile(src, destination);
		} catch (Exception e) {
			LogUtil.getLoggerInstance().error(e.getMessage(), e);
		}
		return filePath;
	}
	
	public static void attachAndroidScreenShotToReport(AndroidDriver<?> driver, String fileName) {
		try {
			String imagePath = captureWebScreenShot(driver, fileName);
			ExtentTestManager.getTest().info("Screen Capture", MediaEntityBuilder.createScreenCaptureFromPath(imagePath).build());
		} catch (Exception e) {
			LogUtil.getLoggerInstance().error("Error while capturing screen", e);
		}

	}
	
	
	public static String getCustomerInformationTable(ArrayList<String> label, ArrayList<String> value) {
		StringBuilder builder = new StringBuilder();
		builder.append("<table class='custom-table-localization'>");
		builder.append("<tr>");
		builder.append("<td style='width: 50%;'>Field</td>");
		builder.append("<td style='width: 22%;'>Value</td>");
		builder.append("</tr>");
		for(int i = 0; i < value.size(); i++) {
			builder.append("<tr>");
			builder.append(String.format("<td>%s</td>", label.get(i)));
			builder.append(String.format("<td>%s</td>", value.get(i)));
			builder.append("</tr>");
			
		}
		builder.append("</table>");
		return builder.toString();
	}
	
	public static String getLoggingTable(ArrayList<ArrayList<String>> content) {
		StringBuilder builder = new StringBuilder();
		builder.append("<table class='custom-table'>");
		builder.append("<tr><td>Parameter Name</td><td>Web Values</td><td>Application Values</td><td>Results (Pass / Fail)</td><td>Comments</td></tr>");
		for (ArrayList<String> rowContent : content) {
			builder.append("<tr>");
			for (String cellContent : rowContent) {
				builder.append(String.format("<td>%s</td>", cellContent));
			}
			builder.append("</tr>");
		}

		builder.append("</table>");
		return builder.toString();
	}
	
	public static String getLoggingTable(ArrayList<ArrayList<String>> content, String title, String title_2) {
		StringBuilder builder = new StringBuilder();
		builder.append("<table class='custom-table'>");
		builder.append("<tr><td>Parameter Name</td><td>"+title+"</td><td>"+title_2+"</td><td>Results (Pass / Fail)</td><td>Comments</td></tr>");
		for (ArrayList<String> rowContent : content) {
			builder.append("<tr>");
			for (String cellContent : rowContent) {
				builder.append(String.format("<td>%s</td>", cellContent));
			}
			builder.append("</tr>");
		}

		builder.append("</table>");
		return builder.toString();
	}
}
