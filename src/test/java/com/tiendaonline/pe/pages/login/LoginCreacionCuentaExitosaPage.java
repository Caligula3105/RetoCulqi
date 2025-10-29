package com.tiendaonline.pe.pages.login;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginCreacionCuentaExitosaPage extends PageObject {

    @FindBy(xpath = "//b[normalize-space()='Account Created!']")
    WebElementFacade lblCuentaCreada;
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElementFacade btnContinuar;

    public boolean validarMensajeCreacionCuentaExitosa(String msjCreacionCuentaEsperado) {
        lblCuentaCreada.waitUntilVisible();
        return lblCuentaCreada.getText().equalsIgnoreCase(msjCreacionCuentaEsperado);
    }

    public void clicEnBotonContinuar() {
        btnContinuar.waitUntilVisible().waitUntilClickable().click();
    }
}