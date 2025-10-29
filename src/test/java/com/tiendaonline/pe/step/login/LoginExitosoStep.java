package com.tiendaonline.pe.step.login;

import com.tiendaonline.pe.pages.login.LoginExitosoPage;
import com.tiendaonline.pe.util.GlobalParameters;

public class LoginExitosoStep {

    LoginExitosoPage loginExitosoPage;

    public void verificarUsuarioLogueado() {
        String usuarioLogueado = GlobalParameters.getNombreUsuario();
        loginExitosoPage.verificarUsuarioLogueado(usuarioLogueado);
    }

    public void clicEnBotonEliminarCuenta() {
        loginExitosoPage.clicEnBotonEliminarCuenta();
    }

    public void validarMensajeDeUsuarioEliminado(String mensajeEsperado) {
        boolean visible = loginExitosoPage.validarMensajeDeUsuarioEliminado(mensajeEsperado);
        if (!visible) {
            throw new AssertionError("El mensaje '" + mensajeEsperado + "' no se muestra en la página.");
        }
    }

    public void clicEnBotonLogin() {
        loginExitosoPage.clicEnBotonLogin();
    }

    public void validarMensajeDeErrorEnLogin(String mensajeEsperado) {
        boolean visible = loginExitosoPage.validarMensajeDeErrorEnLogin(mensajeEsperado);
        if (!visible) {
            throw new AssertionError("El mensaje de error '" + mensajeEsperado + "' no se muestra en la página.");
        }
    }

    public void validarMensajeDeErrorDatosExisten(String mensajeEsperado) {
        boolean visible = loginExitosoPage.validarMensajeDeErrorDatosExisten(mensajeEsperado);
        if (!visible) {
            throw new AssertionError("El mensaje de error '" + mensajeEsperado + "' no se muestra en la página.");
        }
    }

    public void clicEnBotonCerrarSesion() {
        loginExitosoPage.clicEnBotonCerrarSesion();
    }

    public void visualizarPaginaInicioSesion() {
        if (!loginExitosoPage.visualizarPaginaInicioSesion()) {
            throw new AssertionError("El texto 'Login to your account' no está visible");
        }
    }
}