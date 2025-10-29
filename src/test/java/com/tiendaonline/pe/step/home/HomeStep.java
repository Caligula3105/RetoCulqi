package com.tiendaonline.pe.step.home;

import com.tiendaonline.pe.pages.home.HomePage;

public class HomeStep {

    HomePage homePage;

    public void abrirNavegador() {
        homePage.abrirNavegador();
    }

    public void navegarAUrl(String url) {
        homePage.navegarA(url);
    }

    public void validarPaginaInicio() {
        homePage.verificarLogoVisible();
    }

    public void clicEnRegistroLogin() {
        homePage.clicEnRegistroLogin();
    }
}
