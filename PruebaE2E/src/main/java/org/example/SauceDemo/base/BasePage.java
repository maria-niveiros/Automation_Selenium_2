package org.example.SauceDemo.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import lombok.Getter;
import org.example.extentreports.ExtentFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

import static org.example.SauceDemo.base.BaseTest.extent;


public class BasePage {
	
	protected static WebDriver _driver;

	protected static final String URL = "https://saucedemo.com";
	@Getter
	JavascriptExecutor js = ((JavascriptExecutor) _driver);

	ExtentReports extentReports;


	
	public BasePage() {
		if (_driver == null) {
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver/chromedriver.exe");
			_driver = new ChromeDriver();
			_driver.manage().window().maximize();
		}
	}


	public void openApp() {
		_driver.get(URL);
	}

	public WebDriver getDriver() {
		return _driver;
	}



	public WebElement getWebElement(By locator) {
		WebElement elem = null;
		try
		{
			elem = _driver.findElement(locator);
		}
		catch(Exception e)
		{
			System.out.println("There is no an Element: " + locator);
			System.out.println("Exception message: " + e);
		}
		return elem;
	}


	public void clickElement(String locator) {
		WebElement element = getWebElement(By.xpath(locator));
		element.click();
	}

	public void writeText(String locator,String text){
		WebElement element = getWebElement(By.xpath(locator));
		element.sendKeys(text);
	}

	public String getText(String locator){
		WebElement element = getWebElement(By.xpath(locator));
		return element.getText();
	}

	public static String getTitle(){
	 return	_driver.getTitle();
	}

	public void checkCondition (String nameTest, Boolean condition) throws IOException {
		ExtentTest test = extent.createTest(nameTest);
		String screenshotPath = ExtentFactory.getScreenshot(_driver,nameTest);
		if (condition) {
			test.pass("Test passed as expected",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}else {
			test.fail("Test failed. See screenshot for details",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}
	public void pausa(){
		Wait wait = new WebDriverWait(_driver, Duration.ofSeconds(2));
	}
}