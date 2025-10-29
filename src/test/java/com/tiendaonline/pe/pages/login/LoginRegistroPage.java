package com.tiendaonline.pe.pages.login;

import com.tiendaonline.pe.util.WebDriverUtils;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginRegistroPage extends PageObject {


    @FindBy(xpath = "//h2[text()='New User Signup!']")
    public WebElementFacade lblMensajeRegistroNuevoUsuario;
    @FindBy(xpath = "//h2[text()='Login to your account']")
    public WebElementFacade lblMensajeLoginCuenta;
    @FindBy(xpath = "//input[@data-qa='signup-name']")
    WebElementFacade txtNombre;
    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElementFacade txtCorreo;
    @FindBy(xpath = "//button[contains(text(),'Signup')]")
    WebElementFacade btnRegistrarme;
    @FindBy(xpath = "//*[contains(text(),'Enter Account Information')]")
    WebElementFacade txtInformacionDeLaCuenta;
    @FindBy(id = "id_gender1")
    WebElementFacade rbnMr;
    @FindBy(id = "id_gender2")
    WebElementFacade rbnMrs;
    @FindBy(id = "password")
    WebElementFacade txtContrasenia;
    @FindBy(id = "days")
    WebElementFacade selectDia;
    @FindBy(id = "months")
    WebElementFacade selectMes;
    @FindBy(id = "years")
    WebElementFacade selectAno;
    @FindBy(id = "newsletter")
    WebElementFacade chkSuscripcionBoletin;
    @FindBy(id = "optin")
    WebElementFacade chkRecibeOfertas;
    @FindBy(id = "first_name")
    WebElementFacade txtNombrePila;
    @FindBy(id = "last_name")
    WebElementFacade txtApellido;
    @FindBy(id = "company")
    WebElementFacade txtEmpresa;
    @FindBy(id = "address1")
    WebElementFacade txtDireccion;
    @FindBy(id = "address2")
    WebElementFacade txtDireccion2;
    @FindBy(id = "country")
    WebElementFacade selectPais;
    @FindBy(id = "state")
    WebElementFacade txtEstado;
    @FindBy(id = "city")
    WebElementFacade txtCiudad;
    @FindBy(id = "zipcode")
    WebElementFacade txtCodigoPostal;
    @FindBy(id = "mobile_number")
    WebElementFacade txtTelefono;
    @FindBy(xpath = "//button[normalize-space()='Create Account']")
    WebElementFacade btnCrearCuenta;
    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElementFacade txtCorreoLogin;
    @FindBy(xpath = "//input[@data-qa='login-password']")
    WebElementFacade txtContraseniaLogin;
    @FindBy(xpath = "//button[@data-qa='login-button']")
    WebElementFacade btnLogin;


    public void visualizarMensajeRegistroNuevoUsuario(String mensajeEsperado , WebElementFacade elemento) {
        if (!elemento.isVisible()) {
            throw new AssertionError("El mensaje esperado '" + mensajeEsperado + "' no está visible");
        }
        if (!elemento.getText().equalsIgnoreCase(mensajeEsperado)) {
            throw new AssertionError(
                    "Se esperaba el mensaje '" + mensajeEsperado + "' pero se encontró '" + elemento.getText() + "'"
            );
        }
    }

    public void ingresarDatosRegistro(String nombre, String correo) {
        txtNombre.type(nombre);
        txtCorreo.type(correo);
    }

    public void ingresarDatosLogin(String email, String contrasenia) {
        txtCorreoLogin.type(email);
        txtContraseniaLogin.type(contrasenia);
    }

    public void clicEnBotonRegistrarme() {
            btnRegistrarme.click();
    }

    public boolean visualizarMensajeInformacionDeLaCuenta(String mensaje) {
        return txtInformacionDeLaCuenta.isDisplayed();
    }

    public void ingresarDatosDeLaCuentaDesdeArchivo(String titulo, String contrasenia, String dia, String mes, String anio) {
        if ("Mr.".equalsIgnoreCase(titulo)) {
            rbnMr.click();
        } else if ("Mrs.".equalsIgnoreCase(titulo)) {
            rbnMrs.click();
        }
        WebDriverUtils.scrollToAndType(getDriver(), txtContrasenia, contrasenia);
        selectDia.selectByVisibleText(dia);
        selectMes.selectByVisibleText(mes);
        selectAno.selectByVisibleText(anio);
    }

    public void seleccionarCasillasSuscripcionYOfertas() {
        if(!chkSuscripcionBoletin.isSelected()) {
            chkSuscripcionBoletin.click();
        }
        if(!chkRecibeOfertas.isSelected()) {
            chkRecibeOfertas.click();
        }
    }

    public void ingresarDatosDeDireccionDesdeArchivo(String nombrepila, String apellido, String empresa,String direccion, String direccion2, String pais, String estado,
                                                     String ciudad,String codigopostal, String telefono){
        txtNombrePila.type(nombrepila);
        txtApellido.type(apellido);
        txtEmpresa.type(empresa);
        txtDireccion.type(direccion);
        txtDireccion2.type(direccion2);
        WebDriverUtils.scrollToElement(getDriver(), selectPais);
        selectPais.selectByVisibleText(pais);
        txtEstado.type(estado);
        txtCiudad.type(ciudad);
        txtCodigoPostal.type(codigopostal);
        txtTelefono.type(telefono);
    }

    public void clicEnBotonCrearCuenta() {
        btnCrearCuenta.click();
    }
}