package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.services.AccountService;
import lippia.web.services.CommonService;
import lippia.web.services.ShopService;

public class ShopSteps extends PageSteps {

    @When("^el usuario clikea el primer producto$")
    public void elUsuarioClikeaEnLaImagenDelProductoProducto() {
        ShopService.seleccionarProducto();
    }

    @Then("^el usuario se encuentra en la pagina de descripción del producto$")
    public void elUsuarioSeEncuentraEnLaPaginaDeDescripciónDelProducto() {
        ShopService.verificaDescripcion();
    }

    @Then("^se verifica el precio en el menú$")
    public void seVisualizaElPrecioEnElMenú() {
        ShopService.verificaPrecio();
    }

    @Then("^se verifica que el Subtotal es menor al Total$")
    public void seVerificaQueElSubtotalEnMenorAlTotal() {
        ShopService.verificaSutotalTotal();
    }

    @Then("^se visualiza el detalle del pedido, de facturación, información adicional$")
    public void seVisualizaElDetalleDelPedidoDeFacturaciónInformaciónAdicional() {
        ShopService.verificaCheckout();
    }

    @When("^el usuario ingresa datos de facturación$")
    public void elUsuarioIngresaDatosDeFacturaciónYPaís() {
        ShopService.editarDirFacturacion();
    }

    @When("^el usuario selecciona forma de pago \"(.*)\"$")
    public void elUsuarioSeleccionaFormaDePagoPago(String forma_pago) {
        ShopService.setearFormaPago(forma_pago);
    }

    @Then("^se visualiza el detalle de la orden$")
    public void seVisualizaElDetalleDeLaOrden() {
        ShopService.verificarOrden();
    }

    @Then("^se verifica que los impuestos aplicados para \"(.*)\" son del % \"(.*)\"$")
    public void seVerificaQueLosImpuestosAplicadosParaPaisSonDelPorcentaje(String pais, double porcentaje) {
        ShopService.validarTax(pais, porcentaje);
    }

    @When("el agrega un libro al carrito de compras")
    public void elAgregaUnLibroAlCarritoDeCompras() {
        CommonService.clickBoton("Add to Basket");
    }

    @When("el usuario clickea la imagen de un libro")
    public void elUsuarioClickeaLaImagenDeUnLibro() {
        ShopService.seleccionarProducto();
    }

    @When("el usuario ingresa cupón de descuento")
    public void elUsuarioIngresaCupónDeDescuento() {
        ShopService.aplicarDescuento();
    }
}
