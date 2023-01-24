package org.example.SauceDemo.pages;

import lombok.Getter;
import org.example.SauceDemo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.SauceDemo.pages.BSauceInventoryPage.basePage;

public class DSauceCheckOutOnePage extends BasePage {

    public static String nombre="Maria";
    public static String apellido="Lopez";
    public static String codigo_postal="1234";

    @Getter
    public static String titulo ="/html/body/div/div/div/div[1]/div[2]/span";
    @Getter
    public static String input_nombre="/html/body/div/div/div/div[2]/div/form/div[1]/div[1]/input";
    @Getter
    public static String input_apellido="/html/body/div/div/div/div[2]/div/form/div[1]/div[2]/input";
    @Getter
    public static String input_postalcode="/html/body/div/div/div/div[2]/div/form/div[1]/div[3]/input";
    @Getter
    public static String boton_continuar="/html/body/div/div/div/div[2]/div/form/div[2]/input";


    public void completarFormulario(){
        basePage.pausa();
        writeText(input_nombre,nombre);
        writeText(input_apellido,apellido);
        writeText(input_postalcode,codigo_postal);
        basePage.pausa();
        WebElement boton = getWebElement(By.xpath(boton_continuar));
        basePage.getJs().executeScript("arguments[0].scrollIntoView();", boton);
        basePage.pausa();
        clickElement(boton_continuar);

    }

}
