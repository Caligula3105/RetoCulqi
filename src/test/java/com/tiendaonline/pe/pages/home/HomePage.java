package com.tiendaonline.pe.pages.home;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class HomePage extends PageObject {

    @FindBy(xpath = "//img[@alt='Website for automation practice']")
    WebElementFacade imgLogo;
    @FindBy(xpath = "//a[contains(@href, 'login')]")
    WebElementFacade btnRegistroLogin;


    public void abrirNavegador() {
        getDriver().manage().window().maximize();
    }

    public void navegarA(String url) {
        getDriver().get(url);
    }

    public void verificarLogoVisible() {
        if (!imgLogo.isVisible()) {
            throw new AssertionError("El logo de la página de inicio no está visible");
        }
    }

    public void clicEnRegistroLogin() {
        btnRegistroLogin.click();
    }
}