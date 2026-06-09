package GenericUtility;

import java.sql.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListernerUtility implements ITestListener,ISuiteListener{
public static ExtentReports report;
public static ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		
		System.out.println("report configuration");
		String time= new Date(0).toString().replace("","_").replace(":","_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("Crm Application");
		spark.config().setReportName("modular name");
		spark.config().setTheme(Theme.STANDARD);
		
		report= new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("browser", "chrome");
		report.setSystemInfo("os", "windows12");
		
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("report backup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO,result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test=report.createTest(result.getMethod().getMethodName());
		test.log(Status.PASS,result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
//		String testame = result.getMethod().getMethodName();
//		TakesScreenshot ts = (TakesScreenshot)driver;
//		String filepath = ts.getScreenshotAs(OutputType.BASE64);
//		String time = new Date(0).toString().replace(" ", "_").replace(":", "_");
//
//		test.addScreenCaptureFromBase64String(filepath,testame+"_"+time);
//		test.log(Status.FAIL,result.getMethod().getMethodName());
//		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test=report.createTest(result.getMethod().getMethodName());
		test.log(Status.SKIP,result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	
	

}
