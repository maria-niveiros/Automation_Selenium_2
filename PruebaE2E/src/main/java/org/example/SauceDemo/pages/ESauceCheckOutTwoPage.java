package org.example.SauceDemo.pages;

import lombok.Getter;
import org.example.SauceDemo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ESauceCheckOutTwoPage extends BasePage {


    static BasePage basePage=new BasePage();
    Actions actions = new Actions(_driver);
    @Getter
    public static String titulo_page="/html/body/div/div/div/div[1]/div[2]/span";
    @Getter
    public static String boton_finish="/html/body/div/div/div/div[2]/div/div[2]/div[8]/button[2]";
    @Getter
    public static String nombre_item="/html/body/div/div/div/div[2]/div/div[1]/div[4]/div[2]/a/div";

    public void continuarCheckout (){
        WebElement boton = getWebElement(By.xpath(boton_finish));
        basePage.getJs().executeScript("arguments[0].scrollIntoView();", boton);
        Wait wait = new WebDriverWait(_driver, Duration.ofSeconds(2));
        clickElement(boton_finish);
    }
}
