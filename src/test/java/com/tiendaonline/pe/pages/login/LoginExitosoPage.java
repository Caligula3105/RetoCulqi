package com.tiendaonline.pe.pages.login;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginExitosoPage extends PageObject {


    @FindBy(xpath = "//header//a[contains(., 'Logged in as')]/b")
    WebElementFacade lblUsuarioLogueado;
    @FindBy(xpath = "//a[contains(text(),'Delete Account')]")
    WebElementFacade btnEliminarCuenta;
    @FindBy(css = "h2[data-qa='account-deleted']")
    WebElementFacade lblCuentaEliminada;
    @FindBy(xpath = "//button[text()='Login']")
    WebElementFacade btnLogearme;
    @FindBy(xpath = "//p[contains(text(),'Your email or password is incorrect!')]")
    WebElementFacade lblAlertaDatosIncorrectos;
    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElementFacade btnCerrarSesion;
    @FindBy(xpath = "//h2[contains(text(),'Login to your account')]")
    WebElementFacade txtTituloLogin;
    @FindBy(xpath = "//form[@action='/signup']//p[contains(text(),'Email Address already exist!')]")
    WebElementFacade lblDatosExisten;

    public void verificarUsuarioLogueado(String usuarioLogueado) {
        String textoActual = lblUsuarioLogueado.getText();
        if (!textoActual.equals(usuarioLogueado)) {
            throw new AssertionError(
                    "Se esperaba que el usuario '" + usuarioLogueado + "' estuviera visible, pero se encontró: '" + textoActual + "'"
            );
        }
    }

    public void clicEnBotonEliminarCuenta() {
        btnEliminarCuenta.click();
    }

    public boolean validarMensajeDeUsuarioEliminado(String mensajeEsperado) {
        lblCuentaEliminada.waitUntilVisible();
        return lblCuentaEliminada.getText().equalsIgnoreCase(mensajeEsperado);
    }

    public void clicEnBotonLogin() {
        btnLogearme.click();
    }

    public boolean validarMensajeDeErrorEnLogin(String mensajeEsperado) {
        lblAlertaDatosIncorrectos.waitUntilVisible();
        return lblAlertaDatosIncorrectos.getText().equalsIgnoreCase(mensajeEsperado);
    }

    public boolean validarMensajeDeErrorDatosExisten(String mensajeEsperado) {
        lblDatosExisten.waitUntilVisible();
        return lblDatosExisten.getText().equalsIgnoreCase(mensajeEsperado);
    }

    public void clicEnBotonCerrarSesion() {
        btnCerrarSesion.click();
    }

    public boolean visualizarPaginaInicioSesion() {
        return txtTituloLogin.isDisplayed();
    }
}