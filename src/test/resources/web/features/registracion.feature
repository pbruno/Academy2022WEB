@Academy @Registracion
Feature: Registración

  Como usuario
  Quiero poder registrame en la web Automation Practice con un user y password
  Para posterior ingreso

  Background:
    Given El usuario se encuentra en la web Automation Practice

  @TrabajoFinal
  Scenario: Registracion fallida - Password vacía
    When el usuario clickea el menú "My Account"
    And el usuario ingresa su email "pruebaRegistracion@gmail.com" y password ""
    And el usuario clickea el botón "Register"
    Then se muestra mensaje de error "Error: Please enter an account password."

  @TrabajoFinal
  Scenario: Registracion fallida - Email vacío y Password vacía
    When el usuario clickea el menú "My Account"
    And el usuario ingresa su email "" y password ""
    And el usuario clickea el botón "Register"
    Then se muestra mensaje de error "Error: Please provide a valid email address."