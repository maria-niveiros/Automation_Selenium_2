package org.example.SauceDemo.tests.HomePage;

import jdk.jfr.Description;
import org.example.SauceDemo.base.BasePage;
import org.example.SauceDemo.base.BaseTest;
import org.example.SauceDemo.pages.ASauceHomePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public class HomePageTest extends BaseTest {
    static BasePage _basePage = new BasePage();
    static ASauceHomePage sauceHomePage= new ASauceHomePage();
    private static WebDriver driver;

    private  boolean condition ;

    @BeforeAll
    static void setUp() {
        driver = _basePage.getDriver();
        extent.attachReporter(spark);
        _basePage.openApp();
    }
    @Test
    @Order(1)
    @Description("Open Sauce Page")
    public void openPageTest() throws IOException {
        condition = (driver.getTitle().equals("Swag Labs"));
        _basePage.checkCondition("Check success title", condition);
    }

    @Test
    @Order(2)
    @Description("Login user")
    public void loginTest() throws IOException {
        sauceHomePage.userLogin();
        _basePage.pausa();
        condition = (driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"));
        _basePage.checkCondition("Check success title", condition);
    }
    @AfterAll
    static void close() {
        driver.close();
    }

}
