@LoginExitoso
Feature: Login de usuario

  Background:
    Given que el navegador está abierto
    When navego a la URL "http://automationexercise.com"
    And la página de inicio debe mostrarse correctamente

  Scenario: Usuario inicia sesión con correo y contraseña correctos y elimina su cuenta
      And hago clic en el boton Signup o Login
      And debe visualizarse la opción "Login to your account"
      And ingreso los datos del usuario desde el archivo "data/Usuarios.csv" del tipo "temporal" y estado "activo" para "loguearme"
      And hago clic en el boton Login
      And debe visualizarse el nombre del usuario logueado
      And hago clic en el boton Delete Account
      Then debe visualizarse el texto para la "Account Deleted!"
      And hago clic en el boton Continue

    Scenario: Usuario inicia sesión con correo y contraseña incorrectos
      And hago clic en el boton Signup o Login
      And debe visualizarse la opción "Login to your account"
      And ingreso los datos del usuario desde el archivo "data/Usuarios.csv" del tipo "temporal" y estado "inactivo" para "loguearme"
      And hago clic en el boton Login
      Then debe visualizarse el mensaje de error "Your email or password is incorrect!"

    Scenario: Cerrar sesión de usuario
      And hago clic en el boton Signup o Login
      And debe visualizarse la opción "Login to your account"
      And ingreso los datos del usuario desde el archivo "data/Usuarios.csv" del tipo "permanente" y estado "activo" para "loguearme"
      And hago clic en el boton Login
      And debe visualizarse el nombre del usuario logueado
      And hago clic en el boton Logout
      Then debe visualizarse la página de inicio de sesión

    Scenario: Registrar usuario con correo existente
      And hago clic en el boton Signup o Login
      And debe visualizarse la opción "New User Signup!"
      And ingreso los datos del usuario desde el archivo "data/Usuarios.csv" del tipo "permanente" y estado "activo" para "registrarme"
      And hago clic en el boton Signup
      Then debe visualizarse el mensaje de alerta "Email Address already exist!"