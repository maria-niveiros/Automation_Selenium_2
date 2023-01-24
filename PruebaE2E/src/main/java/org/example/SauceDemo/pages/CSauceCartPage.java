package org.example.SauceDemo.pages;

import lombok.Getter;
import org.example.SauceDemo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.example.SauceDemo.pages.BSauceInventoryPage.basePage;

public class CSauceCartPage extends BasePage {

    Actions actions = new Actions(_driver);
    @Getter
    public static String titulo_page="/html/body/div/div/div/div[1]/div[2]/span";
    @Getter
    public static String boton_checkout="/html/body/div/div/div/div[2]/div/div[2]/button[2]";
    @Getter
    public static String nombre_item="/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/a/div";
    @Getter
    public static String nombre_item2="/html/body/div/div/div/div[2]/div/div[1]/div[4]/div[2]/a/div";


    public void continuarCheckout (){
        WebElement boton = getWebElement(By.xpath(boton_checkout));
        System.out.println(boton);
        basePage.getJs().executeScript("arguments[0].scrollIntoView();", boton);
        basePage.pausa();
        clickElement(boton_checkout);

    }

    public String textoTitulo(){
        basePage.pausa();
        WebElement element = getWebElement(By.xpath(titulo_page));
        return element.getText();
    }

    public String contenidoCarrito(){
        basePage.pausa();
        WebElement element = getWebElement(By.xpath(nombre_item));
        WebElement element2 = getWebElement(By.xpath(nombre_item2));
        String contenido= (element.getText())+(element2.getText());
        return contenido;
    }
}
