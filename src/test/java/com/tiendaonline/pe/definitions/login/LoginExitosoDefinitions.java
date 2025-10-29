package com.tiendaonline.pe.definitions.login;

import com.tiendaonline.pe.step.login.LoginExitosoStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;

public class LoginExitosoDefinitions {

    @Steps
    LoginExitosoStep loginExitosoStep;

    @And("debe visualizarse el nombre del usuario logueado")
    public void debeVisualizarseElNombreDelUsusarioLogueado() {
        loginExitosoStep.verificarUsuarioLogueado();
    }

    @And("hago clic en el boton Delete Account")
    public void clicEnElBotonDeleteAccount() {
        loginExitosoStep.clicEnBotonEliminarCuenta();
    }

    @Then("debe visualizarse el texto para la {string}")
    public void debeVisualizarseElTextoParaLa(String mensajeEsperado) {
        loginExitosoStep.validarMensajeDeUsuarioEliminado(mensajeEsperado);
    }

    @And("hago clic en el boton Login")
    public void hagoClicEnElBotonLogin() {
        loginExitosoStep.clicEnBotonLogin();
    }

    @Then("debe visualizarse el mensaje de error {string}")
    public void debeVisualizarseElMensajeDeError(String mensajeEsperado) {
        loginExitosoStep.validarMensajeDeErrorEnLogin(mensajeEsperado);

    }

    @And("hago clic en el boton Logout")
    public void hagoClicEnElBotonLogout() {
        loginExitosoStep.clicEnBotonCerrarSesion();
    }

    @Then("debe visualizarse la página de inicio de sesión")
    public void debeVisualizarseLaPáginaDeInicioDeSesión() {
        loginExitosoStep.visualizarPaginaInicioSesion();
    }

    @Then("debe visualizarse el mensaje de alerta {string}")
    public void debeVisualizarseElMensajeDeAlerta(String mensajeEsperado) {
        loginExitosoStep.validarMensajeDeErrorDatosExisten(mensajeEsperado);
    }
}
