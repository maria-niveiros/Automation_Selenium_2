package org.example.SauceDemo.tests.FinalCheckoutPage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import jdk.jfr.Description;
import org.example.SauceDemo.base.BasePage;
import org.example.SauceDemo.base.BaseTest;
import org.example.SauceDemo.pages.*;
import org.example.extentreports.ExtentFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class FinalCheckoutTest extends BaseTest {


    static BasePage _basePage = new BasePage();

    static ASauceHomePage sauceHomePage= new ASauceHomePage();
    static BSauceInventoryPage sauceInventoryPage= new BSauceInventoryPage();
    static CSauceCartPage sauceCartPage = new CSauceCartPage();
    static DSauceCheckOutOnePage sauceCheckOutOnePage = new DSauceCheckOutOnePage();
    static ESauceCheckOutTwoPage sauceCheckOutTwoPage= new ESauceCheckOutTwoPage();
    static FSauceCheckOutCompletePage sauceCheckOutCompletePage= new FSauceCheckOutCompletePage();
    private static WebDriver driver;

    private  boolean condition ;
    static ExtentSparkReporter spark = ExtentFactory.getInstances();
    static ExtentReports extent = ExtentFactory.getInstance();
    ExtentTest test ;


    @BeforeAll
    static void setUp() {
        driver = _basePage.getDriver();
        extent.attachReporter(spark);
        _basePage.openApp();
        sauceHomePage.userLogin();
        sauceInventoryPage.agregarAlCarrito();
        sauceInventoryPage.irAlCarrito();
        sauceCartPage.continuarCheckout();
    }

    @Test
    @Order(1)
    @Description("Completar Formulario de checkout")
    public void completeCheckoutFormTest() throws IOException {
        _basePage.pausa();
        sauceCheckOutOnePage.completarFormulario();
        condition=(driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-step-two.html"));
        _basePage.checkCondition("check url", condition);

    }

    @Test
    @Order(2)
    @Description("Terminar el checkout")
    public void finishCheckoutTest() throws IOException {
        _basePage.pausa();
       sauceCheckOutTwoPage.continuarCheckout();
        condition=(driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-complete.html"));
        _basePage.checkCondition("check url", condition);

    }
    @Test
    @Order(3)
    @Description("Validar mensajes")
    public void SuccessMessageTest() throws IOException {
        _basePage.pausa();
        sauceCheckOutCompletePage.getTitulo();
        condition=(sauceCheckOutCompletePage.getTitulo().equals("THANK YOU FOR YOUR ORDER"));
        _basePage.checkCondition("check success title", condition);
        condition=(sauceCheckOutCompletePage.getTexto().equals("Your order has been dispatched, and will arrive just as fast as the pony can get there!"));
        _basePage.checkCondition("check success message", condition);
        sauceCheckOutCompletePage.volverAHome();
        condition=driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html");
        _basePage.checkCondition("check go back home button", condition);
    }




}
