package com.tiendaonline.pe.definitions.login;

import com.tiendaonline.pe.step.login.LoginRegistroStep;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Steps;

public class LoginRegistroDefinitions {

    @Steps
    LoginRegistroStep loginRegistroStep;

    @And("debe visualizarse la opción {string}")
    public void debeVisualizarseLaOpción(String mensaje) {
        loginRegistroStep.visualizarMensajeRegistroNuevoUsuario(mensaje);
    }

    @And("hago clic en el boton Signup")
    public void hagoClicEnElBotonSignup() {
        loginRegistroStep.clicEnBotonRegistrarme();
    }

    @And("debe visualizarse el texto {string}")
    public void debeVisualizarseElTexto(String mensaje) {
        loginRegistroStep.visualizarMensajeInformacionDeLaCuenta(mensaje);
    }

    @And("selecciono las casillas de suscripción a boletines y ofertas especiales")
    public void seleccionoLasCasillasDeSuscripciónABoletinesYOfertasEspeciales() {
        loginRegistroStep.seleccionarCasillasSuscripcionYOfertas();
    }

    @And("completo los datos de {string} desde el archivo {string}")
    public void completoLosDatosDeDirecciónDesdeElArchivo(String rutaArchivo,String seccion) {
        loginRegistroStep.ingresarDatosDeDireccionYCuentaDesdeArchivo(rutaArchivo, seccion);
    }

    @And("hago clic en el boton Create Account")
    public void hagoClicEnElBotónCreateAccount() {
        loginRegistroStep.clicEnBotonCrearCuenta();
    }

    @And("ingreso los datos del usuario desde el archivo {string} del tipo {string} y estado {string} para {string}")
    public void ingresoLosDatosDelUsuarioDesdeElArchivoDelTipoYEstadoPara(String rutaArchivo, String tipo, String estado, String accion) {
        loginRegistroStep.ingresarDatosDesdeCSV(rutaArchivo, accion, tipo, estado);
    }

    @And("ingreso los datos del usuario a registrar desde el archivo {string} para {string}")
    public void ingresoLosDatosDelUsuarioARegistrarDesdeElArchivoPara(String rutaArchivo, String accion) {
        loginRegistroStep.ingresarDatosDesdeCSV(rutaArchivo, accion, null, null);
    }
}