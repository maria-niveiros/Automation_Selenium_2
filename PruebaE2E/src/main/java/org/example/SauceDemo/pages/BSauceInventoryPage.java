package org.example.SauceDemo.pages;

import lombok.Getter;
import org.example.SauceDemo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BSauceInventoryPage extends BasePage {

    static BasePage basePage=new BasePage();
    Actions actions = new Actions(_driver);
    @Getter
    public static final String titulo_item ="/html/body/div/div/div/div[2]/div/div/div/div[6]/div[2]/div[1]/a/div";
    @Getter
    public static final String titulo_page="/html/body/div/div/div/div[1]/div[2]/span";
    @Getter
    public static final String button_bike_light="/html/body/div/div/div/div[2]/div/div/div/div[2]/div[2]/div[2]/button";
    @Getter
    public static final String button_tshirt="/html/body/div/div/div/div[2]/div/div/div/div[6]/div[2]/div[2]/button";
    @Getter
    public static final String icono_carrito="/html/body/div/div/div/div[1]/div[1]/div[3]/a";



    public void agregarAlCarrito(){
        basePage.pausa();
        WebElement firstResult = new WebDriverWait(_driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath(button_bike_light)));
        clickElement(button_bike_light);
        basePage.pausa();
        WebElement boton = getWebElement(By.xpath(button_tshirt));
        basePage.getJs().executeScript("arguments[0].scrollIntoView();", boton);
        basePage.pausa();
        clickElement(button_tshirt);
    }

    public void irAlCarrito(){
        WebElement boton = getWebElement(By.xpath(icono_carrito));
        basePage.getJs().executeScript("arguments[0].scrollIntoView();", boton);
        basePage.pausa();
        clickElement(icono_carrito);
    }
}
