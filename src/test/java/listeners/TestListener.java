package listeners;

import java.net.MalformedURLException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utils.AppiumSetup;
import utils.ExtentManager;
import utils.ExtentTestManager;
import utils.LogUtil;
import com.aventstack.extentreports.Status;

public class TestListener implements ITestListener {
	public void onTestStart(ITestResult result) {
		ExtentManager.getReporter();
		LogUtil.getLoggerInstance().info(TestListener.class.getName() + " onTestStart");
	}

	public void onTestSuccess(ITestResult result) {
		ExtentTestManager.getTest().log(Status.PASS, result.getName() + " passed successfully");
		LogUtil.getLoggerInstance().info(TestListener.class.getName() + " onTestSuccess");
		onCompletionOfTest(result);
	}

	public void onTestFailure(ITestResult result) {
		String message = " failed \n\r" + (result.getThrowable() != null ? result.getThrowable().getMessage() : "");
		ExtentTestManager.getTest().log(Status.FAIL, result.getName() + message);
		LogUtil.getLoggerInstance().info(TestListener.class.getName() + " onTestFailure");
		onCompletionOfTest(result);
	}

	public void onTestSkipped(ITestResult result) {
		ExtentTestManager.getTest().log(Status.SKIP, result.getName() + " skipped");
		LogUtil.getLoggerInstance().info(TestListener.class.getName() + " onTestSkipped");
		onCompletionOfTest(result);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		ExtentTestManager.getTest().log(Status.FAIL, result.getName() + " failed but was within success percentage");
		LogUtil.getLoggerInstance().info(TestListener.class.getName() + " onTestFailedButWithinSuccessPercentage");
		onCompletionOfTest(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		String message = " failed due to timeout \n\r" + result.getThrowable() != null ? result.getThrowable().getMessage() : "";
		ExtentTestManager.getTest().log(Status.FAIL, result.getName() + message);
		LogUtil.getLoggerInstance().info(TestListener.class.getName() + " onTestFailedWithTimeout");
		onCompletionOfTest(result);
	}

	public void onStart(ITestContext context) {
		try {
			AppiumSetup.getInstance().setupAppium();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	public void onFinish(ITestContext context) {
		LogUtil.getLoggerInstance().info(TestListener.class.getName() + " onFinish");
		ExtentManager.getReporter().flush();
	}

	private void onCompletionOfTest(ITestResult result) {
		ITestContext ctx = result.getTestContext();
		
	}
}
