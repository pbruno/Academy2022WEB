@Academy @Shop
Feature: Shop

  Como usuario
  Quiero cargar productos al carrito
  Para hacer una compra

  @TrabajoFinal
  Scenario Outline: Añadir un único producto al carrito
    Given el usuario <usuario> está logueado en la web Automation Practice
    When el usuario clickea el menú "Shop"
    When el agrega un libro al carrito de compras
    Then se verifica el precio en el menú
    When el usuario clickea el link "View Basket"
    Then se verifica que el Subtotal es menor al Total
    When el usuario clickea el botón "Proceed to Checkout"
    Then se visualiza el detalle del pedido, de facturación, información adicional
    When el usuario ingresa datos de facturación
    When el usuario selecciona forma de pago "<pago>"
    When el usuario clickea el botón "Place Order"
    Then se visualiza el detalle de la orden

    Examples:
      | usuario | pago             |
      | user    | Cash on Delivery |

  @TrabajoFinal
  Scenario Outline: Añadir un item al carrito a través del link del artículo
    Given el usuario <usuario> está logueado en la web Automation Practice
    When el usuario clickea el menú "Shop"
    When el agrega un libro al carrito de compras
    When el usuario clickea el link "View Basket"
    Then se verifica que los impuestos aplicados para "<pais>" son del % "<porcentaje>"

    Examples:
      | usuario       | pais      | porcentaje |
      | userIndia     | India     | 2          |
      | userArgentina | Argentina | 5          |


  Scenario Outline: Añadir un producto al carrito - haciendo click en imagen
    Given el usuario <usuario> está logueado en la web Automation Practice
    When el usuario clickea el menú "Shop"
    When el usuario clickea la imagen de un libro
    Then el usuario se encuentra en la pagina de descripción del producto
    When el usuario clickea el botón "Add to Basket"
    Then se verifica el precio en el menú
    When el usuario clickea el botón "View Basket"
    When el usuario clickea el botón "Proceed to Checkout"
    Then se visualiza el detalle del pedido, de facturación, información adicional
    When el usuario ingresa datos de facturación
    When el usuario selecciona forma de pago "<pago>"
    When el usuario clickea el botón "Place Order"
    Then se visualiza el detalle de la orden

    Examples:
      | usuario | pago                 |
      | user    | Direct Bank Transfer |