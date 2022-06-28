package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.ActionManager;
import lippia.web.constants.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import static com.crowdar.core.actions.WebActionManager.navigateTo;


public class CommonService extends ActionManager {

    public static void navegarWeb() {
        navigateTo(PropertyManager.getProperty("web.base.url"));
    }

    public static void volverAtrasNavegador() {
        navigateTo(PropertyManager.getProperty("web.base.url")+"/my-account/");

    }

    public static void  clickMenu(String menu) {
        if (menu.equals("My Account")) {
            click(CommonConstants.BTN_MYACCOUNT_ID);
        } else if (menu.equals("Shop")) {
            click(CommonConstants.BTN_SHOP_ID);
        }
    }

    public static void clickBoton(String boton) {
        switch (boton) {
            case "Register":
                waitClickable(RegistrationConstants.BTN_REGISTRACION_XPATH);
                click(RegistrationConstants.BTN_REGISTRACION_XPATH);
                break;
            case "Login":
                click(LoginConstants.BTN_LOGIN_XPATH);
                break;
            case "Save Address":
                if (isPresent(AccountConstants.BTN_SAVEADDSHIP_XPATH)) {
                    waitClickable(AccountConstants.BTN_SAVEADDSHIP_XPATH);
                    click(AccountConstants.BTN_SAVEADDSHIP_XPATH);
                } else{
                    waitClickable(AccountConstants.BTN_SAVEADDBILL_XPATH);
                    click(AccountConstants.BTN_SAVEADDBILL_XPATH);
                }
                break;
            case "Save Changes":
                waitClickable(AccountConstants.BTN_SAVEPASS_XPATH);
                click(AccountConstants.BTN_SAVEPASS_XPATH);
                break;
            case "Add to Basket":
                if (isPresent(ShopConstants.BTN_ADDBASKET_XPATH)) {
                    waitClickable(ShopConstants.BTN_ADDBASKET_XPATH);
                    click(ShopConstants.BTN_ADDBASKET_XPATH);
                } else
                    if (isPresent(ShopConstants.BTN_ADDBASKET1_XPATH)) {
                    waitClickable(ShopConstants.BTN_ADDBASKET1_XPATH);
                    click(ShopConstants.BTN_ADDBASKET1_XPATH);
                    } else {
                    Assert.assertNotEquals(getText(ShopConstants.LABEL_STOCKARRIVAL_XPATH), "Out of stock", "No hay stock para el libro seleccionado");
                }
                    break;
            case "Proceed to Checkout":
                click(ShopConstants.BTN_PROCEED_XPATH);
                break;
            case "Place Order":
                waitClickable(ShopConstants.BTN_PLACEORDER_XPATH);
                click(ShopConstants.BTN_PLACEORDER_XPATH);
                break;
            case "View Basket":
                waitClickable(ShopConstants.BTN_VIEWCART_XPATH);
                click(ShopConstants.BTN_VIEWCART_XPATH);
                break;
            case "Apply Coupon":
                waitClickable(ShopConstants.BTN_CUPON_XPATH);
                click(ShopConstants.BTN_CUPON_XPATH);
                break;
            default:
                System.out.println("No se presionó botón");
                break;
        }

    }

    public static void verificarMensaje(String mensaje) {
        waitVisibility(CommonConstants.TEXT_MENSAJE_XPATH);
        Assert.assertEquals(getText(CommonConstants.TEXT_MENSAJE_XPATH), mensaje);
   }

    public static void clickLink(String textoLink) {
        switch (textoLink) {
            case "Home":
                click(HomeConstants.LINK_HOME_XPATH, textoLink);
                break;
            case "Logout":
                click(LoginConstants.BTN_LOGOUT_XPATH, textoLink);
                break;
            case "Address":
                waitClickable(AccountConstants.LINK_ADDRESS_XPATH);
                click(AccountConstants.LINK_ADDRESS_XPATH, textoLink);
                break;
            case "Account Details":
                click(AccountConstants.LINK_ACCOUNTDETAILS_XPATH, textoLink);
                break;
            case "View Basket":
                click(ShopConstants.LINK_VIEWBASKET_XPATH, textoLink);
                break;
            case "Click here to enter your code":
                click(ShopConstants.LINK_CUPON_XPATH, textoLink);
                break;
            default:
                System.out.println("No se selecciono ninguna opcion válida");
                break;
        }
    }

    public static void clickLinkEdit(String tipoDir) {
        switch (tipoDir) {
            case "Billing Address":
                click(AccountConstants.LINK_EDITBILL_XPATH, tipoDir);
                break;
            case "Shipping Address":
                click(AccountConstants.LINK_EDITSHIP_XPATH, tipoDir);
                break;
            default:
                System.out.println("No se selecciono ninguna opción válida");
                break;
        }
    }


    private static void clearElementWithDelete(String locator) {
        WebElement element = getElement(locator);
        getFluentWait().until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

    }

    public static void verificarMensajeExito(String mensaje) {
        waitVisibility(AccountConstants.TEXT_ADDRESSCHANGE_XPATH);
        Assert.assertEquals(getText(AccountConstants.TEXT_ADDRESSCHANGE_XPATH), mensaje);
    }

    public static void editPassword(String nom, String ape, String currentpass, String newpass, String newpassconfirm) {
        clearElementWithDelete(AccountConstants.INPUT_NOMBRE_ID);
        setInput(AccountConstants.INPUT_NOMBRE_ID, nom);
        clearElementWithDelete(AccountConstants.INPUT_APELLIDO_ID);
        setInput(AccountConstants.INPUT_APELLIDO_ID, ape);
        clearElementWithDelete(AccountConstants.INPUT_CURRENTPASS_ID);
        setInput(AccountConstants.INPUT_CURRENTPASS_ID, currentpass);
        clearElementWithDelete(AccountConstants.INPUT_NEWPASS_ID);
        setInput(AccountConstants.INPUT_NEWPASS_ID, newpass);
        clearElementWithDelete(AccountConstants.INPUT_NEWPASSCONFIRM_ID);
        setInput(AccountConstants.INPUT_NEWPASSCONFIRM_ID, newpassconfirm);

    }

    public static void verificaSesionCerrada() {
        Assert.assertTrue(isVisible(LoginConstants.BTN_LOGIN_XPATH));
    }

}

