package org.example.SauceDemo.tests.InventoryPage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import jdk.jfr.Description;
import org.example.SauceDemo.base.BasePage;
import org.example.SauceDemo.base.BaseTest;
import org.example.SauceDemo.pages.ASauceHomePage;
import org.example.SauceDemo.pages.BSauceInventoryPage;
import org.example.SauceDemo.pages.CSauceCartPage;
import org.example.extentreports.ExtentFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public class InventoryPageTest extends BaseTest {
    static BasePage _basePage = new BasePage();
    static ASauceHomePage sauceHomePage= new ASauceHomePage();
    static BSauceInventoryPage sauceInventoryPage= new BSauceInventoryPage();
    static CSauceCartPage sauceCartPage = new CSauceCartPage();
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
    }


    @Test
    @Order(1)
    @Description("Agregar productos al carrito")
    public void A_itemsToCartTest() throws IOException {
        sauceInventoryPage.agregarAlCarrito();
        sauceInventoryPage.irAlCarrito();
        _basePage.pausa();
        condition = (driver.getCurrentUrl().equals("https://www.saucedemo.com/cart.html"));
        _basePage.checkCondition("Add products", condition);
    }


    @Test
    @Order(2)
    @Description("Iniciar chechout")
    public void B_startCheckoutTest() throws IOException {
        String contenido = sauceCartPage.contenidoCarrito();
        System.out.println(contenido);
       condition=(contenido.contains("Bike")&&contenido.contains("T-Shirt"));
       _basePage.checkCondition("Check cart content",condition);
        sauceCartPage.continuarCheckout();
        _basePage.pausa();
        condition = (driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-step-one.html"));
        _basePage.checkCondition("Check checkout url", condition);
    }

}
