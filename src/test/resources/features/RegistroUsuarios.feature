@RegistroExitoso
Feature: Registro Usuarios

  Background:
    Given que el navegador está abierto
    When navego a la URL "http://automationexercise.com"
    And la página de inicio debe mostrarse correctamente

  Scenario: Registrar un nuevo usuario y luego eliminarlo
    And hago clic en el boton Signup o Login
    And debe visualizarse la opción "New User Signup!"
    And ingreso los datos del usuario a registrar desde el archivo "data/UsuariosTemporales.csv" para "registrarme"
    And hago clic en el boton Signup
    And debe visualizarse el texto "Enter Account Information"
    And completo los datos de "cuenta" desde el archivo "data/UsuariosTemporales.csv"
    And selecciono las casillas de suscripción a boletines y ofertas especiales
    And completo los datos de "dirección" desde el archivo "data/UsuariosTemporales.csv"
    And hago clic en el boton Create Account
    And debe visualizarse el texto para la nueva "Account Created!"
    And hago clic en el boton Continue
    And debe visualizarse el nombre del usuario logueado
    And hago clic en el boton Delete Account
    Then debe visualizarse el texto para la "Account Deleted!"
    And hago clic en el boton Continue