package org.example.SauceDemo.pages;

import lombok.Getter;
import org.example.SauceDemo.base.BasePage;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ASauceHomePage extends BasePage {

    @Getter
    public static final String username_input = "/html/body/div/div/div[2]/div[1]/div[1]/div/form/div[1]/input";
    @Getter
    public static final String password_input="/html/body/div/div/div[2]/div[1]/div[1]/div/form/div[2]/input";
    @Getter
    public static final String loginButton= "/html/body/div/div/div[2]/div[1]/div[1]/div/form/input";
    @Getter
    public static final String userName= "standard_user";
    @Getter
    public static final String password="secret_sauce";


    public void userLogin (){
        writeText(username_input,userName);
        writeText(password_input,password);
        Wait wait1 = new WebDriverWait(_driver, Duration.ofSeconds(2));
        clickElement(loginButton);
    }
}
