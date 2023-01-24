package org.example.SauceDemo.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.example.extentreports.ExtentFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;


public class BaseTest {

	protected static ExtentSparkReporter spark;
	protected static ExtentReports extent;
	protected ExtentTest test;
	
	private static boolean started = false;
	
	
	@BeforeAll
	public static void setUpBaseTest()
	{

		if (!started)
		{
			extent = ExtentFactory.getInstance();
			spark = ExtentFactory.getInstances();
			extent.attachReporter(spark);
			started = true;
		}
	}
	
	@AfterAll
	public static void tearDownBaseTest()
	{
		extent.flush();
	}

}
