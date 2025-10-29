package com.tiendaonline.pe.step.login;

import com.tiendaonline.pe.pages.login.LoginCreacionCuentaExitosaPage;

public class LoginCreacionCuentaExitosaStep {

    LoginCreacionCuentaExitosaPage loginCreacionCuentaExitosaPage;

    public void validarMensajeCreacionCuentaExitosa(String msjCreacionCuentaEsperado) {
        boolean visible = loginCreacionCuentaExitosaPage.validarMensajeCreacionCuentaExitosa(msjCreacionCuentaEsperado);
        if (!visible) {
            throw new AssertionError("El mensaje '" + msjCreacionCuentaEsperado + "' no se muestra en la página.");
        }
    }

    public void clicEnBotonContinuar() {
        loginCreacionCuentaExitosaPage.clicEnBotonContinuar();
    }
}
