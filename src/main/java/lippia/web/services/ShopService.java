package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import lippia.web.constants.AccountConstants;
import lippia.web.constants.LoginConstants;
import lippia.web.constants.RegistrationConstants;
import lippia.web.constants.ShopConstants;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import sun.misc.FloatingDecimal;

public class ShopService extends ActionManager {

    public static void seleccionarProducto() {
        waitClickable(ShopConstants.IMG_PRODPRIMER_XPATH);
        click(ShopConstants.IMG_PRODPRIMER_XPATH);
    }

    public static void verificaPrecio() {
        String precio_carrito = getAttribute(ShopConstants.LABEL_CARTPRICE_XPATH,"innerText").substring(1);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isVisible(ShopConstants.LABEL_CARTPRICE_XPATH), "No se visualiza precio");
        softAssert.assertFalse(precio_carrito.equals("0.0"), "El producto no se agregó al carrito");
        softAssert.assertAll();
    }

    public static void verificaSutotalTotal() {
        waitPresence(ShopConstants.LABEL_SUBTOTAL_XPATH);
        waitPresence(ShopConstants.LABEL_TOTAL_XPATH);

        String subtotalS = getAttribute(ShopConstants.LABEL_SUBTOTAL_XPATH, "innerText").substring(1);
        String totalS    = getAttribute(ShopConstants.LABEL_TOTAL_XPATH, "innerText").substring(1);
        double subtotal = Double.parseDouble(subtotalS.replace(",", ""));
        double total = Double.parseDouble(totalS.replace(",", ""));

        Assert.assertTrue(subtotal<total, "error");
    }

    public static void verificaCheckout() {
        Assert.assertTrue(isVisible(ShopConstants.LABEL_BILLING_XPATH), "No se visualiza detalle de facturacion");
        Assert.assertTrue(isVisible(ShopConstants.LABEL_ADDINFO_XPATH), "No se visualiza detalle de info adicional");
        Assert.assertTrue(isVisible(ShopConstants.LABEL_PEDIDO_XPATH), "No se visualiza detalle de pedido");
    }

    public static void editarDirFacturacion() {
        waitVisibility(AccountConstants.INPUT_NOMBREBILL_ID);
        String sin_direccion = getText(AccountConstants.INPUT_NOMBREBILL_ID);
        System.out.println("La forma de pago seleccionada es inválida");
        if (sin_direccion.equals(" ")) {
           AccountService.editDireccion("Paola", "Prueba", "prueba@automation.com", "2612523258", "India", "Orissa", "India City", "Rajasthan", "1000", "Billing Address");
        }
    }

    public static void setearFormaPago(String forma_pago) {
        //WebElement element = getElement(ShopConstants.LABEL_FORMPAGO1_XPATH);
        //getFluentWait().until(ExpectedConditions.visibilityOf(element));
        waitPresence(ShopConstants.LABEL_FORMPAGO1_XPATH);
        switch (forma_pago) {
            case "Direct Bank Transfer":
                click(ShopConstants.LABEL_FORMPAGO1_XPATH);
                break;
            case "Check Payments":
                click(ShopConstants.LABEL_FORMPAGO2_XPATH);
                break;
            case "Cash on Delivery":
                click(ShopConstants.LABEL_FORMPAGO3_XPATH);
                break;
            case "PayPal Express Checkout":
                click(ShopConstants.LABEL_FORMPAGO4_XPATH);
                break;
             default:
                System.out.println("La forma de pago seleccionada es inválida");
                break;
        }
    }

    public static void verificarOrden() {
        Assert.assertEquals(getText(ShopConstants.LABEL_ORDER_XPATH), "Thank you. Your order has been received.", "No se generó la orden de pedido");
    }

    public static void validarTax(String pais, double porcentaje) {
        waitVisibility(ShopConstants.LABEL_SUBT_XPATH);
        double subtotal = Double.parseDouble(getAttribute(ShopConstants.LABEL_SUBT_XPATH, "innerText").substring(1));
        double impuesto = Double.parseDouble(getAttribute(ShopConstants.LABEL_TAX_XPATH, "innerText").substring(1));
        double calculoTax = (subtotal * porcentaje)/100;

       /* waitVisibility(ShopConstants.LABEL_ROAMINGTAX_XPATH);
        if (pais.equals("India")) {
            Assert.assertEquals(getText(ShopConstants.LABEL_ROAMINGTAX_XPATH),"Tax");
        } else {
            Assert.assertEquals(getText(ShopConstants.LABEL_ROAMINGTAX_XPATH),"Roaming Tax");
        }*/

        Assert.assertEquals(calculoTax, impuesto, "El porcentaje de impuesto aplicado para "+pais+" es incorrecto");
    }

    public static void verificaDescripcion() {
        Assert.assertTrue(isVisible(ShopConstants.LABEL_DESCRIPTION_XPATH), "No se encontró la descripción del producto");

    }

    public static void aplicarDescuento() {
        setInput(ShopConstants.INPUT_CUPON_ID, "1");
        click(ShopConstants.LABEL_FORMPAGO4_XPATH);
    }
}