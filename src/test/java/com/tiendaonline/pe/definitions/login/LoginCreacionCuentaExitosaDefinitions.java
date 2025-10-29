package com.tiendaonline.pe.definitions.login;

import com.tiendaonline.pe.step.login.LoginCreacionCuentaExitosaStep;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Steps;

public class LoginCreacionCuentaExitosaDefinitions {

    @Steps
    LoginCreacionCuentaExitosaStep loginCreacionCuentaExitosaStep;

    @And("debe visualizarse el texto para la nueva {string}")
    public void debeVisualizarseElTextoParaLaNueva(String msjCreacionCuentaEsperado) {
        loginCreacionCuentaExitosaStep.validarMensajeCreacionCuentaExitosa(msjCreacionCuentaEsperado);
    }

    @And("hago clic en el boton Continue")
    public void hagoClicEnElBotonContinue() {
        loginCreacionCuentaExitosaStep.clicEnBotonContinuar();
    }
}
