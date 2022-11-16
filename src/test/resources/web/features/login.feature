@Academy @Login
Feature: Login
  Como usuario
  Quiero poder loguearme en la web Automation Practice
  Para acceder a las opciones que requieran login

  Background:
    Given El usuario se encuentra en la web Automation Practice

  @TrabajoFinal @Paola
  Scenario Outline: Login fallido - Verifica Case Sensitive en Password
    When el usuario clickea el menú "My Account"
    When el usuario ingresa su username <user> y password <pass>
    And el usuario clickea el botón "Login"
    Then se muestra mensaje de error "ERROR: The password you entered for the username <user> is incorrect. Lost your password?"

    Examples:
      | user                  | pass                                         |
      | PRUEBA@AUTOMATION.COM | $$$$$$$$$$$$$$!PASSW0RDSTR0NG!$$$$$$$$$$$$$$ |

  @TrabajoFinal
  Scenario Outline: Login cierre de sesión exitoso al salir de la página
    When el usuario clickea el menú "My Account"
    And el usuario ingresa su username <user> y password <pass>
    And el usuario clickea el botón "Login"
    Then se verifica que ingreso correctamente a la web
    When el usuario clickea el link "Logout"
    When el usuario clickea "Atrás" en el navegador
    Then se verifica que la sesión fue cerrada

    Examples:
      | user                  | pass                                         |
      | prueba@automation.com | $$$$$$$$$$$$$$!Passw0rdStr0ng!$$$$$$$$$$$$$$ |


  Scenario Outline: Login exitoso con credenciales válidas
    When el usuario clickea el menú "My Account"
    And el usuario ingresa su username <user> y password <pass>
    And el usuario clickea el botón "Login"
    Then se verifica que ingreso correctamente a la web

    Examples:
      | user                  | pass                                         |
      | prueba@automation.com | $$$$$$$$$$$$$$!Passw0rdStr0ng!$$$$$$$$$$$$$$ |


  Scenario Outline: Verificación de contraseña enmascarda
    When el usuario clickea el menú "My Account"
    When el usuario ingresa su username  <user> y password <pass>
    Then la contraseña se visualiza enmascarada

    Examples:
      | user                  | pass        |
      | prueba@automation.com | prueba_pass |


  Scenario Outline: El usuario se loguea con credenciales inválidas
    When el usuario clickea el menú "My Account"
    And el usuario ingresa su username <user> y password <pass>
    And el usuario clickea el botón "Login"
    Then se muestra mensaje de error "ERROR: The password you entered for the username <user> is incorrect. Lost your password?"

    Examples:
      | user                  | pass        |
      | prueba@automation.com | prueba-pass |


  @TrabajoFinal @Paola
  Scenario Outline: Login fallido - Prueba para Ceci
    When el usuario clickea el menú "My Account"
    When el usuario ingresa su username <user> y password <pass>
    And el usuario clickea el botón "Login"
    Then se muestra mensaje de error "ERROR: "

    Examples:
      | user                  | pass                                         |
      | PRUEBA@AUTOMATION.COM | $$$$$$$$$$$$$$!PASSW0RDSTR0NG!$$$$$$$$$$$$$$ |