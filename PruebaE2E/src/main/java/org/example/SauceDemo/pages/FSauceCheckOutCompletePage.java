package org.example.SauceDemo.pages;

import org.example.SauceDemo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FSauceCheckOutCompletePage extends BasePage {
    static BasePage basePage=new BasePage();
    Actions actions = new Actions(_driver);
    public static String tituloOrdenCompleta = "/html/body/div/div/div/div[2]/h2";
    public static String mensajeOrdenCompleta="/html/body/div/div/div/div[2]/div";
    public static String boton_backHome="/html/body/div/div/div/div[2]/button";

    public void volverAHome(){
        Wait wait = new WebDriverWait(_driver, Duration.ofSeconds(2));
        WebElement boton = getWebElement(By.xpath(boton_backHome));
        basePage.getJs().executeScript("arguments[0].scrollIntoView();", boton);

        clickElement(boton_backHome);
    }

    public String getTitulo(){
        basePage.pausa();
        WebElement titulo = getWebElement(By.xpath(tituloOrdenCompleta));
        return titulo.getText();
    }

    public String getTexto(){
        basePage.pausa();
        WebElement texto = getWebElement(By.xpath(mensajeOrdenCompleta));
        return texto.getText();
    }
}
