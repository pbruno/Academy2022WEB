@Academy @Account
Feature: Account

  Como usuario
  Quiero contar con un dashboard de control de mi cuenta
  Para ver pedidos recientes, administrar direcciones de envío y facturación, y editar contraseña y los detalles de la misma

  Background:
    Given el usuario user está logueado en la web Automation Practice

  @TrabajoFinal
  Scenario: Visualizar detalle de la cuenta
    When el usuario clickea el menú "My Account"
    When el usuario clickea el link "Account Details"
    Then se visualiza el detalle de la cuenta y la opción cambiar contraseña

  @TrabajoFinal
  Scenario: Cerrar Sessión exitoso
    When el usuario clickea el menú "My Account"
    When el usuario clickea el link "Logout"
    Then se verifica que la sesión fue cerrada


   Scenario Outline: Editar direcciones de envío y facturación
    When el usuario clickea el menú "My Account"
    When el usuario clickea el link "Address"
    When el usuario clickea el link Edit en "<tipoDir>"
    When el usuario ingresa nombre "<nom>", apellido "<ape>", email "<email>", teléfono "<tel>", país "<pais>", calle "<calle>", ciudad "<cdad>", provincia "<prov>", zip "<zip>" para el tipo "<tipoDir>"
    When el usuario clickea el botón "Save Address"
    Then se muestra mensaje de éxito "Address changed successfully."

    Examples:
      | tipoDir          | nom  | ape  | email        | tel        | pais      | calle | cdad   | prov    | zip  |
      | Billing Address  | Pao  | Bru  | pb@gamil.com | 2612541123 | Argentina | Salta | Agrelo | Mendoza | 5500 |
      | Shipping Address | Ceci | Mona |              |            | Argentina | Jujuy | Maipu  | Mendoza | 5510 |


  Scenario Outline: Cambiar Contraseña exitosamente
    When el usuario clickea el menú "My Account"
    When el usuario clickea el link "Account Details"
    When el usuario ingresa nombre "<nom>", apellido "<ape>", contraseña actual "<actualpwd>", nueva contraseña "<newpwd>", confimación nueva contraseña "<newpwd>"
    And el usuario clickea el botón "Save Changes"
    Then se muestra mensaje de error "Account details changed successfully."
    #se revierte el cambio para repetidas ejecuciones
    When el usuario clickea el link "Account Details"
    When el usuario ingresa nombre "<nom>", apellido "<ape>", contraseña actual "<newpwd>", nueva contraseña "<actualpwd>", confimación nueva contraseña "<actualpwd>"
    And el usuario clickea el botón "Save Changes"
    Then se muestra mensaje de éxito "Account details changed successfully."
    @Ignore
    Examples:
      | nom | ape | actualpwd                                    | newpwd                                       |
      | Pao | Bru | $$$$$$$$$$$$$$!Passw0rdStr0ng!$$$$$$$$$$$$$$ | $$$$$$$$$$$$$$!Passw8rdStr0ng!$$$$$$$$$$$$$$ |


