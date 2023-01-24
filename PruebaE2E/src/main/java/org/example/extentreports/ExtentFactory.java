package org.example.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ExtentFactory {
	static String pathImage;
	public static ExtentReports getInstance()
	{
		ExtentReports extent = new ExtentReports();
		extent.setSystemInfo("OS", "Windows 11");
		extent.setSystemInfo("Selenium Version", "4.1.4");
		extent.setSystemInfo("JUnit Version", "5.9.1");
		return extent;
	}

	public static ExtentSparkReporter getInstances(){
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("./report.html").viewConfigurer()
				.viewOrder()
				.as(new ViewName[] {
						ViewName.DASHBOARD,
						ViewName.TEST,
						ViewName.CATEGORY,
						ViewName.AUTHOR,
						ViewName.DEVICE,
						ViewName.EXCEPTION,
						ViewName.LOG
				})
				.apply();;
		return extentSparkReporter;
	}


	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = "./TestsScreenshots/" + screenshotName + dateName
				+ ".jpeg";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		pathImage = "./FailedTestsScreenshots/"+screenshotName+ dateName + ".jpeg";
		return destination;
	}

	public static String getPathImage() {
		return pathImage;
	}
}
