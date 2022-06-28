package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import lippia.web.constants.*;
import org.testng.asserts.SoftAssert;

public class HomeService extends ActionManager {
    public static void verificaIngresos() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isPresent(HomeConstants.LINK_NEW1_XPATH),"El primer nuevo ingreso no está visible");
        softAssert.assertTrue(isPresent(HomeConstants.LINK_NEW2_XPATH),"El segundo nuevo ingreso no está visible");
        softAssert.assertTrue(isPresent(HomeConstants.LINK_NEW3_XPATH),"El tercer nuevo ingreso no está visible");
        //para ver que no haya mas de tres ingresos
        softAssert.assertFalse(isPresent(HomeConstants.LINK_NEW4_XPATH),"Hay mas de tres ingresos en el home");
        softAssert.assertAll();
    }

   public static void seleccionarIngresos() {
        click(HomeConstants.LINK_NEW1_XPATH);
    }

}

