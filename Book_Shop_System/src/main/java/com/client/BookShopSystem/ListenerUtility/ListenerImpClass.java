package com.client.BookShopSystem.ListenerUtility;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.client.BookShopSystem.BaseUtility.UtilityClassObject;

public class ListenerImpClass implements ITestListener, ISuiteListener {
	private ExtentReports report;
	private ExtentTest test;
	private String name;

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onStart(suite);
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("kindredStorie");
		spark.config().setReportName("kindredStorie_Report");
		spark.config().setTheme(Theme.STANDARD);
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", System.getProperty("os.name"));
		report.setSystemInfo("User", System.getProperty("user.name"));

	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onFinish(suite);
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		name = result.getMethod().getMethodName();
		test = report.createTest(name);
		UtilityClassObject.setTest(test);
		UtilityClassObject.getTest().log(Status.INFO, "Test execution Started ");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		UtilityClassObject.getTest().log(Status.PASS, "Test execution Success ");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		UtilityClassObject.getTest().log(Status.FAIL, "Test Failed ");
		TakesScreenshot ts = (TakesScreenshot) UtilityClassObject.getDriver();
		String screenshot = ts.getScreenshotAs(OutputType.BASE64);
		UtilityClassObject.getTest().addScreenCaptureFromBase64String(screenshot, name);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		ITestListener.super.onTestSuccess(result);
		UtilityClassObject.getTest().log(Status.FAIL, "Test execution Failed ");

	}

}
