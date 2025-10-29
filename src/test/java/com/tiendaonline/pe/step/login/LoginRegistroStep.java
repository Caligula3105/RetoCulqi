package com.tiendaonline.pe.step.login;

import com.tiendaonline.pe.pages.login.LoginRegistroPage;
import com.tiendaonline.pe.util.CsvUtils;
import com.tiendaonline.pe.util.GlobalParameters;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.Map;

public class LoginRegistroStep {

    LoginRegistroPage loginRegistroPage;

    public void visualizarMensajeRegistroNuevoUsuario(String mensajeEsperado) {
        WebElementFacade elemento;
        if (mensajeEsperado.equalsIgnoreCase("New User Signup!")) {
            elemento = loginRegistroPage.lblMensajeRegistroNuevoUsuario;
        } else if (mensajeEsperado.equalsIgnoreCase("Login to your account")) {
            elemento = loginRegistroPage.lblMensajeLoginCuenta;
        } else {
            throw new AssertionError("No se definió un elemento para el mensaje: " + mensajeEsperado);
        }
        loginRegistroPage.visualizarMensajeRegistroNuevoUsuario(mensajeEsperado, elemento);
    }

    public void clicEnBotonRegistrarme() {
        loginRegistroPage.clicEnBotonRegistrarme();
    }

    public void visualizarMensajeInformacionDeLaCuenta(String mensaje) {
        if(!loginRegistroPage.visualizarMensajeInformacionDeLaCuenta(mensaje)) {
            throw new AssertionError("El texto 'Enter Account Information' no está visible");
        }
    }

    public void seleccionarCasillasSuscripcionYOfertas() {
        loginRegistroPage.seleccionarCasillasSuscripcionYOfertas();
    }

    public void ingresarDatosDeDireccionYCuentaDesdeArchivo(String rutaArchivo, String seccion) {
        Map<String, String> datos = CsvUtils.leerCSV(rutaArchivo);
        if (seccion.equalsIgnoreCase("cuenta")) {
            loginRegistroPage.ingresarDatosDeLaCuentaDesdeArchivo(
                    datos.get("titulo"),
                    datos.get("contrasenia"),
                    datos.get("dia"),
                    datos.get("mes"),
                    datos.get("anio")
            );
        } else if (seccion.equalsIgnoreCase("direccion")) {
            loginRegistroPage.ingresarDatosDeDireccionDesdeArchivo(
                    datos.get("nombrepila"),
                    datos.get("apellido"),
                    datos.get("empresa"),
                    datos.get("direccion"),
                    datos.get("direccion2"),
                    datos.get("pais"),
                    datos.get("estado"),
                    datos.get("ciudad"),
                    datos.get("codigopostal"),
                    datos.get("telefono")
            );
        } else {
            throw new IllegalArgumentException("Sección no válida: " + seccion);
        }
    }

    public void clicEnBotonCrearCuenta() {
        loginRegistroPage.clicEnBotonCrearCuenta();
    }

    public void ingresarDatosDesdeCSV(String rutaArchivo, String accion, String tipo, String estado) {
        Map<String, String> datos;
        if (tipo != null && estado != null) {
            datos = CsvUtils.leerCSVPorTipoYEstado(rutaArchivo, tipo, estado);
        } else {
            datos = CsvUtils.leerCSV(rutaArchivo);
        }
        GlobalParameters.setNombreUsuario(datos.get("nombre"));
        if (accion.equalsIgnoreCase("registrarme")) {
            loginRegistroPage.ingresarDatosRegistro(
                    datos.get("nombre"),
                    datos.get("email"));
        } else if (accion.equalsIgnoreCase("loguearme")) {
            loginRegistroPage.ingresarDatosLogin(
                    datos.get("email"),
                    datos.get("contrasenia"));
        } else {
            throw new IllegalArgumentException("Acción no válida: " + accion);
        }
    }
}
