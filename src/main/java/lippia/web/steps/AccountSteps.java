package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.services.AccountService;
import lippia.web.services.CommonService;

public class AccountSteps extends PageSteps {

    @When("^el usuario clickea el link Edit en \"(.*)\"$")
    public void elUsuarioClickeaElLinkEditEn(String tipoDir) {
        CommonService.clickLinkEdit(tipoDir);
    }

    @When("^el usuario ingresa nombre \"(.*)\", apellido \"(.*)\", email \"(.*)\", teléfono \"(.*)\", país \"(.*)\", calle \"(.*)\", ciudad \"(.*)\", provincia \"(.*)\", zip \"(.*)\" para el tipo \"(.*)\"$")
    public void elUsuarioIngresaNombreApellidoEmailTeléfonoPaísCalleCiudadProvinciaZip(String nom, String ape, String email, String tel, String pais, String calle, String cdad, String prov, String zip, String tipoDir) {
        AccountService.editDireccion(nom, ape, email, tel, pais, calle, cdad, prov, zip, tipoDir);

    }

    @When("^el usuario ingresa nombre \"(.*)\", apellido \"(.*)\", contraseña actual \"(.*)\", nueva contraseña \"(.*)\", confimación nueva contraseña \"(.*)\"")
    public void elUsuarioIngresaNombreApellidoContraseñaActualNuevaContraseñaConfimaciónNuevaContraseña(String nom, String ape, String currentpass, String newpass, String newpassconfirm) {
        CommonService.editPassword(nom, ape, currentpass, newpass, newpassconfirm);
    }

    @Then("se verifica que la sesión fue cerrada")
    public void seVerificaQueLaSesiónFueCerrada() {
        CommonService.verificaSesionCerrada();
    }

    @Then("se visualiza el detalle de la cuenta y la opción cambiar contraseña")
    public void seVisualizaElDetalleDeLaCuentaYLaOpciónCambiarContraseña() {
        AccountService.verificarDetalleCuenta();
    }
}
