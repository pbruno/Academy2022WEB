@Academy @Home
Feature: Home

  Como usuario
  Quiero ver en el home los nuevos ingresos
  Para realizar compras

  Background:
    Given El usuario se encuentra en la web Automation Practice

  @TrabajoFinal
  Scenario Outline: Añadir un nuevo ingreso al carrito
    When el usuario clickea el menú "Shop"
    When el usuario clickea el link "Home"
    Then se visualiza los tres nuevos ingresos
    When el usuario selecciona un nuevo ingreso
    Then el usuario se encuentra en la pagina de descripción del producto
    When el usuario clickea el botón "Add to Basket"
    Then se verifica el precio en el menú
    When el usuario clickea el botón "View Basket"
    Then se verifica que el Subtotal es menor al Total
    When el usuario clickea el botón "Proceed to Checkout"
    Then se visualiza el detalle del pedido, de facturación, información adicional
    When el usuario ingresa datos de facturación
    When el usuario selecciona forma de pago "<pago>"
    When el usuario clickea el link "Click here to enter your code"
    When el usuario ingresa cupón de descuento
    When el usuario clickea el botón "Apply Coupon"
    Then se visualiza el detalle del pedido, de facturación, información adicional

    Examples:
      | pago                 |
      | Direct Bank Transfer |


  @TrabajoFinal
  Scenario Outline: Añadir un item al carrito y finalizar la compra
    When el usuario clickea el menú "Shop"
    When el usuario clickea el link "Home"
    Then se visualiza los tres nuevos ingresos
    When el usuario selecciona un nuevo ingreso
    Then el usuario se encuentra en la pagina de descripción del producto
    When el usuario clickea el botón "Add to Basket"
    Then se verifica el precio en el menú
    When el usuario clickea el botón "View Basket"
    Then se verifica que el Subtotal es menor al Total
    When el usuario clickea el botón "Proceed to Checkout"
    Then se visualiza el detalle del pedido, de facturación, información adicional
    When el usuario ingresa datos de facturación
    When el usuario selecciona forma de pago "<pago>"
    When el usuario clickea el botón "Place Order"
    Then se visualiza el detalle de la orden

    Examples:
      | pago           |
      | Check Payments |