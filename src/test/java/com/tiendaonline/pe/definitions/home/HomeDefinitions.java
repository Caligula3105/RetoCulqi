package com.tiendaonline.pe.definitions.home;

import com.tiendaonline.pe.step.home.HomeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class HomeDefinitions {

    @Steps
    HomeStep homeStep;

    @Given("que el navegador está abierto")
    public void queElNavegadorEstaAbierto() {
        homeStep.abrirNavegador();
    }

    @When("navego a la URL {string}")
    public void navegoALaURL(String url) {
        homeStep.navegarAUrl(url);
    }

    @And("la página de inicio debe mostrarse correctamente")
    public void laPáginaDeInicioDebeMostrarseCorrectamente() {
        homeStep.validarPaginaInicio();
    }

    @And("hago clic en el boton Signup o Login")
    public void hagoClicEnElBotonSignupOLogin() {
        homeStep.clicEnRegistroLogin();
    }
}
