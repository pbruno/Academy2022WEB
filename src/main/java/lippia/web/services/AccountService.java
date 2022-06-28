package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import lippia.web.constants.AccountConstants;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AccountService extends ActionManager {

    private static void clearElementWithDelete(String locator) {
        WebElement element = getElement(locator);
        getFluentWait().until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

    }

    public static void editDireccion(String nom, String ape, String email, String tel, String pais, String calle, String cdad, String prov, String zip, String tipoDir) {
        switch (tipoDir) {
            case "Billing Address":
                clearElementWithDelete(AccountConstants.INPUT_NOMBREBILL_ID);
                setInput(AccountConstants.INPUT_NOMBREBILL_ID, nom);
                clearElementWithDelete(AccountConstants.INPUT_APELLIDOBILL_ID);
                setInput(AccountConstants.INPUT_APELLIDOBILL_ID, ape);
                clearElementWithDelete(AccountConstants.INPUT_EMAILBILL_ID);
                setInput(AccountConstants.INPUT_EMAILBILL_ID, email);
                clearElementWithDelete(AccountConstants.INPUT_PHONEBILL_ID);
                setInput(AccountConstants.INPUT_PHONEBILL_ID, tel);
               // setInput(AccountConstants.INPUT_PAISBILL_ID, pais);
                clearElementWithDelete(AccountConstants.INPUT_CALLEBILL_ID);
                setInput(AccountConstants.INPUT_CALLEBILL_ID, calle);
                clearElementWithDelete(AccountConstants.INPUT_LOCALIDADBILL_ID);
                setInput(AccountConstants.INPUT_LOCALIDADBILL_ID, cdad);
                //setInput(AccountConstants.INPUT_PROVINCIABILL_ID, prov);
                clearElementWithDelete(AccountConstants.INPUT_ZIPBILL_ID);
                setInput(AccountConstants.INPUT_ZIPBILL_ID, zip);
                break;
            case "Shipping Address":
                clearElementWithDelete(AccountConstants.INPUT_NOMBRESHIP_ID);
                setInput(AccountConstants.INPUT_NOMBRESHIP_ID, nom);
                clearElementWithDelete(AccountConstants.INPUT_APELLIDOSHIP_ID);
                setInput(AccountConstants.INPUT_APELLIDOSHIP_ID, ape);
                //setInput(AccountConstants.INPUT_PAISSHIPSHIP_ID, pais);
                clearElementWithDelete(AccountConstants.INPUT_CALLESHIP_ID);
                setInput(AccountConstants.INPUT_CALLESHIP_ID, calle);
                clearElementWithDelete(AccountConstants.INPUT_LOCALIDADSHIP_ID);
                setInput(AccountConstants.INPUT_LOCALIDADSHIP_ID, cdad);
                //setInput(AccountConstants.INPUT_PROVISEARCH_XPATH, prov);
                clearElementWithDelete(AccountConstants.INPUT_ZIPSHIP_ID);
                setInput(AccountConstants.INPUT_ZIPSHIP_ID, zip);
                break;
            default:
                System.out.println("No se selecciono ninguna opción válida");
                break;
        }
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

    public static void verificarDetalleCuenta() {
        Assert.assertTrue(isVisible(AccountConstants.INPUT_NOMBRE_ID), "No se visualiza detalle");
        Assert.assertTrue(isVisible(AccountConstants.INPUT_NEWPASS_ID), "No se visualiza campos relacionados a contraseña");
    }

}

