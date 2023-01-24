package org.example.SauceDemo.tests.E2E;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import jdk.jfr.Description;
import org.example.SauceDemo.base.BasePage;
import org.example.SauceDemo.base.BaseTest;
import org.example.SauceDemo.pages.*;
import org.example.extentreports.ExtentFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.IOException;




public class E2ETests extends BaseTest {


    static BasePage _basePage = new BasePage();

    static ASauceHomePage sauceHomePage= new ASauceHomePage();
    static BSauceInventoryPage sauceInventoryPage= new BSauceInventoryPage();
    static CSauceCartPage sauceCartPage = new CSauceCartPage();
    static DSauceCheckOutOnePage sauceCheckOutOnePage = new DSauceCheckOutOnePage();
    static ESauceCheckOutTwoPage sauceCheckOutTwoPage= new ESauceCheckOutTwoPage();
    static FSauceCheckOutCompletePage sauceCheckOutCompletePage= new FSauceCheckOutCompletePage();
    private static WebDriver driver;
    JavascriptExecutor executor = (JavascriptExecutor)driver;
    private  boolean condition ;
    static ExtentSparkReporter spark = ExtentFactory.getInstances();
    static ExtentReports extent = ExtentFactory.getInstance();
    ExtentTest test ;

    @BeforeAll
    static void setUp() {
        driver = _basePage.getDriver();
        extent.attachReporter(spark);
        _basePage.openApp();


    }

    @Test
    @Description("E2E Test")
    public void E2E() throws IOException {
        condition = (driver.getTitle().equals("Swag Labs"));
        _basePage.checkCondition("Check success title", condition);
        sauceHomePage.userLogin();
        _basePage.pausa();
        condition = (driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"));
        _basePage.checkCondition("Check success title", condition);
        sauceInventoryPage.agregarAlCarrito();
        sauceInventoryPage.irAlCarrito();
        _basePage.pausa();
        condition = (driver.getCurrentUrl().equals("https://www.saucedemo.com/cart.html"));
        _basePage.checkCondition("Add products", condition);
        String contenido = sauceCartPage.contenidoCarrito();
        System.out.println(contenido);
        condition=(contenido.contains("Bike")&&contenido.contains("T-Shirt"));
        _basePage.checkCondition("Check cart content",condition);
        sauceCartPage.continuarCheckout();
        _basePage.pausa();
        condition = (driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-step-one.html"));
        _basePage.checkCondition("Check checkout url", condition);
        sauceCheckOutOnePage.completarFormulario();
        condition=(driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-step-two.html"));
        _basePage.checkCondition("check url", condition);
        sauceCheckOutTwoPage.continuarCheckout();
        condition=(driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-complete.html"));
        _basePage.checkCondition("check url", condition);
        String titulo= sauceCheckOutCompletePage.getTitulo();
        condition = titulo.equals("THANK YOU FOR YOUR ORDER");
        _basePage.checkCondition("Check success title", condition);
        _basePage.pausa();
        String texto= sauceCheckOutCompletePage.getTexto();
        condition = texto.equals("Your order has been dispatched, and will arrive just as fast as the pony can get there!");
        _basePage.checkCondition("Check success message", condition);
        _basePage.pausa();
        sauceCheckOutCompletePage.volverAHome();
        condition = driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html");
        _basePage.checkCondition("Check back url", condition);

    }


  @AfterAll
    static void close() {
        driver.close();
    }
}
